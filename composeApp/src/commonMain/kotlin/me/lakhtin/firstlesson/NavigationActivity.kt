package me.lakhtin.firstlesson

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import androidx.navigation.toRoute
import me.lakhtin.firstlesson.nav.Route
import me.lakhtin.firstlesson.ui.screens.details.DetailsScreen
import me.lakhtin.firstlesson.ui.screens.home.HomeScreen

@Composable
fun NavigationActivity(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val navigateFunction: (Route) -> Unit = { navigateTo ->
        when (navigateTo) {
            is Route.NavigationUp -> navController.navigateUp()

            else -> navController.navigate(navigateTo)
        }
    }

    NavHost(
        navController = navController,
        startDestination = Route.HomeRoute,
        modifier = modifier
    ) {
        composable<Route.HomeRoute> {
            HomeScreen(navigateFunction)
        }
        composable<Route.DetailRoute>(
            deepLinks = listOf(
                navDeepLink<Route.DetailRoute>(
                    basePath = "smartkeyboard://details"
                )
            )
        ) { stackEntry ->
            DetailsScreen(
                navigateFunction,
                stackEntry.toRoute()
            )
        }
    }
}
