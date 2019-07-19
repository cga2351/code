package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAd.Image;
import java.util.List;

@Deprecated
public class NativeAppInstallAdMapper extends NativeAdMapper
{
  private String zzdnj;
  private String zzene;
  private List<NativeAd.Image> zzenf;
  private NativeAd.Image zzeng;
  private String zzenh;
  private double zzeni;
  private String zzenj;
  private String zzenk;

  public final String getBody()
  {
    return this.zzdnj;
  }

  public final String getCallToAction()
  {
    return this.zzenh;
  }

  public final String getHeadline()
  {
    return this.zzene;
  }

  public final NativeAd.Image getIcon()
  {
    return this.zzeng;
  }

  public final List<NativeAd.Image> getImages()
  {
    return this.zzenf;
  }

  public final String getPrice()
  {
    return this.zzenk;
  }

  public final double getStarRating()
  {
    return this.zzeni;
  }

  public final String getStore()
  {
    return this.zzenj;
  }

  public final void setBody(String paramString)
  {
    this.zzdnj = paramString;
  }

  public final void setCallToAction(String paramString)
  {
    this.zzenh = paramString;
  }

  public final void setHeadline(String paramString)
  {
    this.zzene = paramString;
  }

  public final void setIcon(NativeAd.Image paramImage)
  {
    this.zzeng = paramImage;
  }

  public final void setImages(List<NativeAd.Image> paramList)
  {
    this.zzenf = paramList;
  }

  public final void setPrice(String paramString)
  {
    this.zzenk = paramString;
  }

  public final void setStarRating(double paramDouble)
  {
    this.zzeni = paramDouble;
  }

  public final void setStore(String paramString)
  {
    this.zzenj = paramString;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.mediation.NativeAppInstallAdMapper
 * JD-Core Version:    0.6.2
 */