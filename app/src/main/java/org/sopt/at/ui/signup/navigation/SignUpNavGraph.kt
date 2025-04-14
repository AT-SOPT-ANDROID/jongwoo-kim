package org.sopt.at.ui.signup.navigation

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.sopt.at.ui.signup.screen.SignUpAccountState
import org.sopt.at.ui.signup.screen.SignUpIdScreen
import org.sopt.at.ui.signup.screen.SignUpPwScreen

@Composable
fun SignupNavGraph(
    navController: NavHostController,
    signUpAccountState: SignUpAccountState,
    signUpEndCallback: () -> Unit,
) {
    NavHost(navController = navController, startDestination = SignUpScreenRoute.SignUpIdScreen.route) {
        composable(
            route = SignUpScreenRoute.SignUpIdScreen.route,
            enterTransition = { slideInHorizontally(initialOffsetX = { it }) },
            exitTransition = { slideOutHorizontally(targetOffsetX = { -it }) },
            popEnterTransition = { slideInHorizontally(initialOffsetX = { -it }) },
            popExitTransition = { slideOutHorizontally(targetOffsetX = { it }) }
        ) {
            SignUpIdScreen(navController, signUpAccountState)
        }

        composable(
            route = SignUpScreenRoute.SignUpPwScreen.route,
            enterTransition = { slideInHorizontally(initialOffsetX = { it }) },
            exitTransition = { slideOutHorizontally(targetOffsetX = { -it }) },
            popEnterTransition = { slideInHorizontally(initialOffsetX = { -it }) },
            popExitTransition = { slideOutHorizontally(targetOffsetX = { it }) }
        ) {
            SignUpPwScreen(signUpAccountState, signUpEndCallback)
        }
    }
}