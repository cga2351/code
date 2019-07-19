package com.viber.voip.publicaccount.ui.holders.general.create;

import android.text.TextWatcher;
import android.view.View;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.validation.a.d;
import com.viber.voip.validation.a.g;
import com.viber.voip.widget.PublicAccountIdEditText;
import com.viber.voip.widget.TextViewWithIndependentDescription;

class b extends com.viber.voip.publicaccount.ui.holders.general.base.f<GeneralCreateData>
  implements a
{
  private final PublicAccountIdEditText b;
  private TextWatcher c;

  public b(View paramView)
  {
    super(paramView);
    this.a.setIndependentStatusMessage(R.string.public_group_info_data_explanatory_email);
    this.b = ((PublicAccountIdEditText)paramView.findViewById(R.id.id));
  }

  private void c()
  {
    if (this.c != null)
    {
      this.b.b(this.c);
      this.c = null;
    }
  }

  public void a()
  {
    super.a();
    c();
  }

  public void a(TextWatcher paramTextWatcher)
  {
    if (this.c != paramTextWatcher)
    {
      c();
      this.c = paramTextWatcher;
      this.b.a(this.c);
    }
  }

  public void a(GeneralCreateData paramGeneralCreateData)
  {
    super.b(paramGeneralCreateData);
    paramGeneralCreateData.mPublicGroupIdString = this.b.getPublicAccountId();
  }

  public void a(g paramg)
  {
    paramg.a(new d(this.b, paramg));
    paramg.a(new com.viber.voip.validation.a.f(this.b));
  }

  public String b()
  {
    return this.b.getPublicAccountId();
  }

  public void b(String paramString)
  {
    this.b.setText(paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.general.create.b
 * JD-Core Version:    0.6.2
 */