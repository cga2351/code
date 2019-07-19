package com.my.target;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.util.Base64;
import android.util.DisplayMetrics;

public class ap
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
      float f1 = paramInt / 100.0F;
      Paint localPaint1 = new Paint();
      localPaint1.setColor(0);
      localPaint1.setStyle(Paint.Style.STROKE);
      Canvas localCanvas = new Canvas(localBitmap1);
      float f2 = 3.0F * f1;
      Paint localPaint2 = new Paint();
      localPaint2.setAntiAlias(true);
      localPaint2.setColor(-2013265920);
      localCanvas.drawOval(new RectF(0.0F, 0.0F, paramInt, paramInt), localPaint2);
      Paint localPaint3 = new Paint();
      localPaint3.setAntiAlias(true);
      localPaint3.setStyle(Paint.Style.STROKE);
      localPaint3.setStrokeWidth(f2);
      localPaint3.setColor(-1);
      localCanvas.drawCircle(paramInt / 2, paramInt / 2, paramInt / 2 - f2 / 2.0F, localPaint3);
      localPaint1.setStrokeWidth(f2);
      localPaint1.setColor(-1);
      localPaint1.setAntiAlias(true);
      Path localPath = new Path();
      localPath.setFillType(Path.FillType.EVEN_ODD);
      localPath.moveTo(33.0F * f1, 33.0F * f1);
      localPath.lineTo(66.0F * f1, 66.0F * f1);
      localPath.moveTo(33.0F * f1, 66.0F * f1);
      localPath.lineTo(50.0F * f1, 50.0F * f1);
      localPath.moveTo(55.0F * f1, 45.0F * f1);
      localPath.lineTo(66.0F * f1, f1 * 33.0F);
      localPath.close();
      localCanvas.drawPath(localPath, localPaint1);
    }
    return localBitmap1;
  }

  public static Bitmap a(int paramInt1, int paramInt2)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt1, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    localPaint.setStrokeWidth(paramInt2);
    localPaint.setAntiAlias(true);
    localPaint.setColor(-7829368);
    localPaint.setStrokeCap(Paint.Cap.BUTT);
    localPaint.setStyle(Paint.Style.STROKE);
    localCanvas.drawLine(0.0F, 0.0F, paramInt1, paramInt1, localPaint);
    localCanvas.drawLine(0.0F, paramInt1, paramInt1, 0.0F, localPaint);
    return localBitmap;
  }

  public static Bitmap a(Context paramContext)
  {
    byte[] arrayOfByte = Base64.decode("iVBORw0KGgoAAAANSUhEUgAAAGAAAABgCAQAAABIkb+zAAAAAmJLR0QAAKqNIzIAAAAJcEhZcwAACxMAAAsTAQCanBgAAAAHdElNRQfgAR0KGztQKbC4AAAA8UlEQVR42u2aQQ6EMAzE6IhH8wR+DfeVoCAySRfs82plQ0FNxTQBAAAAAMBXab0frFut4NIeBFTLX4lo4+ufJ+i1z8BI1//sHvz9HSCAAAIIIIAAAiqZo/bl0Vzdi7GECCCAAAJGDlg392wtr77/eEBufXeC/PreBGXoOxOUo+9LUJa+K0F5+p4EZeo7EpSrH5+gbP3oBOXrxyaoQj8yQTX6cQmq0o9KUJ1+TML89A+Ozot+1VznSkxkBBBAAAEEEEAAAQQQ4J8HeqPH3f3+UDMxS4iAgDXt5cVf7iruvVJx/Tuv0aWN//k9AAAAAAB8lx0xVUXCRDTw+wAAAABJRU5ErkJggg==", 0);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inDensity = 640;
    localOptions.inTargetDensity = paramContext.getResources().getDisplayMetrics().densityDpi;
    return BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.ap
 * JD-Core Version:    0.6.2
 */