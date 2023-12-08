pipeline{
    agent any
    stages{
        stage('SCM'){
            steps{
                echo ' getting code from the git repository'
                git changelog: false, poll: false, url: 'https://github.com/sandeep4358/inventoryService.git'
            }
        }


    stage('Maven Build'){
                steps{
                    sh 'mvn clean install'
                }
            }

     stage('Docker Build'){
                steps{
                    echo 'Docker build'
                    script{
                         withDockerRegistry(credentialsId: 'a77c722e-a2ea-45c3-b4e3-6100d91bcb67') {
                                                 // some block
                                                 sh 'docker image build -t sandeep022/inventoryservice:tage234 .'
                                                 sh 'docker push sandeep022/inventoryservice:tage234'
                                             }
                    }
                }
		}

		post{
			always{
				emailtext(
					subject:"Pipeline Status: ${currentBuild.result}",
					body: '''<html>
							<body>
								<p>Build Status: ${currentBuild.result}</p>
								<p>Build Number: ${currentBuild.number}</p>
								<p>Check the <a href="${env.BUILD_URL}">console output</a>.</p>

							</body>
							</html> ''',
					to: 'sandy.msit@gmail.com',
					from: 'sandy.msit@gmail.com',
					replyTo: 'freelanceratsany@gmail.com',
					mimeType: 'text/html'
				)


			}
		}



}
}