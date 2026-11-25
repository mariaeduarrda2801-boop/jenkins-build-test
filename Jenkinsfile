
pipeline {
    agent any

    environment {
        JAVA_HOME = 'C:\\Program Files\\Eclipse Adoptium\\jdk-21.0.13.10002-hotspot'
    }

    stages {
        stage('Compilar') {
            steps {
                bat '"C:\\Program Files\\Maven\\bin\\mvn.cmd" clean test-compile'
            }
        }

        stage('Executar testes') {
            steps {
                catchError(buildResult: 'UNSTABLE', stageResult: 'UNSTABLE') {
                    bat '"C:\\Program Files\\Maven\\bin\\mvn.cmd" surefire:test'
                }
            }
        }
    }

    post {
        always {
            junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'
        }
    }
}
