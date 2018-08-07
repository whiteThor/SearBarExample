package musicmachine.sanples.android.ruben.com.searbarexample.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.models.ExpandableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import musicmachine.sanples.android.ruben.com.searbarexample.ArrayItem;
import musicmachine.sanples.android.ruben.com.searbarexample.R;
import musicmachine.sanples.android.ruben.com.searbarexample.model.Actor;
import musicmachine.sanples.android.ruben.com.searbarexample.model.Category;
import musicmachine.sanples.android.ruben.com.searbarexample.viewHolder.ActorViewHolder;
import musicmachine.sanples.android.ruben.com.searbarexample.viewHolder.CategoryViewHolder;

public class RecyclerAdapter extends ExpandableRecyclerViewAdapter<CategoryViewHolder, ActorViewHolder> implements Filterable{

    private Activity mActivity;
    ArrayList<Category> listData;
    ArrayList<Category> listFiltered;
    ArrayList<Actor> listFilteredAct;

    public RecyclerAdapter(Activity activity, List<? extends ExpandableGroup> groups) {
        super(groups);
        mActivity = activity;
        listData = (ArrayList<Category> )groups;
    }

    @Override
    public CategoryViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) mActivity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.group_view_holder,parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public ActorViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) mActivity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.child_view_holder,parent,false);

        return new ActorViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(ActorViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        Actor actor = (Actor) group.getItems().get(childIndex);
        holder.onBind(actor, group);

    }

    @Override
    public void onBindGroupViewHolder(CategoryViewHolder holder, int flatPosition, ExpandableGroup group) {
        holder.setGroupName(group);

    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString();
                if(charString.isEmpty()){
                    listData =  ArrayItem.getData();

                }else{

                    listFiltered = new ArrayList<>();

                    for (Category row : ArrayItem.getData()) {
                        listFilteredAct = new ArrayList<>();
                        for (Actor actor: row.getItems() ) {
                            if(actor.getName().contains(charString)){
                                listFilteredAct.add(actor);
                            }
                        }
                        listFiltered.add(new Category(row.getTitle(), listFilteredAct));
                    }
                    listData = listFiltered;

                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = listData;

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                RecyclerAdapter.super.expandableList =new ExpandableList( (ArrayList<Category>) results.values);
                        //listData = (ArrayList<Category>) results.values;
                notifyDataSetChanged();
//                notifyAll();

            }
        };
    }
}
