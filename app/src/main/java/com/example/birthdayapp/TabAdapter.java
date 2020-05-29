package com.example.birthdayapp;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabAdapter extends FragmentPagerAdapter {

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int tabPosition) {
        switch (tabPosition) {
            case 0:
                GameTab gameTab = new GameTab();
                return gameTab;
            case 1:
                return new MusicTab();
            case 2:
                return new ImagesTab();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "GameTab";
            case 1:
                return "MusicTab";
            case 2:
                return "ImagesTab";
            default:
                return null;
        }
    }

}
