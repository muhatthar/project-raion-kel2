package com.example.remind.screen.onboard

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.remind.R
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import com.example.remind.ui.theme.Typography
import com.example.remind.ui.theme.Colors
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RegisterScreen(navController: NavController){
    Box(modifier = Modifier.background(brush = Brush.verticalGradient(
        colors = listOf(Colors.Primary500, Colors.Neutral0),
        startY = 0.7f,
        endY = Float.POSITIVE_INFINITY
    ))){
        Scaffold(
            topBar = {
                TopAppBar(
                    backgroundColor = Color.Transparent,
                    contentColor = Color.White,
                    elevation = 0.dp
                ){
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(
                            onClick = { /*TODO*/ }
                        ){
                            Icon(
                                painter = painterResource(id = R.drawable.back_btn),
                                contentDescription = "BackButton",
                                modifier = Modifier.size(24.dp)
                            )
                        }
                        Image(
                            painter = painterResource(id = R.drawable.logo_1),
                            contentDescription = "LogoTopBar",
                            modifier = Modifier.size(width = 119.dp, height = 24.dp)
                        )
                    }
                }
            },
            backgroundColor = Color.Transparent
        ){
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                val (amico, rect) = createRefs()
                Image(
                    painter = painterResource(id = R.drawable.amico),
                    contentDescription = "Amico",
                    modifier = Modifier
                        .size(140.dp)
                        .constrainAs(amico) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(550.dp)
                        .constrainAs(rect) {
                            top.linkTo(amico.bottom, margin = 16.53.dp)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                        .background(
                            color = Colors.Neutral50,
                            RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp)
                        )
                ){
                    ConstraintLayout(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(32.dp)
                    ) {
                        val (email, emailform, uname, unameform, passwd, passwdform, passwdconfirm, passwdconfirmform, daftarbtn, masuktext) = createRefs()

                        Text(text = "Email",
                            style = Typography.body14_regular,
                            color = Colors.Shades300,
                            modifier = Modifier
                                .constrainAs(email){}
                        )

                        var emailvalue by remember { mutableStateOf("") }
                        TextField(
                            modifier = Modifier
                                .constrainAs(emailform) {
                                    top.linkTo(email.bottom, margin = 13.dp)
                                }
                                .fillMaxWidth()
                                .height(51.dp)
                                .background(
                                    Colors.Neutral100,
                                    RoundedCornerShape(13.dp)
                                ),
                            value = emailvalue,
                            onValueChange = { emailvalue = it },
                            placeholder = {Text("youremail@gmail.com")},
                            maxLines = 1,
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Email
                            ),
                            textStyle = TextStyle(
                                color = Colors.Shades300,
                                fontFamily =  FontFamily(Font(R.font.poppins_regular)),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal
                            )
                        )

                        Text(text = "Username",
                            style = Typography.body14_regular,
                            color = Colors.Shades300,
                            modifier = Modifier
                                .constrainAs(uname){
                                    top.linkTo(emailform.bottom, margin = 15.dp)
                                }
                        )

                        var unamevalue by remember { mutableStateOf("") }
                        TextField(
                            modifier = Modifier
                                .constrainAs(unameform) {
                                    top.linkTo(uname.bottom, margin = 13.dp)
                                }
                                .fillMaxWidth()
                                .height(51.dp)
                                .background(
                                    Colors.Neutral100,
                                    RoundedCornerShape(13.dp)
                                ),
                            value = unamevalue,
                            onValueChange = { unamevalue = it },
                            placeholder = {Text("yourUsername")},
                            maxLines = 1,
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Email
                            ),
                            textStyle = TextStyle(
                                color = Colors.Shades300,
                                fontFamily =  FontFamily(Font(R.font.poppins_regular)),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal
                            )
                        )

                        Text(text = "Password",
                            style = Typography.body14_regular,
                            color = Colors.Shades300,
                            modifier = Modifier
                                .constrainAs(passwd){
                                    top.linkTo(unameform.bottom, margin = 15.dp)
                                }
                        )

                        var passwdvalue by remember { mutableStateOf("") }
                        TextField(
                            modifier = Modifier
                                .constrainAs(passwdform) {
                                    top.linkTo(passwd.bottom, margin = 13.dp)
                                }
                                .fillMaxWidth()
                                .height(51.dp)
                                .background(
                                    Colors.Neutral100,
                                    RoundedCornerShape(13.dp)
                                ),
                            value = passwdvalue,
                            onValueChange = { passwdvalue = it },
                            placeholder = {Text("yourPassword")},
                            maxLines = 1,
                            visualTransformation = PasswordVisualTransformation(),
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Password
                            ),
                            textStyle = TextStyle(
                                color = Colors.Shades300,
                                fontFamily =  FontFamily(Font(R.font.poppins_regular)),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal
                            )
                        )

                        Text(text = "Konfirmasi Password",
                            style = Typography.body14_regular,
                            color = Colors.Shades300,
                            modifier = Modifier
                                .constrainAs(passwdconfirm){
                                    top.linkTo(passwdform.bottom, margin = 15.dp)
                                }
                        )

                        var passwdconfirmvalue by remember { mutableStateOf("") }
                        TextField(
                            modifier = Modifier
                                .constrainAs(passwdconfirmform) {
                                    top.linkTo(passwdconfirm.bottom, margin = 13.dp)
                                }
                                .fillMaxWidth()
                                .height(51.dp)
                                .background(
                                    Colors.Neutral100,
                                    RoundedCornerShape(13.dp)
                                ),
                            value = passwdconfirmvalue,
                            onValueChange = { passwdconfirmvalue = it },
                            placeholder = {Text("yourPasswordAgain")},
                            maxLines = 1,
                            visualTransformation = PasswordVisualTransformation(),
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Password
                            ),
                            textStyle = TextStyle(
                                color = Colors.Shades300,
                                fontFamily =  FontFamily(Font(R.font.poppins_regular)),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal
                            )
                        )

                        Button(onClick = {
//                            navController.navigate("register")
                        },
                            shape = RoundedCornerShape(13),
                            modifier = Modifier
                                .constrainAs(daftarbtn) {
                                    top.linkTo(passwdconfirmform.bottom, margin = 24.dp)
                                }
                                .fillMaxWidth()
                                .height(60.dp),
                            colors = ButtonDefaults.buttonColors(backgroundColor = Colors.Primary500)
                        ) {
                            Text(text = "Daftar", style = Typography.h6_bold, color = Colors.Neutral50)
                        }

                        Row(
                            modifier = Modifier
                                .constrainAs(masuktext) {
                                    top.linkTo(daftarbtn.bottom, margin = 15.dp)
                                }
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Sudah punya akun? ",
                                style = Typography.body14_regular
                            )
                            Text(
                                text = "Masuk",
                                style = Typography.body14_semibold,
                                textDecoration = TextDecoration.Underline,
                                color = Colors.Secondary900,
                                modifier = Modifier.clickable {
                                    navController.navigate("login")
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
//
//@Preview(showSystemUi = true)
//@Composable
//fun RegisterPreview(){
//    RegisterScreen()
//}