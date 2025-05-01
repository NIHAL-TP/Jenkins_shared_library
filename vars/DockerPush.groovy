def call(String image,String tag){
    withCredentials([usernamePassword(credentialsId:"Docker-cred",passwordVariable:"dockerHubPass",usernameVariable:"dockerHubUser")])
    {
        sh "echo 'image inside double q' ${image}"
        sh """
        echo "image inside single q" ${image}
        echo "\$dockerHubPass" | docker login -u "\$dockerHubUser" --password-stdin docker.io
        docker push "\$dockerHubUser/${image}:${tag}"
        docker logout docker.io
        """.stripIndent()
    }
}