def call(){
  node {
    checkoutSCM()
    loadTools()
    varsNexus()
    varsServer()
    buildJava()
    //unitTestJava()
   // qualityCheck()
    //qualityGate()
    pushArtifactJava()
    pushSnapshot()
    deployJava()
    healthCheck()
  }
}
