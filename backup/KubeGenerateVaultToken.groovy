node {
  withCredentials([[$class: 'StringBinding', credentialsId: 'VaultDevel2MasterROToken', variable: 'VaultDevel2MasterROToken']]) {
    withEnv(['VaultServerURL=http://10.192.35.219:8090','VaultTokenTTL=72h','KubeNamespace=devel2']) {
      stage 'Jira Token create & apply'
        sh '''(
           KubeSecretName="vault-devel2-jira-ro-token"
           VaultTokenPolicy="policy_devel_ro_jira"

           unset http_proxy; unset https_proxy
           VaultTokenHash=$(curl -sSL --max-time 5 --header "Content-Type: application/json" --header "X-Vault-Token: ${VaultDevel2MasterROToken}" --request POST --data "{ \\"policies\\" : [ \\"$VaultTokenPolicy\\" ], \\"ttl\\": \\"${VaultTokenTTL}\\" }" ${VaultServerURL}/v1/auth/token/create | python -c "import sys, json; print json.load(sys.stdin)['auth']['client_token']" | base64 )
           echo -e "apiVersion: v1 \nkind: Secret \nmetadata: \n  name: ${KubeSecretName} \ntype: Opaque \ndata:  \n  token: ${VaultTokenHash}" | ~/bin/kubectl -n ${KubeNamespace} apply -f -
        )'''
      stage 'Crowd Token create & apply'
        sh '''(
           KubeSecretName="vault-devel2-crowd-ro-token"
           VaultTokenPolicy="policy_devel_ro_crowd"

           unset http_proxy; unset https_proxy
           VaultTokenHash=$(curl -sSL --max-time 5 --header "Content-Type: application/json" --header "X-Vault-Token: ${VaultDevel2MasterROToken}" --request POST --data "{ \\"policies\\" : [ \\"$VaultTokenPolicy\\" ], \\"ttl\\": \\"${VaultTokenTTL}\\" }" ${VaultServerURL}/v1/auth/token/create | python -c "import sys, json; print json.load(sys.stdin)['auth']['client_token']" | base64 )
           echo -e "apiVersion: v1 \nkind: Secret \nmetadata: \n  name: ${KubeSecretName} \ntype: Opaque \ndata:  \n  token: ${VaultTokenHash}" | ~/bin/kubectl -n ${KubeNamespace} apply -f -
        )'''
    }
  }
}
