package com.panevrn.onepiecehierarchy.pirates

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.panevrn.onepiecehierarchy.R


class CreateNewPirateActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_pirate)

        val buttonToCreatePirateSecondLayout = findViewById<Button>(R.id.buttonGoToSecondLayoutPirateCreate)

        buttonToCreatePirateSecondLayout.setOnClickListener {
            val intent = Intent(this, CreateNewPirateSecondLayoutActivity::class.java)

            val pirateName = findViewById<EditText>(R.id.editTextPirateName).text.toString()
            val pirateAge = findViewById<EditText>(R.id.editTextPirateAge).text.toString().toInt()
            val pirateBounty = findViewById<EditText>(R.id.editTextPirateBounty).text.toString().toLong()
            val radioButton1 = findViewById<RadioButton>(R.id.radioButtonDFyes)
            val pirateDFinfo: Boolean = when(radioButton1.isChecked) {
                true -> true
                else -> false
            }
            intent.putExtra("name", pirateName)
            intent.putExtra("age", pirateAge)
            intent.putExtra("bounty", pirateBounty)
            intent.putExtra("infoDF", pirateDFinfo)

            startActivity(intent)
        }


    }
    fun navigateToPirateMenu(view: View) {
        val intent = Intent(this, PirateMenuActivity::class.java)
        startActivity(intent)

    }

//    fun navigateToCreateNewPirateSecondLayout(view: View) {
//        val intent = Intent(this, CreateNewPirateSecondLayoutActivity::class.java)
//
//        val pirateName = findViewById<EditText>(R.id.editTextPirateName).text.toString()
//        val pirateAge = findViewById<EditText>(R.id.editTextPirateAge).text.toString().toInt()
//        val pirateBounty = findViewById<EditText>(R.id.editTextPirateBounty).text.toString().toLong()
//        val radioButton1 = findViewById<RadioButton>(R.id.radioButtonDFyes)
//        val pirateDFinfo: Boolean = when(radioButton1.isChecked) {
//            true -> true
//            else -> false
//        }
//        intent.putExtra("name", pirateName)
//        intent.putExtra("age", pirateAge)
//        intent.putExtra("bounty", pirateBounty)
//        intent.putExtra("infoDF", pirateDFinfo)
//
//        startActivity(intent)


        // Это передача параметров на следующий слой с помощью Intent и метода putExtra()


//        val pirateName = findViewById<EditText>(R.id.editTextPirateName).text.toString()
//        val pirateAge = findViewById<EditText>(R.id.editTextPirateAge).text.toString().toInt()
//        val pirateBounty = findViewById<EditText>(R.id.editTextPirateBounty).text.toString().toLong()
//        val radioButton1 = findViewById<RadioButton>(R.id.radioButtonDFyes)
//        val radioButton2 = findViewById<RadioButton>(R.id.radioButtonDFno)
//        val pirateDFinfo: Boolean = when(radioButton1.isChecked) {
//            true -> true
//            else -> false
//        }
//        intent.putExtra("name", pirateName)
//        intent.putExtra("age", pirateAge)
//        intent.putExtra("bounty", pirateBounty)
//        intent.putExtra("infoDF", pirateDFinfo)


        // Это передача параметров на следующий слой с помощью Intent и метода putExtra()


//    fun saveData(name: String, age: Int, bounty: Long, infoDF: Boolean, pref: SharedPreferences?) {
//        val editor = pref?.edit()
//        editor?.putString("name", name)
//        editor?.putInt("age", age)
//        editor?.putLong("bounty", bounty)
//        editor?.putBoolean("infoDF", infoDF)
//        editor?.putInt("flag", 1)
//        editor?.apply()
//    }
}




