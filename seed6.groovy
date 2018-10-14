


parms=null
  def parms=readFile("TestData1.csv").split('\n').each {line ->
  
  def lin =line.split(',')

        echo lin[0]
  echo lin[1]
    
  mavenJob(lin[0]) {
   
  
  description(lin[1])
  properties {
  githubProjectUrl("http://github.com")
   
    
  }
 
 }
 
 
 
 }
