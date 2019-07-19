package com.viber.voip.util.e.b;

import android.graphics.Bitmap;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.e.b;
import com.viber.voip.util.e.j;

public class e
  implements b
{
  private static final Logger a = ViberEnv.getLogger();
  private final int b;
  private final int c;

  public e(int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
  }

  public Bitmap a(Bitmap paramBitmap)
  {
    Object localObject = null;
    if (paramBitmap != null)
      if ((paramBitmap.getWidth() == this.b) && (paramBitmap.getHeight() == this.c))
        return paramBitmap;
    try
    {
      Bitmap localBitmap = Bitmap.createScaledBitmap(paramBitmap, this.b, this.c, false);
      localObject = localBitmap;
      if ((localObject != null) && (localObject != paramBitmap))
        j.c(paramBitmap);
      return localObject;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (true)
      {
        ViberApplication.getInstance().onOutOfMemory();
        a.a(localOutOfMemoryError, "Not enough memory to scale image.");
        localObject = null;
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        a.a(localException, "Some exception occurred during scaling.");
        localObject = null;
      }
    }
  }

  public String a()
  {
    return "[ScalePostProcessor]";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.e.b.e
 * JD-Core Version:    0.6.2
 */