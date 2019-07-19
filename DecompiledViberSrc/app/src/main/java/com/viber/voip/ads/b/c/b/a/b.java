package com.viber.voip.ads.b.c.b.a;

import android.database.DataSetObserver;
import android.graphics.Rect;
import android.support.v4.util.Pair;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListAdapter;
import com.viber.common.a.e;
import com.viber.voip.ViberEnv;
import com.viber.voip.ads.b.c.c.c;
import com.viber.voip.messages.adapters.j;
import com.viber.voip.ui.ViberListView;

public class b extends a<ViberListView, ListAdapter>
{
  private static final e d = ViberEnv.getLogger();
  private DataSetObserver e;
  private AbsListView.OnScrollListener f;

  public b(d paramd, ViberListView paramViberListView, ListAdapter paramListAdapter)
  {
    super(paramd, paramViberListView, paramListAdapter);
  }

  protected Pair<c, Boolean> a(ViberListView paramViberListView)
  {
    int i = paramViberListView.getFirstVisiblePosition();
    Rect localRect = new Rect();
    paramViberListView.getDrawingRect(localRect);
    this.c = (-1 + ((ListAdapter)this.b).getCount());
    int j = paramViberListView.getChildCount();
    for (int k = 0; k < j; k++)
    {
      View localView = paramViberListView.getChildAt(k);
      if ((localView != null) && (i + k < paramViberListView.getAdapter().getCount()))
      {
        Object localObject = paramViberListView.getAdapter().getItem(i + k);
        if ((localObject instanceof j))
        {
          c localc = ((j)localObject).j();
          if (localc != null)
          {
            float f1 = localView.getY();
            int m = localView.getHeight();
            if ((f1 >= localRect.top) && (f1 + m <= localRect.bottom))
              return Pair.create(localc, Boolean.valueOf(true));
            if ((f1 + m / 2 >= localRect.top) || (f1 + m / 2 >= localRect.bottom))
              return Pair.create(localc, Boolean.valueOf(false));
          }
        }
      }
    }
    return null;
  }

  protected void a()
  {
    this.f = new AbsListView.OnScrollListener()
    {
      public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
      }

      public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        switch (paramAnonymousInt)
        {
        default:
          return;
        case 0:
          b.this.b((ViberListView)paramAnonymousAbsListView);
          return;
        case 1:
        case 2:
        }
        b.this.j();
      }
    };
  }

  protected void b()
  {
    this.e = new DataSetObserver()
    {
      public void onChanged()
      {
        super.onChanged();
        b.this.b(b.this.a);
      }
    };
  }

  protected void c()
  {
    ((ViberListView)this.a).a(this.f);
  }

  protected void d()
  {
    ((ViberListView)this.a).b(this.f);
  }

  protected void e()
  {
    ((ListAdapter)this.b).registerDataSetObserver(this.e);
  }

  protected void f()
  {
    ((ListAdapter)this.b).unregisterDataSetObserver(this.e);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.b.c.b.a.b
 * JD-Core Version:    0.6.2
 */