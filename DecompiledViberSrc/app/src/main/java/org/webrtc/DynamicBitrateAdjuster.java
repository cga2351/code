package org.webrtc;

class DynamicBitrateAdjuster extends BaseBitrateAdjuster
{
  private static final double BITRATE_ADJUSTMENT_MAX_SCALE = 4.0D;
  private static final double BITRATE_ADJUSTMENT_SEC = 3.0D;
  private static final int BITRATE_ADJUSTMENT_STEPS = 20;
  private static final double BITS_PER_BYTE = 8.0D;
  private int bitrateAdjustmentScaleExp = 0;
  private double deviationBytes = 0.0D;
  private double timeSinceLastAdjustmentMs = 0.0D;

  private double getBitrateAdjustmentScale()
  {
    return Math.pow(4.0D, this.bitrateAdjustmentScaleExp / 20.0D);
  }

  public int getAdjustedBitrateBps()
  {
    return (int)(this.targetBitrateBps * getBitrateAdjustmentScale());
  }

  public void reportEncodedFrame(int paramInt)
  {
    if (this.targetFps == 0);
    double d2;
    do
    {
      return;
      double d1 = this.targetBitrateBps / 8.0D / this.targetFps;
      this.deviationBytes += paramInt - d1;
      this.timeSinceLastAdjustmentMs += 1000.0D / this.targetFps;
      d2 = this.targetBitrateBps / 8.0D;
      double d3 = 3.0D * d2;
      this.deviationBytes = Math.min(this.deviationBytes, d3);
      this.deviationBytes = Math.max(this.deviationBytes, -d3);
    }
    while (this.timeSinceLastAdjustmentMs <= 3000.0D);
    if (this.deviationBytes > d2)
    {
      int i = (int)(0.5D + this.deviationBytes / d2);
      this.bitrateAdjustmentScaleExp -= i;
      this.bitrateAdjustmentScaleExp = Math.max(this.bitrateAdjustmentScaleExp, -20);
      this.deviationBytes = d2;
    }
    while (true)
    {
      this.timeSinceLastAdjustmentMs = 0.0D;
      return;
      if (this.deviationBytes < -d2)
      {
        this.bitrateAdjustmentScaleExp = ((int)(0.5D + -this.deviationBytes / d2) + this.bitrateAdjustmentScaleExp);
        this.bitrateAdjustmentScaleExp = Math.min(this.bitrateAdjustmentScaleExp, 20);
        this.deviationBytes = (-d2);
      }
    }
  }

  public void setTargets(int paramInt1, int paramInt2)
  {
    if ((this.targetBitrateBps > 0) && (paramInt1 < this.targetBitrateBps))
      this.deviationBytes = (this.deviationBytes * paramInt1 / this.targetBitrateBps);
    super.setTargets(paramInt1, paramInt2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.DynamicBitrateAdjuster
 * JD-Core Version:    0.6.2
 */