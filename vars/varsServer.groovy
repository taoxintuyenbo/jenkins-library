def call() {
    def serverProps = readProperties(file: 'serverJava.properties')
    env.URL_SERV_VM = serverProps.ipAddress
    env.PRIVKEY_SERV_VM = serverProps.privateKey
}
