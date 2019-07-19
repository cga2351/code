package com.viber.voip.messages.conversation;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.LoaderManager;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.viber.common.b.b;
import com.viber.dexshared.Logger;
import com.viber.provider.d.a;
import com.viber.provider.messages.b.c.d;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.controller.ai.l;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.bv.e;
import com.viber.voip.messages.controller.bv.l;
import com.viber.voip.messages.controller.bv.n;
import com.viber.voip.messages.controller.bv.n.a;
import com.viber.voip.messages.controller.bw;
import com.viber.voip.messages.controller.manager.ad;
import com.viber.voip.messages.controller.manager.af;
import com.viber.voip.messages.controller.manager.y;
import com.viber.voip.messages.controller.manager.y.a;
import com.viber.voip.messages.conversation.a.h;
import com.viber.voip.messages.conversation.a.h.a;
import com.viber.voip.messages.ui.MessagesFragmentModeManager.b;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository;
import com.viber.voip.settings.d.al;
import com.viber.voip.settings.d.l;
import com.viber.voip.user.UserData.OwnerChangedEvent;
import com.viber.voip.util.av;
import com.viber.voip.util.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public abstract class n<T extends ConversationLoaderEntity> extends com.viber.provider.d<T>
  implements h.a
{
  protected static final Logger l = ViberEnv.getLogger();
  public static final String m = "conversations.business_inbox_flags & " + av.a(0, 0) + "<>0";
  private static final String w = "conversations.business_inbox_flags & " + av.a(0L, 0) + "=0";
  private boolean A;
  private boolean B = true;
  private boolean C = true;
  private boolean D = true;
  private boolean E = true;
  private boolean F = true;
  private boolean G = false;
  private boolean H = true;
  private boolean I = true;
  private boolean J = false;
  private boolean K = false;
  private boolean L = false;
  private boolean M = false;
  private boolean N = false;
  private boolean O = true;
  private boolean P = true;
  private boolean Q = true;
  private boolean R = true;
  private boolean S = false;
  private boolean T = true;
  private EventBus U;
  private final dagger.a<ConferenceCallsRepository> V;
  private final h W;
  private LruCache<Integer, T> X = new LruCache(30)
  {
    protected int a(Integer paramAnonymousInteger, T paramAnonymousT)
    {
      return 1;
    }
  };
  private bv.l Y = t();
  private bv.n Z = u();
  private d.al aa;
  private final ai.l ab;
  protected final dagger.a<com.viber.voip.messages.k> n;
  protected String o;
  protected Set<Long> p;
  protected boolean q;
  protected ArrayList<T> r;
  protected boolean s = false;
  protected bv.e t;
  protected af u;
  protected Runnable v;
  private a x = a.a;
  private boolean y;
  private int[] z = new int[0];

  private n(int paramInt, Context paramContext, Uri paramUri, LoaderManager paramLoaderManager, dagger.a<com.viber.voip.messages.k> parama, boolean paramBoolean1, boolean paramBoolean2, a parama1, d.a parama2, EventBus paramEventBus, h paramh, dagger.a<ConferenceCallsRepository> parama3)
  {
    super(paramInt, paramUri, paramContext, paramLoaderManager, parama2, 0);
    Handler localHandler = this.i;
    com.viber.common.b.a[] arrayOfa = new com.viber.common.b.a[1];
    arrayOfa[0] = d.l.e;
    this.aa = new d.al(localHandler, arrayOfa)
    {
      public void onPreferencesChanged(com.viber.common.b.a paramAnonymousa)
      {
        n.this.F();
      }
    };
    this.ab = new ai.l()
    {
      public void a(final y paramAnonymousy, final ArrayList paramAnonymousArrayList)
      {
        n.b(n.this).postAtFrontOfQueue(new Runnable()
        {
          public void run()
          {
            if ((paramAnonymousy.a() != null) && (paramAnonymousy.a().equals(n.this.o)))
            {
              n.this.r = paramAnonymousArrayList;
              n.a(n.this);
            }
          }
        });
      }
    };
    this.v = new Runnable()
    {
      public void run()
      {
        n.this.w();
      }
    };
    this.x = parama1;
    this.q = paramBoolean1;
    this.A = paramBoolean2;
    this.n = parama;
    this.s = ViberApplication.isTablet(paramContext);
    this.U = paramEventBus;
    this.V = parama3;
    b("conversations._id");
    if (paramh != null);
    while (true)
    {
      this.W = paramh;
      d("conversations.favourite_conversation DESC,conversations.date DESC");
      this.L = this.s;
      return;
      paramh = h.a;
    }
  }

  protected n(Context paramContext, int paramInt, Uri paramUri, LoaderManager paramLoaderManager, dagger.a<com.viber.voip.messages.k> parama, d.a parama1, EventBus paramEventBus, h paramh, dagger.a<ConferenceCallsRepository> parama2)
  {
    this(paramInt, paramContext, paramUri, paramLoaderManager, parama, false, false, a.a, parama1, paramEventBus, paramh, parama2);
  }

  public n(Context paramContext, LoaderManager paramLoaderManager, dagger.a<com.viber.voip.messages.k> parama, boolean paramBoolean1, boolean paramBoolean2, a parama1, Bundle paramBundle, String paramString, d.a parama2, EventBus paramEventBus, h paramh, dagger.a<ConferenceCallsRepository> parama3)
  {
    this(1, paramContext, c.d.a, paramLoaderManager, parama, paramBoolean1, paramBoolean2, parama1, parama2, paramEventBus, paramh, parama3);
    this.o = paramString;
  }

  private String H()
  {
    return f(0) + " AND (" + "messages" + "." + "_id" + ">0 OR " + I() + "conversations" + "." + "bot_reply" + " <> '' OR " + "conversations.flags & 33554432>0" + " OR " + "conversations.flags & 16777216>0" + ")";
  }

  private String I()
  {
    if (d.l.e.d())
      return "";
    return m + " OR ";
  }

  private String J()
  {
    String str = f(1);
    return str + " AND " + N();
  }

  private String K()
  {
    return f(4);
  }

  private String L()
  {
    if (this.y)
      return "conversations.conversation_type = 2 AND  conversations.group_role IN (2,1)";
    return "conversations.conversation_type = 2";
  }

  private String M()
  {
    if (this.y);
    for (String str = "conversations.conversation_type = 5 AND  conversations.group_role <> 4 AND EXISTS (SELECT public_accounts.verified AS pa_flags, public_accounts.community_privileges AS privileges FROM public_accounts WHERE conversations.group_id = public_accounts.group_id AND pa_flags & 134217728 = 0 AND (conversations.group_role IN (2,1) OR (conversations.group_role = 3 AND privileges & 9223372036854775807 <> 0)) LIMIT 1)"; ; str = "conversations.conversation_type = 5")
      return str + " AND " + N();
  }

  private String N()
  {
    if ((this.z != null) && (this.z.length > 0))
      return "(group_role IN(" + com.viber.voip.s.a.b(this.z) + "))";
    return "(1)";
  }

  private List<Long> O()
  {
    if (this.V != null)
      return ((ConferenceCallsRepository)this.V.get()).getConversationConferenceIdsAvailableToJoin();
    return Collections.emptyList();
  }

  private String P()
  {
    return "conversations.deleted=0";
  }

  private String Q()
  {
    return "conversations.flags & (1 << 0)=0";
  }

  private String R()
  {
    return m + " AND " + "messages" + "." + "_id" + ">0";
  }

  private String S()
  {
    return "conversations.grouping_key=? AND messages._id>0";
  }

  private String T()
  {
    return "conversations.flags & (1 << 19) > 0 AND messages._id > 0";
  }

  private String a(a parama)
  {
    ArrayList localArrayList = new ArrayList();
    switch (8.a[parama.ordinal()])
    {
    default:
      throw new IllegalArgumentException("Unexpected conversationType " + parama);
    case 1:
      localArrayList.add(H());
      localArrayList.add(J());
      if (this.O)
        localArrayList.add(M());
      localArrayList.add(K());
      List localList = O();
      if ((!this.p.isEmpty()) || (!localList.isEmpty()))
      {
        Collection[] arrayOfCollection = new Collection[2];
        arrayOfCollection[0] = this.p;
        arrayOfCollection[1] = localList;
        localArrayList.add(a(u.a(arrayOfCollection)));
      }
      break;
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    }
    while (true)
    {
      if (this.J)
        localArrayList.add(L());
      return com.viber.voip.s.a.f(localArrayList);
      localArrayList.add(H());
      if (!this.p.isEmpty())
      {
        localArrayList.add(a(this.p));
        continue;
        localArrayList.add(J());
        if (this.O)
        {
          localArrayList.add(M());
          continue;
          localArrayList.add(R());
          continue;
          localArrayList.add(S());
          continue;
          localArrayList.add(T());
        }
      }
    }
  }

  private String a(Collection<Long> paramCollection)
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    localStringBuilder.append("conversations._id IN (");
    com.viber.voip.s.a.a(paramCollection, localStringBuilder).append(')');
    return localStringBuilder.toString();
  }

  private String f(int paramInt)
  {
    return "conversations.conversation_type=" + paramInt;
  }

  public boolean A()
  {
    return this.F;
  }

  public Map<Long, MessagesFragmentModeManager.b> B()
  {
    return a(null);
  }

  protected MessagesFragmentModeManager.b C()
  {
    int i = 1;
    int k = this.f.getInt(i);
    int i1 = this.f.getInt(6);
    long l1 = this.f.getLong(3);
    int i2 = this.f.getInt(9);
    int i3;
    if (com.viber.voip.messages.m.e(k))
    {
      i3 = this.f.getInt(50);
      if (k == 0)
        break label99;
    }
    while (true)
    {
      return new MessagesFragmentModeManager.b(i, false, false, k, i1, l1, i2, i3);
      i3 = 0;
      break;
      label99: int j = 0;
    }
  }

  protected void D()
  {
    this.r = null;
    this.o = null;
  }

  public ArrayList<T> E()
  {
    return this.r;
  }

  protected final void F()
  {
    a(r());
    if (TextUtils.isEmpty(this.o))
      l();
  }

  public void G()
  {
    F();
  }

  public long a(int paramInt)
  {
    if (this.r == null)
      return super.a(paramInt);
    if (paramInt < this.r.size())
    {
      ConversationLoaderEntity localConversationLoaderEntity = (ConversationLoaderEntity)this.r.get(paramInt);
      if (localConversationLoaderEntity != null)
        return localConversationLoaderEntity.getId();
      return 0L;
    }
    return 0L;
  }

  public Map<Long, MessagesFragmentModeManager.b> a(Set<Long> paramSet)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    if (b_(0))
      do
      {
        long l1 = this.f.getLong(0);
        if ((l1 != -10L) && ((paramSet == null) || (paramSet.contains(Long.valueOf(l1)))))
          localLinkedHashMap.put(Long.valueOf(l1), C());
      }
      while (this.f.moveToNext());
    return localLinkedHashMap;
  }

  public void a(Bundle paramBundle)
  {
  }

  protected void a(String paramString, long paramLong)
  {
    this.i.removeCallbacks(this.v);
    if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(paramString.trim())))
    {
      D();
      if (!this.s)
        h();
      k();
      return;
    }
    this.o = paramString.trim();
    this.i.postDelayed(this.v, paramLong);
  }

  protected void a(Set<Long> paramSet, boolean paramBoolean)
  {
    if (this.q)
    {
      this.p = paramSet;
      a(r());
      if (!TextUtils.isEmpty(this.o))
        w();
    }
    else
    {
      return;
    }
    l();
  }

  public void a(boolean paramBoolean)
  {
    this.B = paramBoolean;
  }

  public void a(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null)
      paramArrayOfInt = new int[0];
    this.z = paramArrayOfInt;
  }

  protected abstract T b(Cursor paramCursor);

  public void b(boolean paramBoolean)
  {
    this.C = paramBoolean;
  }

  public void c(boolean paramBoolean)
  {
    this.D = paramBoolean;
  }

  public void d(boolean paramBoolean)
  {
    this.E = paramBoolean;
  }

  public T e(int paramInt)
  {
    if (this.r == null)
    {
      ConversationLoaderEntity localConversationLoaderEntity = (ConversationLoaderEntity)this.X.get(Integer.valueOf(paramInt));
      if ((localConversationLoaderEntity == null) && (b_(paramInt)))
      {
        localConversationLoaderEntity = b(this.f);
        this.X.put(Integer.valueOf(paramInt), localConversationLoaderEntity);
      }
      return localConversationLoaderEntity;
    }
    if ((paramInt >= 0) && (paramInt < this.r.size()))
      return (ConversationLoaderEntity)this.r.get(paramInt);
    return null;
  }

  public void e(boolean paramBoolean)
  {
    this.F = paramBoolean;
  }

  public void f(String paramString)
  {
    a(paramString, 200L);
  }

  public void f(boolean paramBoolean)
  {
    this.G = paramBoolean;
  }

  public void g(boolean paramBoolean)
  {
    this.H = paramBoolean;
  }

  public int getCount()
  {
    if (this.r == null)
      return super.getCount();
    return this.r.size();
  }

  public void h(boolean paramBoolean)
  {
    this.S = paramBoolean;
  }

  public void i()
  {
    try
    {
      this.p = z();
      a(r());
      super.i();
      if (!TextUtils.isEmpty(this.o))
        f(this.o);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void i(boolean paramBoolean)
  {
    this.I = paramBoolean;
  }

  public void j(boolean paramBoolean)
  {
    this.J = paramBoolean;
  }

  public void k(boolean paramBoolean)
  {
    this.O = paramBoolean;
  }

  public void l()
  {
    if (this.j)
    {
      this.k = true;
      return;
    }
    if (!TextUtils.isEmpty(this.o))
      a(this.o, 500L);
    super.l();
  }

  public void l(boolean paramBoolean)
  {
    this.P = paramBoolean;
  }

  protected void m()
  {
    super.m();
    this.X.evictAll();
  }

  public void m(boolean paramBoolean)
  {
    this.T = paramBoolean;
  }

  public void n(boolean paramBoolean)
  {
    this.Q = paramBoolean;
  }

  public String o()
  {
    h localh = this.W;
    if (!TextUtils.isEmpty(this.o));
    for (boolean bool = true; ; bool = false)
    {
      String str = localh.a(bool);
      if (TextUtils.isEmpty(str))
        str = super.o();
      return str;
    }
  }

  public void o(boolean paramBoolean)
  {
    this.R = paramBoolean;
  }

  @Subscribe
  public void onOwnerChanged(UserData.OwnerChangedEvent paramOwnerChangedEvent)
  {
    l();
  }

  public void p()
  {
    super.p();
    this.W.a(this);
    if (!this.U.isRegistered(this))
      this.U.register(this);
    bv localbv = ((com.viber.voip.messages.k)this.n.get()).b();
    localbv.a(this.Y);
    localbv.a(this.Z);
    localbv.a(s());
    com.viber.voip.settings.d.a(this.aa);
  }

  public void p(boolean paramBoolean)
  {
    this.y = paramBoolean;
  }

  public void q()
  {
    super.q();
    this.W.b(this);
    this.U.unregister(this);
    bv localbv = ((com.viber.voip.messages.k)this.n.get()).b();
    localbv.b(this.Y);
    localbv.b(s());
    localbv.b(this.Z);
    com.viber.voip.settings.d.b(this.aa);
  }

  public void q(boolean paramBoolean)
  {
    this.K = paramBoolean;
  }

  protected String r()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String[] arrayOfString = new String[3];
    arrayOfString[0] = P();
    arrayOfString[1] = "conversations.conversation_type <> 0 OR participants_info.participant_info_flags & 2 = 0";
    arrayOfString[2] = a(this.x);
    localStringBuilder.append(com.viber.voip.s.a.c(arrayOfString));
    if (!this.A)
      localStringBuilder.append(" AND ").append(Q());
    if (!this.I)
      localStringBuilder.append(" AND ").append("conversations.flags & (1 << 19)=0 ");
    if (!this.P)
      localStringBuilder.append(" AND ").append("conversations.flags & (1 << 24)=0");
    if (!this.Q)
      localStringBuilder.append(" AND ").append("conversations.conversation_type<>4");
    while (true)
    {
      if (this.K)
        localStringBuilder.append(" AND ").append(w);
      if (this.L)
        localStringBuilder.append(" AND ").append("conversations.grouping_key IS NULL");
      if (this.M)
        localStringBuilder.append(" AND ").append("(conversations.conversation_type <> 0 OR participants_info.member_id NOT LIKE 'em:%')");
      localStringBuilder.append(" AND (").append(v()).append(")");
      if (!this.T)
        localStringBuilder.append(" AND ").append("conversations.flags & (1 << 36)=0");
      return localStringBuilder.toString();
      if (!this.R)
        localStringBuilder.append(" AND (conversations.conversation_type=4 AND (SELECT COUNT(*) from [participants] where [participants].[conversation_id] = conversations._id and [participants].[active] = 0) > 1 OR conversations.conversation_type<>4)");
    }
  }

  public void r(boolean paramBoolean)
  {
    this.L = paramBoolean;
  }

  protected bv.e s()
  {
    if (this.t == null)
      this.t = new bv.e()
      {
        public void onChange(Set<Long> paramAnonymousSet, int paramAnonymousInt, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
        {
          if (!com.viber.voip.messages.m.a(paramAnonymousInt))
            n.this.l();
        }

        public void onConversationClosed(boolean paramAnonymousBoolean, long paramAnonymousLong)
        {
          bw.a(this, paramAnonymousBoolean, paramAnonymousLong);
        }

        public void onDelete(Set<Long> paramAnonymousSet, int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          if (!com.viber.voip.messages.m.a(paramAnonymousInt))
            n.this.l();
        }

        public void onOpen1to1(Set<Long> paramAnonymousSet, boolean paramAnonymousBoolean)
        {
          n.this.a(paramAnonymousSet, paramAnonymousBoolean);
        }

        public void onOpenConversation(ConversationItemLoaderEntity paramAnonymousConversationItemLoaderEntity)
        {
          bw.a(this, paramAnonymousConversationItemLoaderEntity);
        }

        public void onOpenPublicGroup(long paramAnonymousLong, Set paramAnonymousSet)
        {
          bw.a(this, paramAnonymousLong, paramAnonymousSet);
        }

        public void onRead(Set<Long> paramAnonymousSet, int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          if (!com.viber.voip.messages.m.a(paramAnonymousInt))
            n.this.l();
        }

        public void onReadOutgoing(long paramAnonymousLong, int paramAnonymousInt, boolean paramAnonymousBoolean)
        {
          if (!com.viber.voip.messages.m.a(paramAnonymousInt))
            n.this.l();
        }

        public void onWatchersCountChange(long paramAnonymousLong, int paramAnonymousInt)
        {
          bw.a(this, paramAnonymousLong, paramAnonymousInt);
        }
      };
    return this.t;
  }

  public void s(boolean paramBoolean)
  {
    this.M = paramBoolean;
  }

  protected bv.l t()
  {
    return new bv.l()
    {
      public void a(long paramAnonymousLong1, long paramAnonymousLong2, boolean paramAnonymousBoolean)
      {
      }

      public void a(long paramAnonymousLong, Set<Long> paramAnonymousSet)
      {
        n.this.l();
      }

      public void a(MessageEntity paramAnonymousMessageEntity, boolean paramAnonymousBoolean)
      {
      }

      public void a(Set<Long> paramAnonymousSet, boolean paramAnonymousBoolean)
      {
        n.this.l();
      }

      public void a(Set<Long> paramAnonymousSet, boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        n.this.l();
      }

      public void b(long paramAnonymousLong1, long paramAnonymousLong2, boolean paramAnonymousBoolean)
      {
        n.this.l();
      }
    };
  }

  public void t(boolean paramBoolean)
  {
    this.N = paramBoolean;
  }

  protected bv.n u()
  {
    return new bv.n()
    {
      public void onChange(Set<Long> paramAnonymousSet, Set<String> paramAnonymousSet1, boolean paramAnonymousBoolean)
      {
        n.this.l();
      }

      public void onContactStatusChanged(Map<Long, bv.n.a> paramAnonymousMap)
      {
      }

      public void onInitCache()
      {
        n.this.l();
      }

      public void onNewInfo(List<com.viber.voip.model.entity.m> paramAnonymousList, boolean paramAnonymousBoolean)
      {
      }

      public void onParticipantDeleted(com.viber.voip.model.entity.m paramAnonymousm)
      {
      }
    };
  }

  protected String v()
  {
    return "conversations.flags & 294912=0";
  }

  protected void w()
  {
    if (this.u == null)
      this.u = x();
    ((com.viber.voip.messages.k)this.n.get()).c().a(y().a(), this.u, this.ab);
  }

  protected af x()
  {
    return ad.a(this.d.getContentResolver());
  }

  protected y.a y()
  {
    boolean bool1 = true;
    y.a locala = new y.a().a(this.o);
    locala.a(this.y);
    locala.a(this.z);
    locala.e(this.B);
    boolean bool2;
    if ((this.C) && (this.O))
    {
      bool2 = bool1;
      locala.f(bool2);
      locala.d(this.J);
      locala.g(this.D);
      locala.b(this.F);
      locala.c(this.G);
      locala.h(this.A);
      locala.i(this.H);
      locala.j(this.I);
      locala.k(this.P);
      locala.l(this.S);
      if ((!this.Q) || (!this.E))
        break label212;
    }
    while (true)
    {
      locala.m(bool1);
      locala.n(this.R);
      locala.b(com.viber.voip.s.a.e(this.p));
      locala.o(this.M);
      locala.p(this.N);
      return locala;
      bool2 = false;
      break;
      label212: bool1 = false;
    }
  }

  protected Set<Long> z()
  {
    return ((com.viber.voip.messages.k)this.n.get()).a().a();
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[8];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
      arrayOfa[5] = f;
      arrayOfa[6] = g;
      arrayOfa[7] = h;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.n
 * JD-Core Version:    0.6.2
 */