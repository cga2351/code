package com.viber.voip.util.e.b;

import android.graphics.Bitmap;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.e.c;
import com.viber.voip.util.e.j;

public class b
  implements com.viber.voip.util.e.b
{
  private static final Logger a = ViberEnv.getLogger();
  private final int b;
  private final boolean c;
  private c d;

  public b(int paramInt, boolean paramBoolean)
  {
    this.b = paramInt;
    this.c = paramBoolean;
  }

  private c b()
  {
    if (this.d == null)
      this.d = c.a(ViberApplication.getApplication());
    return this.d;
  }

  public Bitmap a(Bitmap paramBitmap)
  {
    Object localObject = null;
    if (paramBitmap != null);
    try
    {
      Bitmap localBitmap = b().a(paramBitmap, this.b, this.c);
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
        a.a(localOutOfMemoryError, "Not enough memory to blur image.");
        localObject = null;
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        a.a(localException, "Some exception occurred during blurring.");
        localObject = null;
      }
    }
  }

  public String a()
  {
    return "[BlurPostProcessor]";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.e.b.b
 * JD-Core Version:    0.6.2
 */