package com.viber.voip.messages.controller;

import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.connection.ConnectionDelegate;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.apps.h.a;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.k;
import com.viber.voip.model.entity.r;
import com.viber.voip.settings.d.g;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class cc
  implements ConnectionDelegate
{
  private static final Logger a = ViberEnv.getLogger();
  private final ai b;
  private final com.viber.voip.apps.h c;
  private final ab d;
  private final Handler e;
  private final Runnable f = new Runnable()
  {
    public void run()
    {
      cc.a(cc.this);
      cc.a(cc.this, cc.b(cc.this).f("SELECT participants_info.member_id FROM conversations, participants_info WHERE conversations.participant_id_1=participants_info._id AND flags & 524288<> 0 AND flags & 262144 <> 0"));
    }
  };
  private final Runnable g = new Runnable()
  {
    public void run()
    {
      cc.c(cc.this);
      cc.a(cc.this, cc.b(cc.this).f("SELECT participants_info.member_id FROM conversations, participants_info WHERE conversations.participant_id_1=participants_info._id AND flags & 524288<> 0"));
      d.g.c.a(false);
    }
  };

  public cc(ai paramai, com.viber.voip.apps.h paramh, ab paramab)
  {
    this.b = paramai;
    this.c = paramh;
    this.d = paramab;
    this.e = av.a(av.e.d);
  }

  private void a(Set<String> paramSet)
  {
    PhoneController localPhoneController = ViberApplication.getInstance().getEngine(true).getPhoneController();
    GroupController localGroupController = ViberApplication.getInstance().getMessagesManager().d();
    Iterator localIterator = paramSet.iterator();
    String str;
    long l;
    int j;
    int i;
    if (localIterator.hasNext())
    {
      str = (String)localIterator.next();
      l = 0L;
      r localr = this.d.a(str);
      if (localr == null)
        break label138;
      ab localab = this.d;
      l = localr.a();
      com.viber.voip.model.entity.h localh = localab.b(l);
      if (localh == null)
        break label138;
      j = localh.j();
      i = localh.p();
    }
    while (true)
    {
      localGroupController.a(localPhoneController.generateSequence(), l, str, 1, j, i);
      break;
      return;
      label138: i = 3;
      j = 3;
    }
  }

  private void c()
  {
    List localList = this.d.y();
    if (localList != null)
      this.c.a(localList, new h.a()
      {
        public void onAppInfoFailed()
        {
        }

        public void onAppInfoReady(List<com.viber.voip.apps.b> paramAnonymousList, boolean paramAnonymousBoolean)
        {
          cc.d(cc.this).a(paramAnonymousList);
        }
      });
  }

  private void d()
  {
    this.c.a(new h.a()
    {
      public void onAppInfoFailed()
      {
      }

      public void onAppInfoReady(List<com.viber.voip.apps.b> paramAnonymousList, boolean paramAnonymousBoolean)
      {
        cc.d(cc.this).a(paramAnonymousList);
      }
    });
  }

  public void a()
  {
    this.e.post(this.f);
  }

  public void b()
  {
    if (d.g.c.d())
      this.e.post(this.g);
  }

  public void onConnect()
  {
    a();
    b();
  }

  public void onConnectionStateChange(int paramInt)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.cc
 * JD-Core Version:    0.6.2
 */