package com.viber.voip.messages.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import com.viber.common.ui.c.b;
import com.viber.voip.R.dimen;
import com.viber.voip.R.string;

public class am extends e
{
  private ai e;

  public am(Context paramContext, ViewGroup paramViewGroup, View paramView, ai paramai)
  {
    super(paramContext, paramViewGroup, paramView);
    this.e = paramai;
  }

  private c.b e()
  {
    SpannableString localSpannableString = SpannableString.valueOf(this.a.getString(R.string.ivm_heart_shape_promotion_tooltip));
    this.e.a(localSpannableString, aj.c);
    return new c.b().a(com.viber.common.d.c.a(localSpannableString)).a(5).i(this.a.getResources().getDimensionPixelSize(R.dimen.record_message_hold_to_record_tooltip_max_width)).a(this.c);
  }

  protected com.viber.common.ui.c a(Resources paramResources)
  {
    return e().a(this.a);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.am
 * JD-Core Version:    0.6.2
 */