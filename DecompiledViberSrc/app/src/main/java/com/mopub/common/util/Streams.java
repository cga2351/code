package com.mopub.common.util;

import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Streams
{
  public static void closeStream(Closeable paramCloseable)
  {
    if (paramCloseable == null)
      return;
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Exception localException)
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Unable to close stream. Ignoring." });
    }
  }

  public static void copyContent(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    if ((paramInputStream == null) || (paramOutputStream == null))
      throw new IOException("Unable to copy from or to a null stream.");
    byte[] arrayOfByte = new byte[16384];
    while (true)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1)
        break;
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }

  public static void copyContent(InputStream paramInputStream, OutputStream paramOutputStream, long paramLong)
    throws IOException
  {
    if ((paramInputStream == null) || (paramOutputStream == null))
      throw new IOException("Unable to copy from or to a null stream.");
    byte[] arrayOfByte = new byte[16384];
    long l = 0L;
    while (true)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1)
        break;
      l += i;
      if (l >= paramLong)
        throw new IOException("Error copying content: attempted to copy " + l + " bytes, with " + paramLong + " maximum.");
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }

  public static void readStream(InputStream paramInputStream, byte[] paramArrayOfByte)
    throws IOException
  {
    int i = 0;
    int j = paramArrayOfByte.length;
    do
    {
      int k = paramInputStream.read(paramArrayOfByte, i, j);
      if (k == -1)
        break;
      i += k;
      j -= k;
    }
    while (j > 0);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.util.Streams
 * JD-Core Version:    0.6.2
 */