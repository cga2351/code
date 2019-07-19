package com.mopub.nativeads;

import android.view.View;
import com.mopub.common.Preconditions.NoThrow;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdLogEvent;
import java.util.HashMap;
import java.util.Map;

public abstract class StaticNativeAd extends BaseNativeAd
  implements ClickInterface, ImpressionInterface
{
  private String a;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private Double g;
  private String h;
  private String i;
  private boolean j;
  private int k = 1000;
  private int l = 50;
  private Integer m = null;
  private final Map<String, Object> n = new HashMap();

  public final void addExtra(String paramString, Object paramObject)
  {
    if (!Preconditions.NoThrow.checkNotNull(paramString, "addExtra key is not allowed to be null"))
      return;
    this.n.put(paramString, paramObject);
  }

  public void clear(View paramView)
  {
  }

  public void destroy()
  {
    invalidate();
  }

  public final String getCallToAction()
  {
    return this.d;
  }

  public final String getClickDestinationUrl()
  {
    return this.c;
  }

  public final Object getExtra(String paramString)
  {
    if (!Preconditions.NoThrow.checkNotNull(paramString, "getExtra key is not allowed to be null"))
      return null;
    return this.n.get(paramString);
  }

  public final Map<String, Object> getExtras()
  {
    return new HashMap(this.n);
  }

  public final String getIconImageUrl()
  {
    return this.b;
  }

  public final int getImpressionMinPercentageViewed()
  {
    return this.l;
  }

  public final int getImpressionMinTimeViewed()
  {
    return this.k;
  }

  public final Integer getImpressionMinVisiblePx()
  {
    return this.m;
  }

  public final String getMainImageUrl()
  {
    return this.a;
  }

  public final String getPrivacyInformationIconClickThroughUrl()
  {
    return this.h;
  }

  public String getPrivacyInformationIconImageUrl()
  {
    return this.i;
  }

  public final Double getStarRating()
  {
    return this.g;
  }

  public final String getText()
  {
    return this.f;
  }

  public final String getTitle()
  {
    return this.e;
  }

  public void handleClick(View paramView)
  {
  }

  public final boolean isImpressionRecorded()
  {
    return this.j;
  }

  public void prepare(View paramView)
  {
  }

  public void recordImpression(View paramView)
  {
  }

  public final void setCallToAction(String paramString)
  {
    this.d = paramString;
  }

  public final void setClickDestinationUrl(String paramString)
  {
    this.c = paramString;
  }

  public final void setIconImageUrl(String paramString)
  {
    this.b = paramString;
  }

  public final void setImpressionMinPercentageViewed(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 100))
    {
      this.l = paramInt;
      return;
    }
    MoPubLog.AdLogEvent localAdLogEvent = MoPubLog.AdLogEvent.CUSTOM;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = ("Ignoring impressionMinTimeViewed that's not a percent [0, 100]: " + paramInt);
    MoPubLog.log(localAdLogEvent, arrayOfObject);
  }

  public final void setImpressionMinTimeViewed(int paramInt)
  {
    if (paramInt > 0)
    {
      this.k = paramInt;
      return;
    }
    MoPubLog.AdLogEvent localAdLogEvent = MoPubLog.AdLogEvent.CUSTOM;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = ("Ignoring non-positive impressionMinTimeViewed: " + paramInt);
    MoPubLog.log(localAdLogEvent, arrayOfObject);
  }

  public final void setImpressionMinVisiblePx(Integer paramInteger)
  {
    if ((paramInteger != null) && (paramInteger.intValue() > 0))
    {
      this.m = paramInteger;
      return;
    }
    MoPubLog.AdLogEvent localAdLogEvent = MoPubLog.AdLogEvent.CUSTOM;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = ("Ignoring null or non-positive impressionMinVisiblePx: " + paramInteger);
    MoPubLog.log(localAdLogEvent, arrayOfObject);
  }

  public final void setImpressionRecorded()
  {
    this.j = true;
  }

  public final void setMainImageUrl(String paramString)
  {
    this.a = paramString;
  }

  public final void setPrivacyInformationIconClickThroughUrl(String paramString)
  {
    this.h = paramString;
  }

  public final void setPrivacyInformationIconImageUrl(String paramString)
  {
    this.i = paramString;
  }

  public final void setStarRating(Double paramDouble)
  {
    if (paramDouble == null)
    {
      this.g = null;
      return;
    }
    if ((paramDouble.doubleValue() >= 0.0D) && (paramDouble.doubleValue() <= 5.0D))
    {
      this.g = paramDouble;
      return;
    }
    MoPubLog.AdLogEvent localAdLogEvent = MoPubLog.AdLogEvent.CUSTOM;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = ("Ignoring attempt to set invalid star rating (" + paramDouble + "). Must be between " + 0.0D + " and " + 5.0D + ".");
    MoPubLog.log(localAdLogEvent, arrayOfObject);
  }

  public final void setText(String paramString)
  {
    this.f = paramString;
  }

  public final void setTitle(String paramString)
  {
    this.e = paramString;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.nativeads.StaticNativeAd
 * JD-Core Version:    0.6.2
 */