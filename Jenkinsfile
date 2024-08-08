pipeline {
    agent any
    options {
        // Timeout counter starts AFTER agent is allocated
        timeout(time: 1, unit: 'SECONDS')
    }
    stages {
        stage('Test'){
            steps {
                echo 'Testing !!'
                script {
                    env.PATH = "C:\\Windows\\System32;C:\\Users\\satyajit_barman\\Server\\apache-maven-3.9.8\\bin"
                }
                bat 'mvn test -Denv=qa -Dbrowser=chrome'
            }
        }
        stage('Archive'){
            steps {
                archiveArtifacts artifacts: 'target/surefire-reports/TEST*.xml', followSymlinks: false
            }
        }
        stage('Report'){
            steps {
                publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'target/cucumber-report', reportFiles: 'report.html', reportName: 'HTML Report', reportTitles: '', useWrapperFileDirectly: true])
            }
        }
        stage('Notify'){
            steps {
                emailext body: '''Hi,

                Please find the current pipeline execution report.
                Job ${env.JOB_NAME} - ${env.BUILD_NUMBER}

                Thanks,
                Pipeline''',
                subject: 'Build Information - Job ${env.JOB_NAME} - ${env.BUILD_NUMBER}',
                to: 'satyajit_barman@epam.com'
            }
        }
    }
}

