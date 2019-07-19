package com.google.android.gms.ads.rewarded;

public class ServerSideVerificationOptions
{
  private final String zzdqu;
  private final String zzdqv;

  private ServerSideVerificationOptions(Builder paramBuilder)
  {
    this.zzdqu = Builder.zza(paramBuilder);
    this.zzdqv = Builder.zzb(paramBuilder);
  }

  public String getCustomData()
  {
    return this.zzdqv;
  }

  public String getUserId()
  {
    return this.zzdqu;
  }

  public static final class Builder
  {
    private String zzdqu = "";
    private String zzdqv = "";

    public final ServerSideVerificationOptions build()
    {
      return new ServerSideVerificationOptions(this, null);
    }

    public final Builder setCustomData(String paramString)
    {
      this.zzdqv = paramString;
      return this;
    }

    public final Builder setUserId(String paramString)
    {
      this.zzdqu = paramString;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.rewarded.ServerSideVerificationOptions
 * JD-Core Version:    0.6.2
 */