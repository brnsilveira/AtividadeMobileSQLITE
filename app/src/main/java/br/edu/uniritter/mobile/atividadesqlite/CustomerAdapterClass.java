package br.edu.uniritter.mobile.atividadesqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomerAdapterClass extends RecyclerView.Adapter<CustomerAdapterClass.ViewHolder> {
    List<CustomerModelClass> customer;
    Context context;
    DatabaseHelperClass databaseHelperClass;

    public CustomerAdapterClass(List<CustomerModelClass> customer, Context context) {
        this.customer = customer;
        this.context = context;
        databaseHelperClass = new DatabaseHelperClass(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.customer_item_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final CustomerModelClass customerModelClass = customer.get(position);

        holder.textViewID.setText(Integer.toString(customerModelClass.getId()));
        holder.editText_Name.setText(customerModelClass.getName());
        holder.editText_Email.setText(customerModelClass.getEmail());

    }

    @Override
    public int getItemCount() {
        return customer.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewID;
        EditText editText_Name;
        EditText editText_Email;
        Button button_Edit;
        Button button_delete;

        public ViewHolder (@NonNull View itemView) {
            super(itemView);

            textViewID = itemView.findViewById(R.id.text_id);
            editText_Name = itemView.findViewById(R.id.edittext_name);
            editText_Email = itemView.findViewById(R.id.edittext_email);
            button_delete = itemView.findViewById(R.id.button_delete);
            button_Edit = itemView.findViewById(R.id.button_edit);
        }
    }
}
