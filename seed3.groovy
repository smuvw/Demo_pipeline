def utilityLib(){    
	//loading from the groovy file repository 
    def util = null
    util = fileLoader.load('seed2.groovy');

   return util
}

node("master"){
    def  utilb = utilityLib()
    utilb.add
    
    }
