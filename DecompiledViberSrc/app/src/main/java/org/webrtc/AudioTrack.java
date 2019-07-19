package org.webrtc;

public class AudioTrack extends MediaStreamTrack
{
  public AudioTrack(long paramLong)
  {
    super(paramLong);
  }

  private static native void nativeSetVolume(long paramLong, double paramDouble);

  public void setVolume(double paramDouble)
  {
    nativeSetVolume(this.nativeTrack, paramDouble);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.AudioTrack
 * JD-Core Version:    0.6.2
 */