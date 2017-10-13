node {
  withCredentials([string(credentialsId: 'VaultDevMasterROToken', variable: 'VaultDevMasterROToken')]) {
    stage 'Jira Token create & apply'
       sh '''( 
           VaultDevJiraROTokenHash=$(curl -sSL --header "Content-Type: application/json" --header "X-Vault-Token: ${VaultDevMasterROToken}" --request POST --data '{ "policies": [ "policy_devel_ro_jira" ], "ttl": "24h" }' http://vault.10.50.10.1.xip.io:8200/v1/auth/token/create | python -c "import sys, json; print json.load(sys.stdin)['auth']['client_token']" | base64 )
           echo -e "apiVersion: v1 \nkind: Secret \nmetadata: \n  name: mysecret \ntype: Opaque \ndata:  \n  root_token: ${VaultDevJiraROTokenHash}" | cat -
        )'''
    stage 'Crowd Token create & apply'
       sh '''( 
           VaultDevCrowdROTokenHash=$(curl -sSL --header "Content-Type: application/json" --header "X-Vault-Token: ${VaultDevMasterROToken}" --request POST --data '{ "policies": [ "policy_devel_ro_crowd" ], "ttl": "24h" }' http://vault.10.50.10.1.xip.io:8200/v1/auth/token/create | python -c "import sys, json; print json.load(sys.stdin)['auth']['client_token']" | base64 )
           echo -e "apiVersion: v1 \nkind: Secret \nmetadata: \n  name: mysecret \ntype: Opaque \ndata:  \n  root_token: ${VaultDevCrowdROTokenHash}" | cat -
        )'''

  }
}
