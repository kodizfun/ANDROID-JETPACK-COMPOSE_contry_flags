package com.mycompany.countryflag.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.mycompany.countryflag.ui.components.CountryCell
import com.mycompany.countryflag.ui.theme.CountryFlagTheme

@Composable
fun CountriesListScreen() {
    LazyColumn {
        item { CountryCell(countryName = "Austria", countryCode = "aut") }
        item { CountryCell(countryName = "Belgium", countryCode = "bel") }
        item { CountryCell(countryName = "France", countryCode = "fra") }
        item { CountryCell(countryName = "Germany", countryCode = "deu") }
        item { CountryCell(countryName = "Greece", countryCode = "grc") }
        item { CountryCell(countryName = "Italy", countryCode = "ita") }
        item { CountryCell(countryName = "Norway", countryCode = "nor") }
        item { CountryCell(countryName = "Portugal", countryCode = "prt") }
        item { CountryCell(countryName = "Spain", countryCode = "esp") }
        item { CountryCell(countryName = "Sweden", countryCode = "swe") }
    }
}

@Preview(showBackground = true)
@Composable
fun CountriesListScreenPreview() {
    CountryFlagTheme {
        CountriesListScreen()
    }
}