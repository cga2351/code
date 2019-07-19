package org.webrtc.audio;

import android.media.AudioManager;
import java.util.Timer;
import java.util.TimerTask;
import javax.annotation.Nullable;
import org.webrtc.Logging;

class VolumeLogger
{
  private static final String TAG = "VolumeLogger";
  private static final String THREAD_NAME = "WebRtcVolumeLevelLoggerThread";
  private static final int TIMER_PERIOD_IN_SECONDS = 30;
  private final AudioManager audioManager;

  @Nullable
  private Timer timer;

  public VolumeLogger(AudioManager paramAudioManager)
  {
    this.audioManager = paramAudioManager;
  }

  public void start()
  {
    Logging.d("VolumeLogger", "start" + WebRtcAudioUtils.getThreadInfo());
    if (this.timer != null)
      return;
    Logging.d("VolumeLogger", "audio mode is: " + WebRtcAudioUtils.modeToString(this.audioManager.getMode()));
    this.timer = new Timer("WebRtcVolumeLevelLoggerThread");
    this.timer.schedule(new LogVolumeTask(this.audioManager.getStreamMaxVolume(2), this.audioManager.getStreamMaxVolume(0)), 0L, 30000L);
  }

  public void stop()
  {
    Logging.d("VolumeLogger", "stop" + WebRtcAudioUtils.getThreadInfo());
    if (this.timer != null)
    {
      this.timer.cancel();
      this.timer = null;
    }
  }

  private class LogVolumeTask extends TimerTask
  {
    private final int maxRingVolume;
    private final int maxVoiceCallVolume;

    LogVolumeTask(int paramInt1, int arg3)
    {
      this.maxRingVolume = paramInt1;
      int i;
      this.maxVoiceCallVolume = i;
    }

    public void run()
    {
      int i = VolumeLogger.this.audioManager.getMode();
      if (i == 1)
        Logging.d("VolumeLogger", "STREAM_RING stream volume: " + VolumeLogger.this.audioManager.getStreamVolume(2) + " (max=" + this.maxRingVolume + ")");
      while (i != 3)
        return;
      Logging.d("VolumeLogger", "VOICE_CALL stream volume: " + VolumeLogger.this.audioManager.getStreamVolume(0) + " (max=" + this.maxVoiceCallVolume + ")");
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.audio.VolumeLogger
 * JD-Core Version:    0.6.2
 */