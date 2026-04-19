def call() {
  properties([
    parameters([
      choice(name: 'TF_ACTION', choices: ['init', 'validate', 'plan', 'apply', 'destroy'], description: 'Terraform action to run'),
    ])
  ])

  node {
    try {
      deleteDir()
      checkout scm
  
      if (env.BRANCH_NAME == 'release' || env.BRANCH_NAME == 'main'){
          dir("environments/prod"){
              terraformRun(
                  action: params.TF_ACTION,
                  awsCred: env.AWS_CRED
              )
          }
      } else if (env.BRANCH_NAME.startsWith('dev')){
          dir("environments/dev") {
              terraformRun(
                  action: params.TF_ACTION,
                  awsCred: env.AWS_CRED
              )
          }
      }
      notiSuccess()
    }
    catch (err) {
        notiFail(stageLog: "${err}")
        throw err
      }
  }
}
