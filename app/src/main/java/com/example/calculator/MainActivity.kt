package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.CalculatorTheme
import androidx.activity.viewModels


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                val viewModel: CalculatorViewModel by viewModels<CalculatorViewModel>()
                val state = viewModel.state
                val buttonSpacing = 8.dp
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.DarkGray)
                        .padding(16.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.BottomCenter),
                        verticalArrangement = Arrangement.spacedBy(buttonSpacing),
                    ) {
                        Text(
                            text = state.result.ifBlank {
                                state.number1 + (state.operation?.symbol ?: "") + state.number2
                            },
                            textAlign = TextAlign.End,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 32.dp),
                            fontWeight = FontWeight.Light,
                            fontSize = 80.sp,
                            color = Color.White,
                            maxLines = 2
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                        ) {
                            CalculatorButton(
                                symbol = "1",

                            ) {
                                viewModel.onAction(CalculatorAction.Number(1))
                            }
                            CalculatorButton(
                                symbol = "2",
                            ) {
                                viewModel.onAction(CalculatorAction.Number(2))
                            }
                            CalculatorButton(
                                symbol = "3",
                            ) {
                                viewModel.onAction(CalculatorAction.Number(3))
                            }
                            CalculatorButton(
                                symbol = "+",
                            ) {
                                viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Add))
                            }
                            CalculatorButton(
                                symbol = "*",
                            ) {
                                viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Multiply))
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                        ) {
                            CalculatorButton(
                                symbol = "4",
                            ) {
                                viewModel.onAction(CalculatorAction.Number(4))
                            }
                            CalculatorButton(
                                symbol = "5",
                            ) {
                                viewModel.onAction(CalculatorAction.Number(5))
                            }
                            CalculatorButton(
                                symbol = "6",
                            ) {
                                viewModel.onAction(CalculatorAction.Number(6))
                            }
                            CalculatorButton(
                                symbol = "-",
                            ) {
                                viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Subtract))
                            }
                            CalculatorButton(
                                symbol = "/",
                            ) {
                                viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Divide))
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                        ) {
                            CalculatorButton(
                                symbol = "7",
                            ) {
                                viewModel.onAction(CalculatorAction.Number(7))
                            }
                            CalculatorButton(
                                symbol = "8",
                            ) {
                                viewModel.onAction(CalculatorAction.Number(8))
                            }
                            CalculatorButton(
                                symbol = "9",
                            ) {
                                viewModel.onAction(CalculatorAction.Number(9))
                            }
                            CalculatorButton(
                                symbol = "+",
                            ) {
                                viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Add))
                            }
                            CalculatorButton(
                                symbol = "sqrt",
                            ) {
                                viewModel.onAction(CalculatorAction.Operation(CalculatorOperation.Sqrt))
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                        ) {
                            CalculatorButton(
                                symbol = "0"
                            ) {
                                viewModel.onAction(CalculatorAction.Number(0))
                            }
                            CalculatorButton(
                                symbol = ".",
                            ) {
                                viewModel.onAction(CalculatorAction.Decimal)
                            }
                            CalculatorButton(
                                symbol = "=",
                            ) {
                                viewModel.onAction(CalculatorAction.Calculate)
                            }
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalculatorTheme {
    }
}