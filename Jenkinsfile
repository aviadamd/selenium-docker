pipeline {
    // master executor should be set to 0 excuturs
    agent any
    stages {
        stage('Build Jar With mvn clean package -DskipTests') {
            steps {
                //sh
                bat "mvn clean package -DskipTests"
            }
        }
        stage('Build Image With docker build -t=selenium-docker-project .') {
            steps {
                //bat
                //sh
                bat "docker build -t=selenium-docker-project ."
            }
        }
        stage('Push Image To Docker Hub') {
            steps {
			    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'pass', usernameVariable: 'user')]) {
                    //sh
			        bat "docker login --username=${user} --password=${pass}"
			        bat "docker push selenium-docker:latest"
			    }                           
            }
        }
    }
}