package com.viber.voip.publicaccount.ui.holders.bottom.edit;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.publicaccount.ui.holders.PublicAccountEditUIHolder;
import com.viber.voip.publicaccount.ui.holders.d;
import com.viber.voip.ui.GenericWebViewActivity;
import java.util.Locale;

public class a extends PublicAccountEditUIHolder<BottomData, b>
  implements View.OnClickListener
{
  private final d c;
  private final a d;

  public a(a parama, d paramd)
  {
    this.d = parama;
    this.c = paramd;
  }

  private void a(Context paramContext)
  {
    String str = Locale.getDefault().getLanguage();
    GenericWebViewActivity.a(paramContext, paramContext.getString(R.string.public_account_edit_learn_more_url, new Object[] { str }), null);
  }

  private void f()
  {
    this.d.b();
  }

  private void g()
  {
    this.c.V_();
  }

  protected void a(BottomData paramBottomData, b paramb)
  {
  }

  protected void a(b paramb, BottomData paramBottomData)
  {
  }

  protected Class<b> b()
  {
    return b.class;
  }

  protected b c(View paramView)
  {
    return new c(paramView, this);
  }

  protected BottomData e()
  {
    return new BottomData();
  }

  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == R.id.btn_leave_public_account)
      f();
    do
    {
      return;
      if (i == R.id.btn_save_public_account_details)
      {
        g();
        return;
      }
    }
    while (i != R.id.btn_learn_more);
    a(paramView.getContext());
  }

  public static abstract interface a
  {
    public abstract void b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.bottom.edit.a
 * JD-Core Version:    0.6.2
 */