def utilityLib(){    
	//loading from the groovy file repository 
    def util = null
    util = fileLoader.load('Demo_pipeline/seed2.groovy');
	
  fileLoader.withGit('hhttps://github.com/smuvw/Demo_pipeline.git', 'master', null, '') {
    util = fileLoader.load('Demo_pipeline/seed2.groovy');
  }

   return util
}

node("master"){
    def  utilb = utilityLib()
    utilb.add
    
    }
