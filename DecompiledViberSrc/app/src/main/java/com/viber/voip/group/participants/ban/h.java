package com.viber.voip.group.participants.ban;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.group.participants.settings.e;
import com.viber.voip.messages.controller.ci;
import com.viber.voip.messages.conversation.ae;
import com.viber.voip.util.u;
import java.util.HashSet;

public class h
{
  private static final Logger a = ViberEnv.getLogger();
  private static final HashSet<String> d = new HashSet();
  private final e b;
  private final ci c;

  public h(e parame, ci paramci)
  {
    this.b = parame;
    this.c = paramci;
  }

  public void a()
  {
    d.clear();
  }

  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt2 < 0));
    HashSet localHashSet;
    do
    {
      return;
      localHashSet = null;
      while (paramInt1 <= paramInt2)
      {
        String str = this.b.a(paramInt1).p();
        if (!d.contains(str))
        {
          if (localHashSet == null)
            localHashSet = new HashSet();
          d.add(str);
          localHashSet.add(str);
        }
        paramInt1++;
      }
    }
    while (u.a(localHashSet));
    this.c.a(localHashSet, null, false, false, false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.group.participants.ban.h
 * JD-Core Version:    0.6.2
 */