package ni.edu.uca.usolibreriaroom.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ni.edu.uca.usolibreriaroom.MainDataBase
import ni.edu.uca.usolibreriaroom.R
import ni.edu.uca.usolibreriaroom.adapter.UserAdapter
import ni.edu.uca.usolibreriaroom.dao.UsuarioDao
import ni.edu.uca.usolibreriaroom.databinding.FragmentAgregarUsuarioBinding
import ni.edu.uca.usolibreriaroom.databinding.FragmentUsuarioBinding
import ni.edu.uca.usolibreriaroom.entidades.UsuarioEntity


class AgregarUsuarioFragment : Fragment() {

    lateinit var binding: FragmentAgregarUsuarioBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentAgregarUsuarioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db: MainDataBase = MainDataBase.getInstace(this.requireContext().applicationContext)
        val dao: UsuarioDao = db.usuarioDao()

            with(binding){
                btnGuardar.setOnClickListener{
                    val us = UsuarioEntity(
                        0,
                        itemPassword.text.toString(),
                        itemEmail.text.toString(),
                        itemNombre.text.toString(),
                        itemApellido.text.toString()
                    )
                    CoroutineScope(Dispatchers.Main).launch {
                        dao.insert(us)
                    }

                    findNavController().navigate(R.id.action_agregarUsuarioFragment_to_usuarioFragment)
                }
            }

    }

}