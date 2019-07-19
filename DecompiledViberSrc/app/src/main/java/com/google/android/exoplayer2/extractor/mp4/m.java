package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.extractor.q.a;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.l;

public final class m
{
  public final boolean a;
  public final String b;
  public final q.a c;
  public final int d;
  public final byte[] e;

  public m(boolean paramBoolean, String paramString, int paramInt1, byte[] paramArrayOfByte1, int paramInt2, int paramInt3, byte[] paramArrayOfByte2)
  {
    int j;
    if (paramInt1 == 0)
    {
      j = i;
      if (paramArrayOfByte2 != null)
        break label77;
    }
    while (true)
    {
      a.a(i ^ j);
      this.a = paramBoolean;
      this.b = paramString;
      this.d = paramInt1;
      this.e = paramArrayOfByte2;
      this.c = new q.a(a(paramString), paramArrayOfByte1, paramInt2, paramInt3);
      return;
      j = 0;
      break;
      label77: i = 0;
    }
  }

  private static int a(String paramString)
  {
    if (paramString == null)
      return 1;
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
    case 3049879:
    case 3049895:
    case 3046605:
    case 3046671:
    }
    while (true)
      switch (i)
      {
      case 0:
      case 1:
      default:
        l.c("TrackEncryptionBox", "Unsupported protection scheme type '" + paramString + "'. Assuming AES-CTR crypto mode.");
        return 1;
        if (paramString.equals("cenc"))
        {
          i = 0;
          continue;
          if (paramString.equals("cens"))
          {
            i = 1;
            continue;
            if (paramString.equals("cbc1"))
            {
              i = 2;
              continue;
              if (paramString.equals("cbcs"))
                i = 3;
            }
          }
        }
        break;
      case 2:
      case 3:
      }
    return 2;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mp4.m
 * JD-Core Version:    0.6.2
 */