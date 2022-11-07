package com.ramanie.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeFragment(
    // we're passing the navController param bc this frag needs to navigate us to the detail screen
    // and the navController is necessary for that
    navController: NavController){

    var navigationArgument by remember {
        mutableStateOf("")
    }

    Column(verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)) {
        TextField(value = navigationArgument, maxLines = 1, onValueChange = {
            navigationArgument = it
        }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.fillMaxHeight(0.02f))
        Button(onClick = {
            navController.navigate(
                // the arg.s have to be passed in order, as they've been added to the route
                route = Destinations.Detail.withArgs(navigationArgument))
        }, modifier = Modifier.align(Alignment.End)) {
            Text(text = stringResource(id = R.string.next))
        }
    }
}