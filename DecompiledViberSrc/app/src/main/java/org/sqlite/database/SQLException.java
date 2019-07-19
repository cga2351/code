package org.sqlite.database;

public class SQLException extends RuntimeException
{
  public SQLException()
  {
  }

  public SQLException(String paramString)
  {
    super(paramString);
  }

  public SQLException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.sqlite.database.SQLException
 * JD-Core Version:    0.6.2
 */