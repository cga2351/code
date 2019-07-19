package com.crashlytics.android.a;

final class ae
{
  public final String a;
  public final String b;
  public final String c;
  public final Boolean d;
  public final String e;
  public final String f;
  public final String g;
  public final String h;
  public final String i;
  public final String j;
  private String k;

  public ae(String paramString1, String paramString2, String paramString3, Boolean paramBoolean, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramBoolean;
    this.e = paramString4;
    this.f = paramString5;
    this.g = paramString6;
    this.h = paramString7;
    this.i = paramString8;
    this.j = paramString9;
  }

  public String toString()
  {
    if (this.k == null)
      this.k = ("appBundleId=" + this.a + ", executionId=" + this.b + ", installationId=" + this.c + ", limitAdTrackingEnabled=" + this.d + ", betaDeviceToken=" + this.e + ", buildId=" + this.f + ", osVersion=" + this.g + ", deviceModel=" + this.h + ", appVersionCode=" + this.i + ", appVersionName=" + this.j);
    return this.k;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.a.ae
 * JD-Core Version:    0.6.2
 */