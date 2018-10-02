mavenJob('example-git') {
   
  
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
  
  
  wrappers {
    environmentVariables {
      
    
      propertiesFile("driver")
    }
  }
  
  
  rootPOM('../sub-project/pom.xml')
  goals('-X clean compile exec:exec')
  
  publishers {
     //   extendedEmail {
           //recipientList('smuvva@gmail.com')
          mailer('smuvva@gmail.com',true,true)
          
       // }
  }
  
  
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
