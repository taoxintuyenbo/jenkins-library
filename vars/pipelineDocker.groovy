def call() {
  node {
    try {
      if (env.BRANCH_NAME == 'release' || env.BRANCH_NAME.startsWith('uat')) {
        checkoutSCM()
        loadTools()
        varsNexus()
        varsServerDocker()
        buildJava()
        unitTestJava()
        qualityCheck()
        qualityGate()
        pushSnapshot()
        buildDocker()
        pushDockerNexus()
        deployDocker()
        healthCheck()
        notiSuccess()
      } else if (env.BRANCH_NAME.startsWith('dev')) {
        checkoutSCM()
        loadTools()
        buildJava()
        unitTestJava()
        qualityCheck()
        qualityGate()
        notiSuccess()
      } else {
        echo "No pipeline configured for branch: ${env.BRANCH_NAME}"
      }
    } catch (err) {
      notiFail(stageLog: "${err}")
      throw err
    }
  }
}
