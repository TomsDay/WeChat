package learn.yktx.com.mylearn.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import learn.yktx.com.mylearn.R;

/**
 * Created by Administrator on 2016/3/15.
 */
public class MyTab extends View{
    private int mColor = 0xFF45301a;
    private Bitmap mIconBitmap;
    private String mText = "微信";
    private int mTextSice = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 12, getResources().getDisplayMetrics());
    public MyTab(Context context) {
        this(context,null);
    }

    public MyTab(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    /**
     * 获取自定义属性的值
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public MyTab(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray tv = context.obtainStyledAttributes(attrs, R.styleable.MyTab);
        int n = tv.getIndexCount();
        for(i = 0;i<n;i++){
            int attr = tv.getIndex(i);
            switch (attr) {
                case R.styleable.MyTab_icon:
                    BitmapDrawable bd = (BitmapDrawable) tv.getDrawable(attr);
                    mIconBitmap = bd.getBitmap();
                    break;
                case R.styleable.MyTab_color:
                    mColor = tv.getColor(attr,0xFF45301a)
                    break;
                case R.styleable.MyTab_text:
                    mText = tv.getString(attr);
                    break;
                case R.styleable.MyTab_text_sice:
                    mTextSice = (int) tv.getDimension(attr,(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 12, getResources().getDisplayMetrics()));
                    break;
            }
        }




    }
}
