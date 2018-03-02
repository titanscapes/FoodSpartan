package bobby.foodspartan.Profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import bobby.foodspartan.R;
import bobby.foodspartan.Utils.UILoader;

/**
 * Created by bobby on 28/02/2018.
 */

public class EditProfileFragment extends Fragment{

    private static final String TAG = "EditProfileFragment";
    private ImageView mProfilePhoto;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_editprofile, container, false);

        mProfilePhoto = (ImageView) view.findViewById(R.id.profile_photo);
        setProfileImage();

        //back arrow to traverse back to main profile

        ImageView backArrow = (ImageView) view.findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: navigating back to Profile");
                getActivity().finish();
            }
        });

        return view;
    }


    private void setProfileImage(){
        Log.d(TAG, "setProfileImage: setting profile image");
        String imgURL = "https://www.androidcentral.com/sites/androidcentral.com/files/styles/large/public/postimages/%5Buid%5D/podcast-ac-new_0.jpg?itok=GFz47App";
        UILoader.setImage(imgURL, mProfilePhoto, null, "");
    }
}

