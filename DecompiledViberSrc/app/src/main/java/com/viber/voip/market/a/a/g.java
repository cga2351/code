package com.viber.voip.market.a.a;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.widget.dslv.DragSortListView;
import com.viber.voip.widget.dslv.DragSortListView.c;

public class g extends com.viber.voip.widget.dslv.a
  implements DragSortListView.c
{
  private final c b;
  private final h c;
  private final DragSortListView d;
  private a e;

  public g(DragSortListView paramDragSortListView, c paramc, h paramh, a parama)
  {
    super(paramDragSortListView, R.id.drag_handle, 0, 0);
    b(false);
    this.d = paramDragSortListView;
    this.c = paramh;
    this.b = paramc;
    this.e = parama;
  }

  public float a(float paramFloat, long paramLong)
  {
    if (paramFloat > 0.8F)
      return this.c.getCount() / 10.0F;
    return 1.0F * paramFloat;
  }

  public int a(MotionEvent paramMotionEvent)
  {
    int i = super.c(paramMotionEvent);
    int j = i - this.d.getHeaderViewsCount();
    if ((i > this.b.a()) && (j >= 0) && (j < this.c.getCount()) && (this.c.a(j) != null) && (!this.c.a(j).c()))
      i = -1;
    return i;
  }

  public View a(int paramInt)
  {
    View localView = super.a(paramInt);
    if (localView.getParent() == null)
    {
      LinearLayout localLinearLayout = new LinearLayout(localView.getContext());
      localLinearLayout.setBackgroundResource(R.drawable.float_view_shadow);
      localView.setId(R.id.image);
      localLinearLayout.addView(localView);
    }
    if (this.e != null)
      this.e.a(localView, paramInt);
    return (View)localView.getParent();
  }

  public void a(View paramView)
  {
    super.a(paramView.findViewById(R.id.image));
    if (this.e != null)
      this.e.a();
  }

  public void a(View paramView, Point paramPoint1, Point paramPoint2)
  {
  }

  public static abstract interface a
  {
    public abstract void a();

    public abstract void a(View paramView, int paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.market.a.a.g
 * JD-Core Version:    0.6.2
 */