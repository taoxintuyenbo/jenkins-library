def call(){
  mail to: "duydeptrai2004tv@gmail.com",
  subject: "${JOB_NAME} - Build # ${BUILD_NUMBER} - SUCCESS!",
  body: "Check console output at ${BUILD_URL} to view the results. "
}
