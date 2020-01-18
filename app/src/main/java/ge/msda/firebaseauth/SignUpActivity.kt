package ge.msda.firebaseauth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var db: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        auth = FirebaseAuth.getInstance()
        db = FirebaseDatabase.getInstance().getReference("UserInfo")

        
        // signup ღილაკით შემოგმვაქვს მონაცემები 
        SignUp.setOnClickListener {

            val email: String = EmailSignup.text.toString()
            val password: String = PasswordSignup.text.toString()
            val passwordconfirm: String = PasswordConfirmSignup.text.toString()

            // ამოწმებს რომელიმე არის თუ არა ცარიელი
            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(passwordconfirm)) {

                Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_LONG).show()

            }
            // ამოწმებს თუ პაროლები ემთხვევა ერთმანეტს
            else if(password != passwordconfirm){
                Toast.makeText(this, "Passwords Do not match", Toast.LENGTH_LONG).show()
            }
            // ამოწმებს თუ პაროლის სიგრძე 6 ზე მეტია
            else if(password.length < 6){
                Toast.makeText(this, "Password must be at least 6 characters long", Toast.LENGTH_LONG).show()
            }
            // .createUserWithEmailAndPassword ფუნქციას ვაწვდით იმეილს და პაროლს რის შედეგადაც
            // ხდება რეგისტრაცია. წარმატებული რეგისტრაციისას მომხმარებელი გადაჰყავს მთავარ გვერდზე.
            else {

                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, OnCompleteListener { task ->
                        if (task.isSuccessful) {

                            Toast.makeText(this, "Successfully Registered", Toast.LENGTH_LONG)
                                .show()
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                            finish()

                        } else {

                            Toast.makeText(this, "Registration Failed ", Toast.LENGTH_LONG).show()

                        }
                    })

            }
        }

        // ლოგინ აქტივიტიზე დაბრუნებისთვის
        member.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }


    }


}
