require 'rubygems'
require 'aws-sdk'
load File.expand_path('../../config/aws.config', __FILE__)

stackdomain=ARGV[0]

sdb = AWS::SimpleDB.new
  
AWS::SimpleDB.consistent_reads do
  domain = sdb.domains.create("#{stackdomain}")
end