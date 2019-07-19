package com.google.android.gms.internal.ads;

public abstract class zzlr
{
  public static final zzlr zzaum = new zzls();

  public final boolean isEmpty()
  {
    return zzhf() == 0;
  }

  public final int zza(int paramInt1, zzlt paramzzlt, zzlu paramzzlu, int paramInt2)
  {
    int i = 1;
    zza(paramInt1, paramzzlt, false);
    zza(0, paramzzlu, false);
    if (paramInt1 == 0)
    {
      switch (paramInt2)
      {
      default:
        throw new IllegalStateException();
      case 0:
        if (-1 + zzhf() == 0)
          i = -1;
        break;
      case 1:
      case 2:
      }
      while (i == -1)
      {
        return -1;
        i = 0;
        continue;
        if (-1 + zzhf() == 0)
          i = 0;
      }
      zza(i, paramzzlu, false);
      return 0;
    }
    return paramInt1 + 1;
  }

  public abstract zzlt zza(int paramInt, zzlt paramzzlt, boolean paramBoolean);

  public final zzlu zza(int paramInt, zzlu paramzzlu, boolean paramBoolean)
  {
    return zza(paramInt, paramzzlu, false, 0L);
  }

  public abstract zzlu zza(int paramInt, zzlu paramzzlu, boolean paramBoolean, long paramLong);

  public abstract int zzc(Object paramObject);

  public abstract int zzhf();

  public abstract int zzhg();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzlr
 * JD-Core Version:    0.6.2
 */