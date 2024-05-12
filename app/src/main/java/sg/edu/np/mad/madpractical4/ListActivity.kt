package sg.edu.np.mad.madpractical4

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Random

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_list)
        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById(R.id.main)
        ) { v: View, insets: WindowInsetsCompat ->
            val systemBars =
                insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Profile")
        builder.setMessage("MADness")
        builder.setNegativeButton(
            "CLOSE"
        ) { dialog, which -> dialog.dismiss() }
        builder.setPositiveButton(
            "VIEW"
        ) { dialog, which ->
            val openActivity = Intent(
                this@ListActivity,
                MainActivity::class.java
            )
            val random = Random().nextInt(999999)
            openActivity.putExtra("ranVal", random)
            startActivity(openActivity)
        }
        val imgClick = findViewById<ImageView>(R.id.ImageClick)
        imgClick.setOnClickListener { v: View? ->
            val alert = builder.create()
            alert.show()
        }
    }
}