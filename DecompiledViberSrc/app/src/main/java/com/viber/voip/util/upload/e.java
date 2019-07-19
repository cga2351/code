package com.viber.voip.util.upload;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

public class e extends InputStream
{
  private String a;
  private RandomAccessFile b;
  private boolean c;
  private boolean d;
  private boolean e;
  private int f;
  private final byte[] g = new byte[1];

  void a()
  {
    try
    {
      notifyAll();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void a(String paramString)
  {
    try
    {
      this.a = paramString;
      notifyAll();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void a(boolean paramBoolean)
  {
    try
    {
      this.d = true;
      this.e = paramBoolean;
      notifyAll();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void close()
    throws IOException
  {
    try
    {
      super.close();
      this.c = true;
      if (this.b != null)
        this.b.close();
      notifyAll();
      return;
    }
    finally
    {
    }
  }

  public int read()
    throws IOException
  {
    if (read(this.g) == -1)
      return -1;
    return this.g[0];
  }

  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    while (true)
    {
      try
      {
        if (this.c)
          throw new IOException("File is closed");
      }
      finally
      {
      }
      if (this.b != null)
        break;
      if (this.a == null)
        break label139;
      this.b = new RandomAccessFile(this.a, "r");
    }
    if (this.b.getFilePointer() >= this.b.length())
      if (this.d)
        if (this.e)
        {
          this.f = (1 + this.f);
          if (this.f > 10)
            throw new IOException("read() returned EOF 10 times, forcing exception");
        }
    label139: int i;
    for (int j = -1; ; j = i)
    {
      while (true)
      {
        return j;
        throw new a("Growth did not finish successfully");
        try
        {
          wait();
        }
        catch (InterruptedException localInterruptedException)
        {
        }
      }
      break;
      i = this.b.read(paramArrayOfByte, paramInt1, paramInt2);
    }
  }

  public static class a extends IOException
  {
    public a(String paramString)
    {
      super();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.upload.e
 * JD-Core Version:    0.6.2
 */