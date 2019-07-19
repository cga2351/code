package com.viber.voip.messages.conversation;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import com.viber.dexshared.Logger;
import com.viber.provider.d.a;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.controller.bv.j;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.messages.conversation.a.h;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository;
import org.greenrobot.eventbus.EventBus;

public class u extends ai
  implements bv.j
{
  protected static final Logger w = ViberEnv.getLogger();

  public u(Context paramContext, LoaderManager paramLoaderManager, dagger.a<com.viber.voip.messages.k> parama, boolean paramBoolean1, boolean paramBoolean2, n.a parama1, Bundle paramBundle, String paramString, d.a parama2, EventBus paramEventBus, h paramh, dagger.a<ConferenceCallsRepository> parama3)
  {
    super(paramContext, paramLoaderManager, parama, paramBoolean1, paramBoolean2, parama1, paramBundle, paramString, parama2, paramEventBus, paramh, parama3);
    q(true);
    r(true);
  }

  public void a()
  {
    F();
  }

  public void a(long paramLong)
  {
    F();
  }

  public void p()
  {
    super.p();
    o.a().a(this);
  }

  public void q()
  {
    super.q();
    o.a().b(this);
  }

  protected String v()
  {
    StringBuilder localStringBuilder = new StringBuilder().append(super.v()).append(" OR ");
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = com.viber.voip.s.a.e(((com.viber.voip.messages.k)this.n.get()).a().b());
    return String.format("conversations._id IN(%s)", arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.u
 * JD-Core Version:    0.6.2
 */