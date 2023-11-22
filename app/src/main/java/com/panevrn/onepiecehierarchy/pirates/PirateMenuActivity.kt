package com.panevrn.onepiecehierarchy.pirates

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import com.panevrn.onepiecehierarchy.MainActivity
import com.panevrn.onepiecehierarchy.R


class PirateMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pirate_menu)

        val buttonShowAllPirates = findViewById<Button>(R.id.buttonShowPirateList)
        buttonShowAllPirates.setOnClickListener {
            val intent = Intent(this, ShowAllPiratesActivity::class.java)
            startActivity(intent)
        }

        val buttonCreateNewPirate = findViewById<Button>(R.id.buttonCreateNewPirate)
        buttonCreateNewPirate.setOnClickListener {
            val intent = Intent(this, CreateNewPirateActivity::class.java)
            startActivity(intent)
        }

        val buttonDeleteThePirate = findViewById<Button>(R.id.buttonDeleteThePirate)
        buttonDeleteThePirate.setOnClickListener {
            val intent = Intent(this, DeleteThePirateActivity::class.java)
            startActivity(intent)
        }

    }

    fun navigateToMenu(view: View) {

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}