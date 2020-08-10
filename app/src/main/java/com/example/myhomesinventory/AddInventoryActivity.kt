package com.example.myhomesinventory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_inventory.*

class AddInventoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_inventory)

        val dbHandler = DatabaseHandler(this)

        btnAdd.setOnClickListener {
            val inventory = Inventory(null, inventoryNameAdd.text.toString(), inventoryTotalAdd.text.toString().toInt())

            if (dbHandler.addInventory(inventory)!=0.toLong()){
                Toast.makeText(this,"Sukses menambahkan barang",Toast.LENGTH_LONG).show()
                finish()
            } else {
                Toast.makeText(this,"Gagal menambahkan barang",Toast.LENGTH_LONG).show()
            }
        }
    }
}