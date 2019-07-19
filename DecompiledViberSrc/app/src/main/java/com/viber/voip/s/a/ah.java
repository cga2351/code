package com.viber.voip.s.a;

import android.database.Cursor;
import com.viber.provider.b;
import org.sqlite.database.sqlite.SQLiteQueryBuilder;

public class ah extends ai
{
  private final SQLiteQueryBuilder a = new SQLiteQueryBuilder();

  public ah()
  {
  }

  public ah(String paramString)
  {
    this.a.setTables(paramString);
  }

  public ah(String paramString1, String paramString2)
  {
    this.a.setTables(paramString1);
    this.a.appendWhere(paramString2);
  }

  public Cursor a(b paramb, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, String paramString3, String paramString4)
  {
    return paramb.a(this.a, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, paramString3, paramString4);
  }

  protected String a(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    throw new UnsupportedOperationException("SQLiteQueryBuilderWrapper does not support buildSql method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.s.a.ah
 * JD-Core Version:    0.6.2
 */