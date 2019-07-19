package a.a;

import com.appboy.f.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

public class al
{
  private static final String a = c.a(al.class);
  private final cy b;
  private final cy c;
  private boolean d = false;

  public al(cy paramcy1, cy paramcy2)
  {
    this.c = paramcy1;
    this.b = paramcy2;
  }

  static void a(gq paramgq, cy paramcy1, cy paramcy2)
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator1 = paramcy1.a().iterator();
    while (localIterator1.hasNext())
    {
      be localbe2 = (be)localIterator1.next();
      c.a(a, "Adding event to dispatch from active storage: " + localbe2);
      localHashSet.add(localbe2.d());
      paramgq.a(localbe2);
    }
    if (paramcy2 != null)
    {
      Collection localCollection = paramcy2.a();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator2 = localCollection.iterator();
      while (localIterator2.hasNext())
      {
        be localbe1 = (be)localIterator2.next();
        localArrayList1.add(localbe1);
        if (localbe1.e_())
        {
          c.b(a, "Event present in migrated storage is non persistable. Not re-adding to current storage: " + localbe1);
        }
        else if (localHashSet.contains(localbe1.d()))
        {
          c.b(a, "Event present in both storage providers. Not re-adding to current storage: " + localbe1);
        }
        else
        {
          c.b(a, "Found event in storage from migrated storage provider: " + localbe1);
          localArrayList2.add(localbe1);
        }
      }
      paramcy2.b(localArrayList1);
      paramcy1.a(localArrayList2);
    }
  }

  public void a()
  {
    this.d = true;
    this.c.b();
  }

  public void a(be parambe)
  {
    if (this.d)
    {
      c.d(a, "Storage manager is closed. Not adding event: " + parambe);
      return;
    }
    this.c.a(parambe);
  }

  public void a(List<be> paramList)
  {
    if (this.d)
    {
      c.d(a, "Storage manager is closed. Not deleting events: " + paramList);
      return;
    }
    this.c.b(paramList);
  }

  public void a(Executor paramExecutor, final gq paramgq)
  {
    if (this.d)
    {
      c.d(a, "Storage manager is closed. Not starting offline recovery.");
      return;
    }
    paramExecutor.execute(new Runnable()
    {
      public void run()
      {
        c.b(al.b(), "Started offline AppboyEvent recovery task.");
        al.a(paramgq, al.a(al.this), al.b(al.this));
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.al
 * JD-Core Version:    0.6.2
 */