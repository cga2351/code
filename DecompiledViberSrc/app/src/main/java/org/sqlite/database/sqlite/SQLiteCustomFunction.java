package org.sqlite.database.sqlite;

public final class SQLiteCustomFunction
{
  public final SQLiteDatabase.CustomFunction callback;
  public final String name;
  public final int numArgs;

  public SQLiteCustomFunction(String paramString, int paramInt, SQLiteDatabase.CustomFunction paramCustomFunction)
  {
    if (paramString == null)
      throw new IllegalArgumentException("name must not be null.");
    this.name = paramString;
    this.numArgs = paramInt;
    this.callback = paramCustomFunction;
  }

  private void dispatchCallback(String[] paramArrayOfString)
  {
    this.callback.callback(paramArrayOfString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.sqlite.database.sqlite.SQLiteCustomFunction
 * JD-Core Version:    0.6.2
 */