require "rexml/document"

module CodeDupParse
  # 
  #
  class CodeDupReader		
    
    attr_reader :total_rawline, :total_dup, :dup_percent, :percent_num
    
    def initialize(file)
      @file = file
      @doc = get_document(file)
      #parse is private		
      parse()			
    end	
    
    def get_document(file)
      return REXML::Document.new(File.open(file))
    end
    
    def parse()		                        
      @doc.elements.each("simian/check/summary") { | pelm |          
          value = pelm.attributes['totalRawLineCount']
	  @total_rawline = value.to_i 
	  value = pelm.attributes['duplicateLineCount']
  	  @total_dup = value.to_i 
	  @percent_num = ((total_dup.to_f / total_rawline.to_f) * 100).to_i	  
    }
      
    end#end parse def
      
      private :parse      
      end#end class	
      end#end module
      
      if $0 == __FILE__
        dup_file = ARGV[0]        
        reader = CodeDupParse::CodeDupReader.new(dup_file)        
	puts "There is " + reader.percent_num.to_s + " percent code duplication"	
	if reader.percent_num.to_i > ARGV[1].to_i
	  puts "Code Duplication Threshold Exceeded!!!"
	  f = File.new(ARGV[2].to_s,  "w+")
	end
      end
