package demo.demoprojects.activities.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import demo.demoprojects.R;

/**
 * Created by epi-i5-gold on 2/6/2019.
 */

public class CarsAdapter extends RecyclerView.Adapter<CarsAdapter.ViewHolder> {

    Context context;
    ArrayList<String> carNamesArray=new ArrayList<>();

    public CarsAdapter(Context context,ArrayList<String> carNamesArray) {
        this.context = context;
        this.carNamesArray=carNamesArray;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View view= LayoutInflater.from(context).inflate(R.layout.items_cars,parent,false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.car_name.setText(carNamesArray.get(position));
    }

    @Override
    public int getItemCount() {
        return carNamesArray.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView car_name;


        public ViewHolder(View itemView) {
            super(itemView);
            car_name=itemView.findViewById(R.id.car_name);
        }
    }
}
