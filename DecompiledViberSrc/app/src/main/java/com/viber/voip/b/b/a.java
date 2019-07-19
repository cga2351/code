package com.viber.voip.b.b;

import android.support.v4.util.Pools.Pool;
import android.support.v4.util.Pools.SynchronizedPool;
import android.util.SparseIntArray;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.an;

public final class a
{
  private static final Logger a = ViberEnv.getLogger();
  private static final int b;
  private static final SparseIntArray c = null;
  private static final SparseIntArray d = null;
  private static final Pools.Pool<byte[]> e;
  private static final Pools.Pool<byte[]> f;
  private static final Pools.Pool<byte[]> g;

  static
  {
    int i = an.c();
    if (i < 4)
      b = 3;
    while (true)
    {
      e = new Pools.SynchronizedPool(3);
      f = new Pools.SynchronizedPool(2);
      g = new Pools.SynchronizedPool(b);
      return;
      if (i > 7)
        b = 7;
      else
        b = i;
    }
  }

  public static void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
      return;
    try
    {
      switch (paramArrayOfByte.length)
      {
      case 4096:
        e.release(paramArrayOfByte);
        return;
      case 8192:
        f.release(paramArrayOfByte);
        return;
      case 65536:
        g.release(paramArrayOfByte);
        return;
      }
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
    }
  }

  public static byte[] a(int paramInt)
  {
    return b(paramInt);
  }

  private static byte[] b(int paramInt)
  {
    byte[] arrayOfByte = null;
    switch (paramInt)
    {
    default:
    case 4096:
    case 8192:
    case 65536:
    }
    while (true)
    {
      if (arrayOfByte == null)
        arrayOfByte = new byte[paramInt];
      return arrayOfByte;
      arrayOfByte = (byte[])e.acquire();
      continue;
      arrayOfByte = (byte[])f.acquire();
      continue;
      arrayOfByte = (byte[])g.acquire();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.b.b.a
 * JD-Core Version:    0.6.2
 */