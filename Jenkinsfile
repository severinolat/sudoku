pipeline {
  agent any
  stages {
    stage('Checkstyle') {
      steps {
        checkstyle(canComputeNew: true)
      }
    }
  }
}