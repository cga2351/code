package com.viber.voip.messages.controller.b;

import android.content.Context;
import com.viber.common.b.b;
import com.viber.dexshared.Logger;
import com.viber.jni.secure.SecureMessagesDelegate;
import com.viber.jni.secure.SecurityAvailableDelegate;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.messages.controller.manager.z;
import com.viber.voip.model.entity.h;
import com.viber.voip.settings.d.as;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class aj
  implements SecureMessagesDelegate, SecurityAvailableDelegate
{
  private static final Logger a = ViberEnv.getLogger();
  private final z b = new z();
  private final o c = o.a();

  public aj(Context paramContext)
  {
  }

  public void onSecureSessionInfo(String paramString1, boolean paramBoolean, String paramString2)
  {
    List localList = ab.b().a(Collections.singleton(paramString1));
    HashSet localHashSet = new HashSet(localList.size());
    Iterator localIterator = localList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      h localh = (h)localIterator.next();
      localHashSet.add(Long.valueOf(localh.getId()));
      if ((i != 0) || ((localh.O() == paramBoolean) && (!localh.S())))
        break label137;
      this.b.a(paramString1, paramBoolean);
    }
    label137: for (int j = 1; ; j = i)
    {
      i = j;
      break;
      if (i != 0)
        this.c.a(localHashSet, 0, false, false);
      return;
    }
  }

  public void onSecurityAvailable(boolean paramBoolean)
  {
    d.as.a.a(paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.b.aj
 * JD-Core Version:    0.6.2
 */