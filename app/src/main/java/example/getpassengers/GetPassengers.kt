//Manoj Budathoki
//CS-3031-001

package example.getpassengers

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class GetPassengers : AppCompatActivity() {
    private val passList: MutableList<Passenger> = ArrayList()
    private lateinit var textPut: TextView
    private lateinit var textFirst: EditText
    private lateinit var textLast: EditText
    private lateinit var textPhone: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_passengers)

        textPut = findViewById(R.id.accum_list)
        textFirst = findViewById(R.id.first_name)
        textLast = findViewById(R.id.last_name)
        textPhone = findViewById(R.id.phone_number)
    }

    fun enterPassenger(view: View) {
        val fName = textFirst.text.toString()
        val lName = textLast.text.toString()
        val phone = textPhone.text.toString()

        if (fName.isNotBlank() && lName.isNotBlank() && phone.isNotBlank()) {
            val passenger = Passenger(fName, lName, phone)
            passList.add(passenger)
            textPut.append("\n${passenger}\n")

            textFirst.text.clear()
            textLast.text.clear()
            textPhone.text.clear()
        }
    }

    fun backToMain(view: View) {
        val intent = Intent()
        intent.putExtra("COUNT", passList.size.toString())
        for (i in passList.indices) {
            intent.putExtra("PASS${i + 1}", passList[i].toString())
        }
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}