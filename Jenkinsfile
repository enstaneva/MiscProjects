node('demo') {
	// Defining variables
	def mvnHome
	def javaHome
	
   stage('Prepare') { 
    echo 'In Prepare stage'
	echo 'Preparing tools ...'
    mvnHome = tool 'MavenAutoInstallation'
	javaHome = tool 'JDK8u131'
	env.JAVA_HOME = "${javaHome}"
	echo "JDK installation path is: ${javaHome}"
    tool name: 'DockerAutoInstallationCentOs', type: 'org.jenkinsci.plugins.docker.commons.tools.DockerTool'
    tool name: 'gitAutoInstallationCentOs', type: 'git' 
	echo 'Cleaning workspace ...'
	cleanWs()
	echo 'Current working directory ...'
	sh "ls -la ${pwd()}"
	echo 'Getting code from a GitHub repository'
	git 'https://github.com/enstaneva/MiscProjects.git'
   }
    
   stage('Build') {
       echo 'In Build stage'
      // Run the maven build
        dir("jenkins-demoapp"){
         sh "'${mvnHome}/bin/mvn' clean install -Dmaven.test.skip=true"      
      }
      }
      
    stage('Deploy') {
        echo 'In Deploy stage'
		 dir("jenkins-demoapp"){
			sh "docker run -p ${env.APP_PORT}:8080 --name demoapp-container -d -h ${env.NODE_NAME} demoapp"
		 }
       
    }
   
    stage('Test') {
        echo 'In Test stage'
		dir("jenkins-demoapp"){
		sh "'${mvnHome}/bin/mvn' test -Dtest=SystemTestSuite -Dmaven.test.failure.ignore -Dapp.host.name=${env.NODE_NAME} -Dapp.port=${env.APP_PORT}"    
		}
    }
    
   stage('Results') {
        echo 'In Results stage'
		dir("jenkins-demoapp/target/surefire-reports"){
		junit '*.xml'
		}
     
   }
}