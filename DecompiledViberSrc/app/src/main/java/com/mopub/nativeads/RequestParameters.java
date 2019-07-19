package com.mopub.nativeads;

import android.location.Location;
import android.text.TextUtils;
import com.mopub.common.MoPub;
import java.util.EnumSet;

public class RequestParameters
{
  private final String a;
  private final String b;
  private final Location c;
  private final EnumSet<NativeAdAsset> d;

  private RequestParameters(Builder paramBuilder)
  {
    this.a = Builder.a(paramBuilder);
    this.d = Builder.b(paramBuilder);
    boolean bool = MoPub.canCollectPersonalInformation();
    if (bool);
    for (String str = Builder.c(paramBuilder); ; str = null)
    {
      this.b = str;
      Location localLocation = null;
      if (bool)
        localLocation = Builder.d(paramBuilder);
      this.c = localLocation;
      return;
    }
  }

  public final String getDesiredAssets()
  {
    String str = "";
    if (this.d != null)
      str = TextUtils.join(",", this.d.toArray());
    return str;
  }

  public final String getKeywords()
  {
    return this.a;
  }

  public final Location getLocation()
  {
    return this.c;
  }

  public final String getUserDataKeywords()
  {
    if (!MoPub.canCollectPersonalInformation())
      return null;
    return this.b;
  }

  public static final class Builder
  {
    private String a;
    private String b;
    private Location c;
    private EnumSet<RequestParameters.NativeAdAsset> d;

    public final RequestParameters build()
    {
      return new RequestParameters(this, null);
    }

    public final Builder desiredAssets(EnumSet<RequestParameters.NativeAdAsset> paramEnumSet)
    {
      this.d = EnumSet.copyOf(paramEnumSet);
      return this;
    }

    public final Builder keywords(String paramString)
    {
      this.a = paramString;
      return this;
    }

    public final Builder location(Location paramLocation)
    {
      if (MoPub.canCollectPersonalInformation());
      while (true)
      {
        this.c = paramLocation;
        return this;
        paramLocation = null;
      }
    }

    public final Builder userDataKeywords(String paramString)
    {
      if (MoPub.canCollectPersonalInformation());
      while (true)
      {
        this.b = paramString;
        return this;
        paramString = null;
      }
    }
  }

  public static enum NativeAdAsset
  {
    private final String a;

    static
    {
      TEXT = new NativeAdAsset("TEXT", 1, "text");
      ICON_IMAGE = new NativeAdAsset("ICON_IMAGE", 2, "iconimage");
      MAIN_IMAGE = new NativeAdAsset("MAIN_IMAGE", 3, "mainimage");
      CALL_TO_ACTION_TEXT = new NativeAdAsset("CALL_TO_ACTION_TEXT", 4, "ctatext");
      STAR_RATING = new NativeAdAsset("STAR_RATING", 5, "starrating");
      NativeAdAsset[] arrayOfNativeAdAsset = new NativeAdAsset[6];
      arrayOfNativeAdAsset[0] = TITLE;
      arrayOfNativeAdAsset[1] = TEXT;
      arrayOfNativeAdAsset[2] = ICON_IMAGE;
      arrayOfNativeAdAsset[3] = MAIN_IMAGE;
      arrayOfNativeAdAsset[4] = CALL_TO_ACTION_TEXT;
      arrayOfNativeAdAsset[5] = STAR_RATING;
    }

    private NativeAdAsset(String paramString)
    {
      this.a = paramString;
    }

    public String toString()
    {
      return this.a;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.nativeads.RequestParameters
 * JD-Core Version:    0.6.2
 */