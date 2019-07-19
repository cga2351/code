package com.viber.voip.b.a.a;

import android.app.Application;
import android.graphics.Bitmap;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.b.a.d;
import com.viber.voip.util.dq;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class e
  implements d
{
  private static final Logger a = ViberEnv.getLogger();
  private Map<Integer, SoftReference<Bitmap>> b = new ConcurrentHashMap();
  private final String c;

  public e(String paramString)
  {
    this.c = paramString;
  }

  public Bitmap a(Integer paramInteger)
  {
    SoftReference localSoftReference = (SoftReference)this.b.get(paramInteger);
    if (localSoftReference != null);
    for (Bitmap localBitmap = (Bitmap)localSoftReference.get(); ; localBitmap = null)
    {
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
        return localBitmap;
      }
    }
  }

  public Bitmap a(Integer paramInteger, Bitmap paramBitmap)
  {
    this.b.put(paramInteger, new SoftReference(paramBitmap));
    return paramBitmap;
  }

  public Bitmap b(Integer paramInteger)
  {
    SoftReference localSoftReference = (SoftReference)this.b.remove(paramInteger);
    if (localSoftReference != null)
      return (Bitmap)localSoftReference.get();
    return null;
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
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.b.a.a.e
 * JD-Core Version:    0.6.2
 */