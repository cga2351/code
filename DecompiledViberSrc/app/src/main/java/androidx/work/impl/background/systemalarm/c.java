package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import androidx.work.i;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.a.d;
import androidx.work.impl.b.j;
import androidx.work.impl.b.k;
import androidx.work.impl.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class c
{
  private static final String a = i.a("ConstraintsCmdHandler");
  private final Context b;
  private final int c;
  private final e d;
  private final d e;

  c(Context paramContext, int paramInt, e parame)
  {
    this.b = paramContext;
    this.c = paramInt;
    this.d = parame;
    this.e = new d(this.b, null);
  }

  void a()
  {
    List localList = this.d.d().d().m().c();
    ConstraintProxy.a(this.b, localList);
    this.e.a(localList);
    ArrayList localArrayList = new ArrayList(localList.size());
    long l = System.currentTimeMillis();
    Iterator localIterator1 = localList.iterator();
    while (localIterator1.hasNext())
    {
      j localj = (j)localIterator1.next();
      String str2 = localj.a;
      if ((l >= localj.c()) && ((!localj.d()) || (this.e.a(str2))))
        localArrayList.add(localj);
    }
    Iterator localIterator2 = localArrayList.iterator();
    while (localIterator2.hasNext())
    {
      String str1 = ((j)localIterator2.next()).a;
      Intent localIntent = b.b(this.b, str1);
      i.a().b(a, String.format("Creating a delay_met command for workSpec with id (%s)", new Object[] { str1 }), new Throwable[0]);
      this.d.a(new e.a(this.d, localIntent, this.c));
    }
    this.e.a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.background.systemalarm.c
 * JD-Core Version:    0.6.2
 */