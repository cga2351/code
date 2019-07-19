package com.google.android.exoplayer2.f;

import android.net.Uri;
import android.util.Base64;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.w;
import java.io.IOException;
import java.net.URLDecoder;

public final class g extends e
{
  private l a;
  private int b;
  private byte[] c;

  public g()
  {
    super(false);
  }

  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
      return 0;
    int i = this.c.length - this.b;
    if (i == 0)
      return -1;
    int j = Math.min(paramInt2, i);
    System.arraycopy(this.c, this.b, paramArrayOfByte, paramInt1, j);
    this.b = (j + this.b);
    a(j);
    return j;
  }

  public long a(l paraml)
    throws IOException
  {
    b(paraml);
    this.a = paraml;
    Uri localUri = paraml.a;
    String str1 = localUri.getScheme();
    if (!"data".equals(str1))
      throw new w("Unsupported scheme: " + str1);
    String[] arrayOfString = ag.a(localUri.getSchemeSpecificPart(), ",");
    if (arrayOfString.length != 2)
      throw new w("Unexpected URI format: " + localUri);
    String str2 = arrayOfString[1];
    if (arrayOfString[0].contains(";base64"));
    while (true)
    {
      try
      {
        this.c = Base64.decode(str2, 0);
        c(paraml);
        return this.c.length;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        throw new w("Error while parsing Base64 encoded string: " + str2, localIllegalArgumentException);
      }
      this.c = ag.c(URLDecoder.decode(str2, "US-ASCII"));
    }
  }

  public Uri a()
  {
    if (this.a != null)
      return this.a.a;
    return null;
  }

  public void c()
    throws IOException
  {
    if (this.c != null)
    {
      this.c = null;
      d();
    }
    this.a = null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.f.g
 * JD-Core Version:    0.6.2
 */