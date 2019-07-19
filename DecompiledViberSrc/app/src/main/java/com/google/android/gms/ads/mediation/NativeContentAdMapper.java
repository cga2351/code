package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAd.Image;
import java.util.List;

@Deprecated
public class NativeContentAdMapper extends NativeAdMapper
{
  private String zzdnj;
  private String zzene;
  private List<NativeAd.Image> zzenf;
  private String zzenh;
  private NativeAd.Image zzenl;
  private String zzenm;

  public final String getAdvertiser()
  {
    return this.zzenm;
  }

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

  public final List<NativeAd.Image> getImages()
  {
    return this.zzenf;
  }

  public final NativeAd.Image getLogo()
  {
    return this.zzenl;
  }

  public final void setAdvertiser(String paramString)
  {
    this.zzenm = paramString;
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

  public final void setImages(List<NativeAd.Image> paramList)
  {
    this.zzenf = paramList;
  }

  public final void setLogo(NativeAd.Image paramImage)
  {
    this.zzenl = paramImage;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.mediation.NativeContentAdMapper
 * JD-Core Version:    0.6.2
 */