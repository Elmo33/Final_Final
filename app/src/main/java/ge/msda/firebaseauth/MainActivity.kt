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

    // ვქნით FirebaseAuth-ის ტიპის auth-ს და  DatabaseReference-ის ტიპის db-ს

    private lateinit var auth: FirebaseAuth
    private lateinit var db: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // getInstance() ფუნქციით database უკავშირდება სასურველ ფოლდერს realtime DB-ში

        db = FirebaseDatabase.getInstance().getReference("UserInfo")

        // ვუკავშირებთ Firebaseauthს და auth object-ს ერთმანეთს
        
        auth = FirebaseAuth.getInstance()

        // ვამომწებთ არის თუ არა უკვე შესული მომხმარებელი აპლიკაციაში
        // თუ არ არის მაშინ გადავდივართ ლოგინ აქთივითიზე და ვხურავთ მთავარს
        // თუ არის ვატყობინებთ რომ უკვკე შესულია და ვიძახებთ ინფორმაციის ჩამოტვირთვის ფუნქციას
        
        if (auth.currentUser == null) {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Already logged in", Toast.LENGTH_LONG).show()
            getUserInfo()
        }
        
        // ვაკონკრეტებთ თუ საიდან(რომელი view-დან) უნდა მიიღოს ინფორმაცია ამ აქტივიტიმ
        setContentView(R.layout.activity_main)

        // გამოგვაქვს ეკრანზე მომხმარებლის ემაილი
        textView.text = auth.currentUser?.email

        
        // ოთხივე ღილაკს ვუკავშირებთ იმ აქტივიტის რომელზეც უნდა გადავიდეს მომხარებელი
        
        updateInfo.setOnClickListener {
            val intent = Intent(this, UpdateInfo::class.java)
            startActivity(intent)
        }

        logoutBtn.setOnClickListener {
            auth.signOut()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            // finish() ფუნქციით ხდება ამჟამინდელი აქტივიტის დახურვა
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
    
    
    // ვქმნით ფუნქციას რომელიც პასუხისმგებელია ინფორმაციის database-დან ჩამოტანაზე
    private fun getUserInfo() {

        //  .child(auth.currentUser?.uid!!) ით ვუკავშირდებით მომხმარებლის კუთვნილ ფოლდერს
        //  addValueEventListener ფუნქციით კი იწყება db-სთან დაკავშირება
        db.child(auth.currentUser?.uid!!)
            .addValueEventListener(object : ValueEventListener {
                
                // თუ ვერ მოხდა წაკითხვა მონაცემების კონსოლში ვხედავთ ამას
                override fun onCancelled(p0: DatabaseError) {
                    println("The read failed")
                }

                // თუ მოხდა წაკითხვა მაშინ ჩამოვტვირთავთ ინფორმაციას და დავუკავშირებთ UserInfo კლასს
                // ინფორმაციის უფრო კომპაქტურად შენახვისთვის
                override fun onDataChange(snap: DataSnapshot) {

                    val userInfo: UserInfo = snap.getValue(UserInfo::class.java) ?: return

                    // დაკავშირებული ინფორმაცია გამოგვაქვს ერკანზე
                    showFullName.text = "Name: " + userInfo.name ?: ""
                    showPhone.text = "Phone: " + userInfo.mobile ?: ""
                    showAddress.text = "Address: " + userInfo.address ?: ""

                    // ვიყენებთ picasso library-ს ლინკის გამოყენებით სურათის საჩვენებლად
                    Picasso.get()
//                        .load("https://i.pinimg.com/originals/34/ed/17/34ed1783bb2ddd660686ac6a685270bf.jpg")
                        .load(userInfo.link)
                        .fit()
                        .into(imageView)


                }

            })

    }


}
