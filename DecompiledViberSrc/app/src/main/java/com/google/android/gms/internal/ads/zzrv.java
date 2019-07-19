package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

public abstract interface zzrv
{
  public abstract void close()
    throws IOException;

  public abstract Uri getUri();

  public abstract int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;

  public abstract long zza(zzry paramzzry)
    throws IOException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzrv
 * JD-Core Version:    0.6.2
 */