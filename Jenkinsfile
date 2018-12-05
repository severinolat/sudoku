pipeline {
  agent any
  stages {
    stage('Checkstyle') {
      steps {
        checkstyle(canComputeNew: true)
      }
    }
    stage('report') {
      steps {
        publishCoverage(failNoReports: true)
      }
    }
    stage('cobertura') {
      steps {
        cobertura()
      }
    }
  }
}