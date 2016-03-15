package learn.yktx.com.mylearn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;

import learn.yktx.com.mylearn.view.SlidingMenu;

public class MainActivity extends AppCompatActivity {
    ScrollView sv;
    TextView tv1,tv2;
    SeekBar sb;
    ViewStub vs;
    Button btn;
//    SlidingMenu sm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sb = (SeekBar) findViewById(R.id.sb);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        vs = (ViewStub) findViewById(R.id.vs);
        btn = (Button) findViewById(R.id.btn);
//        sm = (SlidingMenu) findViewById(R.id.sm);

//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sm.toggle();
//
//            }
//        });
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override//数值改变
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv2.setText("当前数值："+progress);
                tv1.setText("正在拖动");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                tv1.setText("开始拖动");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tv1.setText("停止拖动");
            }
        });
    }

}
