def call(){
  node {
    loadTools("tools.txt")
    checkoutSCM()
    buildJava()
    unitTestJava()
  }
}
