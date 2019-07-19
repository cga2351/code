package com.viber.voip.messages.conversation.ui.a;

import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.adapter.d.c;
import com.viber.voip.messages.orm.entity.json.action.MessageOpenUrlAction;

public class e
  implements c
{
  private c a;

  public void a(aa paramaa, MessageOpenUrlAction paramMessageOpenUrlAction)
  {
    if (this.a != null)
      this.a.a(paramaa, paramMessageOpenUrlAction);
  }

  public void a(c paramc)
  {
    this.a = paramc;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.a.e
 * JD-Core Version:    0.6.2
 */