package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Arrays;

public final class zzry
{
  public final int flags;
  public final Uri uri;
  public final long zzahv;
  public final long zzapg;
  public final byte[] zzbmd;
  public final String zzcc;
  public final long zzcd;

  public zzry(Uri paramUri)
  {
    this(paramUri, 0);
  }

  private zzry(Uri paramUri, int paramInt)
  {
    this(paramUri, 0L, -1L, null, 0);
  }

  private zzry(Uri paramUri, long paramLong1, long paramLong2, long paramLong3, String paramString, int paramInt)
  {
    this(paramUri, null, paramLong1, paramLong2, paramLong3, paramString, paramInt);
  }

  public zzry(Uri paramUri, long paramLong1, long paramLong2, String paramString)
  {
    this(paramUri, paramLong1, paramLong1, paramLong2, paramString, 0);
  }

  private zzry(Uri paramUri, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    this(paramUri, 0L, 0L, -1L, null, 0);
  }

  public zzry(Uri paramUri, byte[] paramArrayOfByte, long paramLong1, long paramLong2, long paramLong3, String paramString, int paramInt)
  {
    boolean bool1;
    boolean bool2;
    if (paramLong1 >= 0L)
    {
      bool1 = true;
      zzsk.checkArgument(bool1);
      if (paramLong2 < 0L)
        break label103;
      bool2 = true;
      label28: zzsk.checkArgument(bool2);
      if ((paramLong3 <= 0L) && (paramLong3 != -1L))
        break label109;
    }
    label103: label109: for (boolean bool3 = true; ; bool3 = false)
    {
      zzsk.checkArgument(bool3);
      this.uri = paramUri;
      this.zzbmd = paramArrayOfByte;
      this.zzapg = paramLong1;
      this.zzahv = paramLong2;
      this.zzcd = paramLong3;
      this.zzcc = paramString;
      this.flags = paramInt;
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label28;
    }
  }

  public final String toString()
  {
    String str1 = String.valueOf(this.uri);
    String str2 = Arrays.toString(this.zzbmd);
    long l1 = this.zzapg;
    long l2 = this.zzahv;
    long l3 = this.zzcd;
    String str3 = this.zzcc;
    int i = this.flags;
    return 93 + String.valueOf(str1).length() + String.valueOf(str2).length() + String.valueOf(str3).length() + "DataSpec[" + str1 + ", " + str2 + ", " + l1 + ", " + l2 + ", " + l3 + ", " + str3 + ", " + i + "]";
  }

  public final boolean zzbk(int paramInt)
  {
    return (0x1 & this.flags) == 1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzry
 * JD-Core Version:    0.6.2
 */