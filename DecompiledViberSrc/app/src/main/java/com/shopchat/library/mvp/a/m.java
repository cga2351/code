package com.shopchat.library.mvp.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.ViewGroup;
import com.shopchat.library.mvp.models.ProductModel;
import java.util.List;
import java.util.Locale;

public class m extends RecyclerView.Adapter<l>
{
  private List<ProductModel> a;
  private k b;

  public m(Context paramContext, Locale paramLocale, List<ProductModel> paramList, j paramj)
  {
    this.a = paramList;
    this.b = new k(paramContext, paramLocale, paramj);
  }

  public int a(int paramInt)
  {
    int i = this.a.size();
    if (i > 1)
    {
      if (paramInt < 1)
        paramInt = i - 1;
    }
    else
      return paramInt;
    if (paramInt >= i + 1)
      return 0;
    return paramInt - 1;
  }

  public l a(ViewGroup paramViewGroup, int paramInt)
  {
    return this.b.a(paramViewGroup);
  }

  public void a(l paraml, int paramInt)
  {
    ProductModel localProductModel = (ProductModel)this.a.get(a(paramInt));
    this.b.a(paraml, localProductModel);
  }

  public int b(int paramInt)
  {
    if (this.a.size() > 1)
      paramInt++;
    return paramInt;
  }

  public int getItemCount()
  {
    int i = this.a.size();
    if (i > 1)
      i += 2;
    return i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.shopchat.library.mvp.a.m
 * JD-Core Version:    0.6.2
 */