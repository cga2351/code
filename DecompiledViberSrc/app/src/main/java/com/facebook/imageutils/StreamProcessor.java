package com.facebook.imageutils;

import java.io.IOException;
import java.io.InputStream;

class StreamProcessor
{
  public static int readPackedInt(InputStream paramInputStream, int paramInt, boolean paramBoolean)
    throws IOException
  {
    int i = 0;
    int j = 0;
    if (j < paramInt)
    {
      int k = paramInputStream.read();
      if (k == -1)
        throw new IOException("no more bytes");
      if (paramBoolean)
        i |= (k & 0xFF) << j * 8;
      while (true)
      {
        j++;
        break;
        i = i << 8 | k & 0xFF;
      }
    }
    return i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imageutils.StreamProcessor
 * JD-Core Version:    0.6.2
 */