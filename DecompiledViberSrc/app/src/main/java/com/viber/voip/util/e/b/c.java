package com.viber.voip.util.e.b;

import android.graphics.Bitmap;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.dv;
import com.viber.voip.util.e.b;
import com.viber.voip.util.e.j;

public class c
  implements b
{
  private static final Logger a = ViberEnv.getLogger();
  private int b;
  private int c;
  private final boolean d;

  public c(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramBoolean;
  }

  public Bitmap a(Bitmap paramBitmap)
  {
    if (this.d)
    {
      int i = j.a(dv.q, paramBitmap.getWidth(), paramBitmap.getHeight(), this.b, this.c);
      this.b /= i;
      this.c /= i;
    }
    return j.b(paramBitmap, this.b, this.c);
  }

  public String a()
  {
    return "[FitAndCropPostProcessor]";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.e.b.c
 * JD-Core Version:    0.6.2
 */