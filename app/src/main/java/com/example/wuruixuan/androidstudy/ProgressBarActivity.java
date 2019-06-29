package com.example.wuruixuan.androidstudy;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

public class ProgressBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 设置标题
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setProgressBarIndeterminateVisibility(true);

        setContentView(R.layout.activity_progress_bar);
    }

    public void showDialogProgress(View v) {
        ProgressDialog pd = new ProgressDialog(this);
        pd.setMax(100);
        pd.setIndeterminate(false);
        pd.setProgress(30);
        pd.setCancelable(true);
        pd.setTitle("下载对话框");
        pd.setMessage("正在下载中...");
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd.show();

        ProgressDialog pd2 = ProgressDialog.show(this, "download", "downloading...", false, true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate();
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
