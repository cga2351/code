package com.viber.voip.util.e.b;

import android.graphics.Bitmap;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.e.b;
import com.viber.voip.util.e.c;
import com.viber.voip.util.e.j;

public class d
  implements b
{
  private static final Logger a = ViberEnv.getLogger();
  private final int b;
  private int c;
  private int d;
  private final boolean e;
  private c f;

  public d(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramBoolean;
  }

  private c b()
  {
    if (this.f == null)
      this.f = c.a(ViberApplication.getApplication());
    return this.f;
  }

  public Bitmap a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
      try
      {
        Bitmap localBitmap2 = b().a(paramBitmap, this.b, this.c, this.d, this.e);
        localBitmap1 = localBitmap2;
        if ((localBitmap1 != null) && (localBitmap1 != paramBitmap))
          j.c(paramBitmap);
        return localBitmap1;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        while (true)
        {
          ViberApplication.getInstance().onOutOfMemory();
          a.a(localOutOfMemoryError, "Not enough memory to blur image.");
          localBitmap1 = null;
        }
      }
      catch (Exception localException)
      {
        while (true)
        {
          a.a(localException, "Some exception occurred during blurring.");
          Bitmap localBitmap1 = null;
        }
      }
    return null;
  }

  public String a()
  {
    return "[ScaleAndBlurPostProcessor]";
  }

  public void a(int paramInt)
  {
    this.c = paramInt;
  }

  public void b(int paramInt)
  {
    this.d = paramInt;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.e.b.d
 * JD-Core Version:    0.6.2
 */