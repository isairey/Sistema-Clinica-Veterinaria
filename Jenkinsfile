pipeline {
    agent any // Specifies that the pipeline can run on any available agent
    tools {
            maven 'mvn' // Replace with your configured Maven tool name
        }
    environment {
        SONARQUBE_ENV = 'sonarqube' // Este nombre debe coincidir con la configuración de SonarQube en Jenkins (Manage Jenkins > Configure System)
    }
    stages {
        
        stage('Build') {
           steps {

                dir('base') { // Cambia 'base' por el nombre de tu carpeta
                    sh 'mvn clean install'
                }

                dir('cliente') { // Cambia 'base' por el nombre de tu carpeta
                    sh 'mvn clean install'
                }
                dir('proveedor') { // Cambia 'base' por el nombre de tu carpeta
                    sh 'mvn clean install'
                }
                dir('mascota') { // Cambia 'base' por el nombre de tu carpeta
                    sh 'mvn clean install'
                }
                dir('rrhh') { // Cambia 'base' por el nombre de tu carpeta
                    sh 'mvn clean install'
                }
            }
        }
         stage('SonarQube Analysis') {
            steps {
                dir('base') {
                    withSonarQubeEnv("${SONARQUBE_ENV}") {
                        sh 'mvn sonar:sonar -Dsonar.host.url=http://sonarqube:9000 -Dsonar.projectKey=sgVet-Base -Dsonar.projectName=SgVet-Base'
                    }
                }

                dir('cliente') {
                    withSonarQubeEnv("${SONARQUBE_ENV}") {
                        sh 'mvn sonar:sonar -Dsonar.host.url=http://sonarqube:9000 -Dsonar.projectKey=SgVet-Cliente -Dsonar.projectName=SgVet-Cliente'
                    }
                }

                dir('proveedor') {
                    withSonarQubeEnv("${SONARQUBE_ENV}") {
                        sh 'mvn sonar:sonar -Dsonar.host.url=http://sonarqube:9000 -Dsonar.projectKey=SgVet-Proveedor -Dsonar.projectName=SgVet-Proveedor'
                    }
                }

                dir('mascota') {
                    withSonarQubeEnv("${SONARQUBE_ENV}") {
                        sh 'mvn sonar:sonar -Dsonar.host.url=http://sonarqube:9000 -Dsonar.projectKey=SgVet-Mascota -Dsonar.projectName=SgVet-Mascota'
                    }
                }

                dir('rrhh') {
                    withSonarQubeEnv("${SONARQUBE_ENV}") {
                        sh 'mvn sonar:sonar -Dsonar.host.url=http://sonarqube:9000 -Dsonar.projectKey=sgVet-RRHH -Dsonar.projectName=SgVet-RRHH'
                    }
                }
            }
        }

    }
}