package com.google.android.gms.internal.ads;

@zzare
public final class zzbio
{
  public final int heightPixels;
  private final int type;
  public final int widthPixels;

  private zzbio(int paramInt1, int paramInt2, int paramInt3)
  {
    this.type = paramInt1;
    this.widthPixels = paramInt2;
    this.heightPixels = paramInt3;
  }

  public static zzbio zzabu()
  {
    return new zzbio(0, 0, 0);
  }

  public static zzbio zzabv()
  {
    return new zzbio(4, 0, 0);
  }

  public static zzbio zzabw()
  {
    return new zzbio(5, 0, 0);
  }

  public static zzbio zzb(zzyb paramzzyb)
  {
    if (paramzzyb.zzchg)
      return new zzbio(3, 0, 0);
    if (paramzzyb.zzchi)
      return new zzbio(2, 0, 0);
    if (paramzzyb.zzbta)
      return zzabu();
    return zzr(paramzzyb.widthPixels, paramzzyb.heightPixels);
  }

  public static zzbio zzr(int paramInt1, int paramInt2)
  {
    return new zzbio(1, paramInt1, paramInt2);
  }

  public final boolean isFluid()
  {
    return this.type == 2;
  }

  public final boolean zzabx()
  {
    return this.type == 3;
  }

  public final boolean zzaby()
  {
    return this.type == 0;
  }

  public final boolean zzabz()
  {
    return this.type == 4;
  }

  public final boolean zzaca()
  {
    return this.type == 5;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbio
 * JD-Core Version:    0.6.2
 */