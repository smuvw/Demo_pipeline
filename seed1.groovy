node(){
   
   stage("Buildjob") {
      
      mavenJob('example-Git') {
   
  
  description("jenkins job for A.com")
  properties {
  githubProjectUrl("http://github.com")
   
    
  }
  
    configure { project ->
        (project / 'authToken').setValue('aykgt456777')
    }
  
  
   configure { project ->
     project / 'buildWrappers' << 'EnvInjectBuildWrapper' {
       
       info {
       propertiesContent('driverConfig=../xmlDriven/online/driverConfig.xml')
    }
     }
      }
  
  
  configure { project ->
     project / 'reporters' << 'hudson.maven.reporters.MavenMailer' {
       
       recipients('vasu@gmail.com')
       perModuleEmail('true')
         }
      }
  
  

 
  publishers {
    logRotator{
      numToKeep(20)
        }
  }
  
  
  
  scm {
        git {
            branches "*/master"
            remote {
                
                url('git@server:account/repo1.git')
               credentials('110e6b6e-7345-436d-8c1c-27c06bcb17b5')
            }
           
        }
    }
  
 
  
  wrappers {
        sauceOnDemand {
           
             
        }
    }
  
  triggers {
   
    snapshotDependencies(true)
    
    genericTrigger {
    
    genericRequestVariables {
    genericRequestVariable {
     key("project")
      regexpFilter("")
      regexpFilter("") //Optional, defaults to empty string
       regexpFilterText("")
   regexpFilterExpression("")
      
    }
      

    genericRequestVariable {
     key("environment")
      regexpFilter("")
      regexpFilter("") //Optional, defaults to empty string
       regexpFilterText("")
   regexpFilterExpression("")
      
    

    }
      
    
    genericRequestVariable {
     key("status")
      regexpFilter("")
      regexpFilter("") //Optional, defaults to empty string
       regexpFilterText("")
   regexpFilterExpression("")
      
    }
      
         
    }
      
   regexpFilterText("\$project\$environment\$status")
   regexpFilterExpression("AllstateCom Staging Sucess")
    
  }
  
  
 
  
 
  }
  
   label('w4')
  
  
  wrappers {
   environmentVariables {
      
    
     propertiesFile("driver")
    }
  }
  
  
  rootPOM('../sub-project/pom.xml')
  goals('-X clean compile exec:exec')
  
 // publishers {
      //extendedEmail {
         //  recipientList('smuvva@gmail.com')
       //  mailer('smuvva@gmail.com',true,true)
          
       // }
//  }
  
  
  publishers {
        publishHtml {
            report('build/test-output') {
                reportName('HTML Report')
            }
        }}
  
  
  
  publishers {
        archiveTestNG('**/target/test-reports/*.xml') {
            escapeTestDescription()
            escapeExceptionMessages(false)
            showFailedBuildsInTrendGraph()
            markBuildAsUnstableOnSkippedTests(false)
            markBuildAsFailureOnFailedConfiguration()
        }
    }



}
      
      
   }
   
   
}
