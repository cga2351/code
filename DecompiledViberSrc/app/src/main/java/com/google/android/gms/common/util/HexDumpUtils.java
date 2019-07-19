package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class HexDumpUtils
{
  @KeepForSdk
  public static String dump(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0) || (paramInt1 < 0) || (paramInt2 <= 0) || (paramInt1 + paramInt2 > paramArrayOfByte.length))
      return null;
    int i = 57;
    if (paramBoolean)
      i = 75;
    StringBuilder localStringBuilder = new StringBuilder(i * ((-1 + (paramInt2 + 16)) / 16));
    int j = paramInt1;
    int k = paramInt2;
    int m = 0;
    int n = 0;
    int i1;
    int i2;
    if (k > 0)
    {
      if (n == 0)
        if (paramInt2 < 65536)
        {
          Object[] arrayOfObject3 = new Object[1];
          arrayOfObject3[0] = Integer.valueOf(j);
          localStringBuilder.append(String.format("%04X:", arrayOfObject3));
          m = j;
        }
      int i4;
      while (true)
      {
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = Integer.valueOf(0xFF & paramArrayOfByte[j]);
        localStringBuilder.append(String.format(" %02X", arrayOfObject1));
        i1 = k - 1;
        i2 = n + 1;
        if ((!paramBoolean) || ((i2 != 16) && (i1 != 0)))
          break label349;
        i4 = 16 - i2;
        if (i4 <= 0)
          break;
        for (int i6 = 0; i6 < i4; i6++)
          localStringBuilder.append("   ");
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = Integer.valueOf(j);
        localStringBuilder.append(String.format("%08X:", arrayOfObject2));
        m = j;
        continue;
        if (n == 8)
          localStringBuilder.append(" -");
      }
      if (i4 >= 8)
        localStringBuilder.append("  ");
      localStringBuilder.append("  ");
      int i5 = 0;
      if (i5 < i2)
      {
        char c = (char)paramArrayOfByte[(m + i5)];
        if ((c >= ' ') && (c <= '~'));
        while (true)
        {
          localStringBuilder.append(c);
          i5++;
          break;
          c = '.';
        }
      }
      label349: if ((i2 != 16) && (i1 != 0))
        break label392;
      localStringBuilder.append('\n');
    }
    label392: for (int i3 = 0; ; i3 = i2)
    {
      j++;
      n = i3;
      k = i1;
      break;
      return localStringBuilder.toString();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.util.HexDumpUtils
 * JD-Core Version:    0.6.2
 */