package hr.santolin.climbingnotebook.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "climbed_entry")
data class ClimbedEntryEntity(
    @PrimaryKey var mountain:String,
    @ColumnInfo(name="location") var location:String,
    @ColumnInfo(name="routeName") var routeName:String,
    @ColumnInfo(name="routeGrade") var routeGrade:String,
    @ColumnInfo(name="routeHeight") var routeHeight:String,
    @ColumnInfo(name="isMultipitch") var isMultipitch:Boolean,
    @ColumnInfo(name="description") var description: String
)

/*   @PrimaryKey(autoGenerate = true)
   var id: Int, */
