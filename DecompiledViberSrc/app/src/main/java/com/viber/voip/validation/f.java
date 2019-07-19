package com.viber.voip.validation;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import com.viber.voip.widget.TextViewWithDescription;

public class f
  implements e<String>
{
  protected TextViewWithDescription a;

  public f(TextViewWithDescription paramTextViewWithDescription, final c<String, ? extends a> paramc)
  {
    this.a = paramTextViewWithDescription;
    this.a.setTryAgainListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramc.e();
      }
    });
  }

  public void a(final e.a parama)
  {
    this.a.a(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        parama.c();
      }

      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
      }

      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
      }
    });
  }

  public String b()
  {
    return this.a.getText().toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.validation.f
 * JD-Core Version:    0.6.2
 */