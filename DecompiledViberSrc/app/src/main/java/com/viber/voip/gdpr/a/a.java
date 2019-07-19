package com.viber.voip.gdpr.a;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.ArraySet;
import com.appnexus.opensdk.ANGDPRSettings;
import com.viber.common.b.d;
import com.viber.common.b.h;
import com.viber.dexshared.Logger;
import com.viber.voip.R.raw;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.i.c.j;
import com.viber.voip.messages.orm.entity.json.gdpr.Vendor;
import com.viber.voip.messages.orm.entity.json.gdpr.VendorList;
import com.viber.voip.settings.d.ad.a;
import com.viber.voip.settings.d.v;
import com.viber.voip.util.da;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class a
{
  private static final Logger b = ViberEnv.getLogger("ConsentController");
  private com.iab.a.a.a a;
  private final Context c;
  private VendorList d;
  private List<com.viber.common.b.b> e;
  private List<b> f;

  @Inject
  public a(Context paramContext)
  {
    this.c = paramContext;
    this.f = new ArrayList();
    this.e = new ArrayList();
    int i = R.string.gdpr_iab_consent__google_vendor_name;
    int j = R.string.gdpr_iab_consent__google_privacy_link;
    com.viber.common.b.b localb = d.v.t;
    a[] arrayOfa = new a[1];
    arrayOfa[0] = a.b;
    a(i, j, localb, arrayOfa);
  }

  private com.iab.a.a.a a(Set<com.iab.a.b> paramSet, Set<Integer> paramSet1, int paramInt)
  {
    while (true)
    {
      long l1;
      try
      {
        l1 = System.currentTimeMillis();
        com.iab.a.a.a locala = d();
        if (locala != null)
        {
          l2 = locala.a();
          VendorList localVendorList = c();
          String str = d.ad.a.a.d();
          if (da.a(str))
            str = Locale.getDefault().getLanguage();
          int i = a(localVendorList.getVendors()).intValue();
          com.iab.a.a.a.a.b localb = new com.iab.a.a.a.a.b().a(l2).b(l1).a(171).b(1).c(paramInt).a(str).d(localVendorList.getVendorListVersion().intValue()).a(paramSet).e(i);
          List localList = a(paramSet1);
          if ((localList != null) && (b(localList) < i))
          {
            localb.f(1).a(false).a(localList);
            return localb.a();
          }
          localb.f(0).b(paramSet1);
          continue;
        }
      }
      catch (Exception localException)
      {
        return null;
      }
      long l2 = l1;
    }
  }

  private Integer a(List<Vendor> paramList)
  {
    return ((Vendor)Collections.max(paramList, new Comparator()
    {
      public int a(Vendor paramAnonymousVendor1, Vendor paramAnonymousVendor2)
      {
        return paramAnonymousVendor1.getId().compareTo(paramAnonymousVendor2.getId());
      }
    })).getId();
  }

  private String a(com.iab.a.a.a parama)
  {
    return com.iab.a.a.c.a(parama);
  }

  private List<com.iab.a.a.b.a> a(Set<Integer> paramSet)
  {
    int i = -1;
    ArrayList localArrayList1 = new ArrayList(paramSet);
    List localList = this.d.getVendors();
    ArrayList localArrayList2 = new ArrayList();
    if (paramSet.size() == localList.size())
    {
      localArrayList2.add(new com.iab.a.a.b.c(1, a(localList).intValue()));
      return localArrayList2;
    }
    if (paramSet.size() == 0)
      return localArrayList2;
    Collections.sort(localArrayList1);
    HashSet localHashSet = new HashSet();
    Iterator localIterator1 = localList.iterator();
    while (localIterator1.hasNext())
      localHashSet.add(((Vendor)localIterator1.next()).getId());
    Iterator localIterator2 = localArrayList1.iterator();
    int j = i;
    int k;
    int n;
    label197: label254: int m;
    if (localIterator2.hasNext())
    {
      k = ((Integer)localIterator2.next()).intValue();
      if ((j > 0) && (k - j > 1))
      {
        n = j + 1;
        int i1 = 0;
        if (n < k)
        {
          if (localHashSet.contains(Integer.valueOf(n)))
            i1 = 1;
        }
        else
        {
          if (i1 != 0)
          {
            if (j == i)
              break label276;
            localArrayList2.add(new com.iab.a.a.b.c(i, j));
            i = k;
          }
          m = i;
        }
      }
    }
    while (true)
    {
      i = m;
      j = k;
      break;
      n++;
      break label197;
      label276: localArrayList2.add(new com.iab.a.a.b.b(i));
      break label254;
      if (j <= 0)
      {
        m = k;
        continue;
        if (j != i)
          localArrayList2.add(new com.iab.a.a.b.c(i, j));
        while (true)
        {
          return localArrayList2;
          localArrayList2.add(new com.iab.a.a.b.b(i));
        }
      }
      else
      {
        m = i;
      }
    }
  }

  private void a(int paramInt1, int paramInt2, com.viber.common.b.b paramb, a[] paramArrayOfa)
  {
    Resources localResources = this.c.getResources();
    int i = this.e.size();
    HashSet localHashSet = new HashSet(Arrays.asList(paramArrayOfa));
    b localb = new b(i, localResources.getString(paramInt1), localResources.getString(paramInt2), localHashSet, 1);
    this.f.add(localb);
    this.e.add(paramb);
  }

  private void a(String paramString, int paramInt)
  {
    d.v.q.a(paramString);
    d.v.s.a(paramInt);
    b();
  }

  private int b(List<com.iab.a.a.b.a> paramList)
  {
    Iterator localIterator = paramList.iterator();
    int i = 13;
    while (localIterator.hasNext())
      i += ((com.iab.a.a.b.a)localIterator.next()).a();
    return i;
  }

  private VendorList c()
  {
    if (this.d == null)
    {
      String str = com.viber.voip.flatbuffers.model.util.a.a(this.c, R.raw.vendorlist);
      this.d = ((VendorList)new com.google.d.f().a(str, VendorList.class));
    }
    return this.d;
  }

  private com.iab.a.a.a d()
  {
    if (this.a == null)
    {
      String str = d.v.q.d();
      if (!da.b(str))
        this.a = com.iab.a.a.b.a(str);
    }
    return this.a;
  }

  public List<b> a()
  {
    List localList = c().getVendors();
    ArrayList localArrayList = new ArrayList(localList.size());
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
      localArrayList.add(b.a((Vendor)localIterator.next()));
    localArrayList.addAll(this.f);
    Collections.sort(localArrayList);
    return localArrayList;
  }

  public void a(int paramInt)
  {
    a(new ArrayMap(), new ArrayMap(), paramInt);
  }

  public void a(Map<a, Boolean> paramMap, Map<b, Boolean> paramMap1, int paramInt)
  {
    HashSet localHashSet1 = new HashSet(paramMap.size());
    Iterator localIterator1 = paramMap.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry2 = (Map.Entry)localIterator1.next();
      if (((Boolean)localEntry2.getValue()).booleanValue())
        localHashSet1.add(((a)localEntry2.getKey()).a());
    }
    HashSet localHashSet2 = new HashSet(paramMap1.size());
    Iterator localIterator2 = paramMap1.entrySet().iterator();
    while (localIterator2.hasNext())
    {
      Map.Entry localEntry1 = (Map.Entry)localIterator2.next();
      b localb = (b)localEntry1.getKey();
      boolean bool = ((Boolean)localEntry1.getValue()).booleanValue();
      switch (localb.d())
      {
      default:
        break;
      case 0:
        if (bool)
          localHashSet2.add(Integer.valueOf(localb.c()));
        break;
      case 1:
        ((com.viber.common.b.b)this.e.get(localb.c())).a(bool);
      }
    }
    com.iab.a.a.a locala = a(localHashSet1, localHashSet2, paramInt);
    if (locala != null)
    {
      this.a = locala;
      a(a(locala), c().getVendorListVersion().intValue());
    }
  }

  public boolean a(a parama)
  {
    com.iab.a.a.a locala = d();
    return (locala == null) || (locala.a(parama.a()));
  }

  public boolean a(b paramb)
  {
    switch (paramb.d())
    {
    default:
    case 0:
      com.iab.a.a.a locala;
      do
      {
        return false;
        locala = d();
      }
      while ((locala != null) && (!locala.a(paramb.c())));
      return true;
    case 1:
    }
    return ((com.viber.common.b.b)this.e.get(paramb.c())).d();
  }

  public void b()
  {
    boolean bool = c.j.a.e();
    String str = d.v.q.d();
    ANGDPRSettings.setConsentRequired(this.c, bool);
    if ((bool) && (!da.a(str)))
      ANGDPRSettings.setConsentString(this.c, str);
  }

  public void b(int paramInt)
  {
    a[] arrayOfa = a.values();
    ArrayMap localArrayMap1 = new ArrayMap(arrayOfa.length);
    int i = arrayOfa.length;
    for (int j = 0; j < i; j++)
      localArrayMap1.put(arrayOfa[j], Boolean.valueOf(true));
    List localList = a();
    ArrayMap localArrayMap2 = new ArrayMap(localList.size());
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
      localArrayMap2.put((b)localIterator.next(), Boolean.valueOf(true));
    a(localArrayMap1, localArrayMap2, paramInt);
  }

  public static enum a
  {
    private final com.iab.a.b f;
    private final int g;
    private final int h;

    static
    {
      a[] arrayOfa = new a[5];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
    }

    private a(com.iab.a.b paramb, int paramInt1, int paramInt2)
    {
      this.f = paramb;
      this.g = paramInt1;
      this.h = paramInt2;
    }

    public static a a(com.iab.a.b paramb)
    {
      switch (a.2.a[paramb.ordinal()])
      {
      default:
        return null;
      case 1:
        return a;
      case 2:
        return b;
      case 3:
        return c;
      case 4:
        return d;
      case 5:
      }
      return e;
    }

    public com.iab.a.b a()
    {
      return this.f;
    }

    public int b()
    {
      return this.g;
    }
  }

  public static class b
    implements Comparable<b>
  {
    private final String a;
    private final String b;
    private final int c;
    private final Set<a.a> d;
    private final int e;

    public b(int paramInt1, String paramString1, String paramString2, Set<a.a> paramSet, int paramInt2)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramInt1;
      this.d = paramSet;
      this.e = paramInt2;
    }

    public static b a(Vendor paramVendor)
    {
      ArraySet localArraySet = new ArraySet(paramVendor.getPurposeIds().size());
      Iterator localIterator = paramVendor.getFeatureIds().iterator();
      while (localIterator.hasNext())
        localArraySet.add(a.a.a(com.iab.a.b.a(((Integer)localIterator.next()).intValue())));
      return new b(paramVendor.getId().intValue(), paramVendor.getName(), paramVendor.getPolicyUrl(), localArraySet, 0);
    }

    public int a(b paramb)
    {
      return a().compareTo(paramb.a());
    }

    public String a()
    {
      return this.a;
    }

    public String b()
    {
      return this.b;
    }

    public int c()
    {
      return this.c;
    }

    public int d()
    {
      return this.e;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gdpr.a.a
 * JD-Core Version:    0.6.2
 */