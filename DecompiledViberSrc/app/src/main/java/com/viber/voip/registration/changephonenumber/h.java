package com.viber.voip.registration.changephonenumber;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.m;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.ui.dialogs.a;
import com.viber.voip.util.cg;

public class h
{
  private Context a;
  private View b;
  private View c;
  private View d;
  private View e;
  private View f;
  private TextView g;
  private m h;

  public h(Context paramContext)
  {
    this.a = paramContext;
  }

  private String a(String paramString)
  {
    return this.a.getString(R.string.change_phone_number_success_dialog_subtitle, new Object[] { paramString });
  }

  public void a()
  {
    if (this.h != null)
      this.h.dismiss();
  }

  public void a(Activity paramActivity)
  {
    a.n().a(paramActivity).a(paramActivity);
  }

  void a(m paramm, View paramView)
  {
    if ((paramm == null) || (paramView == null))
      return;
    this.h = paramm;
    this.b = paramView.findViewById(R.id.progress_indicator);
    this.c = paramView.findViewById(R.id.changing_phone_number_title);
    this.d = paramView.findViewById(R.id.changing_phone_number_msg);
    this.e = paramView.findViewById(R.id.success_icon);
    this.f = paramView.findViewById(R.id.success_title);
    this.g = ((TextView)paramView.findViewById(R.id.success_msg));
  }

  void a(PhoneNumberInfo paramPhoneNumberInfo)
  {
    if (this.h == null)
      return;
    this.b.setVisibility(8);
    this.c.setVisibility(8);
    this.d.setVisibility(8);
    this.e.setVisibility(0);
    this.f.setVisibility(0);
    this.g.setVisibility(0);
    String str = cg.a(this.a, paramPhoneNumberInfo.getCountyIddCode(), paramPhoneNumberInfo.phoneNumber, paramPhoneNumberInfo.canonizedPhoneNumber);
    this.g.setText(Html.fromHtml(a(str)));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.changephonenumber.h
 * JD-Core Version:    0.6.2
 */