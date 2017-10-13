node {
    stage 'Load shared libs'
    deleteDir()
    sh 'git clone https://github.com/borikoss/test-shared-lib.git'

    vault = load 'test-shared-lib/vault-shared-lib.groovy'
    vault.GenerateTokenHash('devel2')

    deleteDir()
}
