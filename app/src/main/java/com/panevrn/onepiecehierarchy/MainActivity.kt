package com.panevrn.onepiecehierarchy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.content.Intent
import com.panevrn.onepiecehierarchy.pirates.PirateMenuActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonGoToSecondLayout = findViewById<Button>(R.id.buttonGoToSecondLayout)
        buttonGoToSecondLayout.setOnClickListener {
            val radioGroupStart = findViewById<RadioGroup>(R.id.radioGroupStartID)
            val checkedRadioButtonID = radioGroupStart.checkedRadioButtonId

            if (checkedRadioButtonID == -1) {
                return@setOnClickListener
            }

            when (checkedRadioButtonID) {
                R.id.radioButtonPirate -> {
                    val intent = Intent(this, PirateMenuActivity::class.java)
                    startActivity(intent)
                }
                // Добавить 2 активности (Маринфорд, Шачибукай)
            }

        }



    }
}
