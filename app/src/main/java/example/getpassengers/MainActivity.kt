//Manoj Budathoki
//CS-3031-001

package example.getpassengers

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    private lateinit var listText: TextView

    private val startForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { activityResult ->
        if (activityResult.resultCode == Activity.RESULT_OK) {
            val data = activityResult.data
            val count = (data?.getStringExtra("COUNT") ?: "").toIntOrNull() ?: 0
            listText.text = "RETURNED PASSENGER LIST\n"
            for (i in 1..count) {
                val passengerInfo = data?.getStringExtra("PASS$i") ?: ""
                listText.append("$passengerInfo\n")
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listText = findViewById(R.id.show_list)
        val getListButton: Button = findViewById(R.id.get_list_button)

        getListButton.setOnClickListener {
            val intent = Intent(this, GetPassengers::class.java)
            startForResult.launch(intent)
        }
    }
}

data class Passenger(val fName: String, val lName: String, val phone: String) {
    override fun toString(): String {
        return "$fName $lName $phone"
    }
}