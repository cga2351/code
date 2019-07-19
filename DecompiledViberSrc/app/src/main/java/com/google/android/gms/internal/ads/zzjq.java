package com.google.android.gms.internal.ads;

import android.net.Uri;

public final class zzjq
{
  public final int flags;
  public final Uri uri;
  public final long zzahv;
  public final long zzapg;
  public final String zzcc;
  public final long zzcd;

  public zzjq(Uri paramUri)
  {
    this(paramUri, 0);
  }

  private zzjq(Uri paramUri, int paramInt)
  {
    this(paramUri, 0L, -1L, null, 0);
  }

  public zzjq(Uri paramUri, long paramLong1, long paramLong2, long paramLong3, String paramString, int paramInt)
  {
    boolean bool1;
    if (paramLong1 >= 0L)
    {
      bool1 = true;
      zzkh.checkArgument(bool1);
      if (paramLong2 < 0L)
        break label105;
    }
    label105: for (boolean bool2 = true; ; bool2 = false)
    {
      zzkh.checkArgument(bool2);
      boolean bool3;
      if (paramLong3 <= 0L)
      {
        boolean bool4 = paramLong3 < -1L;
        bool3 = false;
        if (bool4);
      }
      else
      {
        bool3 = true;
      }
      zzkh.checkArgument(bool3);
      this.uri = paramUri;
      this.zzapg = paramLong1;
      this.zzahv = paramLong2;
      this.zzcd = paramLong3;
      this.zzcc = paramString;
      this.flags = paramInt;
      return;
      bool1 = false;
      break;
    }
  }

  public zzjq(Uri paramUri, long paramLong1, long paramLong2, String paramString)
  {
    this(paramUri, paramLong1, paramLong1, paramLong2, null, 0);
  }

  private zzjq(Uri paramUri, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    this(paramUri, 0L, 0L, -1L, null, 0);
  }

  public final String toString()
  {
    String str1 = String.valueOf(this.uri);
    long l1 = this.zzapg;
    long l2 = this.zzahv;
    long l3 = this.zzcd;
    String str2 = this.zzcc;
    int i = this.flags;
    return 91 + String.valueOf(str1).length() + String.valueOf(str2).length() + "DataSpec[" + str1 + ", " + l1 + ", " + l2 + ", " + l3 + ", " + str2 + ", " + i + "]";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzjq
 * JD-Core Version:    0.6.2
 */