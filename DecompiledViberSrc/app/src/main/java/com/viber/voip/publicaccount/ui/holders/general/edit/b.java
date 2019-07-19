package com.viber.voip.publicaccount.ui.holders.general.edit;

import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView.OnEditorActionListener;
import com.viber.voip.R.id;
import com.viber.voip.publicaccount.d.g;
import com.viber.voip.publicaccount.ui.holders.general.base.f;
import com.viber.voip.widget.TextViewWithDescription;

public class b extends f<GeneralEditData>
  implements a
{
  private final TextViewWithDescription b;
  private final g c;

  public b(View paramView, TextWatcher paramTextWatcher, TextView.OnEditorActionListener paramOnEditorActionListener)
  {
    super(paramView);
    this.b = ((TextViewWithDescription)paramView.findViewById(R.id.tags));
    this.b.a(paramTextWatcher);
    a(this.b, paramOnEditorActionListener);
    this.c = g.a(this.b.getEditText());
  }

  public void a()
  {
    super.a();
    this.b.setOnTextChangedListener(null);
  }

  public void a(GeneralEditData paramGeneralEditData)
  {
    super.b(paramGeneralEditData);
    paramGeneralEditData.mTags = this.c.a();
  }

  public void a(final String[] paramArrayOfString)
  {
    this.b.post(new Runnable()
    {
      public void run()
      {
        b.a(b.this).a(paramArrayOfString);
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.general.edit.b
 * JD-Core Version:    0.6.2
 */