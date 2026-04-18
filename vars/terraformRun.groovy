def call(Map cfg = [:]) {
    def action = cfg.action

    stage("Terraform ${action}") {
        withCredentials([[
            $class: 'AmazonWebServicesCredentialsBinding',
            credentialsId: cfg.awsCred
        ]]) {

            if (action != 'init') {
                sh 'terraform init'
            }

            switch(action) {
                case 'init':
                    sh 'terraform init'
                    break
                case 'plan':
                    sh 'terraform plan'
                    break
                case 'apply':
                    sh 'terraform apply -auto-approve'
                    break
                case 'destroy':
                    sh 'terraform destroy -auto-approve'
                    break
                default:
                    error("Invalid action: ${action}")
            }
        }
    }
}
