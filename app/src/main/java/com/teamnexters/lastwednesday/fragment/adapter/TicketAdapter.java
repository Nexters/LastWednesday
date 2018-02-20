package com.teamnexters.lastwednesday.fragment.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ramotion.foldingcell.FoldingCell;
import com.teamnexters.lastwednesday.R;
import com.teamnexters.lastwednesday.databinding.ItemTicketBinding;
import com.teamnexters.lastwednesday.model.Ticket;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.subjects.PublishSubject;

/**
 * Created by JY on 2018-01-12.
 */

public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.TicketViewHolder> implements View.OnClickListener {

    private List<Ticket> dataSet;
    private PublishSubject<Ticket> publishSubject;

    public TicketAdapter (  ) {
        this.dataSet = new ArrayList<>();
        this.publishSubject = PublishSubject.create();
    }

    @Override
    public TicketViewHolder onCreateViewHolder ( ViewGroup parent, int viewType ) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ticket, parent, false);
        itemView.setOnClickListener(this);
        return new TicketViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder ( TicketViewHolder holder, int position ) {
        Ticket ticket = dataSet.get(position);
        holder.binding.setObj(ticket);

    }

    @Override
    public int getItemCount () {
        return (dataSet != null ? dataSet.size() : 0);
    }

    public void updateData ( List<Ticket> items ) {
        this.dataSet.addAll(items);
        notifyDataSetChanged();
    }


    @Override
    public void onClick ( View v ) {
        ((FoldingCell) v).toggle(false);
    }

    public PublishSubject<Ticket> getPublishSubject () {
        return publishSubject;
    }


    static class TicketViewHolder extends RecyclerView.ViewHolder {

        ItemTicketBinding binding;

        private TicketViewHolder ( View itemView ) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }

}
