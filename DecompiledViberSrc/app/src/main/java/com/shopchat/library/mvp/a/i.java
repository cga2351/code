package com.shopchat.library.mvp.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.ViewGroup;
import com.shopchat.library.mvp.models.BrandModel.Category;
import java.util.List;

public class i extends RecyclerView.Adapter<h>
{
  private final List<BrandModel.Category> a;
  private final g b;

  public i(Context paramContext, List<BrandModel.Category> paramList, a<BrandModel.Category> parama)
  {
    this.a = paramList;
    this.b = new g(paramContext, parama);
  }

  public h a(ViewGroup paramViewGroup, int paramInt)
  {
    return this.b.a(paramViewGroup);
  }

  public void a(int paramInt)
  {
    int i = 0;
    if (i < this.a.size())
    {
      BrandModel.Category localCategory = (BrandModel.Category)this.a.get(i);
      if (i == paramInt);
      for (boolean bool = true; ; bool = false)
      {
        if (localCategory.isSelected() != bool)
        {
          localCategory.setSelected(bool);
          notifyItemChanged(paramInt);
        }
        i++;
        break;
      }
    }
  }

  public void a(h paramh, int paramInt)
  {
    BrandModel.Category localCategory = (BrandModel.Category)this.a.get(paramInt);
    this.b.a(paramh, localCategory);
  }

  public int getItemCount()
  {
    return this.a.size();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.shopchat.library.mvp.a.i
 * JD-Core Version:    0.6.2
 */