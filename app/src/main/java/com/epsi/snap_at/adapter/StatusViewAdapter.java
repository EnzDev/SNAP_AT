package com.epsi.snap_at.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.epsi.snap_at.R;
import com.epsi.snap_at.Status;
import com.epsi.snap_at.holder.StatusViewHolder;

import java.util.List;

/**
 * Created by Ptit-Biscuit on 03/10/2017.
 */

public class StatusViewAdapter extends RecyclerView.Adapter<StatusViewHolder> {
	List<Status> statusList;

	public StatusViewAdapter(List<Status> statusList) {
		this.statusList = statusList;
	}

	@Override
	public StatusViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.status, parent, false);
		return new StatusViewHolder(view);
	}

	@Override
	public void onBindViewHolder(StatusViewHolder holder, int position) {
		Status myObject = statusList.get(position);
		holder.bind(myObject);
	}

	@Override
	public int getItemCount() {
		return statusList.size();
	}
}
