package webapi.apis;


import io.jooby.annotations.*
import webapi.models.User
import webapi.models.Users

@Path("/")
@javax.annotation.Generated(value = ["org.openapitools.codegen.languages.KotlinServerCodegen"])
class UsersApi {

    private val userList = ArrayList<User>()

    init {
        userList.add(User(id = 1, name = "hoge"))
        userList.add(User(id = 2, name = "piyo"))
    }

    @GET
    @Produces("application/json")
    fun usersGet(): Users {
        return Users(users = userList)
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    fun usersIdGet(@PathParam("id") id: kotlin.Int): User {
        return userList.firstOrNull { it.id == id } ?: throw Exception("Not found")
    }

    @POST
    @Path("{id}")
    @Consumes("application/json")
    @Produces("application/json")
    fun usersIdPost(@PathParam("id") id: kotlin.Int, user: User): User {
        userList.removeIf { it.id == id }
        userList.add(user)
        return user
    }
}
