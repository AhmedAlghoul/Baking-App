package com.ahmedghoul.BakingApp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.ahmedghoul.BakingApp.DetailFragment;

import com.ahmedghoul.BakingApp.R;
import com.ahmedghoul.BakingApp.VideoFragment;
import com.ahmedghoul.BakingApp.util.Constants;

public class DetailActivity extends AppCompatActivity {

    private static final String TAG = DetailActivity.class.getSimpleName();
    String stepJson, ingredientJson;
    boolean rotationDetails;
    private boolean twoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        if (savedInstanceState != null) {
            rotationDetails = savedInstanceState.getBoolean(Constants.KEY_ROTATION_DETAIL_ACTIVITY);
        }
        if (findViewById(R.id.video_container_tab) != null) {
            twoPane = true;
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.video_container_tab, new VideoFragment()).commit();
        }
        if (savedInstanceState == null) {
            //Only initialize when needed for preserving rotations states
            stepJson = getIntent().getStringExtra(Constants.KEY_STEPS);
            ingredientJson = getIntent().getStringExtra(Constants.KEY_INGREDIENTS);
            Bundle bundle = new Bundle();
            bundle.putString(Constants.KEY_STEPS_JSON, stepJson);
            bundle.putString(Constants.KEY_INGREDIENTS_JSON, ingredientJson);
            bundle.putBoolean(Constants.KEY_PANE, twoPane);
            Log.d(TAG, "Pane: " + twoPane);
            DetailFragment detailFragment = new DetailFragment();
            detailFragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail_fragment, detailFragment).commit();
            rotationDetails = true;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.getBoolean(Constants.KEY_ROTATION_DETAIL_ACTIVITY, rotationDetails);
    }

}
