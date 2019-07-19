package com.yandex.metrica;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.yandex.metrica.impl.ob.eq;
import com.yandex.metrica.impl.ob.eu;
import com.yandex.metrica.impl.ob.ey;
import com.yandex.metrica.impl.ob.fa;
import com.yandex.metrica.impl.ob.fb;
import com.yandex.metrica.impl.ob.fc;
import java.util.HashMap;
import java.util.Map;

public class ConfigurationService extends Service
{
  private Map<String, fa> a = new HashMap();
  private eu b;
  private String c;

  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }

  public void onCreate()
  {
    super.onCreate();
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = getPackageName();
    this.c = String.format("[ConfigurationService:%s]", arrayOfObject);
    this.b = new eu();
    Context localContext = getApplicationContext();
    ey localey = new ey(localContext, this.b.a(), new eq(localContext));
    this.a.put("com.yandex.metrica.configuration.ACTION_INIT", new fc(getApplicationContext(), localey));
    this.a.put("com.yandex.metrica.configuration.ACTION_SCHEDULED_START", new fb(getApplicationContext(), localey));
  }

  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    Object localObject;
    fa localfa;
    eu localeu;
    Bundle localBundle;
    if (paramIntent == null)
    {
      localObject = null;
      localfa = (fa)this.a.get(localObject);
      if (localfa != null)
      {
        localeu = this.b;
        localBundle = null;
        if (paramIntent != null)
          break label61;
      }
    }
    while (true)
    {
      localeu.a(localfa, localBundle);
      return 2;
      localObject = paramIntent.getAction();
      break;
      label61: localBundle = paramIntent.getExtras();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.ConfigurationService
 * JD-Core Version:    0.6.2
 */