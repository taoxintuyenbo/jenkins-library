def call(){
  node {
    checkoutSCM()
    loadTools()
    buildJava()
    unitTestJava()
  }
}
