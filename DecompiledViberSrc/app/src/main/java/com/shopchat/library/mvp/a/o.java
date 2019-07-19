package com.shopchat.library.mvp.a;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.shopchat.library.R.id;
import com.shopchat.library.mvp.models.ProductModel;
import com.viber.common.ui.ShapeImageView;

class o extends c<ProductModel, a<ProductModel>>
{
  final ShapeImageView c;
  final TextView d;
  final TextView e;
  final ProgressBar f;
  final TextView g;

  o(View paramView)
  {
    super(paramView);
    this.c = ((ShapeImageView)paramView.findViewById(R.id.productImage));
    this.d = ((TextView)paramView.findViewById(R.id.productPrice));
    this.e = ((TextView)paramView.findViewById(R.id.productTitle));
    this.f = ((ProgressBar)paramView.findViewById(R.id.progressBar));
    this.g = ((TextView)paramView.findViewById(R.id.saleBadge));
    paramView.setOnClickListener(this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.shopchat.library.mvp.a.o
 * JD-Core Version:    0.6.2
 */