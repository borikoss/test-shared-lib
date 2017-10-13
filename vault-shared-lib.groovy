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
       } catch(err) {
            echo "error"
       }
}

return this;
