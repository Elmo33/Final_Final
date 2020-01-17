package ge.msda.firebaseauth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class CalculatorActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView

    private var operand: Double = 0.0
    private var operation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        resultTextView = findViewById(R.id.result_text_view)

    }

    fun numberClick(view: View) {
        if (view is TextView) {
            var number: String = view.text.toString()
            var result = resultTextView.text.toString()
            if (result == "0") {
                result = ""
            }

            resultTextView.text = result + number
        }
    }

    fun clear(view: View){
        resultTextView.text = ""
    }

    fun del(view: View){
        // ამოწმებს რამე თუა,რომ არ დაქრაშოს
        if (resultTextView.text.length > 0) {
            resultTextView.text = resultTextView.text.substring(0, resultTextView.text.length - 1)
        }

    }

    fun operationClick(view: View) {
        if (view is TextView) {
            operand = resultTextView.text.toString().toDouble()
            resultTextView.text = ""
            operation = view.text.toString()
        }
    }

    fun equalsClick(view: View) {
        // fixed here too
        if(resultTextView.text != "") {
            val secOperand: Double = resultTextView.text.toString().toDouble()
            when (operation) {
                "+" -> resultTextView.text = (operand + secOperand).toString()
                "-" -> resultTextView.text = (operand - secOperand).toString()
                "*" -> resultTextView.text = (operand * secOperand).toString()
                "/" -> resultTextView.text = (operand / secOperand).toString()
            }
        }
    }

}