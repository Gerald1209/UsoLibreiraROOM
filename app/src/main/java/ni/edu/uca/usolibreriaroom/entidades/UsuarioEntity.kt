package ni.edu.uca.usolibreriaroom.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="TblUsuarios")
data class UsuarioEntity(
    @PrimaryKey(autoGenerate = true)
    val idUsuario:Int = 0,
    @ColumnInfo(name = "passUsuario")
    val passUsuario: String,
    @ColumnInfo(name = "email")
    val email: String,
    @ColumnInfo(name = "nombres")
    val nombres: String,
    @ColumnInfo(name = "apellidos")
    val apellidos:String
)

