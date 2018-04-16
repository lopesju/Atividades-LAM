//Júlia Lopes Olivier

package com.example.alunos.androidqrcodescannerurl;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

import static java.lang.Boolean.FALSE;


public class MainActivity extends AppCompatActivity
        implements View.OnClickListener{
    private Button btnScan;
    private TextView lblUrl,lblName, lblAddress;
    private String aUrl;
    private IntentIntegrator qrScan;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnScan = findViewById(R.id.btnScan);
        lblName = findViewById(R.id.lblName);
        lblAddress = findViewById(R.id.lblAddress);
        lblUrl = findViewById(R.id.lblUrl);
        aUrl = lblUrl.getText().toString();
        qrScan = new IntentIntegrator(this);
        btnScan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        qrScan.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null){
                Toast.makeText(this, "Result Not Found", Toast.LENGTH_LONG).show();
            }else {
                try{
                    String string = result.getContents();
                    if((string.startsWith("http")!=FALSE)){
                        Intent intencao = new Intent(Intent.ACTION_VIEW, Uri.parse(string.toLowerCase()));
                        startActivity(intencao);
                    }else{
                        JSONObject obj = new JSONObject(result.getContents());
                        lblName.setText(obj.getString("name"));
                        lblAddress.setText(obj.getString("address"));
                    }
                }catch (JSONException e){
                    e.printStackTrace();
                    Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
                }
            }
        }else{
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
