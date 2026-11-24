
pipeline {
    agent any

    stages {
        stage('Compilar e testar') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
    }
}
