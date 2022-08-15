pipeline
{
    agent any
        stages
        {
              stage('Build')
              {
                  steps
                  {
                      echo "Buildind the code"
                      sh "mvn clean"
                      echo "Build Step completed successfully"
                  }
              }
              stage('Test')
              {
                  steps
                  {
                      echo "Testing the code"
                      bat "mvn test"
                      echo "Test step completed successfully"
                  }
              }
              stage('Compile')
              {
                  steps
                  {
                      echo "Compiling the code"
                      bat "mvn compile"
                      echo "Compile step completed successfully"
                  }
              }
              stage('Release')
              {
                  steps
                  {
                    echo "Releasing the code"
                    echo "Release step completed successfully"
                  }
              }
          }
}
