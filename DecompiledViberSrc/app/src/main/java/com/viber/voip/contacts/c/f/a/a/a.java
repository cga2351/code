package com.viber.voip.contacts.c.f.a.a;

import android.accounts.Account;
import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentProviderResult;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.provider.contacts.a.d;
import com.viber.provider.contacts.a.e;
import com.viber.provider.contacts.a.f;
import com.viber.provider.contacts.a.f.a;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.calls.h;
import com.viber.voip.contacts.c.d.g.h;
import com.viber.voip.contacts.c.e.b;
import com.viber.voip.contacts.c.f.b.f.a;
import com.viber.voip.messages.orm.entity.EntityUpdater;
import com.viber.voip.messages.orm.manager.AsyncEntityManager;
import com.viber.voip.messages.orm.manager.AsyncEntityManager.FillCursorCompleteCallback;
import com.viber.voip.messages.orm.manager.EntityManager;
import com.viber.voip.model.d;
import com.viber.voip.model.entity.k;
import com.viber.voip.model.entity.s;
import com.viber.voip.model.entity.t;
import com.viber.voip.model.entity.w;
import com.viber.voip.util.af;
import com.viber.voip.util.bq.a;
import com.viber.voip.util.bq.c;
import com.viber.voip.util.bq.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class a
{
  private static final Logger a = ViberEnv.getLogger();
  private AsyncEntityManager b;
  private e c;
  private b d;
  private com.viber.voip.contacts.c.f.b.f e;
  private com.viber.voip.contacts.c.f.a f;
  private c g;

  public a(Context paramContext, ViberApplication paramViberApplication, c paramc)
  {
    this.f = com.viber.voip.contacts.c.f.a.a(paramContext);
    this.b = new AsyncEntityManager(com.viber.voip.model.entity.f.a, false);
    this.d = b.a(paramContext);
    this.c = new e(paramContext, paramViberApplication, this, this.d);
    this.e = com.viber.voip.contacts.c.f.b.f.a(paramContext);
    this.g = paramc;
  }

  private void a(com.viber.voip.model.entity.f paramf)
  {
    Iterator localIterator2;
    do
    {
      Iterator localIterator1 = paramf.a().iterator();
      while (!localIterator2.hasNext())
      {
        Set localSet;
        while (true)
        {
          if (!localIterator1.hasNext())
            break label94;
          localSet = ((s)localIterator1.next()).b();
          if (localSet != null)
            break;
          ViberApplication.getInstance().logToCrashlytics(new RuntimeException("account dataEntities is null"));
        }
        localIterator2 = localSet.iterator();
      }
    }
    while (!((t)localIterator2.next() instanceof k));
    paramf.d(true);
    return;
    label94: paramf.d(false);
  }

  private void a(t paramt1, t paramt2, Map<String, Long> paramMap)
  {
    if (paramt1 != null);
    for (t localt = paramt1; ; localt = paramt2)
    {
      if ((localt instanceof k))
      {
        k localk = (k)localt;
        paramMap.put(localk.b(), Long.valueOf(localk.d().getId()));
      }
      return;
    }
  }

  private void a(final String paramString, final Set<Long> paramSet, final a parama)
  {
    this.d.a(1587, null, a.e.b, new String[] { "data2", "display_name", "phonetic_name" }, "mime_type=0 AND raw_id IN ( SELECT _id FROM phonebookrawcontact WHERE " + paramString + ")", null, null, new bq.g()
    {
      public void onQueryComplete(int paramAnonymousInt, Object paramAnonymousObject, Cursor paramAnonymousCursor)
      {
        try
        {
          if ((!af.b(paramAnonymousCursor)) && (paramAnonymousCursor.moveToFirst()))
          {
            ArrayList localArrayList = new ArrayList();
            do
              a.a(a.this, localArrayList, a.f.a, new w(paramAnonymousCursor.getString(0), paramAnonymousCursor.getString(1), paramAnonymousCursor.getString(2), a.f.a.c), a.b.b);
            while (paramAnonymousCursor.moveToNext());
            a.a(a.this).a(1587, "com.viber.voip.provider.vibercontacts", null, localArrayList, new bq.a()
            {
              public void a(int paramAnonymous2Int, Object paramAnonymous2Object, List<ContentProviderOperation> paramAnonymous2List, ContentProviderResult[] paramAnonymous2ArrayOfContentProviderResult, Exception paramAnonymous2Exception)
              {
                a.b(a.this, a.2.this.a, a.2.this.b, a.2.this.c);
              }
            });
          }
          while (true)
          {
            return;
            a.b(a.this, paramString, paramSet, parama);
          }
        }
        finally
        {
          af.a(paramAnonymousCursor);
        }
      }
    });
  }

  private void a(List<ContentProviderOperation> paramList, Uri paramUri, d paramd, b paramb)
  {
    if (paramb == b.c)
      paramList.add(ContentProviderOperation.newDelete(paramUri).withSelection("_id=" + paramd.getId(), null).build());
    do
    {
      return;
      if (paramb == b.a)
      {
        paramList.add(ContentProviderOperation.newUpdate(paramUri).withValues(paramd.getContentValues()).withSelection("_id=" + paramd.getId(), null).build());
        return;
      }
    }
    while (paramb != b.b);
    paramList.add(ContentProviderOperation.newInsert(paramUri).withValues(paramd.getContentValues()).build());
  }

  private void a(List<ContentProviderOperation> paramList, t paramt, com.viber.voip.model.entity.e parame, a.f.a parama)
  {
    if ((paramt instanceof k))
      a(paramList, a.f.a, new w(((k)paramt).b(), parame, parama), b.b);
  }

  private void a(List<ContentProviderOperation> paramList, final Map<String, Long> paramMap, final boolean paramBoolean, final a parama)
  {
    final int i = paramList.size();
    bq.a local6 = new bq.a()
    {
      int a = 0;

      public void a(int paramAnonymousInt, Object paramAnonymousObject, List<ContentProviderOperation> paramAnonymousList, ContentProviderResult[] paramAnonymousArrayOfContentProviderResult, Exception paramAnonymousException)
      {
        int i = this.a;
        if (paramAnonymousList == null);
        for (int j = 0; ; j = paramAnonymousList.size())
        {
          this.a = (j + i);
          if (this.a == i)
          {
            if ((paramMap.size() > 0) && (a.b(a.this) != null))
              a.b(a.this).b(paramMap);
            a.a(a.this, paramBoolean, parama, i);
          }
          return;
        }
      }
    };
    if (i == 0)
    {
      a(paramBoolean, parama, i);
      return;
    }
    this.d.a(1588, "com.viber.voip.provider.vibercontacts", null, paramList, local6);
  }

  private void a(Map<Long, com.viber.voip.model.entity.f> paramMap, Map<Long, s> paramMap1, Set<com.viber.voip.model.entity.f> paramSet, boolean paramBoolean, final a parama)
  {
    this.f.a();
    final HashSet localHashSet = new HashSet();
    final HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    ArrayList localArrayList1 = new ArrayList(paramSet.size());
    h localh = ViberApplication.getInstance().getRecentLetterManager();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator1 = paramSet.iterator();
    com.viber.voip.model.entity.f localf1;
    com.viber.voip.model.entity.f localf2;
    int i;
    boolean bool2;
    label201: s locals1;
    s locals2;
    com.viber.voip.model.entity.f localf3;
    boolean bool3;
    if (localIterator1.hasNext())
    {
      localf1 = (com.viber.voip.model.entity.f)localIterator1.next();
      localHashSet.add(Long.valueOf(localf1.getId()));
      localf2 = (com.viber.voip.model.entity.f)paramMap.get(Long.valueOf(localf1.getId()));
      boolean bool1 = a(localf2, localf1);
      String str1;
      String str2;
      Iterator localIterator2;
      if ((localf2 == null) || (bool1))
      {
        str1 = localf1.k();
        if (TextUtils.isEmpty(str1))
        {
          str2 = null;
          localf1.l(localh.a(str2));
        }
      }
      else
      {
        localIterator2 = localf1.a().iterator();
        i = 0;
        bool2 = bool1;
      }
      while (true)
        if (localIterator2.hasNext())
        {
          locals1 = (s)localIterator2.next();
          locals2 = null;
          if (localf2 != null)
            locals2 = localf2.e(locals1.getId());
          if (locals2 == null)
            locals2 = (s)paramMap1.get(Long.valueOf(locals1.getId()));
          if ((locals2 == null) || (locals2.a() == locals1.a()))
            break label1293;
          localf3 = (com.viber.voip.model.entity.f)paramMap.get(Long.valueOf(locals2.a()));
          if (localf3 == null)
          {
            int m = i + 1;
            localf1.i("xxx");
            localf1.m("xxx");
            Iterator localIterator6 = paramMap.values().iterator();
            while (true)
              if (localIterator6.hasNext())
              {
                com.viber.voip.model.entity.f localf5 = (com.viber.voip.model.entity.f)localIterator6.next();
                localf5.i("xxx");
                localf5.m("xxx");
                continue;
                str2 = str1.toLowerCase();
                break;
              }
            ViberApplication.getInstance().logToCrashlytics("unJoinedContact is null: newContact " + localf1 + ", newAccount " + locals1 + ", oldContacts " + paramMap + ", oldAccounts " + paramMap1);
            i = m;
          }
          else
          {
            localf3.a().remove(locals2);
            localHashMap1.put(Long.valueOf(locals2.a()), Long.valueOf(locals1.a()));
            bool3 = a(localf3, localf1);
            String str5;
            String str6;
            if (bool3)
            {
              str5 = localf1.k();
              if (TextUtils.isEmpty(str5))
              {
                str6 = null;
                localf1.l(localh.a(str6));
              }
            }
            else
            {
              if (localf2 == null)
                break label711;
            }
            StringBuilder localStringBuilder;
            label711: for (com.viber.voip.model.entity.f localf4 = localf2; ; localf4 = localf1)
            {
              localf4.a().add(locals2);
              locals2.a(localf4);
              String str3 = localf4.q();
              if (localf3.C() != 0L)
                localf4.d(localf3.C());
              if ((TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(localf3.q())))
                break label728;
              String[] arrayOfString = localf3.q().split("\\.");
              localStringBuilder = new StringBuilder();
              int j = arrayOfString.length;
              for (int k = 0; k < j; k++)
              {
                String str4 = arrayOfString[k];
                if (!str3.contains(str4))
                {
                  if (localStringBuilder.length() != 0)
                    localStringBuilder.append(".");
                  localStringBuilder.append(str4);
                }
              }
              str6 = str5.toLowerCase();
              break;
            }
            localf3.n(localStringBuilder.toString());
            label728: if (localf3.a().size() == 0)
            {
              localHashSet.add(Long.valueOf(localf3.getId()));
              a(localArrayList2, com.viber.provider.contacts.a.c.a, localf3, b.c);
            }
          }
        }
    }
    while (true)
    {
      a(locals2, locals1, locals1.c(), a.d.a, localArrayList2);
      if (locals2 == null)
      {
        Iterator localIterator5 = locals1.b().iterator();
        while (localIterator5.hasNext())
        {
          t localt4 = (t)localIterator5.next();
          a(localArrayList2, a.e.a, localt4, b.b);
          a(null, localt4, localHashMap2);
          a(localArrayList2, localt4, localf1, a.f.a.a);
        }
        if (a(localf3, null, localArrayList2))
          com.viber.voip.util.e.e.a(ViberApplication.getApplication()).b(ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, localf1.getId()));
      }
      else
      {
        Iterator localIterator3 = locals1.b().iterator();
        label1057: label1081: 
        while (localIterator3.hasNext())
        {
          t localt2 = (t)localIterator3.next();
          t localt3 = locals2.a(localt2.getId());
          if ((localt2 instanceof k))
          {
            if ((localt3 != null) && ((localt3 instanceof k)) && (((k)localt2).b().equals(((k)localt3).b())))
              break label1057;
            a(localArrayList2, localt2, localf1, a.f.a.a);
            if (localt3 != null)
              a(localArrayList2, localt3, localf2, a.f.a.c);
          }
          while (true)
          {
            if (!a(localt3, localt2, localt2.e(), a.e.a, localArrayList2))
              break label1081;
            a(localt3, localt2, localHashMap2);
            break;
            if ((bool3) && (localt3 != null))
              a(localArrayList2, localt3, localf1, a.f.a.b);
          }
        }
        Iterator localIterator4 = locals2.b().iterator();
        while (localIterator4.hasNext())
        {
          t localt1 = (t)localIterator4.next();
          if (!locals1.b().contains(localt1))
          {
            a(localArrayList2, a.e.a, localt1, b.c);
            a(localArrayList2, localt1, localf2, a.f.a.c);
          }
        }
        locals2.a(locals1.b());
        bool2 = bool3;
        break label201;
        if (i > 0)
        {
          ViberApplication.getInstance().logToCrashlytics("nNullContacts = " + i);
          ViberApplication.getInstance().logToCrashlytics(new RuntimeException("patched null contact data"));
        }
        a(localf2, localf1, localArrayList2);
        if (localArrayList2.size() <= 0)
          break;
        localArrayList1.addAll(localArrayList2);
        localArrayList2.clear();
        break;
        a(localArrayList1, localHashMap2, paramBoolean, new a()
        {
          public void a(boolean paramAnonymousBoolean)
          {
            a.b(a.this).b(localHashMap1, localHashSet);
            if (parama != null)
              parama.a(paramAnonymousBoolean);
          }
        });
        return;
        label1293: bool3 = bool2;
      }
    }
  }

  private void a(boolean paramBoolean, final a parama, final int paramInt)
  {
    try
    {
      boolean bool = this.f.a();
      if ((paramInt != 0) || ((paramBoolean) && (bool)))
        this.e.a(null, bool, false, new f.a()
        {
          public void a(int paramAnonymousInt)
          {
            a.a locala;
            if (parama != null)
            {
              locala = parama;
              if (paramInt == 0)
                break label29;
            }
            label29: for (boolean bool = true; ; bool = false)
            {
              locala.a(bool);
              return;
            }
          }
        });
      while (true)
      {
        return;
        if (parama != null)
          parama.a(false);
      }
    }
    finally
    {
    }
  }

  private boolean a(d paramd1, d paramd2, EntityUpdater<? extends d> paramEntityUpdater, Uri paramUri, List<ContentProviderOperation> paramList)
  {
    if (paramd1 == null)
    {
      a(paramList, paramUri, paramd2, b.b);
      return true;
    }
    if (paramEntityUpdater.update(paramd1))
    {
      a(paramList, paramUri, paramd1, b.a);
      return true;
    }
    return false;
  }

  private boolean a(com.viber.voip.model.entity.e parame1, com.viber.voip.model.entity.e parame2)
  {
    return (parame1 != null) && ((!parame1.k().equals(parame2.k())) || ((parame1.l() != null) && (parame2.l() != null) && (!parame1.l().equals(parame2.l()))));
  }

  private boolean a(com.viber.voip.model.entity.f paramf1, com.viber.voip.model.entity.f paramf2, List<ContentProviderOperation> paramList)
  {
    if (paramf1 == null)
    {
      a(paramf2);
      paramf2.b(paramf2.c());
      a(paramList, com.viber.provider.contacts.a.c.a, paramf2, b.b);
      return true;
    }
    a(paramf1);
    if ((paramf2 != null) && (paramf2.f().update(paramf1)));
    for (int i = 1; ; i = 0)
    {
      int j = paramf1.c();
      int k = paramf1.A();
      if ((i == 0) && (j == k))
        break;
      if (j != k)
        paramf1.c(1 + paramf1.D());
      paramf1.b(j);
      a(paramList, com.viber.provider.contacts.a.c.a, paramf1, b.a);
      return true;
    }
    return false;
  }

  private void b(final String paramString, final a parama)
  {
    this.d.a(1587, null, a.d.a, new String[] { "contact_id" }, paramString, null, null, new bq.g()
    {
      public void onQueryComplete(int paramAnonymousInt, Object paramAnonymousObject, Cursor paramAnonymousCursor)
      {
        HashSet localHashSet = new HashSet();
        if ((paramAnonymousCursor != null) && (paramAnonymousCursor.moveToFirst()))
          do
            localHashSet.add(Long.valueOf(paramAnonymousCursor.getLong(0)));
          while (paramAnonymousCursor.moveToNext());
        af.a(paramAnonymousCursor);
        if (localHashSet.size() > 0)
          a.a(a.this, paramString, localHashSet, parama);
        while (parama == null)
          return;
        a.a(a.this, true, parama, 0);
      }
    }
    , false, false);
  }

  private void b(String paramString, final Set<Long> paramSet, final a parama)
  {
    this.d.a(1587, null, a.d.a, paramString, null, new bq.c()
    {
      public void onDeleteComplete(int paramAnonymousInt1, Object paramAnonymousObject, int paramAnonymousInt2)
      {
        if ((paramAnonymousInt2 > 0) && (a.b(a.this) != null))
          a.b(a.this).f(paramSet);
        a.a(a.this, true, parama, paramAnonymousInt2);
      }
    }
    , false, false);
  }

  public void a()
  {
    this.g.a(true);
    com.viber.service.contacts.sync.a.a().b();
  }

  public void a(Account paramAccount, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, g.h paramh)
  {
    this.c.a(paramAccount, paramString1, paramString2, paramString3, paramBitmap, paramh);
  }

  public void a(String paramString, a parama)
  {
    b("contact_id IN ( " + paramString + " )", parama);
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
      this.c.d();
    this.c.b();
  }

  public void a(boolean paramBoolean, String paramString, a parama)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("_id");
    if (paramBoolean);
    for (String str = " IN "; ; str = " NOT IN ")
    {
      b(str + "( " + paramString + " )", parama);
      return;
    }
  }

  public void a(final boolean paramBoolean, final Set<com.viber.voip.model.entity.f> paramSet, final a parama)
  {
    if (paramSet.size() == 0)
    {
      a(paramBoolean, parama, 0);
      return;
    }
    com.viber.voip.s.a.a locala = com.viber.voip.s.a.c(paramSet);
    if (this.g != null)
      this.g.e(locala.d);
    this.b.fillCursor(this.d, new AsyncEntityManager.FillCursorCompleteCallback()
    {
      public void onDataReady(EntityManager paramAnonymousEntityManager, int paramAnonymousInt)
      {
        HashMap localHashMap1 = new HashMap();
        HashMap localHashMap2 = new HashMap();
        int i = 0;
        if (i < paramAnonymousEntityManager.getCount())
        {
          com.viber.voip.model.entity.f localf = (com.viber.voip.model.entity.f)paramAnonymousEntityManager.getEntity(i);
          if (localf == null);
          while (true)
          {
            i++;
            break;
            localHashMap1.put(Long.valueOf(localf.getId()), localf);
            Iterator localIterator = localf.a().iterator();
            while (localIterator.hasNext())
            {
              s locals = (s)localIterator.next();
              localHashMap2.put(Long.valueOf(locals.getId()), locals);
            }
          }
        }
        paramAnonymousEntityManager.closeCursor();
        a.a(a.this, localHashMap1, localHashMap2, paramSet, paramBoolean, parama);
      }
    }
    , 1584, "phonebookcontact._id IN ( SELECT contact_id FROM phonebookrawcontact WHERE _id IN (" + locala.b + ")) OR " + "phonebookcontact" + "." + "_id" + " IN (" + locala.a + ")", new String[0]);
  }

  public void b()
  {
    this.c.a();
  }

  public boolean c()
  {
    return this.c.c();
  }

  public void d()
  {
    if (this.g != null)
      this.g.a(false);
  }

  public void e()
  {
    this.g.s();
  }

  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean);
  }

  private static enum b
  {
    static
    {
      b[] arrayOfb = new b[3];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
      arrayOfb[2] = c;
    }
  }

  public static abstract interface c
  {
    public abstract void a(boolean paramBoolean);

    public abstract void b(HashMap<Long, Long> paramHashMap, Set<Long> paramSet);

    public abstract void b(Map<String, Long> paramMap);

    public abstract void e(Set<Long> paramSet);

    public abstract void f(Set<Long> paramSet);

    public abstract void s();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.c.f.a.a.a
 * JD-Core Version:    0.6.2
 */