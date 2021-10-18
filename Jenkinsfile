pipeline{
    agent any
    tools {
        maven "3.8.1"
        jdk 'oracle'
    }
    stages{
        stage('GIT'){
            steps {
                echo"pulling project from git"
                git "https://github.com/HafdhiAtef/time_sheet_Dev_Ops.git"
                
            }
        }
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
        stage('Notification!'){
            steps {
                emailext body: 'Check console output at $BUILD_URL to view the results. \n\n ${CHANGES} \n\n -------------------------------------------------- \n${BUILD_LOG, maxLines=100, escapeHtml=false}', 
                    to: "atef.hafdhi@esprit.tn", 
                    subject: 'New build Alert !: $PROJECT_NAME - #$BUILD_NUMBER'
      
            }
            
        }
        
    }
    
}
