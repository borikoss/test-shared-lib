node {
    stage 'Load shared libs'
    deleteDir()
    sh 'git clone https://github.com/borikoss/test-shared-lib.git'

    Vault = load 'test-shared-lib/vault-shared-lib.groovy'
    Kube = load 'test-shared-lib/kube-shared-lib.groovy'

    stage 'Token1'
    Vault.GenerateTokenHash('devel2','wsddwd','346erdgfd','c35c99d3-cf78-6fb3-b604-7d390abab983')
    Kube.WriteTokenSecret('devel2')

    deleteDir()
}
