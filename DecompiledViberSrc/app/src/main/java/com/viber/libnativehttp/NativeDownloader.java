package com.viber.libnativehttp;

public class NativeDownloader
  implements Http.Downloader
{
  private long nativePtr;

  public NativeDownloader(long paramLong)
  {
    this.nativePtr = paramLong;
  }

  private native void nativeOnConnected(long paramLong, AndroidHttp paramAndroidHttp);

  private native boolean nativeOnData(long paramLong, AndroidHttp paramAndroidHttp, byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean);

  private native void nativeOnDisconnected(long paramLong, AndroidHttp paramAndroidHttp);

  private native void nativeOnHead(long paramLong, AndroidHttp paramAndroidHttp, Http.Response paramResponse);

  public void onConnected(Http paramHttp)
  {
    if ((paramHttp == null) || (!(paramHttp instanceof AndroidHttp)))
      throw new RuntimeException("AndroidHttp object is invalid");
    nativeOnConnected(this.nativePtr, (AndroidHttp)paramHttp);
  }

  public boolean onData(Http paramHttp, byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramHttp == null) || (!(paramHttp instanceof AndroidHttp)))
      throw new RuntimeException("AndroidHttp object is invalid");
    return nativeOnData(this.nativePtr, (AndroidHttp)paramHttp, paramArrayOfByte, paramInt1, paramInt2, paramBoolean);
  }

  public void onDisconnected(Http paramHttp)
  {
    if ((paramHttp == null) || (!(paramHttp instanceof AndroidHttp)))
      throw new RuntimeException("AndroidHttp object is invalid");
    nativeOnDisconnected(this.nativePtr, (AndroidHttp)paramHttp);
  }

  public void onHead(Http paramHttp, Http.Response paramResponse)
  {
    if ((paramHttp == null) || (!(paramHttp instanceof AndroidHttp)))
      throw new RuntimeException("AndroidHttp object is invalid");
    nativeOnHead(this.nativePtr, (AndroidHttp)paramHttp, paramResponse);
  }

  public String toString()
  {
    return "nativePtr: " + Long.toHexString(this.nativePtr);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.libnativehttp.NativeDownloader
 * JD-Core Version:    0.6.2
 */