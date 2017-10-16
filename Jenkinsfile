node {
  withCredentials([string(credentialsId: 'VaultDevel2MasterROToken', variable: 'VaultDevel2MasterROToken')]) {
      stage 'Load libs & config'
      deleteDir()
      sh 'git clone https://github.com/borikoss/test-shared-lib.git'

      Vault = load 'test-shared-lib/vault-shared-lib.groovy'
      Kube = load 'test-shared-lib/kube-shared-lib.groovy'

      VaultDevelServerURL = "http://vault.10.50.10.1.xip.io:8200"
      VaultDevelTokenTTL = "72h"
      KubeDevelNamespace = "devel2"
      //VaultDevel2MasterROToken = "c35c99d3-cf78-6fb3-b604-7d390abab983"

      stage 'Create token Jira@devel2'
      Vault.GenerateTokenHash("${VaultDevelServerURL}",'policy_devel_ro_jira',"${VaultDevelTokenTTL}","${VaultDevel2MasterROToken}")
      Kube.WriteTokenSecret("${VaultTokenHash}",'vault-devel2-jira-ro-token',"${KubeDevelNamespace}")

      stage 'Create token Crowd@devel2'
      Vault.GenerateTokenHash("${VaultDevelServerURL}",'policy_devel_ro_crowd',"${VaultDevelTokenTTL}","${VaultDevel2MasterROToken}")
      Kube.WriteTokenSecret("${VaultTokenHash}",'vault-devel2-crowd-ro-token',"${KubeDevelNamespace}")

      deleteDir()
  }
}
