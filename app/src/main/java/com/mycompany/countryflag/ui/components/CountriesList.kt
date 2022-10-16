package com.mycompany.countryflag.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.mycompany.countryflag.models.Country
import com.mycompany.countryflag.ui.theme.CountryFlagTheme

@Composable
fun CountriesList(
    navHostController: NavHostController
) {
    LazyColumn {
        item { CountryItem(country = Country(name = "Austria", code = "aut"), navHostController = navHostController) }
        item { CountryItem(country = Country(name = "Belgium", code = "bel"), navHostController = navHostController) }
        item { CountryItem(country = Country(name = "France", code = "fra"), navHostController = navHostController) }
        item { CountryItem(country = Country(name = "Germany", code = "deu"), navHostController = navHostController) }
        item { CountryItem(country = Country(name = "Greece", code = "grc"), navHostController = navHostController) }
        item { CountryItem(country = Country(name = "Italy", code = "ita"), navHostController = navHostController) }
        item { CountryItem(country = Country(name = "Norway", code = "nor"), navHostController = navHostController) }
        item { CountryItem(country = Country(name = "Portugal", code = "prt"), navHostController = navHostController) }
        item { CountryItem(country = Country(name = "Spain", code = "esp"), navHostController = navHostController) }
        item { CountryItem(country = Country(name = "Sweden", code = "swe"), navHostController = navHostController) }
    }
}

@Preview(showBackground = true)
@Composable
fun CountriesListScreenPreview() {
    CountryFlagTheme {
        CountriesList(navHostController = NavHostController(context = LocalContext.current ))
    }
}