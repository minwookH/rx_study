package com.minwook.rx_study.ui

import android.os.Bundle
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.minwook.rx_study.R
import com.minwook.rx_study.base.VMProviders
import com.minwook.rx_study.viewmodel.GithubViewmodel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var githubViewmodel: GithubViewmodel
    private lateinit var adapter: SearchListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        githubViewmodel = VMProviders.of(this).get(GithubViewmodel::class.java)
        githubViewmodel.searchList.observe(this) {
            if (!it.isNullOrEmpty()) {
                adapter.addList(it)
            }
        }

        bt_search.setOnClickListener {
            githubViewmodel.getSearchRepositories(et_search_text.text.toString())
        }

        adapter = SearchListAdapter(this)
        rv_search_list.adapter = adapter
        rv_search_list.layoutManager = LinearLayoutManager(this)
    }
}