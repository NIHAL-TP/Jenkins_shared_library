def call(String sonarQubeApi,String projectName,String projectKey)
{
    withSonarQubeEnv("${sonarQubeApi}")
    {
        sh """ ${tool 'Sonar'}/bin/sonar-scanner
        -Dsonar.projectName=${projectName}
        -Dsonar.projectKey=${projectKey} -X """
    }
}