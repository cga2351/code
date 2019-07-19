package com.google.android.gms.internal.wearable;

import java.io.IOException;
import java.util.Arrays;

public final class zzj extends zzn<zzj>
{
  public byte[] zzgd = zzw.zzhy;
  public String zzge = "";
  public double zzgf = 0.0D;
  public float zzgg = 0.0F;
  public long zzgh = 0L;
  public int zzgi = 0;
  public int zzgj = 0;
  public boolean zzgk = false;
  public zzh[] zzgl = zzh.zzh();
  public zzi[] zzgm = zzi.zzi();
  public String[] zzgn = zzw.zzhw;
  public long[] zzgo = zzw.zzhs;
  public float[] zzgp = zzw.zzht;
  public long zzgq = 0L;

  public zzj()
  {
    this.zzhc = null;
    this.zzhl = -1;
  }

  public final boolean equals(Object paramObject)
  {
    if (paramObject == this);
    zzj localzzj;
    do
    {
      return true;
      if (!(paramObject instanceof zzj))
        return false;
      localzzj = (zzj)paramObject;
      if (!Arrays.equals(this.zzgd, localzzj.zzgd))
        return false;
      if (this.zzge == null)
      {
        if (localzzj.zzge != null)
          return false;
      }
      else if (!this.zzge.equals(localzzj.zzge))
        return false;
      if (Double.doubleToLongBits(this.zzgf) != Double.doubleToLongBits(localzzj.zzgf))
        return false;
      if (Float.floatToIntBits(this.zzgg) != Float.floatToIntBits(localzzj.zzgg))
        return false;
      if (this.zzgh != localzzj.zzgh)
        return false;
      if (this.zzgi != localzzj.zzgi)
        return false;
      if (this.zzgj != localzzj.zzgj)
        return false;
      if (this.zzgk != localzzj.zzgk)
        return false;
      if (!zzr.equals(this.zzgl, localzzj.zzgl))
        return false;
      if (!zzr.equals(this.zzgm, localzzj.zzgm))
        return false;
      if (!zzr.equals(this.zzgn, localzzj.zzgn))
        return false;
      if (!zzr.equals(this.zzgo, localzzj.zzgo))
        return false;
      if (!zzr.equals(this.zzgp, localzzj.zzgp))
        return false;
      if (this.zzgq != localzzj.zzgq)
        return false;
      if ((this.zzhc != null) && (!this.zzhc.isEmpty()))
        break;
    }
    while ((localzzj.zzhc == null) || (localzzj.zzhc.isEmpty()));
    return false;
    return this.zzhc.equals(localzzj.zzhc);
  }

  public final int hashCode()
  {
    int i = 31 * (31 * (527 + getClass().getName().hashCode()) + Arrays.hashCode(this.zzgd));
    int j;
    int n;
    label126: int i1;
    int i2;
    if (this.zzge == null)
    {
      j = 0;
      int k = j + i;
      long l = Double.doubleToLongBits(this.zzgf);
      int m = 31 * (31 * (31 * (31 * (31 * (k * 31 + (int)(l ^ l >>> 32)) + Float.floatToIntBits(this.zzgg)) + (int)(this.zzgh ^ this.zzgh >>> 32)) + this.zzgi) + this.zzgj);
      if (!this.zzgk)
        break label256;
      n = 1231;
      i1 = 31 * (31 * (31 * (31 * (31 * (31 * (31 * (n + m) + zzr.hashCode(this.zzgl)) + zzr.hashCode(this.zzgm)) + zzr.hashCode(this.zzgn)) + zzr.hashCode(this.zzgo)) + zzr.hashCode(this.zzgp)) + (int)(this.zzgq ^ this.zzgq >>> 32));
      zzp localzzp = this.zzhc;
      i2 = 0;
      if (localzzp != null)
      {
        boolean bool = this.zzhc.isEmpty();
        i2 = 0;
        if (!bool)
          break label264;
      }
    }
    while (true)
    {
      return i1 + i2;
      j = this.zzge.hashCode();
      break;
      label256: n = 1237;
      break label126;
      label264: i2 = this.zzhc.hashCode();
    }
  }

  public final void zza(zzl paramzzl)
    throws IOException
  {
    int i = 1;
    if (!Arrays.equals(this.zzgd, zzw.zzhy))
    {
      byte[] arrayOfByte = this.zzgd;
      paramzzl.zzf(i, 2);
      paramzzl.zzl(arrayOfByte.length);
      paramzzl.zzc(arrayOfByte);
    }
    if ((this.zzge != null) && (!this.zzge.equals("")))
      paramzzl.zza(2, this.zzge);
    if (Double.doubleToLongBits(this.zzgf) != Double.doubleToLongBits(0.0D))
    {
      double d = this.zzgf;
      paramzzl.zzf(3, i);
      paramzzl.zzb(Double.doubleToLongBits(d));
    }
    if (Float.floatToIntBits(this.zzgg) != Float.floatToIntBits(0.0F))
      paramzzl.zza(4, this.zzgg);
    if (this.zzgh != 0L)
      paramzzl.zza(5, this.zzgh);
    if (this.zzgi != 0)
      paramzzl.zzd(6, this.zzgi);
    if (this.zzgj != 0)
    {
      int i3 = this.zzgj;
      paramzzl.zzf(7, 0);
      paramzzl.zzl(zzl.zzn(i3));
    }
    if (this.zzgk)
    {
      boolean bool = this.zzgk;
      paramzzl.zzf(8, 0);
      if (!bool)
        break label278;
    }
    while (true)
    {
      paramzzl.zza((byte)i);
      if ((this.zzgl == null) || (this.zzgl.length <= 0))
        break;
      for (int i2 = 0; i2 < this.zzgl.length; i2++)
      {
        zzh localzzh = this.zzgl[i2];
        if (localzzh != null)
          paramzzl.zza(9, localzzh);
      }
      label278: i = 0;
    }
    if ((this.zzgm != null) && (this.zzgm.length > 0))
      for (int i1 = 0; i1 < this.zzgm.length; i1++)
      {
        zzi localzzi = this.zzgm[i1];
        if (localzzi != null)
          paramzzl.zza(10, localzzi);
      }
    if ((this.zzgn != null) && (this.zzgn.length > 0))
      for (int n = 0; n < this.zzgn.length; n++)
      {
        String str = this.zzgn[n];
        if (str != null)
          paramzzl.zza(11, str);
      }
    if ((this.zzgo != null) && (this.zzgo.length > 0))
      for (int m = 0; m < this.zzgo.length; m++)
        paramzzl.zza(12, this.zzgo[m]);
    if (this.zzgq != 0L)
      paramzzl.zza(13, this.zzgq);
    if (this.zzgp != null)
    {
      int j = this.zzgp.length;
      int k = 0;
      if (j > 0)
        while (k < this.zzgp.length)
        {
          paramzzl.zza(14, this.zzgp[k]);
          k++;
        }
    }
    super.zza(paramzzl);
  }

  protected final int zzg()
  {
    int i = 0;
    int j = super.zzg();
    if (!Arrays.equals(this.zzgd, zzw.zzhy))
    {
      byte[] arrayOfByte = this.zzgd;
      j += zzl.zzk(1) + (zzl.zzm(arrayOfByte.length) + arrayOfByte.length);
    }
    if ((this.zzge != null) && (!this.zzge.equals("")))
      j += zzl.zzb(2, this.zzge);
    if (Double.doubleToLongBits(this.zzgf) != Double.doubleToLongBits(0.0D))
      j += 8 + zzl.zzk(3);
    if (Float.floatToIntBits(this.zzgg) != Float.floatToIntBits(0.0F))
      j += 4 + zzl.zzk(4);
    if (this.zzgh != 0L)
      j += zzl.zzb(5, this.zzgh);
    if (this.zzgi != 0)
      j += zzl.zze(6, this.zzgi);
    if (this.zzgj != 0)
    {
      int i7 = this.zzgj;
      j += zzl.zzk(7) + zzl.zzm(zzl.zzn(i7));
    }
    if (this.zzgk)
      j += 1 + zzl.zzk(8);
    if ((this.zzgl != null) && (this.zzgl.length > 0))
    {
      int i5 = j;
      for (int i6 = 0; i6 < this.zzgl.length; i6++)
      {
        zzh localzzh = this.zzgl[i6];
        if (localzzh != null)
          i5 += zzl.zzb(9, localzzh);
      }
      j = i5;
    }
    if ((this.zzgm != null) && (this.zzgm.length > 0))
    {
      int i3 = j;
      for (int i4 = 0; i4 < this.zzgm.length; i4++)
      {
        zzi localzzi = this.zzgm[i4];
        if (localzzi != null)
          i3 += zzl.zzb(10, localzzi);
      }
      j = i3;
    }
    if ((this.zzgn != null) && (this.zzgn.length > 0))
    {
      int n = 0;
      int i1 = 0;
      int i2 = 0;
      while (n < this.zzgn.length)
      {
        String str = this.zzgn[n];
        if (str != null)
        {
          i2++;
          i1 += zzl.zzg(str);
        }
        n++;
      }
      j = j + i1 + i2 * 1;
    }
    if ((this.zzgo != null) && (this.zzgo.length > 0))
    {
      int k = 0;
      if (i < this.zzgo.length)
      {
        long l = this.zzgo[i];
        int m;
        if ((0xFFFFFF80 & l) == 0L)
          m = 1;
        while (true)
        {
          k += m;
          i++;
          break;
          if ((0xFFFFC000 & l) == 0L)
            m = 2;
          else if ((0xFFE00000 & l) == 0L)
            m = 3;
          else if ((0xF0000000 & l) == 0L)
            m = 4;
          else if ((0x0 & l) == 0L)
            m = 5;
          else if ((0x0 & l) == 0L)
            m = 6;
          else if ((0x0 & l) == 0L)
            m = 7;
          else if ((0x0 & l) == 0L)
            m = 8;
          else if ((l & 0x0) == 0L)
            m = 9;
          else
            m = 10;
        }
      }
      j = j + k + 1 * this.zzgo.length;
    }
    if (this.zzgq != 0L)
      j += zzl.zzb(13, this.zzgq);
    if ((this.zzgp != null) && (this.zzgp.length > 0))
      j = j + 4 * this.zzgp.length + 1 * this.zzgp.length;
    return j;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.wearable.zzj
 * JD-Core Version:    0.6.2
 */