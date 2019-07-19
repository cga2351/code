package org.webrtc;

public class DtmfSender
{
  final long nativeDtmfSender;

  public DtmfSender(long paramLong)
  {
    this.nativeDtmfSender = paramLong;
  }

  private static native boolean nativeCanInsertDtmf(long paramLong);

  private static native int nativeDuration(long paramLong);

  private static native boolean nativeInsertDtmf(long paramLong, String paramString, int paramInt1, int paramInt2);

  private static native int nativeInterToneGap(long paramLong);

  private static native String nativeTones(long paramLong);

  public boolean canInsertDtmf()
  {
    return nativeCanInsertDtmf(this.nativeDtmfSender);
  }

  public void dispose()
  {
    JniCommon.nativeReleaseRef(this.nativeDtmfSender);
  }

  public int duration()
  {
    return nativeDuration(this.nativeDtmfSender);
  }

  public boolean insertDtmf(String paramString, int paramInt1, int paramInt2)
  {
    return nativeInsertDtmf(this.nativeDtmfSender, paramString, paramInt1, paramInt2);
  }

  public int interToneGap()
  {
    return nativeInterToneGap(this.nativeDtmfSender);
  }

  public String tones()
  {
    return nativeTones(this.nativeDtmfSender);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.DtmfSender
 * JD-Core Version:    0.6.2
 */