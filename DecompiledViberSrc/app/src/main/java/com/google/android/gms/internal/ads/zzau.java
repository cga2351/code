package com.google.android.gms.internal.ads;

import java.io.FilterInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;

final class zzau extends FilterInputStream
{
  private final HttpURLConnection zzcl;

  zzau(HttpURLConnection paramHttpURLConnection)
  {
    super(zzat.zzb(paramHttpURLConnection));
    this.zzcl = paramHttpURLConnection;
  }

  public final void close()
    throws IOException
  {
    super.close();
    this.zzcl.disconnect();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzau
 * JD-Core Version:    0.6.2
 */