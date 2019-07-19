package org.webrtc;

public class TurnCustomizer
{
  final long nativeTurnCustomizer;

  public TurnCustomizer(long paramLong)
  {
    this.nativeTurnCustomizer = paramLong;
  }

  private static native void nativeFreeTurnCustomizer(long paramLong);

  public void dispose()
  {
    nativeFreeTurnCustomizer(this.nativeTurnCustomizer);
  }

  @CalledByNative
  long getNativeTurnCustomizer()
  {
    return this.nativeTurnCustomizer;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.TurnCustomizer
 * JD-Core Version:    0.6.2
 */