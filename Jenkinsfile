node {
    stage 'load pipeline'
    deleteDir()
    sh 'git clone https://github.com/borikoss/test-shared-lib.git _pipeline'

    pipeline = load '_pipeline/shared-libs.groovy'
    pipeline.GenerateVaultTokenHash('devel2')
}
