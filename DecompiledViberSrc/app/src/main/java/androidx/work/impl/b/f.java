package androidx.work.impl.b;

import android.arch.persistence.room.b;
import android.arch.persistence.room.h;
import android.arch.persistence.room.i;
import android.database.Cursor;

public class f
  implements e
{
  private final android.arch.persistence.room.e a;
  private final b b;
  private final i c;

  public f(android.arch.persistence.room.e parame)
  {
    this.a = parame;
    this.b = new b(parame)
    {
      public String a()
      {
        return "INSERT OR REPLACE INTO `SystemIdInfo`(`work_spec_id`,`system_id`) VALUES (?,?)";
      }

      public void a(android.arch.persistence.a.f paramAnonymousf, d paramAnonymousd)
      {
        if (paramAnonymousd.a == null)
          paramAnonymousf.a(1);
        while (true)
        {
          paramAnonymousf.a(2, paramAnonymousd.b);
          return;
          paramAnonymousf.a(1, paramAnonymousd.a);
        }
      }
    };
    this.c = new i(parame)
    {
      public String a()
      {
        return "DELETE FROM SystemIdInfo where work_spec_id=?";
      }
    };
  }

  public d a(String paramString)
  {
    h localh = h.a("SELECT * FROM SystemIdInfo WHERE work_spec_id=?", 1);
    if (paramString == null)
      localh.a(1);
    while (true)
    {
      Cursor localCursor = this.a.a(localh);
      try
      {
        int i = localCursor.getColumnIndexOrThrow("work_spec_id");
        int j = localCursor.getColumnIndexOrThrow("system_id");
        if (localCursor.moveToFirst())
        {
          locald = new d(localCursor.getString(i), localCursor.getInt(j));
          return locald;
          localh.a(1, paramString);
          continue;
        }
        d locald = null;
      }
      finally
      {
        localCursor.close();
        localh.b();
      }
    }
  }

  public void a(d paramd)
  {
    this.a.f();
    try
    {
      this.b.a(paramd);
      this.a.h();
      return;
    }
    finally
    {
      this.a.g();
    }
  }

  public void b(String paramString)
  {
    android.arch.persistence.a.f localf = this.c.c();
    this.a.f();
    if (paramString == null);
    try
    {
      localf.a(1);
      while (true)
      {
        localf.a();
        this.a.h();
        return;
        localf.a(1, paramString);
      }
    }
    finally
    {
      this.a.g();
      this.c.a(localf);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.b.f
 * JD-Core Version:    0.6.2
 */