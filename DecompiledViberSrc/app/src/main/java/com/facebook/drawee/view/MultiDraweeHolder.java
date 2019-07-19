package com.facebook.drawee.view;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import java.util.ArrayList;

public class MultiDraweeHolder<DH extends DraweeHierarchy>
{

  @VisibleForTesting
  ArrayList<DraweeHolder<DH>> mHolders = new ArrayList();

  @VisibleForTesting
  boolean mIsAttached = false;

  public void add(int paramInt, DraweeHolder<DH> paramDraweeHolder)
  {
    Preconditions.checkNotNull(paramDraweeHolder);
    Preconditions.checkElementIndex(paramInt, 1 + this.mHolders.size());
    this.mHolders.add(paramInt, paramDraweeHolder);
    if (this.mIsAttached)
      paramDraweeHolder.onAttach();
  }

  public void add(DraweeHolder<DH> paramDraweeHolder)
  {
    add(this.mHolders.size(), paramDraweeHolder);
  }

  public void clear()
  {
    if (this.mIsAttached)
      for (int i = 0; i < this.mHolders.size(); i++)
        ((DraweeHolder)this.mHolders.get(i)).onDetach();
    this.mHolders.clear();
  }

  public void draw(Canvas paramCanvas)
  {
    for (int i = 0; i < this.mHolders.size(); i++)
    {
      Drawable localDrawable = get(i).getTopLevelDrawable();
      if (localDrawable != null)
        localDrawable.draw(paramCanvas);
    }
  }

  public DraweeHolder<DH> get(int paramInt)
  {
    return (DraweeHolder)this.mHolders.get(paramInt);
  }

  public void onAttach()
  {
    if (this.mIsAttached);
    while (true)
    {
      return;
      this.mIsAttached = true;
      for (int i = 0; i < this.mHolders.size(); i++)
        ((DraweeHolder)this.mHolders.get(i)).onAttach();
    }
  }

  public void onDetach()
  {
    if (!this.mIsAttached);
    while (true)
    {
      return;
      this.mIsAttached = false;
      for (int i = 0; i < this.mHolders.size(); i++)
        ((DraweeHolder)this.mHolders.get(i)).onDetach();
    }
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    for (int i = 0; ; i++)
    {
      int j = this.mHolders.size();
      boolean bool = false;
      if (i < j)
      {
        if (((DraweeHolder)this.mHolders.get(i)).onTouchEvent(paramMotionEvent))
          bool = true;
      }
      else
        return bool;
    }
  }

  public void remove(int paramInt)
  {
    DraweeHolder localDraweeHolder = (DraweeHolder)this.mHolders.get(paramInt);
    if (this.mIsAttached)
      localDraweeHolder.onDetach();
    this.mHolders.remove(paramInt);
  }

  public int size()
  {
    return this.mHolders.size();
  }

  public boolean verifyDrawable(Drawable paramDrawable)
  {
    for (int i = 0; ; i++)
    {
      int j = this.mHolders.size();
      boolean bool = false;
      if (i < j)
      {
        if (paramDrawable == get(i).getTopLevelDrawable())
          bool = true;
      }
      else
        return bool;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.drawee.view.MultiDraweeHolder
 * JD-Core Version:    0.6.2
 */