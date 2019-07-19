package org.webrtc;

class BaseBitrateAdjuster
  implements BitrateAdjuster
{
  protected int targetBitrateBps = 0;
  protected int targetFps = 0;

  public int getAdjustedBitrateBps()
  {
    return this.targetBitrateBps;
  }

  public int getCodecConfigFramerate()
  {
    return this.targetFps;
  }

  public void reportEncodedFrame(int paramInt)
  {
  }

  public void setTargets(int paramInt1, int paramInt2)
  {
    this.targetBitrateBps = paramInt1;
    this.targetFps = paramInt2;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.BaseBitrateAdjuster
 * JD-Core Version:    0.6.2
 */