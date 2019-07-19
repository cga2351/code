package org.webrtc;

public abstract interface CapturerObserver
{
  public abstract void onCapturerStarted(boolean paramBoolean);

  public abstract void onCapturerStopped();

  public abstract void onFrameCaptured(VideoFrame paramVideoFrame);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.CapturerObserver
 * JD-Core Version:    0.6.2
 */