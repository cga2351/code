package com.viber.voip.publicaccount.ui.holders.infobuttons;

import android.view.View;
import android.view.View.OnClickListener;
import com.viber.voip.R.id;
import com.viber.voip.publicaccount.d.d;
import com.viber.voip.publicaccount.d.e;
import com.viber.voip.publicaccount.entity.PublicAccount.ExtraInfo.JokerButton;
import com.viber.voip.publicaccount.entity.PublicAccount.ExtraInfo.JokerButton.Action;

public class c extends com.viber.voip.publicaccount.ui.holders.b<ButtonsData, a>
  implements View.OnClickListener
{
  private final a c;

  public c(a parama)
  {
    this.c = parama;
  }

  protected void a(a parama, ButtonsData paramButtonsData)
  {
    boolean bool1 = true;
    boolean bool2;
    boolean bool3;
    label59: boolean bool4;
    boolean bool5;
    label114: boolean bool9;
    label165: label174: boolean bool7;
    label222: label232: boolean bool6;
    label301: label317: a locala1;
    if ((paramButtonsData.mWebhookExists) || ((2 == paramButtonsData.mRole) && (!paramButtonsData.mHasCrm) && (e.c())))
    {
      bool2 = bool1;
      if ((!e.c()) || (!d.l.a(paramButtonsData.mRole, paramButtonsData.mPublicGroupType)))
        break label358;
      bool3 = bool1;
      bool4 = d.B.a(((ButtonsData)this.a).mRole, ((ButtonsData)this.a).mPublicGroupType);
      if ((!d.m.a(paramButtonsData.mRole, paramButtonsData.mPublicGroupType)) || (paramButtonsData.mJokerButton1 == null))
        break label364;
      bool5 = bool1;
      if (!d.k.a(paramButtonsData.mRole, paramButtonsData.mPublicGroupType))
        break label457;
      if (!paramButtonsData.mWebhookExists)
        break label376;
      a locala5 = (a)this.b;
      if ((bool3) || (bool4) || (bool5))
        break label370;
      bool9 = bool1;
      locala5.a(bool9);
      if (!bool3)
        break label478;
      ((a)this.b).c(paramButtonsData.mIsNotSuspendedOrBlocked);
      a locala3 = (a)this.b;
      if ((bool2) || (bool4) || (bool5))
        break label472;
      bool7 = bool1;
      locala3.a(bool1, bool7);
      if (!d.m.a(paramButtonsData.mRole, paramButtonsData.mPublicGroupType))
        break label516;
      PublicAccount.ExtraInfo.JokerButton localJokerButton = paramButtonsData.mJokerButton1;
      if (localJokerButton == null)
        break label501;
      a locala2 = (a)this.b;
      String str1 = localJokerButton.getIconUrl();
      String str2 = localJokerButton.getButtonText();
      if ((bool2) || (bool4) || (bool3))
        break label495;
      bool6 = bool1;
      locala2.a(str1, str2, bool6);
      bool5 = bool1;
      locala1 = (a)this.b;
      if ((bool2) || (bool3) || (bool5))
        break label531;
    }
    while (true)
    {
      locala1.b(bool4, bool1);
      return;
      bool2 = false;
      break;
      label358: bool3 = false;
      break label59;
      label364: bool5 = false;
      break label114;
      label370: bool9 = false;
      break label165;
      label376: if ((2 == paramButtonsData.mRole) && (!paramButtonsData.mHasCrm) && (e.c()))
      {
        a locala4 = (a)this.b;
        if ((!bool3) && (!bool4) && (!bool5));
        for (boolean bool8 = bool1; ; bool8 = false)
        {
          locala4.b(bool8);
          break;
        }
      }
      ((a)this.b).b();
      break label174;
      label457: ((a)this.b).b();
      break label174;
      label472: bool7 = false;
      break label222;
      label478: ((a)this.b).a(false, false);
      break label232;
      label495: bool6 = false;
      break label301;
      label501: ((a)this.b).c();
      break label317;
      label516: ((a)this.b).c();
      break label317;
      label531: bool1 = false;
    }
  }

  protected Class<a> b()
  {
    return a.class;
  }

  protected a c(View paramView)
  {
    return new b(paramView, this);
  }

  protected ButtonsData e()
  {
    return new ButtonsData();
  }

  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == R.id.message_btn)
      this.c.d();
    do
    {
      return;
      if (i == R.id.pa_info_setup_inbox_btn)
      {
        this.c.e();
        return;
      }
      if (i == R.id.public_chat_btn)
      {
        this.c.f();
        return;
      }
      if (i == R.id.joker_1_btn)
      {
        PublicAccount.ExtraInfo.JokerButton localJokerButton = ((ButtonsData)this.a).mJokerButton1;
        this.c.a(localJokerButton.getButtonText(), localJokerButton.getAction());
        return;
      }
    }
    while (i != R.id.edit_info_btn);
    this.c.g();
  }

  public static abstract interface a
  {
    public abstract void a(String paramString, PublicAccount.ExtraInfo.JokerButton.Action paramAction);

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract void g();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.infobuttons.c
 * JD-Core Version:    0.6.2
 */