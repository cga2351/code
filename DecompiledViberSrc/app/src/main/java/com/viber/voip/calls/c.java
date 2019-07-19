package com.viber.voip.calls;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.app.LoaderManager;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.provider.d.a;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.e;
import com.viber.voip.contacts.c.d.g;
import com.viber.voip.contacts.c.d.g.b;
import com.viber.voip.messages.controller.bv.n;
import com.viber.voip.messages.controller.bv.n.a;
import com.viber.voip.messages.controller.ci;
import com.viber.voip.messages.controller.ci.a;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.messages.d.b;
import com.viber.voip.messages.k;
import com.viber.voip.messages.orm.creator.CreatorHelper;
import com.viber.voip.model.AggregatedCall;
import com.viber.voip.model.entity.AggregatedCallEntity;
import com.viber.voip.model.entity.m;
import com.viber.voip.s.a;
import com.viber.voip.util.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class c extends com.viber.provider.d
{
  private static final Logger m = ViberEnv.getLogger();
  private static Map<String, m> t = new HashMap();
  protected LruCache<Integer, AggregatedCall> l = new LruCache(20)
  {
    protected int a(Integer paramAnonymousInteger, AggregatedCall paramAnonymousAggregatedCall)
    {
      return 1;
    }
  };
  private String n;
  private String o;
  private String p;
  private boolean q;
  private int r = -1;
  private Handler s = av.e.a.a();
  private final Runnable u = new Runnable()
  {
    public void run()
    {
      c.this.l();
    }
  };
  private g.b v = new g.b()
  {
    public void a()
    {
      c.this.l();
    }
  };
  private d.c w = new d.c()
  {
    public void a()
    {
      c.this.l();
    }
  };
  private bv.n x = new bv.n()
  {
    public void onChange(Set<Long> paramAnonymousSet, Set<String> paramAnonymousSet1, boolean paramAnonymousBoolean)
    {
      Iterator localIterator = paramAnonymousSet1.iterator();
      int i = 0;
      String str;
      if (localIterator.hasNext())
        str = (String)localIterator.next();
      while (true)
      {
        synchronized (c.t())
        {
          m localm1 = (m)c.t().remove(str);
          if (localm1 == null)
            break label136;
          m localm2 = com.viber.voip.messages.d.c.c().b(localm1.getId());
          if (!str.equals(localm2.getNumber()))
            break label143;
          c.t().put(str, localm2);
          break label143;
          i = j;
        }
        if (i != 0)
          c.this.l();
        return;
        label136: int j = i;
        continue;
        label143: j = 1;
      }
    }

    public void onContactStatusChanged(Map<Long, bv.n.a> paramAnonymousMap)
    {
    }

    public void onInitCache()
    {
    }

    public void onNewInfo(List<m> paramAnonymousList, boolean paramAnonymousBoolean)
    {
    }

    public void onParticipantDeleted(m paramAnonymousm)
    {
    }
  };

  protected c(int paramInt1, Uri paramUri, Context paramContext, LoaderManager paramLoaderManager, d.a parama, int paramInt2)
  {
    super(paramInt1, paramUri, paramContext, paramLoaderManager, parama, paramInt2);
  }

  public c(Context paramContext, LoaderManager paramLoaderManager, String paramString, d.a parama)
  {
    this(15, AggregatedCallEntity.JOIN_CREATOR.getContentUri(), paramContext, paramLoaderManager, parama, 0);
    a(AggregatedCallEntity.JOIN_CREATOR.getProjections());
    d("calls.date DESC,phonebookcontact.low_display_name ASC, phonebookcontact._id");
    u();
    if (!TextUtils.isEmpty(paramString))
      a(paramString, false);
  }

  private a a(String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString3))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (paramString1 != null);
      for (String str1 = paramString1 + " AND "; ; str1 = "")
      {
        String str2 = str1 + paramString2;
        String[] arrayOfString = new String[2];
        arrayOfString[0] = ("%" + paramString3 + "%");
        arrayOfString[1] = ("%" + paramString3 + "%");
        return new a(str2, arrayOfString);
      }
    }
    return new a(paramString1, null);
  }

  private a a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (!TextUtils.isEmpty(paramString3))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (paramString1 != null);
      for (String str1 = paramString1 + " AND "; ; str1 = "")
      {
        String str2 = str1 + paramString2;
        String[] arrayOfString = new String[3];
        arrayOfString[0] = ("%" + paramString3 + "%");
        arrayOfString[1] = ("%" + paramString3 + "%");
        arrayOfString[2] = ("%" + paramString4 + "%");
        return new a(str2, arrayOfString);
      }
    }
    return new a(paramString1, null);
  }

  private void a(String paramString, boolean paramBoolean)
  {
    this.p = paramString;
    String str = "phonebookcontact.low_display_name LIKE ? OR calls.canonized_number LIKE ?";
    HashSet localHashSet = g(paramString);
    if (localHashSet.size() > 0)
    {
      StringBuilder localStringBuilder = new StringBuilder().append(str).append(" OR ");
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = a.b(localHashSet);
      str = String.format("calls.canonized_number IN (%s)", arrayOfObject);
    }
    a locala = a(null, str, paramString);
    a(locala.a());
    b(locala.b());
    if (paramBoolean)
    {
      this.s.removeCallbacks(this.u);
      this.s.postDelayed(this.u, 200L);
    }
  }

  private void a(Set<String> paramSet)
  {
    ViberApplication.getInstance().getMessagesManager().e().b(paramSet, new ci.a()
    {
      public void onGetUserDetail(m[] paramAnonymousArrayOfm)
      {
        int i = paramAnonymousArrayOfm.length;
        int j = 0;
        while (j < i)
        {
          m localm = paramAnonymousArrayOfm[j];
          synchronized (c.t())
          {
            c.t().put(localm.getNumber(), localm);
            j++;
          }
        }
        c.b(c.this).post(new Runnable()
        {
          public void run()
          {
            c.a(c.this).onLoadFinished(c.this, false);
          }
        });
      }

      public void onGetUserError()
      {
      }
    }
    , true);
  }

  private HashSet<String> g(String paramString)
  {
    String str1 = paramString.toLowerCase();
    HashSet localHashSet = new HashSet();
    Iterator localIterator = t.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str2 = ((m)localEntry.getValue()).getViberName();
      if ((!TextUtils.isEmpty(str2)) && (str2.toLowerCase().contains(str1)))
        localHashSet.add(localEntry.getKey());
    }
    return localHashSet;
  }

  private void u()
  {
    a locala = a(null, "phonebookcontact.numbers_name LIKE ? OR calls.canonized_number LIKE ? OR calls.number LIKE ?", this.n, this.o);
    a(locala.a());
    b(locala.b());
  }

  public int a(long paramLong)
  {
    if (paramLong > 0L)
    {
      if (a(this.r) == paramLong)
        return this.r;
      int i = 0;
      int j = getCount();
      while (i < j)
      {
        if (a(i) == paramLong)
        {
          this.r = i;
          return this.r;
        }
        i++;
      }
    }
    this.r = -1;
    return this.r;
  }

  public void a(String paramString1, String paramString2)
  {
    this.n = paramString1;
    this.o = paramString2;
    this.p = this.n;
    u();
    this.s.removeCallbacks(this.u);
    this.s.postDelayed(this.u, 200L);
  }

  public AggregatedCall e(int paramInt)
  {
    AggregatedCall localAggregatedCall = (AggregatedCall)this.l.get(Integer.valueOf(paramInt));
    AggregatedCallEntity localAggregatedCallEntity;
    if ((localAggregatedCall == null) && (b_(paramInt)))
    {
      localAggregatedCallEntity = (AggregatedCallEntity)AggregatedCallEntity.JOIN_CREATOR.createInstance(this.f);
      this.l.put(Integer.valueOf(paramInt), localAggregatedCallEntity);
    }
    for (Object localObject1 = localAggregatedCallEntity; ; localObject1 = localAggregatedCall)
    {
      if (((AggregatedCall)localObject1).getContact() == null);
      synchronized (t)
      {
        m localm = (m)t.get(((AggregatedCall)localObject1).getCanonizedNumber());
        if (localm != null)
          ((AggregatedCall)localObject1).setContact(x.a(localm));
        return localObject1;
      }
    }
  }

  public void f(String paramString)
  {
    a(paramString, true);
  }

  protected void m()
  {
    int i = 0;
    super.m();
    this.l.evictAll();
    this.q = false;
    if (this.f == null)
      return;
    HashSet localHashSet = new HashSet();
    while (true)
    {
      if (i < this.f.getCount())
      {
        AggregatedCall localAggregatedCall = e(i);
        if (localAggregatedCall != null)
        {
          if (!this.q)
            this.q = localAggregatedCall.isMissed();
          if ((localAggregatedCall.getContact() == null) && (localAggregatedCall.isViberCall()))
            synchronized (t)
            {
              if (t.get(localAggregatedCall.getCanonizedNumber()) == null)
                localHashSet.add(localAggregatedCall.getCanonizedNumber());
            }
        }
      }
      else
      {
        if (localHashSet.isEmpty())
          break;
        a(localHashSet);
        return;
      }
      i++;
    }
  }

  public void p()
  {
    super.p();
    ViberApplication.getInstance().getContactManager().a(this.v);
    ViberApplication.getInstance().getRecentCallsManager().a(this.w);
    o.a().a(this.x);
  }

  public void q()
  {
    super.q();
    ViberApplication.getInstance().getContactManager().b(this.v);
    ViberApplication.getInstance().getRecentCallsManager().b(this.w);
    o.a().b(this.x);
  }

  public String r()
  {
    return this.p;
  }

  public List<Integer> s()
  {
    ArrayList localArrayList = new ArrayList();
    int i = getCount();
    for (int j = 0; j < i; j++)
      localArrayList.add(Integer.valueOf(j));
    return localArrayList;
  }

  static class a
  {
    String a;
    String[] b;

    public a(String paramString, String[] paramArrayOfString)
    {
      this.a = paramString;
      this.b = paramArrayOfString;
    }

    public String a()
    {
      return this.a;
    }

    public String[] b()
    {
      return this.b;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.calls.c
 * JD-Core Version:    0.6.2
 */