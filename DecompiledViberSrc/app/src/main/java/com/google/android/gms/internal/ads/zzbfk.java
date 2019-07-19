package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

@zzare
final class zzbfk
  implements zzrv
{
  private Uri uri;
  private final long zzegi;
  private long zzegk;
  private final zzrv zzeho;
  private final zzrv zzehp;

  zzbfk(zzrv paramzzrv1, int paramInt, zzrv paramzzrv2)
  {
    this.zzeho = paramzzrv1;
    this.zzegi = paramInt;
    this.zzehp = paramzzrv2;
  }

  public final void close()
    throws IOException
  {
    this.zzeho.close();
    this.zzehp.close();
  }

  public final Uri getUri()
  {
    return this.uri;
  }

  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    boolean bool = this.zzegk < this.zzegi;
    int i = 0;
    if (bool)
    {
      int m = (int)Math.min(paramInt2, this.zzegi - this.zzegk);
      i = this.zzeho.read(paramArrayOfByte, paramInt1, m);
      this.zzegk += i;
    }
    if (this.zzegk >= this.zzegi)
    {
      int j = paramInt2 - i;
      int k = this.zzehp.read(paramArrayOfByte, paramInt1 + i, j);
      i += k;
      this.zzegk += k;
    }
    return i;
  }

  public final long zza(zzry paramzzry)
    throws IOException
  {
    this.uri = paramzzry.uri;
    zzry localzzry1;
    zzry localzzry2;
    if (paramzzry.zzahv >= this.zzegi)
    {
      localzzry1 = null;
      if (paramzzry.zzcd == -1L)
        break label186;
      boolean bool = paramzzry.zzahv + paramzzry.zzcd < this.zzegi;
      localzzry2 = null;
      if (bool)
        break label186;
      if (localzzry1 == null)
        break label274;
    }
    label274: for (long l5 = this.zzeho.zza(localzzry1); ; l5 = 0L)
    {
      if (localzzry2 != null);
      for (long l6 = this.zzehp.zza(localzzry2); ; l6 = 0L)
      {
        this.zzegk = paramzzry.zzahv;
        if ((l5 == -1L) || (l6 == -1L))
        {
          return -1L;
          long l1 = paramzzry.zzahv;
          if (paramzzry.zzcd != -1L);
          for (long l2 = Math.min(paramzzry.zzcd, this.zzegi - l1); ; l2 = this.zzegi - l1)
          {
            localzzry1 = new zzry(paramzzry.uri, l1, l2, null);
            break;
          }
          label186: long l3 = Math.max(this.zzegi, paramzzry.zzahv);
          if (paramzzry.zzcd != -1L);
          for (long l4 = Math.min(paramzzry.zzcd, paramzzry.zzahv + paramzzry.zzcd - this.zzegi); ; l4 = -1L)
          {
            localzzry2 = new zzry(paramzzry.uri, l3, l4, null);
            break;
          }
        }
        return l5 + l6;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbfk
 * JD-Core Version:    0.6.2
 */