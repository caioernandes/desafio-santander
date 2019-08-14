package com.example.santanderdesafio.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.santanderdesafio.R;
import com.example.santanderdesafio.statements.StatementsModel;

import java.util.ArrayList;

public class StatementsAdapter extends RecyclerView.Adapter<StatementsAdapter.StatementViewHolder> {

    ArrayList<StatementsModel> statements;

    public StatementsAdapter(ArrayList<StatementsModel> statements) {
        this.statements = statements;
    }

    @NonNull
    @Override
    public StatementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.statement_item, parent, false);
        return new StatementViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull StatementViewHolder holder, int position) {
        holder.txtTitle.setText(statements.get(position).getTitle());
        holder.txtDescription.setText(statements.get(position).getDescription());
        holder.txtDate.setText(statements.get(position).getDate());
        holder.txtValue.setText(String.valueOf(statements.get(position).getValue()));
    }

    @Override
    public int getItemCount() {
        return statements.size();
    }

    static class StatementViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView txtTitle;
        TextView txtDescription;
        TextView txtDate;
        TextView txtValue;

        StatementViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cv);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtDescription = itemView.findViewById(R.id.txtDesc);
            txtDate = itemView.findViewById(R.id.txtDate);
            txtValue = itemView.findViewById(R.id.txtValue);
        }
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
