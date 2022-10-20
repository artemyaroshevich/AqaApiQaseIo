pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git branch: "${params.BRANCH}", url: 'https://github.com/artemyaroshevich/AqaApiQaseIo'

                // Run Maven on a Unix agent.
                sh "gradle build"

                // To run Maven on a Windows agent, use
                // bat "mvn clean test -Dheadless=${HEADLESS}"
            }

            post {
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
                always {
                    script {
                        allure([
                                includeProperties: false,
                                jdk: '',
                                properties: [],
                                reportBuildPolicy: 'ALWAYS',
                                results: [[path: 'target/allure-results']]
                        ])
                    }
                }
            }
        }
    }
}