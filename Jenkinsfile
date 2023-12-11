node {
    stage('Build') {
        docker.image('maven:3.9.0').withRun('-v /root/.m2:/root/.m2') {
            sh 'mvn -B -DskipTests clean package'
        }
    }

    stage('Test') {
        docker.image('maven:3.9.0').withRun('-v /root/.m2:/root/.m2') {
            sh 'mvn test'
        }

        junit 'target/surefire-reports/*.xml'
    }
}
