package com.example.mylogin

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(){
    var nrp by remember {
        mutableStateOf(value = "")
    }

    var password by remember {
        mutableStateOf(value = "")
    }

    var rememberMe by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.img), contentDescription = "Login Image", modifier = Modifier.size(200.dp))

        Text(text = "Mobile Programming Class", fontSize = 23.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Sign In with Your Account")

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = nrp, onValueChange = {nrp = it}, label = {
            Text(text = "NRP")
        })

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(value = password, onValueChange = {password = it}, label = {
            Text(text = "Password")
        }, visualTransformation = PasswordVisualTransformation())

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Spacer(modifier = Modifier.width(52.dp))

            Checkbox(
                checked = rememberMe,
                onCheckedChange = { rememberMe = it }
            )
            Text(
                text = "Stay Signed In",
                modifier = Modifier.clickable { rememberMe = !rememberMe }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { Log.i("Credential", "NRP: $nrp Password: $password") }) {
            Text(text = "Sign In")
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(text = "Forgot Password", modifier = Modifier.clickable{

        })

        Spacer(modifier = Modifier.height(32.dp))

        Text(text = "Or Sign In with")

        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(painter = painterResource(id = R.drawable.myits), contentDescription = "MyITS", modifier = Modifier.size(63.dp).clickable{

            })

            Image(painter = painterResource(id = R.drawable.sso), contentDescription = "SSO", modifier = Modifier.size(62.dp).clickable{

            })

            Image(painter = painterResource(id = R.drawable.google), contentDescription = "Google", modifier = Modifier.size(55.dp).clickable{

            })
        }
    }
}
