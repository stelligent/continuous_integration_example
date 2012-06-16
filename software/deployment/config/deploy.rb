require 'rubygems'
require 'aws-sdk'
load '/usr/share/tomcat6/scripts/config/aws.config'

sdb = AWS::SimpleDB.new
s3 = AWS::S3.new

bucket = s3.buckets["cdbrewery"]
object = bucket.objects["brewery.war"]

set :domain do
  item = sdb.domains["test"].items["parameters"]
  item.attributes["domain"].values[0].to_s
end

set :artifact_bucket do
  item = sdb.domains["test"].items['parameters']
  item.attributes['artifact_bucket'].values[0].to_s
end

set :ip_address do
  item = sdb.domains["test"].items['parameters']
  item.attributes['ip_address'].values[0].to_s
end

set :user,             "ec2-user"
set :use_sudo,         false
set :deploy_to,        "/usr/share/tomcat6/webapps"
set :artifact,         "brewery.war"
set :artifact_url,     "https://s3.amazonaws.com/#{artifact_bucket}/#{artifact}"
set :ssh_options,      { :forward_agent => true }

set :application, domain

role :web, domain
role :app, domain
role :db,  domain, :primary => true

set :deploy_via, :remote_cache

def get_binding
  binding # So that everything can be used in templates generated for the servers
end

def from_template(file)
  require 'erb'
  template = File.read(File.join(File.dirname(__FILE__), "..", file))
  result = ERB.new(template).result(self.get_binding)
end

namespace :deploy do
  
  task :setup do
    run "sudo chown -R tomcat:tomcat #{deploy_to}"
    run "sudo service tomcat6 stop"
  end
  
  task :deploy do
    run "cd #{deploy_to} && sudo rm -rf brewery* && sudo wget #{artifact_url}"
  end

  desc "Restart Application"
  task :restart, :roles => :app do
    run "sudo service tomcat6 restart"
  end
  
  # after "deploy:setup", "deploy:wildtracks_config"
  # after "deploy:wildtracks_config", "deploy:httpd_conf"
  # after "deploy:httpd_conf", "deploy:deploy"
  after "deploy:deploy", "deploy:restart"
end

