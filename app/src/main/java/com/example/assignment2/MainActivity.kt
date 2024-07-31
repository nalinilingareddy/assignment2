package com.example.assignment2

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.assignment2.fragments.FragmentFillInTheBlanks
import com.example.assignment2.fragments.FragmentFrenchNotes
import com.example.assignment2.fragments.FragmentTrueFalse

class MainActivity : AppCompatActivity() {
    private lateinit var fragmentTrueFalse: FragmentTrueFalse
    private lateinit var fragmentFillInTheBlanks: FragmentFillInTheBlanks
    private lateinit var fragmentFrenchNotes: FragmentFrenchNotes

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        fragmentTrueFalse = FragmentTrueFalse()
        fragmentFillInTheBlanks = FragmentFillInTheBlanks()
        fragmentFrenchNotes = FragmentFrenchNotes()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frame_layout_1, fragmentFrenchNotes)
                .commit()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.it_true_false -> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.frame_layout_1, fragmentTrueFalse)
                    commit()
                }
                true
            }
            R.id.it_fill_in_the_blanks -> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.frame_layout_1, fragmentFillInTheBlanks)
                    commit()
                }
                true
            }
            R.id.it_french_notes -> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.frame_layout_1, fragmentFrenchNotes)
                    commit()
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }
}
