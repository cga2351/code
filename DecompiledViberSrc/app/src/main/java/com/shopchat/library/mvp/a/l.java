package com.shopchat.library.mvp.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.shopchat.library.R.id;
import com.shopchat.library.mvp.models.ProductModel;

class l extends c<ProductModel, j>
{
  TextView c;
  TextView d;
  TextView e;
  TextView f;
  ImageView g;
  ProgressBar h;
  final TextView i;
  final TextView j;

  l(View paramView)
  {
    super(paramView);
    this.c = ((TextView)paramView.findViewById(R.id.productTitle));
    this.d = ((TextView)paramView.findViewById(R.id.productPrice));
    this.e = ((TextView)paramView.findViewById(R.id.productDescription));
    this.i = ((TextView)paramView.findViewById(R.id.share));
    this.j = ((TextView)paramView.findViewById(R.id.shop));
    this.f = ((TextView)paramView.findViewById(R.id.saleBadge));
    this.g = ((ImageView)paramView.findViewById(R.id.productDetailsImage));
    this.h = ((ProgressBar)paramView.findViewById(R.id.progressBar));
    this.i.setOnClickListener(this);
    this.j.setOnClickListener(this);
  }

  public void onClick(View paramView)
  {
    if ((this.b == null) || (this.a == null))
      return;
    int k = paramView.getId();
    if (R.id.share == k)
    {
      ((j)this.b).a((ProductModel)this.a);
      return;
    }
    if (R.id.shop == k)
    {
      ((j)this.b).b((ProductModel)this.a);
      return;
    }
    super.onClick(paramView);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.shopchat.library.mvp.a.l
 * JD-Core Version:    0.6.2
 */