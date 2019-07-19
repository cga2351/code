package pl.droidsonroids.gif;

import java.io.IOException;

public class GifIOException extends IOException
{
  public final e a;
  private final String b;

  private GifIOException(int paramInt, String paramString)
  {
    this.a = e.a(paramInt);
    this.b = paramString;
  }

  public String getMessage()
  {
    if (this.b == null)
      return this.a.a();
    return this.a.a() + ": " + this.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     pl.droidsonroids.gif.GifIOException
 * JD-Core Version:    0.6.2
 */