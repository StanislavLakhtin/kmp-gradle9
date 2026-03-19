package me.lakhtin.firstlesson.nav

import kotlinx.serialization.Serializable

sealed class Route {
    @Serializable
    data object NavigationUp : Route()

    @Serializable
    data object HomeRoute : Route()
    @Serializable
    data class DetailRoute(val id: String) : Route()
}