package com.viber.voip.viberout.ui.products.search.country;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AutoCompleteTextView;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.ui.ad;
import com.viber.voip.util.dj;
import com.viber.voip.util.u;
import com.viber.voip.viberout.ui.products.model.CountryModel;
import java.util.List;

public abstract class c extends com.viber.voip.mvp.core.d<ViberOutCountrySearchPresenter>
  implements b
{
  private final a a;
  private final AutoCompleteTextView b;
  private final View c;
  private final Resources d;

  protected c(ViberOutCountrySearchPresenter paramViberOutCountrySearchPresenter, View paramView, String paramString, LayoutInflater paramLayoutInflater)
  {
    super(paramViberOutCountrySearchPresenter, paramView);
    this.b = ((AutoCompleteTextView)paramView.findViewById(R.id.search_edit));
    this.c = paramView.findViewById(R.id.clear_btn);
    this.d = this.b.getResources();
    Context localContext = paramView.getContext();
    this.a = new a(localContext, com.viber.voip.util.e.e.a(localContext), paramLayoutInflater);
    if (paramString != null)
    {
      this.b.setText(paramString);
      ((ViberOutCountrySearchPresenter)this.mPresenter).a(paramString);
      dj.b(this.c, true);
    }
    this.b.setAdapter(this.a);
    this.b.setImeOptions(268435462);
    this.b.setDropDownAnchor(paramView.getId());
    this.b.setOnItemClickListener(new d(this));
    if (com.viber.common.d.a.b())
      this.b.setOnDismissListener(new e(this));
    this.b.setOnClickListener(new f(this));
    this.b.setOnFocusChangeListener(new g(this));
    this.b.addTextChangedListener(new ad()
    {
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        ((ViberOutCountrySearchPresenter)c.a(c.this)).a(paramAnonymousCharSequence);
        if (TextUtils.isEmpty(paramAnonymousCharSequence))
        {
          dj.b(c.b(c.this), false);
          return;
        }
        dj.b(c.b(c.this), true);
      }
    });
    this.c.setOnClickListener(new h(this));
  }

  public void a()
  {
    this.a.b();
  }

  public void a(List<CountryModel> paramList, CharSequence paramCharSequence)
  {
    if (TextUtils.isEmpty(paramCharSequence))
      this.a.a(paramList);
    while (true)
    {
      this.b.showDropDown();
      return;
      if (!u.a(paramList))
        this.a.a(paramList, paramCharSequence);
    }
  }

  public void b()
  {
    this.a.a(this.d.getString(R.string.vo_search_no_matches));
    this.a.a();
  }

  public boolean onBackPressed()
  {
    if (this.b.hasFocus())
    {
      this.b.clearFocus();
      return true;
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.search.country.c
 * JD-Core Version:    0.6.2
 */