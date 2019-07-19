package com.viber.voip.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;
import com.viber.voip.R.anim;
import com.viber.voip.R.drawable;
import com.viber.voip.util.e.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CarouselViewFlipper extends ViewFlipper
{
  private List<GestureDetector> a;
  private Animation b;
  private Animation c;
  private Animation d;
  private Animation e;
  private Bitmap f;
  private Bitmap g;
  private int h;
  private int i;
  private int j;
  private int k;

  public CarouselViewFlipper(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  public CarouselViewFlipper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }

  private void a()
  {
    showNext();
    c();
  }

  private void a(Context paramContext)
  {
    this.a = new ArrayList();
    this.a.add(new GestureDetector(paramContext, new a(paramContext)));
    b(paramContext);
    c(paramContext);
  }

  private void b()
  {
    showPrevious();
    c();
  }

  private void b(Context paramContext)
  {
    this.b = AnimationUtils.loadAnimation(paramContext, R.anim.public_account_welcome_carousel_left_in);
    this.c = AnimationUtils.loadAnimation(paramContext, R.anim.public_account_welcome_carousel_left_out);
    this.d = AnimationUtils.loadAnimation(paramContext, R.anim.public_account_welcome_carousel_right_in);
    this.e = AnimationUtils.loadAnimation(paramContext, R.anim.public_account_welcome_carousel_right_out);
  }

  private void c()
  {
    if (isFlipping())
    {
      stopFlipping();
      startFlipping();
    }
  }

  private void c(Context paramContext)
  {
    this.f = BitmapFactory.decodeResource(getResources(), R.drawable.ic_welcome_carousel_page_indicator_unselected);
    this.g = BitmapFactory.decodeResource(getResources(), R.drawable.ic_welcome_carousel_page_indicator_selected);
    this.k = j.a(paramContext, 6.0F);
    this.j = this.g.getWidth();
    this.i = (this.j + this.k);
    this.h = j.a(paramContext, 12.0F);
  }

  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    int m = getChildCount();
    int n = getDisplayedChild();
    float f1 = (getWidth() - m * this.i) / 2.0F;
    float f2 = getHeight() - this.h;
    paramCanvas.save();
    int i1 = 0;
    if (i1 < m)
    {
      if (i1 == n)
        paramCanvas.drawBitmap(this.g, f1, f2, null);
      while (true)
      {
        f1 += this.i;
        i1++;
        break;
        paramCanvas.drawBitmap(this.f, f1, f2, null);
      }
    }
    paramCanvas.restore();
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((GestureDetector)localIterator.next()).onTouchEvent(paramMotionEvent);
    return super.onTouchEvent(paramMotionEvent);
  }

  public void showNext()
  {
    setInAnimation(this.b);
    setOutAnimation(this.c);
    super.showNext();
  }

  public void showPrevious()
  {
    setInAnimation(this.d);
    setOutAnimation(this.e);
    super.showPrevious();
  }

  private final class a extends GestureDetector.SimpleOnGestureListener
  {
    private final ViewConfiguration b;

    a(Context arg2)
    {
      Context localContext;
      this.b = ViewConfiguration.get(localContext);
    }

    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      float f1 = paramMotionEvent1.getY() - paramMotionEvent2.getY();
      float f2 = paramMotionEvent1.getX() - paramMotionEvent2.getX();
      if ((Math.abs(f2) > Math.abs(f1)) && (Math.abs(f2) > this.b.getScaledPagingTouchSlop()) && (Math.abs(paramFloat1) > this.b.getScaledMinimumFlingVelocity()))
      {
        if (f2 <= 0.0F)
          break label93;
        CarouselViewFlipper.a(CarouselViewFlipper.this);
      }
      while (true)
      {
        return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
        label93: CarouselViewFlipper.b(CarouselViewFlipper.this);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.CarouselViewFlipper
 * JD-Core Version:    0.6.2
 */