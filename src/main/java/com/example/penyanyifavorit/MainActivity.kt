package com.example.penyanyifavorit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvPenyanyi: RecyclerView
    private val list = ArrayList<Penyanyi>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvPenyanyi = findViewById(R.id.rv_penyanyi)
        rvPenyanyi.setHasFixedSize(true)

        list.addAll(getlistPenyanyi())
        showRecyclerView()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_about, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_about -> {
                startActivity(Intent(this@MainActivity, AboutActivity::class.java))
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getlistPenyanyi(): ArrayList<Penyanyi> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listPenyanyi = ArrayList<Penyanyi>()
        for (i in dataName.indices) {
            val penyanyi = Penyanyi(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listPenyanyi.add(penyanyi)
        }
        dataPhoto.recycle()
        return listPenyanyi
    }

    private fun showRecyclerView() {
        rvPenyanyi.layoutManager = LinearLayoutManager(this)
        val listPenyanyiAdapter = ListPenyanyi(list)
        rvPenyanyi.adapter = listPenyanyiAdapter
    }
}
