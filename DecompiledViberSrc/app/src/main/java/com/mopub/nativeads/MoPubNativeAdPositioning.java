package com.mopub.nativeads;

import com.mopub.common.Preconditions;
import com.mopub.common.Preconditions.NoThrow;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class MoPubNativeAdPositioning
{
  static MoPubClientPositioning a(MoPubClientPositioning paramMoPubClientPositioning)
  {
    Preconditions.checkNotNull(paramMoPubClientPositioning);
    MoPubClientPositioning localMoPubClientPositioning = new MoPubClientPositioning();
    MoPubClientPositioning.a(localMoPubClientPositioning).addAll(MoPubClientPositioning.a(paramMoPubClientPositioning));
    MoPubClientPositioning.a(localMoPubClientPositioning, MoPubClientPositioning.b(paramMoPubClientPositioning));
    return localMoPubClientPositioning;
  }

  public static MoPubClientPositioning clientPositioning()
  {
    return new MoPubClientPositioning();
  }

  public static MoPubServerPositioning serverPositioning()
  {
    return new MoPubServerPositioning();
  }

  public static class MoPubClientPositioning
  {
    public static final int NO_REPEAT = 2147483647;
    private final ArrayList<Integer> a = new ArrayList();
    private int b = 2147483647;

    List<Integer> a()
    {
      return this.a;
    }

    public MoPubClientPositioning addFixedPosition(int paramInt)
    {
      boolean bool;
      if (paramInt >= 0)
      {
        bool = true;
        if (Preconditions.NoThrow.checkArgument(bool))
          break label20;
      }
      label20: int i;
      do
      {
        return this;
        bool = false;
        break;
        i = Collections.binarySearch(this.a, Integer.valueOf(paramInt));
      }
      while (i >= 0);
      this.a.add(i ^ 0xFFFFFFFF, Integer.valueOf(paramInt));
      return this;
    }

    int b()
    {
      return this.b;
    }

    public MoPubClientPositioning enableRepeatingPositions(int paramInt)
    {
      int i = 1;
      if (paramInt > i);
      while (!Preconditions.NoThrow.checkArgument(i, "Repeating interval must be greater than 1"))
      {
        this.b = 2147483647;
        return this;
        i = 0;
      }
      this.b = paramInt;
      return this;
    }
  }

  public static class MoPubServerPositioning
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.nativeads.MoPubNativeAdPositioning
 * JD-Core Version:    0.6.2
 */