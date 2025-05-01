def call(String image,String tag){
    withCredentials([usernamePassword(credentialsId:"Docker-cred",passwordVariable:"dockerHubPass",usernameVariable:"dockerHubUser")])
    {
        sh 'echo "$dockerHubPass" | docker login -u "$dockerHubUser" -p --password-stdin docker.io'
        sh "docker push ${dockerHubUser}/${image}:${tag}"
    }
}