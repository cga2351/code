package com.viber.voip.viberout.ui.products.account;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.viber.voip.R.color;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;
import com.viber.voip.viberout.ui.products.e;
import java.util.List;

public class a extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private b a;
  private int b;
  private AccountViewModel c;
  private LayoutInflater d;
  private e e;

  public a(LayoutInflater paramLayoutInflater, e parame)
  {
    this.d = paramLayoutInflater;
    this.e = parame;
  }

  public void a()
  {
    this.b = 1;
    notifyDataSetChanged();
  }

  public void a(AccountViewModel paramAccountViewModel)
  {
    this.c = paramAccountViewModel;
    this.b = 2;
    notifyDataSetChanged();
  }

  public void a(b paramb)
  {
    this.a = paramb;
  }

  public void b()
  {
    this.b = 3;
    notifyDataSetChanged();
  }

  public int getItemCount()
  {
    switch (this.b)
    {
    default:
      return 1;
    case 2:
    }
    return 1 + this.c.getPlans().size();
  }

  public int getItemViewType(int paramInt)
  {
    switch (this.b)
    {
    default:
      return 1;
    case 2:
      if (paramInt == this.c.getPlans().size())
        return 5;
      return 4;
    case 3:
    }
    return 3;
  }

  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    switch (getItemViewType(paramInt))
    {
    case 1:
    case 2:
    default:
      return;
    case 3:
      ((c)paramViewHolder).a(this.e);
      return;
    case 5:
      ((a)paramViewHolder).a(this.c.getBalance());
      return;
    case 4:
    }
    ((b)paramViewHolder).a((PlanViewModel)this.c.getPlans().get(paramInt));
  }

  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    case 2:
    default:
      return null;
    case 1:
      return new a(this.d.inflate(R.layout.vo_my_account_balance, paramViewGroup, false), true);
    case 3:
      return new c(this.d.inflate(R.layout.vo_my_account_promotion, paramViewGroup, false), this.a);
    case 4:
      return new b(this.d.inflate(R.layout.vo_my_account_plan_item, paramViewGroup, false), this.a);
    case 5:
    }
    return new a(this.d.inflate(R.layout.vo_my_account_balance, paramViewGroup, false), false);
  }

  static class a extends RecyclerView.ViewHolder
  {
    private final TextView a;
    private final View b;
    private final boolean c;

    a(View paramView, boolean paramBoolean)
    {
      super();
      this.a = ((TextView)paramView.findViewById(R.id.credit_balance_value));
      this.b = paramView.findViewById(R.id.account_progress);
      this.c = paramBoolean;
    }

    public void a(BalanceViewModel paramBalanceViewModel)
    {
      if (this.c)
      {
        dj.b(this.a, false);
        dj.b(this.b, true);
        return;
      }
      dj.b(this.a, true);
      dj.b(this.b, false);
      this.a.setText(paramBalanceViewModel.getFormattedBalance());
      this.a.setTextColor(ContextCompat.getColor(this.itemView.getContext(), paramBalanceViewModel.getBalanceColor()));
    }
  }

  static class b extends RecyclerView.ViewHolder
    implements View.OnClickListener
  {
    private final b a;
    private final TextView b;
    private final ProgressBar c;
    private final TextView d;
    private PlanViewModel e;

    b(View paramView, b paramb)
    {
      super();
      this.a = paramb;
      this.b = ((TextView)paramView.findViewById(R.id.plan_title));
      this.c = ((ProgressBar)paramView.findViewById(R.id.plan_progress));
      this.d = ((TextView)paramView.findViewById(R.id.plan_minutes_left));
      paramView.setOnClickListener(this);
    }

    public void a(PlanViewModel paramPlanViewModel)
    {
      this.e = paramPlanViewModel;
      this.b.setText(paramPlanViewModel.getTitle());
      ProgressBar localProgressBar = this.c;
      Drawable localDrawable;
      int i;
      label75: TextView localTextView2;
      if (paramPlanViewModel.plentyMinutesLeft())
      {
        localDrawable = ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.vo_horizontal_progress_high);
        localProgressBar.setProgressDrawable(localDrawable);
        this.c.setProgress(paramPlanViewModel.getProgress());
        TextView localTextView1 = this.d;
        if (!paramPlanViewModel.isUnlimited())
          break label146;
        i = 8;
        localTextView1.setVisibility(i);
        localTextView2 = this.d;
        if (!paramPlanViewModel.plentyMinutesLeft())
          break label152;
      }
      label146: label152: for (int j = ContextCompat.getColor(this.itemView.getContext(), R.color.progress_high_value); ; j = ContextCompat.getColor(this.itemView.getContext(), R.color.progress_low_value))
      {
        localTextView2.setTextColor(j);
        this.d.setText(paramPlanViewModel.getMinutesLeft());
        return;
        localDrawable = ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.vo_horizontal_progress_low);
        break;
        i = 0;
        break label75;
      }
    }

    public void onClick(View paramView)
    {
      if ((paramView.getId() == R.id.root) && (this.a != null))
        this.a.a(this.e);
    }
  }

  static class c extends RecyclerView.ViewHolder
    implements View.OnClickListener
  {
    private final TextView a;
    private final b b;

    public c(View paramView, b paramb)
    {
      super();
      this.a = ((TextView)paramView.findViewById(R.id.text));
      this.b = paramb;
      paramView.setOnClickListener(this);
    }

    public void a(e parame)
    {
      String str = parame.a();
      if (!da.b(str))
        this.a.setText(str);
    }

    public void onClick(View paramView)
    {
      if (paramView.getId() == R.id.my_account_promo)
        this.b.b();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.account.a
 * JD-Core Version:    0.6.2
 */