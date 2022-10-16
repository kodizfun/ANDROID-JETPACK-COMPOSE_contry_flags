package com.mycompany.countryflag.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mycompany.countryflag.ui.theme.CountryFlagTheme

@Composable
fun CountryItem(
    countryName: String,
    countryCode: String
) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row {
            Image(
                painter = painterResource(
                    id = LocalContext.current.resources.getIdentifier(
                        countryCode,
                        "drawable",
                        LocalContext.current.packageName
                    )
                ),
                contentDescription = null,
                modifier = Modifier.width(60.dp)
            )
            Column(modifier = Modifier.padding(start = 8.dp)) {
                Text(
                    text = countryName,
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )
                Text(text = countryCode.uppercase())
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CountryItemPreview() {
    CountryFlagTheme {
        CountryItem(
            countryName = "France",
            countryCode = "fra"
        )
    }
}