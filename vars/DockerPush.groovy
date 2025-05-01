def call(String image,String tag){
    withCredentials([usernamePassword(credentialsId:"Docker-cred",passwordVariable:"dockerHubPass",usernameVariable:"dockerHubUser")])
    {
        sh 'echo "$dockerHubPass" | docker login -u "$dockerHubUser" --password-stdin docker.io'.stripIndent()
        sh "docker push ${dockerHubUser}/${image}:${tag}"
    }
}