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
                    String resultado = "estado=success\nmessage=mimensaje"
                    def properties = readProperties text: resultado
                    println(properties['estado'])  
                    println(properties['message']) 
                }
            }
        }
    }
}
