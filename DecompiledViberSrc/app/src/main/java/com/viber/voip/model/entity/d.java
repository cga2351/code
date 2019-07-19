package com.viber.voip.model.entity;

import android.content.Context;
import android.net.Uri;
import android.support.v4.util.ArraySet;
import android.text.TextUtils;
import com.viber.voip.contacts.b.a.g;
import com.viber.voip.contacts.b.a.h;
import com.viber.voip.contacts.c.e.b;
import com.viber.voip.messages.orm.creator.CreatorHelper;
import com.viber.voip.messages.orm.manager.AsyncEntityManager;
import com.viber.voip.messages.orm.manager.AsyncEntityManager.FillCursorCompleteCallback;
import com.viber.voip.messages.orm.manager.EntityManager;
import com.viber.voip.model.a;
import com.viber.voip.model.a.a;
import com.viber.voip.model.j;
import com.viber.voip.util.ci;
import com.viber.voip.util.da;
import com.viber.voip.util.dx;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Pattern;

public class d extends e
  implements a
{
  public static final CreatorHelper b = new h();
  public static final CreatorHelper c = new com.viber.voip.contacts.b.a.f();
  public static final CreatorHelper d = new com.viber.voip.contacts.b.a.e();
  public static final CreatorHelper e = new g();
  protected static final Pattern f = Pattern.compile(",");
  protected static final Pattern g = Pattern.compile("!:!");
  public static final Comparator<j> m = new Comparator()
  {
    public int a(j paramAnonymousj1, j paramAnonymousj2)
    {
      if (!TextUtils.isEmpty(paramAnonymousj1.d()));
      int j;
      for (int i = 1; ; i = 0)
      {
        boolean bool = TextUtils.isEmpty(paramAnonymousj2.d());
        j = 0;
        if (!bool)
          j = 1;
        if ((i != 0) || (j == 0))
          break;
        return 1;
      }
      if ((j == 0) && (i != 0))
        return -1;
      return paramAnonymousj1.a().compareTo(paramAnonymousj2.a());
    }
  };
  private String F;
  private String G;
  private String H;
  private String I;
  private Uri J;
  private transient String K;
  private transient Uri L;
  private String a;
  protected a h;
  protected TreeSet<String> i;
  protected TreeMap<String, com.viber.voip.model.f> j;
  protected Set<String> k;
  protected Set<String> l;

  public d()
  {
  }

  public d(String paramString1, String paramString2, Uri paramUri)
  {
    super(paramString1);
    b(paramString2);
    a(paramUri);
  }

  public j a(ci<j> paramci)
  {
    if (s() == null)
      return null;
    Iterator localIterator = this.h.a().iterator();
    while (localIterator.hasNext())
    {
      j localj = (j)localIterator.next();
      if (paramci.apply(localj))
        return localj;
    }
    return null;
  }

  public j a(String paramString)
  {
    if ((s() == null) || (TextUtils.isEmpty(paramString)))
      return null;
    Iterator localIterator = this.h.a().iterator();
    while (localIterator.hasNext())
    {
      j localj = (j)localIterator.next();
      if (paramString.equals(localj.c()))
        return localj;
    }
    return null;
  }

  public void a(Context paramContext, final a.a parama)
  {
    new AsyncEntityManager(t.j, true).fillCursor(b.a(paramContext), new AsyncEntityManager.FillCursorCompleteCallback()
    {
      public void onDataReady(EntityManager paramAnonymousEntityManager, int paramAnonymousInt)
      {
        HashSet localHashSet = new HashSet();
        for (int i = 0; i < paramAnonymousEntityManager.getCount(); i++)
          localHashSet.add((com.viber.voip.model.f)paramAnonymousEntityManager.getEntity(i));
        paramAnonymousEntityManager.closeCursor();
        parama.a(localHashSet);
      }
    }
    , 0, "mime_type=0 AND contact_id=" + this.id, new String[0]);
  }

  public void a(Uri paramUri)
  {
    this.J = paramUri;
  }

  public void a(TreeSet<j> paramTreeSet)
  {
    this.h = new a(paramTreeSet);
  }

  public void b(String paramString)
  {
    this.a = paramString;
  }

  public void c(String paramString)
  {
    this.F = paramString;
  }

  public void d(String paramString)
  {
    this.I = paramString;
  }

  public void e(String paramString)
  {
    this.G = paramString;
  }

  public TreeMap<String, com.viber.voip.model.f> f()
  {
    if (this.j == null)
    {
      HashMap localHashMap = new HashMap();
      if (this.G != null)
      {
        String[] arrayOfString3 = f.split(this.G);
        int i2 = 0;
        int i3 = arrayOfString3.length;
        while (i2 < i3)
        {
          String str6 = arrayOfString3[i2];
          if ((!TextUtils.isEmpty(str6)) && (!"null".equals(str6)))
          {
            String[] arrayOfString4 = g.split(str6);
            if (arrayOfString4.length >= 2)
              localHashMap.put(arrayOfString4[0], arrayOfString4[1]);
          }
          i2++;
        }
      }
      this.j = new TreeMap();
      if (this.F != null)
      {
        String[] arrayOfString1 = f.split(this.F);
        int n = arrayOfString1.length;
        int i1 = 0;
        if (i1 < n)
        {
          String str1 = arrayOfString1[i1];
          String[] arrayOfString2;
          String str2;
          label190: String str3;
          label203: String str4;
          if (!TextUtils.isEmpty(str1))
          {
            arrayOfString2 = g.split(str1);
            if (arrayOfString2.length < 1)
              break label271;
            str2 = arrayOfString2[0];
            if (arrayOfString2.length < 2)
              break label278;
            str3 = arrayOfString2[1];
            if (arrayOfString2.length < 3)
              break label285;
            str4 = arrayOfString2[2];
            label216: if (arrayOfString2.length < 4)
              break label292;
          }
          label271: label278: label285: label292: for (String str5 = arrayOfString2[3]; ; str5 = "")
          {
            this.j.put(str2, new k(str2, str3, str4, str5, (String)localHashMap.get(str2)));
            i1++;
            break;
            str2 = "";
            break label190;
            str3 = "";
            break label203;
            str4 = "";
            break label216;
          }
        }
      }
      this.G = null;
      this.F = null;
    }
    return this.j;
  }

  public void f(String paramString)
  {
    this.h = new a(paramString);
  }

  public Uri g()
  {
    if (this.L != null)
      return this.L;
    j localj = n();
    Uri localUri = null;
    if (localj != null)
      localUri = dx.a(localj.d());
    this.L = localUri;
    return localUri;
  }

  public void g(String paramString)
  {
    this.H = paramString;
  }

  public Set<String> h()
  {
    if (this.k == null)
      if (!TextUtils.isEmpty(this.a))
        break label38;
    label38: for (this.k = new ArraySet(); ; this.k = new ArraySet(Arrays.asList(this.a.split(","))))
    {
      this.a = null;
      return this.k;
    }
  }

  public String k()
  {
    String str = super.k();
    if (TextUtils.isEmpty(str))
      str = this.a;
    return str;
  }

  public String m()
  {
    if (this.K == null)
      this.K = da.f(k());
    return this.K;
  }

  public j n()
  {
    if (this.h == null);
    Iterator localIterator;
    do
    {
      return null;
      localIterator = this.h.a().iterator();
    }
    while (!localIterator.hasNext());
    return (j)localIterator.next();
  }

  public Uri o()
  {
    if (this.J != null)
      return this.J;
    Uri localUri = g();
    if ((localUri == null) && (B()))
      localUri = com.viber.voip.util.x.a(this.id);
    this.J = localUri;
    return localUri;
  }

  public Collection<j> s()
  {
    if (this.h == null)
      this.h = new a((TreeSet)null);
    return this.h.a();
  }

  public Collection<String> t()
  {
    z();
    return this.i;
  }

  public Collection<String> u()
  {
    z();
    return this.l;
  }

  public com.viber.voip.model.f w()
  {
    if ((f() == null) || (f().isEmpty()))
      return null;
    String str = (String)f().firstKey();
    if (str != null)
      return (com.viber.voip.model.f)f().get(str);
    return null;
  }

  public String y()
  {
    j localj = n();
    if (localj != null)
      return localj.d();
    return null;
  }

  public void z()
  {
    int i1;
    String[] arrayOfString2;
    if (this.l == null)
    {
      this.l = new HashSet();
      this.i = new TreeSet();
      if (this.H != null)
      {
        String[] arrayOfString1 = f.split(this.H);
        int n = arrayOfString1.length;
        i1 = 0;
        if (i1 < n)
        {
          String str1 = arrayOfString1[i1];
          if (TextUtils.isEmpty(str1))
            break label164;
          arrayOfString2 = g.split(str1);
        }
      }
    }
    while (true)
    {
      try
      {
        if (arrayOfString2.length <= 0)
          break label170;
        str2 = arrayOfString2[0];
        if (arrayOfString2.length <= 1)
          break label177;
        i2 = Integer.valueOf(arrayOfString2[1]).intValue();
        if (TextUtils.isEmpty(str2))
          break label164;
        if (i2 == 1)
          this.l.add(str2);
        else
          this.i.add(str2);
      }
      catch (NumberFormatException localNumberFormatException)
      {
      }
      this.H = null;
      return;
      label164: i1++;
      break;
      label170: String str2 = "";
      continue;
      label177: int i2 = 0;
    }
  }

  public static final class a
  {
    private String a;
    private volatile Collection<j> b;

    public a(String paramString)
    {
      this.a = paramString;
    }

    public a(TreeSet<j> paramTreeSet)
    {
      this.b = new TreeSet(d.m);
      if (paramTreeSet != null)
      {
        Iterator localIterator = paramTreeSet.iterator();
        while (localIterator.hasNext())
        {
          j localj = (j)localIterator.next();
          this.b.add(localj);
        }
      }
    }

    private void a(Collection<j> paramCollection, String paramString)
    {
      String[] arrayOfString1 = d.f.split(paramString);
      int i = arrayOfString1.length;
      int j = 0;
      label183: label190: label197: if (j < i)
      {
        String str1 = arrayOfString1[j];
        if (!TextUtils.isEmpty(str1))
        {
          if (!str1.startsWith("External:"))
            break label72;
          paramCollection.add(new x(str1, "", ""));
        }
        label72: label202: 
        while (true)
        {
          j++;
          break;
          String[] arrayOfString2 = d.g.split(str1);
          String str2;
          label94: String str3;
          label107: String str4;
          if (arrayOfString2.length > 0)
          {
            str2 = arrayOfString2[0];
            if (arrayOfString2.length <= 1)
              break label183;
            str3 = arrayOfString2[1];
            if (arrayOfString2.length <= 2)
              break label190;
            str4 = arrayOfString2[2];
            label120: if (arrayOfString2.length <= 3)
              break label197;
          }
          for (String str5 = arrayOfString2[3]; ; str5 = "")
          {
            if ((TextUtils.isEmpty(str2)) || ("null".equals(str2)))
              break label202;
            paramCollection.add(new x(str2, str3, str4, str5));
            break;
            str2 = "";
            break label94;
            str3 = "";
            break label107;
            str4 = "";
            break label120;
          }
        }
      }
    }

    public Collection<j> a()
    {
      if (this.b == null);
      try
      {
        if (this.b == null)
        {
          this.b = new TreeSet(d.m);
          if (this.a != null)
          {
            a(this.b, this.a);
            this.a = null;
          }
        }
        return this.b;
      }
      finally
      {
      }
    }

    public void a(j paramj)
    {
      a().add(paramj);
    }

    public String toString()
    {
      return "LazyViberDataCollection{mConcatData='" + this.a + '\'' + ", mViberData=" + this.b + '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.model.entity.d
 * JD-Core Version:    0.6.2
 */