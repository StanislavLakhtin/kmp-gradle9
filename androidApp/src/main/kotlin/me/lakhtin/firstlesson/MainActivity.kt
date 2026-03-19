package me.lakhtin.firstlesson

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.util.Consumer
import androidx.compose.runtime.DisposableEffect
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            DisposableEffect(Unit) {
                val listener = Consumer<Intent> { newIntent ->
                    navController.handleDeepLink(newIntent)
                }
                addOnNewIntentListener(listener)
                onDispose { removeOnNewIntentListener(listener) }
            }

            App(navController = navController)
        }
    }
}
