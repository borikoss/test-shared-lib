def WriteTokenSecret(
    String VaultTokenHash,
    String KubeSecretName,
    String KubeNamespace
){
    try{
          sh "echo -e \"apiVersion: v1 \nkind: Secret \nmetadata: \n  name: ${KubeSecretName} \ntype: Opaque \ndata:  \n  token: ${VaultTokenHash}\" | cat -"

       } catch(err) {
            echo "Unknown error appeared! Please check!"
       }
}

return this;
