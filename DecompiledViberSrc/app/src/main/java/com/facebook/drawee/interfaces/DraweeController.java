package com.facebook.drawee.interfaces;

import android.graphics.drawable.Animatable;
import android.view.MotionEvent;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public abstract interface DraweeController
{
  public abstract Animatable getAnimatable();

  public abstract String getContentDescription();

  @Nullable
  public abstract DraweeHierarchy getHierarchy();

  public abstract boolean isSameImageRequest(DraweeController paramDraweeController);

  public abstract void onAttach();

  public abstract void onDetach();

  public abstract boolean onTouchEvent(MotionEvent paramMotionEvent);

  public abstract void onViewportVisibilityHint(boolean paramBoolean);

  public abstract void setContentDescription(String paramString);

  public abstract void setHierarchy(@Nullable DraweeHierarchy paramDraweeHierarchy);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.drawee.interfaces.DraweeController
 * JD-Core Version:    0.6.2
 */