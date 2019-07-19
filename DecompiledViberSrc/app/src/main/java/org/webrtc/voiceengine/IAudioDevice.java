package org.webrtc.voiceengine;

public abstract interface IAudioDevice
{
  public static final int AUDIOROUTE_PLAYBACK = 1;
  public static final int AUDIOROUTE_PLAYBACK_AND_RECORDING = 3;
  public static final int AUDIOROUTE_RECORDING = 2;
  public static final int AUDIOROUTE_VOIP;

  public abstract int CheckDeviceVoiceCommunicationAbility(int paramInt1, int paramInt2);

  public abstract int GetAudioRoute();

  public abstract int GetPlayoutVolume();

  public abstract int ProbePlayback(int paramInt);

  public abstract int ProbeRecording(int paramInt1, int paramInt2);

  public abstract int SetAudioRoute(int paramInt);

  public abstract int SetPlayoutSpeaker(boolean paramBoolean);

  public abstract int SetPlayoutVolume(int paramInt);

  public abstract int StartPlayback();

  public abstract int StartRecording();

  public abstract int StopPlayback();

  public abstract int StopRecording();

  public abstract void registerStateListener(AudioDeviceStateListener paramAudioDeviceStateListener);

  public abstract void waitForInitialize();

  public static abstract interface AudioDeviceStateListener
  {
    public abstract void onCapturePostStart();

    public abstract void onCaptureStart();

    public abstract void onCaptureStop();

    public abstract void onPlaybackPostStart();

    public abstract void onPlaybackPostStop(int paramInt);

    public abstract void onPlaybackPreStart(int paramInt);

    public abstract void onPlaybackPreStop();

    public abstract void onStart(int paramInt);

    public abstract void onStop(int paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.voiceengine.IAudioDevice
 * JD-Core Version:    0.6.2
 */