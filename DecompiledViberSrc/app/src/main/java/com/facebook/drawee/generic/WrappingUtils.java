package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build.VERSION;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.drawable.DrawableParent;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.drawable.MatrixDrawable;
import com.facebook.drawee.drawable.Rounded;
import com.facebook.drawee.drawable.RoundedBitmapDrawable;
import com.facebook.drawee.drawable.RoundedColorDrawable;
import com.facebook.drawee.drawable.RoundedCornersDrawable;
import com.facebook.drawee.drawable.RoundedNinePatchDrawable;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import javax.annotation.Nullable;

public class WrappingUtils
{
  private static final String TAG = "WrappingUtils";
  private static final Drawable sEmptyDrawable = new ColorDrawable(0);

  private static Drawable applyLeafRounding(Drawable paramDrawable, RoundingParams paramRoundingParams, Resources paramResources)
  {
    if ((paramDrawable instanceof BitmapDrawable))
    {
      BitmapDrawable localBitmapDrawable = (BitmapDrawable)paramDrawable;
      RoundedBitmapDrawable localRoundedBitmapDrawable = new RoundedBitmapDrawable(paramResources, localBitmapDrawable.getBitmap(), localBitmapDrawable.getPaint());
      applyRoundingParams(localRoundedBitmapDrawable, paramRoundingParams);
      return localRoundedBitmapDrawable;
    }
    if ((paramDrawable instanceof NinePatchDrawable))
    {
      RoundedNinePatchDrawable localRoundedNinePatchDrawable = new RoundedNinePatchDrawable((NinePatchDrawable)paramDrawable);
      applyRoundingParams(localRoundedNinePatchDrawable, paramRoundingParams);
      return localRoundedNinePatchDrawable;
    }
    if (((paramDrawable instanceof ColorDrawable)) && (Build.VERSION.SDK_INT >= 11))
    {
      RoundedColorDrawable localRoundedColorDrawable = RoundedColorDrawable.fromColorDrawable((ColorDrawable)paramDrawable);
      applyRoundingParams(localRoundedColorDrawable, paramRoundingParams);
      return localRoundedColorDrawable;
    }
    FLog.w("WrappingUtils", "Don't know how to round that drawable: %s", new Object[] { paramDrawable });
    return paramDrawable;
  }

  static void applyRoundingParams(Rounded paramRounded, RoundingParams paramRoundingParams)
  {
    paramRounded.setCircle(paramRoundingParams.getRoundAsCircle());
    paramRounded.setRadii(paramRoundingParams.getCornersRadii());
    paramRounded.setBorder(paramRoundingParams.getBorderColor(), paramRoundingParams.getBorderWidth());
    paramRounded.setPadding(paramRoundingParams.getPadding());
    paramRounded.setScaleDownInsideBorders(paramRoundingParams.getScaleDownInsideBorders());
  }

  static DrawableParent findDrawableParentForLeaf(DrawableParent paramDrawableParent)
  {
    while (true)
    {
      Drawable localDrawable = paramDrawableParent.getDrawable();
      if ((localDrawable == paramDrawableParent) || (!(localDrawable instanceof DrawableParent)))
        return paramDrawableParent;
      paramDrawableParent = (DrawableParent)localDrawable;
    }
  }

  static Drawable maybeApplyLeafRounding(@Nullable Drawable paramDrawable, @Nullable RoundingParams paramRoundingParams, Resources paramResources)
  {
    if ((paramDrawable == null) || (paramRoundingParams == null) || (paramRoundingParams.getRoundingMethod() != RoundingParams.RoundingMethod.BITMAP_ONLY))
      return paramDrawable;
    if ((paramDrawable instanceof ForwardingDrawable))
    {
      DrawableParent localDrawableParent = findDrawableParentForLeaf((ForwardingDrawable)paramDrawable);
      localDrawableParent.setDrawable(applyLeafRounding(localDrawableParent.setDrawable(sEmptyDrawable), paramRoundingParams, paramResources));
      return paramDrawable;
    }
    return applyLeafRounding(paramDrawable, paramRoundingParams, paramResources);
  }

  @Nullable
  static Drawable maybeWrapWithMatrix(@Nullable Drawable paramDrawable, @Nullable Matrix paramMatrix)
  {
    if ((paramDrawable == null) || (paramMatrix == null))
      return paramDrawable;
    return new MatrixDrawable(paramDrawable, paramMatrix);
  }

  static Drawable maybeWrapWithRoundedOverlayColor(@Nullable Drawable paramDrawable, @Nullable RoundingParams paramRoundingParams)
  {
    if ((paramDrawable == null) || (paramRoundingParams == null) || (paramRoundingParams.getRoundingMethod() != RoundingParams.RoundingMethod.OVERLAY_COLOR))
      return paramDrawable;
    RoundedCornersDrawable localRoundedCornersDrawable = new RoundedCornersDrawable(paramDrawable);
    applyRoundingParams(localRoundedCornersDrawable, paramRoundingParams);
    localRoundedCornersDrawable.setOverlayColor(paramRoundingParams.getOverlayColor());
    return localRoundedCornersDrawable;
  }

  @Nullable
  static Drawable maybeWrapWithScaleType(@Nullable Drawable paramDrawable, @Nullable ScalingUtils.ScaleType paramScaleType)
  {
    return maybeWrapWithScaleType(paramDrawable, paramScaleType, null);
  }

  @Nullable
  static Drawable maybeWrapWithScaleType(@Nullable Drawable paramDrawable, @Nullable ScalingUtils.ScaleType paramScaleType, @Nullable PointF paramPointF)
  {
    if ((paramDrawable == null) || (paramScaleType == null))
      return paramDrawable;
    ScaleTypeDrawable localScaleTypeDrawable = new ScaleTypeDrawable(paramDrawable, paramScaleType);
    if (paramPointF != null)
      localScaleTypeDrawable.setFocusPoint(paramPointF);
    return localScaleTypeDrawable;
  }

  static void resetRoundingParams(Rounded paramRounded)
  {
    paramRounded.setCircle(false);
    paramRounded.setRadius(0.0F);
    paramRounded.setBorder(0, 0.0F);
    paramRounded.setPadding(0.0F);
    paramRounded.setScaleDownInsideBorders(false);
  }

  static void updateLeafRounding(DrawableParent paramDrawableParent, @Nullable RoundingParams paramRoundingParams, Resources paramResources)
  {
    DrawableParent localDrawableParent = findDrawableParentForLeaf(paramDrawableParent);
    Drawable localDrawable = localDrawableParent.getDrawable();
    if ((paramRoundingParams != null) && (paramRoundingParams.getRoundingMethod() == RoundingParams.RoundingMethod.BITMAP_ONLY))
      if ((localDrawable instanceof Rounded))
        applyRoundingParams((Rounded)localDrawable, paramRoundingParams);
    while (!(localDrawable instanceof Rounded))
    {
      do
        return;
      while (localDrawable == null);
      localDrawableParent.setDrawable(sEmptyDrawable);
      localDrawableParent.setDrawable(applyLeafRounding(localDrawable, paramRoundingParams, paramResources));
      return;
    }
    resetRoundingParams((Rounded)localDrawable);
  }

  static void updateOverlayColorRounding(DrawableParent paramDrawableParent, @Nullable RoundingParams paramRoundingParams)
  {
    Drawable localDrawable = paramDrawableParent.getDrawable();
    if ((paramRoundingParams != null) && (paramRoundingParams.getRoundingMethod() == RoundingParams.RoundingMethod.OVERLAY_COLOR))
      if ((localDrawable instanceof RoundedCornersDrawable))
      {
        localRoundedCornersDrawable = (RoundedCornersDrawable)localDrawable;
        applyRoundingParams(localRoundedCornersDrawable, paramRoundingParams);
        localRoundedCornersDrawable.setOverlayColor(paramRoundingParams.getOverlayColor());
      }
    while (!(localDrawable instanceof RoundedCornersDrawable))
    {
      RoundedCornersDrawable localRoundedCornersDrawable;
      return;
      paramDrawableParent.setDrawable(maybeWrapWithRoundedOverlayColor(paramDrawableParent.setDrawable(sEmptyDrawable), paramRoundingParams));
      return;
    }
    paramDrawableParent.setDrawable(((RoundedCornersDrawable)localDrawable).setCurrent(sEmptyDrawable));
    sEmptyDrawable.setCallback(null);
  }

  static ScaleTypeDrawable wrapChildWithScaleType(DrawableParent paramDrawableParent, ScalingUtils.ScaleType paramScaleType)
  {
    Drawable localDrawable = maybeWrapWithScaleType(paramDrawableParent.setDrawable(sEmptyDrawable), paramScaleType);
    paramDrawableParent.setDrawable(localDrawable);
    Preconditions.checkNotNull(localDrawable, "Parent has no child drawable!");
    return (ScaleTypeDrawable)localDrawable;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.drawee.generic.WrappingUtils
 * JD-Core Version:    0.6.2
 */