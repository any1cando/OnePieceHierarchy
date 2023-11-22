package com.panevrn.onepiecehierarchy.pirates

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.panevrn.onepiecehierarchy.DBHelper
import com.panevrn.onepiecehierarchy.PirateAdapter
import com.panevrn.onepiecehierarchy.R

class ShowAllPiratesActivity : AppCompatActivity() {
    private val dbHelper = DBHelper(this)
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PirateAdapter
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private var piratesList: List<Pirate> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_all_pirates)

        layoutManager = LinearLayoutManager(this)
        adapter = PirateAdapter(dbHelper, piratesList)
        recyclerView = findViewById<RecyclerView?>(R.id.piratesRecyclerView1).apply {
            setHasFixedSize(true)
            layoutManager = this@ShowAllPiratesActivity.layoutManager
            adapter = this@ShowAllPiratesActivity.adapter
        }

        // Загрузка данных
        loadPirates()

        adapter.setOnItemClickListener(object: OnItemClickListener {
            override fun onItemClick(pirate: Pirate) {
                val intent = Intent(this@ShowAllPiratesActivity, CertainPirateInformationActivity::class.java)
                intent.putExtra("pirate_id", pirate.id.toString()) // Передача ID пирата
                startActivity(intent)
            }
        })

        val backButton = findViewById<ImageButton>(R.id.arrowBackToPirateMenuFromAllPirates)
        backButton.setOnClickListener {
            val intent = Intent(this, PirateMenuActivity::class.java)
            startActivity(intent)
        }
    }
    private fun loadPirates() {
        // Эмуляция запроса данных, например, из базы данных или API
        // В вашем случае здесь может быть вызов DBHelper для получения списка пиратов
        piratesList = dbHelper.getAllPirates() // Получаем список пиратов
        if (piratesList.isEmpty()) {
            Toast.makeText(this, "Список пиратов пуст", Toast.LENGTH_SHORT).show()
        }
        else {
            adapter.updateData(piratesList)
        } // Обновляем данные в адаптере
    }
}