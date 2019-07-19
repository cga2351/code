package com.viber.voip.b.a.a;

import android.app.Application;
import android.graphics.Bitmap;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.b.a.d;
import com.viber.voip.util.dq;

public class c
  implements d
{
  private static final Logger a = ViberEnv.getLogger();
  private final String b;

  public c(String paramString)
  {
    this.b = paramString;
  }

  public Bitmap a(Integer paramInteger)
  {
    try
    {
      Bitmap localBitmap = dq.a(ViberApplication.getApplication().getResources(), paramInteger.intValue());
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      a.a(localOutOfMemoryError, "Not enough memory to allocate bitmap.");
      ViberApplication.getInstance().onOutOfMemory();
    }
    return null;
  }

  public Bitmap a(Integer paramInteger, Bitmap paramBitmap)
  {
    return paramBitmap;
  }

  public Bitmap b(Integer paramInteger)
  {
    return null;
  }

  public void evictAll()
  {
  }

  public int size()
  {
    return 0;
  }

  public void trimToSize(int paramInt)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.b.a.a.c
 * JD-Core Version:    0.6.2
 */