package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.IOException;

public class zzbb extends zzdst
  implements Closeable
{
  private static zzdtb zzcp = zzdtb.zzm(zzbb.class);

  public zzbb(zzdsv paramzzdsv, zzba paramzzba)
    throws IOException
  {
    zza(paramzzdsv, paramzzdsv.size(), paramzzba);
  }

  public void close()
    throws IOException
  {
    this.zzhtn.close();
  }

  public String toString()
  {
    String str = this.zzhtn.toString();
    return 7 + String.valueOf(str).length() + "model(" + str + ")";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbb
 * JD-Core Version:    0.6.2
 */