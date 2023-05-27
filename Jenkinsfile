pipeline {
    agent any
    stages {
        stage("Clean Workspace") {
            steps {
                echo "Clean Workspace"
                cleanWs()
            }
        }
        stage("Checkout") {
            steps {
                echo "Checkout repository"
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/RaffaelIoannone/zhaw-devops-devops-demo']]])
            }
        }
        stage("Build") {
            steps {
                sh './backend/gradlew -p backend test'
                nodejs('NodeJS 18.12.1') {
                    sh '''npm install --prefix frontend
                          npm run build --prefix frontend'''
                }
            }
        }
    }
    post {
        always {
            junit '**/test-results/test/*.xml'
            jacoco()
        }
        success {
            echo "Build succeeded!"
        }
        failure {
            echo "Build failed!"
        }
    }
}