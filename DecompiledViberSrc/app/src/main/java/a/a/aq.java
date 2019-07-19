package a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.appboy.f.c;

public class aq
{
  private static final String d = c.a(aq.class);
  final SharedPreferences a;
  final d b;
  boolean c = false;
  private final dd e;

  public aq(Context paramContext, d paramd, dd paramdd)
  {
    this.b = paramd;
    this.e = paramdd;
    this.a = paramContext.getSharedPreferences("com.appboy.storage.sessions.messaging_session", 0);
  }

  void a()
  {
    if (c())
    {
      c.b(d, "Publishing new messaging session event.");
      this.b.a(l.a, l.class);
      this.c = true;
      return;
    }
    c.b(d, "Messaging session not started.");
  }

  void b()
  {
    long l = di.a();
    c.b(d, "Messaging session stopped. Adding new messaging session timestamp: " + l);
    this.a.edit().putLong("messaging_session_timestamp", l).apply();
    this.c = false;
  }

  boolean c()
  {
    long l1 = this.e.f();
    boolean bool1 = l1 < -1L;
    boolean bool2 = false;
    if (bool1)
    {
      boolean bool3 = this.c;
      bool2 = false;
      if (!bool3)
      {
        long l2 = this.a.getLong("messaging_session_timestamp", -1L);
        long l3 = di.a();
        c.b(d, "Messaging session timeout: " + l1 + ", current diff: " + (l3 - l2));
        boolean bool4 = l1 + l2 < l3;
        bool2 = false;
        if (bool4)
          bool2 = true;
      }
    }
    return bool2;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.aq
 * JD-Core Version:    0.6.2
 */