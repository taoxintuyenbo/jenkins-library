def call(){
  node {
    checkoutSCM()
    loadTools()
    varsNexus()
    varsServerDocker()
    buildJava()
    // unitTestJava()
    // qualityCheck()
    // qualityGate()
    pushSnapshot()
    buildDocker()
    pushDockerNexus()
    deployDocker()
    healthCheck()
  }
}
