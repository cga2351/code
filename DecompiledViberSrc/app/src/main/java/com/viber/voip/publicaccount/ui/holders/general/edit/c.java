package com.viber.voip.publicaccount.ui.holders.general.edit;

import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import com.viber.voip.publicaccount.ui.holders.d;
import com.viber.voip.validation.FormValidator.a;

public class c extends com.viber.voip.publicaccount.ui.holders.general.base.a<GeneralEditData, a>
{
  private final TextWatcher h = new TextWatcher()
  {
    public void afterTextChanged(Editable paramAnonymousEditable)
    {
    }

    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
    }

    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      c.a(c.this);
    }
  };

  public c(Fragment paramFragment, d paramd)
  {
    super(paramFragment, paramd, true);
  }

  protected void a(a parama, GeneralEditData paramGeneralEditData, FormValidator.a parama1)
  {
    super.a(parama, paramGeneralEditData, parama1);
    if (paramGeneralEditData.mTags != null);
    for (String[] arrayOfString = paramGeneralEditData.mTags; ; arrayOfString = new String[0])
    {
      parama.a(arrayOfString);
      return;
    }
  }

  protected Class<a> b()
  {
    return a.class;
  }

  protected a c(View paramView)
  {
    return (a)a(new b(paramView, this.h, this.g));
  }

  protected GeneralEditData j()
  {
    return new GeneralEditData();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.general.edit.c
 * JD-Core Version:    0.6.2
 */