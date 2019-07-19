package com.facebook.common.internal;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public final class ByteStreams
{
  private static final int BUF_SIZE = 4096;

  public static long copy(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    Preconditions.checkNotNull(paramInputStream);
    Preconditions.checkNotNull(paramOutputStream);
    byte[] arrayOfByte = new byte[4096];
    int i;
    for (long l = 0L; ; l += i)
    {
      i = paramInputStream.read(arrayOfByte);
      if (i == -1)
        return l;
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }

  public static int read(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    Preconditions.checkNotNull(paramInputStream);
    Preconditions.checkNotNull(paramArrayOfByte);
    if (paramInt2 < 0)
      throw new IndexOutOfBoundsException("len is negative");
    int i = 0;
    while (true)
    {
      int j;
      if (i < paramInt2)
      {
        j = paramInputStream.read(paramArrayOfByte, paramInt1 + i, paramInt2 - i);
        if (j != -1);
      }
      else
      {
        return i;
      }
      i += j;
    }
  }

  public static void readFully(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = read(paramInputStream, paramArrayOfByte, paramInt1, paramInt2);
    if (i != paramInt2)
      throw new EOFException("reached end of stream after reading " + i + " bytes; " + paramInt2 + " bytes expected");
  }

  public static byte[] toByteArray(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    copy(paramInputStream, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }

  public static byte[] toByteArray(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    byte[] arrayOfByte1 = new byte[paramInt];
    int i = paramInt;
    int m;
    if (i > 0)
    {
      int k = paramInt - i;
      m = paramInputStream.read(arrayOfByte1, k, i);
      if (m == -1)
        arrayOfByte1 = Arrays.copyOf(arrayOfByte1, k);
    }
    int j;
    do
    {
      return arrayOfByte1;
      i -= m;
      break;
      j = paramInputStream.read();
    }
    while (j == -1);
    FastByteArrayOutputStream localFastByteArrayOutputStream = new FastByteArrayOutputStream(null);
    localFastByteArrayOutputStream.write(j);
    copy(paramInputStream, localFastByteArrayOutputStream);
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + localFastByteArrayOutputStream.size()];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
    localFastByteArrayOutputStream.writeTo(arrayOfByte2, arrayOfByte1.length);
    return arrayOfByte2;
  }

  private static final class FastByteArrayOutputStream extends ByteArrayOutputStream
  {
    void writeTo(byte[] paramArrayOfByte, int paramInt)
    {
      System.arraycopy(this.buf, 0, paramArrayOfByte, paramInt, this.count);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.common.internal.ByteStreams
 * JD-Core Version:    0.6.2
 */