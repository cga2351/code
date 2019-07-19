package com.viber.voip.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v4.util.ArraySet;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AbsListView.RecyclerListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

public class ViberListView extends ListView
  implements AbsListView.OnScrollListener
{
  private static final Logger a = ViberEnv.getLogger();
  private ArraySet<AbsListView.OnScrollListener> b = new ArraySet();
  private ArraySet<AbsListView.RecyclerListener> c = new ArraySet();
  private final AbsListView.RecyclerListener d;

  public ViberListView(Context paramContext)
  {
    super(paramContext);
    this.d = new az(this);
    a();
  }

  public ViberListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.d = new ay(this);
    a();
  }

  public ViberListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.d = new ax(this);
    a();
  }

  private void a()
  {
    super.setOnScrollListener(this);
    super.setRecyclerListener(this.d);
    setDescendantFocusability(262144);
  }

  private void a(View paramView)
  {
    int i = this.c.size();
    for (int j = 0; j < i; j++)
      ((AbsListView.RecyclerListener)this.c.valueAt(j)).onMovedToScrapHeap(paramView);
  }

  public void a(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.b.add(paramOnScrollListener);
  }

  public void a(AbsListView.RecyclerListener paramRecyclerListener)
  {
    this.c.add(paramRecyclerListener);
  }

  public View b(int paramInt)
  {
    int i = getFirstVisiblePosition();
    int j = -1 + (i + getChildCount());
    if ((paramInt < i) || (paramInt > j))
      return null;
    return getChildAt(paramInt - i);
  }

  public void b(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.b.remove(paramOnScrollListener);
  }

  public void b(AbsListView.RecyclerListener paramRecyclerListener)
  {
    this.c.remove(paramRecyclerListener);
  }

  public boolean b()
  {
    int i = getChildCount();
    boolean bool = false;
    if (i > 0)
    {
      int j = getLastVisiblePosition();
      int k = -1 + getAdapter().getCount();
      bool = false;
      if (j >= k)
      {
        int m = getChildAt(-1 + getChildCount()).getBottom();
        int n = getHeight() - getPaddingBottom();
        bool = false;
        if (m <= n)
          bool = true;
      }
    }
    return bool;
  }

  protected void dispatchDraw(Canvas paramCanvas)
  {
    try
    {
      super.dispatchDraw(paramCanvas);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      while ((getAdapter() == null) || (!(getAdapter() instanceof BaseAdapter)));
      ((BaseAdapter)getAdapter()).notifyDataSetChanged();
      return;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      label7: break label7;
    }
  }

  protected void layoutChildren()
  {
    try
    {
      super.layoutChildren();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      measure(getMeasuredWidth(), getMeasuredHeight());
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      while ((getAdapter() == null) || (!(getAdapter() instanceof BaseAdapter)));
      ((BaseAdapter)getAdapter()).notifyDataSetChanged();
      return;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
    }
    catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException)
    {
    }
  }

  public boolean n()
  {
    int i = getChildCount();
    boolean bool = false;
    if (i > 0)
    {
      int j = getLastVisiblePosition();
      int k = -1 + getAdapter().getCount();
      bool = false;
      if (j >= k)
        bool = true;
    }
    return bool;
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
    }
  }

  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = this.b.size();
    for (int j = 0; j < i; j++)
      ((AbsListView.OnScrollListener)this.b.valueAt(j)).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
  }

  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    int i = this.b.size();
    for (int j = 0; j < i; j++)
      ((AbsListView.OnScrollListener)this.b.valueAt(j)).onScrollStateChanged(paramAbsListView, paramInt);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (NullPointerException localNullPointerException)
    {
      return false;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      label11: break label11;
    }
  }

  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    throw new RuntimeException("Use addOnScrollListener instead");
  }

  public void setRecyclerListener(AbsListView.RecyclerListener paramRecyclerListener)
  {
    throw new RuntimeException("Use addRecyclerListener instead");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.ViberListView
 * JD-Core Version:    0.6.2
 */