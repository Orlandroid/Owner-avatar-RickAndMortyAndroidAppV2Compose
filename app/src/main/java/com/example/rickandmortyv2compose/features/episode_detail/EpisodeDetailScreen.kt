package com.example.rickandmortyv2compose.features.episode_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.rickandmortyv2compose.R
import com.example.rickandmortyv2compose.features.base.BaseView
import com.example.rickandmortyv2compose.features.componets.ItemKeyValue
import com.example.rickandmortyv2compose.features.componets.ToolbarConfiguration
import com.example.rickandmortyv2compose.features.episodes.EpisodesViewModel
import com.example.rickandmortyv2compose.ui.theme.AlwaysWhite


@Composable
fun EpisodeDetailScreen(navController: NavController) {
    val viewModel: EpisodesViewModel = hiltViewModel()
    BaseView(
        background = AlwaysWhite,
        navController = navController,
        toolbarConfiguration = ToolbarConfiguration(
            isWithBackIcon = true, title = stringResource(id = R.string.episode_detail)
        )
    ) {
        val locationsImage = painterResource(id = R.drawable.morty_and_rick)
        ConstraintLayout(
            Modifier
                .fillMaxSize()
        ) {
            val (imageEpisode, layoutInfoEpisode) = createRefs()
            Image(
                painter = locationsImage,
                contentDescription = null,
                Modifier.constrainAs(imageEpisode) {
                    top.linkTo(parent.top, 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            )
            Column(
                Modifier
                    .padding(horizontal = 16.dp)
                    .constrainAs(layoutInfoEpisode) {
                        top.linkTo(imageEpisode.bottom, 16.dp)
                        start.linkTo(parent.start, 16.dp)
                        end.linkTo(parent.end, 16.dp)
                    }
            ) {
                ItemKeyValue(
                    key = "Episode name",
                    value = "Close Rick-counter of the Rick Kind",
                    textSize = 16.sp
                )
                ItemKeyValue(key = "Episode number", value = "S01E10", textSize = 16.sp)
                ItemKeyValue(key = "Episode date", value = "April 7 2014", textSize = 16.sp)
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun EpisodeDetailScreenPreview() {
    EpisodeDetailScreen(rememberNavController())
}