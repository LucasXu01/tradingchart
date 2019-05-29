package com.example.lucas.qiniutest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.storage.UpCompletionHandler;
import com.qiniu.android.storage.UploadManager;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;

import static java.lang.System.in;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //指定zone的具体区域
//FixedZone.zone0   华东机房
//FixedZone.zone1   华北机房
//FixedZone.zone2   华南机房
//FixedZone.zoneNa0 北美机房

//自动识别上传区域
//AutoZone.autoZone


        Bitmap rawBitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher_round);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        rawBitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] data = baos.toByteArray();
//        data = <File对象、或 文件路径、或 字节数组>
        UploadManager uploadManager = new UploadManager();
        String key = "jinjintest2";
        String token = "cTlheMjLfCYQyfRLLAsZsNMCF6JNjTl05cejJguK:VAGbUfSVc2aRSZeZo7nqfpf-Pag=:eyJzY29wZSI6InlhbmZyaWVuZHMiLCJkZWFkbGluZSI6MTU1NTc0NjQ2NX0=";
        uploadManager.put(data, key, token,
                new UpCompletionHandler() {
                    @Override
                    public void complete(String key, ResponseInfo info, JSONObject res) {
                        //res包含hash、key等信息，具体字段取决于上传策略的设置
                        if(info.isOK()) {
                            Log.e("qiniu", "Upload Success");
                        } else {
                            Log.e("qiniu", "Upload Fail");
                            //如果失败，这里可以把info信息上报自己的服务器，便于后面分析上传错误原因
                        }
                        Log.e("qiniu", key + ",\r\n " + info + ",\r\n " + res);
                    }
                }, null);




    }
}
