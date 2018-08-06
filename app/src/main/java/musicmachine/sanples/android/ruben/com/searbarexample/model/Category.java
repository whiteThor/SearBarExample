package musicmachine.sanples.android.ruben.com.searbarexample.model;

import android.os.Parcel;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class Category extends ExpandableGroup<Actor>{
    public Category(String title, List<Actor> items) {
        super(title, items);
    }

    protected Category(Parcel in) {
        super(in);
    }
}
