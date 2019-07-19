package com.viber.voip.contacts.ui.list;

import android.net.Uri;
import android.os.Handler;
import android.support.v7.d.c.b;
import com.viber.dexshared.Logger;
import com.viber.jni.connection.ConnectionDelegate;
import com.viber.jni.connection.ConnectionListener;
import com.viber.voip.ViberEnv;
import com.viber.voip.invitelinks.f.a;
import com.viber.voip.invitelinks.g;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.bv.t;
import com.viber.voip.messages.controller.p;
import com.viber.voip.messages.controller.p.a;
import com.viber.voip.messages.conversation.adapter.a.c.a.e;
import com.viber.voip.messages.conversation.ae;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationItemLoaderEntity;
import com.viber.voip.model.a;
import com.viber.voip.util.cd;
import com.viber.voip.util.cl;
import com.viber.voip.util.da;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class al
  implements ak, f.a
{
  private static final Logger a = ViberEnv.getLogger();
  private static final at b = (at)cl.b(at.class);
  private at c;
  private final e d;
  private final p e;
  private com.viber.voip.invitelinks.f f;
  private final com.viber.voip.invitelinks.linkscreen.f g;
  private final bv h;
  private final ConnectionListener i;
  private final com.viber.voip.analytics.story.e.c j;
  private final Handler k;
  private final Handler l;
  private final com.viber.voip.contacts.c.d.m m;
  private List<z> n;
  private List<z> o;
  private List<z> p;
  private com.viber.voip.messages.conversation.ac q;
  private PublicGroupConversationItemLoaderEntity r;
  private int s;
  private boolean t;
  private p.a u = new p.a()
  {
    public void a(int paramAnonymousInt)
    {
      al.a(al.this).post(new aq(this));
    }

    public void a(Set<Member> paramAnonymousSet, boolean paramAnonymousBoolean)
    {
      al.a(al.this, paramAnonymousSet, paramAnonymousBoolean);
    }
  };
  private bv.t v = new bv.t()
  {
    public void onMembersRemovedFromGroup(long paramAnonymousLong, int paramAnonymousInt, String[] paramAnonymousArrayOfString, Map<String, Integer> paramAnonymousMap)
    {
      if ((al.c(al.this) != null) && (al.c(al.this).getGroupId() == paramAnonymousLong) && (paramAnonymousInt == 0))
        al.d(al.this).post(new ar(this, paramAnonymousArrayOfString));
    }
  };
  private ConnectionDelegate w = new ConnectionDelegate()
  {
    public void onConnect()
    {
      al.this.f();
    }

    public void onConnectionStateChange(int paramAnonymousInt)
    {
    }
  };

  al(at paramat, e parame, p paramp, com.viber.voip.invitelinks.f paramf, com.viber.voip.invitelinks.linkscreen.f paramf1, com.viber.voip.contacts.c.d.m paramm, bv parambv, ConnectionListener paramConnectionListener, com.viber.voip.analytics.story.e.c paramc, Handler paramHandler1, Handler paramHandler2)
  {
    this.c = paramat;
    this.d = parame;
    this.e = paramp;
    this.f = paramf;
    this.g = paramf1;
    this.m = paramm;
    this.h = parambv;
    this.i = paramConnectionListener;
    this.j = paramc;
    this.k = paramHandler1;
    this.l = paramHandler2;
    this.n = new ArrayList();
    this.o = new ArrayList();
    this.p = new ArrayList();
    this.e.a();
    this.h.a(this.v);
    ConnectionListener localConnectionListener = this.i;
    ConnectionDelegate[] arrayOfConnectionDelegate = new ConnectionDelegate[1];
    arrayOfConnectionDelegate[0] = this.w;
    localConnectionListener.registerDelegate(arrayOfConnectionDelegate);
  }

  private void a(List<z> paramList, boolean paramBoolean)
  {
    this.o = paramList;
    c(paramBoolean);
  }

  private void a(Set<Member> paramSet, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Map localMap = this.m.b(paramSet);
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
    {
      Member localMember = (Member)localIterator.next();
      String str1 = localMember.getEncryptedMemberId();
      if (!da.a(str1))
      {
        a locala = (a)localMap.get(str1);
        ae localae;
        if (locala != null)
        {
          localae = ae.a(str1, localMember.getViberName(), locala);
          localArrayList.add(new z(localae));
        }
        else
        {
          if (localMember.getPhotoUri() != null);
          for (String str2 = localMember.getPhotoUri().getLastPathSegment(); ; str2 = null)
          {
            localae = ae.a(str1, localMember.getViberName(), str2);
            break;
          }
        }
      }
    }
    b(localArrayList, paramBoolean);
  }

  private void a(String[] paramArrayOfString)
  {
    int i1 = this.p.size();
    int i2 = paramArrayOfString.length;
    for (int i3 = 0; i3 < i2; i3++)
    {
      String str = paramArrayOfString[i3];
      Iterator localIterator = this.p.iterator();
      while (localIterator.hasNext())
      {
        z localz = (z)localIterator.next();
        if ((str.equals(localz.a.h())) || (str.equals(localz.a.p())))
          localIterator.remove();
      }
    }
    if (i1 != this.p.size())
      c(false);
  }

  private void b(List<z> paramList, boolean paramBoolean)
  {
    this.p.addAll(paramList);
    int i1 = this.n.size();
    this.n.addAll(paramList);
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    localLinkedHashSet.addAll(this.n);
    ArrayList localArrayList = new ArrayList(localLinkedHashSet);
    int i2 = localArrayList.size() - i1;
    this.k.post(new an(this, paramBoolean, paramList, i2, localArrayList, i1));
  }

  private void b(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    for (int i1 = 0; i1 < this.q.getCount(); i1++)
      localArrayList.add(new z(this.q.e(i1)));
    a(localArrayList, paramBoolean);
  }

  private void c(boolean paramBoolean)
  {
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    localLinkedHashSet.addAll(this.o);
    localLinkedHashSet.addAll(this.p);
    ArrayList localArrayList = new ArrayList(localLinkedHashSet);
    if (paramBoolean)
    {
      this.n.clear();
      this.n.addAll(localArrayList);
      this.k.post(new ao(this, localArrayList));
      return;
    }
    c.b localb = android.support.v7.d.c.a(new ac(this.n, localArrayList));
    this.n.clear();
    this.n.addAll(localArrayList);
    this.k.post(new ap(this, localArrayList, localb));
  }

  private void j()
  {
    int i1 = 1;
    int i2 = com.viber.voip.messages.m.e(this.r);
    at localat = this.c;
    int i3;
    if (i2 == 2)
    {
      i3 = i1;
      if (i2 != i1)
        break label51;
    }
    while (true)
    {
      localat.a(new aj(i3, i1));
      return;
      int i4 = 0;
      break;
      label51: i1 = 0;
    }
  }

  private void k()
  {
    if ((this.q == null) || (this.r == null))
      return;
    int i1 = this.q.getCount();
    if (cd.f(this.r.getGroupRole()))
      i1--;
    int i2 = this.r.getWatchersCount();
    this.c.a(i1 + i2);
  }

  private void l()
  {
    if (this.r.getWatchersCount() > 0);
    for (boolean bool = true; ; bool = false)
    {
      this.t = bool;
      this.c.c(this.t);
      return;
    }
  }

  public void a()
  {
    this.c.b(false);
    this.c.l();
  }

  public void a(long paramLong, String paramString)
  {
    g.a(this, paramLong, paramString);
  }

  public void a(com.viber.voip.messages.conversation.ac paramac, boolean paramBoolean)
  {
    this.q = paramac;
    k();
    this.l.post(new am(this, paramBoolean));
  }

  public void a(PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity, String paramString)
  {
    this.g.c(paramPublicGroupConversationItemLoaderEntity.getId(), paramPublicGroupConversationItemLoaderEntity.getGroupName(), paramPublicGroupConversationItemLoaderEntity.getIconUri(), paramString);
    this.c.b(false);
  }

  public void a(PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity, boolean paramBoolean)
  {
    this.r = paramPublicGroupConversationItemLoaderEntity;
    j();
    int i1 = this.r.getGroupRole();
    if (this.d.c() != i1)
    {
      this.d.a(i1);
      this.c.a(this.d);
    }
    k();
    if (paramBoolean)
      l();
  }

  public void b()
  {
    this.c.b(false);
    this.c.m();
  }

  public void c()
  {
    this.c.b(false);
    this.c.n();
  }

  public void d()
  {
    this.c.b(false);
    this.c.o();
  }

  public void e()
  {
    j();
  }

  public void f()
  {
    if (!this.t)
      return;
    this.e.a(this.d.d(), this.s, 50, this.u);
  }

  public void g()
  {
    this.c.b(true);
    this.f.a(this.r, false, this);
  }

  public void h()
  {
    if ((this.q == null) || (this.q.getCount() < 1) || (this.r == null))
      return;
    this.j.b("Participants List", this.r);
    this.c.a(this.r, this.q.getCount());
  }

  public void i()
  {
    this.h.b(this.v);
    this.e.b();
    this.i.removeDelegate(this.w);
    this.c = b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.list.al
 * JD-Core Version:    0.6.2
 */