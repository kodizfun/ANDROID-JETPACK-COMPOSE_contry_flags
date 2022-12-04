package com.mycompany.countryflag

import com.mycompany.countryflag.viewmodels.CountryViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mycompany.countryflag.ui.components.CountriesList
import com.mycompany.countryflag.ui.components.CountryDetails
import com.mycompany.countryflag.ui.components.DrawerMenu
import com.mycompany.countryflag.ui.theme.CountryFlagTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val viewModel: CountryViewModel = CountryViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.getCountries()

        setContent {
            val scaffoldState = rememberScaffoldState()
            val coroutineScope = rememberCoroutineScope()
            val navHostController = rememberNavController()
            CountryFlagTheme {
                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "Countries") },
                            navigationIcon = {
                                IconButton(
                                    onClick = {
                                        coroutineScope.launch {
                                            scaffoldState.drawerState.open()
                                        }
                                    },
                                ) {
                                    Icon(
                                        Icons.Rounded.Menu,
                                        contentDescription = ""
                                    )
                                }
                            },
                            actions = {
                                IconButton(
                                    onClick = {
                                        viewModel.getCountries()
                                    },
                                ) {
                                    Icon(
                                        Icons.Rounded.Refresh,
                                        contentDescription = ""
                                    )
                                }
                            }
                        )
                    },
                    drawerContent = {
                        DrawerMenu()
                    }
                ) {
                    NavHost(navController = navHostController, startDestination = "countriesList") {
                        composable("countriesList") { CountriesList(navHostController = navHostController, countryViewModel = viewModel) }
                        composable(
                            "countryDetails/{encodedCountry}",
                            arguments = listOf(navArgument("encodedCountry") { type = NavType.StringType })
                        ) { backStackEntry ->
                            CountryDetails(encodedCountry = backStackEntry.arguments?.getString("encodedCountry")!!)
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CountryFlagTheme {
        CountriesList(navHostController = NavHostController(context = LocalContext.current), countryViewModel = CountryViewModel())
    }
}