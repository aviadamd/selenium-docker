pipeline {
    agent any
    stages {
        stage("Wait For Jars Build") {
            steps { 
                timeout(time: 3, unit: 'SECONDS') {
                    retry(1) {
                       echo "wait for build jar"
                    }   
                }
            }    
        }
        stage('Build Jar') {
            steps {
                bat "mvn clean package -DskipTests"
            }
        }
        stage("Wait For Docker Build Image") {
                    steps {
                        timeout(time: 3, unit: 'SECONDS') {
                            retry(1) {
                               echo "wait for docker build image"
                            }
                        }
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
        stage('Run Sanity Tests') {
            steps {
                bat "mvn clean install"
            }
        }
    }
}