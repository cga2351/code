package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import java.io.Serializable;
import java.util.Locale;

public class VastFractionalProgressTracker extends VastTracker
  implements Serializable, Comparable<VastFractionalProgressTracker>
{
  private final float a;

  public VastFractionalProgressTracker(VastTracker.a parama, String paramString, float paramFloat)
  {
    super(parama, paramString);
    if (paramFloat >= 0.0F);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      this.a = paramFloat;
      return;
    }
  }

  public VastFractionalProgressTracker(String paramString, float paramFloat)
  {
    this(VastTracker.a.TRACKING_URL, paramString, paramFloat);
  }

  public int compareTo(VastFractionalProgressTracker paramVastFractionalProgressTracker)
  {
    float f = paramVastFractionalProgressTracker.trackingFraction();
    return Double.compare(trackingFraction(), f);
  }

  public String toString()
  {
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Float.valueOf(this.a);
    arrayOfObject[1] = getContent();
    return String.format(localLocale, "%2f: %s", arrayOfObject);
  }

  public float trackingFraction()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.VastFractionalProgressTracker
 * JD-Core Version:    0.6.2
 */