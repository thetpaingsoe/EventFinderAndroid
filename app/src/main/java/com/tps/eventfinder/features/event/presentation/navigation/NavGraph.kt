package com.tps.eventfinder.features.event.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.tps.eventfinder.features.event.presentation.event_list.EventListScreen
import com.tps.eventfinder.features.event.presentation.event_list.EventListViewModel


@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = "event_list") {
        composable("event_list") {
            val viewModel: EventListViewModel = hiltViewModel()
            EventListScreen(viewModel, navController)
        }

    }
}