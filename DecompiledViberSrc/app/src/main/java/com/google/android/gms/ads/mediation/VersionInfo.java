package com.google.android.gms.ads.mediation;

public final class VersionInfo
{
  private final int zzens;
  private final int zzent;
  private final int zzenu;

  public VersionInfo(int paramInt1, int paramInt2, int paramInt3)
  {
    this.zzens = paramInt1;
    this.zzent = paramInt2;
    this.zzenu = paramInt3;
  }

  public final int getMajorVersion()
  {
    return this.zzens;
  }

  public final int getMicroVersion()
  {
    return this.zzenu;
  }

  public final int getMinorVersion()
  {
    return this.zzent;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.mediation.VersionInfo
 * JD-Core Version:    0.6.2
 */