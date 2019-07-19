package com.viber.voip.ads.b.c.b.a;

import android.graphics.Rect;
import android.support.v4.util.Pair;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.View;
import com.viber.voip.ViberEnv;
import com.viber.voip.ads.b.c.c.c;

public class e extends a<RecyclerView, RecyclerView.Adapter>
{
  private static final com.viber.common.a.e d = ViberEnv.getLogger();
  private RecyclerView.AdapterDataObserver e;
  private RecyclerView.OnScrollListener f;
  private final int g;

  public e(d paramd, RecyclerView paramRecyclerView, RecyclerView.Adapter paramAdapter, int paramInt)
  {
    super(paramd, paramRecyclerView, paramAdapter);
    this.g = paramInt;
  }

  protected Pair<c, Boolean> a(RecyclerView paramRecyclerView)
  {
    if (!(paramRecyclerView.getLayoutManager() instanceof LinearLayoutManager))
      return null;
    int i = ((LinearLayoutManager)paramRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
    Rect localRect = new Rect();
    paramRecyclerView.getDrawingRect(localRect);
    this.c = (-1 + ((RecyclerView.Adapter)this.b).getItemCount());
    int j = paramRecyclerView.getChildCount();
    for (int k = 0; k < j; k++)
    {
      View localView = paramRecyclerView.getChildAt(k);
      if ((localView != null) && (i + k < paramRecyclerView.getAdapter().getItemCount()))
      {
        Object localObject = localView.getTag(this.g);
        if ((localObject instanceof c))
        {
          c localc = (c)localObject;
          float f1 = localView.getY();
          int m = localView.getHeight();
          if ((f1 >= localRect.top) && (f1 + m <= localRect.bottom))
            return Pair.create(localc, Boolean.valueOf(true));
          if ((f1 + m / 2 >= localRect.top) || (f1 + m / 2 >= localRect.bottom))
            return Pair.create(localc, Boolean.valueOf(false));
        }
      }
    }
    return null;
  }

  protected void a()
  {
    this.f = new RecyclerView.OnScrollListener()
    {
      public void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        switch (paramAnonymousInt)
        {
        default:
          return;
        case 0:
          e.this.b(paramAnonymousRecyclerView);
          return;
        case 1:
        case 2:
        }
        e.this.j();
      }

      public void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
      }
    };
  }

  protected void b()
  {
    this.e = new RecyclerView.AdapterDataObserver()
    {
      public void onChanged()
      {
        super.onChanged();
        e.this.b(e.this.a);
      }
    };
  }

  protected void c()
  {
    ((RecyclerView)this.a).addOnScrollListener(this.f);
  }

  protected void d()
  {
    ((RecyclerView)this.a).removeOnScrollListener(this.f);
  }

  protected void e()
  {
    ((RecyclerView.Adapter)this.b).registerAdapterDataObserver(this.e);
  }

  protected void f()
  {
    ((RecyclerView.Adapter)this.b).unregisterAdapterDataObserver(this.e);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.b.c.b.a.e
 * JD-Core Version:    0.6.2
 */