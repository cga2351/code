package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Stack;

final class zzny
  implements zzob
{
  private final byte[] zzanf = new byte[8];
  private final Stack<zzoa> zzang = new Stack();
  private int zzanj;
  private int zzank;
  private long zzanl;
  private final zzoi zzazr = new zzoi();
  private zzoc zzazs;

  private final long zza(zzno paramzzno, int paramInt)
    throws IOException, InterruptedException
  {
    int i = 0;
    paramzzno.readFully(this.zzanf, 0, paramInt);
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
    this.zzazr.reset();
  }

  public final void zza(zzoc paramzzoc)
  {
    this.zzazs = paramzzoc;
  }

  public final boolean zzb(zzno paramzzno)
    throws IOException, InterruptedException
  {
    boolean bool;
    if (this.zzazs != null)
    {
      bool = true;
      zzsk.checkState(bool);
    }
    while (true)
    {
      if ((!this.zzang.isEmpty()) && (paramzzno.getPosition() >= zzoa.zza((zzoa)this.zzang.peek())))
      {
        this.zzazs.zzy(zzoa.zzb((zzoa)this.zzang.pop()));
        return true;
        bool = false;
        break;
      }
      if (this.zzanj == 0)
      {
        long l7 = this.zzazr.zza(paramzzno, true, false, 4);
        if (l7 == -2L)
          paramzzno.zzig();
        while (true)
        {
          paramzzno.zzc(this.zzanf, 0, 4);
          int i1 = zzoi.zzaw(this.zzanf[0]);
          if ((i1 != -1) && (i1 <= 4))
          {
            int i2 = (int)zzoi.zza(this.zzanf, i1, false);
            if (this.zzazs.zzav(i2))
            {
              paramzzno.zzr(i1);
              l7 = i2;
              if (l7 != -1L)
                break;
              return false;
            }
          }
          paramzzno.zzr(1);
        }
        this.zzank = ((int)l7);
        this.zzanj = 1;
      }
      if (this.zzanj == 1)
      {
        this.zzanl = this.zzazr.zza(paramzzno, false, true, 8);
        this.zzanj = 2;
      }
      int i = this.zzazs.zzx(this.zzank);
      switch (i)
      {
      default:
        throw new zzlm(32 + "Invalid element type " + i);
      case 1:
        long l5 = paramzzno.getPosition();
        long l6 = l5 + this.zzanl;
        this.zzang.add(new zzoa(this.zzank, l6, null));
        this.zzazs.zzb(this.zzank, l5, this.zzanl);
        this.zzanj = 0;
        return true;
      case 2:
        if (this.zzanl > 8L)
        {
          long l4 = this.zzanl;
          throw new zzlm(42 + "Invalid integer size: " + l4);
        }
        this.zzazs.zzc(this.zzank, zza(paramzzno, (int)this.zzanl));
        this.zzanj = 0;
        return true;
      case 5:
        if ((this.zzanl != 4L) && (this.zzanl != 8L))
        {
          long l3 = this.zzanl;
          throw new zzlm(40 + "Invalid float size: " + l3);
        }
        zzoc localzzoc2 = this.zzazs;
        int m = this.zzank;
        int n = (int)this.zzanl;
        long l2 = zza(paramzzno, n);
        if (n == 4);
        for (double d = Float.intBitsToFloat((int)l2); ; d = Double.longBitsToDouble(l2))
        {
          localzzoc2.zza(m, d);
          this.zzanj = 0;
          return true;
        }
      case 3:
        if (this.zzanl > 2147483647L)
        {
          long l1 = this.zzanl;
          throw new zzlm(41 + "String element size: " + l1);
        }
        zzoc localzzoc1 = this.zzazs;
        int j = this.zzank;
        int k = (int)this.zzanl;
        if (k == 0);
        byte[] arrayOfByte;
        for (String str = ""; ; str = new String(arrayOfByte))
        {
          localzzoc1.zza(j, str);
          this.zzanj = 0;
          return true;
          arrayOfByte = new byte[k];
          paramzzno.readFully(arrayOfByte, 0, k);
        }
      case 4:
        this.zzazs.zza(this.zzank, (int)this.zzanl, paramzzno);
        this.zzanj = 0;
        return true;
      case 0:
      }
      paramzzno.zzr((int)this.zzanl);
      this.zzanj = 0;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzny
 * JD-Core Version:    0.6.2
 */