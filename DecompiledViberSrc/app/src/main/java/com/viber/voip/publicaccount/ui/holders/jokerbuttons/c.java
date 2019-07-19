package com.viber.voip.publicaccount.ui.holders.jokerbuttons;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.viber.voip.R.id;
import com.viber.voip.publicaccount.entity.PublicAccount.ExtraInfo.JokerButton;
import com.viber.voip.publicaccount.ui.holders.numbers.NumberView;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;

class c
  implements b
{
  e a;
  f b;
  private final NumberView c;
  private final NumberView d;
  private final NumberView e;
  private final View f;
  private final View g;
  private final View h;

  public c(View paramView, View.OnClickListener paramOnClickListener)
  {
    this.c = ((NumberView)paramView.findViewById(R.id.joker_button_2));
    this.c.setOnClickListener(paramOnClickListener);
    this.d = ((NumberView)paramView.findViewById(R.id.joker_button_3));
    this.d.setOnClickListener(paramOnClickListener);
    this.e = ((NumberView)paramView.findViewById(R.id.joker_button_4));
    this.e.setOnClickListener(paramOnClickListener);
    this.f = paramView.findViewById(R.id.joker_buttons_divider_0);
    this.g = paramView.findViewById(R.id.joker_buttons_divider_1);
    this.h = paramView.findViewById(R.id.joker_buttons_divider_2);
    this.a = e.a(paramView.getContext());
    this.b = f.e();
  }

  private void a(PublicAccount.ExtraInfo.JokerButton paramJokerButton, NumberView paramNumberView, View paramView)
  {
    if (paramJokerButton != null)
    {
      String str = paramJokerButton.getIconUrl();
      if (!TextUtils.isEmpty(str));
      for (Uri localUri = Uri.parse(str); ; localUri = null)
      {
        paramNumberView.a(localUri, this.a, this.b);
        paramNumberView.setText(paramJokerButton.getButtonText());
        dj.b(paramNumberView, true);
        dj.b(paramView, true);
        return;
      }
    }
    dj.b(paramNumberView, false);
    dj.b(paramView, false);
  }

  public void a()
  {
  }

  public void a(PublicAccount.ExtraInfo.JokerButton paramJokerButton1, PublicAccount.ExtraInfo.JokerButton paramJokerButton2, PublicAccount.ExtraInfo.JokerButton paramJokerButton3)
  {
    a(paramJokerButton1, this.c, this.f);
    a(paramJokerButton2, this.d, this.g);
    a(paramJokerButton3, this.e, this.h);
  }

  public void b()
  {
    a(null, null, null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.jokerbuttons.c
 * JD-Core Version:    0.6.2
 */