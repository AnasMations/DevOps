pipeline {
    agent any
    tools {
        jdk 'OpenJDK8'
        maven 'Maven3'
    }
    
    environment {
        JAVA_HOME = "${tool 'OpenJDK8'}"
        PATH = "${JAVA_HOME}/bin:${env.PATH}"
    }
    
    stages {
        stage('SCM') {
            steps {
                git branch: 'main', changelog: false, poll: false, url: 'https://github.com/anasmations/DevOps.git'
            }
        }
        
    stage('Maven Build') {
        steps {
            script {
                def mvnHome = tool 'Maven3'
                sh "${mvnHome}/bin/mvn clean install"
            }
        }
    }
        
    stage('Build Image') {
        steps{
            script{
                sh 'docker build -t anasmations/nodejs-web-app:latest .'
            }
        }
    }

    stage('Push to DockerHub') {
        steps {
            script {
                // Push Docker image to DockerHub
                withCredentials([string(credentialsId: 'dockerhubpwd', variable: 'dockerhubpwd')]) {
                    sh 'docker login -u anasmations -p ${dockerhubpwd}'
                }
                sh 'docker push anasmations/nodejs-web-app:latest'
            }
        }
    }

        stage('Deploy to Kubernetes') {
            steps {
                script {
                    // Deploy to Kubernetes
                    withKubeConfig([credentialsId: 'k8sconfigpwd', serverUrl: 'https://your-kubernetes-api-server']) {
                        sh 'kubectl apply -f deploy.yml'
                    }
                }
            }
        }
    }
}
