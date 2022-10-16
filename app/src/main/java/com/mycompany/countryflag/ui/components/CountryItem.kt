package com.mycompany.countryflag.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.gson.Gson
import com.mycompany.countryflag.models.Country
import com.mycompany.countryflag.ui.theme.CountryFlagTheme

@Composable
fun CountryItem(
    country: Country,
    navHostController: NavHostController
) {
    var shouldExpand by rememberSaveable { mutableStateOf(false) }

    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .animateContentSize()
    ) {

        Column(modifier = Modifier.padding(24.dp)) {
            Row {
                Image(
                    painter = painterResource(
                        id = LocalContext.current.resources.getIdentifier(
                            country.code,
                            "drawable",
                            LocalContext.current.packageName
                        )
                    ),
                    contentDescription = null,
                    modifier = Modifier.width(60.dp)
                )
                Column(
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .weight(1.0f)
                ) {
                    Text(text = country.name, style = TextStyle(fontWeight = FontWeight.Bold))
                    Text(text = country.code.uppercase())
                }

                OutlinedButton(
                    onClick = { shouldExpand = !shouldExpand }
                ) {
                    Text(if (shouldExpand) "Show less" else "Show more")
                }
            }
            if (shouldExpand) {
                Column {
                    Text(
                        modifier = Modifier.padding(top = 8.dp),
                        style = TextStyle(textAlign = TextAlign.Justify),
                        text = country.description
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            navHostController.navigate("countryDetails/${encodeCountry(country = country)}")
                        }
                    ) {
                        Text(text = "DETAILS")
                    }
                }
            }
        }
    }
}

private fun encodeCountry(country: Country): String {
    return Gson().toJson(country)
}

@Preview(showBackground = true)
@Composable
fun CountryItemPreview() {
    CountryFlagTheme {
        CountryItem(
            country = Country("France", "fra"),
            navHostController = rememberNavController()
        )
    }
}