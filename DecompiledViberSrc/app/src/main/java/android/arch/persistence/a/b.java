package android.arch.persistence.a;

import android.database.Cursor;
import android.database.SQLException;
import android.util.Pair;
import java.io.Closeable;
import java.util.List;

public abstract interface b extends Closeable
{
  public abstract f a(String paramString);

  public abstract Cursor a(e parame);

  public abstract void a();

  public abstract Cursor b(String paramString);

  public abstract void b();

  public abstract void c();

  public abstract void c(String paramString)
    throws SQLException;

  public abstract boolean d();

  public abstract boolean e();

  public abstract String f();

  public abstract List<Pair<String, String>> g();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.arch.persistence.a.b
 * JD-Core Version:    0.6.2
 */