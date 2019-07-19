package com.google.android.gms.internal.ads;

import android.location.Location;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAdOptions.Builder;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@zzare
public final class zzant
  implements NativeMediationAdRequest
{
  private final int zzcgp;
  private final boolean zzchb;
  private final String zzche;
  private final int zzdgc;
  private final int zzdgd;
  private final zzadx zzdgu;
  private final List<String> zzdgv;
  private final Map<String, Boolean> zzdgw;
  private final Date zzms;
  private final Set<String> zzmu;
  private final boolean zzmv;
  private final Location zzmw;

  public zzant(Date paramDate, int paramInt1, Set<String> paramSet, Location paramLocation, boolean paramBoolean1, int paramInt2, zzadx paramzzadx, List<String> paramList, boolean paramBoolean2, int paramInt3, String paramString)
  {
    this.zzms = paramDate;
    this.zzcgp = paramInt1;
    this.zzmu = paramSet;
    this.zzmw = paramLocation;
    this.zzmv = paramBoolean1;
    this.zzdgc = paramInt2;
    this.zzdgu = paramzzadx;
    this.zzchb = paramBoolean2;
    this.zzdgd = paramInt3;
    this.zzche = paramString;
    this.zzdgv = new ArrayList();
    this.zzdgw = new HashMap();
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (str.startsWith("custom:"))
        {
          String[] arrayOfString = str.split(":", 3);
          if (arrayOfString.length == 3)
            if ("true".equals(arrayOfString[2]))
              this.zzdgw.put(arrayOfString[1], Boolean.valueOf(true));
            else if ("false".equals(arrayOfString[2]))
              this.zzdgw.put(arrayOfString[1], Boolean.valueOf(false));
        }
        else
        {
          this.zzdgv.add(str);
        }
      }
    }
  }

  public final float getAdVolume()
  {
    return zzabc.zzqf().zzpq();
  }

  @Deprecated
  public final Date getBirthday()
  {
    return this.zzms;
  }

  @Deprecated
  public final int getGender()
  {
    return this.zzcgp;
  }

  public final Set<String> getKeywords()
  {
    return this.zzmu;
  }

  public final Location getLocation()
  {
    return this.zzmw;
  }

  public final NativeAdOptions getNativeAdOptions()
  {
    if (this.zzdgu == null)
      return null;
    NativeAdOptions.Builder localBuilder = new NativeAdOptions.Builder().setReturnUrlsForImageAssets(this.zzdgu.zzcym).setImageOrientation(this.zzdgu.zzbqc).setRequestMultipleImages(this.zzdgu.zzbqe);
    if (this.zzdgu.versionCode >= 2)
      localBuilder.setAdChoicesPlacement(this.zzdgu.zzbqf);
    if ((this.zzdgu.versionCode >= 3) && (this.zzdgu.zzcyn != null))
      localBuilder.setVideoOptions(new VideoOptions(this.zzdgu.zzcyn));
    return localBuilder.build();
  }

  public final boolean isAdMuted()
  {
    return zzabc.zzqf().zzpr();
  }

  public final boolean isAppInstallAdRequested()
  {
    return (this.zzdgv != null) && ((this.zzdgv.contains("2")) || (this.zzdgv.contains("6")));
  }

  public final boolean isContentAdRequested()
  {
    return (this.zzdgv != null) && ((this.zzdgv.contains("1")) || (this.zzdgv.contains("6")));
  }

  @Deprecated
  public final boolean isDesignedForFamilies()
  {
    return this.zzchb;
  }

  public final boolean isTesting()
  {
    return this.zzmv;
  }

  public final boolean isUnifiedNativeAdRequested()
  {
    return (this.zzdgv != null) && (this.zzdgv.contains("6"));
  }

  public final int taggedForChildDirectedTreatment()
  {
    return this.zzdgc;
  }

  public final boolean zzsu()
  {
    return (this.zzdgv != null) && (this.zzdgv.contains("3"));
  }

  public final Map<String, Boolean> zzsv()
  {
    return this.zzdgw;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzant
 * JD-Core Version:    0.6.2
 */