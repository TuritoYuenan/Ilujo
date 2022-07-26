package vn.turito.ilujo

import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import vn.turito.ilujo.ui.theme.IlujoTheme

class PhoneInfo : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent { PhoneInfoUI() }
	}
}

@Composable
fun PhoneInfoUI() {
	@Composable
	fun Entry(name: String, info: String) {
		Column(modifier = Modifier.padding(16.dp)) {
			Text(text = name, style = MaterialTheme.typography.titleMedium)
			Text(text = info, style = MaterialTheme.typography.bodyLarge)
		}
	}

	IlujoTheme {
		Surface(
			modifier = Modifier.fillMaxSize(),
			color = MaterialTheme.colorScheme.background
		) {
			Column() {
				Text(
					style = MaterialTheme.typography.titleLarge,
					modifier = Modifier.padding(16.dp).fillMaxSize(),
					textAlign = TextAlign.Center,
					text = "Phone Info"
				)
				Entry(name = "Brand", info = Build.BRAND)
			}
		}
	}
}

//@Preview(showBackground = true, name = "Light")
@Preview(showBackground = true, name = "Night", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewPhoneInfo() { PhoneInfoUI() }
