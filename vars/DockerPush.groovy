def call(image,tag){
    withCredentials([usernamePassword(credentialsId:"${Docker-
    cred}",passwordVariable:"${dockerHubPass}",usernameVariable:"${dockerHubUser}")])
    {
        sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"
        sh "docker push ${dockerHubUser}/${image}:${tag}"
    }
}