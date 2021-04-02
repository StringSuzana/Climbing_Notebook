package hr.santolin.climbingnotebook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.Toast
import hr.santolin.climbingnotebook.utils.*
import kotlinx.android.synthetic.main.activity_splash_screen.*

private const val DATA_IMPORTED ="hr.santolin.climbingnotebook.DATA_IMPORTED"
private const val DELAY =1500L
class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        startAnimations()
        redirect()
    }

    private fun redirect() {
        setBooleanPreference(DATA_IMPORTED,true)
        if(getBooleanPreference(DATA_IMPORTED)){
            Handler(Looper.getMainLooper()).postDelayed({
                startActivity<ClimbedActivity>()
            }, DELAY)
        }else{
            if(isOnline()){
                //start service
            }else{
                showToast("Connect to internet", Toast.LENGTH_LONG)

            }

        }
    }

    private fun startAnimations() {
        //ivSplash.applyAnimation(R.anim.blink)
        tvSplash.applyAnimation(R.anim.blink)
    }
}