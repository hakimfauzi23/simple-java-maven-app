node {
    def mavenImage = 'maven:3.9.0'

    // Run Maven build inside Docker container
    stage('Build') {
        // Start the Maven Docker container
        def mavenContainer = docker.image(mavenImage).run('-v /root/.m2:/root/.m2')

        // Run Maven build inside the container
        sh 'mvn -B -DskipTests clean package'

        // Stop and remove the Maven Docker container
        mavenContainer.stop()
        mavenContainer.remove(force: true)
    }
}
