package app

import io.jooby.Kooby
import io.jooby.json.JacksonModule
import io.jooby.runApp
import webapi.apis.UsersApi

class App : Kooby({
    install(JacksonModule())
    path("/users") {
        mvc(UsersApi())
    }

    get("/") {
        "Welcome to Jooby!"
    }
})

fun main(args: Array<String>) {
    runApp(args, App::class)
}
