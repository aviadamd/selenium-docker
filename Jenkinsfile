pipeline {
    agent any
    stages {
        stage('Build Jar') {
            steps {
                //bat - windows
                //sh - mac
                bat "mvn clean package -DskipTests"
            }
        }
        stage('Build Image') {
            steps {
                bat "docker build -t=selenium-docker-project ."
            }
        }
        stage('Push Image') {
           steps {
               withCredentials([usernamePassword(credentialsId: '5311072', passwordVariable: '5311072', usernameVariable: '5311072')]) {
                   bat "docker login --username=${user} --password=${pass}"
                   bat "docker push selenium-docker-project:latest"
                }                           
            }
        }
    }
}