pipeline {
    agent any
    environment {
        imagename = "28609002/time_sheet_dev_ops"
        registryCredential = '28609002-dockerhub'
        dockerImage = ''
    }
    
    stages {

        stage('Running our image from dockerhub inside container') {
            steps {
               //bat "docker stop $container"
               //bat "docker rm $container"
               sh "docker run -d --name $container -p 3000:3000 $imagename:$BUILD_NUMBER"
            }
        }
    }
}

