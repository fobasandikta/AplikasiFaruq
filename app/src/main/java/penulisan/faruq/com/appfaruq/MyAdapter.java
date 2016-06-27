package penulisan.faruq.com.appfaruq;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;

/**
 * Created by root on 10/06/16.
 */
public class MyAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private String[] titles = {"OVERVIEW","PORTOFOLIO","TEAM"};
    int[] icons = new int[]{R.mipmap.media,R.mipmap.gallery,R.mipmap.people};
    private int heightIcon;

    public MyAdapter(FragmentManager fm,Context c ) {
        super(fm);
        mContext=c;
        double scale = c.getResources().getDisplayMetrics().density;
        heightIcon = (int) (30*scale+0.5f);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;
        if (position==0){
            frag = new GalleryFragment();
        }else if (position == 1){
            frag = new PeopleFragment();
        }else if (position == 2){
            frag = new MediaFragment();
        }

        Bundle b = new Bundle();
        b.putInt("position",position);
        frag.setArguments(b);
        return frag;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Drawable d = mContext .getResources().getDrawable(icons[position]);
        d.setBounds(0,0,heightIcon,heightIcon);

        ImageSpan is = new ImageSpan(d);

        SpannableString sp = new SpannableString(" ");
        sp.setSpan(is,0,sp.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return  (sp);
    }
}
