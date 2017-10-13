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
          sh '
            echo "${VaultDevel2MasterROToken}"
            curl -sSL --header "Content-Type: application/json" --header "X-Vault-Token: ${VaultDevel2MasterROToken}" --request POST --data '{ \\"policies\\": [ \\"${VaultTokenPolicy}\\" ], \\"ttl\\": \\"${VaultTokenTTL}\\" }' ${VaultServerURL}/v1/auth/token/create
          '
       } catch(err) {
            echo "error"
       }
}

return this;
