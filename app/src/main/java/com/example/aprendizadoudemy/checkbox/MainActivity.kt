package com.example.aprendizadoudemy.checkbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aprendizadoudemy.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                image.setColorFilter(resources.getColor(R.color.teal_200))
            } else {
                image.setColorFilter(resources.getColor(R.color.gray))
            }
        }
    }
}