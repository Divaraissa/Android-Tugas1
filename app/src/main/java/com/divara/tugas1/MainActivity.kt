package com.divara.tugas1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    var isFragmentLoaded = true
    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonkiri = findViewById<Button>(R.id.back)
        val buttonkanan  = findViewById<Button>(R.id.next)
        showFragmentSatu()

        buttonkanan.setOnClickListener {
            if (isFragmentLoaded) {
                showFragmentSatu()
                buttonkanan.setEnabled(false)
            }
        }
        buttonkiri.setOnClickListener {
            if (isFragmentLoaded){
                showHalamanDua()
                buttonkiri.setEnabled(false)
            }
        }
        buttonkanan.setOnClickListener {
            if (isFragmentLoaded) {
                showHalamanTiga()
                buttonkanan.setEnabled(false)
            }
        }

    }

    fun showHalamanTiga() {
        val transaction = manager.beginTransaction()
        val fragment = HalamanTiga()
        transaction.replace(R.id.frame, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentLoaded = true
    }

    fun showFragmentSatu(){
        val transaction = manager.beginTransaction()
        val fragment = FragmentSatu()
        transaction.replace(R.id.frame, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentLoaded = true
    }

    fun showHalamanDua(){
        val transaction = manager.beginTransaction()
        val fragment = HalamanDua()
        transaction.replace(R.id.frame, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        isFragmentLoaded = false
    }

}
