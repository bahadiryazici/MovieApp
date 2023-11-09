package com.ahmet.movieapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ahmet.movieapp.presentation.movie_detail.views.MovieDetailScreen
import com.ahmet.movieapp.presentation.movies.views.MovieScreen
import com.ahmet.movieapp.presentation.ui.theme.MovieAppTheme
import com.ahmet.movieapp.util.Constants.IMDB_ID
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.MovieScreen.route){
                        composable(Screen.MovieScreen.route){
                            MovieScreen(navController = navController)
                        }
                        composable(Screen.MovieDetailScreen.route + "/{${IMDB_ID}}"){
                            MovieDetailScreen()
                        }
                    }
                }
            }
        }
    }
}
