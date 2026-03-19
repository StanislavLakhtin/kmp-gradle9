package me.lakhtin.firstlesson.ui.screens.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.lakhtin.firstlesson.nav.Route

@Composable
fun DetailsScreen(
    navigateTo: (Route) -> Unit,
    route: Route.DetailRoute
) {
    DetailsScreenView(navigateTo = navigateTo, route = route)
}

@Composable
fun DetailsScreenView(
    navigateTo: (Route) -> Unit,
    route: Route.DetailRoute,
) {
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(top = 48.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { navigateTo(Route.NavigationUp) }) {
            Text("Back")
        }
        Text("Compose details: ${route.id}")
    }
}

@Composable
@Preview
fun DetailsScreenPreview() {
    DetailsScreenView(
        navigateTo = {},
        route = Route.DetailRoute("1")
    )
}