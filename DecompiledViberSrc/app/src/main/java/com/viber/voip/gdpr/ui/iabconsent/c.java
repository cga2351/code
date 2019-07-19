package com.viber.voip.gdpr.ui.iabconsent;

import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.mvp.core.d;
import com.viber.voip.mvp.core.j;
import com.viber.voip.util.dj;

public class c extends d<AllConsentPresenter>
  implements View.OnClickListener, j
{
  private final TextView a;
  private final TextView b;
  private final Button c;

  protected c(AllConsentPresenter paramAllConsentPresenter, View paramView)
  {
    super(paramAllConsentPresenter, paramView);
    this.a = ((TextView)paramView.findViewById(R.id.body));
    this.a.setText(Html.fromHtml(this.a.getText().toString()));
    this.a.setMovementMethod(LinkMovementMethod.getInstance());
    this.c = ((Button)paramView.findViewById(R.id.allow_btn));
    this.c.setOnClickListener(this);
    this.b = ((TextView)paramView.findViewById(R.id.manage_ads_btn));
    dj.a(this.b, true);
    this.b.setOnClickListener(this);
  }

  public boolean onBackPressed()
  {
    return true;
  }

  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == R.id.allow_btn)
      ((AllConsentPresenter)this.mPresenter).a();
    while (i != R.id.manage_ads_btn)
      return;
    ((AllConsentPresenter)this.mPresenter).b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gdpr.ui.iabconsent.c
 * JD-Core Version:    0.6.2
 */