def GenerateTokenHash(
    String VaultServerURL,
    String VaultTokenPolicy,
    String VaultTokenTTL,
    String VaultDevel2MasterROToken
){
    try{
          sh "unset http_proxy; unset https_proxy"
          sh "curl -sSL --max-time 5 --header \"Content-Type: application/json\" --header \"X-Vault-Token: ${VaultDevel2MasterROToken}\" --request POST --data '{ \"policies\": [ \"${VaultTokenPolicy}\" ], \"ttl\": \"${VaultTokenTTL}\" }' ${VaultServerURL}/v1/auth/token/create  | python -c \"import sys, json; print json.load(sys.stdin)['auth']['client_token']\" | base64 > outFile"
          VaultTokenHash = readFile 'outFile'
          deleteDir()

       } catch(err) {
            echo "Unknown error appeared! Please check!"
       }
}

return this;
