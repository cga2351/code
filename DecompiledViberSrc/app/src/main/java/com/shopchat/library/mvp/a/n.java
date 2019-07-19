package com.shopchat.library.mvp.a;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
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
import com.viber.common.ui.ShapeImageView;
import com.viber.common.ui.a.c;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

class n extends b<o, ProductModel>
{
  private final Context a;
  private final a<ProductModel> b;
  private final DecimalFormat c;
  private final LayoutInflater d;

  n(Context paramContext, a<ProductModel> parama, Locale paramLocale)
  {
    this.a = paramContext;
    this.b = parama;
    this.c = ((DecimalFormat)NumberFormat.getCurrencyInstance(paramLocale));
    this.c.setDecimalSeparatorAlwaysShown(true);
    this.d = LayoutInflater.from(this.a);
  }

  o a(ViewGroup paramViewGroup)
  {
    o localo = new o(this.d.inflate(R.layout.products_list_item, paramViewGroup, false));
    int i = f.a(this.a, 4.0F);
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new com.viber.common.ui.a.a(i, 15, f.a(this.a, 0.5F)));
    localShapeDrawable.getPaint().setColor(f.a(this.a, R.attr.sc__productImageBorderColor));
    localo.c.setForegroundDrawable(localShapeDrawable);
    localo.c.setBackground(new ShapeDrawable(new c(-1, i)));
    return localo;
  }

  void a(final o paramo, ProductModel paramProductModel)
  {
    paramo.a(paramProductModel);
    paramo.a(this.b);
    paramo.f.setVisibility(0);
    d.a(this.a).a(paramProductModel.getImageUrlShort(), paramo.c, 2, new d.a()
    {
      public void a()
      {
        paramo.f.setVisibility(4);
      }
    });
    paramo.e.setText(paramProductModel.getTitle());
    paramo.d.setText(this.c.format(paramProductModel.getPrice()));
    if (paramProductModel.isSale())
    {
      paramo.d.setTextColor(f.a(this.a, R.attr.sc__productSalePriceTextColor));
      paramo.g.setVisibility(0);
      return;
    }
    paramo.d.setTextColor(f.a(this.a, R.attr.sc__productPriceTextColor));
    paramo.g.setVisibility(4);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.shopchat.library.mvp.a.n
 * JD-Core Version:    0.6.2
 */