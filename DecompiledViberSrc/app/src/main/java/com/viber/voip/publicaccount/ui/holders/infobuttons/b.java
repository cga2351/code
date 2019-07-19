package com.viber.voip.publicaccount.ui.holders.infobuttons;

import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;

class b
  implements a
{
  e a;
  f b;
  private final InfoButtonView c;
  private final InfoButtonView d;
  private final InfoButtonView e;
  private final InfoButtonView f;
  private final View g;
  private boolean h;
  private int i;
  private int j;
  private int k;
  private int l;

  public b(View paramView, View.OnClickListener paramOnClickListener)
  {
    this.g = paramView.findViewById(R.id.info_buttons_container);
    this.c = ((InfoButtonView)paramView.findViewById(R.id.message_btn));
    this.c.setIcon(R.drawable.ic_pa_info_btn_message);
    this.c.setOnClickListener(paramOnClickListener);
    this.d = ((InfoButtonView)paramView.findViewById(R.id.public_chat_btn));
    this.d.setIcon(R.drawable.ic_pa_info_btn_public_chat);
    this.d.setText(R.string.public_account_info_button_public_chat);
    this.d.setOnClickListener(paramOnClickListener);
    this.e = ((InfoButtonView)paramView.findViewById(R.id.joker_1_btn));
    this.e.setTextUnderlined(true);
    this.e.setOnClickListener(paramOnClickListener);
    this.f = ((InfoButtonView)paramView.findViewById(R.id.edit_info_btn));
    this.f.setIcon(R.drawable.ic_pa_info_btn_edit_info);
    this.f.setText(R.string.public_account_info_button_edit_info);
    this.f.setOnClickListener(paramOnClickListener);
    Resources localResources = paramView.getResources();
    this.i = localResources.getDimensionPixelSize(R.dimen.public_account_info_button_horizontal_margin);
    this.j = localResources.getDimensionPixelSize(R.dimen.public_account_info_button_fill_width_horizontal_margin);
    this.k = localResources.getDimensionPixelSize(R.dimen.public_account_info_button_icon_bottom_margin);
    this.l = localResources.getDimensionPixelSize(R.dimen.public_account_info_button_fill_width_icon_right_margin);
    this.a = e.a(paramView.getContext());
    this.b = f.e();
  }

  private void a(InfoButtonView paramInfoButtonView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramInfoButtonView.setGravity(16);
      paramInfoButtonView.setOrientation(0);
      paramInfoButtonView.a(this.j, 0, this.l, 0);
      paramInfoButtonView.b(0, 0, this.j, 0);
      return;
    }
    paramInfoButtonView.setGravity(17);
    paramInfoButtonView.setOrientation(1);
    paramInfoButtonView.a(0, 0, 0, this.k);
    paramInfoButtonView.b(this.i, 0, this.i, 0);
  }

  private void d()
  {
    if ((this.c.getVisibility() == 0) || (this.d.getVisibility() == 0) || (this.e.getVisibility() == 0) || (this.f.getVisibility() == 0));
    for (boolean bool = true; ; bool = false)
    {
      dj.b(this.g, bool);
      return;
    }
  }

  public void a()
  {
    this.c.setOnClickListener(null);
    this.d.setOnClickListener(null);
    this.f.setOnClickListener(null);
  }

  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    InfoButtonView localInfoButtonView = this.e;
    if (!TextUtils.isEmpty(paramString1));
    for (Uri localUri = Uri.parse(paramString1); ; localUri = null)
    {
      localInfoButtonView.a(localUri, this.a, this.b);
      this.e.setText(paramString2);
      dj.b(this.e, true);
      a(this.e, paramBoolean);
      d();
      return;
    }
  }

  public void a(boolean paramBoolean)
  {
    this.c.setId(R.id.message_btn);
    this.c.setText(R.string.message);
    a(this.c, paramBoolean);
    dj.b(this.c, true);
    d();
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    dj.b(this.f, paramBoolean1);
    a(this.f, paramBoolean2);
    d();
  }

  public void b()
  {
    dj.b(this.c, false);
    d();
  }

  public void b(boolean paramBoolean)
  {
    this.c.setId(R.id.pa_info_setup_inbox_btn);
    this.c.setText(R.string.message);
    a(this.c, paramBoolean);
    dj.b(this.c, true);
    d();
  }

  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (this.h != paramBoolean2))
    {
      this.h = paramBoolean2;
      a(this.d, paramBoolean2);
    }
    dj.b(this.d, paramBoolean1);
    d();
  }

  public void c()
  {
    dj.b(this.e, false);
    d();
  }

  public void c(boolean paramBoolean)
  {
    this.f.setEnabled(paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.infobuttons.b
 * JD-Core Version:    0.6.2
 */