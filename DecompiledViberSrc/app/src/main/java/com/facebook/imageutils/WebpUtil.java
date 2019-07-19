package com.facebook.imageutils;

import android.util.Pair;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nullable;

public class WebpUtil
{
  private static final String VP8L_HEADER = "VP8L";
  private static final String VP8X_HEADER = "VP8X";
  private static final String VP8_HEADER = "VP8 ";

  private static boolean compare(byte[] paramArrayOfByte, String paramString)
  {
    if (paramArrayOfByte.length != paramString.length())
      return false;
    for (int i = 0; ; i++)
    {
      if (i >= paramArrayOfByte.length)
        break label36;
      if (paramString.charAt(i) != paramArrayOfByte[i])
        break;
    }
    label36: return true;
  }

  public static int get2BytesAsInt(InputStream paramInputStream)
    throws IOException
  {
    int i = (byte)paramInputStream.read();
    return 0xFF00 & (byte)paramInputStream.read() << 8 | i & 0xFF;
  }

  private static byte getByte(InputStream paramInputStream)
    throws IOException
  {
    return (byte)(0xFF & paramInputStream.read());
  }

  private static String getHeader(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (int i = 0; i < paramArrayOfByte.length; i++)
      localStringBuilder.append((char)paramArrayOfByte[i]);
    return localStringBuilder.toString();
  }

  private static int getInt(InputStream paramInputStream)
    throws IOException
  {
    int i = (byte)paramInputStream.read();
    int j = (byte)paramInputStream.read();
    int k = (byte)paramInputStream.read();
    return 0xFF000000 & (byte)paramInputStream.read() << 24 | 0xFF0000 & k << 16 | 0xFF00 & j << 8 | i & 0xFF;
  }

  private static short getShort(InputStream paramInputStream)
    throws IOException
  {
    return (short)(0xFF & paramInputStream.read());
  }

  @Nullable
  public static Pair<Integer, Integer> getSize(InputStream paramInputStream)
  {
    byte[] arrayOfByte = new byte[4];
    try
    {
      paramInputStream.read(arrayOfByte);
      boolean bool1 = compare(arrayOfByte, "RIFF");
      if (!bool1)
      {
        localObject2 = null;
        if (paramInputStream == null);
      }
      do
      {
        do
        {
          String str;
          do
          {
            do
            {
              do
              {
                try
                {
                  paramInputStream.close();
                  return localObject2;
                }
                catch (IOException localIOException4)
                {
                  localIOException4.printStackTrace();
                  return null;
                }
                getInt(paramInputStream);
                paramInputStream.read(arrayOfByte);
                boolean bool2 = compare(arrayOfByte, "WEBP");
                if (bool2)
                  break;
                localObject2 = null;
              }
              while (paramInputStream == null);
              try
              {
                paramInputStream.close();
                return null;
              }
              catch (IOException localIOException5)
              {
                localIOException5.printStackTrace();
                return null;
              }
              paramInputStream.read(arrayOfByte);
              str = getHeader(arrayOfByte);
              if (!"VP8 ".equals(str))
                break;
              Pair localPair3 = getVP8Dimension(paramInputStream);
              localObject2 = localPair3;
            }
            while (paramInputStream == null);
            try
            {
              paramInputStream.close();
              return localObject2;
            }
            catch (IOException localIOException9)
            {
              localIOException9.printStackTrace();
              return localObject2;
            }
            if (!"VP8L".equals(str))
              break;
            Pair localPair2 = getVP8LDimension(paramInputStream);
            localObject2 = localPair2;
          }
          while (paramInputStream == null);
          try
          {
            paramInputStream.close();
            return localObject2;
          }
          catch (IOException localIOException8)
          {
            localIOException8.printStackTrace();
            return localObject2;
          }
          if (!"VP8X".equals(str))
            break;
          Pair localPair1 = getVP8XDimension(paramInputStream);
          localObject2 = localPair1;
        }
        while (paramInputStream == null);
        try
        {
          paramInputStream.close();
          return localObject2;
        }
        catch (IOException localIOException7)
        {
          localIOException7.printStackTrace();
          return localObject2;
        }
        localObject2 = null;
      }
      while (paramInputStream == null);
      try
      {
        paramInputStream.close();
        return null;
      }
      catch (IOException localIOException6)
      {
        localIOException6.printStackTrace();
        return null;
      }
    }
    catch (IOException localIOException2)
    {
      do
      {
        localIOException2.printStackTrace();
        Object localObject2 = null;
      }
      while (paramInputStream == null);
      try
      {
        paramInputStream.close();
        return null;
      }
      catch (IOException localIOException3)
      {
        localIOException3.printStackTrace();
        return null;
      }
    }
    finally
    {
      if (paramInputStream == null);
    }
    try
    {
      paramInputStream.close();
      throw localObject1;
    }
    catch (IOException localIOException1)
    {
      while (true)
        localIOException1.printStackTrace();
    }
  }

  private static Pair<Integer, Integer> getVP8Dimension(InputStream paramInputStream)
    throws IOException
  {
    paramInputStream.skip(7L);
    int i = getShort(paramInputStream);
    int j = getShort(paramInputStream);
    int k = getShort(paramInputStream);
    if ((i != 157) || (j != 1) || (k != 42))
      return null;
    return new Pair(Integer.valueOf(get2BytesAsInt(paramInputStream)), Integer.valueOf(get2BytesAsInt(paramInputStream)));
  }

  private static Pair<Integer, Integer> getVP8LDimension(InputStream paramInputStream)
    throws IOException
  {
    getInt(paramInputStream);
    if (getByte(paramInputStream) != 47)
      return null;
    int i = 0xFF & (byte)paramInputStream.read();
    int j = 0xFF & (byte)paramInputStream.read();
    int k = 0xFF & (byte)paramInputStream.read();
    int m = 0xFF & (byte)paramInputStream.read();
    int n = 1 + (i | (j & 0x3F) << 8);
    int i1 = 1 + ((m & 0xF) << 10 | k << 2 | (j & 0xC0) >> 6);
    return new Pair(Integer.valueOf(n), Integer.valueOf(i1));
  }

  private static Pair<Integer, Integer> getVP8XDimension(InputStream paramInputStream)
    throws IOException
  {
    paramInputStream.skip(8L);
    return new Pair(Integer.valueOf(1 + read3Bytes(paramInputStream)), Integer.valueOf(1 + read3Bytes(paramInputStream)));
  }

  private static boolean isBitOne(byte paramByte, int paramInt)
  {
    return (0x1 & paramByte >> paramInt % 8) == 1;
  }

  private static int read3Bytes(InputStream paramInputStream)
    throws IOException
  {
    int i = getByte(paramInputStream);
    int j = getByte(paramInputStream);
    return 0xFF0000 & getByte(paramInputStream) << 16 | 0xFF00 & j << 8 | i & 0xFF;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imageutils.WebpUtil
 * JD-Core Version:    0.6.2
 */