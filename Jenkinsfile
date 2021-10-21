pipeline{

    agent any
    environment {
        imagename = "28609002/time_sheet_dev_ops"
        registryCredential = '28609002-dockerhub'
        dockerImage = ''
    }
    tools {
       maven "3.8.1"
        jdk 'oracle'
    }

    
    stages{
        
        stage('Maven Clean Compile'){
            steps {
                echo "starting maven"
                echo "Initiating clean compile commands"
                sh 'mvn --version'
                sh 'mvn clean compile install'
                
            }
            
        }
        stage('Maven Test'){
            steps {
                echo "Initiating Dynamic test ! "
                sh 'mvn test'
            }
        }
        stage('Maven install'){
            steps {
                echo "Installing the app "
                sh 'mvn install'
            }
        }
        stage('Building docker image'){
            steps {
                script {
                    dockerImage = docker.build imagename + ":$BUILD_NUMBER"
                       }
            }
        }
        stage('pushing to dockerhub'){
            steps {
                script {
                        docker.withRegistry( '', registryCredential ) {
                        dockerImage.push("$BUILD_NUMBER")
                        dockerImage.push('latest')
                                    }
                }
            }
        }
        stage('Deploying the image into a container'){
            steps {
                echo "Installing the app "
                sh 'docker run -d --name $container -p 3000:3000 $imagename:$BUILD_NUMBER'
            }
        }
        
        //stage('Remove')
        stage('Notification!'){
            steps {
                emailext body: 'Check console output at $BUILD_URL to view the results. \n\n ${CHANGES} \n\n -------------------------------------------------- \n${BUILD_LOG, maxLines=100, escapeHtml=false}', 
                    to: "atef.hafdhi@esprit.tn", 
                    subject: 'New build Alert !: $PROJECT_NAME - #$BUILD_NUMBER'
      
            }
            
        }
        
    }
    
}
