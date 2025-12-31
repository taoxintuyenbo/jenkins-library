def call(){
  node {
    checkoutSCM()
    loadTools()
    varsNexus()
    varsServer()
    buildJava()
    unitTestJava()
    qualityCheck()
    qualityGate()
    pushSnapshot()
    buildDocker()
    pushDockerNexus()
  }
}
