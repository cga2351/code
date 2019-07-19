package com.viber.voip.publicaccount.ui.holders.general.base;

import android.text.InputFilter;
import android.view.View.OnClickListener;
import android.widget.TextView.OnEditorActionListener;
import com.viber.voip.publicaccount.ui.holders.PublicAccountEditUIHolder.a;
import com.viber.voip.validation.a.a;
import com.viber.voip.validation.a.b;
import com.viber.voip.validation.a.i;
import com.viber.voip.widget.ViewWithDescription.a;

public abstract interface e<D extends GeneralData> extends PublicAccountEditUIHolder.a
{
  public abstract void a(InputFilter paramInputFilter, TextView.OnEditorActionListener paramOnEditorActionListener);

  public abstract void a(View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2);

  public abstract void a(TextView.OnEditorActionListener paramOnEditorActionListener);

  public abstract void a(D paramD);

  public abstract void a(a parama, i parami, b paramb);

  public abstract void a(ViewWithDescription.a parama);

  public abstract void a(String paramString);

  public abstract void b(TextView.OnEditorActionListener paramOnEditorActionListener);

  public abstract void b(D paramD);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.general.base.e
 * JD-Core Version:    0.6.2
 */