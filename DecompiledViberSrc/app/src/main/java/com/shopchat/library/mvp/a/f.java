package com.shopchat.library.mvp.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.ViewGroup;
import com.shopchat.library.events.BrandClicked;
import com.shopchat.library.mvp.models.BrandModel;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

public class f extends RecyclerView.Adapter<e>
{
  private final Context a;
  private final List<BrandModel> b;
  private final d c;

  public f(Context paramContext, List<BrandModel> paramList)
  {
    this.a = paramContext;
    this.b = paramList;
    this.c = new d(this.a, new a()
    {
      public void a(int paramAnonymousInt, BrandModel paramAnonymousBrandModel)
      {
        com.shopchat.library.util.a.a().post(new BrandClicked(paramAnonymousBrandModel, paramAnonymousInt));
      }
    });
  }

  public e a(ViewGroup paramViewGroup, int paramInt)
  {
    return this.c.a(paramViewGroup);
  }

  public void a(e parame, int paramInt)
  {
    BrandModel localBrandModel = (BrandModel)this.b.get(paramInt);
    this.c.a(parame, localBrandModel);
  }

  public int getItemCount()
  {
    return this.b.size();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.shopchat.library.mvp.a.f
 * JD-Core Version:    0.6.2
 */