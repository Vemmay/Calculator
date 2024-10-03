package com.example.calculator

sealed class CalculatorOperation(val symbol: String) {
    object Add : CalculatorOperation("+")
    object Subtract : CalculatorOperation("-")
    object Multiply : CalculatorOperation("*")
    object Divide : CalculatorOperation("/")
    object Sqrt : CalculatorOperation("sqrt")
}

sealed class CalculatorAction {
    data class Number(val number: Int): CalculatorAction()
    data class Operation(val operation: CalculatorOperation): CalculatorAction()
    object Calculate: CalculatorAction()
    object Decimal: CalculatorAction()
}

data class CalculatorState(
    val number1: String = "",
    val number2: String = "",
    val result: String = "",
    val operation: CalculatorOperation? = null
)
