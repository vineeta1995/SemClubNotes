package com.example.vineeta.clubnotes.View;

import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.vineeta.clubnotes.R;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class RecorderPlayActivity extends AppCompatActivity
{
    Button Play, Stop;
    String AudioSavePathInDevice = null;
    MediaRecorder mediaRecorder;
    String code;
    String Qrcode;
    public static final int RequestPermissionCode = 1;
    MediaPlayer mediaPlayer;
    String folder;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recorder_play);
        Intent intent = getIntent();
        folder=intent.getStringExtra("Folder Name");
        code=intent.getStringExtra("SCAN_RESULTS");
        Play = (Button) findViewById(R.id.play);
        Stop = (Button) findViewById(R.id.stop);
        Qrcode=md5(code );
        AudioSavePathInDevice = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Club Notes/Audio/" + folder+ '/' + Qrcode + ".3gp";
        Stop.setEnabled(false);
    }
    private String md5(String in)
    {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
            digest.reset();
            digest.update(in.getBytes());
            byte[] a = digest.digest();
            int len = a.length;
            StringBuilder sb = new StringBuilder(len << 1);
            for (int i = 0; i < len; i++) {
                sb.append(Character.forDigit((a[i] & 0xf0) >> 4, 16));
                sb.append(Character.forDigit(a[i] & 0x0f, 16));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) { e.printStackTrace(); }
        return null;
    }

    public void play(View view)
    {
        Stop.setEnabled(true);

        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(AudioSavePathInDevice);
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mediaPlayer.start();
        Toast.makeText(RecorderPlayActivity.this, "Recording Playing",
                Toast.LENGTH_LONG).show();
    }
    public void stop(View view)
    {
        if(mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.release();
            MediaRecorderReady();
    }
}

    private void MediaRecorderReady()
    {
        mediaRecorder=new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        mediaRecorder.setOutputFile(AudioSavePathInDevice);
    }
    }
