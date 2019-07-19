package com.mopub.mobileads;

public class VideoViewabilityTracker extends VastTracker
{
  private final int a;
  private final int b;

  public VideoViewabilityTracker(int paramInt1, int paramInt2, String paramString)
  {
    super(paramString);
    this.a = paramInt1;
    this.b = paramInt2;
  }

  public int getPercentViewable()
  {
    return this.b;
  }

  public int getViewablePlaytimeMS()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.VideoViewabilityTracker
 * JD-Core Version:    0.6.2
 */