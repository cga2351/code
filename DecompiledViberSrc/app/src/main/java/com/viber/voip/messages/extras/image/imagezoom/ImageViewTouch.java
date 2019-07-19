package com.viber.voip.messages.extras.image.imagezoom;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.ui.media.n.b;

public class ImageViewTouch extends b
{
  private static final Logger w = ViberEnv.getLogger();
  protected d a;
  protected GestureDetector b;
  protected int c;
  protected float d;
  protected float e;
  protected int f;
  protected a g;
  protected c h;
  protected b i;
  protected View.OnClickListener j;
  protected View.OnTouchListener k;
  private n.b x;

  public ImageViewTouch(Context paramContext)
  {
    super(paramContext);
  }

  public ImageViewTouch(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  private void a(MotionEvent paramMotionEvent)
  {
    if (this.k != null)
      this.k.onTouch((View)getParent(), paramMotionEvent);
  }

  protected float a(float paramFloat1, float paramFloat2)
  {
    if (this.f == 1)
    {
      if (paramFloat1 + 2.0F * this.e <= paramFloat2)
        return paramFloat1 + this.e;
      this.f = -1;
      return paramFloat2;
    }
    this.f = 1;
    return 1.0F;
  }

  protected void a()
  {
    super.a();
    this.c = ViewConfiguration.getTouchSlop();
    this.g = new a();
    this.h = new c();
    this.a = new d(getContext(), this.h);
    this.b = new GestureDetector(getContext(), this.g, null, true);
    this.d = 1.0F;
    this.f = 1;
  }

  protected void a(float paramFloat)
  {
    super.a(paramFloat);
    if (!this.a.a())
      this.d = paramFloat;
    n.b localb;
    if (this.x != null)
    {
      localb = this.x;
      if (paramFloat <= 1.0F)
        break label48;
    }
    label48: for (boolean bool = true; ; bool = false)
    {
      localb.b(bool);
      return;
    }
  }

  public void a(c paramc, boolean paramBoolean)
  {
    super.a(paramc, paramBoolean);
    this.e = (getMaxZoom() / 3.0F);
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.x != null)
      this.x.b(false);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    if (((View)getParent()).getTranslationY() != 0.0F)
    {
      a(paramMotionEvent);
      return false;
    }
    this.a.a(paramMotionEvent);
    if (!this.a.a());
    try
    {
      this.b.onTouchEvent(paramMotionEvent);
      label56: switch (0xFF & paramMotionEvent.getAction())
      {
      default:
      case 1:
      }
      while (true)
      {
        int m;
        if (!this.a.a())
        {
          boolean bool = getScale() < 1.0F;
          m = 0;
          if (!bool);
        }
        else
        {
          m = 1;
        }
        if (m == 0)
          a(paramMotionEvent);
        return true;
        if (getScale() < 1.0F)
          c(1.0F, 50.0F);
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label56;
    }
  }

  public void setExternalScrollListener(b paramb)
  {
    this.i = paramb;
  }

  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.j = paramOnClickListener;
  }

  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.k = paramOnTouchListener;
  }

  public void setZoomImageListener(n.b paramb)
  {
    this.x = paramb;
  }

  class a extends GestureDetector.SimpleOnGestureListener
  {
    a()
    {
    }

    public boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      float f1 = ImageViewTouch.this.getScale();
      float f2 = ImageViewTouch.this.a(f1, ImageViewTouch.this.getMaxZoom());
      float f3 = Math.min(ImageViewTouch.this.getMaxZoom(), Math.max(f2, 0.9F));
      ImageViewTouch.this.d = f3;
      ImageViewTouch.this.b(f3, paramMotionEvent.getX(), paramMotionEvent.getY(), 200.0F);
      ImageViewTouch.this.invalidate();
      if ((ImageViewTouch.this.i != null) && (f3 > 1.0F))
        ImageViewTouch.this.i.a(false);
      return super.onDoubleTap(paramMotionEvent);
    }

    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      if ((paramMotionEvent1.getPointerCount() > 1) || (paramMotionEvent2.getPointerCount() > 1));
      while (ImageViewTouch.this.a.a())
        return false;
      float f1 = paramMotionEvent2.getX() - paramMotionEvent1.getX();
      float f2 = paramMotionEvent2.getY() - paramMotionEvent1.getY();
      if ((Math.abs(paramFloat1) > 800.0F) || (Math.abs(paramFloat2) > 800.0F))
      {
        ImageViewTouch.this.c(f1 / 2.0F, f2 / 2.0F, 300.0F);
        ImageViewTouch.this.invalidate();
      }
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }

    public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      int i = 1;
      if ((paramMotionEvent1 == null) || (paramMotionEvent2 == null));
      while ((paramMotionEvent1.getPointerCount() > i) || (paramMotionEvent2.getPointerCount() > i) || (ImageViewTouch.this.a.a()))
        return false;
      ImageViewTouch.this.d(-paramFloat1, -paramFloat2);
      ImageViewTouch.this.invalidate();
      if (ImageViewTouch.this.i != null)
      {
        if ((ImageViewTouch.this.getScale() == 1.0F) && (ImageViewTouch.this.i != null))
        {
          ImageViewTouch.this.i.a(i);
          return false;
        }
        RectF localRectF = ImageViewTouch.this.getBitmapRect();
        if (localRectF != null)
        {
          float f = ImageViewTouch.this.getWidth();
          if (((paramMotionEvent1.getX() - paramMotionEvent2.getX() < ImageViewTouch.this.l) || ((int)(localRectF.right - f) > 0)) && ((paramMotionEvent1.getX() - paramMotionEvent2.getX() > -ImageViewTouch.this.l) || ((int)localRectF.left < 0)))
            break label228;
        }
      }
      while (true)
      {
        ImageViewTouch.this.i.a(i);
        if (i != 0)
          break;
        return super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
        label228: int j = 0;
      }
    }

    public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
    {
      if (ImageViewTouch.this.j != null)
      {
        ImageViewTouch.this.j.onClick(ImageViewTouch.this);
        return true;
      }
      return super.onSingleTapConfirmed(paramMotionEvent);
    }
  }

  public static abstract interface b
  {
    public abstract void a(boolean paramBoolean);
  }

  class c extends d.b
  {
    c()
    {
    }

    public boolean a(d paramd)
    {
      (paramd.d() - paramd.e());
      float f1 = ImageViewTouch.this.d * paramd.f();
      float f2 = Math.min(ImageViewTouch.this.getMaxZoom(), Math.max(f1, 0.9F));
      ImageViewTouch.this.b(f2, paramd.b(), paramd.c());
      ImageViewTouch.this.d = Math.min(ImageViewTouch.this.getMaxZoom(), Math.max(f2, 0.9F));
      ImageViewTouch.this.f = 1;
      ImageViewTouch.this.invalidate();
      return true;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extras.image.imagezoom.ImageViewTouch
 * JD-Core Version:    0.6.2
 */