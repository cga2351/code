package com.google.android.exoplayer2.f;

import android.net.Uri;
import com.google.android.exoplayer2.g.a;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class ac
  implements h
{
  private final h a;
  private long b;
  private Uri c;
  private Map<String, List<String>> d;

  public ac(h paramh)
  {
    this.a = ((h)a.a(paramh));
    this.c = Uri.EMPTY;
    this.d = Collections.emptyMap();
  }

  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = this.a.a(paramArrayOfByte, paramInt1, paramInt2);
    if (i != -1)
      this.b += i;
    return i;
  }

  public long a(l paraml)
    throws IOException
  {
    this.c = paraml.a;
    this.d = Collections.emptyMap();
    long l = this.a.a(paraml);
    this.c = ((Uri)a.a(a()));
    this.d = b();
    return l;
  }

  public Uri a()
  {
    return this.a.a();
  }

  public void a(ad paramad)
  {
    this.a.a(paramad);
  }

  public Map<String, List<String>> b()
  {
    return this.a.b();
  }

  public void c()
    throws IOException
  {
    this.a.c();
  }

  public void d()
  {
    this.b = 0L;
  }

  public long e()
  {
    return this.b;
  }

  public Uri f()
  {
    return this.c;
  }

  public Map<String, List<String>> g()
  {
    return this.d;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.f.ac
 * JD-Core Version:    0.6.2
 */