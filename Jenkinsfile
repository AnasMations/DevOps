pipeline {
    agent any
    tools{
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
                    // Ensure that Maven is using the correct JAVA_HOME
                    def mvnHome = tool 'Maven3'
                    sh "${mvnHome}/bin/mvn clean install"
                }
            }
        }
        
        stage('Build Image') {
            steps {
                script {
                    docker.build('anasmations/nodejs-web-app:latest')
                }
            }
        }


        stage('Push to DockerHub') {
            steps {
                script {
                    withCredentials([string(credentialsId: 'dockerhubpwd', variable: 'dockerhubpwd')]) {
                    sh 'docker login -u anasmations -p ${dockerhubpwd}'

                    }
                    sh 'docker push anasmations/nodejs-web-app:latest'
                }
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                  script{
                    withCredentials([string(credentialsId: 'dockerhubpwd', variable: 'dockerhubpwd')]) {
                    sh 'docker login -u anasmations -p ${dockerhubpwd}'

                    }
                    sh 'docker push anasmations/nodejs-web-app:latest'

                }
                script{kubernetesDeploy (configs: 'deploymentservice.yml',  kubeconfigId: 'k8sconfigpwd')}
            }
        }
    }
}
