package com.ramanie.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation(modifier: Modifier = Modifier.fillMaxSize()){
    // we'll use this to navigate to diff. frag.s and pass arg.s to destinations
    val navController = rememberNavController()

    NavHost(modifier = modifier, navController = navController, startDestination = Destinations.Home.route){
        // we can describe our destinations to the navHost here, using the composables
        composable(route = Destinations.Home.route){
            // in here's where we define the composable fun. for this route
            HomeFragment(navController = navController)
        }
        composable(
            // we're passing an arg. to the route
//            route = Destinations.Detail.route + "/{"+ Arguments.DetailFragmentArgument.argument +"}/{" + Arguments.DetailFragmentArgument.argument + "}"
            // with the line below we can pass an optional argument, and if the arg isn't passed then the default val. we specify will be passed
//            route = Destinations.Detail.route + "?" + Arguments.DetailFragmentArgument.argument + "={"+ Arguments.DetailFragmentArgument.argument +"}",
            route = Destinations.Detail.route + "/{"+ Arguments.DetailFragmentArgument.argument +"}",
            arguments = listOf(navArgument(Arguments.DetailFragmentArgument.argument) {
                type = NavType.StringType
                nullable = false
                defaultValue = "No Detail"
        })){
            DetailsFragment(detail = it.arguments?.getString(Arguments.DetailFragmentArgument.argument))
        }
    }
}