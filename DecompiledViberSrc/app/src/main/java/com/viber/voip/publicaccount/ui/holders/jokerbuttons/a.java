package com.viber.voip.publicaccount.ui.holders.jokerbuttons;

import android.view.View;
import android.view.View.OnClickListener;
import com.viber.voip.R.id;
import com.viber.voip.publicaccount.d.d;
import com.viber.voip.publicaccount.entity.PublicAccount.ExtraInfo.JokerButton;
import com.viber.voip.publicaccount.entity.PublicAccount.ExtraInfo.JokerButton.Action;

public class a extends com.viber.voip.publicaccount.ui.holders.b<JokerButtonsData, b>
  implements View.OnClickListener
{
  private final a c;

  public a(a parama)
  {
    this.c = parama;
  }

  protected void a(b paramb, JokerButtonsData paramJokerButtonsData)
  {
    if (d.y.a(((JokerButtonsData)this.a).mRole, ((JokerButtonsData)this.a).mPublicGroupType))
    {
      ((b)this.b).a(paramJokerButtonsData.mJokerButton2, paramJokerButtonsData.mJokerButton3, paramJokerButtonsData.mJokerButton4);
      return;
    }
    ((b)this.b).b();
  }

  protected Class<b> b()
  {
    return b.class;
  }

  protected b c(View paramView)
  {
    return new c(paramView, this);
  }

  protected JokerButtonsData e()
  {
    return new JokerButtonsData();
  }

  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == R.id.joker_button_2)
    {
      PublicAccount.ExtraInfo.JokerButton localJokerButton3 = ((JokerButtonsData)this.a).mJokerButton2;
      this.c.a(localJokerButton3.getButtonText(), localJokerButton3.getAction());
    }
    do
    {
      return;
      if (i == R.id.joker_button_3)
      {
        PublicAccount.ExtraInfo.JokerButton localJokerButton2 = ((JokerButtonsData)this.a).mJokerButton3;
        this.c.a(localJokerButton2.getButtonText(), localJokerButton2.getAction());
        return;
      }
    }
    while (i != R.id.joker_button_4);
    PublicAccount.ExtraInfo.JokerButton localJokerButton1 = ((JokerButtonsData)this.a).mJokerButton4;
    this.c.a(localJokerButton1.getButtonText(), localJokerButton1.getAction());
  }

  public static abstract interface a
  {
    public abstract void a(String paramString, PublicAccount.ExtraInfo.JokerButton.Action paramAction);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.jokerbuttons.a
 * JD-Core Version:    0.6.2
 */