package com.google.android.exoplayer2.f;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class u extends e
{
  private RandomAccessFile a;
  private Uri b;
  private long c;
  private boolean d;

  public u()
  {
    super(false);
  }

  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws u.a
  {
    int j;
    if (paramInt2 == 0)
      j = 0;
    while (true)
    {
      return j;
      if (this.c == 0L)
        return -1;
      try
      {
        int i = this.a.read(paramArrayOfByte, paramInt1, (int)Math.min(this.c, paramInt2));
        j = i;
        if (j <= 0)
          continue;
        this.c -= j;
        a(j);
        return j;
      }
      catch (IOException localIOException)
      {
        throw new a(localIOException);
      }
    }
  }

  public long a(l paraml)
    throws u.a
  {
    while (true)
    {
      try
      {
        this.b = paraml.a;
        b(paraml);
        this.a = new RandomAccessFile(paraml.a.getPath(), "r");
        this.a.seek(paraml.f);
        if (paraml.g == -1L)
        {
          l = this.a.length() - paraml.f;
          this.c = l;
          if (this.c >= 0L)
            break;
          throw new EOFException();
        }
      }
      catch (IOException localIOException)
      {
        throw new a(localIOException);
      }
      long l = paraml.g;
    }
    this.d = true;
    c(paraml);
    return this.c;
  }

  public Uri a()
  {
    return this.b;
  }

  public void c()
    throws u.a
  {
    this.b = null;
    try
    {
      if (this.a != null)
        this.a.close();
      return;
    }
    catch (IOException localIOException)
    {
      throw new a(localIOException);
    }
    finally
    {
      this.a = null;
      if (this.d)
      {
        this.d = false;
        d();
      }
    }
  }

  public static class a extends IOException
  {
    public a(IOException paramIOException)
    {
      super();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.f.u
 * JD-Core Version:    0.6.2
 */