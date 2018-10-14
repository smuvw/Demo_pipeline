parms=null
pipeline{
agent any
stages{

      stage('clean up builds') {
       steps {
        dir('notify') {
        deleteDir()
        }
         }
      }

 stage('read') {
 steps {
 script {
 
  parms=readFile("TestData1.csv").split('\n).each {line ->
  
  def lin =line.split(',')
  echo lin[0]
  echo lin[1]
    
  
 
 }
 
 
 
 }
 }
}
}

}
 

}
