package pt.dev_sorcerer.currency_app

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key.Companion.R
import androidx.compose.ui.unit.dp
import com.russhwolf.settings.Settings
import currencyapp.composeapp.generated.resources.Res
import currencyapp.composeapp.generated.resources.compose_multiplatform
import currencyapp.composeapp.generated.resources.Res.drawable
import org.jetbrains.compose.ui.tooling.preview.Preview

import kotlinx.datetime.Instant
import org.jetbrains.compose.resources.painterResource

@Composable
@Preview
fun App() {
    var progress by remember { mutableStateOf(false) }
    var amount by remember { mutableStateOf(1.00f) }
    var calculatedAmount by remember { mutableStateOf(1.00f) }


    val settings = Settings()
    val lastUpdatedDate = settings.getLong("lastUpdatedDate", -1)

    var greeting by remember {
        mutableStateOf(
            Instant.fromEpochMilliseconds(lastUpdatedDate).toString()
        )
    }

    /*val now = Clock.System.now().toEpochMilliseconds()
    val difference = now - lastUpdatedDate
    if (difference > (1000 * 60 * 60 * 24)) {
        progress = true
        LaunchedEffect(true) {
            val response = ApiConnection.greeting()

            val serverLastUpdatedDate = Instant.parse(response.meta.lastUpdatedAt).toEpochMilliseconds()
            settings.putLong("lastUpdatedDate", serverLastUpdatedDate)
            greeting = response.meta.lastUpdatedAt

            progress = false
        }
    }*/


    MaterialTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            AnimatedVisibility(progress, modifier = Modifier.align(Alignment.Center)) {
                CircularProgressIndicator()
            }
        }


        Column(Modifier.fillMaxWidth().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Button(onClick = {

                }, modifier = Modifier.height(56.dp)) {
                    Text("EUR")
                }

                Spacer(modifier = Modifier.width(8.dp))

                TextField(
                    modifier = Modifier.weight(1f),
                    value = amount.toString(),
                    onValueChange = {
                        amount = it.toFloat()
                    },
                    label = {
                        Text("From")
                    })
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {

            }) {
                //Image(painter = painterResource(Res.drawable.ic_currency_exchange), contentDescription = null)
            }

            Row(modifier = Modifier.fillMaxWidth()) {
                Button(onClick = {

                }, modifier = Modifier.height(56.dp)) {
                    Text("USD")
                }

                Spacer(modifier = Modifier.width(8.dp))

                TextField(
                    modifier = Modifier.weight(1f),
                    value = calculatedAmount.toString(),
                    onValueChange = {
                        calculatedAmount = it.toFloat()
                    },
                    label = {
                        Text("To")
                    })
            }


            Text(greeting)


        }
    }
}