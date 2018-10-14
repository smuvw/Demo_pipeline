def f=readFileFromWorkspace("TestData1.csv")

f.split('\n').each {line ->
  
  def lin =line.split(',')

   println lin[0]
  println lin[1]
  println lin[2]
  
  def jobname=lin[0]
   

mavenJob(lin[0]) {
   
  
  description(jobname)
  properties {
  githubProjectUrl("http://github.com")
       
  }
  
  
  configure { project ->
        (project / 'authToken').setValue(lin[2])
    }
  
}
}
