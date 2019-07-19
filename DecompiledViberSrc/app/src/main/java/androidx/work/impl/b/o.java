package androidx.work.impl.b;

import android.arch.persistence.a.f;
import android.arch.persistence.room.b;
import android.arch.persistence.room.e;
import android.arch.persistence.room.h;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.List;

public class o
  implements n
{
  private final e a;
  private final b b;

  public o(e parame)
  {
    this.a = parame;
    this.b = new b(parame)
    {
      public String a()
      {
        return "INSERT OR IGNORE INTO `WorkTag`(`tag`,`work_spec_id`) VALUES (?,?)";
      }

      public void a(f paramAnonymousf, m paramAnonymousm)
      {
        if (paramAnonymousm.a == null)
          paramAnonymousf.a(1);
        while (paramAnonymousm.b == null)
        {
          paramAnonymousf.a(2);
          return;
          paramAnonymousf.a(1, paramAnonymousm.a);
        }
        paramAnonymousf.a(2, paramAnonymousm.b);
      }
    };
  }

  public List<String> a(String paramString)
  {
    h localh = h.a("SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?", 1);
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

  public void a(m paramm)
  {
    this.a.f();
    try
    {
      this.b.a(paramm);
      this.a.h();
      return;
    }
    finally
    {
      this.a.g();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.b.o
 * JD-Core Version:    0.6.2
 */