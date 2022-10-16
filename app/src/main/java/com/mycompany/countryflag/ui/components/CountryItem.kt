package com.mycompany.countryflag.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
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
import com.mycompany.countryflag.ui.theme.CountryFlagTheme

@Composable
fun CountryItem(
    countryName: String,
    countryCode: String,
    countryDescription: String = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
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
                            countryCode,
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
                    Text(text = countryName, style = TextStyle(fontWeight = FontWeight.Bold))
                    Text(text = countryCode.uppercase())
                }

                OutlinedButton(
                    onClick = { shouldExpand = !shouldExpand }
                ) {
                    Text(if (shouldExpand) "Show less" else "Show more")
                }
            }
            if (shouldExpand) {
                Text(
                    modifier = Modifier.padding(top = 8.dp),
                    style = TextStyle(textAlign = TextAlign.Justify),
                    text = countryDescription
                )
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