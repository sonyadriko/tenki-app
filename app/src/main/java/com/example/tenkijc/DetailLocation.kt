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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WeatherInfo(
    location: String,
    currentTemperature: String,
    currentWeather: String,
    currentHumidity: String,
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
        Image(
            painter = painterResource(R.drawable.wind), // Replace 'ic_wind' with the actual file name
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            colorFilter = ColorFilter.tint(Color(0xFFF3F3F3))
        )
        Spacer(modifier = Modifier.size(4.dp))
        Text(
            text = windInfo,
            color = Color(0xFFF3F3F3),
            fontFamily = FontFamily.Default,
            fontSize = 16.sp,
        )

        Spacer(modifier = Modifier.size(8.dp))

        Image(
            painter = painterResource(R.drawable.humidity), // Replace 'ic_humidity' with the actual file name
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            colorFilter = ColorFilter.tint(Color(0xFFF3F3F3))
        )
        Spacer(modifier = Modifier.size(4.dp))
        Text(
            text = currentHumidity,
            color = Color(0xFFF3F3F3),
            fontFamily = FontFamily.Default,
            fontSize = 16.sp,
        )

        Spacer(modifier = Modifier.size(8.dp))

        Image(
            painter = painterResource(R.drawable.rain), // Replace 'ic_cloud' with the actual file name
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            colorFilter = ColorFilter.tint(Color(0xFFF3F3F3))
        )
        Spacer(modifier = Modifier.size(4.dp))
        Text(
            text = nextDaysRain,
            color = Color(0xFFF3F3F3),
            fontFamily = FontFamily.Default,
            fontSize = 16.sp,
        )

        Spacer(modifier = Modifier.size(8.dp))

        Box(
            modifier = Modifier
                .padding(start = 16.dp, top = 8.dp)
                .background(color = Color.Gray),
        ) {
            Text(
                text = nextDaysWind,
                fontSize = 16.sp,
                color = Color.White,
                modifier = Modifier.padding(16.dp)
            )
        }
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
