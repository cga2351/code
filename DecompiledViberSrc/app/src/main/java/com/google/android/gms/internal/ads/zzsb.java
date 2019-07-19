package com.google.android.gms.internal.ads;

import java.io.IOException;

public class zzsb extends IOException
{
  private final int type;
  private final zzry zzbmo;

  public zzsb(IOException paramIOException, zzry paramzzry, int paramInt)
  {
    super(paramIOException);
    this.zzbmo = paramzzry;
    this.type = paramInt;
  }

  public zzsb(String paramString, zzry paramzzry, int paramInt)
  {
    super(paramString);
    this.zzbmo = paramzzry;
    this.type = 1;
  }

  public zzsb(String paramString, IOException paramIOException, zzry paramzzry, int paramInt)
  {
    super(paramString, paramIOException);
    this.zzbmo = paramzzry;
    this.type = 1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzsb
 * JD-Core Version:    0.6.2
 */