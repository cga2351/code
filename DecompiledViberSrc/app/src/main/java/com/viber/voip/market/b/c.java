package com.viber.voip.market.b;

import android.os.Handler;
import com.viber.voip.apps.a;
import com.viber.voip.apps.b;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.market.MarketApi.AppStatusInfo;
import com.viber.voip.market.MarketApi.a;
import com.viber.voip.market.MarketApi.b;
import com.viber.voip.util.dd;
import java.util.List;

public class c
{
  public void a(final MarketApi.b paramb)
  {
    av.a(av.e.f).post(new Runnable()
    {
      public void run()
      {
        List localList = new a().b();
        final MarketApi.AppStatusInfo[] arrayOfAppStatusInfo = new MarketApi.AppStatusInfo[localList.size()];
        int i = localList.size();
        for (int j = 0; j < i; j++)
          arrayOfAppStatusInfo[j] = new MarketApi.AppStatusInfo(String.valueOf(((b)localList.get(j)).a()), MarketApi.a.c);
        dd.a(new Runnable()
        {
          public void run()
          {
            c.1.this.a.a(arrayOfAppStatusInfo);
          }
        });
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.market.b.c
 * JD-Core Version:    0.6.2
 */