def call(Map config = [:]) {
  mail to: "duydeptrai2004tv@gmail.com",
  subject: "${JOB_NAME} - Build #${BUILD_NUMBER} - FAILURE!",
  body: "Failure log: ${config.stageLog}. Please check the console output at ${BUILD_URL} for details."
}
