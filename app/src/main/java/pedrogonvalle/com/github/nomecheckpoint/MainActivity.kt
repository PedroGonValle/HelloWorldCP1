package pedrogonvalle.com.github.nomecheckpoint

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pedrogonvalle.com.github.nomecheckpoint.ui.theme.NomeCheckpointTheme
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Associa a Activity ao layout definido em activity_main.xml
        setContentView(R.layout.activity_main)

        // Referências para os componentes do layout
        val etName = findViewById<EditText>(R.id.etName)
        val tvHelloMessage = findViewById<TextView>(R.id.tvHelloMessage)

        // Listener para quando o usuário pressiona Enter (actionDone)
        etName.setOnEditorActionListener { textView, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                val name = textView.text.toString().trim()
                // Verifica se o nome foi digitado
                if (name.isNotEmpty()) {
                    tvHelloMessage.text = "Hello World, $name!"
                } else {
                    tvHelloMessage.text = "Hello World!"
                }
                true // Indica que consumimos o evento
            } else {
                false
            }
        }
    }
}