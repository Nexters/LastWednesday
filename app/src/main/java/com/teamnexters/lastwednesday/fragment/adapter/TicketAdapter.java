package com.teamnexters.lastwednesday.fragment.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.ramotion.foldingcell.FoldingCell;
import com.teamnexters.lastwednesday.MainActivity;
import com.teamnexters.lastwednesday.R;
import com.teamnexters.lastwednesday.databinding.ItemTicketBinding;
import com.teamnexters.lastwednesday.model.Ticket;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by JY on 2018-01-12.
 */

public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.TicketViewHolder> implements View.OnClickListener {

    private Context context;

    private List<Ticket> dataSet;
    private List<Ticket> selectedList;

    private PublishSubject<View> longClickSubject;
    private PublishSubject<Ticket> checkedSubject;

    private ActionMode mActionMode;
    private ActionMode.Callback mActionModeCallback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode ( ActionMode mode, Menu menu ) {
            ((MainActivity) context).actionModeState(true);

            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.ticket_menu, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode ( ActionMode mode, Menu menu ) {
            return false;
        }

        @Override
        public boolean onActionItemClicked ( ActionMode mode, MenuItem item ) {
            if ( item.getItemId() == R.id.menu_delete ) { //삭제메뉴(휴지통)클릭하면 선택된 항목 삭제.
                deleteDataSet();
                mode.finish();
                return true;
            }
            return false;
        }

        @Override
        public void onDestroyActionMode ( ActionMode mode ) {
            selectedList.clear();
            ((MainActivity) context).actionModeState(false);
            mActionMode = null;
            changeSelectState(false);
            changeCheckBoxVisibility(false);
        }
    };

    public TicketAdapter ( Context context ) {
        this.context = context;
        this.dataSet = new ArrayList<>();
        this.selectedList = new ArrayList<>();
        this.checkedSubject = PublishSubject.create();
        this.longClickSubject = PublishSubject.create();
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

        holder.getLongClickObservable().subscribe(longClickSubject);
        holder.getCheckedObservable(ticket).subscribe(checkedSubject);

    }

    @Override
    public int getItemCount () {
        return (dataSet != null ? dataSet.size() : 0);
    }

    public void onCheckedChangeEventPublish () { //체크박스의 체크상태가 변할때 실행
        checkedSubject
                .subscribe(data -> {
                    addSelectedItem(data);
                    if ( mActionMode != null )
                        mActionMode.setTitle(selectedList.size() + context.getString(R.string.select)); //선택된 항목의 개수를 액션바에 보여줌
                });
    }

    private void changeSelectState ( boolean state ) { //체크박스 선택상태 변경.
        Observable.fromIterable(dataSet)
                .filter(val -> val.isSelected() != state)
                .subscribe(data -> {
                    data.setSelected(state);
                    notifyDataSetChanged();
                });
    }

    private void addSelectedItem ( Ticket item ) {
        if ( !selectedList.contains(item) && item.isSelected() ) {
            selectedList.add(item);
        } else if ( !item.isSelected() && selectedList.contains(item) ) {
            selectedList.remove(item);
        }
    }

    public void onLongClickEventPublish () {
        longClickSubject
                .subscribe(v -> {
                    if ( mActionMode == null ) {
                        changeCheckBoxVisibility(true);
                        mActionMode = ((MainActivity) context).startActionMode(mActionModeCallback);
                    }
                });
    }

    private void changeCheckBoxVisibility ( boolean state ) {
        Observable.fromIterable(dataSet)
                .filter(data -> data.isLongClicked() !=state)
                .subscribe(data -> {
                    data.setLongClicked(state);
                    notifyDataSetChanged();
                });
    }

    public void updateDataSet ( List<Ticket> items ) {
        this.dataSet.addAll(items);
        notifyDataSetChanged();
    }

    private void deleteDataSet () {
        this.dataSet.removeAll(selectedList);
        notifyDataSetChanged();
    }

    @Override
    public void onClick ( View v ) {
        ((FoldingCell) v).toggle(false);
    }


    static class TicketViewHolder extends RecyclerView.ViewHolder {

        ItemTicketBinding binding;

        private TicketViewHolder ( View itemView ) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        private Observable<Ticket> getCheckedObservable ( Ticket item ) { //checkbox observable
            return Observable.create(e ->
                    binding.cellTitleTicket.checkTicket.setOnCheckedChangeListener(
                            ( compoundBtn, state ) -> {
                                item.setSelected(state);
                                e.onNext(item);
                            }
                    ));
        }

        private Observable<View> getLongClickObservable () {
            return Observable.create(e -> {
                itemView.setOnLongClickListener(view -> {
                    e.onNext(itemView);
                    return true;
                });
            });
        }
    }

}
