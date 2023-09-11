package com.vikravch.cellcomexam.core_ui.components

import com.vikravch.cellcomexam.core_ui.R

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

sealed interface FilterMode{
    object Popular: FilterMode
    object BroadcastNow: FilterMode
    object Favourite: FilterMode
}
@Composable
fun FilterSwitcher(
    modifier: Modifier = Modifier,
    selected: FilterMode,
    onSwitch: (FilterMode) -> Unit
) {
    val activeModifier = Modifier
        .background(
            color = Black,
            shape = RoundedCornerShape(8.dp),
        )
        .width(100.dp)
        .height(24.dp)

    val unactiveModifier = Modifier
        .background(
            color = White,
            shape = RoundedCornerShape(8.dp),
        )
        .width(100.dp)
        .height(24.dp)

    Row(modifier = modifier
        .height(52.dp)
        .background(
            shape = RoundedCornerShape(8.dp),
            color = White
        )
        .border(2.dp, White, RoundedCornerShape(20.dp))
        .padding(end = 20.dp)

        , verticalAlignment = Alignment.CenterVertically) {
        Row(modifier = Modifier
            .background(
                color = White,
                shape = RoundedCornerShape(8.dp),
            )
            .fillMaxWidth()) {
            Box(
                modifier = (if (selected == FilterMode.Popular) activeModifier else unactiveModifier)
                    .clickable {
                        onSwitch(FilterMode.Popular)
                    }
                    .fillMaxWidth(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(text = stringResource(id = R.string.popular_filter_tab),
                    textAlign = TextAlign.Center,
                    fontSize = 10.sp,
                    color = if(selected == FilterMode.Popular) White else Black,
                    modifier = Modifier
                        .width(100.dp))
            }
            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier = (if (selected == FilterMode.BroadcastNow) activeModifier else unactiveModifier)
                    .clickable {
                        onSwitch(FilterMode.BroadcastNow)
                    }
                    .fillMaxWidth(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(text = stringResource(id = R.string.broadcast_now_filter_tab),
                    textAlign = TextAlign.Center,
                    fontSize = 10.sp,
                    color = if(selected == FilterMode.BroadcastNow) White else Black,
                    modifier = Modifier
                        .width(100.dp))
                }
            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier = (if(selected == FilterMode.Favourite) activeModifier else unactiveModifier).clickable {
                    onSwitch(FilterMode.Favourite)
                },
                contentAlignment = Alignment.Center
            ) {
                Text(text = stringResource(id = R.string.my_favourites_filter_tab),
                    textAlign = TextAlign.Center,
                    fontSize = 10.sp,
                    color = if(selected == FilterMode.Favourite) White else Black,
                    modifier = Modifier
                        .width(100.dp))
            }
        }
    }

}

@Preview
@Composable
fun EdenSwitcherPreview0() {
    FilterSwitcher(
        modifier = Modifier
            .fillMaxWidth()
            .background(White),
        onSwitch = {},
        selected = FilterMode.Popular
    )
}

@Preview
@Composable
fun EdenSwitcherPreview1() {
    FilterSwitcher(
        modifier = Modifier
            .fillMaxWidth()
            .background(White),
        onSwitch = {},
        selected = FilterMode.BroadcastNow
    )
}

@Preview
@Composable
fun EdenSwitcherPreview2() {
    FilterSwitcher(
        modifier = Modifier
            .fillMaxWidth()
            .background(White),
        onSwitch = {},
        selected = FilterMode.Favourite
    )
}