package com.shopchat.library.mvp.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.ViewGroup;
import com.shopchat.library.events.ProductClicked;
import com.shopchat.library.mvp.models.ProductModel;
import java.util.List;
import java.util.Locale;
import org.greenrobot.eventbus.EventBus;

public class p extends RecyclerView.Adapter<o>
  implements a<ProductModel>
{
  private List<ProductModel> a;
  private final n b;

  public p(Context paramContext, List<ProductModel> paramList, Locale paramLocale)
  {
    this.a = paramList;
    this.b = new n(paramContext, new a()
    {
      public void a(int paramAnonymousInt, ProductModel paramAnonymousProductModel)
      {
        com.shopchat.library.util.a.a().post(new ProductClicked(p.a(p.this), paramAnonymousInt));
      }
    }
    , paramLocale);
  }

  public o a(ViewGroup paramViewGroup, int paramInt)
  {
    return this.b.a(paramViewGroup);
  }

  public void a(int paramInt, ProductModel paramProductModel)
  {
    com.shopchat.library.util.a.a().post(new ProductClicked(this.a, paramInt));
  }

  public void a(o paramo, int paramInt)
  {
    ProductModel localProductModel = (ProductModel)this.a.get(paramInt);
    this.b.a(paramo, localProductModel);
  }

  public void a(List<ProductModel> paramList)
  {
    this.a = paramList;
  }

  public int getItemCount()
  {
    return this.a.size();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.shopchat.library.mvp.a.p
 * JD-Core Version:    0.6.2
 */