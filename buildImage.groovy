#!/user/bin/env groovy

def call() {
echo "building the docker image..."
withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]){
    sh "docker build -t kbarbary211/demo-app:${IMAGE_NAME} ."
    sh 'echo $PASS | docker login -u $USER --password-stdin'
    sh "docker push kbarbary211/demo-app:${IMAGE_NAME}"
}
}