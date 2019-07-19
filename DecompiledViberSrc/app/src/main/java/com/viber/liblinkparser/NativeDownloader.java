package com.viber.liblinkparser;

public class NativeDownloader
  implements Http.Downloader
{
  private long nativePtr;

  public NativeDownloader(long paramLong)
  {
    this.nativePtr = paramLong;
  }

  private native boolean nativeOnData(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2);

  private native boolean nativeOnResponse(long paramLong, Http.Response paramResponse);

  public boolean onData(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return nativeOnData(this.nativePtr, paramArrayOfByte, paramInt1, paramInt2);
  }

  public boolean onResponse(Http.Response paramResponse)
  {
    return nativeOnResponse(this.nativePtr, paramResponse);
  }

  public String toString()
  {
    return "nativePtr: " + Long.toHexString(this.nativePtr);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.liblinkparser.NativeDownloader
 * JD-Core Version:    0.6.2
 */