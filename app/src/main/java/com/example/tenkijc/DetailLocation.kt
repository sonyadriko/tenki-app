package com.example.tenkijc

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WeatherInfo(
    location: String,
    currentTemperature: String,
    currentWeather: String,
    currentHumidity: String,
    currentWind: String,
    currentRain: String,
    windInfo: String,
    nextDaysTemperature: String,
    nextDaysRain: String,
    nextDaysWind: String,
) {
    Column {
        // Informasi Cuaca Saat Ini
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "$currentTemperature°",
                color = Color(0xFFF3F3F3),
//                fontFamily = FontFamily(R.font.font_family), //  nama file font_family.xml
                fontSize = 48.sp,
            )

            Spacer(modifier = Modifier.size(4.dp))
            Text(
                text = currentWeather,
                color = Color(0xFFF3F3F3),
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
            )
        }

        Spacer(modifier = Modifier.size(16.dp))

        // Informasi Cuaca Lainnya
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Wind Section
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(4.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.wind), // Replace 'ic_cloud' with the actual file name
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                )
                Text(
                    text = currentWind,
                    color = Color(0xFFF3F3F3),
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                )
                Text(
                    text = "Wind",
                    color = Color(0xFFF3F3F3),
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                )
            }

            // Humidity Section
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(4.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.humidity), // Replace 'ic_cloud' with the actual file name
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                )
                Text(
                    text = currentHumidity,
                    color = Color(0xFFF3F3F3),
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                )
                Text(
                    text = "Humidity",
                    color = Color(0xFFF3F3F3),
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                )
            }

            // Rain Section
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(4.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.rain), // Replace 'ic_cloud' with the actual file name
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                )
                Text(
                    text = currentRain,
                    color = Color(0xFFF3F3F3),
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                )
                Text(
                    text = "Rain",
                    color = Color(0xFFF3F3F3),
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                )
            }
        }


        Spacer(modifier = Modifier.size(8.dp))


    }
}


@Composable
fun WeatherInfoScreen() {
    val location = "Stuttgart" // Define the location variable here
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color(0xFF1A1C1E) // Warna latar belakang #1A1C1E
    ) {
        Column {
            // Navbar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { /* Handle back navigation here */ }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        tint = Color(0xFFF3F3F3) // Warna button back #F3F3F3
                    )
                }

                Text(
                    text = "$location",
                    fontSize = 20.sp,
                    color = Color(0xFFF3F3F3),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically)
                )
            }

            // Weather Info
            WeatherInfo(
                location = "Stuttgart",
                currentTemperature = "20",
                currentWeather = "Thunderstorm",
                currentHumidity = "98%",
                currentWind= "10 m/s",
                currentRain= "100%",
                windInfo = "10 m/s",
                nextDaysTemperature = "Wednesday 18°",
                nextDaysRain = "100%",
                nextDaysWind = "! ¡"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WeatherInfoScreen()
}
