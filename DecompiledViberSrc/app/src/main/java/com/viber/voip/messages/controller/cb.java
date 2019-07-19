package com.viber.voip.messages.controller;

import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.d.l;
import java.util.HashSet;
import java.util.Set;

public abstract class cb
  implements ca
{
  private Set<l> a = new HashSet();

  public void a()
  {
    this.a.clear();
  }

  public void a(aa paramaa, boolean paramBoolean)
  {
    l locall = new l(paramaa);
    if (paramBoolean)
    {
      this.a.add(locall);
      return;
    }
    this.a.remove(locall);
  }

  public boolean b(aa paramaa)
  {
    return this.a.contains(new l(paramaa));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.cb
 * JD-Core Version:    0.6.2
 */