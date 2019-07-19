package com.viber.voip.messages.controller.manager;

import com.viber.dexshared.Logger;
import com.viber.provider.b;
import com.viber.provider.messages.b.d;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import java.util.HashMap;
import java.util.Map;
import org.sqlite.database.sqlite.SQLiteStatement;

public class aj
{
  private static final Logger a = ViberEnv.getLogger();
  private static Map<String, SQLiteStatement> b = new HashMap();

  public static SQLiteStatement a(String paramString)
  {
    String str = paramString + "[" + Thread.currentThread().getId() + "]";
    SQLiteStatement localSQLiteStatement = (SQLiteStatement)b.get(str);
    if (localSQLiteStatement == null)
    {
      localSQLiteStatement = d.a(ViberApplication.getApplication()).b(paramString);
      b.put(str, localSQLiteStatement);
    }
    return localSQLiteStatement;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.manager.aj
 * JD-Core Version:    0.6.2
 */