package ge.msda.firebaseauth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_to_do.*

class ToDoActivity : AppCompatActivity() {

    private lateinit var db: DatabaseReference
    lateinit var listView: ListView
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do)


        auth = FirebaseAuth.getInstance()
        db = FirebaseDatabase.getInstance().getReference("/UserInfo/" + auth.currentUser?.uid!! + "/ToDos/")
        val notToDos = arrayListOf<String>()



        TodoSubmit.setOnClickListener {
            val text = TodoText.text.toString()

            db.push().setValue(text).addOnCompleteListener {
                if(it.isSuccessful()){
                    Toast.makeText(this, "Success", Toast.LENGTH_LONG).show()
                }
                else {
                    Toast.makeText(this, it.exception.toString(), Toast.LENGTH_LONG).show() }
            }
            TodoText.setText("")
            notToDos.clear()
        }


        db.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                println("The read failed")
            }

            override fun onDataChange(p0: DataSnapshot) {
                for (i in p0.children) {
                    val notToDo: String = i.value.toString()
                    notToDos.add(notToDo)
                }
                listView = findViewById(R.id.listview)
                listView.adapter = ArrayAdapter<String>(
                    this@ToDoActivity,
                    R.layout.listview,
                    notToDos
                )
            }
        })
    }
}
