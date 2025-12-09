def call(){
  node {
    loadTools()
    checkoutSCM()
    buildJava()
    unitTestJava()
  }
}
