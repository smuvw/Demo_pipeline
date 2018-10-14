def f=readFileFromWorkspace("TestData1.csv")

f.split('\n').each {line ->
  
  def lin =line.split(',')

   println lin[0]
  println lin[1]
    
