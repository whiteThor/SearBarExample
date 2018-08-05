package musicmachine.sanples.android.ruben.com.searbarexample;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayAdapter extends RecyclerView.Adapter<ArrayAdapter.ViewHolder> implements Filterable{

    List<String> listFiltered;
    List<String> listData;

    public ArrayAdapter() {
        this.listData = listData;
        listData = Arrays.asList(ArrayItem.arrays);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString();
                if(charString.isEmpty()){
                    listData = Arrays.asList(ArrayItem.arrays);

                }else{

                    listFiltered = new ArrayList<String>();
                    for (String row : ArrayItem.arrays) {
                        if(row.contains(charString)){
                            listFiltered.add(row);
                        }
                    }
                    listData = listFiltered;

                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = listData;

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                listData = (List<String>) results.values;
                notifyDataSetChanged();

            }
        };
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView mItemText;


        public ViewHolder(View itemView) {
            super(itemView);
            mItemText = itemView.findViewById(R.id.itemText);


        }

        public void bind(int position){

            mItemText.setText(listData.get(position));

        }
    }
}
