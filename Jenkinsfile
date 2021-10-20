pipeline{

    agent any
    environment {
        imagename = "28609002/time_sheet_dev_ops"
        registryCredential = '28609002-dockerhub'
        dockerImage = ''
    }
   // tools {
       // maven "3.8.1"
        //jdk 'oracle'
   // }

    stages{
        
        stage('Maven Clean Compile'){
            steps {
                echo "starting maven"
                echo "Initiating clean compile commands"
                sh 'mvn --version'
                sh 'mvn clean compile'
                
            }
            
        }
        stage('Maven Test'){
            steps {
                echo "Initiating Dynamic test ! "
                sh 'mvn test'
            }
        }
        stage('Building docker image'){
            steps {
                script {
                    dockerImage = docker.build imagename + ":$BUILD_NUMBER"
                       }
            }
        }
        stage('Deploy image'){
            steps {
                script {
                        docker.withRegistry( '', registryCredential ) {
                        dockerImage.push("$BUILD_NUMBER")
                        dockerImage.push('latest')
                                    }
                }
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
