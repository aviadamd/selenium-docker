pipeline {
    agent any
    stages {
        stage("Wait For Tests") {
            steps { 
                timeout(time: 3, unit: 'SECONDS') {
                    retry(2) {
                       echo "wait for test"
                    }   
                }
            }    
        }
        stage('Build Jar') {
            steps {
                bat "mvn clean package -DskipTests"
            }
        }
        stage('Build Image') {
            steps {
                bat "docker build -t=5311072/selenium-docker ."
            }
        }
        stage('Push Image') {
           steps {
               withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'pass', usernameVariable: 'user')]) {
                   bat "docker login --username=${user} --password=${pass}"
                   bat "docker push 5311072/selenium-docker:latest"
                }                           
            }
        }
    }
}