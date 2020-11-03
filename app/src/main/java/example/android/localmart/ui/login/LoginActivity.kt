package example.android.localmart.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import example.android.localmart.R
import example.android.localmart.ui.home.HomeActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginBtn.setOnClickListener {

            if(loginId.text.isEmpty() || loginPassword.text.isEmpty()){
                Toast.makeText(this, "Please fill the empty fields", Toast.LENGTH_SHORT).show()
            }else{
                var intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
        }


    }
}
