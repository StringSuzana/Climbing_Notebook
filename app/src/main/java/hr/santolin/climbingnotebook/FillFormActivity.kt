package hr.santolin.climbingnotebook

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import hr.santolin.climbingnotebook.databases.AppDatabase
import hr.santolin.climbingnotebook.entities.ClimbedEntryEntity
import hr.santolin.climbingnotebook.utils.showToast
import hr.santolin.climbingnotebook.utils.startActivity
import kotlinx.android.synthetic.main.activity_fill_form.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

private lateinit var validationFields: List<EditText>

class FillFormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fill_form)
        init()
        setUpListeners()
    }

    private fun init() {
      //  validationFields = listOf(etMountain, etDate, etDescription, etRouteName, etRouteGrade)
        validationFields = listOf(etMountain,etRouteName)
    }

    private fun setUpListeners() {
        val rightNow:Date = Calendar.getInstance().time


        btnSubmitForm.setOnClickListener {
            if (formValid()) {
          /*      val db = Room.databaseBuilder(
                    applicationContext,
                    AppDatabase::class.java, "climbed_database.db"
                ).build()*/
                 val db = AppDatabase(this)
                GlobalScope.launch {
                    var entry = ClimbedEntryEntity(
                        mountain = etMountain.text.toString(),
                        description = etDescription.text.toString(),
                        isMultipitch = cbIsMultipitch.isChecked,
                        location = etLocation.text.toString(),
                        routeGrade = etRouteGrade.text.toString(),
                        routeHeight = etNumHeight.text.toString(),
                        routeName = etRouteName.text.toString()
                    )

                    db.climbedEntryDao().insert(entry)
                }
                startActivity<ClimbedActivity>()
            } else {
                showToast("ve valja", Toast.LENGTH_SHORT)
            }
        }
    }

 /*   private fun showAnimation() {
        ivMountain.setImageResource(R.drawable.articles)
        ivMountain.applyAnimation(R.anim.blink)
    }*/

    private fun formValid(): Boolean {
        var valid:Boolean = true
        validationFields.forEach {
            if (it.text.toString().isBlank()) {
                it.error = getString(R.string.errorMsg_insert_text)
                it.requestFocus()
                valid = false
            }
        }
        return valid
    }

    //ivNekaSlika.setImageDrawable(null) makni sliku
}