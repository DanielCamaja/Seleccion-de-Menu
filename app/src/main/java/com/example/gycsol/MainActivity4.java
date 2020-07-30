package com.example.gycsol;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainActivity4 extends AppCompatActivity {


    EditText emaillogin,passwordlogin;
    ImageButton btn1;
    Connection con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        emaillogin = (EditText)findViewById(R.id.emaillogin);
        passwordlogin = (EditText)findViewById(R.id.passwordlogin);
        btn1 = (ImageButton) findViewById(R.id.btnlogin);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MainActivity4.checkLogin().execute("");
            }
        });

    }

    public class checkLogin extends AsyncTask<String, String, String> {

        String z = null;
        Boolean isSuccess = false;


        @Override
        protected void onPreExecute() {

        }

        @Override
        protected void onPostExecute(String s) {

        }

        @Override
        protected String doInBackground(String... strings) {
            con = connectionClass(ConnectionClass.un.toString(),ConnectionClass.pass.toString(),ConnectionClass.db.toString(),ConnectionClass.ip.toString());
            if(con == null){
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity4.this,"Check Internet Connection",Toast.LENGTH_LONG).show();
                    }
                });
                z = "On Internet Connection";
            }
            else {
                try {
                    String sql = "SELECT * FROM SUPERVISORCOMEDOR WHERE RUT = '" + emaillogin.getText() + "' AND PASS = '" + passwordlogin.getText() + "' ";
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(sql);

                    if (rs.next()) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity4.this, "Login Success", Toast.LENGTH_LONG).show();
                            }
                        });
                        z = "Success";

                        Intent intent = new Intent(MainActivity4.this, MainActivity5.class);
                        startActivity(intent);
                        finish();
                    } else {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity4.this, "Check email or password", Toast.LENGTH_LONG).show();
                            }
                        });

                        emaillogin.setText("");
                        passwordlogin.setText("");
                    }
                } catch (Exception e) {
                    isSuccess = false;
                    Log.e("SQL Error : ", e.getMessage());
                }
            }
            return z;
        }
    }

    @SuppressLint("NewApi")
    public Connection connectionClass(String user, String password, String database, String server){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection = null;
        String connectionURL = null;
        try{
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            connectionURL = "jdbc:jtds:sqlserver://" + server+"/" + database + ";user=" + user + ";password=" + password + ";";
            connection = DriverManager.getConnection(connectionURL);
        }catch (Exception e){
            Log.e("SQL Connection Error : ", e.getMessage());
        }

        return connection;
    }
}