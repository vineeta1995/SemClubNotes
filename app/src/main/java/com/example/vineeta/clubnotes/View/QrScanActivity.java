package com.example.vineeta.clubnotes.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.vineeta.clubnotes.R;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class QrScanActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler
{
    String folder;
    private ZXingScannerView zXingScannerView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_scan);
        Intent intent = getIntent();
        folder=intent.getStringExtra("Folder Name");
    }
    public void scan(View view)
    {
        zXingScannerView =new ZXingScannerView(getApplicationContext());
        setContentView(zXingScannerView);
        zXingScannerView.setResultHandler(this);
        zXingScannerView.startCamera();
    }
    @Override
    protected void onPause()
    {
        super.onPause();
        zXingScannerView.stopCamera();
    }
    @Override
    public void handleResult(com.google.zxing.Result result)
    {
        Toast.makeText(getApplicationContext(),result.getText(),Toast.LENGTH_SHORT).show();
        zXingScannerView.resumeCameraPreview(this);
        Intent intent = new Intent(QrScanActivity.this, RecorderActivity.class);
        intent.putExtra("SCAN_RESULTS", result.getText().toString());
        intent.putExtra("Folder Name", folder);
        startActivity(intent);
        finish();
    }
}
