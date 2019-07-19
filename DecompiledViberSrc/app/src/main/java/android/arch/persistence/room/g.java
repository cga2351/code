package android.arch.persistence.room;

import android.arch.persistence.a.b;
import android.arch.persistence.a.c.a;
import android.database.Cursor;
import java.util.Iterator;
import java.util.List;

public class g extends c.a
{
  private a b;
  private final a c;
  private final String d;
  private final String e;

  public g(a parama, a parama1, String paramString1, String paramString2)
  {
    super(parama1.a);
    this.b = parama;
    this.c = parama1;
    this.d = paramString1;
    this.e = paramString2;
  }

  private void e(b paramb)
  {
    boolean bool1 = h(paramb);
    Object localObject1 = null;
    Cursor localCursor;
    if (bool1)
      localCursor = paramb.a(new android.arch.persistence.a.a("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
    try
    {
      boolean bool2 = localCursor.moveToFirst();
      localObject1 = null;
      if (bool2)
      {
        String str = localCursor.getString(0);
        localObject1 = str;
      }
      localCursor.close();
      if ((!this.d.equals(localObject1)) && (!this.e.equals(localObject1)))
        throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
    }
    finally
    {
      localCursor.close();
    }
  }

  private void f(b paramb)
  {
    g(paramb);
    paramb.c(f.a(this.d));
  }

  private void g(b paramb)
  {
    paramb.c("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
  }

  private static boolean h(b paramb)
  {
    Cursor localCursor = paramb.b("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
    try
    {
      boolean bool1 = localCursor.moveToFirst();
      boolean bool2 = false;
      if (bool1)
      {
        int i = localCursor.getInt(0);
        bool2 = false;
        if (i != 0)
          bool2 = true;
      }
      return bool2;
    }
    finally
    {
      localCursor.close();
    }
  }

  public void a(b paramb)
  {
    super.a(paramb);
  }

  public void a(b paramb, int paramInt1, int paramInt2)
  {
    a locala = this.b;
    int i = 0;
    if (locala != null)
    {
      List localList = this.b.d.a(paramInt1, paramInt2);
      i = 0;
      if (localList != null)
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
          ((android.arch.persistence.room.a.a)localIterator.next()).a(paramb);
        this.c.e(paramb);
        f(paramb);
        i = 1;
      }
    }
    if (i == 0)
    {
      if ((this.b != null) && (!this.b.a(paramInt1)))
      {
        this.c.a(paramb);
        this.c.b(paramb);
      }
    }
    else
      return;
    throw new IllegalStateException("A migration from " + paramInt1 + " to " + paramInt2 + " was required but not found. Please provide the " + "necessary Migration path via " + "RoomDatabase.Builder.addMigration(Migration ...) or allow for " + "destructive migrations via one of the " + "RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
  }

  public void b(b paramb)
  {
    f(paramb);
    this.c.b(paramb);
    this.c.d(paramb);
  }

  public void b(b paramb, int paramInt1, int paramInt2)
  {
    a(paramb, paramInt1, paramInt2);
  }

  public void c(b paramb)
  {
    super.c(paramb);
    e(paramb);
    this.c.c(paramb);
    this.b = null;
  }

  public static abstract class a
  {
    public final int a;

    public a(int paramInt)
    {
      this.a = paramInt;
    }

    protected abstract void a(b paramb);

    protected abstract void b(b paramb);

    protected abstract void c(b paramb);

    protected abstract void d(b paramb);

    protected abstract void e(b paramb);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.arch.persistence.room.g
 * JD-Core Version:    0.6.2
 */