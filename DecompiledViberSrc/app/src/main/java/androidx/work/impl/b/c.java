package androidx.work.impl.b;

import android.arch.persistence.a.f;
import android.arch.persistence.room.e;
import android.arch.persistence.room.h;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

public class c
  implements b
{
  private final e a;
  private final android.arch.persistence.room.b b;

  public c(e parame)
  {
    this.a = parame;
    this.b = new android.arch.persistence.room.b(parame)
    {
      public String a()
      {
        return "INSERT OR IGNORE INTO `Dependency`(`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
      }

      public void a(f paramAnonymousf, a paramAnonymousa)
      {
        if (paramAnonymousa.a == null)
          paramAnonymousf.a(1);
        while (paramAnonymousa.b == null)
        {
          paramAnonymousf.a(2);
          return;
          paramAnonymousf.a(1, paramAnonymousa.a);
        }
        paramAnonymousf.a(2, paramAnonymousa.b);
      }
    };
  }

  public void a(a parama)
  {
    this.a.f();
    try
    {
      this.b.a(parama);
      this.a.h();
      return;
    }
    finally
    {
      this.a.g();
    }
  }

  public boolean a(String paramString)
  {
    int i = 1;
    h localh = h.a("SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)", i);
    if (paramString == null)
      localh.a(i);
    while (true)
    {
      Cursor localCursor = this.a.a(localh);
      try
      {
        if (localCursor.moveToFirst())
        {
          int k = localCursor.getInt(0);
          if (k != 0);
          while (true)
          {
            return i;
            localh.a(i, paramString);
            break;
            j = 0;
          }
        }
        int j = 0;
      }
      finally
      {
        localCursor.close();
        localh.b();
      }
    }
  }

  public List<String> b(String paramString)
  {
    h localh = h.a("SELECT work_spec_id FROM dependency WHERE prerequisite_id=?", 1);
    if (paramString == null)
      localh.a(1);
    Cursor localCursor;
    ArrayList localArrayList;
    while (true)
    {
      localCursor = this.a.a(localh);
      try
      {
        localArrayList = new ArrayList(localCursor.getCount());
        while (localCursor.moveToNext())
          localArrayList.add(localCursor.getString(0));
      }
      finally
      {
        localCursor.close();
        localh.b();
      }
      localh.a(1, paramString);
    }
    localCursor.close();
    localh.b();
    return localArrayList;
  }

  public boolean c(String paramString)
  {
    int i = 1;
    h localh = h.a("SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?", i);
    if (paramString == null)
      localh.a(i);
    while (true)
    {
      Cursor localCursor = this.a.a(localh);
      try
      {
        if (localCursor.moveToFirst())
        {
          int k = localCursor.getInt(0);
          if (k != 0);
          while (true)
          {
            return i;
            localh.a(i, paramString);
            break;
            j = 0;
          }
        }
        int j = 0;
      }
      finally
      {
        localCursor.close();
        localh.b();
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.b.c
 * JD-Core Version:    0.6.2
 */