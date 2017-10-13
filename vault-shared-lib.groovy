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
          curl -sSL \
--header "Content-Type: application/json" \
--header "X-Vault-Token: 696d336f-610f-1529-7e17-888eb423fbfa" \
--request POST \
--data '{ "policies": [ "policy_devel_ro_jira" ], "ttl": "24h" }' \
http://vault.10.50.10.1.xip.io:8200/v1/auth/token/create | python -c "import sys, json; print json.load(sys.stdin)['auth']['client_token']"

       } catch(err) {
            echo "error"
       }
}

return this;
