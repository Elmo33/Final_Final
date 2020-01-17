package ge.msda.firebaseauth

import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_forgot_password.*
import kotlinx.android.synthetic.main.activity_update_password.*

class UpdatePasswordActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_password)

        auth = FirebaseAuth.getInstance()

        ChangeBack.setOnClickListener {
            finish()
        }

        ChangePassword.setOnClickListener {

            val password: String = PasswordReset.text.toString()

            if (TextUtils.isEmpty(password)) {

                Toast.makeText(this, "Please enter password", Toast.LENGTH_LONG).show()

            }
            else if(password.length < 6){
                Toast.makeText(this, "Password must be at least 6 characters long", Toast.LENGTH_LONG).show()
            }else {

                auth.currentUser?.updatePassword(password)
                    ?.addOnCompleteListener(this, OnCompleteListener { task ->
                        if (task.isSuccessful) {

                            Toast.makeText(this, "Password changed successfully", Toast.LENGTH_LONG)
                                .show()
                            finish()

                        } else {

                            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG)
                                .show()

                        }
                    })

            }

        }

    }


}