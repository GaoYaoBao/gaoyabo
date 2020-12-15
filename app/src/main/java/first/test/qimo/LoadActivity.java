package first.test.qimo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import first.test.qimo.view.HomeActivity;

public class LoadActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 请输入用户名
     */
    private EditText mEtName;
    /**
     * 请输入密码
     */
    private EditText mEtPwd;
    /**
     * 登录
     */
    private Button mBtnLogin;
    private SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        initView();
    }

    private void initView() {
        mEtName = (EditText) findViewById(R.id.et_name);
        mEtPwd = (EditText) findViewById(R.id.et_pwd);
        mBtnLogin = (Button) findViewById(R.id.btn_login);
        mBtnLogin.setOnClickListener(this);
        SharedPreferences name = getSharedPreferences("name", MODE_PRIVATE);
        boolean flag = name.getBoolean("flag", false);
        edit = name.edit();
        if(flag){
            startActivity(new Intent(LoadActivity.this, HomeActivity.class));
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_login:
                String name = mEtName.getText().toString();
                String pwd = mEtPwd.getText().toString();
                if(name.equals("H2003xs")&& pwd.equals("H2003")){
                    startActivity(new Intent(LoadActivity.this, HomeActivity.class));
                    Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                    edit.putBoolean("flag",true);
                    edit.commit();
                }else{
                    Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
                    mBtnLogin.setText("重新登录");
		// ertjyrtjxfkhfdfhfg  h gmvhnbj
                }
                break;
        }
    }
}
