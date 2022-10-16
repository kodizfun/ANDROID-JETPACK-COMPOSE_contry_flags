package com.mycompany.countryflag.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.mycompany.countryflag.ui.theme.CountryFlagTheme

@Composable
fun CountriesList() {
    Column {
        CountryItem(countryName = "Austria", countryCode = "aut")
        CountryItem(countryName = "Belgium", countryCode = "bel")
        CountryItem(countryName = "France", countryCode = "fra")
        CountryItem(countryName = "Germany", countryCode = "deu")
        CountryItem(countryName = "Greece", countryCode = "grc")
        CountryItem(countryName = "Italy", countryCode = "ita")
        CountryItem(countryName = "Norway", countryCode = "nor")
        CountryItem(countryName = "Portugal", countryCode = "prt")
        CountryItem(countryName = "Spain", countryCode = "esp")
        CountryItem(countryName = "Sweden", countryCode = "swe")
    }
}

@Preview(showBackground = true)
@Composable
fun CountriesListPreview() {
    CountryFlagTheme {
        CountriesList()
    }
}