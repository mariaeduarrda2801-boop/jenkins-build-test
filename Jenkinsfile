
pipeline {
    agent any

    environment {
        JAVA_HOME = 'C:\\Program Files\\Eclipse Adoptium\\jdk-21.0.13.10002-hotspot'
        PATH+MAVEN = 'C:\\Program Files\\Maven\\bin'
    }

    stages {
        stage('Compilar e testar') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {
        always {
            junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'
        }
    }
}

