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
                bat "docker build -t=aviad/selenium-docker-project ."
            }
        }
        stage('Push Image') {
           steps {
               withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'pass', usernameVariable: 'user')]) {
                   bat "docker login --username=${user} --password=${pass}"
                   bat "docker push aviad/selenium-docker-project"
                }                           
            }
        }
    }
}