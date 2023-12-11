node {
    // Define the Maven image
    def mavenImage = 'maven:3.9.2-eclipse-temurin-11'

    // Run Docker container with Maven image
    def mavenContainer = docker.image(mavenImage).run('-v /root/.m2:/root/.m2')

    try {
        // Build stage
        stage('Build') {
            // Run Maven build
            sh 'mvn -B -DskipTests clean package'
        }

        // Test stage
        stage('Test') {
            // Run Maven tests
            sh 'mvn test'

            // Publish JUnit test results
            junit 'target/surefire-reports/*.xml'
        }
    } finally {
        // Stop and remove the Docker container
        mavenContainer.stop()
        mavenContainer.remove(force: true)
    }
}
