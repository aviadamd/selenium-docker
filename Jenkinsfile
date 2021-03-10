pipeline {
    agent any
    stages {
        stage('Build Jar') {
            steps {
                //bat
                //sh
                bat "mvn clean package -DskipTests"
            }
        }
        stage('Build Image') {
            steps {
                //bat
                //sh
                bat "docker build -t=selenium-docker-project ."
            }
        }
        stage('Push Image') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'pass', usernameVariable: 'user')]) {
                    //bat
                    //sh
                    bat "docker login --username=${user} --password=${pass}"
                    bat "docker push selenium-docker-project:latest"
                }                           
            }
        }
    }
}