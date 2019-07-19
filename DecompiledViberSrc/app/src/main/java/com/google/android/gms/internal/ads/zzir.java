package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class zzir extends zziq
{
  public final long zzalz;
  public final List<zzis> zzama = new ArrayList();
  public final List<zzir> zzamb = new ArrayList();

  public zzir(int paramInt, long paramLong)
  {
    super(paramInt);
    this.zzalz = paramLong;
  }

  public final String toString()
  {
    String str1 = zzu(this.type);
    String str2 = String.valueOf(Arrays.toString(this.zzama.toArray(new zzis[0])));
    String str3 = String.valueOf(Arrays.toString(this.zzamb.toArray(new zzir[0])));
    return 22 + String.valueOf(str1).length() + String.valueOf(str2).length() + String.valueOf(str3).length() + str1 + " leaves: " + str2 + " containers: " + str3;
  }

  public final zzis zzv(int paramInt)
  {
    int i = this.zzama.size();
    for (int j = 0; j < i; j++)
    {
      zzis localzzis = (zzis)this.zzama.get(j);
      if (localzzis.type == paramInt)
        return localzzis;
    }
    return null;
  }

  public final zzir zzw(int paramInt)
  {
    int i = this.zzamb.size();
    for (int j = 0; j < i; j++)
    {
      zzir localzzir = (zzir)this.zzamb.get(j);
      if (localzzir.type == paramInt)
        return localzzir;
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzir
 * JD-Core Version:    0.6.2
 */