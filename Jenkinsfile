pipeline {
    agent any
    environment {
        imagename = "28609002/time_sheet_dev_ops"
        registryCredential = '28609002-dockerhub'
        dockerImage = 'Spring-app'
                }
 //   revision = version + "-" + sprintf("%04d", env.BUILD_NUMBER.toInteger()   
    
    stages {
        stage('Preparing enviroment '){
            steps {
                echo "removing old image"
                sh 'docker rmi -f $imagename:latest  '
            }
        }
    
    
        stage('Deploying the image into a container'){
            steps {
                echo "Installing the app "
                sh 'docker run -p 8084:8084 -d --name $dockerImage $imagename:$BUILD_NUMBER   '
            }
        }
        
        
        
 
        
        
         
        }
}

