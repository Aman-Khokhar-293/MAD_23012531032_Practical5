package com.example.mad_23012531032_practical5.screen.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun FormField(
    label: String,
    textState: String,
    onTextChange: (String) -> Unit,
    isPasswordFiled: Boolean = false,
    isNumber: Boolean = false
){
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        if (!isNumber){
            OutlinedTextField(
                value = textState,
                onValueChange = onTextChange,
                textStyle = LocalTextStyle.current.copy(fontSize = 20.sp),
                visualTransformation = (
                        if (isPasswordFiled) PasswordVisualTransformation() else VisualTransformation.None
                        ),
                label = { Text("Enter $label") },
                placeholder = { Text("Enter $label") },
                modifier = Modifier.fillMaxWidth()
            )
        } else {
            NumericOutlinedTextField(
                label = label,
                value = textState,
                onValueChange = onTextChange,
                modifier = Modifier
                    .fillMaxWidth()

            )
        }
    }
}

@Composable
fun NumericOutlinedTextField(
    label: String,
    value: String,
    modifier: Modifier,
    onValueChange:(String)-> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = {
            newText -> if (newText.all { it.isDigit() }){
                onValueChange(newText)
            }
        },
        modifier = modifier,
        textStyle = LocalTextStyle.current.copy(fontSize = 18.sp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        label = { Text("Enter $label") },
    )
}

@Preview(showBackground = true)
@Composable
fun FormFieldPreview(){
    FormField(label = "Name", textState = "", onTextChange = {})
}