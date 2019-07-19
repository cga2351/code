package org.webrtc;

public abstract interface SdpObserver
{
  @CalledByNative
  public abstract void onCreateFailure(String paramString);

  @CalledByNative
  public abstract void onCreateSuccess(SessionDescription paramSessionDescription);

  @CalledByNative
  public abstract void onSetFailure(String paramString);

  @CalledByNative
  public abstract void onSetSuccess();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.SdpObserver
 * JD-Core Version:    0.6.2
 */