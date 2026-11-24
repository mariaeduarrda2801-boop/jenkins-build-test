
pipeline {
    agent any

    environment {
        JAVA_HOME = 'C:\\Program Files\\Eclipse Adoptium\\jdk-21.0.13.10002-hotspot'
    }

    stages {
        stage('Compilar e testar') {
            steps {
                bat '"C:\\Program Files\\Maven\\bin\\mvn.cmd" clean test'
            }
        }
    }

    post {
        always {
            junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'
        }
    }
}

