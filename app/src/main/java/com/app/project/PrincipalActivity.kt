package com.app.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import com.app.project.databinding.ActivityPrincipalBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputLayout

class PrincipalActivity : AppCompatActivity() {

    private val TAG = "PAC"
    private lateinit var binding : ActivityPrincipalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnImprimir.setOnClickListener {

            // binding.btnImprimir.error = null

            // code
            val nombre = binding.txtGenero.editText?.text.toString()

            // if (nombre.isEmpty){
            //binding.txtNombre.error = "valor requerido"
            // return@setOnClickListener

            val estadoCivil = when (binding.rgEstadoCivil.checkedRadioButtonId) {
                binding.rbSoltero.id -> {
                    "Soltero"
                } binding.rbCasado.id -> {
                    "Casado"
                } binding.rbDivorciado.id -> {
                    "Divorciado"
                } else -> {
                    "Viudo"
                }
            }

            if (estadoCivil.isEmpty()){
                MaterialAlertDialogBuilder(this)
                    .setTitle("Alerta")
                    .setMessage("Debe seleccionar un estado civil para continuar")
                    .show()
                return@setOnClickListener
            }

            MaterialAlertDialogBuilder(this)
             .setTitle("confirmacion")
             .setMessage("Desea enviar todos los datos")
             .setPositiveButton("aceptar") { _, _ ->

                 val next = Intent(this, DetalleActivity::class.java)
                 next.putExtra("estadoCivil", estadoCivil)
                 startActivity(next)
             }
                .setNeutralButton("Cancelar", null)
                .show()

            Log.i(TAG, nombre)
            Log.i(TAG, estadoCivil)
        }

        // val textField = findViewById<TextInputLayout>(R.id.txt_genero)
        // val items = listOf("M", "F")
        // val adapter = ArrayAdapter(this, com.google.android.material.R.layout.material_chip_input_combo, items)
        // (textField.editText as? AutoCompleteTextView)?.setAdapter(adapter)
    }

}