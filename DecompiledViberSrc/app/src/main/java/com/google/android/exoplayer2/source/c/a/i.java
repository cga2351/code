package com.google.android.exoplayer2.source.c.a;

import android.net.Uri;
import com.google.android.exoplayer2.f.y;
import com.google.android.exoplayer2.source.o.a;
import java.io.IOException;

public abstract interface i
{
  public abstract e a(d.a parama, boolean paramBoolean);

  public abstract void a();

  public abstract void a(Uri paramUri, o.a parama, e parame);

  public abstract void a(b paramb);

  public abstract boolean a(d.a parama);

  public abstract d b();

  public abstract void b(d.a parama)
    throws IOException;

  public abstract void b(b paramb);

  public abstract long c();

  public abstract void c(d.a parama);

  public abstract void d()
    throws IOException;

  public abstract boolean e();

  public static abstract interface a
  {
    public abstract i a(com.google.android.exoplayer2.source.c.e parame, y paramy, h paramh);
  }

  public static abstract interface b
  {
    public abstract boolean a(d.a parama, long paramLong);

    public abstract void h();
  }

  public static final class c extends IOException
  {
    public final String a;

    public c(String paramString)
    {
      this.a = paramString;
    }
  }

  public static final class d extends IOException
  {
    public final String a;

    public d(String paramString)
    {
      this.a = paramString;
    }
  }

  public static abstract interface e
  {
    public abstract void a(e parame);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.source.c.a.i
 * JD-Core Version:    0.6.2
 */