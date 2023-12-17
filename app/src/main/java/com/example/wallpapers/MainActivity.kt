package com.example.wallpapers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.wallpapers.ui.theme.WallpapersTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import coil.compose.AsyncImage


class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WallpapersTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navigator = rememberNavController()


                    NavHost(navController = navigator, startDestination = "login") {
                        composable("login") {
                            Login(onAuthSuccess = {
                                navigator.navigate("dashboard")
                            })
                        }


                        composable("dashboard") {
                            Dashboard()
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun Login(onAuthSuccess: () -> Unit) {


    var email by remember {
        mutableStateOf("")
    }


    var password by remember {
        mutableStateOf("")
    }


    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)) {


        Spacer(modifier = Modifier.height(16.dp))


        Text(
            text = "Wallpaper Gallery",
            fontFamily = FontFamily.Cursive,
            fontSize = 36.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontWeight = FontWeight.ExtraBold
        )


        AsyncImage(
            model = "https://wallpapers.com/images/hd/wallpaper-chain-iron-metal-links-blur-1wkvbpapxb6wafjx.webp",
            contentDescription = "Login Screen",
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop
        )


        OutlinedTextField(value = email, onValueChange = {
            email = it
        }, label = {
            Text(text = "Email")
        }, modifier = Modifier.fillMaxWidth())


        OutlinedTextField(value = password, onValueChange = {
            password = it
        }, label = {
            Text(text = "Password")
        }, modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )


        Button(onClick = { onAuthSuccess() }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Submit")
        }
    }
}


@Composable
fun Dashboard() {


    val imageListUrl = listOf(
        "https://i.imgur.com/OB0y6MR.jpg",
        "https://i.imgur.com/CzXTtJV.jpg",
        "https://farm4.staticflickr.com/3852/14447103450_2d0ff8802b_z_d.jpg",
        "https://farm2.staticflickr.com/1533/26541536141_41abe98db3_z_d.jpg",
        "https://farm4.staticflickr.com/3075/3168662394_7d7103de7d_z_d.jpg",
        "https://i.imgur.com/OnwEDW3.jpg",
        "https://farm3.staticflickr.com/2220/1572613671_7311098b76_z_d.jpg",
        "https://farm7.staticflickr.com/6089/6115759179_86316c08ff_z_d.jpg",
        "https://farm4.staticflickr.com/3224/3081748027_0ee3d59fea_z_d.jpg",
        "https://farm8.staticflickr.com/7377/9359257263_81b080a039_z_d.jpg",
        "https://farm9.staticflickr.com/8295/8007075227_dc958c1fe6_z_d.jpg",
        "https://farm2.staticflickr.com/1449/24800673529_64272a66ec_z_d.jpg"
    )


    LazyVerticalGrid(columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(imageListUrl) {
            AsyncImage(
                model = it,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .border(2.dp, Color.Black, RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )
        }
    }
}
