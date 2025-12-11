def call() {
    def nexusProps = readProperties(file: 'nexus.properties')
    env.NEXUS_URL         = nexusProps.nexusUrl
    env.NEXUS_URL_DOCKER  = nexusProps.nexusUrlDocker
    env.NEXUS_PRO_REPO    = nexusProps.nexusRepo
    env.NEXUS_GROUP       = nexusProps.nexusGroup
    env.NEXUS_CRED        = nexusProps.nexusCred
    env.NEXUS_ARTIFACT_ID = nexusProps.nexusPrjID
}
