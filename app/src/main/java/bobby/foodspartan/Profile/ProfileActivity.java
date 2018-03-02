package bobby.foodspartan.Profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

import bobby.foodspartan.R;
import bobby.foodspartan.Utils.BottomNavigationViewHelper;
import bobby.foodspartan.Utils.GridImageAdapter;
import bobby.foodspartan.Utils.UILoader;

/**
 * Created by bobby on 20/02/2018.
 */

public class ProfileActivity extends AppCompatActivity {
    private static final String TAG = "ProfileActivity";
    private static final int ACTIVITY_NUM = 4;
    private static final int NUM_GRID_COLUMNS = 3;

    private Context mContext = ProfileActivity.this;

    private ProgressBar mProgressBar;
    private ImageView profilePhoto;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Log.d(TAG, "started!");

        setupBottomNavigationView();
        setupToolbar();
        setupActivityWidgets();
        setProfilePhoto();

        tempGridSetup();
    }

    private void tempGridSetup(){
        ArrayList<String> imgURLs = new ArrayList<>();
        imgURLs.add("https://www.bbcgoodfood.com/sites/default/files/styles/category_retina/public/recipe-collections/collection-image/2013/05/mexican-chicken-burger_1.jpg?itok=LJYhlfBT");
        imgURLs.add("https://i.pinimg.com/474x/ae/9b/2d/ae9b2d8ef8bd4e649e6d215f18dd6f32--homemade-waffle-recipes-homemade-waffles.jpg");
        imgURLs.add("http://www.oliviascuisine.com/wp-content/uploads/2016/07/ny-bec.jpg");
        imgURLs.add("http://www.sickchirpse.com/wp-content/uploads/2016/01/pizza-stock.jpg");
        imgURLs.add("https://imagesvc.timeincapp.com/v3/mm/image?url=http%3A%2F%2Fimg1.cookinglight.timeinc.net%2Fsites%2Fdefault%2Ffiles%2Fstyles%2Fmedium_2x%2Fpublic%2Fimage%2F2017%2F03%2Fmain%2Fbeer-brushed-tofu-skewers-barley-1705p105.jpg%3Fitok%3Dx5o9EEm6&w=1600&q=70");
        imgURLs.add("https://food.fnr.sndimg.com/content/dam/images/food/fullset/2012/10/2/1/FNM_110112-Garlic-and-Chicken-Potatoes-Recipe_s4x3.jpg.rend.hgtvcom.616.462.suffix/1382456485753.jpeg");
        imgURLs.add("http://jeanetteshealthyliving.com/wp-content/uploads/blogger/-BO2IalI5CDk/TccgnRmOcqI/AAAAAAAAA-k/XDFYBWURzes/s640/IMG_7378.JPG");
        imgURLs.add("https://www.williams-sonoma.com/wsimgs/rk/images/dp/wcm/201747/0003/ice-cream-bowls-set-of-6-o.jpg");
        imgURLs.add("https://img.grouponcdn.com/deal/fmPws6o2uTweCftZu7yj/p4-2048x1229/v1/c700x420.jpg");
        imgURLs.add("http://www.youdeaty.com/wp-content/uploads/2018/02/Indian-Cuisine2.jpg");
        imgURLs.add("http://www.destinationmp.com/wp-content/uploads/2016/08/Popular-Chinese-Dishes.jpg");
        imgURLs.add("https://assets.epicurious.com/photos/54af56b3c4a891cc44cceb29/6:4/w_620%2Ch_413/51171400_chicken-tikka-masala_1x1.jpg");
        imgURLs.add("https://upload.wikimedia.org/wikipedia/commons/thumb/8/8e/English_Breakfast_nic.jpg/600px-English_Breakfast_nic.jpg");
        imgURLs.add("https://amp.businessinsider.com/images/538798d3eab8eae80cb36475-1334-1001.jpg");
        imgURLs.add("http://www.salsasmexican.com/wp-content/uploads/2016/11/01.jpg");
        imgURLs.add("https://www.cookingclassy.com/wp-content/uploads/2014/11/red-velvet-cake-srgb.2.jpg");

        setupPhotoGrid(imgURLs);

    }

    private void setupPhotoGrid(ArrayList<String> imgURLs){
        GridView gridView = (GridView) findViewById(R.id.gridView);

        //fixes photo grid scaling issues
        int gridWidth = getResources().getDisplayMetrics().widthPixels;
        int imageWidth = gridWidth/NUM_GRID_COLUMNS;
        gridView.setColumnWidth(imageWidth);

        GridImageAdapter adapter = new GridImageAdapter(mContext, R.layout.layout_grid_imageview, "", imgURLs);
        gridView.setAdapter(adapter);

    }

    private void setProfilePhoto(){
        Log.d(TAG, "setProfileImage = setting profile photo");
        String imgURL = "https://www.androidcentral.com/sites/androidcentral.com/files/styles/large/public/postimages/%5Buid%5D/podcast-ac-new_0.jpg?itok=GFz47App";
        UILoader.setImage(imgURL, profilePhoto, mProgressBar, "");

    }

    private void setupActivityWidgets(){
        mProgressBar = (ProgressBar) findViewById(R.id.profileProgressBar);
        mProgressBar.setVisibility(View.GONE);
        profilePhoto = (ImageView) findViewById(R.id.profile_photo);


    }


    //sets up toolbar

    private void setupToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.profileToolBar);
        setSupportActionBar(toolbar);

        ImageView profileMenu = (ImageView) findViewById(R.id.profileMenu);
        profileMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "traversing to account settings");
                Intent intent = new Intent(mContext, AccountSettingsActivity.class);
                startActivity(intent);
            }
        });

    }

    //BottomNavigationViewSetup

    private void setupBottomNavigationView(){
        Log.d(TAG,"setupBottomNavigationView: setting up BottomNavigationView!");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(mContext, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }
}
