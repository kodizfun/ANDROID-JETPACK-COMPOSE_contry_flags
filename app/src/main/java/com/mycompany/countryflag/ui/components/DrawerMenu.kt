package com.mycompany.countryflag.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mycompany.countryflag.ui.theme.CountryFlagTheme

@Composable
fun DrawerMenu() {
    Column(modifier = Modifier.padding(24.dp)) {

        Text(text = "Country Flag", style = TextStyle(fontSize = 48.sp))
        Spacer(modifier = Modifier.height(20.dp))
        Divider()
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Icon(Icons.Default.List, contentDescription = null, tint = MaterialTheme.colors.primary)
            Spacer(modifier = Modifier.width(20.dp))
            Text(text = "European flags", color = MaterialTheme.colors.primary)
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Icon(Icons.Default.List, contentDescription = null, tint = MaterialTheme.colors.primary)
            Spacer(modifier = Modifier.width(20.dp))
            Text(text = "South American flags", color = MaterialTheme.colors.primary)
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Icon(Icons.Default.Settings, contentDescription = null, tint = MaterialTheme.colors.primary)
            Spacer(modifier = Modifier.width(20.dp))
            Text(text = "Settings", color = MaterialTheme.colors.primary)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DrawerMenuPreview() {
    CountryFlagTheme {
        DrawerMenu()
    }
}