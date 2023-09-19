package com.shreyansh.instagramclone

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun login(){
    Image(painter = painterResource(id = R.drawable.instagramcoloured), contentDescription = null,
    modifier = Modifier.padding(top = 100.dp))
}