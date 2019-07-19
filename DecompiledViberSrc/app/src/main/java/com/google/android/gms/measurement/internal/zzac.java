package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

final class zzac
{
  final String name;
  final long zzahv;
  final long zzahw;
  final long zzahx;
  final long zzahy;
  final Long zzahz;
  final Long zzaia;
  final Long zzaib;
  final Boolean zzaic;
  final String zztt;

  zzac(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, Long paramLong5, Long paramLong6, Long paramLong7, Boolean paramBoolean)
  {
    Preconditions.checkNotEmpty(paramString1);
    Preconditions.checkNotEmpty(paramString2);
    boolean bool1;
    boolean bool2;
    if (paramLong1 >= 0L)
    {
      bool1 = true;
      Preconditions.checkArgument(bool1);
      if (paramLong2 < 0L)
        break label122;
      bool2 = true;
      label38: Preconditions.checkArgument(bool2);
      if (paramLong4 < 0L)
        break label128;
    }
    label128: for (boolean bool3 = true; ; bool3 = false)
    {
      Preconditions.checkArgument(bool3);
      this.zztt = paramString1;
      this.name = paramString2;
      this.zzahv = paramLong1;
      this.zzahw = paramLong2;
      this.zzahx = paramLong3;
      this.zzahy = paramLong4;
      this.zzahz = paramLong5;
      this.zzaia = paramLong6;
      this.zzaib = paramLong7;
      this.zzaic = paramBoolean;
      return;
      bool1 = false;
      break;
      label122: bool2 = false;
      break label38;
    }
  }

  final zzac zza(long paramLong1, long paramLong2)
  {
    return new zzac(this.zztt, this.name, this.zzahv, this.zzahw, this.zzahx, paramLong1, Long.valueOf(paramLong2), this.zzaia, this.zzaib, this.zzaic);
  }

  final zzac zza(Long paramLong1, Long paramLong2, Boolean paramBoolean)
  {
    if ((paramBoolean != null) && (!paramBoolean.booleanValue()));
    for (Boolean localBoolean = null; ; localBoolean = paramBoolean)
      return new zzac(this.zztt, this.name, this.zzahv, this.zzahw, this.zzahx, this.zzahy, this.zzahz, paramLong1, paramLong2, localBoolean);
  }

  final zzac zzae(long paramLong)
  {
    return new zzac(this.zztt, this.name, this.zzahv, this.zzahw, paramLong, this.zzahy, this.zzahz, this.zzaia, this.zzaib, this.zzaic);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzac
 * JD-Core Version:    0.6.2
 */