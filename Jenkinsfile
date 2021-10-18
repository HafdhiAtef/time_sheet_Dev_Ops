pipeline {
    environment {
        registry = "zakaria25/spring"
        registryCredential = 'dockerhub_id'
        dockerImage = ''
        container='spring'
    }
    agent any
    stages {
        stage('Launch Maven-Lifecycle') {
            steps {
              bat 'mvn install'
            }
        }
        stage('Send To Sonar (Code Quality) ') {
            steps {
              bat 'mvn sonar:sonar'
            }
        }
        stage('Building our image') {
            steps {
                script {
                 dockerImage = docker.build registry + ":$BUILD_NUMBER"
                 }
            }
        }
        stage('Push our image to dockerhub') {
            steps {
                script {
                 docker.withRegistry( '', registryCredential ) {
                 dockerImage.push()
                 }
              }
            }
        }
        stage('Running our image from dockerhub inside container') {
            steps {
               //bat "docker stop $container"
               //bat "docker rm $container"
               bat "docker run -d --name $container -p 3000:3000 $registry:$BUILD_NUMBER"
            }
        }
    }
}

