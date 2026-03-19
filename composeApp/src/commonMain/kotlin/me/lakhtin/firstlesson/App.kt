package me.lakhtin.firstlesson

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun App(navController: NavHostController = rememberNavController()) {
    MaterialTheme {
        ContentNavigation(navController = navController)
    }
}

@Composable
fun ContentNavigation(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    NavigationActivity(
        navController = navController,
        modifier = modifier
    )
}