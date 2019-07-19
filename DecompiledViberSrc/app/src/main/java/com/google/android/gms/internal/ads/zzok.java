package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class zzok extends zzoj
{
  public final List<zzol> zzama;
  public final List<zzok> zzamb;
  public final long zzbdz;

  public zzok(int paramInt, long paramLong)
  {
    super(paramInt);
    this.zzbdz = paramLong;
    this.zzama = new ArrayList();
    this.zzamb = new ArrayList();
  }

  public final String toString()
  {
    String str1 = zzu(this.type);
    String str2 = Arrays.toString(this.zzama.toArray());
    String str3 = Arrays.toString(this.zzamb.toArray());
    return 22 + String.valueOf(str1).length() + String.valueOf(str2).length() + String.valueOf(str3).length() + str1 + " leaves: " + str2 + " containers: " + str3;
  }

  public final zzol zzay(int paramInt)
  {
    int i = this.zzama.size();
    for (int j = 0; j < i; j++)
    {
      zzol localzzol = (zzol)this.zzama.get(j);
      if (localzzol.type == paramInt)
        return localzzol;
    }
    return null;
  }

  public final zzok zzaz(int paramInt)
  {
    int i = this.zzamb.size();
    for (int j = 0; j < i; j++)
    {
      zzok localzzok = (zzok)this.zzamb.get(j);
      if (localzzok.type == paramInt)
        return localzzok;
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzok
 * JD-Core Version:    0.6.2
 */