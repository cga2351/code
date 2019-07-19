package com.viber.voip.messages.conversation.ui;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m;
import com.viber.common.dialogs.m.a;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.story.a.a;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.block.b.a;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ui.banner.ConversationAlertView;
import com.viber.voip.messages.conversation.ui.banner.ConversationAlertView.a;
import com.viber.voip.messages.conversation.ui.banner.e;
import com.viber.voip.messages.conversation.ui.banner.e.a;
import com.viber.voip.registration.ao;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.p;

public class b
  implements b.a, e.a
{
  private static final Logger a = ViberEnv.getLogger();
  private final Fragment b;
  private final ConversationAlertView c;
  private final a d;
  private ConversationItemLoaderEntity e;
  private e f;

  public b(Fragment paramFragment, ConversationAlertView paramConversationAlertView, a parama)
  {
    this.b = paramFragment;
    this.c = paramConversationAlertView;
    this.d = parama;
  }

  public void a()
  {
    this.d.b("Banner");
    com.viber.voip.block.b.a().b(this.e.getAppId());
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    if ((ao.f()) || (paramConversationItemLoaderEntity.getAppId() == 10118) || (paramConversationItemLoaderEntity.getAppId() == 12829))
      return;
    this.e = paramConversationItemLoaderEntity;
    if ((paramConversationItemLoaderEntity.isNonReplyableChat()) && (!SpamController.b(paramConversationItemLoaderEntity)))
    {
      if (this.f == null)
        this.f = new e(this.c, this, this.b.getLayoutInflater());
      this.f.a(paramConversationItemLoaderEntity);
      com.viber.voip.block.b.a().a(this.e.getAppId(), this);
      return;
    }
    c();
  }

  public void a(boolean paramBoolean)
  {
    av.a(av.e.a).post(new c(this, paramBoolean));
  }

  public void b()
  {
    p.a().a(false).a(new m.a()
    {
      public void onDialogAction(m paramAnonymousm, int paramAnonymousInt)
      {
        if (paramAnonymousm.c().equals(DialogCode.D398));
        switch (paramAnonymousInt)
        {
        default:
          return;
        case -2:
        }
        b.a(b.this).a("Banner");
        com.viber.voip.block.b.a().a(b.b(b.this).getAppId());
      }

      public void onPrepareDialogView(m paramAnonymousm, View paramAnonymousView, int paramAnonymousInt)
      {
        TextView localTextView = (TextView)paramAnonymousView.findViewById(R.id.body);
        localTextView.setText(Html.fromHtml(localTextView.getText().toString()));
        localTextView.setMovementMethod(LinkMovementMethod.getInstance());
      }
    }).b(this.b);
  }

  public void c()
  {
    this.c.a(ConversationAlertView.a.i, false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.b
 * JD-Core Version:    0.6.2
 */