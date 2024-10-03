package com.example.calculator

import androidx.compose.foundation.layout.Box
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.unit.dp


@Composable
fun CalculatorButton(
    symbol: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(color)
            .clickable {
                onClick() // for onaction
            }
            .then(modifier)
    ) {
        Text(
            text = symbol,
            Modifier.padding(14.dp),
            fontSize = 50.sp,
            color = Color.Yellow
        )
    }
}


