package ru.mrfix1033.imageview

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity2 : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private val images = listOf(R.drawable.ic_launcher_foreground, R.drawable.boy_with_guitar, R.drawable.landscape)
    private var imageIterator = images.iterator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        imageView = findViewById(R.id.imageView)
        imageView.setImageResource(imageIterator.next())

        findViewById<Button>(R.id.buttonNext).setOnClickListener {
            if (imageIterator.hasNext())
                imageView.setImageResource(imageIterator.next())
            else {
                val intent =  Intent(this, Activity3::class.java)
                startActivity(intent)
            }
        }
    }
}