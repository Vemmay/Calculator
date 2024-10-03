package com.example.calculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlin.math.sqrt

class CalculatorViewModel: ViewModel() {
    var state by mutableStateOf(CalculatorState())

    fun onAction(action: CalculatorAction) {
        when(action) {
            is CalculatorAction.Number -> numberInput(action.number)
            is CalculatorAction.Operation -> operationInput(action.operation)
            is CalculatorAction.Decimal -> decimalInput()
            is CalculatorAction.Calculate -> calculate()
        }
    }

    private fun calculate() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()
        if(number1 != null && number2 != null) {
            val result = when(state.operation) {
                is CalculatorOperation.Add -> number1 + number2
                is CalculatorOperation.Subtract -> number1 - number2
                is CalculatorOperation.Multiply -> number1 * number2
                is CalculatorOperation.Divide -> number1 / number2
                is CalculatorOperation.Sqrt -> sqrt(number1)
                null -> return

            }
            state = state.copy(
                result = result.toString().take(15),
                number1 = "",
                number2 = "",
                operation = null
            )
        }
    }

    private fun numberInput(number:Int){
        state = state.copy(
            result = ""
        )
        if(state.operation == null) {
            if(state.number1.length >= 8) {
                return
            }
            state = state.copy(
                number1 = state.number1 + number
            )
            return
        }
        if(state.number2.length >= 8) {
            return
        }
        state = state.copy(
            number2 = state.number2 + number
        )
    }

    private fun decimalInput(){
        if(state.operation == null && !state.number1.contains(".") && state.number1.isNotBlank()) {
            state = state.copy(
                number1 = state.number1 + "."
            )
            return
        } else if(!state.number2.contains(".") && state.number2.isNotBlank()) {
            state = state.copy(
                number2 = state.number2 + "."
            )
        }
    }

    private fun operationInput(operand: CalculatorOperation){
        if(state.number1.isNotBlank()) {
            state = state.copy(operation = operand)
        }

    }
}