package com.shreyansh.instagramclone

//import androidx.compose.foundation.gestures.ModifierLocalScrollableContainerProvider.value
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.shreyansh.instagramclone.Models.User


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun signUp() {
    lateinit var user: User
    val context = LocalContext.current
    var username by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var pass by rememberSaveable { mutableStateOf("") }
    user = User()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 150.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .background(Color.White)
        ) {
            // Load your circular image here
            Image(
                painter = painterResource(id = R.drawable.circularimage), // Replace with your image
                contentDescription = null, // Provide a content description
                contentScale = ContentScale.Crop,

                // modifier = Modifier.fillMaxSize()
            )
        }
        Image(
            painter = painterResource(id = R.drawable.plus), // Replace with your image
            contentDescription = null,
            Modifier
                .padding(top = 55.dp, start = 69.dp)
                .size(35.dp)
            // Provide a content description


            // modifier = Modifier.fillMaxSize()
        )
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 400.dp, start = 10.dp, end = 10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            value = username,
            onValueChange = { username = it },
            label = { Text(text = "Name/Username") },
            placeholder = { Text(text = "Enter your Username") },
//       leadingIcon = {
//           Icon(imageVector = Icons.Default.Email, contentDescription = null)
//       },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            shape = CircleShape
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email") },
            placeholder = { Text(text = "Enter your Email") },
//           leadingIcon = {
//               Icon(imageVector = Icons.Default.Email, contentDescription = null)
//           }
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Done
            ),
            shape = CircleShape
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            value = pass,
            onValueChange = { pass = it },
            label = { Text(text = "Password") },
            placeholder = { Text(text = "Enter your Password") },
//           leadingIcon = {
//               Icon(imageVector = Icons.Default.Email, contentDescription = null)
//           }
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Done
            ),
            shape = CircleShape
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Button(
            onClick = {
                if (username.isEmpty() or email.isEmpty() or pass.isEmpty()) {
                    Toast.makeText(context, "You have not entered all fields", Toast.LENGTH_LONG)
                        .show()
                } else {
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                        email, pass
                    ).addOnCompleteListener { result ->
                        if (result.isSuccessful) {

                            user.Email = email
                            user.Password = pass
                            user.Name = username
                            Firebase.firestore.collection("User")
                                .document(Firebase.auth.currentUser!!.uid).set(user)
                                .addOnSuccessListener {
                                    Toast.makeText(
                                        context,
                                        "Login Successful",
                                        Toast.LENGTH_LONG
                                    ).show()
                                }

                        } else
                            Toast.makeText(
                                context,
                                result.exception?.localizedMessage,
                                Toast.LENGTH_LONG
                            ).show()
                    }
                }

            },

            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp)

        ) {

            Text(text = "Register")
        }
        Row() {

            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                modifier = Modifier.padding(top = 5.dp)
            ) {
                Text(text = "Already Have An Account Login?", color = Color(0XFFFB5AAA))
            }

        }
    }

}


