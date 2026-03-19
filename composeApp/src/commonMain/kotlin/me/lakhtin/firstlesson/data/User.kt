package me.lakhtin.firstlesson.data

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer

@Serializable
data class User (val name: String, val age: Int)

inline fun <reified T> Json.decode(jsonString: String): T {
    val serializer = serializer<T>()
    return this.decodeFromString(serializer, jsonString)
}

val json = """{"name": "Ivan", "age": 30}"""
val user = Json.decode<User>(json)
