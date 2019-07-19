package com.android.camera;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class CropImageView extends c
{
  ArrayList<b> a = new ArrayList();
  b b = null;
  float c;
  float d;
  int e;

  public CropImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  private void a(MotionEvent paramMotionEvent)
  {
    int k;
    for (int i = 0; ; i++)
    {
      int j = this.a.size();
      k = 0;
      if (i >= j)
        break;
      b localb2 = (b)this.a.get(i);
      localb2.a(false);
      localb2.c();
    }
    b localb1;
    do
    {
      k++;
      if (k >= this.a.size())
        break;
      localb1 = (b)this.a.get(k);
    }
    while (localb1.a(paramMotionEvent.getX(), paramMotionEvent.getY()) == 1);
    if (!localb1.a())
    {
      localb1.a(true);
      localb1.c();
    }
    invalidate();
  }

  private void b(b paramb)
  {
    Rect localRect = paramb.d;
    int i = Math.max(0, getLeft() - localRect.left);
    int j = Math.min(0, getRight() - localRect.right);
    int k = Math.max(0, getTop() - localRect.top);
    int m = Math.min(0, getBottom() - localRect.bottom);
    if (i != 0)
      if (k == 0)
        break label98;
    while (true)
    {
      if ((i != 0) || (k != 0))
        b(i, k);
      return;
      i = j;
      break;
      label98: k = m;
    }
  }

  private void c(b paramb)
  {
    Rect localRect = paramb.d;
    float f1 = localRect.width();
    float f2 = localRect.height();
    float f3 = getWidth();
    float f4 = getHeight();
    float f5 = Math.max(1.0F, Math.min(0.6F * (f3 / f1), 0.6F * (f4 / f2)) * getScale());
    if (Math.abs(f5 - getScale()) / f5 > 0.1D)
    {
      float[] arrayOfFloat = new float[2];
      arrayOfFloat[0] = paramb.e.centerX();
      arrayOfFloat[1] = paramb.e.centerY();
      getImageMatrix().mapPoints(arrayOfFloat);
      a(f5, arrayOfFloat[0], arrayOfFloat[1], 300.0F);
    }
    b(paramb);
  }

  protected void a(float paramFloat1, float paramFloat2)
  {
    super.a(paramFloat1, paramFloat2);
    for (int i = 0; i < this.a.size(); i++)
    {
      b localb = (b)this.a.get(i);
      localb.f.postTranslate(paramFloat1, paramFloat2);
      localb.c();
    }
  }

  protected void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super.a(paramFloat1, paramFloat2, paramFloat3);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      localb.f.set(getImageMatrix());
      localb.c();
    }
  }

  public void a(b paramb)
  {
    this.a.add(paramb);
    invalidate();
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    for (int i = 0; i < this.a.size(); i++)
      ((b)this.a.get(i)).a(paramCanvas);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.h.b() != null)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)localIterator.next();
        localb.f.set(getImageMatrix());
        localb.c();
        if (localb.b)
          c(localb);
      }
    }
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    CropImage localCropImage = (CropImage)getContext();
    if (localCropImage.b)
      return false;
    switch (paramMotionEvent.getAction())
    {
    default:
      switch (paramMotionEvent.getAction())
      {
      default:
      case 1:
      case 2:
      }
      break;
    case 0:
    case 1:
    case 2:
    }
    while (true)
    {
      return true;
      if (localCropImage.a)
      {
        a(paramMotionEvent);
        break;
      }
      for (int k = 0; k < this.a.size(); k++)
      {
        b localb2 = (b)this.a.get(k);
        int m = localb2.a(paramMotionEvent.getX(), paramMotionEvent.getY());
        if (m != 1)
        {
          this.e = m;
          this.b = localb2;
          this.c = paramMotionEvent.getX();
          this.d = paramMotionEvent.getY();
          b localb3 = this.b;
          if (m == 32);
          for (b.a locala = b.a.b; ; locala = b.a.c)
          {
            localb3.a(locala);
            break;
          }
        }
      }
      if (localCropImage.a)
        for (int i = 0; i < this.a.size(); i++)
        {
          b localb1 = (b)this.a.get(i);
          if (localb1.a())
          {
            localCropImage.c = localb1;
            int j = 0;
            if (j < this.a.size())
            {
              if (j == i);
              while (true)
              {
                j++;
                break;
                ((b)this.a.get(j)).b(true);
              }
            }
            c(localb1);
            ((CropImage)getContext()).a = false;
            return true;
          }
        }
      if (this.b != null)
      {
        c(this.b);
        this.b.a(b.a.a);
      }
      this.b = null;
      break;
      if (localCropImage.a)
      {
        a(paramMotionEvent);
        break;
      }
      if (this.b == null)
        break;
      this.b.a(this.e, paramMotionEvent.getX() - this.c, paramMotionEvent.getY() - this.d);
      this.c = paramMotionEvent.getX();
      this.d = paramMotionEvent.getY();
      b(this.b);
      break;
      a(true, true);
      continue;
      if (getScale() == 1.0F)
        a(true, true);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.android.camera.CropImageView
 * JD-Core Version:    0.6.2
 */