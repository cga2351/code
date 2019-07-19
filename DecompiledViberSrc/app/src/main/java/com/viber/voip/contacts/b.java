package com.viber.voip.contacts;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.app.LoaderManager;
import android.support.v4.util.LruCache;
import com.viber.provider.d.a;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.contacts.c.d.g;
import com.viber.voip.contacts.c.d.g.b;
import com.viber.voip.messages.orm.creator.CreatorHelper;
import com.viber.voip.model.entity.z;
import com.viber.voip.registration.af;
import com.viber.voip.registration.ao;
import com.viber.voip.user.UserManager;
import com.viber.voip.util.da;

public class b extends com.viber.provider.d
  implements a
{
  private static final String p = "phonebookdata.data2 IN(SELECT data2 FROM walletnumbers,phonebookdata WHERE wallet_wu_status=" + z.b + " AND " + "data2" + "=" + "canonized_number" + ")";
  private static final String q = "vibernumbers.canonized_number IN(SELECT data2 FROM walletnumbers,phonebookdata WHERE wallet_wu_status=" + z.b + " AND " + "data2" + "=" + "canonized_number" + ")";
  private static final String r = "phonebookcontact.viber=0 AND " + p;
  private g.b A = new g.b()
  {
    public void a()
    {
      b.this.l();
    }
  };
  protected Handler l;
  protected boolean m;
  protected com.viber.voip.contacts.d.a n;
  protected final Runnable o = new Runnable()
  {
    public void run()
    {
      b.this.l();
    }
  };
  private final a s = new a();
  private final a t = new a();
  private final a u = new a();
  private final a v = new a();
  private final dagger.a<g> w;
  private b x = b.b;
  private boolean y;
  private LruCache<Integer, com.viber.voip.model.c> z = new LruCache(20)
  {
    protected int a(Integer paramAnonymousInteger, com.viber.voip.model.c paramAnonymousc)
    {
      return 1;
    }
  };

  public b(int paramInt, Context paramContext, LoaderManager paramLoaderManager, dagger.a<g> parama, d.a parama1, b paramb)
  {
    super(paramInt, com.viber.voip.model.entity.d.d.getContentUri(), paramContext, paramLoaderManager, parama1, 0);
    this.w = parama;
    this.l = av.a(av.e.a);
    if ((!UserManager.from(paramContext).getRegistrationValues().r()) || (ao.f()));
    for (Object localObject = new com.viber.voip.contacts.d.d(); ; localObject = new com.viber.voip.contacts.d.c())
    {
      this.n = ((com.viber.voip.contacts.d.a)localObject);
      a(paramb, false);
      a(com.viber.voip.model.entity.d.d.getProjections());
      return;
    }
  }

  private void a(a parama, a[] paramArrayOfa)
  {
    if (parama != null)
      a.c(parama);
    if (paramArrayOfa != null)
    {
      int i = paramArrayOfa.length;
      for (int j = 0; j < i; j++)
        a.d(paramArrayOfa[j]);
    }
  }

  private void a(a[] paramArrayOfa)
  {
    if (paramArrayOfa != null)
    {
      int i = paramArrayOfa.length;
      for (int j = 0; j < i; j++)
        a.b(paramArrayOfa[j]);
    }
  }

  private String b(String paramString1, String paramString2)
  {
    if (da.a(paramString1));
    while (true)
    {
      if (da.a(paramString2))
        paramString2 = "";
      return paramString2;
      if (da.a(paramString2))
        paramString2 = paramString1;
      else
        paramString2 = paramString1 + " AND " + paramString2;
    }
  }

  public int a(long paramLong)
  {
    return a.a(this.u, paramLong);
  }

  public String a()
  {
    return this.n.c();
  }

  public void a(b paramb)
  {
    a(paramb, true);
  }

  public void a(b paramb, boolean paramBoolean)
  {
    if (this.x != paramb)
    {
      this.x = paramb;
      a(b.a(paramb));
      if ((paramBoolean) && (!x_()))
        l();
    }
  }

  public void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, 0L);
  }

  public void a(String paramString1, String paramString2, long paramLong)
  {
    if (!d())
      return;
    a(paramString1, paramString2, true, paramLong);
  }

  public void a(String paramString1, String paramString2, b paramb)
  {
    a(paramb);
    a(paramString1, paramString2, false, 0L);
    i();
  }

  protected void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    a(paramString1, paramString2, paramBoolean, 0L);
  }

  protected void a(String paramString1, String paramString2, boolean paramBoolean, long paramLong)
  {
    boolean bool;
    Uri localUri;
    label42: String[] arrayOfString;
    label68: String str1;
    if (!da.a(paramString1))
    {
      bool = true;
      this.m = bool;
      this.y = this.m;
      if (!this.m)
        break label152;
      localUri = this.n.a();
      a(localUri);
      if (!this.m)
        break label163;
      arrayOfString = this.n.a(paramString1, paramString2);
      b(arrayOfString);
      if (!this.m)
        break label197;
      str1 = t();
      label87: if (!this.m)
        break label204;
    }
    label152: label163: label197: label204: for (String str2 = this.x.a(); ; str2 = b.a(this.x))
    {
      a(b(str1, str2));
      if (paramBoolean)
      {
        this.l.removeCallbacks(this.o);
        this.l.postDelayed(this.o, 200L);
      }
      return;
      bool = false;
      break;
      localUri = com.viber.voip.model.entity.d.d.getContentUri();
      break label42;
      arrayOfString = new String[1];
      arrayOfString[0] = ("conversationId:" + paramLong);
      break label68;
      str1 = "";
      break label87;
    }
  }

  public void b(b paramb)
  {
    a(paramb);
    i();
  }

  public com.viber.voip.model.c c(int paramInt)
  {
    com.viber.voip.model.c localc = (com.viber.voip.model.c)this.z.get(Integer.valueOf(paramInt));
    if ((localc == null) && (b_(paramInt)))
    {
      localc = (com.viber.voip.model.c)com.viber.voip.model.entity.d.d.createInstance(this.f);
      this.z.put(Integer.valueOf(paramInt), localc);
    }
    return localc;
  }

  protected void h()
  {
    try
    {
      super.h();
      this.y = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  protected void m()
  {
    super.m();
    this.z.evictAll();
    a[] arrayOfa1 = new a[4];
    arrayOfa1[0] = this.s;
    arrayOfa1[1] = this.t;
    arrayOfa1[2] = this.u;
    arrayOfa1[3] = this.v;
    a(arrayOfa1);
    if (this.f == null)
      return;
    int i = this.f.getColumnIndex("alias_union_type");
    int j = 0;
    label72: int k;
    if ((j < this.f.getCount()) && (b_(j)) && (i != -1))
    {
      k = this.f.getInt(i);
      if (k != 2)
        break label134;
      a(this.s, new a[0]);
    }
    label134: label179: 
    do
      while (true)
      {
        j++;
        break label72;
        break;
        if (k != 1)
          break label179;
        a locala = this.t;
        a[] arrayOfa2 = new a[2];
        arrayOfa2[0] = this.u;
        arrayOfa2[1] = this.v;
        a(locala, arrayOfa2);
      }
    while (k != 3);
    a.a(this.u, getCount() - a.a(this.u));
  }

  public void p()
  {
    super.p();
    ((g)this.w.get()).a(this.A);
  }

  public void q()
  {
    super.q();
    ((g)this.w.get()).b(this.A);
  }

  public b r()
  {
    return this.x;
  }

  public boolean s()
  {
    return this.y;
  }

  protected String t()
  {
    return this.n.b();
  }

  public a u()
  {
    return this.s;
  }

  public a v()
  {
    return this.t;
  }

  public a w()
  {
    return this.u;
  }

  public boolean x_()
  {
    return this.m;
  }

  public class a
    implements a
  {
    private int b;
    private int c;
    private int d = -1;

    public a()
    {
    }

    private int a(long paramLong)
    {
      if (paramLong > 0L)
      {
        if (a(this.d) == paramLong)
          return this.d;
        for (int i = 0; i < this.c; i++)
          if (a(i) == paramLong)
          {
            this.d = i;
            return this.d;
          }
      }
      this.d = -1;
      return this.d;
    }

    private void c()
    {
      this.b = 0;
      this.c = 0;
    }

    public long a(int paramInt)
    {
      if ((paramInt >= 0) && (paramInt < this.c))
        return b.this.a(paramInt + this.b);
      return -1L;
    }

    public String a()
    {
      return b.this.a();
    }

    public com.viber.voip.model.c c(int paramInt)
    {
      if ((paramInt >= 0) && (paramInt < this.c))
        return b.this.c(paramInt + this.b);
      return null;
    }

    public int getCount()
    {
      return this.c;
    }

    public boolean x_()
    {
      return b.this.x_();
    }
  }

  public static enum b
  {
    private final String g;
    private final String h;

    static
    {
      b[] arrayOfb = new b[6];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
      arrayOfb[2] = c;
      arrayOfb[3] = d;
      arrayOfb[4] = e;
      arrayOfb[5] = f;
    }

    private b(String paramString1, String paramString2)
    {
      this.g = paramString1;
      this.h = paramString2;
    }

    private String b()
    {
      return this.g;
    }

    public String a()
    {
      return this.h;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.b
 * JD-Core Version:    0.6.2
 */