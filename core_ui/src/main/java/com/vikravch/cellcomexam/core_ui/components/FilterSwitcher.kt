package com.vikravch.cellcomexam.core_ui.components

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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FilterSwitcher(
    modifier: Modifier = Modifier,
    text: String = "Filter by:",
    selected: Int,
    onSwitch: (Int) -> Unit
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

    Row(modifier = modifier.height(52.dp)
        .background(
            shape = RoundedCornerShape(8.dp),
            color = White
        )
        .border(2.dp, White, RoundedCornerShape(20.dp))
        .padding(end = 20.dp)

        , verticalAlignment = Alignment.CenterVertically) {
        Text(text =text, modifier = Modifier.padding(start = 20.dp))
        Spacer(modifier = Modifier.weight(1f))
        Row(modifier = Modifier
            .background(
                color = White,
                shape = RoundedCornerShape(8.dp),
            )) {
            Box(
                modifier = (if(selected == 0) activeModifier else unactiveModifier).clickable {
                    onSwitch(0)
                },
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Popular",
                    textAlign = TextAlign.Center,
                    fontSize = 10.sp,
                    color = if(selected == 0) White else Black,
                    modifier = Modifier
                        .width(100.dp))
            }
            Box(
                modifier = (if(selected == 1) activeModifier else unactiveModifier).clickable {
                    onSwitch(1)
                },
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Broadcast NOW",
                    textAlign = TextAlign.Center,
                    fontSize = 10.sp,
                    color = if(selected == 1) White else Black,
                    modifier = Modifier
                        .width(100.dp))
                }
            Box(
                modifier = (if(selected == 2) activeModifier else unactiveModifier).clickable {
                    onSwitch(2)
                },
                contentAlignment = Alignment.Center
            ) {
                Text(text = "My favorites",
                    textAlign = TextAlign.Center,
                    fontSize = 10.sp,
                    color = if(selected == 2) White else Black,
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
        text = "Filter by:",
        onSwitch = {},
        selected = 0
    )
}

@Preview
@Composable
fun EdenSwitcherPreview1() {
    FilterSwitcher(
        modifier = Modifier
            .fillMaxWidth()
            .background(White),
        text = "Filter by:",
        onSwitch = {},
        selected = 1
    )
}

@Preview
@Composable
fun EdenSwitcherPreview2() {
    FilterSwitcher(
        modifier = Modifier
            .fillMaxWidth()
            .background(White),
        text = "Filter by:",
        onSwitch = {},
        selected = 2
    )
}