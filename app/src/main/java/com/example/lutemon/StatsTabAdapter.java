package com.example.lutemon;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class StatsTabAdapter extends FragmentStateAdapter {

    public StatsTabAdapter (@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new AllStatsFragment();
            case 1:
                return new LutemonStatsFragment();
            default:
                return new AllStatsFragment();
        }

    }

    @Override
    public int getItemCount() {
        return 2;
    }
}