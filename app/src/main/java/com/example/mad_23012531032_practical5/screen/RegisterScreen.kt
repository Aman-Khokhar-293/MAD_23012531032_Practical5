package com.example.mad_23012531032_practical5.screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mad_23012531032_practical5.R
import com.example.mad_23012531032_practical5.screen.components.FormField
@Composable
fun RegisterUI(navController: NavHostController) {
    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.guni_pink_logo),
            contentDescription = "GUNI Logo",
            modifier = Modifier
                .padding(top = 50.dp, bottom = 30.dp)
                .height(130.dp)
        )

        // Card-like box
        Card(
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFECECF8)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Name",
                        fontSize = 16.sp,
                        modifier = Modifier.width(90.dp)
                    )
                    FormField(
                        label = "Name",
                        textState = name,
                        onTextChange = { name = it }
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Phone Number",
                        fontSize = 16.sp,
                        modifier = Modifier.width(90.dp)
                    )
                    FormField(
                        label = "Phone Number",
                        textState = phone,
                        onTextChange = { phone = it },
                        isNumber = true
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "City",
                        fontSize = 16.sp,
                        modifier = Modifier.width(90.dp)
                    )
                    FormField(
                        label = "City",
                        textState = city,
                        onTextChange = { city = it }
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Email",
                        fontSize = 16.sp,
                        modifier = Modifier.width(90.dp)
                    )
                    FormField(
                        label = "Email",
                        textState = email,
                        onTextChange = { email = it }
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row (
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Password",
                        fontSize = 16.sp,
                        modifier = Modifier.width(90.dp)
                    )
                    FormField(
                        label = "Password",
                        textState = password,
                        onTextChange = { password = it },
                        isPasswordFiled = true
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row (
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Confirm Password",
                        fontSize = 16.sp,
                        modifier = Modifier.width(90.dp)
                    )
                    FormField(
                        label = "Confirm Password",
                        textState = confirmPassword,
                        onTextChange = { confirmPassword = it },
                        isPasswordFiled = true
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = {
                        Toast.makeText(context, "Registered Successfully", Toast.LENGTH_SHORT).show()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0D47A1))
                ) {
                    Text(
                        text = "Register",
                        fontSize = 18.sp
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))


        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Already have an account? ",
                color = Color.Black,
                fontSize = 16.sp
            )
            Text(
                text = "SIGN IN",
                color = Color(0xFFE91E63),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {
                    navController.navigate("login")
                }
            )
        }
    }
}