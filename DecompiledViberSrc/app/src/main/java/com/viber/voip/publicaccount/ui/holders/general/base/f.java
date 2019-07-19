package com.viber.voip.publicaccount.ui.holders.general.base;

import android.text.InputFilter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView.OnEditorActionListener;
import com.viber.voip.R.id;
import com.viber.voip.validation.a.a;
import com.viber.voip.validation.a.b;
import com.viber.voip.validation.a.i;
import com.viber.voip.validation.g;
import com.viber.voip.widget.TextViewWithDescription;
import com.viber.voip.widget.TextViewWithIndependentDescription;
import com.viber.voip.widget.ViewWithDescription.a;

public abstract class f<D extends GeneralData>
  implements e<D>
{
  protected final TextViewWithIndependentDescription a;
  private final TextViewWithDescription b;
  private final TextViewWithDescription c;
  private final TextViewWithDescription d;

  public f(View paramView)
  {
    this.b = ((TextViewWithDescription)paramView.findViewById(R.id.about));
    this.c = ((TextViewWithDescription)paramView.findViewById(R.id.location));
    this.d = ((TextViewWithDescription)paramView.findViewById(R.id.website));
    this.a = ((TextViewWithIndependentDescription)paramView.findViewById(R.id.email));
  }

  public void a()
  {
    this.c.setOnClickListener(null);
    this.c.setTryAgainListener(null);
  }

  public void a(InputFilter paramInputFilter, TextView.OnEditorActionListener paramOnEditorActionListener)
  {
    this.b.a(new InputFilter[] { paramInputFilter });
    a(this.b, paramOnEditorActionListener);
  }

  public void a(View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    this.c.setOnClickListener(paramOnClickListener1);
    this.c.setTryAgainListener(paramOnClickListener2);
  }

  public void a(TextView.OnEditorActionListener paramOnEditorActionListener)
  {
    a(this.d, paramOnEditorActionListener);
  }

  public void a(GeneralData paramGeneralData)
  {
    this.b.setText(paramGeneralData.mAbout);
    if (paramGeneralData.mAboutViewState != null)
      this.b.a(paramGeneralData.mAboutViewState);
    this.a.setText(paramGeneralData.mEmail);
    if (paramGeneralData.mEmailViewState != null)
      this.a.a(paramGeneralData.mEmailViewState);
    this.d.setText(paramGeneralData.mWebsite);
    if (paramGeneralData.mWebsiteViewState != null)
      this.d.a(paramGeneralData.mWebsiteViewState);
    this.c.setText(paramGeneralData.mAddress);
    this.c.setStatus(paramGeneralData.mLocationStatus);
  }

  public void a(a parama, i parami, b paramb)
  {
    parama.a(new com.viber.voip.validation.f(this.b, parama));
    parama.a(new g(this.b));
    parami.a(new com.viber.voip.validation.f(this.d, parami));
    parami.a(new g(this.d));
    paramb.a(new com.viber.voip.validation.f(this.a, paramb));
    paramb.a(new g(this.a));
  }

  protected final void a(TextViewWithDescription paramTextViewWithDescription, TextView.OnEditorActionListener paramOnEditorActionListener)
  {
    if (paramOnEditorActionListener != null)
      paramTextViewWithDescription.setOnEditorActionListener(paramOnEditorActionListener);
  }

  public void a(ViewWithDescription.a parama)
  {
    this.c.setStatus(parama);
  }

  public void a(String paramString)
  {
    this.c.setText(paramString);
  }

  public void b(TextView.OnEditorActionListener paramOnEditorActionListener)
  {
    a(this.a, paramOnEditorActionListener);
  }

  public void b(D paramD)
  {
    paramD.mAbout = this.b.getText().toString();
    paramD.mAboutViewState = this.b.getValidationState();
    paramD.mWebsite = this.d.getText().toString();
    paramD.mWebsiteViewState = this.d.getValidationState();
    paramD.mEmail = this.a.getText().toString();
    paramD.mEmailViewState = this.a.getValidationState();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.general.base.f
 * JD-Core Version:    0.6.2
 */