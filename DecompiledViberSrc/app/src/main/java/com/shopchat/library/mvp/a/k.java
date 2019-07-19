package com.shopchat.library.mvp.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.shopchat.library.R.attr;
import com.shopchat.library.R.layout;
import com.shopchat.library.mvp.models.ProductModel;
import com.shopchat.library.util.d;
import com.shopchat.library.util.d.a;
import com.shopchat.library.util.f;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

class k extends b<l, ProductModel>
{
  private final Context a;
  private final j b;
  private final DecimalFormat c;
  private final LayoutInflater d;

  k(Context paramContext, Locale paramLocale, j paramj)
  {
    this.a = paramContext;
    this.b = paramj;
    this.c = ((DecimalFormat)NumberFormat.getCurrencyInstance(paramLocale));
    this.c.setDecimalSeparatorAlwaysShown(true);
    this.d = LayoutInflater.from(paramContext);
  }

  l a(ViewGroup paramViewGroup)
  {
    return new l(this.d.inflate(R.layout.product_details_list_item, paramViewGroup, false));
  }

  void a(final l paraml, ProductModel paramProductModel)
  {
    paraml.a(paramProductModel);
    paraml.a(this.b);
    paraml.h.setVisibility(0);
    d.a(this.a).a(paramProductModel.getImageUrlShort(), paraml.g, 2, new d.a()
    {
      public void a()
      {
        paraml.h.setVisibility(8);
      }
    });
    paraml.c.setText(paramProductModel.getTitle());
    paraml.d.setText(this.c.format(paramProductModel.getPrice()));
    paraml.e.setText(paramProductModel.getDescription());
    if (paramProductModel.isSale())
    {
      paraml.d.setTextColor(f.a(this.a, R.attr.sc__productSalePriceTextColor));
      paraml.f.setVisibility(0);
      return;
    }
    paraml.d.setTextColor(f.a(this.a, R.attr.sc__productPriceTextColor));
    paraml.f.setVisibility(8);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.shopchat.library.mvp.a.k
 * JD-Core Version:    0.6.2
 */