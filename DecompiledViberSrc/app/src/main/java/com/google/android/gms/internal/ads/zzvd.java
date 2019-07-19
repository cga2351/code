package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;

@zzare
public final class zzvd extends zzuy
{
  private MessageDigest zzbwd;

  public final byte[] zzbl(String paramString)
  {
    int i = 0;
    String[] arrayOfString = paramString.split(" ");
    Object localObject1;
    if (arrayOfString.length == 1)
    {
      int i2 = zzvc.zzbn(arrayOfString[0]);
      ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
      localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
      localByteBuffer.putInt(i2);
      localObject1 = localByteBuffer.array();
      this.zzbwd = zznf();
    }
    while (true)
    {
      byte[] arrayOfByte2;
      synchronized (this.mLock)
      {
        if (this.zzbwd == null)
        {
          byte[] arrayOfByte1 = new byte[0];
          return arrayOfByte1;
          if (arrayOfString.length < 5)
          {
            byte[] arrayOfByte4 = new byte[arrayOfString.length << 1];
            int m = 0;
            if (m < arrayOfString.length)
            {
              int n = zzvc.zzbn(arrayOfString[m]);
              int i1 = 0xFFFF & n ^ n >> 16;
              byte[] arrayOfByte5 = new byte[2];
              arrayOfByte5[0] = ((byte)i1);
              arrayOfByte5[1] = ((byte)(i1 >> 8));
              arrayOfByte4[(m << 1)] = arrayOfByte5[0];
              arrayOfByte4[(1 + (m << 1))] = arrayOfByte5[1];
              m++;
              continue;
            }
            localObject1 = arrayOfByte4;
            break;
          }
          localObject1 = new byte[arrayOfString.length];
          if (i >= arrayOfString.length)
            break;
          int j = zzvc.zzbn(arrayOfString[i]);
          localObject1[i] = ((byte)(j & 0xFF ^ 0xFF & j >> 8 ^ 0xFF & j >> 16 ^ j >> 24));
          i++;
          continue;
        }
        this.zzbwd.reset();
        this.zzbwd.update((byte[])localObject1);
        arrayOfByte2 = this.zzbwd.digest();
        if (arrayOfByte2.length > 4)
        {
          k = 4;
          byte[] arrayOfByte3 = new byte[k];
          System.arraycopy(arrayOfByte2, 0, arrayOfByte3, 0, arrayOfByte3.length);
          return arrayOfByte3;
        }
      }
      int k = arrayOfByte2.length;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzvd
 * JD-Core Version:    0.6.2
 */