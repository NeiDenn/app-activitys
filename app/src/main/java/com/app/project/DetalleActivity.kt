package com.app.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.project.databinding.ActivityDetalleBinding
import com.app.project.databinding.ActivityPrincipalBinding

class DetalleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // adecuar la configuracion binding
        binding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras

        if(extras != null){
            val estCivil = extras.getString("estadoCivil")

            binding.lblDetalle.text = "Estado Civil Recibido: $estCivil"
        }
    }
}