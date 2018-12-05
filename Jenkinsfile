pipeline {
  agent any
  stages {
    stage('error') {
      steps {
        checkstyle(canComputeNew: true, canResolveRelativePaths: true, canRunOnFailed: true)
      }
    }
  }
}