package ge.msda.firebaseauth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_update_info.*

class UpdateInfo : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var db: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_info)

        init()

        UpdateInfoBtn.setOnClickListener {

            val n: String = inputFullName.text.toString()
            val p: String = inputPhone.text.toString()
            val a: String = inputAddress.text.toString()
            val l: String = inputLink.text.toString()

            if (TextUtils.isEmpty(n)) {
                Toast.makeText(this, "Empty name!", Toast.LENGTH_LONG).show()
            } else {
                contactInfo(n, p, a, l)
                Toast.makeText(this, "Information has been updated", Toast.LENGTH_LONG).show()
            }

        }

        UpdateBack.setOnClickListener {
            finish()
        }

    }
    private fun init() {

        auth = FirebaseAuth.getInstance()
        db = FirebaseDatabase.getInstance().getReference("UserInfo")

        addUserInfoChangeListener()

    }
    private fun contactInfo(name: String, phone: String?, address: String?, link: String?) {
        val userInfo = UserInfo(name, phone, address, link)
        db.child(auth.currentUser?.uid!!).child("Info").setValue(userInfo).addOnCanceledListener {
            Toast.makeText(this, "Success", Toast.LENGTH_LONG).show()
        }
    }
    private fun addUserInfoChangeListener() {

        db.child(auth.currentUser?.uid!!)
            .addValueEventListener(object : ValueEventListener {

                override fun onCancelled(p0: DatabaseError) {

                }

                override fun onDataChange(snap: DataSnapshot) {

                    inputFullName.setText("")
                    inputPhone.setText("")
                    inputAddress.setText("")
                    inputLink.setText("")

                }

            })

    }

}

