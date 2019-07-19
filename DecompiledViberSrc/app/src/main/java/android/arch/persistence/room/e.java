package android.arch.persistence.room;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.arch.persistence.a.b;
import android.arch.persistence.a.c.c;
import android.arch.persistence.a.f;
import android.content.Context;
import android.database.Cursor;
import android.os.Build.VERSION;
import android.support.v4.app.ActivityManagerCompat;
import android.support.v4.util.SparseArrayCompat;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class e
{
  protected volatile b a;
  boolean b;
  protected List<b> c;
  private android.arch.persistence.a.c d;
  private final c e = c();
  private boolean f;
  private final ReentrantLock g = new ReentrantLock();

  public f a(String paramString)
  {
    e();
    return this.d.a().a(paramString);
  }

  public Cursor a(android.arch.persistence.a.e parame)
  {
    e();
    return this.d.a().a(parame);
  }

  public Cursor a(String paramString, Object[] paramArrayOfObject)
  {
    return this.d.a().a(new android.arch.persistence.a.a(paramString, paramArrayOfObject));
  }

  Lock a()
  {
    return this.g;
  }

  protected void a(b paramb)
  {
    this.e.a(paramb);
  }

  public void a(a parama)
  {
    this.d = b(parama);
    int i = Build.VERSION.SDK_INT;
    boolean bool = false;
    if (i >= 16)
    {
      c localc1 = parama.g;
      c localc2 = c.c;
      bool = false;
      if (localc1 == localc2)
        bool = true;
      this.d.a(bool);
    }
    this.c = parama.e;
    this.f = parama.f;
    this.b = bool;
  }

  public android.arch.persistence.a.c b()
  {
    return this.d;
  }

  protected abstract android.arch.persistence.a.c b(a parama);

  protected abstract c c();

  public boolean d()
  {
    b localb = this.a;
    return (localb != null) && (localb.e());
  }

  public void e()
  {
    if (this.f);
    while (!android.arch.a.a.a.a().b())
      return;
    throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
  }

  public void f()
  {
    e();
    b localb = this.d.a();
    this.e.b(localb);
    localb.a();
  }

  public void g()
  {
    this.d.a().b();
    if (!i())
      this.e.a();
  }

  public void h()
  {
    this.d.a().c();
  }

  public boolean i()
  {
    return this.d.a().d();
  }

  public static class a<T extends e>
  {
    private final Class<T> a;
    private final String b;
    private final Context c;
    private ArrayList<e.b> d;
    private c.c e;
    private boolean f;
    private e.c g;
    private boolean h;
    private final e.d i;
    private Set<Integer> j;
    private Set<Integer> k;

    a(Context paramContext, Class<T> paramClass, String paramString)
    {
      this.c = paramContext;
      this.a = paramClass;
      this.b = paramString;
      this.g = e.c.a;
      this.h = true;
      this.i = new e.d();
    }

    public a<T> a()
    {
      this.f = true;
      return this;
    }

    public a<T> a(e.b paramb)
    {
      if (this.d == null)
        this.d = new ArrayList();
      this.d.add(paramb);
      return this;
    }

    public a<T> a(android.arch.persistence.room.a.a[] paramArrayOfa)
    {
      if (this.k == null)
        this.k = new HashSet();
      int m = paramArrayOfa.length;
      for (int n = 0; n < m; n++)
      {
        android.arch.persistence.room.a.a locala = paramArrayOfa[n];
        this.k.add(Integer.valueOf(locala.a));
        this.k.add(Integer.valueOf(locala.b));
      }
      this.i.a(paramArrayOfa);
      return this;
    }

    public a<T> b()
    {
      this.h = false;
      return this;
    }

    public T c()
    {
      if (this.c == null)
        throw new IllegalArgumentException("Cannot provide null context for the database.");
      if (this.a == null)
        throw new IllegalArgumentException("Must provide an abstract class that extends RoomDatabase");
      if ((this.k != null) && (this.j != null))
      {
        Iterator localIterator = this.k.iterator();
        while (localIterator.hasNext())
        {
          Integer localInteger = (Integer)localIterator.next();
          if (this.j.contains(localInteger))
            throw new IllegalArgumentException("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: " + localInteger);
        }
      }
      if (this.e == null)
        this.e = new android.arch.persistence.a.a.c();
      a locala = new a(this.c, this.b, this.e, this.i, this.d, this.f, this.g.a(this.c), this.h, this.j);
      e locale = (e)d.a(this.a, "_Impl");
      locale.a(locala);
      return locale;
    }
  }

  public static abstract class b
  {
    public void a(b paramb)
    {
    }

    public void b(b paramb)
    {
    }
  }

  public static enum c
  {
    static
    {
      c[] arrayOfc = new c[3];
      arrayOfc[0] = a;
      arrayOfc[1] = b;
      arrayOfc[2] = c;
    }

    @SuppressLint({"NewApi"})
    c a(Context paramContext)
    {
      if (this != a)
        return this;
      if (Build.VERSION.SDK_INT >= 16)
      {
        ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
        if ((localActivityManager != null) && (!ActivityManagerCompat.isLowRamDevice(localActivityManager)))
          return c;
      }
      return b;
    }
  }

  public static class d
  {
    private SparseArrayCompat<SparseArrayCompat<android.arch.persistence.room.a.a>> a = new SparseArrayCompat();

    private List<android.arch.persistence.room.a.a> a(List<android.arch.persistence.room.a.a> paramList, boolean paramBoolean, int paramInt1, int paramInt2)
    {
      int i;
      int j;
      if (paramBoolean)
      {
        i = -1;
        j = paramInt1;
        if (!paramBoolean)
          break label50;
        if (j >= paramInt2);
      }
      SparseArrayCompat localSparseArrayCompat;
      while (true)
      {
        localSparseArrayCompat = (SparseArrayCompat)this.a.get(j);
        if (localSparseArrayCompat != null)
          break label60;
        paramList = null;
        label50: 
        do
        {
          return paramList;
          i = 1;
          break;
        }
        while (j <= paramInt2);
      }
      label60: int k = localSparseArrayCompat.size();
      int m;
      label80: int n;
      label84: int i3;
      int i4;
      label121: int i2;
      int i1;
      if (paramBoolean)
      {
        m = k - 1;
        k = -1;
        n = m;
        if (n == k)
          break label209;
        i3 = localSparseArrayCompat.keyAt(n);
        if (!paramBoolean)
          break label166;
        if ((i3 > paramInt2) || (i3 <= j))
          break label160;
        i4 = 1;
        if (i4 == 0)
          break label192;
        paramList.add(localSparseArrayCompat.valueAt(n));
        i2 = 1;
        i1 = i3;
      }
      while (true)
      {
        if (i2 == 0)
        {
          return null;
          m = 0;
          break label80;
          label160: i4 = 0;
          break label121;
          label166: if ((i3 >= paramInt2) && (i3 < j))
          {
            i4 = 1;
            break label121;
          }
          i4 = 0;
          break label121;
          label192: n += i;
          break label84;
        }
        j = i1;
        break;
        label209: i1 = j;
        i2 = 0;
      }
    }

    private void a(android.arch.persistence.room.a.a parama)
    {
      int i = parama.a;
      int j = parama.b;
      SparseArrayCompat localSparseArrayCompat1 = (SparseArrayCompat)this.a.get(i);
      SparseArrayCompat localSparseArrayCompat2;
      if (localSparseArrayCompat1 == null)
      {
        localSparseArrayCompat2 = new SparseArrayCompat();
        this.a.put(i, localSparseArrayCompat2);
      }
      for (SparseArrayCompat localSparseArrayCompat3 = localSparseArrayCompat2; ; localSparseArrayCompat3 = localSparseArrayCompat1)
      {
        android.arch.persistence.room.a.a locala = (android.arch.persistence.room.a.a)localSparseArrayCompat3.get(j);
        if (locala != null)
          Log.w("ROOM", "Overriding migration " + locala + " with " + parama);
        localSparseArrayCompat3.append(j, parama);
        return;
      }
    }

    public List<android.arch.persistence.room.a.a> a(int paramInt1, int paramInt2)
    {
      if (paramInt1 == paramInt2)
        return Collections.emptyList();
      if (paramInt2 > paramInt1);
      for (boolean bool = true; ; bool = false)
        return a(new ArrayList(), bool, paramInt1, paramInt2);
    }

    public void a(android.arch.persistence.room.a.a[] paramArrayOfa)
    {
      int i = paramArrayOfa.length;
      for (int j = 0; j < i; j++)
        a(paramArrayOfa[j]);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.arch.persistence.room.e
 * JD-Core Version:    0.6.2
 */