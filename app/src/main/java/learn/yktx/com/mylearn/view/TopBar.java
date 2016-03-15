package learn.yktx.com.mylearn.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import learn.yktx.com.mylearn.R;

/**
 * Created by Administrator on 2016/3/10.
 *
 *
 *
 */
public class TopBar extends RelativeLayout{

    private Button leftBtn,rightBtn;
    private TextView title;

    private String lbn;
    private float lbns;
    private  int lbnc;
    private Drawable lbnb;

    private String rbn;
    private float rbns;
    private  int rbnc;
    private Drawable rbnb;

    private String tn;
    private float tns;
    private int tnc;

    private int tb;
    public TopBar(Context context, AttributeSet attrs) {
        this(context, attrs,0);

    }
    public TopBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray  ta = context.obtainStyledAttributes(attrs, R.styleable.TopBar,defStyleAttr,0);
        lbn = ta.getString(R.styleable.TopBar_lbn);
        lbnb = ta.getDrawable(R.styleable.TopBar_lbnb);
        lbnc = ta.getColor(R.styleable.TopBar_lbnc,0);
        lbns = ta.getDimension(R.styleable.TopBar_lbns,0);

        rbn = ta.getString(R.styleable.TopBar_rbn);
        rbnb = ta.getDrawable(R.styleable.TopBar_rbnb);
        rbnc = ta.getColor(R.styleable.TopBar_rbnc,0);
        rbns = ta.getDimension(R.styleable.TopBar_rbns,0);

        tn = ta.getString(R.styleable.TopBar_tn);
        tns = ta.getDimension(R.styleable.TopBar_tns,0);
        tnc = ta.getColor(R.styleable.TopBar_tnc,0);

        tb = ta.getColor(R.styleable.TopBar_tb,0);

        ta.recycle();

        leftBtn = new Button(context);
        rightBtn = new Button(context);
        title = new TextView(context);
        RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params1.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);
        RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params2.addRule(RelativeLayout.CENTER_IN_PARENT,TRUE);
        RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params3.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);

        leftBtn.setLayoutParams(params1);
        title.setLayoutParams(params2);
        rightBtn.setLayoutParams(params3);


        title.setText(tn);
        leftBtn.setText(lbn);

        addView(leftBtn);
        addView(rightBtn);
        addView(title);



    }
}
