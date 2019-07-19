package com.viber.voip.publicaccount.ui.holders;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.publicaccount.d.d;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.util.dj;
import com.viber.voip.widget.ai;
import com.viber.voip.widget.ai.a;

public class a
  implements c
{
  private static final Logger a = ViberEnv.getLogger();
  private final Context b;
  private final a c;
  private View d;
  private ai e;
  private ai f;
  private View g;
  private View h;

  public a(Context paramContext, a parama)
  {
    this.b = paramContext;
    this.c = parama;
  }

  private void c(PublicAccount paramPublicAccount)
  {
    this.e = new ai(this.d.findViewById(R.id.smart_notifications), paramPublicAccount.isSmartNotificationsOn());
    this.e.a(this.b.getString(R.string.pa_toggle_title_smart_notifications));
    this.e.a(new ai.a()
    {
      public void a(boolean paramAnonymousBoolean)
      {
        a.a(a.this).a(paramAnonymousBoolean);
      }
    });
  }

  private void d(PublicAccount paramPublicAccount)
  {
    this.f = new ai(this.d.findViewById(R.id.mute_chat), paramPublicAccount.isMute());
    this.f.a(this.b.getString(R.string.pa_toggle_title_mute));
    this.f.b(this.b.getString(R.string.pa_toggle_summary_mute));
    this.f.a(new ai.a()
    {
      public void a(boolean paramAnonymousBoolean)
      {
        a.a(a.this).b(paramAnonymousBoolean);
      }
    });
  }

  public void a()
  {
    this.d = null;
    this.e = null;
    this.f = null;
    this.g = null;
    this.h = null;
  }

  public void a(Bundle paramBundle)
  {
  }

  public void a(View paramView)
  {
    this.d = paramView;
    this.g = this.d.findViewById(R.id.toggles_divider_0);
    this.h = this.d.findViewById(R.id.toggles_divider_1);
  }

  public void a(PublicAccount paramPublicAccount)
  {
    boolean bool1 = true;
    if (this.d == null)
      return;
    boolean bool2;
    label64: label76: boolean bool4;
    label117: View localView2;
    if ((d.o.a(paramPublicAccount.getGroupRole(), paramPublicAccount.getPublicGroupType())) && (!paramPublicAccount.isMute()))
    {
      bool2 = bool1;
      boolean bool3 = d.p.a(paramPublicAccount.getGroupRole(), paramPublicAccount.getPublicGroupType());
      if (this.e != null)
        break label151;
      c(paramPublicAccount);
      if (this.f != null)
        break label165;
      d(paramPublicAccount);
      dj.b(this.e.b(), bool2);
      dj.b(this.f.b(), bool3);
      View localView1 = this.g;
      if ((!bool2) && (!bool3))
        break label179;
      bool4 = bool1;
      dj.b(localView1, bool4);
      localView2 = this.h;
      if ((!bool2) || (!bool3))
        break label185;
    }
    while (true)
    {
      dj.b(localView2, bool1);
      return;
      bool2 = false;
      break;
      label151: this.e.a(paramPublicAccount.isSmartNotificationsOn());
      break label64;
      label165: this.f.a(paramPublicAccount.isMute());
      break label76;
      label179: bool4 = false;
      break label117;
      label185: bool1 = false;
    }
  }

  public void b(Bundle paramBundle)
  {
  }

  public void b(PublicAccount paramPublicAccount)
  {
  }

  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean);

    public abstract void b(boolean paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.a
 * JD-Core Version:    0.6.2
 */