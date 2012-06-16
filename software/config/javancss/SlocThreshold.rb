require "rexml/document"


module SlocThreshold
  # 
  #
  class JavaSlocThreshold		
    
    attr_reader :object_ncss_max
    
    def initialize(file)
      @file = file
      @doc = get_document(file)      
      @object_ncss_max = []
      #parse is private		
      parse()			
    end	
    
    def get_document(file)
      return REXML::Document.new(File.open(file))
    end
    
    def parse()		

      object_ncss = []		
      @doc.elements.each("javancss/objects/child::node()") { | object_elm |        
        if object_elm.name == "object"					
          object_elm.elements.each("child::node()"){ | ccn_elms |			    					
            if ccn_elms.name == "ncss" 
              object_ncss << ccn_elms.text.to_i
            end #end if		            
          }
        end #end if						
      }     
      
     
      object_ncss.each { |object|
        @object_ncss_max << object if(object >= 300)
      }       
     
      end#end parse def
      
      private :parse		
      
      end#end class	
      end#end module
      
      if $0 == __FILE__
        ncss_file = ARGV[0]        
        puts "using the following ncss file " + ncss_file        
        reader = SlocThreshold::JavaSlocThreshold.new(ncss_file)        
        puts "   number of classes with LOC greater than 300: " + reader.object_ncss_max.size.to_s        
      end
      
