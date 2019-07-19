package com.viber.voip.notif.e;

import android.content.Context;
import android.net.Uri;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.voip.ViberEnv;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.notif.d.e.a;
import com.viber.voip.notif.d.e.b;
import com.viber.voip.notif.d.j;
import com.viber.voip.notif.i.a.b;
import com.viber.voip.notif.i.i;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository.ConferenceAvailabilityListener;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository.ConferenceAvailabilityListener..CC;
import com.viber.voip.phone.viber.conference.model.OngoingConferenceCallModel;
import com.viber.voip.util.ViberActionRunner.bo;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class b extends a.b
{
  private static final Logger b = ViberEnv.getLogger();
  boolean a;
  private final Context c;
  private final Engine d;
  private final j e;
  private final dagger.a<com.viber.voip.notif.f> f;
  private final com.viber.voip.util.d g;
  private final ConferenceCallsRepository.ConferenceAvailabilityListener h = new ConferenceCallsRepository.ConferenceAvailabilityListener()
  {
    public void onConferenceMissedInProgress(OngoingConferenceCallModel paramAnonymousOngoingConferenceCallModel, String paramAnonymousString1, String paramAnonymousString2)
    {
      ((com.viber.voip.notif.f)b.a(b.this).get()).a(com.viber.voip.notif.e.b(paramAnonymousOngoingConferenceCallModel.conversationId));
      b.a(b.this, paramAnonymousOngoingConferenceCallModel, paramAnonymousString1, paramAnonymousString2);
    }

    public void onConferencesAvailable(Map paramAnonymousMap)
    {
      ConferenceCallsRepository.ConferenceAvailabilityListener..CC.onConferencesAvailable(this, paramAnonymousMap);
    }

    public void onConferencesUnavailable(Map<Long, OngoingConferenceCallModel> paramAnonymousMap)
    {
      Iterator localIterator = paramAnonymousMap.values().iterator();
      while (localIterator.hasNext())
      {
        OngoingConferenceCallModel localOngoingConferenceCallModel = (OngoingConferenceCallModel)localIterator.next();
        b.this.a(localOngoingConferenceCallModel.callToken, localOngoingConferenceCallModel.conversationId);
      }
    }
  };

  b(Context paramContext, Engine paramEngine, j paramj, dagger.a<com.viber.voip.notif.f> parama, com.viber.voip.util.d paramd)
  {
    this.c = paramContext;
    this.d = paramEngine;
    this.e = paramj;
    this.f = parama;
    this.g = paramd;
  }

  private void a()
  {
    ViberActionRunner.bo.a(this.c);
    com.viber.voip.notif.f localf = (com.viber.voip.notif.f)this.f.get();
    localf.a(201);
    localf.a(203);
    this.a = false;
  }

  private void a(long paramLong, boolean paramBoolean)
  {
    if (this.a)
      a(new com.viber.voip.notif.b.a.a(this.d, paramLong, paramBoolean, true), g.a);
  }

  private void a(com.viber.voip.notif.d.e parame)
  {
    try
    {
      parame.a(this.c, this.e).a((com.viber.voip.notif.f)this.f.get());
      return;
    }
    catch (Exception localException)
    {
      b.a(localException, "Can't show notification!");
    }
  }

  private void a(com.viber.voip.notif.d.e parame, e.a parama)
  {
    try
    {
      parame.a(this.c, this.e).a((com.viber.voip.notif.f)this.f.get(), parama);
      return;
    }
    catch (Exception localException)
    {
      b.a(localException, "Can't show notification!");
    }
  }

  private void a(OngoingConferenceCallModel paramOngoingConferenceCallModel, String paramString1, String paramString2)
  {
    a(new com.viber.voip.notif.b.a.d(paramOngoingConferenceCallModel, paramString1, paramString2));
  }

  public void a(long paramLong1, long paramLong2)
  {
    ((com.viber.voip.notif.f)this.f.get()).a(com.viber.voip.notif.e.a(paramLong1), com.viber.voip.notif.e.b(paramLong2));
  }

  public void a(com.viber.voip.notif.i.a parama, ConferenceCallsRepository paramConferenceCallsRepository)
  {
    parama.a(this);
    paramConferenceCallsRepository.registerConferenceAvailabilityListener(this.h);
    ((com.viber.voip.notif.f)this.f.get()).a(201);
  }

  public void onChronometerTick(long paramLong)
  {
    a(paramLong, false);
  }

  public void onEndedCall(int paramInt)
  {
    a();
  }

  public void onHold(boolean paramBoolean)
  {
    a(0L, paramBoolean);
  }

  public void onIdleCall()
  {
    a();
  }

  public void onInProgressCall(String paramString1, String paramString2, Uri paramUri, ConferenceInfo paramConferenceInfo)
  {
    a(new com.viber.voip.notif.b.a.a(this.d, 0L, false, false), new f(this));
    this.a = true;
  }

  public void onIncomingCall(String paramString1, String paramString2, Uri paramUri, boolean paramBoolean1, boolean paramBoolean2, ConferenceInfo paramConferenceInfo)
  {
    if ((i.a()) && (com.viber.voip.notif.c.e.a((com.viber.voip.notif.f)this.f.get())))
    {
      a(new com.viber.voip.notif.b.a.c(paramString1, paramString2, paramBoolean1, paramBoolean2, this.g.b(), paramConferenceInfo), new c(this));
      return;
    }
    a(new com.viber.voip.notif.b.a.b(paramString1, paramString2, paramBoolean1, paramConferenceInfo, 0), new d(this));
  }

  public void onOutgoingCall(String paramString1, String paramString2, Uri paramUri, ConferenceInfo paramConferenceInfo)
  {
    a(new com.viber.voip.notif.b.a.b(paramString1, paramString2, false, paramConferenceInfo, 1), new e(this));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.e.b
 * JD-Core Version:    0.6.2
 */