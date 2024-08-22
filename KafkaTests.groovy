package kafka

class KafkaUtils {

    static void inputParametersCreateKafkaTopic() {
        def kafkaTopicNameInput
        def producto
        def accion
        def alfaNumRegex = /^[a-zA-Z0-9]+$/

        while (true) {
            def message = "📄 Nombre del topic de Kafka\n"
            kafkaTopicNameInput = input(
                id: 'kafkaTopicNameInput',
                message: message,
                ok: 'Continuar',
                parameters: [
                    [
                        $class: 'StringParameterDefinition',
                        description: """\
                                        |El topic se conforma de la siguiente manera: \n 
                                        |  ➡️  topic_${env.SIGLA}_${env.DEPLOY_ENV}_[PRODUCTO]_[ACCION] \n
                                        |
                                        |  Por Ejemplo: topic_${env.SIGLA}_${env.DEPLOY_ENV}_cuenta_movimiento
                                        |
                                        |Debe proporcionar un nombre de PRODUCTO y de ACCION.
                                        |
                                        |Ingrese el PRODUCTO: """.stripMargin(),
                        name: 'PRODUCTO',],
                        [$class: 'StringParameterDefinition', description: "Ingrese la ACCION: ", name: 'ACCION']
                ]
            )

            producto = kafkaTopicNameInput['PRODUCTO']
            accion = kafkaTopicNameInput['ACCION']

            if (producto =~ alfaNumRegex && accion =~ alfaNumRegex) {
                break
            } else {
                echo "⚠️  Producto y Acción deben ser alfanuméricos. Por favor, inténtelo de nuevo."
            }
        }

        env.KAFKA_TOPIC_NAME = "${producto.toLowerCase()}_${accion.toLowerCase()}"
    }
}
