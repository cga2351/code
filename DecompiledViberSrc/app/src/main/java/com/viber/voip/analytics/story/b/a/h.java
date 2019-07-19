package com.viber.voip.analytics.story.b.a;

import com.viber.jni.controller.PhoneController;
import com.viber.voip.analytics.g;
import com.viber.voip.analytics.story.b.c;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.call.CallInitiationId;
import com.viber.voip.phone.call.listeners.CallInitiationListenersStore;
import com.viber.voip.phone.call.listeners.CallInitiationListenersStore.Listener;
import com.viber.voip.phone.viber.conference.ConferenceParticipantsRepository;
import com.viber.voip.phone.viber.conference.model.ConferenceParticipantRepositoryEntity;
import com.viber.voip.registration.af;
import com.viber.voip.util.cg;
import com.viber.voip.util.da;
import com.viber.voip.util.u;
import dagger.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class h
{
  private final c a;
  private final PhoneController b;
  private final af c;
  private final a<ConferenceParticipantsRepository> d;
  private final a<CallHandler> e;
  private final ScheduledExecutorService f;
  private final Set<CallInitiationListenersStore.Listener> g = new HashSet();

  @Inject
  public h(c paramc, PhoneController paramPhoneController, af paramaf, a<ConferenceParticipantsRepository> parama, a<CallHandler> parama1, ScheduledExecutorService paramScheduledExecutorService)
  {
    this.a = paramc;
    this.b = paramPhoneController;
    this.c = paramaf;
    this.d = parama;
    this.e = parama1;
    this.f = paramScheduledExecutorService;
  }

  private List<String> a(Collection<String> paramCollection)
  {
    Map localMap = ((ConferenceParticipantsRepository)this.d.get()).loadParticipantInfos(paramCollection);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localMap.values().iterator();
    while (localIterator.hasNext())
      localArrayList.add(((ConferenceParticipantRepositoryEntity)localIterator.next()).number);
    return localArrayList;
  }

  private void d(a parama)
  {
    Set localSet1 = parama.f();
    Set localSet2 = parama.g();
    int i = 1 + (localSet1.size() + localSet2.size());
    String str = cg.a(this.b, this.c.g(), true);
    Collection[] arrayOfCollection = new Collection[2];
    arrayOfCollection[0] = a(localSet2);
    arrayOfCollection[1] = localSet1;
    List localList = u.a(u.a(arrayOfCollection), new j(this));
    this.a.a(i, str, localList, parama.d(), parama.e(), parama.a(), parama.b(), parama.c());
    g.a().a(com.viber.voip.analytics.a.i.b());
  }

  public void a(a parama)
  {
    this.f.execute(new i(this, parama));
  }

  public void b(a parama)
  {
    CallInitiationListenersStore.Listener local1 = new CallInitiationListenersStore.Listener()
    {
      public void onInitiationResult(int paramAnonymousInt, long paramAnonymousLong)
      {
        if (paramAnonymousLong >= this.a)
          ((CallHandler)h.a(h.this).get()).getCallInitiationListenersStore().unregisterListener(this);
        synchronized (h.b(h.this))
        {
          h.b(h.this).remove(this);
          if (paramAnonymousLong != this.a)
            return;
        }
        h.a locala = this.b;
        if ((h.a.a(this.b)) && (9 == paramAnonymousInt))
          locala = this.b.h().a(true).b(false).a();
        h.this.a(locala);
      }
    };
    synchronized (this.g)
    {
      this.g.add(local1);
      ((CallHandler)this.e.get()).getCallInitiationListenersStore().registerListener(local1);
      return;
    }
  }

  public static class a
  {
    private boolean a;
    private boolean b;
    private boolean c;
    private String d;
    private String e;
    private Set<String> f;
    private Set<String> g;

    public static a i()
    {
      return new a(null);
    }

    public boolean a()
    {
      return this.a;
    }

    public boolean b()
    {
      return this.b;
    }

    public boolean c()
    {
      return this.c;
    }

    public String d()
    {
      return da.b(this.d, "");
    }

    public String e()
    {
      return da.b(this.e, "");
    }

    public Set<String> f()
    {
      if (this.f != null)
        return this.f;
      return Collections.emptySet();
    }

    public Set<String> g()
    {
      if (this.g != null)
        return this.g;
      return Collections.emptySet();
    }

    public a h()
    {
      return new a(this, null);
    }

    public static final class a
    {
      private h.a a = new h.a();

      private a()
      {
      }

      private a(h.a parama)
      {
        this();
        a(h.a.b(parama));
        b(h.a.a(parama));
        c(h.a.c(parama));
        a(h.a.d(parama));
        b(h.a.e(parama));
        if (h.a.f(parama) != null)
          a(h.a.f(parama));
        if (h.a.g(parama) != null)
          b(h.a.g(parama));
      }

      public a a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
      {
        if (paramConversationItemLoaderEntity.isConversation1on1())
        {
          if (paramConversationItemLoaderEntity.isSecret());
          for (String str = "1-on-1 Secret Chat"; ; str = "1-on-1 Chat")
          {
            a(str);
            return this;
          }
        }
        a("Group");
        return this;
      }

      public a a(String paramString)
      {
        h.a.a(this.a, paramString);
        return this;
      }

      public a a(Collection<String> paramCollection)
      {
        if (h.a.f(this.a) == null)
          h.a.a(this.a, new HashSet(paramCollection.size()));
        h.a.f(this.a).addAll(paramCollection);
        return this;
      }

      public a a(boolean paramBoolean)
      {
        h.a.a(this.a, paramBoolean);
        return this;
      }

      public a a(boolean paramBoolean1, boolean paramBoolean2)
      {
        if (paramBoolean1)
        {
          b("Viber Out");
          return this;
        }
        if (paramBoolean2)
        {
          b("Free Video");
          return this;
        }
        b("Free Audio 1-On-1 Call");
        return this;
      }

      public a a(String[] paramArrayOfString)
      {
        if (h.a.f(this.a) == null)
          h.a.a(this.a, new HashSet(paramArrayOfString.length));
        h.a.f(this.a).addAll(Arrays.asList(paramArrayOfString));
        return this;
      }

      public h.a a()
      {
        h.a locala = this.a;
        this.a = new h.a();
        return locala;
      }

      public a b(String paramString)
      {
        h.a.b(this.a, paramString);
        return this;
      }

      public a b(Collection<String> paramCollection)
      {
        if (h.a.g(this.a) == null)
          h.a.b(this.a, new HashSet(paramCollection.size()));
        h.a.g(this.a).addAll(paramCollection);
        return this;
      }

      public a b(boolean paramBoolean)
      {
        h.a.b(this.a, paramBoolean);
        return this;
      }

      public a b(String[] paramArrayOfString)
      {
        if (h.a.g(this.a) == null)
          h.a.b(this.a, new HashSet(paramArrayOfString.length));
        h.a.g(this.a).addAll(Arrays.asList(paramArrayOfString));
        return this;
      }

      public a c(boolean paramBoolean)
      {
        h.a.c(this.a, paramBoolean);
        return this;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.story.b.a.h
 * JD-Core Version:    0.6.2
 */