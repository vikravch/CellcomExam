object Compose {
    const val composeVersion = "1.4.6"
    const val composeCompilerVersion = "1.4.6"
    const val material = "androidx.compose.material:material:$composeVersion"
    const val ui = "androidx.compose.ui:ui:$composeVersion"
    const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:$composeVersion"
    const val runtime = "androidx.compose.runtime:runtime:$composeVersion"
    const val compiler = "androidx.compose.compiler:compiler:$composeCompilerVersion"

    private const val navigationVersion = "2.4.0-beta02"
    const val navigation = "androidx.navigation:navigation-compose:$navigationVersion"

    private const val hiltNavigationComposeVersion = "1.0.0-beta01"
    const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:$hiltNavigationComposeVersion"

    private const val activityComposeVersion = "1.7.2"
    const val activityCompose = "androidx.activity:activity-compose:$activityComposeVersion"

    private const val lifecycleVersion = "2.4.0"
    const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycleVersion"

    private const val constraintLayoutComposeVersion = "1.0.0-beta08"
    const val constraintLayoutCompose = "androidx.constraintlayout:constraintlayout-compose:$constraintLayoutComposeVersion"

    // Tooling support (Previews, etc.)
    const val uiTooling = "androidx.compose.ui:ui-tooling:$composeVersion"
    // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
    const val foundation = "androidx.compose.foundation:foundation:$composeVersion"
    // Material design icons
    const val materialIcons = "androidx.compose.material:material-icons-core:$composeVersion"
    const val materialIconsExtended = "androidx.compose.material:material-icons-extended:$composeVersion"
    // Integration with observables
    const val runtimeLivedata = "androidx.compose.runtime:runtime-livedata:$composeVersion"
    // UI Tests
    const val uiTest = "androidx.compose.ui:ui-test-junit4:$composeVersion"
    // Constraint Layout
    const val constraintLayout = "androidx.constraintlayout:constraintlayout-compose:1.0.1"
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:2.5.0-rc02"
    // do not update this experimental version
    const val accompanist = "com.google.accompanist:accompanist-pager:0.22.0-rc"
    const val coil = "io.coil-kt:coil-compose:1.4.0"
    const val slider = "com.github.SmartToolFactory:Compose-Colorful-Sliders:1.0.2"

}
