package com.viber.voip.viberout.ui.products.credits;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import com.viber.svg.jni.SvgImageView;
import com.viber.svg.jni.clock.CyclicClock;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.R.style;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.f;
import com.viber.voip.util.e.f.b;
import com.viber.voip.viberout.ui.products.d;
import com.viber.voip.viberout.ui.products.model.CreditModel;
import com.viber.voip.viberout.ui.products.model.RateModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class a extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private e a;
  private com.viber.voip.viberout.ui.products.account.b b;
  private List<CreditModel> c = new ArrayList();
  private List<RateModel> d = new ArrayList();
  private boolean e;
  private boolean f;
  private boolean g = false;
  private int h = -1;
  private LayoutInflater i;
  private com.viber.voip.viberout.ui.products.e j;

  public a(LayoutInflater paramLayoutInflater, com.viber.voip.viberout.ui.products.e parame)
  {
    this.i = paramLayoutInflater;
    this.j = parame;
  }

  public void a()
  {
    this.g = true;
  }

  public void a(com.viber.voip.viberout.ui.products.account.b paramb)
  {
    this.b = paramb;
  }

  public void a(final e parame)
  {
    this.a = new e()
    {
      public void a(int paramAnonymousInt)
      {
        a.a(a.this, paramAnonymousInt);
        if (parame != null)
          parame.a(paramAnonymousInt);
      }

      public void a(CreditModel paramAnonymousCreditModel)
      {
        if (parame != null)
          parame.a(paramAnonymousCreditModel);
      }

      public void a(RateModel paramAnonymousRateModel)
      {
        if (parame != null)
          if (paramAnonymousRateModel.isExpanded())
            break label54;
        label54: for (boolean bool = true; ; bool = false)
        {
          paramAnonymousRateModel.setExpanded(bool);
          a.this.notifyItemChanged(2 + a.a(a.this).indexOf(paramAnonymousRateModel));
          parame.a(paramAnonymousRateModel);
          return;
        }
      }
    };
  }

  public void a(Collection<RateModel> paramCollection)
  {
    this.d.clear();
    this.d.addAll(paramCollection);
    this.e = false;
    notifyDataSetChanged();
  }

  public void a(Collection<CreditModel> paramCollection, int paramInt)
  {
    int k = 0;
    this.c.clear();
    this.h = -1;
    this.f = false;
    this.c.addAll(paramCollection);
    this.h = paramInt;
    if (this.c.size() < 3)
    {
      int m = 3 - this.c.size();
      while (k < m)
      {
        this.c.add(CreditModel.STUB);
        k++;
      }
    }
    notifyDataSetChanged();
  }

  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
    this.e = paramBoolean;
    notifyDataSetChanged();
  }

  public int getItemCount()
  {
    if (this.e);
    for (int k = 1; ; k = this.d.size())
    {
      int m = k + 2;
      if (!this.g)
        m++;
      return m;
    }
  }

  public int getItemViewType(int paramInt)
  {
    int k = 1;
    if ((this.f) && (this.e));
    for (int m = k; paramInt == 0; m = 0)
    {
      if (m != 0)
        k = 2;
      return k;
    }
    if (paramInt == k)
      return 3;
    if (m != 0)
      return 5;
    if ((!this.g) && (paramInt == 2 + this.d.size()))
      return 6;
    return 4;
  }

  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    switch (getItemViewType(paramInt))
    {
    case 2:
    default:
      return;
    case 1:
      ((c)paramViewHolder).a(this.c, this.h);
      return;
    case 3:
      b localb = (b)paramViewHolder;
      List localList = this.c;
      int k = this.h;
      if ((this.f) && (this.e));
      for (boolean bool = true; ; bool = false)
      {
        localb.a(localList, k, bool);
        return;
      }
    case 4:
    }
    ((f)paramViewHolder).a((RateModel)this.d.get(paramInt - 2));
  }

  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    default:
      return null;
    case 1:
      return new c((ViewGroup)this.i.inflate(R.layout.vo_credit_offer_items, paramViewGroup, false), this.a);
    case 2:
      return new d(this.i.inflate(R.layout.vo_credit_offer_items_empty, paramViewGroup, false));
    case 3:
      return new b(this.i.inflate(R.layout.vo_credit_buy_button, paramViewGroup, false), this.a, this.j);
    case 4:
      View localView = this.i.inflate(R.layout.vo_rate_item, paramViewGroup, false);
      e locale = this.a;
      d locald = new d(this.i);
      boolean bool1 = this.g;
      boolean bool2 = false;
      if (!bool1)
        bool2 = true;
      return new f(localView, locale, locald, bool2);
    case 6:
      return new a(this.i.inflate(R.layout.vo_my_account, paramViewGroup, false), this.b);
    case 5:
    }
    return new g(this.i.inflate(R.layout.vo_rate_item_empty, paramViewGroup, false));
  }

  static class a extends RecyclerView.ViewHolder
  {
    a(View paramView, com.viber.voip.viberout.ui.products.account.b paramb)
    {
      super();
      paramView.setOnClickListener(new b(paramb));
      dj.b(paramView.findViewById(R.id.divider), false);
    }
  }

  static class b extends RecyclerView.ViewHolder
    implements View.OnClickListener
  {
    private final a.e a;
    private final Button b;
    private CreditModel c;
    private com.viber.voip.viberout.ui.products.e d;

    public b(View paramView, a.e parame, com.viber.voip.viberout.ui.products.e parame1)
    {
      super();
      this.a = parame;
      this.d = parame1;
      this.b = ((Button)paramView.findViewById(R.id.buy_button));
      this.b.setOnClickListener(this);
    }

    void a(List<CreditModel> paramList, int paramInt, boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.b.setText(R.string.buy);
        this.b.setEnabled(false);
      }
      while (true)
      {
        if (this.d.b() != null)
          ViewCompat.setBackgroundTintList(this.b, this.d.b());
        return;
        if ((paramInt >= 0) && (paramInt < paramList.size()))
        {
          this.c = ((CreditModel)paramList.get(paramInt));
          Context localContext = this.itemView.getContext();
          int i = R.string.buy_price;
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = this.c.getFormattedAmount();
          String str = localContext.getString(i, arrayOfObject);
          this.b.setText(str);
          this.b.setEnabled(true);
        }
      }
    }

    public void onClick(View paramView)
    {
      if ((paramView.getId() == R.id.buy_button) && (this.a != null))
        this.a.a(this.c);
    }
  }

  static class c extends RecyclerView.ViewHolder
    implements View.OnClickListener
  {
    private final a.e a;
    private final List<a> b;
    private final int c;

    c(ViewGroup paramViewGroup, a.e parame)
    {
      super();
      this.a = parame;
      int i = paramViewGroup.getChildCount();
      this.b = new ArrayList(3);
      for (int j = 0; j < i; j++)
      {
        View localView = paramViewGroup.getChildAt(j);
        if ((localView instanceof ViewStub))
        {
          ViewGroup localViewGroup = (ViewGroup)((ViewStub)localView).inflate();
          localViewGroup.setOnClickListener(this);
          a locala = new a(localViewGroup, (TextView)localViewGroup.findViewById(R.id.credit_price), (TextView)localViewGroup.findViewById(R.id.extra_price), localViewGroup.findViewById(R.id.background), null);
          this.b.add(locala);
        }
      }
      this.c = paramViewGroup.getContext().getResources().getDimensionPixelOffset(R.dimen.credit_offer_padding);
    }

    private void a(View paramView, boolean paramBoolean)
    {
      int i = this.b.size();
      int j = 0;
      a locala;
      int k;
      boolean bool;
      int m;
      if (j < i)
      {
        locala = (a)this.b.get(j);
        k = this.c;
        if (paramView != locala.a)
          break label233;
        if ((paramBoolean) && (this.a != null))
          this.a.a(j);
        bool = true;
        m = 0;
      }
      while (true)
      {
        locala.d.setSelected(bool);
        TextView localTextView1 = locala.b;
        Context localContext1 = paramView.getContext();
        int n;
        label111: TextView localTextView2;
        Context localContext2;
        if (bool)
        {
          n = R.style.CreditOfferTextAppearance_Selected;
          localTextView1.setTextAppearance(localContext1, n);
          localTextView2 = locala.c;
          localContext2 = paramView.getContext();
          if (!bool)
            break label224;
        }
        label224: for (int i1 = R.style.CreditOfferTextAppearance_Selected_Secondary; ; i1 = R.style.CreditOfferTextAppearance_Secondary)
        {
          localTextView2.setTextAppearance(localContext2, i1);
          int[] arrayOfInt = new int[2];
          arrayOfInt[0] = locala.a.getPaddingLeft();
          arrayOfInt[1] = m;
          ValueAnimator localValueAnimator = ValueAnimator.ofInt(arrayOfInt);
          localValueAnimator.addUpdateListener(new c(locala));
          localValueAnimator.setDuration(150L);
          localValueAnimator.start();
          j++;
          break;
          n = R.style.CreditOfferTextAppearance;
          break label111;
        }
        return;
        label233: m = k;
        bool = false;
      }
    }

    void a(List<CreditModel> paramList, int paramInt)
    {
      int i = this.b.size();
      int j = 0;
      if (j < i)
      {
        CreditModel localCreditModel = (CreditModel)paramList.get(j);
        a locala = (a)this.b.get(j);
        locala.b.setText(localCreditModel.getFormattedAmount());
        label78: View localView;
        if (localCreditModel.getExtraFormattedAmount() == null)
        {
          dj.b(locala.c, false);
          localView = locala.d;
          if (!localCreditModel.isRecommended())
            break label174;
        }
        label174: for (int m = R.drawable.bg_credit_plan_stars; ; m = R.drawable.bg_credit_plan)
        {
          localView.setBackgroundResource(m);
          j++;
          break;
          dj.b(locala.c, true);
          Resources localResources = locala.c.getResources();
          int k = R.string.free_credit;
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = localCreditModel.getExtraFormattedAmount();
          String str = localResources.getString(k, arrayOfObject);
          locala.c.setText(str);
          break label78;
        }
      }
      if ((paramInt >= 0) && (paramInt < this.b.size()))
        a(((a)this.b.get(paramInt)).a, false);
    }

    public void onClick(View paramView)
    {
      a(paramView, true);
    }

    private static class a
    {
      final ViewGroup a;
      final TextView b;
      final TextView c;
      final View d;

      private a(ViewGroup paramViewGroup, TextView paramTextView1, TextView paramTextView2, View paramView)
      {
        this.a = paramViewGroup;
        this.b = paramTextView1;
        this.c = paramTextView2;
        this.d = paramView;
      }
    }
  }

  static class d extends RecyclerView.ViewHolder
  {
    private SvgImageView[] a;

    public d(View paramView)
    {
      super();
      SvgImageView[] arrayOfSvgImageView1 = new SvgImageView[3];
      arrayOfSvgImageView1[0] = ((SvgImageView)paramView.findViewById(R.id.credit_price1));
      arrayOfSvgImageView1[1] = ((SvgImageView)paramView.findViewById(R.id.credit_price2));
      arrayOfSvgImageView1[2] = ((SvgImageView)paramView.findViewById(R.id.credit_price3));
      this.a = arrayOfSvgImageView1;
      paramView.findViewById(R.id.credit_offer2_container).setSelected(true);
      for (SvgImageView localSvgImageView : this.a)
      {
        localSvgImageView.loadFromAsset(paramView.getContext(), "svg/vo_credit_offer_loading.svg", "", 0);
        localSvgImageView.setClock(new CyclicClock(4.0D));
        localSvgImageView.setSvgEnabled(true);
      }
    }
  }

  public static abstract interface e
  {
    public abstract void a(int paramInt);

    public abstract void a(CreditModel paramCreditModel);

    public abstract void a(RateModel paramRateModel);
  }

  static class f extends RecyclerView.ViewHolder
    implements View.OnClickListener
  {
    private final a.e a;
    private final com.viber.voip.viberout.ui.products.c b;
    private final ImageView c;
    private final TextView d;
    private final TextView e;
    private final TableLayout f;
    private final View g;
    private RateModel h;
    private final Drawable i;
    private final Drawable j;
    private final boolean k;

    public f(View paramView, a.e parame, com.viber.voip.viberout.ui.products.c paramc, boolean paramBoolean)
    {
      super();
      this.a = parame;
      this.b = paramc;
      this.c = ((ImageView)paramView.findViewById(R.id.country_icon));
      this.d = ((TextView)paramView.findViewById(R.id.country_name));
      this.e = ((TextView)paramView.findViewById(R.id.rate_equation));
      this.f = ((TableLayout)paramView.findViewById(R.id.destinations));
      this.g = paramView.findViewById(R.id.divider);
      this.i = paramView.getResources().getDrawable(R.drawable.ic_collapse_close);
      this.j = paramView.getResources().getDrawable(R.drawable.ic_collapse_open);
      this.k = paramBoolean;
      paramView.findViewById(R.id.toggle).setOnClickListener(this);
    }

    void a(RateModel paramRateModel)
    {
      boolean bool = true;
      this.h = paramRateModel;
      com.viber.voip.util.e.e.a(this.itemView.getContext()).a(paramRateModel.getCountryIcon(), this.c, f.a(R.drawable.ic_vo_default_country, f.b.a));
      this.d.setText(paramRateModel.getCountryName());
      this.e.setText(paramRateModel.getRateEquation());
      this.f.removeAllViews();
      if (paramRateModel.isExpanded())
      {
        this.b.a(this.f, paramRateModel.getDestinations());
        Resources localResources = this.itemView.getContext().getResources();
        int m = (int)localResources.getDimension(R.dimen.vo_destination_item_left_padding);
        int n = (int)localResources.getDimension(R.dimen.vo_destination_table_bottom_padding);
        this.f.setPadding(m, 0, 0, n);
        this.f.setVisibility(0);
        this.e.setCompoundDrawablesWithIntrinsicBounds(null, null, this.j, null);
      }
      while (this.k)
      {
        dj.c(this.g, bool);
        return;
        this.f.setVisibility(8);
        this.e.setCompoundDrawablesWithIntrinsicBounds(null, null, this.i, null);
      }
      View localView = this.g;
      if (!paramRateModel.isLast());
      while (true)
      {
        dj.c(localView, bool);
        return;
        bool = false;
      }
    }

    public void onClick(View paramView)
    {
      if ((paramView.getId() == R.id.toggle) && (this.a != null))
        this.a.a(this.h);
    }
  }

  static class g extends RecyclerView.ViewHolder
  {
    private final SvgImageView[] a;

    public g(View paramView)
    {
      super();
      SvgImageView[] arrayOfSvgImageView1 = new SvgImageView[3];
      arrayOfSvgImageView1[0] = ((SvgImageView)paramView.findViewById(R.id.placeholder));
      arrayOfSvgImageView1[1] = ((SvgImageView)paramView.findViewById(R.id.placeholder2));
      arrayOfSvgImageView1[2] = ((SvgImageView)paramView.findViewById(R.id.placeholder3));
      this.a = arrayOfSvgImageView1;
      for (SvgImageView localSvgImageView : this.a)
      {
        localSvgImageView.loadFromAsset(paramView.getContext(), "svg/vo_credit_loading.svg", "", 0);
        localSvgImageView.setClock(new CyclicClock(4.0D));
        localSvgImageView.setSvgEnabled(true);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.credits.a
 * JD-Core Version:    0.6.2
 */