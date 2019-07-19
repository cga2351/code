package com.appnexus.opensdk;

import android.graphics.Bitmap;
import android.view.View;
import java.util.HashMap;
import java.util.List;

public abstract interface NativeAdResponse
{
  public abstract void destroy();

  public abstract Rating getAdStarRating();

  public abstract String getCallToAction();

  public abstract String getCreativeId();

  public abstract String getDescription();

  public abstract String getFullText();

  public abstract Bitmap getIcon();

  public abstract String getIconUrl();

  public abstract Bitmap getImage();

  public abstract String getImageUrl();

  public abstract List<String> getImpressionTrackers();

  public abstract HashMap<String, Object> getNativeElements();

  public abstract Network getNetworkIdentifier();

  public abstract String getOriginalResponse();

  public abstract String getSocialContext();

  public abstract String getSponsoredBy();

  public abstract String getTitle();

  public abstract boolean hasExpired();

  public abstract boolean registerView(View paramView, NativeAdEventListener paramNativeAdEventListener);

  public abstract boolean registerViewList(View paramView, List<View> paramList, NativeAdEventListener paramNativeAdEventListener);

  public abstract void setCreativeId(String paramString);

  public abstract void setIcon(Bitmap paramBitmap);

  public abstract void setImage(Bitmap paramBitmap);

  public abstract void unregisterViews();

  public static class MainMedia
  {
  }

  public static enum Network
  {
    static
    {
      APPNEXUS = new Network("APPNEXUS", 2);
      INMOBI = new Network("INMOBI", 3);
      YAHOO = new Network("YAHOO", 4);
      ADMOB = new Network("ADMOB", 5);
      CUSTOM = new Network("CUSTOM", 6);
      Network[] arrayOfNetwork = new Network[7];
      arrayOfNetwork[0] = FACEBOOK;
      arrayOfNetwork[1] = MOPUB;
      arrayOfNetwork[2] = APPNEXUS;
      arrayOfNetwork[3] = INMOBI;
      arrayOfNetwork[4] = YAHOO;
      arrayOfNetwork[5] = ADMOB;
      arrayOfNetwork[6] = CUSTOM;
    }
  }

  public static class Rating
  {
    private final double a;
    private final double b;

    public Rating(double paramDouble1, double paramDouble2)
    {
      this.a = paramDouble1;
      this.b = paramDouble2;
    }

    public double getScale()
    {
      return this.b;
    }

    public double getValue()
    {
      return this.a;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.NativeAdResponse
 * JD-Core Version:    0.6.2
 */