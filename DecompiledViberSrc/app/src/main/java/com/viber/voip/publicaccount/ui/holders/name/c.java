package com.viber.voip.publicaccount.ui.holders.name;

import android.text.InputFilter;
import android.view.View.OnClickListener;
import android.widget.TextView.OnEditorActionListener;
import com.viber.voip.publicaccount.ui.holders.PublicAccountEditUIHolder.a;
import com.viber.voip.validation.a.h;
import com.viber.voip.widget.TextViewWithDescription.a;
import com.viber.voip.widget.ViewWithDescription.ValidationState;
import com.viber.voip.widget.ViewWithDescription.a;

public abstract interface c extends PublicAccountEditUIHolder.a
{
  public abstract void a(InputFilter paramInputFilter, TextView.OnEditorActionListener paramOnEditorActionListener);

  public abstract void a(NameAndCategoryData paramNameAndCategoryData);

  public abstract void a(h paramh);

  public abstract void a(TextViewWithDescription.a parama, View.OnClickListener paramOnClickListener);

  public abstract void a(ViewWithDescription.a parama);

  public abstract void a(String paramString);

  public abstract void a(String paramString, ViewWithDescription.ValidationState paramValidationState);

  public abstract void a(boolean paramBoolean);

  public abstract void b();

  public abstract void b(TextViewWithDescription.a parama, View.OnClickListener paramOnClickListener);

  public abstract void b(String paramString);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.name.c
 * JD-Core Version:    0.6.2
 */