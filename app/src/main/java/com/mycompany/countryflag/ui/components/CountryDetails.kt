package com.mycompany.countryflag.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.gson.Gson
import com.mycompany.countryflag.models.Country
import com.mycompany.countryflag.ui.theme.CountryFlagTheme

@Composable
fun CountryDetails(
    encodedCountry: String
) {
    val country = decodedCountry(encodedCountry)
    Column(modifier = Modifier.padding(24.dp)) {
        Image(
            painter = painterResource(
                id = LocalContext.current.resources.getIdentifier(
                    country.code,
                    "drawable",
                    LocalContext.current.packageName
                )
            ),
            contentDescription = null
        )
        Text(country.name, style = TextStyle(fontSize = 48.sp))
        Text(country.description)
    }

}

private fun decodedCountry(encodedCountry: String): Country {
    return Gson().fromJson(encodedCountry,Country::class.java)
}

@Preview(showBackground = true)
@Composable
fun CountryDetailsPreview() {
    CountryFlagTheme {
        CountryDetails("")
    }
}