package com.google.android.gms.internal.ads;

import java.io.IOException;

public class zzjx extends IOException
{
  private final zzjq zzapt;

  public zzjx(IOException paramIOException, zzjq paramzzjq)
  {
    super(paramIOException);
    this.zzapt = paramzzjq;
  }

  public zzjx(String paramString, zzjq paramzzjq)
  {
    super(paramString);
    this.zzapt = paramzzjq;
  }

  public zzjx(String paramString, IOException paramIOException, zzjq paramzzjq)
  {
    super(paramString, paramIOException);
    this.zzapt = paramzzjq;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzjx
 * JD-Core Version:    0.6.2
 */