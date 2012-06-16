require 'raven'
require 'rake/clean'

task 'default' => 'brewery.war'

dependency 'deps' do |t|
  t.libs = Dir.glob('lib/**/*.*')  
end 

javac 'compile' => 'deps' do |t|
  printf 'in the COMPILE task'
  t.build_path << "src"
end

lib_dir 'prepare_lib' do |t|
  CLEAN.include('*/target')
  FileUtils.rm_r Dir.glob('target/**/*.*'), :force => true
  t.target = 'dist/lib'
end

war 'brewery.war' => ['clean', 'compile', 'java-doc'] do |t|
    t.webapp_dir = "src/web"   
end

javadoc 'java-doc' => 'deps' do |t|
  t.build_path << "src"
end

junit 'test' => ['compile', 'deps'] do |t|
  t.build_path << 'tests'
end