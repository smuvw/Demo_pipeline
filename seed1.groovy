pipeline {
    agent any 
    stages {
        stage('Build') { 
            steps {
                // 
                echo "welcome"
            }
        }
        stage('Test') { 
            steps {
                 echo "welcome"
            }
        }
        stage('Deploy') { 
            steps {
                echo "welcome"
            }
        }
    }
}
