node {
    def mavenImage = 'maven:3.9.0'

    stage('Build and Test') {
        def mavenContainer = docker.image(mavenImage).run('-v /root/.m2:/root/.m2')

        def mavenHome = mavenContainer.inside {
            sh 'echo $M2_HOME' 
        }.trim()

        try {
            sh "export PATH=${mavenHome}/bin:\$PATH && mvn -B -DskipTests clean package"
        } finally {
            mavenContainer.stop()
            mavenContainer.remove(force: true)
        }
    }

    stage('Test') {
        def mavenTestContainer = docker.image(mavenImage).run('-v /root/.m2:/root/.m2')

        def mavenTestHome = mavenTestContainer.inside {
            sh 'echo $M2_HOME' 
        }.trim()

        try {
            sh "export PATH=${mavenTestHome}/bin:\$PATH && mvn test"

            junit 'target/surefire-reports/*.xml'
        } finally {
            mavenTestContainer.stop()
            mavenTestContainer.remove(force: true)
        }
    }
}
