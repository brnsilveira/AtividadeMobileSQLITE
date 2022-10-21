package br.edu.uniritter.mobile.atividadesqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText_name, editText_email;
    Button button_add, button_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_name = findViewById(R.id.edittext_name);
        editText_name = findViewById(R.id.edittext_email);

        button_add = findViewById(R.id.button_add);
        button_add = findViewById(R.id.button_view);

        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stringName = editText_name.getText().toString();
                String stringEmail = editText_email.getText().toString();

                if (stringName.length() <= 0 || stringEmail.length() <=0) {
                    Toast.makeText(MainActivity.this, "Enter All Data", Toast.LENGTH_SHORT).show();
                } else {
                    DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(MainActivity.this);
                    CustomerModelClass customerModelClass = new CustomerModelClass(stringName, stringEmail);
                    databaseHelperClass.addCustomer(customerModelClass);
                    Toast.makeText(MainActivity.this, "Add Customer Successfuly", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                }
            }
        });
    }
}