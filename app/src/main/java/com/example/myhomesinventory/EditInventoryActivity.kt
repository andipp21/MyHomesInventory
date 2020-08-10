package com.example.myhomesinventory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_edit_inventory.*

class EditInventoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_inventory)

        val dbHandler = DatabaseHandler(this)

        val inventory = intent.getParcelableExtra<Inventory>("inventory")

        if (inventory != null) {
            supportActionBar?.title = "Ubah data ${inventory.name}"
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        inventoryNameUpdate.setText(inventory?.name)
        inventoryTotalUpdate.setText(inventory?.total.toString())

        btnUpdate.setOnClickListener {
            inventory?.name = inventoryNameUpdate.text.toString()
            inventory?.total = inventoryTotalUpdate.text.toString().toInt()

            inventory?.let {
                if (dbHandler.updateInventory(it)!=0){
                    Toast.makeText(this,"Data barang berhasil dirubah", Toast.LENGTH_LONG).show()
                    finish()
                } else {
                    Toast.makeText(this,"Gagal merubah data barang",Toast.LENGTH_LONG).show()
                }
            }
        }

        fun onSuppoerNavigateUp(): Boolean {
            finish()
            return super.onSupportNavigateUp()
        }
    }
}