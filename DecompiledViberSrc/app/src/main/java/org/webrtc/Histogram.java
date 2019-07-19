package org.webrtc;

class Histogram
{
  private final long handle;

  private Histogram(long paramLong)
  {
    this.handle = paramLong;
  }

  public static Histogram createCounts(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    return new Histogram(nativeCreateCounts(paramString, paramInt1, paramInt2, paramInt3));
  }

  public static Histogram createEnumeration(String paramString, int paramInt)
  {
    return new Histogram(nativeCreateEnumeration(paramString, paramInt));
  }

  private static native void nativeAddSample(long paramLong, int paramInt);

  private static native long nativeCreateCounts(String paramString, int paramInt1, int paramInt2, int paramInt3);

  private static native long nativeCreateEnumeration(String paramString, int paramInt);

  public void addSample(int paramInt)
  {
    nativeAddSample(this.handle, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.Histogram
 * JD-Core Version:    0.6.2
 */