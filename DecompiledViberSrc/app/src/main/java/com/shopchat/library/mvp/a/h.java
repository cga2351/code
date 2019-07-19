package com.shopchat.library.mvp.a;

import android.view.View;
import android.widget.TextView;
import com.shopchat.library.R.id;
import com.shopchat.library.mvp.models.BrandModel.Category;

class h extends c<BrandModel.Category, a<BrandModel.Category>>
{
  TextView c;

  h(View paramView)
  {
    super(paramView);
    this.c = ((TextView)paramView.findViewById(R.id.categoryName));
    this.c.setOnClickListener(this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.shopchat.library.mvp.a.h
 * JD-Core Version:    0.6.2
 */