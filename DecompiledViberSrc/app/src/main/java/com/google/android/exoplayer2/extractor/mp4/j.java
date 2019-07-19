package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.g.r;
import java.nio.ByteBuffer;
import java.util.UUID;

public final class j
{
  public static UUID a(byte[] paramArrayOfByte)
  {
    a locala = b(paramArrayOfByte);
    if (locala == null)
      return null;
    return a.a(locala);
  }

  public static byte[] a(UUID paramUUID, byte[] paramArrayOfByte)
  {
    return a(paramUUID, null, paramArrayOfByte);
  }

  public static byte[] a(UUID paramUUID, UUID[] paramArrayOfUUID, byte[] paramArrayOfByte)
  {
    int i = 0;
    int j;
    ByteBuffer localByteBuffer;
    if (paramArrayOfByte != null)
    {
      j = paramArrayOfByte.length;
      int k = j + 32;
      if (paramArrayOfUUID != null)
        k += 4 + 16 * paramArrayOfUUID.length;
      localByteBuffer = ByteBuffer.allocate(k);
      localByteBuffer.putInt(k);
      localByteBuffer.putInt(a.U);
      if (paramArrayOfUUID == null)
        break label154;
    }
    label154: for (int m = 16777216; ; m = 0)
    {
      localByteBuffer.putInt(m);
      localByteBuffer.putLong(paramUUID.getMostSignificantBits());
      localByteBuffer.putLong(paramUUID.getLeastSignificantBits());
      if (paramArrayOfUUID == null)
        break label160;
      localByteBuffer.putInt(paramArrayOfUUID.length);
      int n = paramArrayOfUUID.length;
      while (i < n)
      {
        UUID localUUID = paramArrayOfUUID[i];
        localByteBuffer.putLong(localUUID.getMostSignificantBits());
        localByteBuffer.putLong(localUUID.getLeastSignificantBits());
        i++;
      }
      j = 0;
      break;
    }
    label160: if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      localByteBuffer.putInt(paramArrayOfByte.length);
      localByteBuffer.put(paramArrayOfByte);
    }
    return localByteBuffer.array();
  }

  private static a b(byte[] paramArrayOfByte)
  {
    r localr = new r(paramArrayOfByte);
    if (localr.c() < 32);
    int i;
    UUID localUUID;
    int j;
    do
    {
      do
      {
        return null;
        localr.c(0);
      }
      while ((localr.p() != 4 + localr.b()) || (localr.p() != a.U));
      i = a.a(localr.p());
      if (i > 1)
      {
        l.c("PsshAtomUtil", "Unsupported pssh version: " + i);
        return null;
      }
      localUUID = new UUID(localr.r(), localr.r());
      if (i == 1)
        localr.d(16 * localr.v());
      j = localr.v();
    }
    while (j != localr.b());
    byte[] arrayOfByte = new byte[j];
    localr.a(arrayOfByte, 0, j);
    return new a(localUUID, i, arrayOfByte);
  }

  private static class a
  {
    private final UUID a;
    private final int b;
    private final byte[] c;

    public a(UUID paramUUID, int paramInt, byte[] paramArrayOfByte)
    {
      this.a = paramUUID;
      this.b = paramInt;
      this.c = paramArrayOfByte;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mp4.j
 * JD-Core Version:    0.6.2
 */