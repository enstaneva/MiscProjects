pipeline{
agent 'jenkins-demo1'

stages{

stage('Prepare'){

steps{
	echo 'In Prepare stage'
	echo 'Preparing tools ...'
    tool name: 'DockerAutoInstallationCentOs', type: 'org.jenkinsci.plugins.docker.commons.tools.DockerTool'
    tool name: 'gitAutoInstallationCentOs', type: 'git' 
	echo 'Cleaning workspace ...'
	cleanWs()
	echo 'Getting code from a GitHub repository'
	git 'https://github.com/enstaneva/MiscProjects.git'

}

}

stage('Build'){
steps{


	   echo 'In Build stage'
        dir("jenkins-demoapp"){
            withEnv(["PATH+GRADLE=${tool 'GradleAutoInstallation'}/bin","PATH+JAVA=${tool 'JDK8u131'}/bin"]){ 
		 sh "gradle clean build docker -x test"  
            }
      }

}

}

stage('Deploy'){
steps{


     echo 'In Deploy stage'
		 dir("jenkins-demoapp"){
			sh "docker run -p ${env.APP_PORT}:8080 --name demoapp-container -d -h ${env.NODE_NAME} demoapp"
		 }
  

}

}


stage('Test'){
steps{

        echo 'In Test stage'
		dir("jenkins-demoapp"){
		withEnv(["PATH+GRADLE=${tool 'GradleAutoInstallation'}/bin","PATH+JAVA=${tool 'JDK8u131'}/bin"]){ 
		sh "gradle clean test -Dtest.single=SystemTestSuite -Dapp.host.name=${env.NODE_NAME} -Dapp.port=${env.APP_PORT}"    
		}
		}
}

}


stage('Results'){
steps{


        echo 'In Results stage'
		dir("jenkins-demoapp/build/test-results/test"){
		junit '*.xml'
		}
}
}

}

}




























}


}