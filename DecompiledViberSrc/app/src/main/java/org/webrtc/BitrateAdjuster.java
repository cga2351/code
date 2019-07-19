package org.webrtc;

abstract interface BitrateAdjuster
{
  public abstract int getAdjustedBitrateBps();

  public abstract int getCodecConfigFramerate();

  public abstract void reportEncodedFrame(int paramInt);

  public abstract void setTargets(int paramInt1, int paramInt2);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.BitrateAdjuster
 * JD-Core Version:    0.6.2
 */