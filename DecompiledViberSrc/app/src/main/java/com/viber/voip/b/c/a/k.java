package com.viber.voip.b.c.a;

import android.content.Context;
import com.viber.dexshared.Logger;
import com.viber.provider.b;
import com.viber.provider.messages.b.d;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.b.c.a.a.a;
import com.viber.voip.b.c.a.a.g;
import com.viber.voip.util.dv;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.sqlite.database.sqlite.SQLiteStatement;

public class k extends c
{
  private static final Logger d = ViberEnv.getLogger();

  public k(Context paramContext)
  {
    super(paramContext);
  }

  private boolean a(SQLiteStatement paramSQLiteStatement, File paramFile)
  {
    paramSQLiteStatement.bindString(1, "file://" + paramFile.getAbsolutePath());
    return paramSQLiteStatement.simpleQueryForLong() > 0L;
  }

  private b f()
  {
    return d.a(ViberApplication.getApplication());
  }

  public void a()
  {
    this.b = new f(new g(new a()), 256);
    this.b.b(true);
  }

  protected void b()
  {
    if (this.a);
    List localList;
    label87: 
    do
    {
      return;
      SQLiteStatement localSQLiteStatement = f().b("SELECT COUNT(*) FROM messages WHERE extra_uri = ?");
      localList = this.b.a(dv.p.a(this.c));
      Iterator localIterator = localList.iterator();
      while (true)
      {
        if (!localIterator.hasNext())
          break label87;
        if (this.a)
          break;
        if (a(localSQLiteStatement, (File)localIterator.next()))
          localIterator.remove();
      }
    }
    while (this.a);
    this.b.a(localList);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.b.c.a.k
 * JD-Core Version:    0.6.2
 */