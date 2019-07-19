package com.google.android.exoplayer2.f;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

public final class f extends e
{
  private final ContentResolver a;
  private Uri b;
  private AssetFileDescriptor c;
  private FileInputStream d;
  private long e;
  private boolean f;

  public f(Context paramContext)
  {
    super(false);
    this.a = paramContext.getContentResolver();
  }

  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws f.a
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
    throws f.a
  {
    long l1 = -1L;
    try
    {
      this.b = paraml.a;
      b(paraml);
      this.c = this.a.openAssetFileDescriptor(this.b, "r");
      if (this.c == null)
        throw new FileNotFoundException("Could not open file descriptor for: " + this.b);
    }
    catch (IOException localIOException)
    {
      throw new a(localIOException);
    }
    this.d = new FileInputStream(this.c.getFileDescriptor());
    long l2 = this.c.getStartOffset();
    long l3 = this.d.skip(l2 + paraml.f) - l2;
    if (l3 != paraml.f)
      throw new EOFException();
    if (paraml.g != l1)
      this.e = paraml.g;
    while (true)
    {
      this.f = true;
      c(paraml);
      return this.e;
      long l4 = this.c.getLength();
      if (l4 == l1)
      {
        FileChannel localFileChannel = this.d.getChannel();
        long l5 = localFileChannel.size();
        if (l5 == 0L);
        while (true)
        {
          this.e = l1;
          break;
          l1 = l5 - localFileChannel.position();
        }
      }
      this.e = (l4 - l3);
    }
  }

  public Uri a()
  {
    return this.b;
  }

  public void c()
    throws f.a
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
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.f.f
 * JD-Core Version:    0.6.2
 */