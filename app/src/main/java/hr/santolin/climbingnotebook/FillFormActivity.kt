package hr.santolin.climbingnotebook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_fill_form.*

class FillFormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fill_form)

        setUpListeners()
    }

    private fun setUpListeners() {
        btnSubmitForm.setOnClickListener{

        }
    }
}