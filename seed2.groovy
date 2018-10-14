
parms=null
lin[0]=null
lin[1]=null

def readfileinfo(){
  parms=readFile("TestData1.csv").split('\n').each {line ->
  
  def lin =line.split(',')

        echo lin[0]
  echo lin[1]
      
 }

def add() {
 println "welcome Add"
}
//return this;
def sub() {
 println "welcome sub"
}


def readExcel(){
}
return this;
