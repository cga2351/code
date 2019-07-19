package com.crashlytics.android.c;

import c.a.a.a.a.b.i;
import c.a.a.a.a.b.u;
import c.a.a.a.a.b.u.c;
import c.a.a.a.c;
import c.a.a.a.l;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

class an
  implements z
{
  private final File a;
  private final int b;
  private u c;

  public an(File paramFile, int paramInt)
  {
    this.a = paramFile;
    this.b = paramInt;
  }

  private void b(long paramLong, String paramString)
  {
    if (this.c == null)
      return;
    if (paramString == null);
    for (String str1 = "null"; ; str1 = paramString)
      try
      {
        int i = this.b / 4;
        if (str1.length() > i)
          str1 = "..." + str1.substring(str1.length() - i);
        String str2 = str1.replaceAll("\r", " ").replaceAll("\n", " ");
        Locale localLocale = Locale.US;
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = Long.valueOf(paramLong);
        arrayOfObject[1] = str2;
        byte[] arrayOfByte = String.format(localLocale, "%d %s%n", arrayOfObject).getBytes("UTF-8");
        this.c.a(arrayOfByte);
        while ((!this.c.b()) && (this.c.a() > this.b))
          this.c.c();
      }
      catch (IOException localIOException)
      {
        c.g().e("CrashlyticsCore", "There was a problem writing to the Crashlytics log.", localIOException);
        return;
      }
  }

  private a e()
  {
    if (!this.a.exists());
    do
    {
      return null;
      f();
    }
    while (this.c == null);
    final int[] arrayOfInt = { 0 };
    final byte[] arrayOfByte = new byte[this.c.a()];
    try
    {
      this.c.a(new u.c()
      {
        public void a(InputStream paramAnonymousInputStream, int paramAnonymousInt)
          throws IOException
        {
          try
          {
            paramAnonymousInputStream.read(arrayOfByte, arrayOfInt[0], paramAnonymousInt);
            int[] arrayOfInt = arrayOfInt;
            arrayOfInt[0] = (paramAnonymousInt + arrayOfInt[0]);
            return;
          }
          finally
          {
            paramAnonymousInputStream.close();
          }
        }
      });
      return new a(arrayOfByte, arrayOfInt[0]);
    }
    catch (IOException localIOException)
    {
      while (true)
        c.g().e("CrashlyticsCore", "A problem occurred while reading the Crashlytics log file.", localIOException);
    }
  }

  private void f()
  {
    if (this.c == null);
    try
    {
      this.c = new u(this.a);
      return;
    }
    catch (IOException localIOException)
    {
      c.g().e("CrashlyticsCore", "Could not open log file: " + this.a, localIOException);
    }
  }

  public d a()
  {
    a locala = e();
    if (locala == null)
      return null;
    return d.a(locala.a, 0, locala.b);
  }

  public void a(long paramLong, String paramString)
  {
    f();
    b(paramLong, paramString);
  }

  public byte[] b()
  {
    a locala = e();
    if (locala == null)
      return null;
    return locala.a;
  }

  public void c()
  {
    i.a(this.c, "There was a problem closing the Crashlytics log file.");
    this.c = null;
  }

  public void d()
  {
    c();
    this.a.delete();
  }

  public class a
  {
    public final byte[] a;
    public final int b;

    public a(byte[] paramInt, int arg3)
    {
      this.a = paramInt;
      int i;
      this.b = i;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.c.an
 * JD-Core Version:    0.6.2
 */