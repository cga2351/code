package com.viber.voip.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.support.v4.widget.DrawerLayout.LayoutParams;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.viber.dexshared.Logger;
import com.viber.voip.R.dimen;
import com.viber.voip.ViberEnv;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FullDrawerLayout extends DrawerLayout
  implements DrawerLayout.DrawerListener
{
  private static final Logger a = ViberEnv.getLogger();
  private boolean b = Boolean.TRUE.booleanValue();
  private int c;
  private Map<Integer, View> d = new HashMap();
  private boolean e;

  public FullDrawerLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }

  public FullDrawerLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }

  public FullDrawerLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }

  private void a()
  {
    addDrawerListener(this);
    this.c = getResources().getDimensionPixelOffset(R.dimen.drawer_slide_area);
  }

  private boolean a(MotionEvent paramMotionEvent)
  {
    Iterator localIterator = this.d.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (localEntry.getValue() == null)
        localEntry.setValue(findViewById(((Integer)localEntry.getKey()).intValue()));
      View localView = (View)localEntry.getValue();
      if ((localView != null) && (a(paramMotionEvent, localView)))
        return true;
    }
    return false;
  }

  private boolean a(MotionEvent paramMotionEvent, View paramView)
  {
    Rect localRect = new Rect();
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    paramView.getHitRect(localRect);
    localRect.offset(arrayOfInt[0] - paramView.getLeft(), arrayOfInt[1] - paramView.getTop());
    return (paramView.isShown()) && (localRect.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY()));
  }

  private boolean a(View paramView)
  {
    return ((DrawerLayout.LayoutParams)paramView.getLayoutParams()).gravity == 0;
  }

  private boolean b(View paramView)
  {
    return (0x7 & Gravity.getAbsoluteGravity(((DrawerLayout.LayoutParams)paramView.getLayoutParams()).gravity, paramView.getLayoutDirection())) != 0;
  }

  private int c(View paramView)
  {
    return Gravity.getAbsoluteGravity(((DrawerLayout.LayoutParams)paramView.getLayoutParams()).gravity, paramView.getLayoutDirection());
  }

  private void setCanSlide(boolean paramBoolean)
  {
    if (this.b != paramBoolean)
    {
      this.b = paramBoolean;
      if (paramBoolean)
        setDrawerLockMode(0);
    }
    else
    {
      return;
    }
    setDrawerLockMode(2);
  }

  public void a(int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt.length;
    for (int j = 0; j < i; j++)
    {
      int k = paramArrayOfInt[j];
      if (!this.d.containsKey(Integer.valueOf(k)))
        this.d.put(Integer.valueOf(k), null);
    }
  }

  public void onDrawerClosed(View paramView)
  {
    setCanSlide(true);
  }

  public void onDrawerOpened(View paramView)
  {
    setCanSlide(false);
  }

  public void onDrawerSlide(View paramView, float paramFloat)
  {
    setCanSlide(true);
  }

  public void onDrawerStateChanged(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return;
    case 0:
    }
    if (!isDrawerOpen(5));
    for (boolean bool = true; ; bool = false)
    {
      setCanSlide(bool);
      return;
    }
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = MotionEventCompat.getActionMasked(paramMotionEvent);
    int j;
    if ((i == 3) || (i == 1))
    {
      j = 1;
      if (j != 0)
        this.e = false;
      if (!this.e)
        break label40;
    }
    label40: 
    do
    {
      return false;
      j = 0;
      break;
      if (!a(paramMotionEvent))
        break label59;
    }
    while (j != 0);
    this.e = true;
    return false;
    label59: if (paramMotionEvent.getX() < this.c)
      setCanSlide(true);
    return super.onInterceptTouchEvent(paramMotionEvent);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getMode(paramInt2);
    int k = View.MeasureSpec.getSize(paramInt1);
    int m = View.MeasureSpec.getSize(paramInt2);
    if ((i == 1073741824) && (j != 1073741824));
    setMeasuredDimension(k, m);
    int n = getChildCount();
    int i1 = 0;
    if (i1 < n)
    {
      View localView = getChildAt(i1);
      if (localView.getVisibility() == 8);
      while (true)
      {
        i1++;
        break;
        DrawerLayout.LayoutParams localLayoutParams = (DrawerLayout.LayoutParams)localView.getLayoutParams();
        if (a(localView))
        {
          localView.measure(View.MeasureSpec.makeMeasureSpec(k - localLayoutParams.leftMargin - localLayoutParams.rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(m - localLayoutParams.topMargin - localLayoutParams.bottomMargin, 1073741824));
        }
        else if (b(localView))
        {
          if ((0x0 & (0x7 & c(localView))) != 0);
          localView.measure(getChildMeasureSpec(paramInt1, 0 + localLayoutParams.leftMargin + localLayoutParams.rightMargin, localLayoutParams.width), getChildMeasureSpec(paramInt2, localLayoutParams.topMargin + localLayoutParams.bottomMargin, localLayoutParams.height));
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.FullDrawerLayout
 * JD-Core Version:    0.6.2
 */