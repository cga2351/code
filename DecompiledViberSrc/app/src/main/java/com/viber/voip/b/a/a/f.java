package com.viber.voip.b.a.a;

import android.app.Application;
import android.graphics.Bitmap;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.b.a.d;
import com.viber.voip.util.dq;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class f
  implements d
{
  private static final Logger a = ViberEnv.getLogger();
  private Map<Integer, Bitmap> b = new ConcurrentHashMap();
  private final String c;

  public f(String paramString)
  {
    this.c = paramString;
  }

  public Bitmap a(Integer paramInteger)
  {
    Bitmap localBitmap = (Bitmap)this.b.get(paramInteger);
    if (localBitmap == null);
    try
    {
      localBitmap = dq.a(ViberApplication.getApplication().getResources(), paramInteger.intValue());
      if (localBitmap != null)
        a(paramInteger, localBitmap);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      a.a(localOutOfMemoryError, "Not enough memory to allocate default or loading bitmap.");
      ViberApplication.getInstance().onOutOfMemory();
    }
    return localBitmap;
  }

  public Bitmap a(Integer paramInteger, Bitmap paramBitmap)
  {
    return (Bitmap)this.b.put(paramInteger, paramBitmap);
  }

  public Bitmap b(Integer paramInteger)
  {
    return (Bitmap)this.b.remove(paramInteger);
  }

  public void evictAll()
  {
    this.b.clear();
  }

  public int size()
  {
    return this.b.size();
  }

  public void trimToSize(int paramInt)
  {
    this.b.clear();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.b.a.a.f
 * JD-Core Version:    0.6.2
 */