node {
    def mavenImage = 'maven:3.9.0'
    stage('Build') {
        def mavenContainer = docker.image(mavenImage).run('-v /root/.m2:/root/.m2')
        try {
            sh(script: 'mvn -B -DskipTests clean package', container: mavenContainer.id)
        } finally {
            mavenContainer.stop()
            mavenContainer.remove(force: true)
        }
    }

    stage('Test') {
        def mavenTestContainer = docker.image(mavenImage).run('-v /root/.m2:/root/.m2')
        try {
            sh(script: 'mvn test', container: mavenTestContainer.id)
            junit 'target/surefire-reports/*.xml'
        } finally {
            mavenTestContainer.stop()
            mavenTestContainer.remove(force: true)
        }
    }
}
