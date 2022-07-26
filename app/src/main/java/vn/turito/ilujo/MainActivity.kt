package vn.turito.ilujo

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import vn.turito.ilujo.ui.theme.IlujoTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent { Init() }
	}
}

data class Tool(val Name: String, val Icon: Int, val Activity: ComponentActivity)

@Composable
fun Init() {
	@Composable
	fun ToolButton(tool: Tool) {
		val mContext = LocalContext.current
		Column(horizontalAlignment = Alignment.CenterHorizontally) {
			Button(onClick = {
				mContext.startActivity(Intent(mContext, tool.Activity::class.java))
			}) {
				Image(
					painter = painterResource(tool.Icon),
					contentDescription = tool.Name,
					modifier = Modifier.size(60.dp)
				)
			}
			Spacer(modifier = Modifier.height(8.dp))
			Text(text = tool.Name, style = MaterialTheme.typography.titleMedium)
		}
	}

	@Composable
	fun ToolGroup(name: String, tools: List<Tool>) {
		Column(horizontalAlignment = Alignment.CenterHorizontally) {
			Text(
				text = name,
				style = MaterialTheme.typography.titleLarge,
				modifier = Modifier.padding(16.dp)
			)
			LazyVerticalGrid(
				verticalArrangement = Arrangement.spacedBy(16.dp),
				horizontalArrangement = Arrangement.spacedBy(16.dp),
				columns = GridCells.Adaptive(100.dp),
				modifier = Modifier.padding(16.dp),
			) { itemsIndexed(tools) { _, item -> ToolButton(item) } }
		}
	}

	IlujoTheme { Surface(
		modifier = Modifier.fillMaxSize(),
		color = MaterialTheme.colorScheme.background
	) {
		Column() {
			ToolGroup("Instruments", Tools.Instruments)
			ToolGroup("Converters", Tools.Converters)
		}
	} }
}

@Preview(name = "Light", showBackground = true, showSystemUi = true)
@Preview(name = "Night", showBackground = true, showSystemUi = true,
	uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun MainPreview() { Init() }
