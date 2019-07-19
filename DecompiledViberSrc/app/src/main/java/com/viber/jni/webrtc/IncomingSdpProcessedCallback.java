package com.viber.jni.webrtc;

class IncomingSdpProcessedCallback
  implements SdpProcessedCallback
{
  private long mPtr;

  private IncomingSdpProcessedCallback(long paramLong)
  {
    this.mPtr = paramLong;
  }

  private native void nativeDestroy(long paramLong);

  private native void nativeOnProcessed(long paramLong, String paramString);

  public void finalize()
  {
    if (this.mPtr != 0L)
    {
      nativeDestroy(this.mPtr);
      this.mPtr = 0L;
    }
  }

  public void onProcessed(String paramString)
  {
    nativeOnProcessed(this.mPtr, paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.webrtc.IncomingSdpProcessedCallback
 * JD-Core Version:    0.6.2
 */