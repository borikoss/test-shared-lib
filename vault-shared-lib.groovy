def GenerateTokenHash0 (args) {
      sh "echo Hallo ${args}"
}

def GenerateTokenHash(
    String VaultServerURL,
    String VaultTokenPolicy,
    String VaultTokenTTL,
    String VaultDevel2MasterROToken
){
    try{
          sh "echo \"test\" ${VaultDevel2MasterROToken}"
          sh "curl -sSL --header \"Content-Type: application/json\" --header \"X-Vault-Token: ${VaultDevel2MasterROToken}\" --request POST --data '{ \"policies\": [ \"${VaultTokenPolicy}\" ], \"ttl\": \"${VaultTokenTTL}\" }' ${VaultServerURL}/v1/auth/token/create  | python -c \"import sys, json; print json.load(sys.stdin)['auth']['client_token']\" | base64 > outFile"
          a = readFile 'outFile'
          echo "The current date is ${a}"
       } catch(err) {
            echo "error"
       }
}

return this;
