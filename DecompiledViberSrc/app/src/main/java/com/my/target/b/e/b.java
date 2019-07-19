package com.my.target.b.e;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Point;
import android.graphics.RectF;
import com.my.target.dp;

public final class b
{
  public static Bitmap a(int paramInt)
  {
    Bitmap.Config localConfig = Bitmap.Config.ARGB_8888;
    Bitmap localBitmap1;
    try
    {
      Bitmap localBitmap2 = Bitmap.createBitmap(paramInt, paramInt, localConfig);
      localBitmap1 = localBitmap2;
      if (localBitmap1 == null)
        return null;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (true)
      {
        dp.a("cannot build icon: OOME");
        localBitmap1 = null;
      }
      float f = paramInt / 100.0F;
      Paint localPaint = new Paint();
      localPaint.setColor(0);
      localPaint.setStyle(Paint.Style.STROKE);
      Canvas localCanvas = new Canvas(localBitmap1);
      a(f, paramInt, localPaint, localCanvas);
      localCanvas.drawArc(new RectF(57.0F * f, 45.0F * f, 67.0F * f, 55.0F * f), 90.0F, -180.0F, false, localPaint);
      localCanvas.drawArc(new RectF(52.0F * f, 40.0F * f, 72.0F * f, f * 60.0F), 90.0F, -180.0F, false, localPaint);
    }
    return localBitmap1;
  }

  private static void a(float paramFloat, int paramInt, Paint paramPaint, Canvas paramCanvas)
  {
    float f = 3.0F * paramFloat;
    Paint localPaint1 = new Paint();
    localPaint1.setAntiAlias(true);
    localPaint1.setColor(-2013265920);
    paramCanvas.drawOval(new RectF(0.0F, 0.0F, paramInt, paramInt), localPaint1);
    Paint localPaint2 = new Paint();
    localPaint2.setAntiAlias(true);
    localPaint2.setStyle(Paint.Style.STROKE);
    localPaint2.setStrokeWidth(f);
    localPaint2.setColor(-1);
    paramCanvas.drawCircle(paramInt / 2, paramInt / 2, paramInt / 2 - f / 2.0F, localPaint2);
    paramPaint.setStrokeWidth(f);
    paramPaint.setColor(-1);
    paramPaint.setAntiAlias(true);
    Path localPath = new Path();
    localPath.setFillType(Path.FillType.EVEN_ODD);
    localPath.moveTo(23.0F * paramFloat, 38.0F * paramFloat);
    localPath.lineTo(23.0F * paramFloat, 60.0F * paramFloat);
    localPath.lineTo(38.0F * paramFloat, 60.0F * paramFloat);
    localPath.lineTo(38.0F * paramFloat, 38.0F * paramFloat);
    localPath.lineTo(56.0F * paramFloat, 27.0F * paramFloat);
    localPath.lineTo(56.0F * paramFloat, 71.0F * paramFloat);
    localPath.lineTo(38.0F * paramFloat, 60.0F * paramFloat);
    localPath.moveTo(38.0F * paramFloat, 38.0F * paramFloat);
    localPath.lineTo(23.0F * paramFloat, 38.0F * paramFloat);
    localPath.close();
    paramCanvas.drawPath(localPath, paramPaint);
  }

  public static Bitmap b(int paramInt)
  {
    Bitmap.Config localConfig = Bitmap.Config.ARGB_8888;
    Bitmap localBitmap1;
    try
    {
      Bitmap localBitmap2 = Bitmap.createBitmap(paramInt, paramInt, localConfig);
      localBitmap1 = localBitmap2;
      if (localBitmap1 == null)
        return null;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (true)
      {
        dp.a("cannot build icon: OOME");
        localBitmap1 = null;
      }
      float f = paramInt / 100.0F;
      Paint localPaint = new Paint();
      localPaint.setColor(0);
      localPaint.setStyle(Paint.Style.STROKE);
      Canvas localCanvas = new Canvas(localBitmap1);
      a(f, paramInt, localPaint, localCanvas);
      Path localPath = new Path();
      localPath.setFillType(Path.FillType.EVEN_ODD);
      localPath.moveTo(62.0F * f, 40.0F * f);
      localPath.lineTo(82.0F * f, 60.0F * f);
      localPath.moveTo(62.0F * f, 60.0F * f);
      localPath.lineTo(82.0F * f, f * 40.0F);
      localCanvas.drawPath(localPath, localPaint);
    }
    return localBitmap1;
  }

  public static Bitmap c(int paramInt)
  {
    int i = paramInt / 4 + paramInt / 32;
    int j = paramInt / 8;
    Bitmap.Config localConfig = Bitmap.Config.ARGB_8888;
    Bitmap localBitmap1;
    try
    {
      Bitmap localBitmap2 = Bitmap.createBitmap(paramInt, paramInt, localConfig);
      localBitmap1 = localBitmap2;
      if (localBitmap1 == null)
        return null;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (true)
      {
        dp.a("cannot build play icon: OOME");
        localBitmap1 = null;
      }
      Canvas localCanvas = new Canvas(localBitmap1);
      Paint localPaint1 = new Paint();
      localPaint1.setAntiAlias(true);
      localPaint1.setColor(-2013265920);
      localCanvas.drawOval(new RectF(0.0F, 0.0F, paramInt, paramInt), localPaint1);
      Paint localPaint2 = new Paint();
      localPaint2.setColor(0);
      localCanvas.drawPaint(localPaint2);
      localPaint2.setStrokeWidth(4.0F);
      localPaint2.setColor(-16733198);
      localPaint2.setStyle(Paint.Style.FILL_AND_STROKE);
      localPaint2.setAntiAlias(true);
      Point localPoint1 = new Point(j * 3, i);
      Point localPoint2 = new Point(j * 3, paramInt - i);
      Point localPoint3 = new Point(paramInt - j * 2, paramInt / 2);
      Path localPath = new Path();
      localPath.setFillType(Path.FillType.EVEN_ODD);
      localPath.moveTo(localPoint1.x, localPoint1.y);
      localPath.lineTo(localPoint2.x, localPoint2.y);
      localPath.lineTo(localPoint3.x, localPoint3.y);
      localPath.lineTo(localPoint1.x, localPoint1.y);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint2);
    }
    return localBitmap1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.b.e.b
 * JD-Core Version:    0.6.2
 */