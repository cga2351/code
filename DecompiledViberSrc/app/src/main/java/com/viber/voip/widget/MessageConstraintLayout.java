package com.viber.voip.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.constraint.ConstraintLayout;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.ArraySet;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.viber.voip.widget.b.c;
import com.viber.voip.widget.b.c.a;
import java.util.Iterator;

public class MessageConstraintLayout extends ConstraintLayout
  implements al, b, b.a.a, c
{
  private ArraySet<c.a> g = new ArraySet(5);
  private ArrayMap<al.a, View> h = new ArrayMap(5);
  private b.a i;

  public MessageConstraintLayout(Context paramContext)
  {
    super(paramContext);
  }

  public MessageConstraintLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public MessageConstraintLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  private void c()
  {
    this.i = new b.a(getContext(), 1);
    if (ViewCompat.isLaidOut(this))
      this.i.a(getLeft(), getTop(), getRight(), getBottom());
  }

  public void a()
  {
    if (this.i != null)
    {
      this.i.a(true);
      return;
    }
    c();
    invalidate();
  }

  public void a(al.a parama, View paramView)
  {
    this.h.put(parama, paramView);
  }

  public void a(c.a parama)
  {
    this.g.add(parama);
  }

  public void a(boolean paramBoolean, long[] paramArrayOfLong)
  {
    if (this.i == null)
    {
      c();
      this.i.a(paramArrayOfLong);
    }
    while (!paramBoolean)
      return;
    this.i.a(paramArrayOfLong);
  }

  public boolean a(Canvas paramCanvas, View paramView, long paramLong)
  {
    return super.drawChild(paramCanvas, paramView, paramLong);
  }

  public void b()
  {
    if ((this.i == null) || (!this.i.a()))
      return;
    this.i.a(false);
    this.i.b();
    invalidate();
  }

  public void b(c.a parama)
  {
    this.g.remove(parama);
  }

  public void childDrawableStateChanged(View paramView)
  {
    super.childDrawableStateChanged(paramView);
    int j = this.h.size();
    for (int k = 0; k < j; k++)
    {
      al.a locala = (al.a)this.h.keyAt(k);
      if (paramView == this.h.get(locala))
        locala.a(paramView);
    }
  }

  public void dispatchDraw(Canvas paramCanvas)
  {
    if ((this.i != null) && (this.i.a()))
      this.i.c();
    super.dispatchDraw(paramCanvas);
  }

  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext())
      if (((c.a)localIterator.next()).a(paramMotionEvent))
        return true;
    return super.dispatchTouchEvent(paramMotionEvent);
  }

  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    if ((this.i != null) && (this.i.a()))
      return this.i.a(paramCanvas, paramView, paramLong, this);
    return super.drawChild(paramCanvas, paramView, paramLong);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.i != null)
      this.i.a(paramInt1, paramInt2, paramInt3, paramInt4);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.MessageConstraintLayout
 * JD-Core Version:    0.6.2
 */