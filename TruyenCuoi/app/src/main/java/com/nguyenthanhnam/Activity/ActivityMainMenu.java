package com.nguyenthanhnam.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import com.nguyenthanhnam.Flagment.MainMenuFlagment;
import com.nguyenthanhnam.Flagment.StoryOfflineFlagment;
import com.nguyenthanhnam.Flagment.StoryOnlineFlagment;
import com.nguyenthanhnam.truyencuoi.R;

/**
 * Created by namnguyenthanhnam on 9/3/2016.
 */
public class ActivityMainMenu extends Activity {

  private MainMenuFlagment mainMenuFlagment;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainstory);
         mainMenuFlagment=new MainMenuFlagment();
        getFragmentManager().beginTransaction().replace(R.id.mainmenu, mainMenuFlagment).commit();
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}
