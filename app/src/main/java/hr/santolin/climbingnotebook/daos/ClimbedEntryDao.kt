package hr.santolin.climbingnotebook.daos

import androidx.room.*
import hr.santolin.climbingnotebook.entities.ClimbedEntryEntity

@Dao
interface ClimbedEntryDao {
    @Query("SELECT * FROM climbed_entry")
    fun getAll(): List<ClimbedEntryEntity>

    @Query("SELECT * FROM climbed_entry WHERE mountain LIKE :mountain")
    fun findByMountain(mountain:String): ClimbedEntryEntity

    @Insert
    fun insert(vararg climbedentry: ClimbedEntryEntity)

    @Delete
    fun delete (climbedentry: ClimbedEntryEntity)

    @Update
    fun update (vararg climbedentry: ClimbedEntryEntity)

    /*
    //Making queries observable
    @Query("SELECT * FROM climbedentry WHERE mountain LIKE :mountain")
    fun findByTitle(mountain: String): LiveData<List<ClimbedEntryEntity>>*/
}