pipeline{
    stages{
        stage('SCM'){
            step{
                echo ' getting code from the git repository'
                git changelog: false, poll: false, url: 'https://github.com/sandeep4358/inventoryService.git'
            }
        }

    stage('Maven Build'){
                step{
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