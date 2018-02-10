package com.teamnexters.lastwednesday.fragment.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.teamnexters.lastwednesday.R;
import com.teamnexters.lastwednesday.databinding.ItemTicketBinding;
import com.teamnexters.lastwednesday.model.Ticket;

import java.util.List;

/**
 * Created by JY on 2018-01-12.
 */

public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.TicketViewHolder> {

    private List<Ticket> dataSet;

    public TicketAdapter(List<Ticket> dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public TicketViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ticket, parent, false);

        return new TicketViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TicketViewHolder holder, int position) {
        Ticket ticket = dataSet.get(position);

        holder.binding.setObj(ticket); //xml파일의 variable 설정.
    }

    @Override
    public int getItemCount() {
        return (dataSet != null ? dataSet.size() : 0);
    }

    static class TicketViewHolder extends RecyclerView.ViewHolder {

        ItemTicketBinding binding;

        public TicketViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}
