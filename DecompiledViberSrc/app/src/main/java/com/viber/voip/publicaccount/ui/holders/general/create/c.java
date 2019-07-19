package com.viber.voip.publicaccount.ui.holders.general.create;

import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import com.viber.voip.R.integer;
import com.viber.voip.publicaccount.ui.holders.d;
import com.viber.voip.validation.FormValidator.a;
import com.viber.voip.validation.FormValidator.b;
import com.viber.voip.validation.a.g;

public class c extends com.viber.voip.publicaccount.ui.holders.general.base.a<GeneralCreateData, a>
{
  private final TextWatcher h = new TextWatcher()
  {
    public void afterTextChanged(Editable paramAnonymousEditable)
    {
      if (((GeneralCreateData)c.a(c.this)).mIsGroupIdGenerated)
      {
        String str = ((a)c.b(c.this)).b();
        if ((str != null) && (!str.equals(((GeneralCreateData)c.c(c.this)).mPublicGroupIdString)))
          ((GeneralCreateData)c.d(c.this)).mIsGroupIdGenerated = false;
      }
    }

    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
    }

    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
    }
  };

  public c(Fragment paramFragment, d paramd)
  {
    super(paramFragment, paramd, false);
    ((GeneralCreateData)this.a).setMaximalIdLength(this.c.getResources().getInteger(R.integer.public_account_max_id_chars));
  }

  protected void a(a parama, GeneralCreateData paramGeneralCreateData, FormValidator.a parama1)
  {
    super.a(parama, paramGeneralCreateData, parama1);
    ((a)this.b).b(paramGeneralCreateData.mPublicGroupIdString);
    g localg = new g();
    localg.a(this.e);
    localg.a(400L);
    parama.a(localg);
    if (this.f);
    for (FormValidator.b localb = FormValidator.b.b; ; localb = FormValidator.b.a)
    {
      parama1.a(localg, localb);
      return;
    }
  }

  protected Class<a> b()
  {
    return a.class;
  }

  protected a c(View paramView)
  {
    b localb = new b(paramView);
    localb.a(this.h);
    return (a)a(localb);
  }

  protected GeneralCreateData j()
  {
    return new GeneralCreateData();
  }

  public boolean k()
  {
    return ((GeneralCreateData)this.a).mIsGroupIdGenerated;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.general.create.c
 * JD-Core Version:    0.6.2
 */