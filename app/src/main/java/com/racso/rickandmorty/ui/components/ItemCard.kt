package com.racso.rickandmorty.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.racso.basiccodelabcompose.data.models.Location
import com.racso.basiccodelabcompose.data.models.Origin
import com.racso.basiccodelabcompose.data.models.Result
import com.racso.rickandmorty.utils.CustomPreview
import coil.compose.AsyncImage


@Composable
fun ItemCard(item: Result) {

    var showDetail by rememberSaveable{ mutableStateOf(false) }

    ElevatedCard(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 5.dp, horizontal = 10.dp)) {
        Row() {
            AsyncImage(model = item.image, contentDescription = "")
            Column(
                modifier = Modifier.padding(10.dp),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        modifier = Modifier.width(120.dp),
                        text = item.name, style = MaterialTheme.typography.titleMedium, maxLines = 1, overflow = TextOverflow.Ellipsis)
                    Button(onClick = { showDetail = !showDetail }) {
                        if (showDetail){
                            Text(text = "Hide Detail")
                            //Icon(Icons.Filled.KeyboardArrowUp, contentDescription = "")
                        }else{
                            Text(text = "Show Detail")
                            //Icon(Icons.Filled.KeyboardArrowDown, contentDescription = "")
                        }
                    }
                }

            }
        }
        AnimatedVisibility(showDetail){
            Column(
                modifier = Modifier.padding(10.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(text = "Status: ${item.status}")
                Text(text = "Species: ${item.species}")
                Text(text = "Type: ${item.type}")
                Text(text = "Gender: ${item.gender}")
                Text(text = "Origin: ${item.origin.name}", maxLines = 1, overflow = TextOverflow.Ellipsis)
                Text(text = "Location: ${item.location.name}", maxLines = 1, overflow = TextOverflow.Ellipsis)
            }
        }
    }
}


@Preview(showBackground = true, widthDp = 320, heightDp = 400)
@Composable
fun ItemCardPreview() {
    ItemCard(Result("",
    listOf(""),
    "gender",
    1,
    "",
    Location("",""),
    "name",
    Origin("", ""),
    "val species: String",
    "val status: String",
   "",
    "val url: String"
    ))
}