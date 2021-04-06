package hr.santolin.climbingnotebook.databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import hr.santolin.climbingnotebook.daos.ClimbedEntryDao
import hr.santolin.climbingnotebook.entities.ClimbedEntryEntity


@Database(entities = arrayOf(ClimbedEntryEntity::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
abstract fun climbedEntryDao(): ClimbedEntryDao
    companion object {
        @Volatile private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it}
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
            AppDatabase::class.java, "climbed_database.db")
            .build()
    }
/* primjer iz https://developer.android.com/codelabs/android-room-with-a-view-kotlin#13
   companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "climbed_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }*/
}