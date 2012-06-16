require 'rubygems'
require 'aws-sdk'
load File.expand_path('../../config/aws.config', __FILE__)

stackdomain=ARGV[0]

file = File.open("/tmp/properties", "r")

sdb = AWS::SimpleDB.new
  
AWS::SimpleDB.consistent_reads do
  domain = sdb.domains[stackdomain]
  item = domain.items["parameters"]
  
  file.each_line do|line|
    key,value = line.split '='
    item.attributes.set(
      "#{key}" => "#{value}")
  end
end