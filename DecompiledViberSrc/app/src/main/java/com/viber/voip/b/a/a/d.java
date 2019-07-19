package com.viber.voip.b.a.a;

import android.graphics.Bitmap;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.ui.aj;
import com.viber.voip.messages.ui.aj.a;

public class d
  implements com.viber.voip.b.a.d
{
  private static final Logger a = ViberEnv.getLogger();
  private final String b;
  private final aj c;

  public d(String paramString, aj paramaj)
  {
    this.b = paramString;
    this.c = paramaj;
  }

  public Bitmap a(Integer paramInteger)
  {
    try
    {
      aj.a locala = this.c.b(paramInteger.intValue());
      if (locala != null)
      {
        Bitmap localBitmap = this.c.a(locala);
        return localBitmap;
      }
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
 * Qualified Name:     com.viber.voip.b.a.a.d
 * JD-Core Version:    0.6.2
 */