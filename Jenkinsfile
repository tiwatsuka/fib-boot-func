pipeline {
  agent {
    docker {
      image 'quay.io/lib/maven'
    }

  }
  stages {
    stage('build') {
      steps {
        sh 'mvn install'
      }
    }

    stage('save') {
      steps {
        archiveArtifacts 'target/*.jar'
      }
    }

  }
}