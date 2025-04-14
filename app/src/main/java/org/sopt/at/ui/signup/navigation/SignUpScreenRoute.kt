package org.sopt.at.ui.signup.navigation

sealed class SignUpScreenRoute(val route: String) {
    data object SignUpIdScreen: SignUpScreenRoute("SignupIdScreen")
    data object SignUpPwScreen: SignUpScreenRoute("SignupPwScreen")
}