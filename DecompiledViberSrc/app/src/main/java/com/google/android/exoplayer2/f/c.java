package com.google.android.exoplayer2.f;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public final class c extends e
{
  private final AssetManager a;
  private Uri b;
  private InputStream c;
  private long d;
  private boolean e;

  public c(Context paramContext)
  {
    super(false);
    this.a = paramContext.getAssets();
  }

  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws c.a
  {
    int i = -1;
    if (paramInt2 == 0)
      i = 0;
    int j;
    while (true)
    {
      return i;
      if (this.d != 0L)
        try
        {
          if (this.d == -1L);
          while (true)
          {
            j = this.c.read(paramArrayOfByte, paramInt1, paramInt2);
            if (j != i)
              break label108;
            if (this.d == -1L)
              break;
            throw new a(new EOFException());
            long l = Math.min(this.d, paramInt2);
            paramInt2 = (int)l;
          }
        }
        catch (IOException localIOException)
        {
          throw new a(localIOException);
        }
    }
    label108: if (this.d != -1L)
      this.d -= j;
    a(j);
    return j;
  }

  public long a(l paraml)
    throws c.a
  {
    while (true)
    {
      String str;
      try
      {
        this.b = paraml.a;
        str = this.b.getPath();
        if (str.startsWith("/android_asset/"))
        {
          str = str.substring(15);
          b(paraml);
          this.c = this.a.open(str, 1);
          if (this.c.skip(paraml.f) >= paraml.f)
            break;
          throw new EOFException();
        }
      }
      catch (IOException localIOException)
      {
        throw new a(localIOException);
      }
      if (str.startsWith("/"))
        str = str.substring(1);
    }
    if (paraml.g != -1L)
      this.d = paraml.g;
    while (true)
    {
      this.e = true;
      c(paraml);
      return this.d;
      this.d = this.c.available();
      if (this.d == 2147483647L)
        this.d = -1L;
    }
  }

  public Uri a()
  {
    return this.b;
  }

  public void c()
    throws c.a
  {
    this.b = null;
    try
    {
      if (this.c != null)
        this.c.close();
      return;
    }
    catch (IOException localIOException)
    {
      throw new a(localIOException);
    }
    finally
    {
      this.c = null;
      if (this.e)
      {
        this.e = false;
        d();
      }
    }
  }

  public static final class a extends IOException
  {
    public a(IOException paramIOException)
    {
      super();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.f.c
 * JD-Core Version:    0.6.2
 */