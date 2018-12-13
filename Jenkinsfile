pipeline {
  agent any
  stages {
    stage('checkstyle') {
      steps {
        checkstyle(canComputeNew: true)
      }
    }
    stage('findbugs') {
      steps {
        findbugs(canComputeNew: true)
      }
    }
    stage('cobertura') {
      steps {
        cobertura(autoUpdateStability: true, autoUpdateHealth: true)
      }
    }
  }
}