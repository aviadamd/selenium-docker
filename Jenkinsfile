pipeline {
    agent any
    stages {
        stage('Build Jar') {
          steps {
             bat "mvn clean package -DskipTests"
          }
        }
        stage('Build Docker Image') {
          steps {
             bat "docker build -t=5311072/selenium-docker ."
          }
        }
        stage('Push Image To Hub') {
           steps {
               withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'pass', usernameVariable: 'user')]) {
                   bat "docker login --username=${user} --password=${pass}"
                   bat "docker push 5311072/selenium-docker:latest"
                }                           
            }
        }
    }
}