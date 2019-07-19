package com.viber.voip.sound.ptt;

import android.media.MediaRecorder;
import android.os.Handler;
import android.os.SystemClock;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MediaRecordPtt
  implements AudioRecorder
{
  private static final Logger L = ViberEnv.getLogger();
  private ArrayList<Short> amplitudes = new ArrayList();
  private File audioFile;
  private AudioPttRecordDelegate delegate;
  private Handler handler = av.a(av.e.f);
  private boolean isRecording = false;
  private final int mBitDepth;
  private final int mBitRate;
  private final int mSampleRate;
  private MediaRecorder mediaRecorder;
  private long startHTime = 0L;
  private Runnable stopPttRecord = new Runnable()
  {
    public void run()
    {
      if (MediaRecordPtt.this.isRecording())
        MediaRecordPtt.this.stopRecord(1);
    }
  };
  private Runnable updateVisualizer = new Runnable()
  {
    public void run()
    {
      if (MediaRecordPtt.this.isRecording());
      try
      {
        int i = MediaRecordPtt.this.mediaRecorder.getMaxAmplitude();
        s = (short)i;
        MediaRecordPtt.this.amplitudes.add(Short.valueOf(s));
        MediaRecordPtt.this.handler.postDelayed(this, 20L);
        return;
      }
      catch (Exception localException)
      {
        while (true)
          short s = 0;
      }
    }
  };

  public MediaRecordPtt(AudioPttRecordDelegate paramAudioPttRecordDelegate, File paramFile)
  {
    this.audioFile = paramFile;
    this.delegate = paramAudioPttRecordDelegate;
    this.mBitDepth = 16;
    this.mSampleRate = 32000;
    this.mBitRate = (this.mBitDepth * this.mSampleRate);
  }

  private void resetRecorder()
    throws IOException
  {
    this.mediaRecorder = new MediaRecorder();
    this.mediaRecorder.setAudioSource(1);
    this.mediaRecorder.setOutputFormat(2);
    this.mediaRecorder.setAudioEncoder(3);
    this.mediaRecorder.setAudioEncodingBitRate(this.mBitRate);
    this.mediaRecorder.setAudioSamplingRate(this.mSampleRate);
    this.mediaRecorder.setOutputFile(this.audioFile.getAbsolutePath());
    this.mediaRecorder.prepare();
  }

  private void stopRecord(int paramInt)
  {
    long l = SystemClock.uptimeMillis() - this.startHTime;
    this.isRecording = false;
    try
    {
      this.mediaRecorder.stop();
      try
      {
        label21: this.mediaRecorder.release();
        label28: this.mediaRecorder = null;
        this.startHTime = 0L;
        int i = this.amplitudes.size();
        short[] arrayOfShort = new short[i];
        int j = 0;
        short s = 0;
        while (j < i)
        {
          arrayOfShort[j] = ((Short)this.amplitudes.get(j)).shortValue();
          if (arrayOfShort[j] > s)
            s = arrayOfShort[j];
          j++;
        }
        this.delegate.onRecordFinished(paramInt, (int)l, arrayOfShort, i, s);
        trackRecording(false);
        this.amplitudes.clear();
        return;
      }
      catch (Exception localException2)
      {
        break label28;
      }
    }
    catch (Exception localException1)
    {
      break label21;
    }
  }

  private void trackRecording(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.handler.post(this.updateVisualizer);
      this.handler.postDelayed(this.stopPttRecord, PttUtils.MAX_PTT_DURATION_IN_MS);
      return;
    }
    this.handler.removeCallbacks(this.updateVisualizer);
    this.handler.removeCallbacks(this.stopPttRecord);
  }

  public void interruptRecord(int paramInt)
  {
    stopRecord();
    this.delegate.onRecordError(paramInt);
    trackRecording(false);
  }

  public boolean isRecording()
  {
    return this.isRecording;
  }

  public void startRecord()
  {
    try
    {
      resetRecorder();
      this.mediaRecorder.start();
      this.isRecording = true;
      this.delegate.onRecordStarted(0);
      this.startHTime = SystemClock.uptimeMillis();
      trackRecording(true);
      return;
    }
    catch (Exception localException)
    {
      this.delegate.onRecordStarted(3);
      localException.printStackTrace();
    }
  }

  public void stopRecord()
  {
    stopRecord(0);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.sound.ptt.MediaRecordPtt
 * JD-Core Version:    0.6.2
 */