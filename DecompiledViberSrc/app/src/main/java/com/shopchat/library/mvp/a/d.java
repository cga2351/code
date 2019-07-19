package com.shopchat.library.mvp.a;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopchat.library.R.layout;
import com.shopchat.library.mvp.models.BrandModel;
import com.shopchat.library.mvp.models.BrandModel.BrandType;
import com.shopchat.library.mvp.models.BrandModel.Highlight;
import com.shopchat.library.mvp.models.ColorModel;
import com.shopchat.library.util.f;

class d extends b<e, BrandModel>
{
  private final Context a;
  private final a<BrandModel> b;
  private final LayoutInflater c;

  public d(Context paramContext, a<BrandModel> parama)
  {
    this.a = paramContext;
    this.b = parama;
    this.c = LayoutInflater.from(this.a);
  }

  e a(ViewGroup paramViewGroup)
  {
    return new e(this.c.inflate(R.layout.brands_list_item, paramViewGroup, false));
  }

  void a(e parame, BrandModel paramBrandModel)
  {
    parame.a(paramBrandModel);
    parame.a(this.b);
    if (paramBrandModel.getBrandType() == BrandModel.BrandType.NORMAL)
      com.shopchat.library.util.d.a(this.a).a(paramBrandModel.getLogo(), parame.d, null);
    com.viber.common.ui.a.b localb = new com.viber.common.ui.a.b();
    localb.b(paramBrandModel.getBackgroundColor().getColor());
    ShapeDrawable localShapeDrawable = new ShapeDrawable(localb);
    parame.c.setBackground(localShapeDrawable);
    BrandModel.Highlight localHighlight = paramBrandModel.getHighlight();
    if ((localHighlight != null) && (localHighlight.isVisible()))
    {
      parame.e.setVisibility(0);
      int i = localHighlight.getColor().getColor();
      GradientDrawable localGradientDrawable = (GradientDrawable)parame.e.getBackground();
      localGradientDrawable.setColor(i);
      localGradientDrawable.setStroke(f.a(this.a, 1.0F), i);
      String str = localHighlight.getMessage().toUpperCase().trim();
      parame.e.setText(str);
      return;
    }
    parame.e.setVisibility(4);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.shopchat.library.mvp.a.d
 * JD-Core Version:    0.6.2
 */