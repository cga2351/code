package com.google.android.exoplayer2.drm;

import android.media.DeniedByServerException;
import android.media.MediaCryptoException;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract interface o<T extends n>
{
  public abstract a a(byte[] paramArrayOfByte, List<DrmInitData.SchemeData> paramList, int paramInt, HashMap<String, String> paramHashMap)
    throws NotProvisionedException;

  public abstract void a(byte[] paramArrayOfByte);

  public abstract byte[] a()
    throws MediaDrmException;

  public abstract byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws NotProvisionedException, DeniedByServerException;

  public abstract b b();

  public abstract void b(byte[] paramArrayOfByte)
    throws DeniedByServerException;

  public abstract void b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);

  public abstract Map<String, String> c(byte[] paramArrayOfByte);

  public abstract T d(byte[] paramArrayOfByte)
    throws MediaCryptoException;

  public static final class a
  {
  }

  public static final class b
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.o
 * JD-Core Version:    0.6.2
 */