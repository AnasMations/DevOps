pipeline {
    agent any

    stages {
        stage('Build Image') {
            steps {
                script {
                    docker.build('anasmations/nodejs-web-app:latest')
                }
            }
        }

        stage('Test Container') {
            steps {
                script {
                    docker.image('anasmations/nodejs-web-app:latest').inside {
                        sh 'echo "Test Container success!"'
                    }
                }
            }
        }

        stage('Push to DockerHub') {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'dockerhub-credentials') {
                        docker.image('anasmations/nodejs-web-app:latest').push()
                    }
                }
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                script {
                    // Use kubectl commands to deploy to Kubernetes
                    sh 'kubectl apply -f kubernetes-deployment.yaml'
                }
            }
        }
    }
}
