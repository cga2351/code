package com.viber.provider;

import android.content.Context;
import com.viber.dexshared.Logger;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.sqlite.database.SQLException;
import org.sqlite.database.sqlite.SQLiteOpenHelper;

public abstract class e extends SQLiteOpenHelper
{
  protected Context a;

  protected e(Context paramContext, String paramString)
  {
    super(paramContext, paramContext.getApplicationContext().getDatabasePath(paramString).getPath(), null, 155);
    this.a = paramContext;
  }

  public static void a(Context paramContext, String paramString, b paramb, Logger paramLogger)
  {
    Iterator localIterator = com.viber.voip.s.b.a(paramContext, paramString).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        paramb.a(str);
      }
      catch (SQLException localSQLException)
      {
        paramLogger.a(localSQLException, paramString + " failed on " + str);
      }
    }
  }

  protected static boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt1 < paramInt3) && (paramInt2 >= paramInt3);
  }

  protected final Context a()
  {
    return this.a;
  }

  protected abstract void a(b paramb);

  protected abstract void b(b paramb);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.provider.e
 * JD-Core Version:    0.6.2
 */