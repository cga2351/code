package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

final class nx
  implements nt<Drawable>
{
  private final nw a = new nw();

  public final boolean a(Drawable paramDrawable, Bitmap paramBitmap)
  {
    if ((paramDrawable instanceof BitmapDrawable))
    {
      BitmapDrawable localBitmapDrawable = (BitmapDrawable)paramDrawable;
      if (localBitmapDrawable.getBitmap() != null)
      {
        localBitmap1 = localBitmapDrawable.getBitmap();
        Bitmap localBitmap2 = Bitmap.createScaledBitmap(localBitmap1, 1, 1, true);
        Bitmap localBitmap3 = Bitmap.createScaledBitmap(paramBitmap, 1, 1, true);
        a locala1 = new a(localBitmap2.getPixel(0, 0));
        a locala2 = new a(localBitmap3.getPixel(0, 0));
        if ((Math.abs(a.a(locala1) - a.a(locala2)) > 20) || (Math.abs(a.b(locala1) - a.b(locala2)) > 20) || (Math.abs(a.c(locala1) - a.c(locala2)) > 20) || (Math.abs(a.d(locala1) - a.d(locala2)) > 20))
          break label237;
        return true;
      }
    }
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    if ((i <= 0) || (j <= 0));
    for (Bitmap localBitmap1 = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888); ; localBitmap1 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888))
    {
      Canvas localCanvas = new Canvas(localBitmap1);
      paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
      paramDrawable.draw(localCanvas);
      break;
    }
    label237: return false;
  }

  private static final class a
  {
    private final int a;
    private final int b;
    private final int c;
    private final int d;

    a(int paramInt)
    {
      this.a = Color.alpha(paramInt);
      this.b = Color.red(paramInt);
      this.c = Color.green(paramInt);
      this.d = Color.blue(paramInt);
    }

    public final boolean equals(Object paramObject)
    {
      if (this == paramObject);
      a locala;
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass()))
          return false;
        locala = (a)paramObject;
        if (this.a != locala.a)
          return false;
        if (this.b != locala.b)
          return false;
        if (this.c != locala.c)
          return false;
      }
      while (this.d == locala.d);
      return false;
    }

    public final int hashCode()
    {
      return 31 * (31 * (31 * this.a + this.b) + this.c) + this.d;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.nx
 * JD-Core Version:    0.6.2
 */