package first.test.qimo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView mTvText;
    int sum=3;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if(msg.what==1){
                mTvText.setText("倒计时"+sum);
                sum--;
                if(sum==0){
                    startActivity(new Intent(MainActivity.this,LoadActivity.class));
                }else{
                    handler.sendEmptyMessageDelayed(1,1000);
                }
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTvText = (TextView) findViewById(R.id.tv_text);
        handler.sendEmptyMessageDelayed(1,1000);

    }
}
