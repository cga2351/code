package com.viber.voip.messages.ui.d.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.ui.cv.c;
import com.viber.voip.messages.ui.d.b.l;
import com.viber.voip.schedule.d;
import com.viber.voip.schedule.o;
import com.viber.voip.util.dj;
import java.util.List;

public class a
  implements View.OnClickListener, View.OnLongClickListener
{
  private static final Logger a = ViberEnv.getLogger();
  private final Context b;
  private b c;
  private RecyclerView d;
  private b e;
  private View f;
  private ImageButton g;
  private ImageButton h;
  private TextView i;
  private cv.c j;
  private BroadcastReceiver k = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      a.c(a.this);
    }
  };

  public a(Context paramContext, cv.c paramc)
  {
    this.b = paramContext;
    this.j = paramc;
    this.b.registerReceiver(this.k, new IntentFilter("com.viber.voip.stickers.notification.UPDATE_STICKER_PACKAGES_COUNT_ACTION"));
  }

  private void a(Context paramContext, int paramInt1, int paramInt2)
  {
  }

  private View b(int paramInt)
  {
    RecyclerView.ViewHolder localViewHolder = this.d.findViewHolderForAdapterPosition(paramInt);
    if (localViewHolder != null)
      return localViewHolder.itemView;
    return null;
  }

  private void b()
  {
    if (this.i == null)
      return;
    int m = d.a().c().h();
    if (m > 0)
    {
      this.i.setVisibility(0);
      this.i.setText(String.valueOf(m));
      return;
    }
    this.i.setVisibility(8);
  }

  public void a()
  {
    try
    {
      this.b.unregisterReceiver(this.k);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
    }
  }

  public void a(int paramInt)
  {
    a(paramInt, c.c);
  }

  public void a(final int paramInt, final c paramc)
  {
    this.e.a(paramInt);
    if ((paramc == c.b) || (paramc == c.c))
      this.d.post(new Runnable()
      {
        public void run()
        {
          if (a.a(a.this).getChildCount() == 0)
            return;
          View localView = a.a(a.this, paramInt);
          LinearLayoutManager localLinearLayoutManager;
          int m;
          int i;
          if (localView == null)
          {
            localLinearLayoutManager = (LinearLayoutManager)a.a(a.this).getLayoutManager();
            int k = localLinearLayoutManager.findLastVisibleItemPosition();
            m = localLinearLayoutManager.findFirstVisibleItemPosition();
            if (paramInt > k)
              i = localLinearLayoutManager.getChildAt(-1 + localLinearLayoutManager.getChildCount()).getLeft() + a.b(a.this).b() * (paramInt - k);
          }
          int j;
          while (true)
          {
            j = i - (a.a(a.this).getWidth() - a.b(a.this).b()) / 2;
            switch (a.3.a[paramc.ordinal()])
            {
            default:
              return;
            case 1:
              a.a(a.this).scrollBy(j - a.a(a.this).getScrollX(), 0);
              return;
              i = localLinearLayoutManager.getChildAt(0).getLeft() - a.b(a.this).b() * (m - paramInt);
              continue;
              i = localView.getLeft();
            case 2:
            }
          }
          a.a(a.this).smoothScrollBy(j - a.a(a.this).getScrollX(), 0);
        }
      });
  }

  public void a(View paramView)
  {
    this.f = paramView;
    this.f.setBackgroundResource(this.j.b());
    this.d = ((RecyclerView)paramView.findViewById(R.id.indicator));
    this.e = new b(paramView.getContext(), this, null, this.j);
    this.d.setItemAnimator(null);
    this.d.setAdapter(this.e);
    this.g = ((ImageButton)paramView.findViewById(R.id.sticker_search));
    this.g.setImageDrawable(this.j.e());
    this.g.setOnClickListener(this);
    this.h = ((ImageButton)paramView.findViewById(R.id.market_btn));
    this.h.setImageDrawable(this.j.d());
    this.h.setOnClickListener(this);
    this.i = ((TextView)paramView.findViewById(R.id.new_package_count));
    b();
  }

  public void a(cv.c paramc)
  {
    this.j = paramc;
    if (this.d != null)
    {
      this.f.setBackgroundResource(this.j.b());
      this.e.a(paramc);
      this.g.setImageDrawable(this.j.e());
      this.h.setImageDrawable(this.j.d());
    }
  }

  public void a(b paramb)
  {
    this.c = paramb;
  }

  public void a(List<d> paramList, int paramInt, c paramc)
  {
    this.e.a(paramList, paramInt);
    a(paramInt, paramc);
  }

  public void a(boolean paramBoolean)
  {
    dj.b(this.g, paramBoolean);
  }

  public void onClick(View paramView)
  {
    if (paramView == this.h)
      if (this.c != null)
        this.c.q();
    d locald;
    do
    {
      int m;
      do
      {
        do
        {
          return;
          if (paramView != this.g)
            break;
        }
        while (this.c == null);
        this.c.f();
        return;
        locald = (d)paramView.getTag();
        m = ((Integer)paramView.getTag(R.id.list_item_id)).intValue();
        if (this.c != null)
          this.c.b(d.a(locald));
      }
      while (this.e.a() == m);
      if (!d.b(locald))
        a(m);
    }
    while (this.c == null);
    int n = l.a(d.c(locald), d.d(locald), d.e(locald));
    this.c.a(d.a(locald), n);
  }

  public boolean onLongClick(View paramView)
  {
    d locald = (d)paramView.getTag();
    a(paramView.getContext(), locald.b(), locald.c());
    return false;
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[3];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
    }
  }

  public static abstract interface b
  {
    public abstract void a(int paramInt1, int paramInt2);

    public abstract void b(int paramInt);

    public abstract void f();

    public abstract void q();
  }

  public static enum c
  {
    static
    {
      c[] arrayOfc = new c[3];
      arrayOfc[0] = a;
      arrayOfc[1] = b;
      arrayOfc[2] = c;
    }
  }

  public static class d
  {
    private final int a;
    private final int b;
    private final boolean c;
    private final boolean d;
    private final boolean e;
    private final boolean f;
    private final boolean g;
    private final boolean h;
    private final a.a i;

    public d(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, a.a parama)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramBoolean1;
      this.d = paramBoolean2;
      this.e = paramBoolean3;
      this.f = paramBoolean4;
      this.g = paramBoolean5;
      this.h = paramBoolean6;
      this.i = parama;
    }

    public a.a a()
    {
      return this.i;
    }

    public int b()
    {
      return this.a;
    }

    public int c()
    {
      return this.b;
    }

    public boolean d()
    {
      return this.d;
    }

    public boolean e()
    {
      return this.f;
    }

    public String toString()
    {
      return "TabItem{packageId=" + this.a + ", menuPosition=" + this.b + ", ignorePress=" + this.c + ", isSvg=" + this.d + ", isPromotion=" + this.e + ", hasSound=" + this.f + ", shouldDisplayRedownloadUi=" + this.g + ", isDefault=" + this.h + ", badge=" + this.i + '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.d.a.a
 * JD-Core Version:    0.6.2
 */