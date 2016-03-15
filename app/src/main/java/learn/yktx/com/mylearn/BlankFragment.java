package learn.yktx.com.mylearn;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class BlankFragment extends Fragment {
    private String mTitle = "default";

    public static final String TitleKey = "title";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(getArguments() != null){
            mTitle = getArguments().getString(TitleKey);
        }


        TextView tv1 = new TextView(this.getActivity());
        tv1.setTextSize(30);
        tv1.setBackgroundColor(Color.parseColor("#ffffffff"));
        tv1.setText(mTitle);
        tv1.setGravity(Gravity.CENTER);
        return  tv1;
    }
}
