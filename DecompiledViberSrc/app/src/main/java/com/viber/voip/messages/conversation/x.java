package com.viber.voip.messages.conversation;

import android.content.Context;
import android.support.v4.app.LoaderManager;
import com.viber.provider.d;
import com.viber.provider.d.a;
import com.viber.provider.messages.b.c.f;
import com.viber.voip.ViberApplication;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.bv.n;
import com.viber.voip.messages.controller.bv.n.a;
import com.viber.voip.messages.k;
import com.viber.voip.model.entity.m;
import com.viber.voip.user.UserData.OwnerChangedEvent;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class x extends d
{
  private final k l = ViberApplication.getInstance().getMessagesManager();
  private EventBus m;
  private final bv.n n = new bv.n()
  {
    public void onChange(Set<Long> paramAnonymousSet, Set<String> paramAnonymousSet1, boolean paramAnonymousBoolean)
    {
    }

    public void onContactStatusChanged(Map<Long, bv.n.a> paramAnonymousMap)
    {
    }

    public void onInitCache()
    {
      x.this.l();
    }

    public void onNewInfo(List<m> paramAnonymousList, boolean paramAnonymousBoolean)
    {
    }

    public void onParticipantDeleted(m paramAnonymousm)
    {
    }
  };

  public x(Context paramContext, LoaderManager paramLoaderManager, d.a parama, long paramLong, EventBus paramEventBus)
  {
    super(23, c.f.a, paramContext, paramLoaderManager, parama, 0);
    this.m = paramEventBus;
    a(y.a);
    a("messages_likes.message_token = ? AND messages_likes.status<>2");
    String[] arrayOfString = new String[1];
    arrayOfString[0] = String.valueOf(paramLong);
    b(arrayOfString);
    d("messages_likes.date DESC");
  }

  public y e(int paramInt)
  {
    if (b_(paramInt))
      return new y(this.f);
    return null;
  }

  @Subscribe
  public void onOwnerChanged(UserData.OwnerChangedEvent paramOwnerChangedEvent)
  {
    l();
  }

  public void p()
  {
    super.p();
    if (!this.m.isRegistered(this))
      this.m.register(this);
    this.l.b().a(this.n);
  }

  public void q()
  {
    super.q();
    this.m.unregister(this);
    this.l.b().b(this.n);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.x
 * JD-Core Version:    0.6.2
 */