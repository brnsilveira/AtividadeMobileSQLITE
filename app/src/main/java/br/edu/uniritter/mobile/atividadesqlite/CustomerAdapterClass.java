package br.edu.uniritter.mobile.atividadesqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder (@NonNull View itemView) {
            super(itemView);
        }
    }
}
