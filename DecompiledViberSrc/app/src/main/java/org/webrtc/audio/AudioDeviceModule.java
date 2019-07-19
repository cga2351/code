package org.webrtc.audio;

public abstract interface AudioDeviceModule
{
  public abstract long getNativeAudioDeviceModulePointer();

  public abstract void release();

  public abstract void setMicrophoneMute(boolean paramBoolean);

  public abstract void setSpeakerMute(boolean paramBoolean);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.audio.AudioDeviceModule
 * JD-Core Version:    0.6.2
 */