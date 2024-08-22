pipeline {
    agent any

    environment {
        SIGLA = 'MI_SIGLA'
        DEPLOY_ENV = 'dev'
    }

    stages {
        stage('Initialize') {
            steps {
                script {
                    def utils = load "${env.WORKSPACE}/KafkaUtils.groovy"
                    
                    utils.inputParametersCreateKafkaTopic()
                    
                    echo "El nombre del topic generado es: ${env.KAFKA_TOPIC_NAME}"
                }
            }
        }
    }
}
