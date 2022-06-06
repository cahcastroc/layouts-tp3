package me.camila.tp3_layout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val etName = this.findViewById<EditText>(R.id.etName)
        val etEmail = this.findViewById<EditText>(R.id.etEmail)
        val btLogin = this.findViewById<Button>(R.id.btLogin)

        btLogin.setOnClickListener {
            if (validated(etName, etEmail)) {

                val name = etName.text.toString()
                val tableIntent = Intent(this, TableActivity::class.java)

                tableIntent.putExtra("Name", name)

                startActivity(tableIntent)

            } else {
                Toast.makeText(this, "Todos os campos são obrigatórios", Toast.LENGTH_LONG).show()
            }

        }

    }

    private fun validated(name: EditText, email: EditText): Boolean {
        return name.text.isNotBlank() && email.text.isNotBlank()

    }
}