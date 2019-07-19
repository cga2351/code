package com.viber.jni.webrtc;

class IncomingProcessedCallback
  implements ProcessedCallback
{
  private long mPtr;

  private IncomingProcessedCallback(long paramLong)
  {
    this.mPtr = paramLong;
  }

  private native void nativeDestroy(long paramLong);

  private native void nativeOnProcessed(long paramLong, boolean paramBoolean);

  public void finalize()
  {
    if (this.mPtr != 0L)
    {
      nativeDestroy(this.mPtr);
      this.mPtr = 0L;
    }
  }

  public void onProcessed(boolean paramBoolean)
  {
    nativeOnProcessed(this.mPtr, paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.webrtc.IncomingProcessedCallback
 * JD-Core Version:    0.6.2
 */