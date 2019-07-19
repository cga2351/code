package com.viber.voip.messages.ui.fm;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.viber.jni.Engine;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.R.dimen;
import com.viber.voip.ViberApplication;
import com.viber.voip.analytics.g;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.d.c;
import com.viber.voip.messages.d.l;
import com.viber.voip.messages.orm.entity.json.BaseMessage;
import com.viber.voip.messages.orm.entity.json.action.Action;
import com.viber.voip.messages.orm.entity.json.action.AddContactAction;
import com.viber.voip.messages.orm.entity.json.action.MessageOpenUrlAction;
import com.viber.voip.messages.orm.entity.json.action.OpenUrlAction;
import com.viber.voip.messages.orm.entity.json.action.ViewMediaAction;
import com.viber.voip.messages.ui.by;
import com.viber.voip.util.ViberActionRunner.ae;
import com.viber.voip.util.da;

abstract class a<V extends View>
  implements i<V>
{
  final Context a;
  final View.OnClickListener b;
  aa c;
  com.viber.voip.messages.conversation.adapter.a.a d;
  l e;
  com.viber.voip.messages.conversation.adapter.a.c.a.i f;
  private final com.viber.voip.messages.conversation.adapter.e.b g;

  a(BaseMessage paramBaseMessage, Context paramContext, com.viber.voip.messages.conversation.adapter.a.a parama, com.viber.voip.messages.conversation.adapter.a.c.a.i parami, com.viber.voip.messages.conversation.adapter.e.b paramb)
  {
    this.g = paramb;
    this.a = paramContext;
    this.d = parama;
    this.c = parama.c();
    this.e = parama.d();
    this.f = parami;
    this.b = new b(this, paramBaseMessage.getAction(), paramBaseMessage.getCdrAction(), paramBaseMessage.getElementIndex());
  }

  private void a(Action paramAction, String paramString1, String paramString2, int paramInt)
  {
    this.g.u().a(this.c);
    if ("Viber".equals(paramString2))
      g.a().a(com.viber.voip.analytics.story.l.a.a(String.valueOf(this.c.y())));
    if (paramAction == null)
      return;
    Engine localEngine = ViberApplication.getInstance().getEngine(false);
    if (localEngine.isInitialized())
    {
      int i = localEngine.getPhoneController().generateSequence();
      if (!da.a(paramString1))
        localEngine.getPhoneController().handleOnClick(paramString1, paramString2, paramInt, i);
    }
    if ((paramAction instanceof OpenUrlAction))
    {
      MessageOpenUrlAction localMessageOpenUrlAction = MessageOpenUrlAction.from((OpenUrlAction)paramAction);
      this.g.v().a(this.c, localMessageOpenUrlAction);
      return;
    }
    if ((paramAction instanceof ViewMediaAction))
      ((ViewMediaAction)paramAction).setConversationId(this.c.b());
    while (true)
    {
      ViberActionRunner.ae.a(this.a, this.c.X(), paramAction);
      return;
      if ((paramAction instanceof AddContactAction))
        this.g.A().a(this.c);
    }
  }

  public void a()
  {
  }

  public void a(V paramV)
  {
    paramV.setOnCreateContextMenuListener(this.g.c());
    paramV.setOnClickListener(this.b);
  }

  public int b()
  {
    return this.a.getResources().getDimensionPixelSize(R.dimen.formatted_message_horizontal_padding);
  }

  boolean b(View paramView)
  {
    return this.g.w().a(this.c, paramView);
  }

  public int c()
  {
    return this.a.getResources().getDimensionPixelSize(R.dimen.formatted_message_horizontal_padding);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.fm.a
 * JD-Core Version:    0.6.2
 */