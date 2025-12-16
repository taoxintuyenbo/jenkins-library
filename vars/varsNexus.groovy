def call() {
    def nexusProps = readProperties(file: 'nexus.properties')
    env.NEXUS_URL         = nexusProps.nexusUrl
    env.NEXUS_URL_DOCKER  = nexusProps.nexusUrlDocker
    env.NEXUS_SNAPSHOTS_REPO = nexusProps.nexusRepoSnapshots
    env.NEXUS_RELEASES_REPO = nexusProps.nexusRepoReleases
    env.ARTIFACT_PATH = nexusProps.artifactPath
    env.NEXUS_GROUP       = nexusProps.nexusGroup
    env.NEXUS_CRED        = nexusProps.nexusCred
    env.NEXUS_ARTIFACT_ID = nexusProps.nexusPrjID
}
