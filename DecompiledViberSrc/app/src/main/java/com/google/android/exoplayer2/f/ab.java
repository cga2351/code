package com.google.android.exoplayer2.f;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class ab extends e
{
  private final Resources a;
  private Uri b;
  private AssetFileDescriptor c;
  private InputStream d;
  private long e;
  private boolean f;

  public ab(Context paramContext)
  {
    super(false);
    this.a = paramContext.getResources();
  }

  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws ab.a
  {
    int i = -1;
    if (paramInt2 == 0)
      i = 0;
    int j;
    while (true)
    {
      return i;
      if (this.e != 0L)
        try
        {
          if (this.e == -1L);
          while (true)
          {
            j = this.d.read(paramArrayOfByte, paramInt1, paramInt2);
            if (j != i)
              break label108;
            if (this.e == -1L)
              break;
            throw new a(new EOFException());
            long l = Math.min(this.e, paramInt2);
            paramInt2 = (int)l;
          }
        }
        catch (IOException localIOException)
        {
          throw new a(localIOException);
        }
    }
    label108: if (this.e != -1L)
      this.e -= j;
    a(j);
    return j;
  }

  public long a(l paraml)
    throws ab.a
  {
    long l1 = -1L;
    try
    {
      this.b = paraml.a;
      if (!TextUtils.equals("rawresource", this.b.getScheme()))
        throw new a("URI must use scheme rawresource");
    }
    catch (IOException localIOException)
    {
      throw new a(localIOException);
    }
    try
    {
      int i = Integer.parseInt(this.b.getLastPathSegment());
      b(paraml);
      this.c = this.a.openRawResourceFd(i);
      this.d = new FileInputStream(this.c.getFileDescriptor());
      this.d.skip(this.c.getStartOffset());
      if (this.d.skip(paraml.f) < paraml.f)
        throw new EOFException();
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw new a("Resource identifier must be an integer.");
    }
    if (paraml.g != l1)
    {
      this.e = paraml.g;
      this.f = true;
      c(paraml);
      return this.e;
    }
    long l2 = this.c.getLength();
    if (l2 == l1);
    while (true)
    {
      this.e = l1;
      break;
      long l3 = paraml.f;
      l1 = l2 - l3;
    }
  }

  public Uri a()
  {
    return this.b;
  }

  public void c()
    throws ab.a
  {
    this.b = null;
    try
    {
      if (this.d != null)
        this.d.close();
      this.d = null;
      try
      {
        if (this.c != null)
          this.c.close();
        return;
      }
      catch (IOException localIOException3)
      {
        throw new a(localIOException3);
      }
      finally
      {
        this.c = null;
        if (this.f)
        {
          this.f = false;
          d();
        }
      }
    }
    catch (IOException localIOException2)
    {
      throw new a(localIOException2);
    }
    finally
    {
      this.d = null;
      try
      {
        if (this.c != null)
          this.c.close();
        throw localObject1;
      }
      catch (IOException localIOException1)
      {
        throw new a(localIOException1);
      }
      finally
      {
        this.c = null;
        if (this.f)
        {
          this.f = false;
          d();
        }
      }
    }
  }

  public static class a extends IOException
  {
    public a(IOException paramIOException)
    {
      super();
    }

    public a(String paramString)
    {
      super();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.f.ab
 * JD-Core Version:    0.6.2
 */