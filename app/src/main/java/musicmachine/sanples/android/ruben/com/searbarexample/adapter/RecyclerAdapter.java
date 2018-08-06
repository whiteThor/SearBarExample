package musicmachine.sanples.android.ruben.com.searbarexample.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

import musicmachine.sanples.android.ruben.com.searbarexample.R;
import musicmachine.sanples.android.ruben.com.searbarexample.model.Actor;
import musicmachine.sanples.android.ruben.com.searbarexample.model.Category;
import musicmachine.sanples.android.ruben.com.searbarexample.viewHolder.ActorViewHolder;
import musicmachine.sanples.android.ruben.com.searbarexample.viewHolder.CategoryViewHolder;

public class RecyclerAdapter extends ExpandableRecyclerViewAdapter<CategoryViewHolder, ActorViewHolder>{

    private Activity mActivity;
    public RecyclerAdapter(Activity activity, List<? extends ExpandableGroup> groups) {
        super(groups);
        mActivity = activity;
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
}
