package com.viber.voip.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class df
{
  public static Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    Paint localPaint = new Paint();
    localPaint.setColorFilter(new PorterDuffColorFilter(paramInt, PorterDuff.Mode.SRC_IN));
    Bitmap localBitmap = paramBitmap.copy(Bitmap.Config.ARGB_8888, true);
    new Canvas(localBitmap).drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
    return localBitmap;
  }

  public static Drawable a(Drawable paramDrawable, int paramInt, boolean paramBoolean)
  {
    if (paramDrawable == null)
      return null;
    Drawable localDrawable = DrawableCompat.wrap(paramDrawable);
    if (paramBoolean)
      localDrawable = localDrawable.mutate();
    DrawableCompat.setTint(localDrawable, paramInt);
    return localDrawable;
  }

  public static Drawable a(Drawable paramDrawable, ColorStateList paramColorStateList, boolean paramBoolean)
  {
    if (paramDrawable == null)
      return null;
    Drawable localDrawable = DrawableCompat.wrap(paramDrawable);
    if (paramBoolean)
      localDrawable = localDrawable.mutate();
    DrawableCompat.setTintList(localDrawable, paramColorStateList);
    return localDrawable;
  }

  public static Animation a(Context paramContext, Animation paramAnimation, int paramInt)
  {
    if (paramAnimation == null)
      paramAnimation = AnimationUtils.loadAnimation(paramContext, paramInt);
    return paramAnimation;
  }

  public static Integer a(Integer paramInteger, Context paramContext, int paramInt)
  {
    if (paramInteger != null)
      return paramInteger;
    return Integer.valueOf(ContextCompat.getColor(paramContext, paramInt));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.df
 * JD-Core Version:    0.6.2
 */