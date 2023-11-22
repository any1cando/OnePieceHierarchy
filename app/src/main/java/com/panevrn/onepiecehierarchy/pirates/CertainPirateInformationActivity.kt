package com.panevrn.onepiecehierarchy.pirates

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import com.panevrn.onepiecehierarchy.DBHelper
import com.panevrn.onepiecehierarchy.R

class CertainPirateInformationActivity : AppCompatActivity() {
    private val dbHelper: DBHelper = DBHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_certain_pirate_information)

        val intent = intent
        val idString = intent.getStringExtra("pirate_id")
        println("Проверка лога после передачи через intent")
        println(idString)
        try {
            val pirateId: Int = if (idString != null) {
                idString.toInt()
            } else {
                0
            }
            println("Проверка ЛОГА после проверки if")
            println(pirateId)
            if (pirateId != 0) { // Проверьте, что pirateId не равно 0, прежде чем получать информацию о пирате
                val certainPirate = dbHelper.getPirateById(pirateId)
                if (certainPirate != null) { // Проверьте, что получена информация о пирате
                    val checkInfoDF = certainPirate.devilFruit
                    val nameTextView = findViewById<TextView>(R.id.certainPirateTextViewNameData)
                    val ageTextView = findViewById<TextView>(R.id.certainPirateTextViewAgeData)
                    val bountyTextView = findViewById<TextView>(R.id.certainPirateTextViewBountyData)
                    val infoDFTextView = findViewById<TextView>(R.id.certainPirateTextViewDFData)
                    val crimeHistoryTextView = findViewById<TextView>(R.id.certainPirateTextViewCrimeHistoryData)
                    val destinyTextView = findViewById<TextView>(R.id.certainPirateTextViewDestinyData)

                    infoDFTextView.text = if (checkInfoDF) "Есть" else "Отсутствует"
                    nameTextView.text = certainPirate.name
                    ageTextView.text = certainPirate.age.toString()
                    bountyTextView.text = certainPirate.bounty.toString()
                    crimeHistoryTextView.text = certainPirate.crimeHistory.ifEmpty { "Особо тяжких преступлений не обнаружено" }
                    destinyTextView.text = certainPirate.destiny.ifEmpty { "Цель пирата неизвестна" }
                }
            } else {
                // Обработка случая, когда pirateId равно 0 (пустое значение)
            }
        } catch (e : Exception) {
            println(e)
        }

        val buttonGoToPirateMenu = findViewById<ImageButton>(R.id.arrowBackToPirateMenuFromCertainPirate)
        buttonGoToPirateMenu.setOnClickListener {
            val intent = Intent(this, PirateMenuActivity::class.java)
            startActivity(intent)
        }

    }
}