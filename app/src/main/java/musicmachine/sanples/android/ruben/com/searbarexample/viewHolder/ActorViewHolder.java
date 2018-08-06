package musicmachine.sanples.android.ruben.com.searbarexample.viewHolder;

import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

import musicmachine.sanples.android.ruben.com.searbarexample.R;
import musicmachine.sanples.android.ruben.com.searbarexample.model.Actor;

public class ActorViewHolder extends ChildViewHolder {

    private TextView mName;
    private TextView mPhone;
    private TextView mImage;

    public ActorViewHolder(View itemView) {
        super(itemView);
        mName  = itemView.findViewById(R.id.name);
        mPhone = itemView.findViewById(R.id.phone);
        mImage = itemView.findViewById(R.id.image);
    }

    public  void onBind(Actor actor, ExpandableGroup group){
        mName.setText(actor.getName());
        mPhone.setText(actor.getPhone());
        mImage.setText(actor.getImage());

        switch (group.getTitle()){
            case "Drama":
                mPhone.setCompoundDrawablesWithIntrinsicBounds(R.drawable.nexus,0,0,0);
            case "Accion":
                mPhone.setCompoundDrawablesWithIntrinsicBounds(R.drawable.iphone,0,0,0);
                break;
            case "Comedia":
                mPhone.setCompoundDrawablesWithIntrinsicBounds(R.drawable.window_phone,0,0,0);
                break;

        }



    }


}
