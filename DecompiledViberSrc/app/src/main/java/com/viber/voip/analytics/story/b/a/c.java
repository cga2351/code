package com.viber.voip.analytics.story.b.a;

import com.viber.dexshared.Logger;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ViberEnv;
import com.viber.voip.phone.viber.conference.ConferenceParticipantsRepository;
import com.viber.voip.phone.viber.conference.model.ConferenceParticipantRepositoryEntity;
import com.viber.voip.registration.af;
import com.viber.voip.util.cg;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;

public class c
{
  private static final Logger a = ViberEnv.getLogger();
  private final com.viber.voip.analytics.story.b.c b;
  private final PhoneController c;
  private final af d;
  private final ConferenceParticipantsRepository e;
  private final ScheduledExecutorService f;
  private final com.viber.voip.model.a.d g;

  @Inject
  c(com.viber.voip.analytics.story.b.c paramc, PhoneController paramPhoneController, af paramaf, ConferenceParticipantsRepository paramConferenceParticipantsRepository, ScheduledExecutorService paramScheduledExecutorService, com.viber.voip.model.a.d paramd)
  {
    this.b = paramc;
    this.c = paramPhoneController;
    this.d = paramaf;
    this.f = paramScheduledExecutorService;
    this.g = paramd;
    this.e = paramConferenceParticipantsRepository;
  }

  private void a(int paramInt1, com.viber.voip.analytics.story.b.f paramf, String paramString, List<String> paramList, int paramInt2, long paramLong)
  {
    long l1 = paramf.i();
    long l2 = paramf.j();
    long l3 = paramf.k() / 1000L;
    long l4 = (l1 + l2) / 1000L;
    long l5 = l1 / 1000L;
    long l6 = l2 / 1000L;
    long l7 = paramLong / 1000L;
    this.b.a(paramInt1, paramf, paramString, paramList, paramInt2, l3, l4, l5, l6, l7);
  }

  private void a(com.viber.voip.analytics.story.b.f paramf, boolean paramBoolean, int paramInt, long paramLong)
  {
    Set localSet = paramf.m();
    int i = 1 + localSet.size();
    Object localObject1 = "";
    ArrayList localArrayList = new ArrayList();
    String str1 = this.d.g();
    String str2 = cg.a(this.c, str1, true);
    Map localMap;
    String str3;
    label83: Iterator localIterator;
    Object localObject2;
    if (paramBoolean)
    {
      localObject1 = str2;
      localMap = this.e.loadParticipantInfos(localSet);
      if (!paramBoolean)
        break label190;
      str3 = this.d.l();
      localIterator = localMap.keySet().iterator();
      localObject2 = localObject1;
    }
    while (true)
    {
      label101: if (!localIterator.hasNext())
        break label230;
      String str4 = (String)localIterator.next();
      ConferenceParticipantRepositoryEntity localConferenceParticipantRepositoryEntity = (ConferenceParticipantRepositoryEntity)localMap.get(str4);
      if (localConferenceParticipantRepositoryEntity.number != null);
      for (String str5 = cg.a(this.c, localConferenceParticipantRepositoryEntity.number, false); ; str5 = "")
      {
        if (!str3.equals(str4))
          break label217;
        localObject2 = str5;
        break label101;
        localArrayList.add(str2);
        break;
        label190: str3 = (String)localSet.iterator().next();
        break label83;
      }
      label217: localArrayList.add(str5);
    }
    label230: a(i, paramf, localObject2, localArrayList, paramInt, paramLong);
  }

  private void b(com.viber.voip.analytics.story.b.f paramf, boolean paramBoolean, int paramInt, long paramLong)
  {
    String str1 = (String)paramf.l().iterator().next();
    String str2;
    if (paramBoolean)
    {
      str2 = this.d.g();
      if (!paramBoolean)
        break label118;
    }
    label118: for (String str3 = this.c.canonizePhoneNumber(str1); ; str3 = this.d.g())
    {
      String str4 = cg.a(this.c, str2, true);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(cg.a(this.c, str3, true));
      a(2, paramf, str4, localArrayList, paramInt, paramLong);
      return;
      str2 = this.c.canonizePhoneNumber(str1);
      break;
    }
  }

  private void e()
  {
    long l = System.currentTimeMillis();
    this.g.b("last_call_connection_was_established", false);
    this.g.a("last_call_connection_established_time", l);
  }

  private void f()
  {
    Long localLong = this.g.g("last_call_connection_established_time");
    if (localLong == null);
    for (long l = 0L; ; l = System.currentTimeMillis() - localLong.longValue())
    {
      this.g.b("last_call_connection_was_established", true);
      this.g.a("last_call_connection_established_time", l);
      return;
    }
  }

  private long g()
  {
    long l = 0L;
    Boolean localBoolean = this.g.h("last_call_connection_was_established");
    if ((localBoolean != null) && (localBoolean.booleanValue()))
    {
      Long localLong = this.g.g("last_call_connection_established_time");
      if ((localLong != null) && (localLong.longValue() > l))
        l = localLong.longValue();
      this.g.b("last_call_connection_was_established", false);
    }
    return l;
  }

  public void a()
  {
    this.f.execute(new d(this));
  }

  public void a(com.viber.voip.analytics.story.b.f paramf, boolean paramBoolean, int paramInt)
  {
    this.f.execute(new f(this, paramf, paramBoolean, paramInt));
  }

  public void b()
  {
    this.f.execute(new e(this));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.story.b.a.c
 * JD-Core Version:    0.6.2
 */