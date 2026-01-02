pipeline {
    agent {
        docker {
            image 'eclipse-temurin:21-jdk-jammy'  // Maven + Java 21
            args '-v /var/run/docker.sock:/var/run/docker.sock'
        }
    }

    environment {
        DOCKER_IMAGE = "springboot-app:latest"
        CONTAINER_NAME = "springboot-app"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/younes200444/projet.git'
            }
        }

        stage('Build with Maven') {
            steps {
                // utilise le Maven Wrapper fourni dans ton projet
                sh './mvnw clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh "docker build -t $DOCKER_IMAGE ."
            }
        }

        stage('Run Docker Container') {
            steps {
                sh "docker stop $CONTAINER_NAME || true"
                sh "docker rm $CONTAINER_NAME || true"
                sh "docker run -d --name $CONTAINER_NAME -p 8081:8080 $DOCKER_IMAGE"
            }
        }
    }

    post {
        success {
            echo "✅ Build et déploiement réussis !"
        }
        failure {
            echo "❌ Build ou déploiement échoué !"
        }
    }
}
