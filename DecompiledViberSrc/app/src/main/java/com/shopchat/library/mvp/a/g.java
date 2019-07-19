package com.shopchat.library.mvp.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.shopchat.library.R.layout;
import com.shopchat.library.mvp.models.BrandModel.Category;

class g extends b<h, BrandModel.Category>
{
  private a<BrandModel.Category> a;
  private LayoutInflater b;

  g(Context paramContext, a<BrandModel.Category> parama)
  {
    this.a = parama;
    this.b = LayoutInflater.from(paramContext);
  }

  h a(ViewGroup paramViewGroup)
  {
    return new h(this.b.inflate(R.layout.categories_list_item, paramViewGroup, false));
  }

  void a(h paramh, BrandModel.Category paramCategory)
  {
    paramh.a(paramCategory);
    paramh.a(this.a);
    paramh.c.setText(paramCategory.getName());
    paramh.c.setTag(paramCategory.getId());
    paramh.c.setSelected(paramCategory.isSelected());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.shopchat.library.mvp.a.g
 * JD-Core Version:    0.6.2
 */