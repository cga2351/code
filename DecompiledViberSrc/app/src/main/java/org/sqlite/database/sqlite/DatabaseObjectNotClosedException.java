package org.sqlite.database.sqlite;

public class DatabaseObjectNotClosedException extends RuntimeException
{
  private static final String s = "Application did not close the cursor or database object that was opened here";

  public DatabaseObjectNotClosedException()
  {
    super("Application did not close the cursor or database object that was opened here");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.sqlite.database.sqlite.DatabaseObjectNotClosedException
 * JD-Core Version:    0.6.2
 */