require 'rubygems'
require 'aws-sdk'
load File.expand_path('../../aws.config', __FILE__)

stackdomain=ARGV[0]
key=ARGV[1]

sdb = AWS::SimpleDB.new
  
AWS::SimpleDB.consistent_reads do
  domain = sdb.domains["#{stackdomain}"]
  item = domain.items["parameters"]
  
  item.attributes.each_value do |name, value|
    if name == "#{key}"
      puts "#{value}"
    end
  end
end