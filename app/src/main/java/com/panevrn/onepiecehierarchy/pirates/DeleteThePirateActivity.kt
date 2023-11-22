package com.panevrn.onepiecehierarchy.pirates

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.panevrn.onepiecehierarchy.DBHelper
import com.panevrn.onepiecehierarchy.PirateAdapter
import com.panevrn.onepiecehierarchy.R

class DeleteThePirateActivity : AppCompatActivity() {
    private val dbHelper: DBHelper = DBHelper(this)
    private lateinit var adapter: PirateAdapter
    private var piratesList: List<Pirate> = mutableListOf()
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete_the_pirate)

        layoutManager = LinearLayoutManager(this)
        adapter = PirateAdapter(dbHelper, piratesList)
        recyclerView = findViewById<RecyclerView?>(R.id.piratesRecyclerView3).apply {
            setHasFixedSize(true)
            layoutManager = this@DeleteThePirateActivity.layoutManager
            adapter = this@DeleteThePirateActivity.adapter
        }

        loadData()

        adapter.setOnItemClickListener(object: OnItemClickListener {
            override fun onItemClick(pirate: Pirate) {
                adapter.showDeleteConfirmationDialog(this@DeleteThePirateActivity, pirate)
            }
        })

//        recyclerView.adapter = adapter

        val buttonGoToPirateMenu = findViewById<ImageButton>(R.id.arrowBackToPirateMenuFromDeleteThePirate)
        buttonGoToPirateMenu.setOnClickListener {
            val intent = Intent(this, PirateMenuActivity::class.java)
            startActivity(intent)
        }


    }
    private fun loadData() {
        piratesList = dbHelper.getAllPirates()
        if (piratesList.isEmpty()) {
            Toast.makeText(this, "Список пиратов пуст", Toast.LENGTH_SHORT).show()
        }
        else {
            adapter.updateData(piratesList)
        } // Обновляем данные в адаптере
    }
}