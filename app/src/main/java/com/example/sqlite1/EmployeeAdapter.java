package com.example.sqlite1;

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

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {
    List<EmployeeModel> employee;
    Context context;

    public EmployeeAdapter(List<EmployeeModel> employee, Context context) {
        this.employee = employee;
        this.context = context;
        databaseHelper = new DatabaseHelper(context);
    }

    DatabaseHelper databaseHelper;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.employee_item_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final EmployeeModel employeeModel = employee.get(position);
        holder.textViewID.setText(Integer.toString(employeeModel.getId()));
        holder.editText_name.setText(employeeModel.getName());
        holder.editText_email.setText(employeeModel.getEmail());
        holder.editText_phone.setText(employeeModel.getPhone());
        holder.editText_address.setText(employeeModel.getAddress());

    }

    @Override
    public int getItemCount() {
        return employee.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewID;
        EditText editText_name;
        EditText editText_email;
        EditText editText_phone;
        EditText editText_address;
        Button exit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewID = itemView.findViewById(R.id.textViewID);
            editText_name = itemView.findViewById(R.id.editTextname);
            editText_email = itemView.findViewById(R.id.editTextemail);
            editText_address = itemView.findViewById(R.id.editTextaddress);
            editText_phone = itemView.findViewById(R.id.editTextphone);
            exit = itemView.findViewById(R.id.Exit);
        }
    }
}
