package ge.msda.firebaseauth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var db: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        db = FirebaseDatabase.getInstance().getReference("UserInfo")
        auth = FirebaseAuth.getInstance()

        if (auth.currentUser == null) {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Already logged in", Toast.LENGTH_LONG).show()
            getUserInfo()
        }

        setContentView(R.layout.activity_main)

        textView.text = auth.currentUser?.email

        updateInfo.setOnClickListener {
            val intent = Intent(this, UpdateInfo::class.java)
            startActivity(intent)
        }

        logoutBtn.setOnClickListener {
            auth.signOut()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        updatePasswordBtn.setOnClickListener {
            val intent = Intent(this, UpdatePasswordActivity::class.java)
            startActivity(intent)
        }

        AppsButton.setOnClickListener {
            val intent = Intent(this, AppsActivity::class.java)
            startActivity(intent)
        }

    }
    private fun getUserInfo() {

        db.child(auth.currentUser?.uid!!)
            .addValueEventListener(object : ValueEventListener {

                override fun onCancelled(p0: DatabaseError) {
                    println("The read failed")
                }

                override fun onDataChange(snap: DataSnapshot) {

                    val userInfo: UserInfo = snap.getValue(UserInfo::class.java) ?: return

                    showFullName.text = "Name: " + userInfo.name ?: ""
                    showPhone.text = "Phone: " + userInfo.mobile ?: ""
                    showAddress.text = "Address: " + userInfo.address ?: ""


                    Picasso.get()
//                        .load("https://i.pinimg.com/originals/34/ed/17/34ed1783bb2ddd660686ac6a685270bf.jpg")
                        .load(userInfo.link)
                        .fit()
                        .into(imageView)



                }

            })

    }


}