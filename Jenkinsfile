node {
    stage 'Load shared libs'
    deleteDir()
    sh 'git clone https://github.com/borikoss/test-shared-lib.git'

    Vault = load 'test-shared-lib/vault-shared-lib.groovy'
    Kube = load 'test-shared-lib/kube-shared-lib.groovy'

    stage 'Token1'
    Vault.GenerateTokenHash('devel2','wsddwd','346erdgfd','89324jkdkjdsf87234,dsflkjljksfd')
    Kube.WriteTokenSecret('devel2')

    deleteDir()
}
