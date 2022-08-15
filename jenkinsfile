pipeline
{
    agent any
     {
          stages
          {
              stage('Build')
              {
                  steps
                  {
                      echo "Buildind the code"
                      bat "mvn clean"
                      echo "Build Step completed successfully"
                  }
              }
          }
          stages
          {
              stage('Test')
              {
                  steps
                  {
                      echo "Testing the code"
                      bat "mvn test"
                      echo "Test step completed successfully"
                  }
              }
          }
          stages
          {
              stage('Compile')
              {
                  steps
                  {
                      echo "Compiling the code"
                      bat "mvn compile"
                      echo "Compile step completed successfully"
                  }
              }
          }
          stages
          {
              stage('Release')
              {
                  echo "Releasing the code"
                  echo "Release step completed successfully"
              }
          }
     }
}
