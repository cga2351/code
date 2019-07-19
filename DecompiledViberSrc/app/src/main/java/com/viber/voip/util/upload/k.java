package com.viber.voip.util.upload;

import android.net.Uri;
import com.viber.dexshared.Logger;
import com.viber.jni.EncryptionParams;
import com.viber.voip.ViberEnv;
import com.viber.voip.b.b.a;
import com.viber.voip.util.at;
import com.viber.voip.util.cr;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Locale;

abstract class k
  implements Runnable
{
  private Logger a = ViberEnv.getLogger();
  private InputStream b;
  private EncryptionParams c;
  private File d;
  private File e;
  private File f;
  private volatile long g;

  k(InputStream paramInputStream, EncryptionParams paramEncryptionParams, File paramFile1, File paramFile2, File paramFile3)
  {
    this.b = paramInputStream;
    this.c = paramEncryptionParams;
    this.d = paramFile1;
    this.e = paramFile2;
    this.f = paramFile3;
    this.g = 0L;
  }

  private void a(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte = a.a(4096);
    try
    {
      while (true)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i == -1)
          break;
        paramOutputStream.write(arrayOfByte, 0, i);
        this.g += i;
      }
    }
    finally
    {
      a.a(arrayOfByte);
    }
    a.a(arrayOfByte);
  }

  long a()
  {
    return this.g;
  }

  void a(Logger paramLogger)
  {
    this.a = ViberEnv.getLogger(paramLogger);
  }

  abstract void a(Exception paramException);

  abstract void b();

  public void run()
  {
    try
    {
      localInputStream = cr.a(this.b, this.c);
      try
      {
        localFileOutputStream = new FileOutputStream(this.e);
        try
        {
          a(localInputStream, localFileOutputStream);
          if ((!this.e.renameTo(this.f)) && (!at.a(Uri.fromFile(this.e), Uri.fromFile(this.f))))
            throw new a(this.e.getAbsolutePath(), this.f.getAbsolutePath());
        }
        finally
        {
        }
      }
      finally
      {
        localInputStream.close();
      }
    }
    catch (Exception localException)
    {
      InputStream localInputStream;
      FileOutputStream localFileOutputStream;
      a(localException);
      return;
      this.d.delete();
      localFileOutputStream.close();
      localInputStream.close();
      b();
      return;
    }
    finally
    {
      this.e.delete();
    }
  }

  public static class a extends Exception
  {
    public a(String paramString1, String paramString2)
    {
      super();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.upload.k
 * JD-Core Version:    0.6.2
 */