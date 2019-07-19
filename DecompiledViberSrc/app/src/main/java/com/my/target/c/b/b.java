package com.my.target.c.b;

import android.os.Parcelable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.my.target.ax;
import com.my.target.be;
import com.my.target.cc;
import com.my.target.cc.a;
import com.my.target.cw;
import com.my.target.dp;
import java.util.ArrayList;
import java.util.List;

public class b extends RecyclerView
  implements cc
{
  private final cw a;
  private final View.OnClickListener b;
  private List<com.my.target.c.a.b> c;
  private cc.a d;
  private boolean e;
  private int f;
  private a g;

  private void b()
  {
    int i = this.a.findFirstCompletelyVisibleItemPosition();
    if (i < 0);
    View localView;
    do
    {
      do
      {
        do
          return;
        while (this.f == i);
        this.f = i;
      }
      while ((this.d == null) || (this.c == null));
      localView = this.a.findViewByPosition(this.f);
    }
    while (localView == null);
    cc.a locala = this.d;
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = this.f;
    locala.a(localView, arrayOfInt);
  }

  public void a()
  {
    if (this.g != null)
      this.g.c();
  }

  public void a(Parcelable paramParcelable)
  {
    this.a.onRestoreInstanceState(paramParcelable);
  }

  public Parcelable getState()
  {
    return this.a.onSaveInstanceState();
  }

  public int[] getVisibleCardNumbers()
  {
    int i = 0;
    int j = this.a.findFirstCompletelyVisibleItemPosition();
    int k = this.a.findLastCompletelyVisibleItemPosition();
    if ((this.c == null) || (j > k) || (j < 0) || (k >= this.c.size()))
      return new int[0];
    int[] arrayOfInt = new int[1 + (k - j)];
    while (i < arrayOfInt.length)
    {
      arrayOfInt[i] = j;
      j++;
      i++;
    }
    return arrayOfInt;
  }

  public void onScrollStateChanged(int paramInt)
  {
    super.onScrollStateChanged(paramInt);
    if (paramInt != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.e = bool;
      if (!this.e)
        b();
      return;
    }
  }

  public void setAdapter(RecyclerView.Adapter paramAdapter)
  {
    if ((paramAdapter instanceof a))
    {
      setPromoCardAdapter((a)paramAdapter);
      return;
    }
    dp.a("You must use setPromoCardAdapter(PromoCardAdapter) method with custom CardRecyclerView");
  }

  public void setPromoCardAdapter(a parama)
  {
    if (parama == null)
      return;
    this.c = parama.a();
    this.g = parama;
    this.g.a(this.b);
    setLayoutManager(this.a);
    super.swapAdapter(this.g, true);
  }

  public void setPromoCardSliderListener(cc.a parama)
  {
    this.d = parama;
  }

  public static abstract class a extends RecyclerView.Adapter<b.b>
  {
    private final List<com.my.target.c.a.b> a = new ArrayList();
    private View.OnClickListener b;

    private void a(com.my.target.c.a.b paramb, c paramc)
    {
      if (paramb.d() != null)
      {
        paramc.a().a(paramb.d().b(), paramb.d().c());
        if (paramb.d().f() == null)
          break label111;
        paramc.a().getImageView().setImageBitmap(paramb.d().f());
      }
      while (true)
      {
        paramc.b().setText(paramb.a());
        paramc.c().setText(paramb.b());
        String str = paramb.c();
        paramc.d().setText(str);
        paramc.d().setContentDescription(str);
        return;
        label111: be.a(paramb.d(), paramc.a().getImageView());
      }
    }

    public b.b a(ViewGroup paramViewGroup, int paramInt)
    {
      return new b.b(b());
    }

    public List<com.my.target.c.a.b> a()
    {
      return this.a;
    }

    public void a(View.OnClickListener paramOnClickListener)
    {
      this.b = paramOnClickListener;
    }

    public void a(b.b paramb)
    {
      int i = paramb.getLayoutPosition();
      ax localax = (ax)paramb.a().a().getImageView();
      localax.setImageData(null);
      if ((i > 0) && (i < this.a.size()))
      {
        com.my.target.c.a.b localb = (com.my.target.c.a.b)this.a.get(i);
        if (localb != null)
        {
          com.my.target.common.a.b localb1 = localb.d();
          if (localb1 != null)
            be.b(localb1, localax);
        }
      }
      paramb.a().e().setOnClickListener(null);
      paramb.a().d().setOnClickListener(null);
      super.onViewRecycled(paramb);
    }

    public void a(b.b paramb, int paramInt)
    {
      if (paramInt < this.a.size())
      {
        com.my.target.c.a.b localb = (com.my.target.c.a.b)this.a.get(paramInt);
        if (localb != null)
          a(localb, paramb.a());
      }
      paramb.a().e().setContentDescription("card_" + paramInt);
      paramb.a().e().setOnClickListener(this.b);
      paramb.a().d().setOnClickListener(this.b);
    }

    public abstract c b();

    public void c()
    {
      this.b = null;
    }

    public int getItemCount()
    {
      return this.a.size();
    }
  }

  static class b extends RecyclerView.ViewHolder
  {
    private final c a;

    b(c paramc)
    {
      super();
      paramc.e().setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
      this.a = paramc;
    }

    c a()
    {
      return this.a;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.c.b.b
 * JD-Core Version:    0.6.2
 */