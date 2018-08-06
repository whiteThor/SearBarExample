package musicmachine.sanples.android.ruben.com.searbarexample.viewHolder;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import musicmachine.sanples.android.ruben.com.searbarexample.R;

public class CategoryViewHolder extends GroupViewHolder {
    private TextView mCatName;
    public static final String TAG = CategoryViewHolder.class.getSimpleName();


    public CategoryViewHolder(View itemView) {
        super(itemView);

        mCatName = itemView.findViewById(R.id.category);
    }

    public void setGroupName(ExpandableGroup group){
        mCatName.setText(group.getTitle());
    }

    @Override
    public void expand() {
        Log.d(TAG, "Expand");

        mCatName.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.down_arrow,0);

    }

    @Override
    public void collapse() {
        Log.d(TAG, "Collapse");
        mCatName.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.up_arrow,0);

    }
}
