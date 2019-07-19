package com.viber.voip.sound.ptt;

import android.net.Uri;
import android.os.Handler;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.PhoneControllerDelegate;
import com.viber.jni.PhoneControllerDelegateAdapter;
import com.viber.jni.dialer.DialerControllerDelegate.DialerPhoneState;
import com.viber.jni.dialer.DialerPhoneStateListener;
import com.viber.voip.R.raw;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.sound.ISoundService;
import com.viber.voip.sound.audiofocus.AudioFocusManager;
import com.viber.voip.sound.audiofocus.AudioFocusableMediaPlayer;
import com.viber.voip.sound.audiofocus.AudioFocusableMediaPlayer.PlaybackListener;
import com.viber.voip.util.dk;
import com.viber.voip.util.upload.o;
import java.io.File;

public class AudioPttRecorderWrapper extends PhoneControllerDelegateAdapter
  implements DialerControllerDelegate.DialerPhoneState
{
  private static final com.viber.common.a.e L = ViberEnv.getLogger();
  private static final long PTT_STOP_DELAY_IN_MS = 356L;
  private final AudioFocusManager mAudioFocusManager = new AudioFocusManager(ViberApplication.getApplication());
  private File mCurrentRecordFile = null;
  private boolean mPlayingStartRecTone = false;
  private AudioPttRecordDelegate mRecDelegate;
  AudioRecorder mRecorder;
  private final Object mRecorderLock = new Object();
  private final Uri mStartRecToneUri = dk.a(R.raw.ptt_start_rec, ViberApplication.getApplication());
  private AudioFocusableMediaPlayer mStartTonePlayer;

  public AudioPttRecorderWrapper()
  {
    EngineDelegatesManager localEngineDelegatesManager = ViberApplication.getInstance().getEngine(false).getDelegatesManager();
    localEngineDelegatesManager.getDialerPhoneStateListener().registerDelegate(new DialerControllerDelegate.DialerPhoneState[] { this });
    localEngineDelegatesManager.registerDelegate(new PhoneControllerDelegate[] { this });
  }

  private void interruptPttByCall()
  {
    if ((this.mRecorder != null) && (this.mRecorder.isRecording()))
      this.mRecorder.interruptRecord(1);
  }

  private void pauseEmbeddedMedia()
  {
    ViberApplication.getInstance().getPlayerWindowManager().b();
  }

  public void onGSMStateChange(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    case 1:
    }
  }

  public void onPhoneStateChanged(int paramInt)
  {
    switch (paramInt)
    {
    case 0:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    }
  }

  public void setAudioPttRecordDelegate(AudioPttRecordDelegate paramAudioPttRecordDelegate)
  {
    this.mRecDelegate = paramAudioPttRecordDelegate;
  }

  public void startRecord(File paramFile, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mCurrentRecordFile = paramFile;
    pauseEmbeddedMedia();
    ISoundService localISoundService = ViberApplication.getInstance().getSoundService();
    if ((localISoundService.isGSMCallActive()) || (localISoundService.isViberCallActive()))
    {
      this.mRecDelegate.onRecordStarted(2);
      return;
    }
    if (!o.a())
    {
      this.mRecDelegate.onRecordStarted(1);
      return;
    }
    this.mRecorder = PttFactory.createPttRecorder(this.mRecDelegate, this.mCurrentRecordFile);
    if (paramBoolean1)
    {
      this.mStartTonePlayer = new AudioFocusableMediaPlayer(3, this.mAudioFocusManager, ViberApplication.getApplication());
      this.mStartTonePlayer.setPlaybackListener(new AudioFocusableMediaPlayer.PlaybackListener()
      {
        public void onPlayStarted()
        {
          synchronized (AudioPttRecorderWrapper.this.mRecorderLock)
          {
            AudioPttRecorderWrapper.access$102(AudioPttRecorderWrapper.this, true);
            return;
          }
        }

        public void onPlayStopped(int paramAnonymousInt)
        {
          synchronized (AudioPttRecorderWrapper.this.mRecorderLock)
          {
            AudioPttRecorderWrapper.access$102(AudioPttRecorderWrapper.this, false);
            AudioPttRecorderWrapper.this.mRecorder.startRecord();
            return;
          }
        }
      });
      this.mStartTonePlayer.play(this.mStartRecToneUri, 2);
      return;
    }
    this.mRecorder.startRecord();
  }

  public void stopRecord(boolean paramBoolean)
  {
    if (this.mRecorder != null)
      synchronized (this.mRecorderLock)
      {
        if (this.mPlayingStartRecTone)
        {
          this.mRecorder = null;
          this.mRecDelegate.onRecordError(2);
          return;
        }
        final AudioRecorder localAudioRecorder = this.mRecorder;
        av.a(av.e.e).postDelayed(new Runnable()
        {
          public void run()
          {
            localAudioRecorder.stopRecord();
          }
        }
        , 356L);
      }
    this.mRecDelegate.onRecordError(2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.sound.ptt.AudioPttRecorderWrapper
 * JD-Core Version:    0.6.2
 */