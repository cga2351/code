package com.viber.provider.messages;

import android.content.ContentValues;
import android.database.Cursor;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.util.Arrays;
import org.sqlite.database.SQLException;
import org.sqlite.database.sqlite.SQLiteDatabase;
import org.sqlite.database.sqlite.SQLiteStatement;

public class b extends a
{
  private static final Logger b = ViberEnv.getLogger();
  private static final ThreadLocal<a> c = new ThreadLocal();
  private static int d;
  private static int e;
  private static int f;

  private void a(a parama, boolean paramBoolean)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    if (paramBoolean);
    for (String str = "BEFORE"; ; str = "AFTER ")
    {
      StringBuilder localStringBuilder2 = localStringBuilder1.append(str).append(" THRID:").append(parama.a).append(", OPID:").append(parama.b);
      if (parama.c != 0)
      {
        localStringBuilder2.append(", TRID:").append(parama.c);
        localStringBuilder2.append(", TRDEP:").append(parama.d);
      }
      localStringBuilder2.append(", METHOD:").append(parama.e);
      if (parama.f != null)
        localStringBuilder2.append(", QUERY:").append(parama.f);
      if ((parama.g != null) && (parama.g.length > 0))
        localStringBuilder2.append(", ARGS:").append(Arrays.toString(parama.g));
      return;
    }
  }

  private void b(String paramString, Object[] paramArrayOfObject)
  {
    a locala = n();
    locala.f = paramString;
    locala.g = paramArrayOfObject;
    locala.e = o()[2].getMethodName();
    if (locala.e.startsWith("beginTransaction"))
    {
      if (!this.a.inTransaction())
        locala.c = k();
      locala.d = (1 + locala.d);
    }
    locala.b = j();
    a(locala, true);
  }

  private static int j()
  {
    try
    {
      int i = d;
      d = i + 1;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private static int k()
  {
    try
    {
      int i = e;
      e = i + 1;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private static int l()
  {
    try
    {
      int i = f;
      f = i + 1;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private void m()
  {
    a locala = n();
    a(locala, false);
    if (locala.e.equals("endTransaction"))
      locala.d = (-1 + locala.d);
    if (!this.a.inTransaction())
      locala.c = 0;
    locala.f = null;
    locala.g = null;
  }

  private a n()
  {
    a locala = (a)c.get();
    if (locala == null)
    {
      locala = new a();
      c.set(locala);
      locala.a = l();
    }
    return locala;
  }

  private StackTraceElement[] o()
  {
    new Throwable().getStackTrace();
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    if (arrayOfStackTraceElement.length < 3)
      throw new IllegalStateException("Synthetic stacktrace didn't have enough elements");
    return arrayOfStackTraceElement;
  }

  public int a(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    try
    {
      b(null, new Object[] { paramString1, paramContentValues, paramString2, paramArrayOfString });
      int i = super.a(paramString1, paramContentValues, paramString2, paramArrayOfString);
      return i;
    }
    finally
    {
      m();
    }
  }

  public int a(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    try
    {
      b(null, new Object[] { paramString1, paramString2, paramArrayOfString });
      int i = super.a(paramString1, paramString2, paramArrayOfString);
      return i;
    }
    finally
    {
      m();
    }
  }

  public long a(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    try
    {
      b(null, new Object[] { paramString1, paramString2, paramContentValues });
      long l = super.a(paramString1, paramString2, paramContentValues);
      return l;
    }
    finally
    {
      m();
    }
  }

  public long a(SQLiteStatement paramSQLiteStatement)
  {
    try
    {
      b(null, new Object[0]);
      long l = super.a(paramSQLiteStatement);
      return l;
    }
    finally
    {
      m();
    }
  }

  public Cursor a(String paramString, String[] paramArrayOfString)
  {
    try
    {
      b(paramString, (Object[])paramArrayOfString);
      Cursor localCursor = super.a(paramString, paramArrayOfString);
      return localCursor;
    }
    finally
    {
      m();
    }
  }

  public Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      b(a(false, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, null), new Object[0]);
      Cursor localCursor = super.a(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5);
      return localCursor;
    }
    finally
    {
      m();
    }
  }

  public Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    try
    {
      b(a(false, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramString6), new Object[0]);
      Cursor localCursor = super.a(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramString6);
      return localCursor;
    }
    finally
    {
      m();
    }
  }

  public void a()
  {
    try
    {
      b(null, new Object[0]);
      super.a();
      return;
    }
    finally
    {
      m();
    }
  }

  public void a(String paramString)
    throws SQLException
  {
    try
    {
      b(paramString, new Object[0]);
      super.a(paramString);
      return;
    }
    finally
    {
      m();
    }
  }

  public void a(String paramString, Object[] paramArrayOfObject)
    throws SQLException
  {
    try
    {
      b(paramString, paramArrayOfObject);
      super.a(paramString, paramArrayOfObject);
      return;
    }
    finally
    {
      m();
    }
  }

  public long b(String paramString1, String paramString2, ContentValues paramContentValues)
    throws SQLException
  {
    try
    {
      b(null, new Object[] { paramString1, paramString2, paramContentValues });
      long l = super.b(paramString1, paramString2, paramContentValues);
      return l;
    }
    finally
    {
      m();
    }
  }

  public void b()
  {
    try
    {
      b(null, new Object[0]);
      super.b();
      return;
    }
    finally
    {
      m();
    }
  }

  public void c()
  {
    try
    {
      b(null, new Object[0]);
      super.c();
      return;
    }
    finally
    {
      m();
    }
  }

  public boolean d()
  {
    try
    {
      b(null, new Object[0]);
      boolean bool = super.d();
      return bool;
    }
    finally
    {
      m();
    }
  }

  public boolean e()
  {
    try
    {
      b(null, new Object[0]);
      boolean bool = super.e();
      return bool;
    }
    finally
    {
      m();
    }
  }

  private static class a
  {
    int a;
    int b;
    int c;
    int d;
    String e;
    String f;
    Object[] g;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.provider.messages.b
 * JD-Core Version:    0.6.2
 */