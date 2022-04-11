package ni.edu.uca.usolibreriaroom.dao

import androidx.room.*
import ni.edu.uca.usolibreriaroom.entidades.UsuarioEntity

@Dao
interface UsuarioDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(usuario: UsuarioEntity)

    @Query("SELECT * FROM TblUsuarios")
    suspend fun getAll(): List<UsuarioEntity>

    @Query("SELECT * FROM TblUsuarios WHERE idUsuario = :id")
    suspend fun getById(id : Int) : UsuarioEntity

    @Update
    fun update(usuario: UsuarioEntity)

    @Delete
    fun delete(usuario: UsuarioEntity)
}