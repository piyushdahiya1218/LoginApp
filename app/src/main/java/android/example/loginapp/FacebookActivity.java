package android.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.widget.ProfilePictureView;

import org.w3c.dom.Text;

public class FacebookActivity extends AppCompatActivity {

    ImageView imageView;
    TextView nametextview, birthdaytextview, gendertexview, emailtextview;
    Button fblogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook);
        imageView = (ImageView)findViewById(R.id.imageView);
        nametextview = (TextView)findViewById(R.id.fbname);
        birthdaytextview = (TextView)findViewById(R.id.fbbirthday);
        gendertexview = (TextView)findViewById(R.id.fbgender);
        emailtextview = (TextView)findViewById(R.id.fbemail);
        fblogout = (Button)findViewById(R.id.fblogout);

        Intent intent = getIntent();

        String id = intent.getStringExtra("id");
        String image_url = "https://graph.facebook.com/" + id + "/picture?type=large";
        Glide.with(this).load(image_url).into(imageView);

        String name = intent.getStringExtra("name");
        nametextview.setText(name);

        String birthday = intent.getStringExtra("birthday");
        birthdaytextview.setText("Birthday : "+birthday);

        String gender = intent.getStringExtra("gender");
        gendertexview.setText("Gender : "+gender);

        String email = intent.getStringExtra("email");
        emailtextview.setText("Email : "+email);

        fblogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginManager.getInstance().logOut();
                Toast.makeText(FacebookActivity.this, "Logged out", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(FacebookActivity.this, MainActivity.class);
//                startActivity(intent);
                finish();
            }
        });
    }
}