package id.djaka.adapterdelegatedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.djaka.adapterdelegatedemo.example.feed.ui.delegate.withoutholder.WithoutHolderActivity
import id.djaka.adapterdelegatedemo.example.feed.ui.old.OldActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_old_way.setOnClickListener {
            startActivity(Intent(this, OldActivity::class.java))
        }

        button_adapter_delegate.setOnClickListener {
            startActivity(Intent(this, WithoutHolderActivity::class.java))
        }
    }
}
