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
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import ni.edu.uca.usolibreriaroom.MainDataBase
import ni.edu.uca.usolibreriaroom.R
import ni.edu.uca.usolibreriaroom.adapter.UserAdapter
import ni.edu.uca.usolibreriaroom.dao.UsuarioDao
import ni.edu.uca.usolibreriaroom.databinding.FragmentUsuarioBinding
import ni.edu.uca.usolibreriaroom.databinding.ItemUsuarioBinding


class UsuarioFragment : Fragment() {

    lateinit var binding: FragmentUsuarioBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentUsuarioBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db: MainDataBase = MainDataBase.getInstace(this.requireContext().applicationContext)
        val dao: UsuarioDao = db.usuarioDao()
        CoroutineScope(Dispatchers.Main).launch {
            val list = dao.getAll()
            binding.rvUsuario.layoutManager = LinearLayoutManager(context)
            binding.rvUsuario.adapter = UserAdapter(list)
        }

        binding.btnAdd.setOnClickListener{
            findNavController().navigate(R.id.action_usuarioFragment_to_agregarUsuarioFragment)
        }
    }

}