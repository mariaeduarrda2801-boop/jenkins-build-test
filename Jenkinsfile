
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

        stage('Executar testes e cobertura') {
            steps {
                catchError(buildResult: 'UNSTABLE', stageResult: 'UNSTABLE') {
                    bat '"C:\\Program Files\\Maven\\bin\\mvn.cmd" verify'
                    
                    script {
                        def linhas = readFile('target/site/jacoco/jacoco.csv').readLines()
                        def perdidas = 0
                        def cobertas = 0

                        linhas.drop(1).each { linha ->
                            def colunas = linha.split(',')
                            perdidas += colunas[3].toInteger()
                            cobertas += colunas[4].toInteger()
                        }

                        def total = perdidas + cobertas
                        def percentual = total == 0 ? 0 : cobertas * 100.0 / total

                        echo "COBERTURA DE CODIGO: ${String.format('%.2f', percentual)}%"
                    }
                }
            }
        }
    }

    post {
        always {
            junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'
            archiveArtifacts artifacts: 'target/site/jacoco/**', allowEmptyArchive: true
        }
    }
}
