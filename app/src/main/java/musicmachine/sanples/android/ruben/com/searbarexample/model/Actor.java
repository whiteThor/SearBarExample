package musicmachine.sanples.android.ruben.com.searbarexample.model;

import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;

public class Actor implements Parcelable {

    private String mName;
    private String mPhone;
    private String mImage;
    private String mCategory;

    protected Actor(Parcel in) {
        mName = in.readString();
        mPhone = in.readString();
        mImage = in.readString();
        mCategory = in.readString();
    }

    public Actor(String name, String phone, String image) {
        mName = name;
        mPhone = phone;
        mImage = image;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

    public String getImage() {
        return mImage;
    }

    public void setImage(String image) {
        mImage = image;
    }

    public String getCategory() {
        return mCategory;
    }

    public void setCategory(String category) {
        mCategory = category;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeString(mPhone);
        dest.writeString(mImage);
        dest.writeString(mCategory);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Actor> CREATOR = new Creator<Actor>() {
        @Override
        public Actor createFromParcel(Parcel in) {
            return new Actor(in);
        }

        @Override
        public Actor[] newArray(int size) {
            return new Actor[size];
        }
    };


}


