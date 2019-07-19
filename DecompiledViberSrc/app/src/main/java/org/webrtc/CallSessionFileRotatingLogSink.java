package org.webrtc;

public class CallSessionFileRotatingLogSink
{
  private long nativeSink;

  public CallSessionFileRotatingLogSink(String paramString, int paramInt, Logging.Severity paramSeverity)
  {
    if (paramString == null)
      throw new IllegalArgumentException("dirPath may not be null.");
    this.nativeSink = nativeAddSink(paramString, paramInt, paramSeverity.ordinal());
  }

  public static byte[] getLogData(String paramString)
  {
    if (paramString == null)
      throw new IllegalArgumentException("dirPath may not be null.");
    return nativeGetLogData(paramString);
  }

  private static native long nativeAddSink(String paramString, int paramInt1, int paramInt2);

  private static native void nativeDeleteSink(long paramLong);

  private static native byte[] nativeGetLogData(String paramString);

  public void dispose()
  {
    if (this.nativeSink != 0L)
    {
      nativeDeleteSink(this.nativeSink);
      this.nativeSink = 0L;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.CallSessionFileRotatingLogSink
 * JD-Core Version:    0.6.2
 */