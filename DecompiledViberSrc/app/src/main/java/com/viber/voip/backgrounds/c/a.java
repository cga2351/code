package com.viber.voip.backgrounds.c;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import com.viber.voip.backgrounds.b.a;
import com.viber.voip.util.e.j;
import com.viber.voip.util.upload.o;
import java.io.File;

public class a
{
  private static Bitmap a(int paramInt1, int paramInt2, int paramInt3)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888);
    new Canvas(localBitmap).drawColor(paramInt1);
    return localBitmap;
  }

  public static void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
    throws b.a
  {
    if (o.a())
    {
      j.a(a(paramInt1, paramInt2, paramInt3), new File(paramString));
      return;
    }
    throw new b.a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backgrounds.c.a
 * JD-Core Version:    0.6.2
 */