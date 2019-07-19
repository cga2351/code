package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.c;
import com.yandex.metrica.e;
import java.util.concurrent.Executor;

public class kx extends ky<lf>
  implements c
{
  public kx(Executor paramExecutor, Context paramContext, String paramString)
  {
    super(paramExecutor, paramContext, paramString, new lf());
  }

  public void a(final e parame)
  {
    this.b.execute(new Runnable()
    {
      public void run()
      {
        kx.this.b(parame);
      }
    });
  }

  public void a(final String paramString1, final String paramString2)
  {
    ((lf)this.a).a(paramString1, paramString2);
    this.b.execute(new Runnable()
    {
      public void run()
      {
        kx.this.a().a(paramString1, paramString2);
      }
    });
  }

  public void sendEventsBuffer()
  {
    ((lf)this.a).sendEventsBuffer();
    this.b.execute(new Runnable()
    {
      public void run()
      {
        kx.this.a().sendEventsBuffer();
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.kx
 * JD-Core Version:    0.6.2
 */