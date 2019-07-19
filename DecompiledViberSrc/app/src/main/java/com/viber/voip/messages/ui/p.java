package com.viber.voip.messages.ui;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import com.viber.voip.messages.controller.publicaccount.d;

public abstract class p
  implements TextWatcher
{
  private d a;
  private Handler b;
  private Runnable c = new Runnable()
  {
    public void run()
    {
      if (p.this.b())
        p.this.c();
    }
  };

  public p(Handler paramHandler, d paramd)
  {
    this.a = paramd;
    this.b = paramHandler;
  }

  public void a()
  {
    this.b.removeCallbacks(this.c);
  }

  public void afterTextChanged(Editable paramEditable)
  {
  }

  public abstract boolean b();

  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public abstract void c();

  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 != paramInt3)
    {
      this.a.a();
      if (b())
      {
        this.b.removeCallbacks(this.c);
        this.b.postDelayed(this.c, 1000L);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.p
 * JD-Core Version:    0.6.2
 */