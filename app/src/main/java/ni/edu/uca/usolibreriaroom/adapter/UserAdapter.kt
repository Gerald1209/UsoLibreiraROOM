package ni.edu.uca.usolibreriaroom.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ni.edu.uca.usolibreriaroom.databinding.ItemUsuarioBinding
import ni.edu.uca.usolibreriaroom.entidades.UsuarioEntity


class UserAdapter(val list:List<UsuarioEntity>):RecyclerView.Adapter<UserAdapter.UserViewHolder>(){

    private companion object DiffCallback : DiffUtil.ItemCallback<UsuarioEntity>() {

        override fun areItemsTheSame(oldItem: UsuarioEntity, newItem: UsuarioEntity): Boolean =
            oldItem.idUsuario == newItem.idUsuario

        override fun areContentsTheSame(oldItem: UsuarioEntity, newItem: UsuarioEntity): Boolean =
            oldItem.nombres == newItem.nombres && oldItem.apellidos == newItem.apellidos && oldItem.email==newItem.email

    }

    inner class UserViewHolder(private val binding: ItemUsuarioBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(us : UsuarioEntity) = binding.run {
            itemTitle.text = "${us.nombres} ${us.apellidos}"
            itemSubtitle.text = us.email


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder =
        UserViewHolder(ItemUsuarioBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) : Unit =
        holder.bind(list[position])

    override fun getItemCount(): Int =list.size
}