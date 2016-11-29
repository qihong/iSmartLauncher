package com.bostage.ismartplayer.video;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;

import com.bostage.ismartplayer.R;
import com.bostage.ismartplayer.detail.MediaModel;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;



public class VideoActivity extends Activity {

    private JCVideoPlayerStandard jcVideoPlayerStandard;
    public static final String VIDEO = "Video";
    private MediaModel mMediaModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        mMediaModel = getIntent().getParcelableExtra(VideoActivity.VIDEO);

        JCVideoPlayer.TOOL_BAR_EXIST = false;
        JCVideoPlayer.ACTION_BAR_EXIST = false;

        jcVideoPlayerStandard = (JCVideoPlayerStandard) findViewById(R.id.video_player);

        jcVideoPlayerStandard.setUp(mMediaModel.getVideoUrl()
                , JCVideoPlayerStandard.SCREEN_LAYOUT_LIST, mMediaModel.getTitle());
        jcVideoPlayerStandard.startPlayLocic();
    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if(event.getAction()==KeyEvent.ACTION_UP) {
            jcVideoPlayerStandard.setUp(mMediaModel.getVideoUrlNext()
                    , JCVideoPlayerStandard.SCREEN_LAYOUT_LIST, event.getAction());
            jcVideoPlayerStandard.startPlayLocic();
        }
        return super.onKeyUp(keyCode,event);
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
}
