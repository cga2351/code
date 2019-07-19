package org.webrtc;

class FramerateBitrateAdjuster extends BaseBitrateAdjuster
{
  private static final int INITIAL_FPS = 30;

  public int getCodecConfigFramerate()
  {
    return 30;
  }

  public void setTargets(int paramInt1, int paramInt2)
  {
    if (this.targetFps == 0)
      paramInt2 = 30;
    super.setTargets(paramInt1, paramInt2);
    this.targetBitrateBps = (30 * this.targetBitrateBps / this.targetFps);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.FramerateBitrateAdjuster
 * JD-Core Version:    0.6.2
 */