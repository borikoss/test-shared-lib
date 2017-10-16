node {
  withCredentials([[$class: 'StringBinding', credentialsId: 'VaultDevel2MasterRWToken', variable: 'VaultDevel2MasterRWToken'],[$class: 'StringBinding', credentialsId: 'VaultDevel2MasterROToken', variable: 'VaultDevel2MasterROToken']]) {
    withEnv(['VaultServerURL=http://10.192.35.219:8090','VaultTokenIncrementTTL=768h']) {
      stage 'Renew R/O-Master Token'
        sh '''(
           unset http_proxy; unset https_proxy
           curl -sSL --max-time 5 --header "Content-Type: application/json" --header "X-Vault-Token: ${VaultDevel2MasterROToken}" --request POST --data "{ \\"increment\\" : \\"$VaultTokenIncrementTTL\\" }" ${VaultServerURL}/v1/auth/token/renew-self
        )'''
      stage 'Renew R/W-Master Token'
        sh '''(
           unset http_proxy; unset https_proxy
           curl -sSL --max-time 5 --header "Content-Type: application/json" --header "X-Vault-Token: ${VaultDevel2MasterRWToken}" --request POST --data "{ \\"increment\\" : \\"$VaultTokenIncrementTTL\\" }" ${VaultServerURL}/v1/auth/token/renew-self
        )'''
    }
  }
}
