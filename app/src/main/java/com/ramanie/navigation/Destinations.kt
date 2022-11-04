package com.ramanie.navigation

sealed class Destinations(val route: String){
    object Home: Destinations("home_screen")
    object Detail: Destinations("detail_screen")

    // the fun. below is a helper fun that'll be used to construct the full route(with arg.s)
    // NOTE the helper fun. will only work for a route with mandatory arg.s not optional(it'll fail with even a single optional arg.)
    fun withArgs(vararg args: String): String{
        return buildString {
            // we'll append the route first b4 adding the
            append(route)
            // then we're gon loop through the varargs and append all the args needed for the navigation to the destination
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}

sealed class Arguments(val argument: String){
    object DetailFragmentArgument: Arguments("detailFragmentArgument")
}
