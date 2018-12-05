pipeline {
  agent none
  stages {
    stage('error') {
      steps {
        build 'sudoku'
        checkstyle(canComputeNew: true, canResolveRelativePaths: true, canRunOnFailed: true)
      }
    }
  }
}