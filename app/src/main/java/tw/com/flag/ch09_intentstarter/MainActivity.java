package tw.com.flag.ch09_intentstarter;

import android.Manifest;
import android.app.SearchManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        Intent it = new Intent(Intent.ACTION_VIEW); //建立意圖並指定預設動作

        switch (v.getId()) {//讀取按鈕的 Id 來做相關處理
            case R.id.buttonEmail:   //指定 E-mail 地址
                it.setData(Uri.parse("mailto:service@google.com.tw"));
                it.putExtra(Intent.EXTRA_CC,                  //設定副本收件人
                        new String[]{"test@google.com.tw"});
                it.putExtra(Intent.EXTRA_SUBJECT, "您好");  //設定主旨
                it.putExtra(Intent.EXTRA_TEXT, "謝謝！");   //設定內容
                break;
            case R.id.buttonSms:  //指定簡訊的傳送對象及內容
                it.setData(Uri.parse("sms:0999-123456?body=您好！"));
                break;
            case R.id.buttonWeb:  //指定網址
                it.setData(Uri.parse("http://www.google.com.tw"));
                break;
            case R.id.buttonGps:  //指定 GPS 座標：台北火車站
                it.setData(Uri.parse("geo:25.047095,121.517308"));
                break;
            case R.id.buttonWebSearch:  //搜尋 Web 資料
                it.setAction(Intent.ACTION_WEB_SEARCH);  //將動作改為搜尋
                it.putExtra(SearchManager.QUERY, "Google");
                break;
            case R.id.buttonMapSearch:    //搜尋資料
                it.setData(Uri.parse("geo:0,0?q=大安森林公園"));
                break;
        }
        startActivity(it);  //啟動程式
    }
}
