package com.mopub.nativeads;

import com.mopub.common.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;

public class AdRendererRegistry
{
  private final ArrayList<MoPubAdRenderer> a = new ArrayList();

  public int getAdRendererCount()
  {
    return this.a.size();
  }

  public MoPubAdRenderer getRendererForAd(BaseNativeAd paramBaseNativeAd)
  {
    Preconditions.checkNotNull(paramBaseNativeAd);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      MoPubAdRenderer localMoPubAdRenderer = (MoPubAdRenderer)localIterator.next();
      if (localMoPubAdRenderer.supports(paramBaseNativeAd))
        return localMoPubAdRenderer;
    }
    return null;
  }

  public MoPubAdRenderer getRendererForViewType(int paramInt)
  {
    try
    {
      MoPubAdRenderer localMoPubAdRenderer = (MoPubAdRenderer)this.a.get(paramInt - 1);
      return localMoPubAdRenderer;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
    }
    return null;
  }

  public Iterable<MoPubAdRenderer> getRendererIterable()
  {
    return this.a;
  }

  public int getViewTypeForAd(NativeAd paramNativeAd)
  {
    Preconditions.checkNotNull(paramNativeAd);
    for (int i = 0; ; i++)
    {
      int j = this.a.size();
      int k = 0;
      if (i < j)
      {
        if (paramNativeAd.getMoPubAdRenderer() == this.a.get(i))
          k = i + 1;
      }
      else
        return k;
    }
  }

  public void registerAdRenderer(MoPubAdRenderer paramMoPubAdRenderer)
  {
    this.a.add(paramMoPubAdRenderer);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.nativeads.AdRendererRegistry
 * JD-Core Version:    0.6.2
 */