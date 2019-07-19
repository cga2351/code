package com.viber.voip.engagement.a;

import android.content.Context;
import android.support.v4.app.LoaderManager;
import com.viber.provider.d;
import com.viber.provider.d.a;
import com.viber.voip.engagement.c;
import com.viber.voip.engagement.c.a;
import com.viber.voip.messages.conversation.ConversationLoaderEntity;
import com.viber.voip.messages.conversation.RegularConversationLoaderEntity;
import com.viber.voip.messages.conversation.ai;
import com.viber.voip.messages.conversation.n.a;
import com.viber.voip.messages.k;
import com.viber.voip.util.cl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;

public class a
  implements c
{
  private boolean a = false;
  private final ai b;
  private c.a c = (c.a)cl.b(c.a.class);
  private Map<String, RegularConversationLoaderEntity> d = new HashMap();
  private final d.a e = new d.a()
  {
    public void onLoadFinished(d paramAnonymousd, boolean paramAnonymousBoolean)
    {
      if (a.a(a.this));
      while ((!paramAnonymousBoolean) || (paramAnonymousd.getCount() <= 0))
        return;
      int i = Math.min(paramAnonymousd.getCount(), 30);
      ArrayList localArrayList = new ArrayList(i);
      for (int j = 0; j < i; j++)
      {
        RegularConversationLoaderEntity localRegularConversationLoaderEntity = (RegularConversationLoaderEntity)paramAnonymousd.b(j);
        localArrayList.add(localRegularConversationLoaderEntity);
        if (localRegularConversationLoaderEntity.isConversation1on1())
          a.b(a.this).put(localRegularConversationLoaderEntity.getParticipantMemberId(), localRegularConversationLoaderEntity);
      }
      a.c(a.this).a(localArrayList);
    }

    public void onLoaderReset(d paramAnonymousd)
    {
    }
  };

  public a(Context paramContext, LoaderManager paramLoaderManager, dagger.a<k> parama, boolean paramBoolean, EventBus paramEventBus)
  {
    if (paramBoolean);
    for (n.a locala = n.a.a; ; locala = n.a.b)
    {
      this.b = new ai(paramContext, paramLoaderManager, parama, false, false, locala, null, null, this.e, paramEventBus);
      c();
      return;
    }
  }

  private void c()
  {
    this.b.d(30);
    this.b.i(false);
    this.b.n(false);
    this.b.o(false);
    this.b.g(false);
    this.b.l(false);
    this.b.h(false);
  }

  public ConversationLoaderEntity a(String paramString)
  {
    return (ConversationLoaderEntity)this.d.get(paramString);
  }

  public void a()
  {
    if (this.b.d())
      this.b.l();
    while (true)
    {
      this.a = false;
      return;
      this.b.i();
    }
  }

  public void a(c.a parama)
  {
    this.c = parama;
  }

  public void b()
  {
    this.a = true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.a.a
 * JD-Core Version:    0.6.2
 */