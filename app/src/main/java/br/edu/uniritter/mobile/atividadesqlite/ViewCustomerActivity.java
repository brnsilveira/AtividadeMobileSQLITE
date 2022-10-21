package br.edu.uniritter.mobile.atividadesqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class ViewCustomerActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_customer);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(this);
        List<CustomerModelClass> customerModelClasses = databaseHelperClass.getCustomerList();

        if(customerModelClasses.size() > 0) {
            CustomerAdapterClass customeradapterclass = new CustomerAdapterClass(customerModelClasses, ViewCustomerActivity.this);

        } else {
            Toast.makeText(this, "There is no customer in the database", Toast.LENGTH_SHORT).show();
        }

    }
}