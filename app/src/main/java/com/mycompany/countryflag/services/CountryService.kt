package com.mycompany.countryflag.services

import com.mycompany.countryflag.models.Country

class CountryService {

    fun fetchCountries(): List<Country> {
        return listOf(
            Country(name = "Austria", code = "aut"),
            Country(name = "Belgium", code = "bel"),
            Country(name = "France", code = "fra"),
            Country(name = "Germany", code = "deu"),
            Country(name = "Greece", code = "grc"),
            Country(name = "Italy", code = "ita"),
            Country(name = "Norway", code = "nor"),
            Country(name = "Portugal", code = "prt"),
            Country(name = "Spain", code = "esp"),
            Country(name = "Sweden", code = "swe")
        ).shuffled()
    }

}