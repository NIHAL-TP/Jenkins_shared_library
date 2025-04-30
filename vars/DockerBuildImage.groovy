def call(String username,String image,String Tag)
{
    sh "docker build -t ${username}/${image}:${Tag} ."
}