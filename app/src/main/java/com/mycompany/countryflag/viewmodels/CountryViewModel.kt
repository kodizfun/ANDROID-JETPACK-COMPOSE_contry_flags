package com.mycompany.countryflag.viewmodels

import androidx.lifecycle.ViewModel
import com.mycompany.countryflag.models.Country
import com.mycompany.countryflag.services.CountryService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CountryViewModel: ViewModel() {
    private val countryService: CountryService = CountryService()
    private val _countries: MutableStateFlow<List<Country>> = MutableStateFlow(listOf())
    var countries: StateFlow<List<Country>> = _countries.asStateFlow()

    fun getCountries() {
        _countries.value = countryService.fetchCountries()
    }
}