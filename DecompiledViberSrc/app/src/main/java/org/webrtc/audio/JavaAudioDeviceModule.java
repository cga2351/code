package org.webrtc.audio;

import android.content.Context;
import android.media.AudioManager;
import org.webrtc.JniCommon;
import org.webrtc.Logging;

public class JavaAudioDeviceModule
  implements AudioDeviceModule
{
  private static final String TAG = "JavaAudioDeviceModule";
  private final WebRtcAudioRecord audioInput;
  private final AudioManager audioManager;
  private final WebRtcAudioTrack audioOutput;
  private final Context context;
  private long nativeAudioDeviceModule;
  private final Object nativeLock = new Object();
  private final int sampleRate;
  private final boolean useStereoInput;
  private final boolean useStereoOutput;

  private JavaAudioDeviceModule(Context paramContext, AudioManager paramAudioManager, WebRtcAudioRecord paramWebRtcAudioRecord, WebRtcAudioTrack paramWebRtcAudioTrack, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.context = paramContext;
    this.audioManager = paramAudioManager;
    this.audioInput = paramWebRtcAudioRecord;
    this.audioOutput = paramWebRtcAudioTrack;
    this.sampleRate = paramInt;
    this.useStereoInput = paramBoolean1;
    this.useStereoOutput = paramBoolean2;
  }

  public static Builder builder(Context paramContext)
  {
    return new Builder(paramContext, null);
  }

  public static boolean isBuiltInAcousticEchoCancelerSupported()
  {
    return WebRtcAudioEffects.isAcousticEchoCancelerSupported();
  }

  public static boolean isBuiltInNoiseSuppressorSupported()
  {
    return WebRtcAudioEffects.isNoiseSuppressorSupported();
  }

  private static native long nativeCreateAudioDeviceModule(Context paramContext, AudioManager paramAudioManager, WebRtcAudioRecord paramWebRtcAudioRecord, WebRtcAudioTrack paramWebRtcAudioTrack, int paramInt, boolean paramBoolean1, boolean paramBoolean2);

  public long getNativeAudioDeviceModulePointer()
  {
    synchronized (this.nativeLock)
    {
      if (this.nativeAudioDeviceModule == 0L)
        this.nativeAudioDeviceModule = nativeCreateAudioDeviceModule(this.context, this.audioManager, this.audioInput, this.audioOutput, this.sampleRate, this.useStereoInput, this.useStereoOutput);
      long l = this.nativeAudioDeviceModule;
      return l;
    }
  }

  public void release()
  {
    synchronized (this.nativeLock)
    {
      if (this.nativeAudioDeviceModule != 0L)
      {
        JniCommon.nativeReleaseRef(this.nativeAudioDeviceModule);
        this.nativeAudioDeviceModule = 0L;
      }
      return;
    }
  }

  public void setMicrophoneMute(boolean paramBoolean)
  {
    Logging.d("JavaAudioDeviceModule", "setMicrophoneMute: " + paramBoolean);
    this.audioInput.setMicrophoneMute(paramBoolean);
  }

  public void setSpeakerMute(boolean paramBoolean)
  {
    Logging.d("JavaAudioDeviceModule", "setSpeakerMute: " + paramBoolean);
    this.audioOutput.setSpeakerMute(paramBoolean);
  }

  public static abstract interface AudioRecordErrorCallback
  {
    public abstract void onWebRtcAudioRecordError(String paramString);

    public abstract void onWebRtcAudioRecordInitError(String paramString);

    public abstract void onWebRtcAudioRecordStartError(JavaAudioDeviceModule.AudioRecordStartErrorCode paramAudioRecordStartErrorCode, String paramString);
  }

  public static enum AudioRecordStartErrorCode
  {
    static
    {
      AudioRecordStartErrorCode[] arrayOfAudioRecordStartErrorCode = new AudioRecordStartErrorCode[2];
      arrayOfAudioRecordStartErrorCode[0] = AUDIO_RECORD_START_EXCEPTION;
      arrayOfAudioRecordStartErrorCode[1] = AUDIO_RECORD_START_STATE_MISMATCH;
    }
  }

  public static class AudioSamples
  {
    private final int audioFormat;
    private final int channelCount;
    private final byte[] data;
    private final int sampleRate;

    public AudioSamples(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
    {
      this.audioFormat = paramInt1;
      this.channelCount = paramInt2;
      this.sampleRate = paramInt3;
      this.data = paramArrayOfByte;
    }

    public int getAudioFormat()
    {
      return this.audioFormat;
    }

    public int getChannelCount()
    {
      return this.channelCount;
    }

    public byte[] getData()
    {
      return this.data;
    }

    public int getSampleRate()
    {
      return this.sampleRate;
    }
  }

  public static abstract interface AudioTrackErrorCallback
  {
    public abstract void onWebRtcAudioTrackError(String paramString);

    public abstract void onWebRtcAudioTrackInitError(String paramString);

    public abstract void onWebRtcAudioTrackStartError(JavaAudioDeviceModule.AudioTrackStartErrorCode paramAudioTrackStartErrorCode, String paramString);
  }

  public static enum AudioTrackStartErrorCode
  {
    static
    {
      AudioTrackStartErrorCode[] arrayOfAudioTrackStartErrorCode = new AudioTrackStartErrorCode[2];
      arrayOfAudioTrackStartErrorCode[0] = AUDIO_TRACK_START_EXCEPTION;
      arrayOfAudioTrackStartErrorCode[1] = AUDIO_TRACK_START_STATE_MISMATCH;
    }
  }

  public static class Builder
  {
    private final AudioManager audioManager;
    private JavaAudioDeviceModule.AudioRecordErrorCallback audioRecordErrorCallback;
    private int audioSource = 7;
    private JavaAudioDeviceModule.AudioTrackErrorCallback audioTrackErrorCallback;
    private final Context context;
    private int sampleRate;
    private JavaAudioDeviceModule.SamplesReadyCallback samplesReadyCallback;
    private boolean useHardwareAcousticEchoCanceler = JavaAudioDeviceModule.isBuiltInAcousticEchoCancelerSupported();
    private boolean useHardwareNoiseSuppressor = JavaAudioDeviceModule.isBuiltInNoiseSuppressorSupported();
    private boolean useStereoInput;
    private boolean useStereoOutput;

    private Builder(Context paramContext)
    {
      this.context = paramContext;
      this.audioManager = ((AudioManager)paramContext.getSystemService("audio"));
      this.sampleRate = WebRtcAudioManager.getSampleRate(this.audioManager);
    }

    public AudioDeviceModule createAudioDeviceModule()
    {
      Logging.d("JavaAudioDeviceModule", "createAudioDeviceModule");
      if (this.useHardwareNoiseSuppressor)
      {
        Logging.d("JavaAudioDeviceModule", "HW NS will be used.");
        if (!this.useHardwareAcousticEchoCanceler)
          break label145;
        Logging.d("JavaAudioDeviceModule", "HW AEC will be used.");
      }
      while (true)
      {
        WebRtcAudioRecord localWebRtcAudioRecord = new WebRtcAudioRecord(this.context, this.audioManager, this.audioSource, this.audioRecordErrorCallback, this.samplesReadyCallback, this.useHardwareAcousticEchoCanceler, this.useHardwareNoiseSuppressor);
        WebRtcAudioTrack localWebRtcAudioTrack = new WebRtcAudioTrack(this.context, this.audioManager, this.audioTrackErrorCallback);
        return new JavaAudioDeviceModule(this.context, this.audioManager, localWebRtcAudioRecord, localWebRtcAudioTrack, this.sampleRate, this.useStereoInput, this.useStereoOutput, null);
        if (JavaAudioDeviceModule.isBuiltInNoiseSuppressorSupported())
          Logging.d("JavaAudioDeviceModule", "Overriding default behavior; now using WebRTC NS!");
        Logging.d("JavaAudioDeviceModule", "HW NS will not be used.");
        break;
        label145: if (JavaAudioDeviceModule.isBuiltInAcousticEchoCancelerSupported())
          Logging.d("JavaAudioDeviceModule", "Overriding default behavior; now using WebRTC AEC!");
        Logging.d("JavaAudioDeviceModule", "HW AEC will not be used.");
      }
    }

    public Builder setAudioRecordErrorCallback(JavaAudioDeviceModule.AudioRecordErrorCallback paramAudioRecordErrorCallback)
    {
      this.audioRecordErrorCallback = paramAudioRecordErrorCallback;
      return this;
    }

    public Builder setAudioSource(int paramInt)
    {
      this.audioSource = paramInt;
      return this;
    }

    public Builder setAudioTrackErrorCallback(JavaAudioDeviceModule.AudioTrackErrorCallback paramAudioTrackErrorCallback)
    {
      this.audioTrackErrorCallback = paramAudioTrackErrorCallback;
      return this;
    }

    public Builder setSampleRate(int paramInt)
    {
      Logging.d("JavaAudioDeviceModule", "Sample rate overridden to: " + paramInt);
      this.sampleRate = paramInt;
      return this;
    }

    public Builder setSamplesReadyCallback(JavaAudioDeviceModule.SamplesReadyCallback paramSamplesReadyCallback)
    {
      this.samplesReadyCallback = paramSamplesReadyCallback;
      return this;
    }

    public Builder setUseHardwareAcousticEchoCanceler(boolean paramBoolean)
    {
      if ((paramBoolean) && (!JavaAudioDeviceModule.isBuiltInAcousticEchoCancelerSupported()))
      {
        Logging.e("JavaAudioDeviceModule", "HW AEC not supported");
        paramBoolean = false;
      }
      this.useHardwareAcousticEchoCanceler = paramBoolean;
      return this;
    }

    public Builder setUseHardwareNoiseSuppressor(boolean paramBoolean)
    {
      if ((paramBoolean) && (!JavaAudioDeviceModule.isBuiltInNoiseSuppressorSupported()))
      {
        Logging.e("JavaAudioDeviceModule", "HW NS not supported");
        paramBoolean = false;
      }
      this.useHardwareNoiseSuppressor = paramBoolean;
      return this;
    }

    public Builder setUseStereoInput(boolean paramBoolean)
    {
      this.useStereoInput = paramBoolean;
      return this;
    }

    public Builder setUseStereoOutput(boolean paramBoolean)
    {
      this.useStereoOutput = paramBoolean;
      return this;
    }
  }

  public static abstract interface SamplesReadyCallback
  {
    public abstract void onWebRtcAudioRecordSamplesReady(JavaAudioDeviceModule.AudioSamples paramAudioSamples);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.audio.JavaAudioDeviceModule
 * JD-Core Version:    0.6.2
 */