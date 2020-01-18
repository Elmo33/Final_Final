package ge.msda.firebaseauth

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    // ვქმნით auth object-ს და ვანიჭებთ მას FirebaseAuth-ის ტიპს

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // ვაკავშირებთ auth-ს Firebase-სთან
        
        auth = FirebaseAuth.getInstance()

        
        // login button ისთვის განკუთვნილი კოდი
        
        SignIn.setOnClickListener {
            
            // იღებს მომხმარებლის მიერ შეყვანილ იმეილს და პაროლს

            val email: String = EmailSignIn.text.toString()
            val password: String = PasswordSignIn.text.toString()

            // ამოწმებს არის თუ არა რომელიმე ხაზი ცარიელა
            
            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {

                Toast.makeText(this@LoginActivity, "Please fill all the fields", Toast.LENGTH_LONG)
                    .show()

            } else {
                
                // ვაწვდით ემაილს და პაროლს signInWithEmailAndPassword ფუნქციას რომლის წარმატებით
                // შესრულების შემთხვევაშიც გამოგვაქვს Toast
                
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, OnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Successfully Logged In", Toast.LENGTH_LONG).show()
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show()
                        }
                    })

            }
        }

        // რეგისტრაციისთვის განკუთვნილი ღილაკი
        
        notmember.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
            finish()
        }
        
        // პაროლის შეხსენებისთვის განკუთვნილი ღილაკი

        Forgot.setOnClickListener {
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }

    }


}
