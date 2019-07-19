package com.shopchat.library.mvp.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopchat.library.R.id;
import com.shopchat.library.mvp.models.BrandModel;

class e extends c<BrandModel, a<BrandModel>>
{
  final ImageView c;
  final ImageView d;
  final TextView e;

  e(View paramView)
  {
    super(paramView);
    this.c = ((ImageView)paramView.findViewById(R.id.brandImageBackground));
    this.d = ((ImageView)paramView.findViewById(R.id.brandImage));
    this.e = ((TextView)paramView.findViewById(R.id.brandBadge));
    paramView.setOnClickListener(this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.shopchat.library.mvp.a.e
 * JD-Core Version:    0.6.2
 */