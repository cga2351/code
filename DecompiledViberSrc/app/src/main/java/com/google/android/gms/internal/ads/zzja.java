package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Stack;

final class zzja
  implements zzjd
{
  private final byte[] zzanf = new byte[8];
  private final Stack<zzjc> zzang = new Stack();
  private final zzjf zzanh = new zzjf();
  private zzje zzani;
  private int zzanj;
  private int zzank;
  private long zzanl;

  private final long zzc(zzie paramzzie, int paramInt)
    throws IOException, InterruptedException
  {
    int i = 0;
    paramzzie.readFully(this.zzanf, 0, paramInt);
    long l = 0L;
    while (i < paramInt)
    {
      l = l << 8 | 0xFF & this.zzanf[i];
      i++;
    }
    return l;
  }

  public final void reset()
  {
    this.zzanj = 0;
    this.zzang.clear();
    this.zzanh.reset();
  }

  public final void zza(zzje paramzzje)
  {
    this.zzani = paramzzje;
  }

  public final boolean zza(zzie paramzzie)
    throws IOException, InterruptedException
  {
    boolean bool;
    if (this.zzani != null)
    {
      bool = true;
      zzkh.checkState(bool);
    }
    while (true)
    {
      if ((!this.zzang.isEmpty()) && (paramzzie.getPosition() >= zzjc.zza((zzjc)this.zzang.peek())))
      {
        this.zzani.zzy(zzjc.zzb((zzjc)this.zzang.pop()));
        return true;
        bool = false;
        break;
      }
      if (this.zzanj == 0)
      {
        long l7 = this.zzanh.zza(paramzzie, true, false);
        if (l7 == -1L)
          return false;
        this.zzank = ((int)l7);
        this.zzanj = 1;
      }
      if (this.zzanj == 1)
      {
        this.zzanl = this.zzanh.zza(paramzzie, false, true);
        this.zzanj = 2;
      }
      int i = this.zzani.zzx(this.zzank);
      switch (i)
      {
      default:
        throw new IllegalStateException(32 + "Invalid element type " + i);
      case 1:
        long l5 = paramzzie.getPosition();
        long l6 = l5 + this.zzanl;
        this.zzang.add(new zzjc(this.zzank, l6, null));
        this.zzani.zzb(this.zzank, l5, this.zzanl);
        this.zzanj = 0;
        return true;
      case 2:
        if (this.zzanl > 8L)
        {
          long l4 = this.zzanl;
          throw new IllegalStateException(42 + "Invalid integer size: " + l4);
        }
        this.zzani.zzc(this.zzank, zzc(paramzzie, (int)this.zzanl));
        this.zzanj = 0;
        return true;
      case 5:
        if ((this.zzanl != 4L) && (this.zzanl != 8L))
        {
          long l3 = this.zzanl;
          throw new IllegalStateException(40 + "Invalid float size: " + l3);
        }
        zzje localzzje2 = this.zzani;
        int m = this.zzank;
        int n = (int)this.zzanl;
        long l2 = zzc(paramzzie, n);
        if (n == 4);
        for (double d = Float.intBitsToFloat((int)l2); ; d = Double.longBitsToDouble(l2))
        {
          localzzje2.zza(m, d);
          this.zzanj = 0;
          return true;
        }
      case 3:
        if (this.zzanl > 2147483647L)
        {
          long l1 = this.zzanl;
          throw new IllegalStateException(41 + "String element size: " + l1);
        }
        zzje localzzje1 = this.zzani;
        int j = this.zzank;
        int k = (int)this.zzanl;
        byte[] arrayOfByte = new byte[k];
        paramzzie.readFully(arrayOfByte, 0, k);
        localzzje1.zza(j, new String(arrayOfByte, Charset.forName("UTF-8")));
        this.zzanj = 0;
        return true;
      case 4:
        this.zzani.zza(this.zzank, (int)this.zzanl, paramzzie);
        this.zzanj = 0;
        return true;
      case 0:
      }
      paramzzie.zzr((int)this.zzanl);
      this.zzanj = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzja
 * JD-Core Version:    0.6.2
 */