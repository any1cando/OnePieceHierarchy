package com.panevrn.onepiecehierarchy.pirates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import com.panevrn.onepiecehierarchy.DBHelper
import com.panevrn.onepiecehierarchy.R

class CreateNewPirateSecondLayoutActivity: AppCompatActivity() {
    private lateinit var dbHelper: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_pirate_second_layout)

        val intent = intent

        val pirateName = intent.getStringExtra("name")
        val pirateAge = intent.getIntExtra("age", 0)
        val pirateBounty = intent.getLongExtra("bounty", 0)
        val pirateInfoDF = intent.getBooleanExtra("infoDF", false)

        // Переданные значения с предыдущего слоя

        val buttonToCreateNewPirate = findViewById<Button>(R.id.buttonToAddNewPirate)

        buttonToCreateNewPirate.setOnClickListener {
            val pirateDestiny = findViewById<EditText>(R.id.editTextPirateDestiny).text.toString()
            val pirateCrimeHistory = findViewById<EditText>(R.id.editTextPirateCrimeHistory).text.toString()

            val newPirate: Pirate = Pirate(
                name = pirateName!!,
                age = pirateAge,
                bounty = pirateBounty,
                devilFruit = pirateInfoDF,
                crimeHistory = pirateCrimeHistory,
                destiny = pirateDestiny
            )

            dbHelper = DBHelper(this)
            dbHelper.addPirate(newPirate)

            val intent = Intent(this, PirateMenuActivity::class.java)
            startActivity(intent)
        }



    }

    fun navigateToCreateNewPirate(view: View) {
        val intent = Intent(this, CreateNewPirateActivity::class.java)
        startActivity(intent)

    }

//    fun navigateAfterCreatingPirate(view: View) {
//
//        val intent = Intent(this, PirateMenuActivity::class.java)
//        startActivity(intent)
//
//    }
}

