package com.racso.rickandmorty.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.racso.basiccodelabcompose.data.models.Result
import com.racso.rickandmorty.ui.components.ItemCard
import com.racso.rickandmorty.utils.CustomPreview



@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val characters = viewModel.characters.observeAsState().value

    Column(modifier = modifier.fillMaxSize()){
        LazyColumn {
            items(characters!!) { item ->
                ItemCard(item)
            }
        }
    }
}


@CustomPreview
@Composable
fun CharactersListScreenPreview() {
    HomeScreen()
}