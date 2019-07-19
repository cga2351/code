package com.viber.voip.group.participants.settings;

import android.content.Context;
import android.view.View;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m;
import com.viber.common.dialogs.m.a;
import com.viber.voip.R.string;
import com.viber.voip.messages.conversation.adapter.r;
import com.viber.voip.messages.conversation.adapter.s;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.v;
import com.viber.voip.widget.ai;
import com.viber.voip.widget.ai.a;

public class a extends r
  implements ai.a
{
  private final ai a;
  private final k b;
  private final c c;
  private final Context d;
  private b e;

  public a(View paramView, Context paramContext, k paramk, c paramc, b paramb)
  {
    super(paramView);
    this.d = paramContext;
    this.a = new ai(paramView, false);
    this.b = paramk;
    this.c = paramc;
    this.a.a(paramContext.getString(R.string.member_privileges_other_members_title));
    this.a.b(paramContext.getString(R.string.member_privileges_other_members_summary));
    this.a.a(this);
    this.e = paramb;
  }

  private b b(s params)
  {
    b localb = this.c.a();
    if (localb == null)
      localb = this.e;
    return localb;
  }

  public void a(s params)
  {
    b localb = b(params);
    this.a.a(localb.canWrite(), false);
  }

  public void a(final boolean paramBoolean)
  {
    v.a(paramBoolean).a(new m.a()
    {
      public void onDialogAction(m paramAnonymousm, int paramAnonymousInt)
      {
        super.onDialogAction(paramAnonymousm, paramAnonymousInt);
        if (paramAnonymousm.a(DialogCode.D2000a))
        {
          if (paramAnonymousInt != -1)
            break label48;
          if (a.a(a.this) != null)
            a.a(a.this).a(paramBoolean);
        }
        return;
        label48: ai localai = a.b(a.this);
        if (!paramBoolean);
        for (boolean bool = true; ; bool = false)
        {
          localai.a(bool, false);
          return;
        }
      }
    }).a(this.d);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.group.participants.settings.a
 * JD-Core Version:    0.6.2
 */