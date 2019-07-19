package com.viber.voip.publicaccount.ui.holders;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.viber.voip.R.id;
import com.viber.voip.publicaccount.d.d;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.util.dj;

public class f
  implements View.OnClickListener, c
{
  private final a a;
  private View b;

  public f(a parama)
  {
    this.a = parama;
  }

  public void a()
  {
    if (this.b != null)
    {
      this.b.setOnClickListener(null);
      this.b = null;
    }
  }

  public void a(Bundle paramBundle)
  {
  }

  public void a(View paramView)
  {
    this.b = paramView.findViewById(R.id.view_public_chat);
    this.b.setOnClickListener(this);
  }

  public void a(PublicAccount paramPublicAccount)
  {
    boolean bool = d.B.a(paramPublicAccount.getGroupRole(), paramPublicAccount.getPublicGroupType());
    dj.b(this.b, bool);
  }

  public void b(Bundle paramBundle)
  {
  }

  public void b(PublicAccount paramPublicAccount)
  {
  }

  public void onClick(View paramView)
  {
    if (R.id.view_public_chat == paramView.getId())
      this.a.a();
  }

  public static abstract interface a
  {
    public abstract void a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.f
 * JD-Core Version:    0.6.2
 */