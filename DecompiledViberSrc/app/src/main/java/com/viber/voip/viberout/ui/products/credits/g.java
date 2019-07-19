package com.viber.voip.viberout.ui.products.credits;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.mvp.core.d;
import com.viber.voip.util.ViberActionRunner.be;
import com.viber.voip.util.ck;
import com.viber.voip.util.ck.b;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;
import com.viber.voip.viberout.ui.products.account.b;
import com.viber.voip.viberout.ui.products.model.CreditModel;
import com.viber.voip.viberout.ui.products.model.RateModel;
import java.util.Collection;

public class g extends d<ViberOutCreditsPresenter>
  implements View.OnClickListener, a.e, f
{
  private final Activity a;
  private final ck<RecyclerView.Adapter<RecyclerView.ViewHolder>> b;
  private final a c;
  private RecyclerView d;
  private ViewGroup e;
  private Button f;
  private a g;

  protected g(ViberOutCreditsPresenter paramViberOutCreditsPresenter, View paramView, Activity paramActivity, ck<RecyclerView.Adapter<RecyclerView.ViewHolder>> paramck, b paramb, a parama)
  {
    super(paramViberOutCreditsPresenter, paramView);
    this.a = paramActivity;
    this.b = paramck;
    this.c = parama;
    this.c.a(this);
    this.c.a(true);
    this.c.a(paramb);
    this.d = ((RecyclerView)paramView.findViewById(R.id.list_view));
    this.g = new a();
    this.d.addOnScrollListener(this.g);
    this.e = ((ViewGroup)paramView.findViewById(R.id.buy_button_container));
    dj.c(this.e, false);
    this.f = ((Button)paramView.findViewById(R.id.buy_button));
    this.f.setOnClickListener(this);
  }

  private void a(boolean paramBoolean, int paramInt)
  {
    if (this.e.getVisibility() == 0);
    for (boolean bool = true; ; bool = false)
    {
      if (bool != paramBoolean)
        ((ViberOutCreditsPresenter)this.mPresenter).a(paramBoolean, paramInt);
      return;
    }
  }

  public void a()
  {
    this.c.a();
  }

  public void a(int paramInt)
  {
    ((ViberOutCreditsPresenter)this.mPresenter).a(paramInt);
  }

  public void a(CreditModel paramCreditModel)
  {
    ((ViberOutCreditsPresenter)this.mPresenter).a(paramCreditModel);
  }

  public void a(RateModel paramRateModel)
  {
  }

  public void a(Collection<RateModel> paramCollection)
  {
    this.c.a(paramCollection);
  }

  public void a(Collection<CreditModel> paramCollection, int paramInt)
  {
    this.c.a(paramCollection, paramInt);
  }

  public void a(boolean paramBoolean)
  {
    dj.c(this.e, paramBoolean);
  }

  public void b(int paramInt)
  {
    a.a(this.g, paramInt);
  }

  public void b(CreditModel paramCreditModel)
  {
    if (!da.a(paramCreditModel.getBuyAction()))
      ViberActionRunner.be.a(this.a, paramCreditModel.getBuyAction());
  }

  public void c(CreditModel paramCreditModel)
  {
    Context localContext = this.f.getContext();
    int i = R.string.buy_price;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramCreditModel.getFormattedAmount();
    String str = localContext.getString(i, arrayOfObject);
    this.f.setText(str);
    this.f.setTag(paramCreditModel);
  }

  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.buy_button)
      a((CreditModel)this.f.getTag());
  }

  class a extends RecyclerView.OnScrollListener
  {
    private int b = -1;

    public a()
    {
      ((ViberOutCreditsPresenter)g.a(g.this)).a(false, this.b);
    }

    public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      int i = ((LinearLayoutManager)paramRecyclerView.getLayoutManager()).findFirstVisibleItemPosition();
      if (i == -1);
      ck.b localb;
      do
      {
        return;
        if (this.b != -1)
        {
          if (i >= this.b)
          {
            g.a(g.this, true, this.b);
            return;
          }
          g.a(g.this, false, this.b);
          return;
        }
        localb = g.b(g.this).a(i);
      }
      while (localb.a != g.c(g.this));
      if (localb.a.getItemViewType(localb.b) == 3)
      {
        this.b = i;
        g.a(g.this, true, this.b);
        return;
      }
      g.a(g.this, false, this.b);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.credits.g
 * JD-Core Version:    0.6.2
 */