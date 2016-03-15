package learn.yktx.com.mylearn.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import com.nineoldandroids.view.ViewHelper;

import learn.yktx.com.mylearn.R;

/**
 * Created by Administrator on 2016/3/9.
 */
public class SlidingMenu extends HorizontalScrollView{
    LinearLayout mWapper;
    ViewGroup mMenu;
    ViewGroup mContent;
    int mScreenWidth;
    int mMenuRightPadding = 50;
    boolean once = false;
    int mMenuWidth;
    boolean isOpen = false;

    public SlidingMenu(Context context) {
        this(context, null);
    }


    public SlidingMenu(Context context, AttributeSet attrs) {
        this(context,attrs,0);


    }

    public SlidingMenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        WindowManager wm = (WindowManager) context.getSystemService(context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        mScreenWidth = dm.widthPixels;
//        mMenuRightPadding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,mMenuRightPadding,context.getResources().getDisplayMetrics());

        //获得属性的值
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SlidingMenu, defStyleAttr, 0);
        int n = a.getIndexCount();
        for (int i = 0; i < n; i++ ) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.SlidingMenu_rightPadding:
                    mMenuRightPadding = (int) a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_DIP, 50, context.getResources().getDisplayMetrics()));
                    break;
            }
        }

        a.recycle();



    }

    public SlidingMenu(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (!once) {
            mWapper = (LinearLayout) getChildAt(0);
            mMenu = (ViewGroup) mWapper.getChildAt(0);
            mContent = (ViewGroup) mWapper.getChildAt(1);

            mMenuWidth =  mMenu.getLayoutParams().width = mScreenWidth - mMenuRightPadding;
            mContent.getLayoutParams().width = mScreenWidth;
            once = true;
        }


        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (changed) {
            scrollTo(mMenuWidth,0);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:

                break;
            case MotionEvent.ACTION_MOVE:

                break;
            case MotionEvent.ACTION_UP:
                int scrollX = getScrollX();
                Log.d("aaa","scrollX==="+scrollX);
                if (scrollX >= mMenuWidth / 2) {
                    smoothScrollTo(mMenuWidth, 0);
                    isOpen = false;
                } else {
                    smoothScrollTo(0, 0);
                    isOpen = true;
                }
                return true;
        }


        return super.onTouchEvent(ev);
    }
    public void openMenu(){
        if(isOpen) return;
        smoothScrollTo(0, 0);
        isOpen =  true;
    }
    public void closenMenu(){
        if(!isOpen) return;
        smoothScrollTo(mMenuWidth, 0);
        isOpen =  false;

    }
    public void toggle(){
        if (isOpen) {
            closenMenu();
        } else {
            openMenu();
        }

    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        Log.d("aaa","getScrollX===="+l );
        float scale = l*1.0f/mMenuWidth;// 1-0
        /**
         *
         * 区别1： 内容区域1.0 - 0.7 缩放效果 scale 1.0 - 0.7： 0.7+0.3*scale
         *
         * 区别2: 菜单的偏移量需要修改
         *
         * 区别3：菜单显示时有缩放 透明的效果变化
         * 缩放：0.7-1.0 ： 1 - scale*0.3
         * 透明度：0.6-1.0  ：0.6+0.4*（1-scale）
         *
         */


        float rightScale = 0.7f + 0.3f * scale;
        float leftScale = 1.0f - scale * 0.3f;
        float leftAlpha = 0.6f + 0.4f * (1.0f - scale);

        //菜单在content下的偏移量
        //调用属性动画，设置TranslationX
        ViewHelper.setTranslationX(mMenu,mMenuWidth*scale * 0.8f);//偏移量

        //设置菜单的缩放和渐变效果
        ViewHelper.setScaleX(mMenu,leftScale);//缩放
        ViewHelper.setScaleY(mMenu,leftScale);
        ViewHelper.setAlpha(mMenu,leftAlpha);//透明毒

        //设置Content的缩放中心点
        ViewHelper.setPivotX(mContent,0);
        ViewHelper.setPivotY    (mContent,mContent.getHeight()/2);
        ViewHelper.setScaleX(mContent,rightScale);
        ViewHelper.setScaleY(mContent,rightScale);


    }
}
