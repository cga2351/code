package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import javax.annotation.Nullable;

public abstract class PlatformBitmapFactory
{
  private static void checkFinalImageBounds(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool1 = true;
    boolean bool2;
    if (paramInt1 + paramInt3 <= paramBitmap.getWidth())
    {
      bool2 = bool1;
      Preconditions.checkArgument(bool2, "x + width must be <= bitmap.width()");
      if (paramInt2 + paramInt4 > paramBitmap.getHeight())
        break label49;
    }
    while (true)
    {
      Preconditions.checkArgument(bool1, "y + height must be <= bitmap.height()");
      return;
      bool2 = false;
      break;
      label49: bool1 = false;
    }
  }

  private static void checkWidthHeight(int paramInt1, int paramInt2)
  {
    boolean bool1 = true;
    boolean bool2;
    if (paramInt1 > 0)
    {
      bool2 = bool1;
      Preconditions.checkArgument(bool2, "width must be > 0");
      if (paramInt2 <= 0)
        break label30;
    }
    while (true)
    {
      Preconditions.checkArgument(bool1, "height must be > 0");
      return;
      bool2 = false;
      break;
      label30: bool1 = false;
    }
  }

  private static void checkXYSign(int paramInt1, int paramInt2)
  {
    boolean bool1 = true;
    boolean bool2;
    if (paramInt1 >= 0)
    {
      bool2 = bool1;
      Preconditions.checkArgument(bool2, "x must be >= 0");
      if (paramInt2 < 0)
        break label30;
    }
    while (true)
    {
      Preconditions.checkArgument(bool1, "y must be >= 0");
      return;
      bool2 = false;
      break;
      label30: bool1 = false;
    }
  }

  private CloseableReference<Bitmap> createBitmap(int paramInt1, int paramInt2, Bitmap.Config paramConfig, boolean paramBoolean)
  {
    return createBitmap(paramInt1, paramInt2, paramConfig, paramBoolean, null);
  }

  private CloseableReference<Bitmap> createBitmap(int paramInt1, int paramInt2, Bitmap.Config paramConfig, boolean paramBoolean, @Nullable Object paramObject)
  {
    return createBitmap(null, paramInt1, paramInt2, paramConfig, paramBoolean, paramObject);
  }

  private CloseableReference<Bitmap> createBitmap(DisplayMetrics paramDisplayMetrics, int paramInt1, int paramInt2, Bitmap.Config paramConfig, boolean paramBoolean)
  {
    return createBitmap(paramDisplayMetrics, paramInt1, paramInt2, paramConfig, paramBoolean, null);
  }

  private CloseableReference<Bitmap> createBitmap(DisplayMetrics paramDisplayMetrics, int paramInt1, int paramInt2, Bitmap.Config paramConfig, boolean paramBoolean, @Nullable Object paramObject)
  {
    checkWidthHeight(paramInt1, paramInt2);
    CloseableReference localCloseableReference = createBitmapInternal(paramInt1, paramInt2, paramConfig);
    Bitmap localBitmap = (Bitmap)localCloseableReference.get();
    if (paramDisplayMetrics != null)
      localBitmap.setDensity(paramDisplayMetrics.densityDpi);
    if (Build.VERSION.SDK_INT >= 12)
      localBitmap.setHasAlpha(paramBoolean);
    if ((paramConfig == Bitmap.Config.ARGB_8888) && (!paramBoolean))
      localBitmap.eraseColor(-16777216);
    return localCloseableReference;
  }

  private static Bitmap.Config getSuitableBitmapConfig(Bitmap paramBitmap)
  {
    Bitmap.Config localConfig1 = Bitmap.Config.ARGB_8888;
    Bitmap.Config localConfig2 = paramBitmap.getConfig();
    if (localConfig2 != null);
    switch (1.$SwitchMap$android$graphics$Bitmap$Config[localConfig2.ordinal()])
    {
    default:
      localConfig1 = Bitmap.Config.ARGB_8888;
      return localConfig1;
    case 1:
      return Bitmap.Config.RGB_565;
    case 2:
    }
    return Bitmap.Config.ALPHA_8;
  }

  private static void setPropertyFromSourceBitmap(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    paramBitmap2.setDensity(paramBitmap1.getDensity());
    if (Build.VERSION.SDK_INT >= 12)
      paramBitmap2.setHasAlpha(paramBitmap1.hasAlpha());
    if (Build.VERSION.SDK_INT >= 19)
      paramBitmap2.setPremultiplied(paramBitmap1.isPremultiplied());
  }

  public CloseableReference<Bitmap> createBitmap(int paramInt1, int paramInt2)
  {
    return createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
  }

  public CloseableReference<Bitmap> createBitmap(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    return createBitmap(paramInt1, paramInt2, paramConfig, null);
  }

  public CloseableReference<Bitmap> createBitmap(int paramInt1, int paramInt2, Bitmap.Config paramConfig, @Nullable Object paramObject)
  {
    return createBitmapInternal(paramInt1, paramInt2, paramConfig);
  }

  public CloseableReference<Bitmap> createBitmap(int paramInt1, int paramInt2, @Nullable Object paramObject)
  {
    return createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888, paramObject);
  }

  public CloseableReference<Bitmap> createBitmap(Bitmap paramBitmap)
  {
    return createBitmap(paramBitmap, null);
  }

  public CloseableReference<Bitmap> createBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return createBitmap(paramBitmap, paramInt1, paramInt2, paramInt3, paramInt4, null);
  }

  public CloseableReference<Bitmap> createBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, @Nullable Matrix paramMatrix, boolean paramBoolean)
  {
    return createBitmap(paramBitmap, paramInt1, paramInt2, paramInt3, paramInt4, paramMatrix, paramBoolean, null);
  }

  public CloseableReference<Bitmap> createBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, @Nullable Matrix paramMatrix, boolean paramBoolean, @Nullable Object paramObject)
  {
    Preconditions.checkNotNull(paramBitmap, "Source bitmap cannot be null");
    checkXYSign(paramInt1, paramInt2);
    checkWidthHeight(paramInt3, paramInt4);
    checkFinalImageBounds(paramBitmap, paramInt1, paramInt2, paramInt3, paramInt4);
    Rect localRect = new Rect(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
    RectF localRectF1 = new RectF(0.0F, 0.0F, paramInt3, paramInt4);
    Bitmap.Config localConfig = getSuitableBitmapConfig(paramBitmap);
    CloseableReference localCloseableReference;
    Canvas localCanvas;
    Paint localPaint;
    if ((paramMatrix == null) || (paramMatrix.isIdentity()))
    {
      localCloseableReference = createBitmap(paramInt3, paramInt4, localConfig, paramBitmap.hasAlpha(), paramObject);
      setPropertyFromSourceBitmap(paramBitmap, (Bitmap)localCloseableReference.get());
      localCanvas = new Canvas((Bitmap)localCloseableReference.get());
      localPaint = null;
      localCanvas.drawBitmap(paramBitmap, localRect, localRectF1, localPaint);
      localCanvas.setBitmap(null);
      return localCloseableReference;
    }
    int i;
    label166: RectF localRectF2;
    int j;
    int k;
    if (!paramMatrix.rectStaysRect())
    {
      i = 1;
      localRectF2 = new RectF();
      paramMatrix.mapRect(localRectF2, localRectF1);
      j = Math.round(localRectF2.width());
      k = Math.round(localRectF2.height());
      if (i != 0)
        localConfig = Bitmap.Config.ARGB_8888;
      if ((i == 0) && (!paramBitmap.hasAlpha()))
        break label335;
    }
    label335: for (boolean bool = true; ; bool = false)
    {
      localCloseableReference = createBitmap(j, k, localConfig, bool, paramObject);
      setPropertyFromSourceBitmap(paramBitmap, (Bitmap)localCloseableReference.get());
      localCanvas = new Canvas((Bitmap)localCloseableReference.get());
      localCanvas.translate(-localRectF2.left, -localRectF2.top);
      localCanvas.concat(paramMatrix);
      localPaint = new Paint();
      localPaint.setFilterBitmap(paramBoolean);
      if (i == 0)
        break;
      localPaint.setAntiAlias(true);
      break;
      i = 0;
      break label166;
    }
  }

  public CloseableReference<Bitmap> createBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, @Nullable Object paramObject)
  {
    return createBitmap(paramBitmap, paramInt1, paramInt2, paramInt3, paramInt4, null, false, paramObject);
  }

  public CloseableReference<Bitmap> createBitmap(Bitmap paramBitmap, @Nullable Object paramObject)
  {
    return createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), paramObject);
  }

  public CloseableReference<Bitmap> createBitmap(DisplayMetrics paramDisplayMetrics, int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    return createBitmap(paramDisplayMetrics, paramInt1, paramInt2, paramConfig, null);
  }

  public CloseableReference<Bitmap> createBitmap(DisplayMetrics paramDisplayMetrics, int paramInt1, int paramInt2, Bitmap.Config paramConfig, @Nullable Object paramObject)
  {
    return createBitmap(paramDisplayMetrics, paramInt1, paramInt2, paramConfig, true, paramObject);
  }

  public CloseableReference<Bitmap> createBitmap(DisplayMetrics paramDisplayMetrics, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Bitmap.Config paramConfig)
  {
    return createBitmap(paramDisplayMetrics, paramArrayOfInt, paramInt1, paramInt2, paramInt3, paramInt4, paramConfig, null);
  }

  public CloseableReference<Bitmap> createBitmap(DisplayMetrics paramDisplayMetrics, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Bitmap.Config paramConfig, @Nullable Object paramObject)
  {
    CloseableReference localCloseableReference = createBitmap(paramDisplayMetrics, paramInt3, paramInt4, paramConfig, paramObject);
    ((Bitmap)localCloseableReference.get()).setPixels(paramArrayOfInt, paramInt1, paramInt2, 0, 0, paramInt3, paramInt4);
    return localCloseableReference;
  }

  public CloseableReference<Bitmap> createBitmap(DisplayMetrics paramDisplayMetrics, int[] paramArrayOfInt, int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    return createBitmap(paramDisplayMetrics, paramArrayOfInt, paramInt1, paramInt2, paramConfig, null);
  }

  public CloseableReference<Bitmap> createBitmap(DisplayMetrics paramDisplayMetrics, int[] paramArrayOfInt, int paramInt1, int paramInt2, Bitmap.Config paramConfig, @Nullable Object paramObject)
  {
    return createBitmap(paramDisplayMetrics, paramArrayOfInt, 0, paramInt1, paramInt1, paramInt2, paramConfig, paramObject);
  }

  public CloseableReference<Bitmap> createBitmap(int[] paramArrayOfInt, int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    return createBitmap(paramArrayOfInt, paramInt1, paramInt2, paramConfig, null);
  }

  public CloseableReference<Bitmap> createBitmap(int[] paramArrayOfInt, int paramInt1, int paramInt2, Bitmap.Config paramConfig, @Nullable Object paramObject)
  {
    CloseableReference localCloseableReference = createBitmapInternal(paramInt1, paramInt2, paramConfig);
    ((Bitmap)localCloseableReference.get()).setPixels(paramArrayOfInt, 0, paramInt1, 0, 0, paramInt1, paramInt2);
    return localCloseableReference;
  }

  public abstract CloseableReference<Bitmap> createBitmapInternal(int paramInt1, int paramInt2, Bitmap.Config paramConfig);

  public CloseableReference<Bitmap> createScaledBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return createScaledBitmap(paramBitmap, paramInt1, paramInt2, paramBoolean, null);
  }

  public CloseableReference<Bitmap> createScaledBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean, @Nullable Object paramObject)
  {
    checkWidthHeight(paramInt1, paramInt2);
    Matrix localMatrix = new Matrix();
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    localMatrix.setScale(paramInt1 / i, paramInt2 / j);
    return createBitmap(paramBitmap, 0, 0, i, j, localMatrix, paramBoolean, paramObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory
 * JD-Core Version:    0.6.2
 */