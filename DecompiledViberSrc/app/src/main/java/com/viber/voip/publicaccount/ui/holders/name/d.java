package com.viber.voip.publicaccount.ui.holders.name;

import android.text.InputFilter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView.OnEditorActionListener;
import com.viber.voip.R.id;
import com.viber.voip.util.dj;
import com.viber.voip.validation.a.h;
import com.viber.voip.validation.f;
import com.viber.voip.validation.g;
import com.viber.voip.widget.TextViewWithDescription;
import com.viber.voip.widget.TextViewWithDescription.a;
import com.viber.voip.widget.ViewWithDescription.ValidationState;
import com.viber.voip.widget.ViewWithDescription.a;
import com.viber.voip.widget.ae;

class d
  implements c
{
  private final TextViewWithDescription a;
  private final TextViewWithDescription b;
  private final TextViewWithDescription c;

  public d(View paramView)
  {
    this.a = ((TextViewWithDescription)paramView.findViewById(R.id.name));
    this.b = ((TextViewWithDescription)paramView.findViewById(R.id.category));
    this.c = ((TextViewWithDescription)paramView.findViewById(R.id.subcategory));
  }

  public void a()
  {
    this.b.setOnTextChangedListener(null);
    this.b.setOnClickListener(null);
    this.c.setOnTextChangedListener(null);
    this.c.setOnClickListener(null);
  }

  public void a(InputFilter paramInputFilter, TextView.OnEditorActionListener paramOnEditorActionListener)
  {
    this.a.a(new InputFilter[] { paramInputFilter });
    if (paramOnEditorActionListener != null)
      this.a.setOnEditorActionListener(paramOnEditorActionListener);
  }

  public void a(NameAndCategoryData paramNameAndCategoryData)
  {
    paramNameAndCategoryData.mName = this.a.getText().toString();
    paramNameAndCategoryData.mNameViewState = this.a.getValidationState();
  }

  public void a(h paramh)
  {
    paramh.a(new f(this.a, paramh));
    paramh.a(new g(this.a));
  }

  public void a(TextViewWithDescription.a parama, View.OnClickListener paramOnClickListener)
  {
    this.b.setOnTextChangedListener(parama);
    this.b.setOnClickListener(paramOnClickListener);
  }

  public void a(ViewWithDescription.a parama)
  {
    this.b.setStatus(parama);
  }

  public void a(String paramString)
  {
    this.b.setText(paramString);
  }

  public void a(String paramString, ViewWithDescription.ValidationState paramValidationState)
  {
    this.a.setText(paramString);
    if (paramValidationState != null)
      this.a.a(paramValidationState);
  }

  public void a(boolean paramBoolean)
  {
    this.c.setEnabled(paramBoolean);
  }

  public void b()
  {
    if (this.a.getEditText().isFocused())
      dj.a(this.a.getEditText(), true);
  }

  public void b(TextViewWithDescription.a parama, View.OnClickListener paramOnClickListener)
  {
    this.c.setOnTextChangedListener(parama);
    this.c.setOnClickListener(paramOnClickListener);
  }

  public void b(String paramString)
  {
    this.c.setText(paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.name.d
 * JD-Core Version:    0.6.2
 */