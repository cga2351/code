package com.viber.voip.engagement.d;

import android.os.Handler;
import android.support.v4.util.ArrayMap;
import com.viber.voip.model.a;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

public class n
{
  private final Handler a;
  private final Handler b;
  private final i c;
  private final boolean d;

  @Nullable
  private Map<String, m> e;

  public n(boolean paramBoolean, j paramj, Handler paramHandler1, Handler paramHandler2)
  {
    this.d = paramBoolean;
    this.a = paramHandler1;
    this.b = paramHandler2;
    this.c = paramj.a();
  }

  @Nullable
  public m a(String paramString)
  {
    if (this.e != null)
      return (m)this.e.get(paramString);
    return null;
  }

  public void a(final a parama)
  {
    this.a.post(new Runnable()
    {
      public void run()
      {
        if (n.a(n.this));
        for (ArrayMap localArrayMap = new ArrayMap(); ; localArrayMap = null)
        {
          final List localList = n.b(n.this).a(localArrayMap);
          n.a(n.this, localArrayMap);
          n.c(n.this).post(new Runnable()
          {
            public void run()
            {
              n.1.this.a.a(localList);
            }
          });
          return;
        }
      }
    });
  }

  public static abstract interface a
  {
    public abstract void a(List<a> paramList);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.d.n
 * JD-Core Version:    0.6.2
 */