def call(){
  node {
    checkoutSCM()
    loadTools()
    varsNexus()
    buildJava()
    unitTestJava()
    qualityCheck()
    qualityGate()
    pushArtifactJava()
    pushSnapshot()
  }
}
