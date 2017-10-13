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
          sh "echo ${VaultDevel2MasterROToken}"
          sh "curl -sSL --header \"Content-Type: application/json\" --header \"X-Vault-Token: ${VaultDevel2MasterROToken}\" --request POST --data '{ "policies": [ "policy_devel_ro_jira" ], "ttl": "24h" }' http://vault.10.50.10.1.xip.io:8200/v1/auth/token/create "

       } catch(err) {
            echo "error"
       }
}

return this;
