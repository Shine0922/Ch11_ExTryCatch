package com.example.win7.extrycatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity
{

private TextView txtResult;
private EditText edtX,edtY;
private Button btnDo;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  取得介面元件 id
        edtX=(EditText)findViewById(R.id.edtX);
        edtY=(EditText)findViewById(R.id.edtY);
        txtResult=(TextView)findViewById(R.id.txtResult);
        btnDo=(Button)findViewById(R.id.btnDo);

        //  設定　button元件　的　listener　為　btnDoListener
        btnDo.setOnClickListener(btnDoListener);
    }

        //  定義　button 的 onClick( )方法
    private Button.OnClickListener btnDoListener = new Button.OnClickListener()
    {
        public void onClick(View v)
        {   //  捕捉 x % y 的錯誤
            try
            {       //  把x y 由 String 轉成 int
                int x = Integer.parseInt(edtX.getText().toString());
                int y = Integer.parseInt(edtY.getText().toString());
                int r = x % y;
                txtResult.setText(x + " % " + y + " = " + r);
            }

            //  輸入非數字情況會拋出 NumberFormatException 的型別錯誤
            catch (NumberFormatException err)
            {
                Toast.makeText(getApplicationContext(),"發生輸入非數值錯誤",Toast.LENGTH_LONG).show();
            }
            catch (Exception err)
            {
                Toast.makeText(getApplicationContext(),"發生其他錯誤, 包括 分母為0的錯誤! \n\r錯誤資訊:" + err.toString(),Toast.LENGTH_LONG).show();
            }
            finally
            {
                Toast.makeText(getApplicationContext(),"finally中一律執行!",Toast.LENGTH_LONG).show();
            }
        }
    };
}
