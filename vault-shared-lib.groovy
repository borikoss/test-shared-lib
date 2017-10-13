def GenerateTokenHash0 (args) {
      sh "echo Hallo ${args}"
}

def GenerateTokenHash(
    String VaultServerURL,
    String VaultTokenTTL,
    String VaultTokenPolicy,
    String VaultDevel2MasterROToken
){
    try{
          sh "echo ${VaultServerURL}"
          sh "echo ${VaultTokenTTL}"
          sh '''curl -sSL --header "Content-Type: application/json" --header "X-Vault-Token: c35c99d3-cf78-6fb3-b604-7d390abab983" --request POST --data '{ "policies": [ "policy_devel_ro_jira" ], "ttl": "24h" }' http://vault.10.50.10.1.xip.io:8200/v1/auth/token/create '''

       } catch(err) {
            echo "error"
       }
}

return this;
