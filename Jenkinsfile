pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh './mvnw compile'
            }
        }
        stage('Test') {
            steps {
                sh './mvnw test'
            }
        }
        post {
            always {
                junit '**/target/*.xml'
            }
            failure {
                mail to: camilo.tiago@gmail.com, subject: 'Game Timeline - Pipeline failed'
            }
        }
    }
}