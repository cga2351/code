package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

final class zzwe extends PushbackInputStream
{
  zzwe(zzwb paramzzwb, InputStream paramInputStream, int paramInt)
  {
    super(paramInputStream, 1);
  }

  public final void close()
    throws IOException
  {
    try
    {
      zzvz.zza(this.zzbxk.zzbxb);
      super.close();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzwe
 * JD-Core Version:    0.6.2
 */