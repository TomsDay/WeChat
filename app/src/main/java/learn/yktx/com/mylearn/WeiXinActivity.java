package learn.yktx.com.mylearn;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.view.ViewConfiguration;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class WeiXinActivity extends FragmentActivity {
    private ViewPager mViewPager;
    private List<Fragment> FragmentList = new ArrayList<Fragment>();
    String[] mTitle = {"第一个Fragment","第二个Fragment","第三个Fragment","第四个Fragment"};
    FragmentPagerAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wei_xin);


        initView();
        initDate();




//        setOverFlowButtonAlays();
//        getActionBar().setDisplayHomeAsUpEnabled(false);

    }

    private void initDate() {
        for(String title : mTitle){
            BlankFragment bf = new BlankFragment();
            Bundle bundle = new Bundle();
            bundle.putString(BlankFragment.TitleKey,title);
            bf.setArguments(bundle);
            FragmentList.add(bf);
        }
        pageAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return FragmentList.get(position);
            }

            @Override
            public int getCount() {
                return mTitle.length;
            }
        };
        mViewPager.setAdapter(pageAdapter);
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.my_pager);

    }
//    public void setOverFlowButtonAlays(){
//        ViewConfiguration config = ViewConfiguration.get(WeiXinActivity.this);
//        try {
//            Field field = ViewConfiguration.class.getDeclaredField("hasPermanentMenuKey");
//            field.setAccessible(true);
//            field.setBoolean(config,false);
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//
//        getMenuInflater().inflate(R.menu.menu,menu);
//        return true;
//    }
}
