package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import java.io.Serializable;
import java.util.Locale;

public class VastAbsoluteProgressTracker extends VastTracker
  implements Serializable, Comparable<VastAbsoluteProgressTracker>
{
  private final int a;

  public VastAbsoluteProgressTracker(VastTracker.a parama, String paramString, int paramInt)
  {
    super(parama, paramString);
    if (paramInt >= 0);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      this.a = paramInt;
      return;
    }
  }

  public VastAbsoluteProgressTracker(String paramString, int paramInt)
  {
    this(VastTracker.a.TRACKING_URL, paramString, paramInt);
  }

  public int compareTo(VastAbsoluteProgressTracker paramVastAbsoluteProgressTracker)
  {
    int i = paramVastAbsoluteProgressTracker.getTrackingMilliseconds();
    return getTrackingMilliseconds() - i;
  }

  public int getTrackingMilliseconds()
  {
    return this.a;
  }

  public String toString()
  {
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(this.a);
    arrayOfObject[1] = getContent();
    return String.format(localLocale, "%dms: %s", arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.VastAbsoluteProgressTracker
 * JD-Core Version:    0.6.2
 */