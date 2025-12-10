def call(){
  node {
    checkoutSCM()
    loadTools()
    buildJava()
    unitTestJava()
    qualityCheck()
    qualityGate()
  }
}
