package android.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class GoogleActivity extends AppCompatActivity {

    TextView nametextview, emailtextview;
    ImageView profilepicimageview;
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google);

        nametextview = (TextView)findViewById(R.id.Gname);
        emailtextview = (TextView)findViewById(R.id.Gemail);
        profilepicimageview = (ImageView)findViewById(R.id.Gprofilepic);
        logout = (Button)findViewById(R.id.Glogout);

        Intent intent = getIntent();

        String profilepicurl = intent.getStringExtra("profilepic");
        Uri profilepicuri = Uri.parse(profilepicurl);
        Glide.with(this).load(profilepicuri).into(profilepicimageview);

        String name = intent.getStringExtra("name");
        nametextview.setText(name);

        String email = intent.getStringExtra("email");
        emailtextview.setText(email);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoogleSignInOptions gso = new GoogleSignInOptions.
                        Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).
                        build();

                GoogleSignInClient googleSignInClient= GoogleSignIn.getClient(getApplicationContext(),gso);
                googleSignInClient.signOut();
                Toast.makeText(GoogleActivity.this, "Logged out", Toast.LENGTH_SHORT).show();
//                Intent intent  = new Intent(GoogleActivity.this, MainActivity.class);
//                startActivity(intent);
                finish();
            }
        });
    }
}