package com.shreyansh.instagramclone

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay


@Composable
fun splashScreen(navController: NavHostController){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
        //.padding(bottom = 45.dp)
    ) {
        Image(painter = painterResource(id = R.drawable.instagram), contentDescription ="logoPic", modifier = Modifier
            .padding(top = 290.dp)
            .size(95.dp)
        )
        Column(verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            //modifier = Modifier.fillMaxHeight()
        ) {
            Text(text = stringResource(id = R.string.from), fontSize = 20.sp,
                color = Color.Gray,
                modifier = Modifier
                    .padding(top = 365.dp)
            )
            Text(text = "Shreyansh", color = Color(0XFFFB5AAA), fontSize =25.sp )
        }
        LaunchedEffect(true){
            delay(1000)

            navController.navigate(SignUp.route)

        }

    }
}