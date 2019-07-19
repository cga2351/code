package com.viber.voip.phone;

class NetworkStatusNotifier
{
  final long mNativeHandle = prepareNative();

  private native void disposeNative(long paramLong);

  private native void notifyStarted(long paramLong, boolean paramBoolean);

  private native long prepareNative();

  public void dispose()
  {
    disposeNative(this.mNativeHandle);
  }

  public long getNativeNotifier()
  {
    return this.mNativeHandle;
  }

  public void started(boolean paramBoolean)
  {
    notifyStarted(this.mNativeHandle, paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.NetworkStatusNotifier
 * JD-Core Version:    0.6.2
 */