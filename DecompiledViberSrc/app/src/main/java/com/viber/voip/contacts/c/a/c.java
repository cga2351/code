package com.viber.voip.contacts.c.a;

import android.content.Context;
import android.support.v4.util.Pair;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.util.cd;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class c
  implements a
{
  private static final Logger a = ViberEnv.getLogger();
  private com.viber.voip.contacts.c.e.a b;
  private com.viber.voip.contacts.c.c.a c;

  public c(Context paramContext, com.viber.voip.contacts.c.c.a parama)
  {
    this.b = new com.viber.voip.contacts.c.e.a(paramContext);
    this.c = parama;
  }

  public void a()
  {
    this.b.b();
  }

  public void a(Member paramMember)
  {
    a(Collections.singleton(paramMember));
  }

  public void a(Member paramMember, boolean paramBoolean)
  {
    a(Collections.singleton(paramMember), paramBoolean);
  }

  public void a(Set<Member> paramSet)
  {
    HashSet localHashSet = new HashSet(paramSet);
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
    {
      Member localMember = cd.a((Member)localIterator.next());
      if (localMember != null)
        localHashSet.add(localMember);
    }
    this.b.a(localHashSet);
    this.c.b(paramSet, true);
  }

  public void a(Set<Member> paramSet, boolean paramBoolean)
  {
    this.b.a(paramSet, paramBoolean);
    this.c.a(paramSet, true);
    Engine localEngine = ViberApplication.getInstance().getEngine(true);
    ICdrController localICdrController = localEngine.getCdrController();
    ab localab = ab.b();
    Iterator localIterator1 = paramSet.iterator();
    while (localIterator1.hasNext())
    {
      Member localMember = (Member)localIterator1.next();
      List localList = localab.a(localMember.getId(), 3);
      if (!localList.isEmpty())
      {
        int i = localEngine.getPhoneController().generateSequence();
        Iterator localIterator2 = localList.iterator();
        while (localIterator2.hasNext())
        {
          Pair localPair = (Pair)localIterator2.next();
          MessageEntity localMessageEntity = (MessageEntity)localPair.first;
          Iterator localIterator3 = ((List)localPair.second).iterator();
          while (localIterator3.hasNext())
          {
            String str = (String)localIterator3.next();
            localICdrController.handleReportBlockedNumberStatistics(localMessageEntity.getDate(), localMessageEntity.getMessageToken(), i, localMember.getPhoneNumber(), localMember.getId(), paramBoolean, str, localMessageEntity.getMimeType());
          }
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.c.a.c
 * JD-Core Version:    0.6.2
 */