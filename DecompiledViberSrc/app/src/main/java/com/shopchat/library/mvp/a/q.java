package com.shopchat.library.mvp.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.shopchat.library.R.layout;
import com.shopchat.library.events.RecommendedProductClicked;
import com.shopchat.library.mvp.models.ProductModel;
import java.util.List;
import java.util.Locale;
import org.greenrobot.eventbus.EventBus;

public class q extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private final List<ProductModel> a;
  private final n b;
  private final LayoutInflater c;

  public q(Context paramContext, List<ProductModel> paramList, Locale paramLocale)
  {
    this.a = paramList;
    this.b = new n(paramContext, new a()
    {
      public void a(int paramAnonymousInt, ProductModel paramAnonymousProductModel)
      {
        com.shopchat.library.util.a.a().post(new RecommendedProductClicked(q.a(q.this), paramAnonymousInt - 1));
      }
    }
    , paramLocale);
    this.c = LayoutInflater.from(paramContext);
  }

  public int a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
      return paramInt1;
    return 1;
  }

  public int getItemCount()
  {
    int i = this.a.size();
    if (i > 0)
      return i + 1;
    return 0;
  }

  public int getItemViewType(int paramInt)
  {
    if (paramInt == 0)
      return b.a.ordinal();
    return b.b.ordinal();
  }

  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof o))
    {
      ProductModel localProductModel = (ProductModel)this.a.get(paramInt - 1);
      this.b.a((o)paramViewHolder, localProductModel);
    }
  }

  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (b.a.ordinal() == paramInt)
      return new a(this.c.inflate(R.layout.recommended_products_list_header, paramViewGroup, false));
    if (b.b.ordinal() == paramInt)
      return this.b.a(paramViewGroup);
    return null;
  }

  class a extends RecyclerView.ViewHolder
  {
    a(View arg2)
    {
      super();
    }
  }

  static enum b
  {
    static
    {
      b[] arrayOfb = new b[2];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.shopchat.library.mvp.a.q
 * JD-Core Version:    0.6.2
 */