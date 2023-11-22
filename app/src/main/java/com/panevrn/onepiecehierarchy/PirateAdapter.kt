package com.panevrn.onepiecehierarchy

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.panevrn.onepiecehierarchy.pirates.OnItemClickListener
import com.panevrn.onepiecehierarchy.pirates.Pirate

class PirateAdapter(private val dbHelper: DBHelper, private var pirates: List<Pirate>): RecyclerView.Adapter<PirateAdapter.ViewHolder>() {
    private var itemClickListener: OnItemClickListener? = null

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.pirateNameTextViewItem)
        val bountyTextView: TextView = view.findViewById(R.id.pirateBountyTextViewItem)
        val idTextView: TextView = view.findViewById(R.id.pirateIDTextViewItem)

        init {
            itemView.setOnClickListener {
                showDeleteConfirmationDialog(itemView.context, pirates[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pirate, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pirate = pirates[position]
        holder.nameTextView.text = pirate.name
        holder.bountyTextView.text = pirate.bounty.toString() + " Belly"
        holder.idTextView.text = "ID пирата - " + pirate.id.toString()

        holder.itemView.setOnClickListener {
            itemClickListener?.onItemClick(pirate)
        }

    }

    fun showDeleteConfirmationDialog(context: Context, pirate: Pirate) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Удаление пирата")
            .setMessage("Вы уверены, что хотите удалить этого пирата из списка?")
            .setPositiveButton("Да") { _, _ ->
                // Удаление из базы данных
                dbHelper.deletePirateById(pirate.id)

                pirates = dbHelper.getAllPirates()
                notifyDataSetChanged()

            }
            .setNegativeButton("Нет", null)
            .create()
            .show()
    }

    override fun getItemCount() = pirates.size

    fun setOnItemClickListener(listener: OnItemClickListener) {
        itemClickListener = listener
    }

    fun updateData(newPirates: List<Pirate>) {
        pirates = newPirates
        notifyDataSetChanged()
    }

}
