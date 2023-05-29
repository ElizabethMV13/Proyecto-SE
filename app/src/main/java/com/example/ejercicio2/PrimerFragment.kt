package com.example.ejercicio2


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Switch
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import com.google.android.material.switchmaterial.SwitchMaterial
import androidx.fragment.app.Fragment


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PrimerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PrimerFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_primer, container, false)

        val DarkModeS = view.findViewById<SwitchMaterial>(R.id.switchModo)
        val DarkModeI = view.findViewById<ImageView>(R.id.imageModo)

// Obtener el estado actual del modo
        val currentNightMode = AppCompatDelegate.getDefaultNightMode()

// Establecer el estado inicial del Switch según el modo actual
        DarkModeS.isChecked = currentNightMode == AppCompatDelegate.MODE_NIGHT_YES

        DarkModeS.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // El Switch está marcado (estado: true)
                DarkModeS.text = getString(R.string.Modo1)
                DarkModeI.setImageResource(R.drawable.nights)
                println("mensaje2")
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                // El Switch no está marcado (estado: false)
                DarkModeS.text = getString(R.string.Modo2)
                DarkModeI.setImageResource(R.drawable.sunn)
                println("mensaje1")
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
            // Reiniciar la actividad para aplicar el cambio de modo
            requireActivity().recreate()
        }

        return view

    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PrimerFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PrimerFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}