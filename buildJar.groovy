#!/user/bin/env groovy

def call() {
    echo "Building the application for ${env.GIT_BRANCH} branch"
    sh "mvn package"
}
