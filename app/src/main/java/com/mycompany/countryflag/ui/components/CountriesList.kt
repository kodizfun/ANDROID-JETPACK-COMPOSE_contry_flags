package com.mycompany.countryflag.ui.components

import com.mycompany.countryflag.viewmodels.CountryViewModel
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.mycompany.countryflag.ui.theme.CountryFlagTheme

@Composable
fun CountriesList(
    navHostController: NavHostController,
    countryViewModel: CountryViewModel
) {

    val countriesState by countryViewModel.countries.collectAsState()

    LazyColumn {
        items(countriesState) { country ->
            CountryItem(country = country, navHostController = navHostController)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CountriesListScreenPreview() {
    CountryFlagTheme {
        CountriesList(navHostController = NavHostController(context = LocalContext.current), countryViewModel = CountryViewModel())
    }
}