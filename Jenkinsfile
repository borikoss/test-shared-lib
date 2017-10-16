node {
    stage 'Load shared libs'
    deleteDir()
    sh 'git clone https://github.com/borikoss/test-shared-lib.git'

    Vault = load 'test-shared-lib/vault-shared-lib.groovy'
    Kube = load 'test-shared-lib/kube-shared-lib.groovy'

    stage 'Jira Token create & apply'
    Vault.GenerateTokenHash('http://vault.10.50.10.1.xip.io:8200','policy_devel_ro_jira','72h','c35c99d3-cf78-6fb3-b604-7d390abab983')
    echo "Hash is ${VaultTokenHash}"

    Kube.WriteTokenSecret('${VaultTokenHash}','vault-devel2-jira-ro-token','devel2')

    deleteDir()
}
