package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class zzar
{
  private final int zzcf;
  private final List<zzl> zzcg;
  private final int zzch;
  private final InputStream zzci;

  public zzar(int paramInt, List<zzl> paramList)
  {
    this(paramInt, paramList, -1, null);
  }

  public zzar(int paramInt1, List<zzl> paramList, int paramInt2, InputStream paramInputStream)
  {
    this.zzcf = paramInt1;
    this.zzcg = paramList;
    this.zzch = paramInt2;
    this.zzci = paramInputStream;
  }

  public final InputStream getContent()
  {
    return this.zzci;
  }

  public final int getContentLength()
  {
    return this.zzch;
  }

  public final int getStatusCode()
  {
    return this.zzcf;
  }

  public final List<zzl> zzq()
  {
    return Collections.unmodifiableList(this.zzcg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzar
 * JD-Core Version:    0.6.2
 */