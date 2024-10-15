package com.example.aiapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val prompt = findViewById<EditText>(R.id.prompt)
        val submitbtn = findViewById<Button>(R.id.submitbtn)
        val result = findViewById<TextView>(R.id.result)

        submitbtn.setOnClickListener {
            val provideprompt= prompt.text.toString()
            val generativeModel = GenerativeModel(
                // For text-only input, use the gemini-pro model
                modelName = "gemini-pro",
                //Paste the generated API key from google gemini over here or put it in build.gradle
                apiKey = "AIzaSyA5mup_MVVc-f452kj1C_1ucTrfCbYuIcE"
                // ENTER YOUR KEY
            )
            runBlocking {
                val response = generativeModel.generateContent(provideprompt)
                result.text= response.text
            }
        }
    }
}