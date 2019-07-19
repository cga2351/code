package org.sqlite.database.sqlite;

public abstract interface SQLiteTransactionListener
{
  public abstract void onBegin();

  public abstract void onCommit();

  public abstract void onRollback();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.sqlite.database.sqlite.SQLiteTransactionListener
 * JD-Core Version:    0.6.2
 */