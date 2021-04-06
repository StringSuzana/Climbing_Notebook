package hr.santolin.climbingnotebook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import hr.santolin.climbingnotebook.databases.AppDatabase
import hr.santolin.climbingnotebook.entities.ClimbedEntryEntity
import kotlinx.android.synthetic.main.activity_climbed.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ClimbedActivity : AppCompatActivity() {
    private var items = mutableListOf<ClimbedEntryEntity>()
    private val itemadapter = ClimbedAdapter(items)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_climbed)
        showClimbed()
    }

    private fun showClimbed() {
        val db = AppDatabase(this)
        GlobalScope.launch {
            val data = db.climbedEntryDao().getAll()
            if (data.isNotEmpty()) {
                data.forEach{
                    items.add(it)
                }
                initWidgets()

                //addItem()
            }
            /*  data.forEach {
                  tvClimbed.text=tvClimbed.text.toString() + "\n ${it.mountain}, ${it.routeName}"
              }*/
        }
    }

  /*  private fun addItem() {

        adapter.notifyItemInserted(items.size-1)
    }*/

    private fun initWidgets() {
        rvItems.apply {
            layoutManager = LinearLayoutManager(this@ClimbedActivity)
            adapter = itemadapter
        }
    }
}