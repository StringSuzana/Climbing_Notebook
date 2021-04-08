package hr.santolin.climbingnotebook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import androidx.recyclerview.widget.LinearLayoutManager
import hr.santolin.climbingnotebook.databases.AppDatabase
import hr.santolin.climbingnotebook.entities.ClimbedEntryEntity
import hr.santolin.climbingnotebook.utils.startActivity
import kotlinx.android.synthetic.main.activity_climbed.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ClimbedActivity : AppCompatActivity() {
    private var items = mutableListOf<ClimbedEntryEntity>()
    private val itemadapter = ClimbedAdapter(items)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        setContentView(R.layout.activity_climbed)
        bottomNavigationView.background = null
        bottomNavigationView.menu.getItem(2).isEnabled = false
        showClimbed()

    }

    private fun showClimbed() {
        val db = AppDatabase(this)
        GlobalScope.launch {// not encouraged?
            val data = db.climbedEntryDao().getAll()
            if (data.isNotEmpty()) {
                data.forEach{
                    items.add(it)
                }
                initWidgets()
            }
        }
    }

    private fun initWidgets() {

        rvItems.apply {
            layoutManager = LinearLayoutManager(this@ClimbedActivity)
            adapter = itemadapter
        }

    }

    fun addNewOnClick(view: View) {
        startActivity<FillFormActivity>()
    }
}















/*  private fun addItem() {

      adapter.notifyItemInserted(items.size-1)
  }*/