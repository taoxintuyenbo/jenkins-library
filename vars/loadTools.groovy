def call(String toolFile = 'tools.properties') {
    if (!fileExists(toolFile)) {
        error "Tools properties file not found: ${toolFile}"
    }

    env.VERSION = "${new Date().format('yyMMdd')}"
    
    // require plugin Pipelin ultil
    def toolsConfig = readProperties(file: toolFile)

    // Extract special properties
    env.SONAR_SERVER = toolsConfig.get('sonarServer', '')
    env.PROJECT_NAME = toolsConfig.get('projectName', '')

    // Load only Jenkins tool types (maven, jdk, nodejs...)
    toolsConfig.each { key, value ->
        if (key.startsWith("tool.")) { 
            def realKey = key.replace("tool.", "")  // tool.maven → MAVEN_HOME
            def toolHome = tool(value.trim())
            env["${realKey.toUpperCase()}_HOME"] = toolHome
            echo "Loaded tool: ${realKey} => ${value}"
        }
    }
}
