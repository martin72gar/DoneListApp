package com.martinsiregar.donelistapp.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.martinsiregar.donelistapp.EditActivity;
import com.martinsiregar.donelistapp.EditDonelistActivity;
import com.martinsiregar.donelistapp.Model.Kontak;
import com.martinsiregar.donelistapp.Model.ListDone;
import com.martinsiregar.donelistapp.R;

import java.util.List;

public class DoneListAdapter extends RecyclerView.Adapter<DoneListAdapter.MyViewHolder> {
    List<ListDone> mDoneList;

    public DoneListAdapter(List <ListDone> DoneList) {
        mDoneList = DoneList;
    }

    @Override
    public DoneListAdapter.MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.done_list, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder (MyViewHolder holder, final int position){
        holder.mTextViewId.setText("Id = " + mDoneList.get(position).getId());
        holder.mTextViewNama.setText(mDoneList.get(position).getNama());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), EditDonelistActivity.class);
                mIntent.putExtra("Id", mDoneList.get(position).getId());
                mIntent.putExtra("Nama", mDoneList.get(position).getNama());
                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount () {
        return mDoneList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewId, mTextViewNama;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewId = (TextView) itemView.findViewById(R.id.tvId);
            mTextViewNama = (TextView) itemView.findViewById(R.id.tvNama);
        }
    }
}
