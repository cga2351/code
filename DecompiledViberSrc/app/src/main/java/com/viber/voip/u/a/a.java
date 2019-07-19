package com.viber.voip.u.a;

import android.annotation.SuppressLint;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.ui.ViberListView;

class a
  implements b
{
  static int a = 350;
  private static final Logger c = ViberEnv.getLogger();
  final a b;

  a(a parama)
  {
    this.b = parama;
  }

  @SuppressLint({"NewApi"})
  protected void a(ViberListView paramViberListView)
  {
    if (!paramViberListView.n())
      paramViberListView.setSelectionFromTop(-1 + paramViberListView.getAdapter().getCount(), -32768);
  }

  protected void a(final ViberListView paramViberListView, View paramView)
  {
    if (this.b != null)
      this.b.a();
    paramViberListView.smoothScrollBy(paramView.getMeasuredHeight() + paramViberListView.b(-2 + paramViberListView.getAdapter().getCount()).getBottom() - paramViberListView.getBottom(), a);
    if (this.b != null)
      paramViberListView.postDelayed(new Runnable()
      {
        public void run()
        {
          if (ViewCompat.isAttachedToWindow(paramViberListView))
            a.this.b.b();
        }
      }
      , a);
  }

  public void a(final ViberListView paramViberListView, final b.a parama)
  {
    final BaseAdapter localBaseAdapter = (BaseAdapter)paramViberListView.getAdapter();
    a(paramViberListView);
    paramViberListView.post(new Runnable()
    {
      public void run()
      {
        parama.b();
        localBaseAdapter.notifyDataSetChanged();
        paramViberListView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener()
        {
          public void onScrollChanged()
          {
            a.1.this.c.getViewTreeObserver().removeOnScrollChangedListener(this);
            View localView = a.this.b(a.1.this.c);
            if (localView != null)
              a.this.a(a.1.this.c, localView);
          }
        });
      }
    });
  }

  protected View b(ViberListView paramViberListView)
  {
    View localView = paramViberListView.getAdapter().getView(-1 + paramViberListView.getAdapter().getCount(), null, paramViberListView);
    localView.measure(View.MeasureSpec.makeMeasureSpec(paramViberListView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
    return localView;
  }

  static abstract interface a
  {
    public abstract void a();

    public abstract void b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.u.a.a
 * JD-Core Version:    0.6.2
 */