package a.a;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

final class ag
{
  final String a;
  final long[] b;
  boolean c;
  af.a d;
  long e;
  private int f;
  private File g;

  ag(String paramString, int paramInt, File paramFile)
  {
    this.a = paramString;
    this.f = paramInt;
    this.g = paramFile;
    this.b = new long[paramInt];
  }

  public File a(int paramInt)
  {
    return new File(this.g, this.a + "." + paramInt);
  }

  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (long l : this.b)
      localStringBuilder.append(' ').append(l);
    return localStringBuilder.toString();
  }

  void a(String[] paramArrayOfString)
  {
    if (paramArrayOfString.length != this.f)
      throw b(paramArrayOfString);
    int i = 0;
    try
    {
      while (i < paramArrayOfString.length)
      {
        this.b[i] = Long.parseLong(paramArrayOfString[i]);
        i++;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw b(paramArrayOfString);
    }
  }

  public File b(int paramInt)
  {
    return new File(this.g, this.a + "." + paramInt + ".tmp");
  }

  IOException b(String[] paramArrayOfString)
  {
    throw new IOException("unexpected journal line: " + Arrays.toString(paramArrayOfString));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.ag
 * JD-Core Version:    0.6.2
 */