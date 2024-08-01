package com.srgmrtnvqr.datosdiarios

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        const val SHARED_PREFS = "shared_prefs"
        const val USUARIO_KEY = "usuario_key"
        const val CONTRASEÑA_KEY = "contraseña_key"
    }

    private lateinit var sharedpreferences: SharedPreferences
    private var usuario: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedpreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)
        usuario = sharedpreferences.getString(USUARIO_KEY, null)

        val welcomeTV = findViewById<TextView>(R.id.idTVWelcome)
        welcomeTV.text = "Bienvenido $usuario"
        val logoutBtn = findViewById<Button>(R.id.idBtnLogout)
        logoutBtn.setOnClickListener {
            val editor = sharedpreferences.edit()
            editor.clear()
            editor.apply()

            val i = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(i)
            finish()
        }
    }
}