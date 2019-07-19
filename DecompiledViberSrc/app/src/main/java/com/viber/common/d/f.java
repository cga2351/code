package com.viber.common.d;

import java.io.Closeable;
import java.io.IOException;

public class f
{
  public static void a(Closeable[] paramArrayOfCloseable)
  {
    int i = paramArrayOfCloseable.length;
    int j = 0;
    while (true)
      if (j < i)
      {
        Closeable localCloseable = paramArrayOfCloseable[j];
        if (localCloseable != null);
        try
        {
          localCloseable.close();
          label24: j++;
        }
        catch (IOException localIOException)
        {
          break label24;
        }
      }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.d.f
 * JD-Core Version:    0.6.2
 */