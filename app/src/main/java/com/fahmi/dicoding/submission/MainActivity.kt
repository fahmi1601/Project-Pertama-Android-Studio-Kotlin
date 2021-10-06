package com.fahmi.dicoding.submission

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvMilan : RecyclerView
    private val list: ArrayList<Milan> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "AC Milan Players"

        rvMilan = findViewById(R.id.rv_acmilan)
        rvMilan.setHasFixedSize(true)

        list.addAll(MilanData.listData)
        showRecycleList()
    }

    private fun showRecycleList() {
        rvMilan.layoutManager = LinearLayoutManager(this)
        val listMilanAdapter = ListMilanAdapter(list)
        rvMilan.adapter = listMilanAdapter

        listMilanAdapter.setOnItemClickCallback(object : ListMilanAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Milan) {
                showSelectedPlayer(data)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_profile -> {
                val profileIntent = Intent(this@MainActivity, ProfileActivity::class.java)
                startActivity(profileIntent)
            }
        }
    }

    private fun showSelectedPlayer(milan: Milan) {
        val moveToDetail = Intent(this@MainActivity, DetailActivity::class.java)
        moveToDetail.putExtra(DetailActivity.EXTRA_NAME, milan.name)
        moveToDetail.putExtra(DetailActivity.EXTRA_BIRTH_DATE, milan.birth_date)
        moveToDetail.putExtra(DetailActivity.EXTRA_PHOTO, milan.photo)
        moveToDetail.putExtra(DetailActivity.EXTRA_BIRTH_DATE, milan.birth_date)
        moveToDetail.putExtra(DetailActivity.EXTRA_BIRTH_PLACE, milan.birth_place)
        moveToDetail.putExtra(DetailActivity.EXTRA_NATIONALITY, milan.nationality)
        moveToDetail.putExtra(DetailActivity.EXTRA_HEIGHT, milan.height)
        moveToDetail.putExtra(DetailActivity.EXTRA_WEIGHT, milan.weight)
        moveToDetail.putExtra(DetailActivity.EXTRA_BIO, milan.bio)
        startActivity(moveToDetail)
    }
}