node {
    checkout scm
    docker.image('maven:3.9.2-eclipse-temurin-11').inside('-v /root/.m2:/root/.m2') {
        stage('Build') {
            sh 'mvn --version'
            sh 'mvn -B -DskipTests clean package'
        }
        stage('Test') {
            sh 'mvn test'
            junit 'target/surefire-reports/*.xml'
        }
        stage('Deploy'){
            sh './jenkins/scripts/deliver.sh'
            input message: 'Sudah selesai menggunakan React App? (Klik "Proceed" untuk mengakhiri)'
            sh './jenkins/scripts/kill.sh'
        }
    }
}
