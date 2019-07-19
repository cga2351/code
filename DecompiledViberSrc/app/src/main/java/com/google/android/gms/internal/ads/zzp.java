package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class zzp
{
  public final List<zzl> allHeaders;
  public final byte[] data;
  public final int statusCode;
  public final Map<String, String> zzab;
  public final boolean zzac;
  private final long zzad;

  private zzp(int paramInt, byte[] paramArrayOfByte, Map<String, String> paramMap, List<zzl> paramList, boolean paramBoolean, long paramLong)
  {
    this.statusCode = paramInt;
    this.data = paramArrayOfByte;
    this.zzab = paramMap;
    if (paramList == null);
    for (this.allHeaders = null; ; this.allHeaders = Collections.unmodifiableList(paramList))
    {
      this.zzac = paramBoolean;
      this.zzad = paramLong;
      return;
    }
  }

  @Deprecated
  public zzp(int paramInt, byte[] paramArrayOfByte, Map<String, String> paramMap, boolean paramBoolean, long paramLong)
  {
  }

  public zzp(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean, long paramLong, List<zzl> paramList)
  {
  }

  @Deprecated
  public zzp(byte[] paramArrayOfByte, Map<String, String> paramMap)
  {
    this(200, paramArrayOfByte, paramMap, false, 0L);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzp
 * JD-Core Version:    0.6.2
 */