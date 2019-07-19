package com.google.android.exoplayer2.f;

import android.net.Uri;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public abstract interface h
{
  public abstract int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;

  public abstract long a(l paraml)
    throws IOException;

  public abstract Uri a();

  public abstract void a(ad paramad);

  public abstract Map<String, List<String>> b();

  public abstract void c()
    throws IOException;

  public static abstract interface a
  {
    public abstract h a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.f.h
 * JD-Core Version:    0.6.2
 */