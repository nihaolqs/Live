package live.lqs.com.live;

import android.animation.AnimatorSet;
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

/**
 * Created by dell on 2017/2/8.
 */

public class VideoActivity extends AppCompatActivity{

    private VideoView mVideoView;
    private SeekBar mSeekBar;
    private TextView mTvCurrentTime;
    private TextView mTvTotalTime;
    private StringBuffer sb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sb = new StringBuffer();
        setContentView(R.layout.activity_video);
        mVideoView = (VideoView) findViewById(R.id.videoView);
        mSeekBar = (SeekBar) findViewById(R.id.seekBar);
        mTvCurrentTime = (TextView) findViewById(R.id.tv_activity_video_videocurrenttime);
        mTvTotalTime = (TextView) findViewById(R.id.tv_activity_video_videototaltime);
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mTvCurrentTime.setText(timeFormat(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(VideoActivity.this,"非会员不能拖动",Toast.LENGTH_SHORT).show();
            }
        });

        mVideoView.setVideoPath("http://test.mhhqd.com/files/upload/826279134f364635845bbb439ef8f0304584944924561717860.mp4");
        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
//                setResult(1);
                finish();
            }
        });

        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                int duration = mVideoView.getDuration();
                Log.e("duration",""+duration);
                int max = 3395000 + duration;
                mSeekBar.setMax(max);
                mTvTotalTime.setText(timeFormat(max));
                mSeekBar.post(new Runnable() {
                    @Override
                    public void run() {
                        int currentPosition = mVideoView.getCurrentPosition();
                        mSeekBar.setProgress(currentPosition);
                        mSeekBar.postDelayed(this,1000);
                    }
                });

                mVideoView.requestFocus();
                mVideoView.start();
            }
        });
    }

    private String timeFormat(int time){
        int i = time / 1000;
        int m = i / 60;
        int s = i % 60;
        return timeFormatUtil(m) +":"+ timeFormatUtil(s);
    }

    private String timeFormatUtil(int i){
        sb.setLength(0);
        if(i < 10){
            sb.append(0);
        }
        sb.append(i);
        return sb.toString();
    }

}
