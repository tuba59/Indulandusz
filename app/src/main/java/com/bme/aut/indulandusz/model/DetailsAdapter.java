package com.bme.aut.indulandusz.model;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bme.aut.indulandusz.R;

import java.util.List;

public class DetailsAdapter  extends RecyclerView.Adapter<DetailsAdapter.ViewHolder> {
    private List<Vehicle> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView vehicleName;
        public TextView departureTimes;
        public ViewHolder(View v) {
            super(v);
            vehicleName =  (TextView) v.findViewById(R.id.vehicleName);
            departureTimes = (TextView) v.findViewById(R.id.vehicleDepartureTimes);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public DetailsAdapter(List<Vehicle> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public DetailsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.details_list_item, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.vehicleName.setText(mDataset.get(position).getName());
        holder.departureTimes.setText(mDataset.get(position).getDepartureTimes());
    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}
