def call(String sonarQubeApi,String projectName,String projectKey)
{
    withSonarQubeEnv("${sonarQubeApi}")
    {
        sh "{$SONAR_HOME}/bin/sonar-scanner
        -Dsonar.projectName=${projectName}
        -Dsonar.projectKey=${projectKey} -x"
    }
}