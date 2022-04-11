package ni.edu.uca.usolibreriaroom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ni.edu.uca.usolibreriaroom.dao.UsuarioDao
import ni.edu.uca.usolibreriaroom.entidades.UsuarioEntity

interface MainDataBaseProvider{
    fun usuarioDao() : UsuarioDao
}
@Database(entities = [UsuarioEntity::class], version =1 )
abstract class MainDataBase: RoomDatabase(), MainDataBaseProvider{
    abstract override fun usuarioDao(): UsuarioDao
    companion object{
        @Volatile
        private var INSTANCE: MainDataBase? = null
        fun getInstace(context: Context):MainDataBase{
            synchronized(this){
                var instance = INSTANCE
                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MainDataBase::class.java,
                        "usuario_main_db"
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
