package com.facebook.imageformat;

import com.facebook.common.internal.Preconditions;
import java.io.UnsupportedEncodingException;

public class ImageFormatCheckerUtils
{
  public static byte[] asciiBytes(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    try
    {
      byte[] arrayOfByte = paramString.getBytes("ASCII");
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new RuntimeException("ASCII not found!", localUnsupportedEncodingException);
    }
  }

  public static int indexOfPattern(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    int i = 0;
    Preconditions.checkNotNull(paramArrayOfByte1);
    Preconditions.checkNotNull(paramArrayOfByte2);
    if (paramInt2 > paramInt1);
    while (true)
    {
      return -1;
      int j = paramArrayOfByte2[0];
      int k = paramInt1 - paramInt2;
      while (i <= k)
      {
        if (paramArrayOfByte1[i] != j)
          do
            i++;
          while ((i <= k) && (paramArrayOfByte1[i] != j));
        if (i <= k)
        {
          int m = i + 1;
          int n = -1 + (m + paramInt2);
          for (int i1 = 1; (m < n) && (paramArrayOfByte1[m] == paramArrayOfByte2[i1]); i1++)
            m++;
          if (m == n)
            return i;
        }
        i++;
      }
    }
  }

  public static boolean startsWithPattern(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    Preconditions.checkNotNull(paramArrayOfByte1);
    Preconditions.checkNotNull(paramArrayOfByte2);
    if (paramArrayOfByte2.length > paramArrayOfByte1.length)
      return false;
    for (int i = 0; ; i++)
    {
      if (i >= paramArrayOfByte2.length)
        break label46;
      if (paramArrayOfByte1[i] != paramArrayOfByte2[i])
        break;
    }
    label46: return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imageformat.ImageFormatCheckerUtils
 * JD-Core Version:    0.6.2
 */