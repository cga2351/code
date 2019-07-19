package com.vk.sdk;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.DisplayMetrics;

public class VKUIHelper
{
  private static Context sApplicationContext;

  public static Context getApplicationContext()
  {
    return sApplicationContext;
  }

  public static Bitmap getRoundedCornerBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if ((paramBitmap == null) || (sApplicationContext == null))
      return paramBitmap;
    int i = (int)(sApplicationContext.getResources().getDisplayMetrics().density * paramInt1);
    float f = 1.0F * paramBitmap.getHeight() / i;
    int j = (int)(paramBitmap.getWidth() / f);
    Bitmap localBitmap = Bitmap.createBitmap(j, i, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    Rect localRect1 = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    Rect localRect2 = new Rect(0, 0, j, i);
    RectF localRectF = new RectF(localRect2);
    localPaint.setAntiAlias(true);
    localCanvas.drawARGB(0, 0, 0, 0);
    localPaint.setColor(-1);
    localCanvas.drawRoundRect(localRectF, paramInt2, paramInt2, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
    return localBitmap;
  }

  static void setApplicationContext(Context paramContext)
  {
    if (paramContext != null)
      sApplicationContext = paramContext.getApplicationContext();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.vk.sdk.VKUIHelper
 * JD-Core Version:    0.6.2
 */