package com.viber.voip.app;

import android.content.Context;
import android.content.res.Resources;
import com.viber.dexshared.Logger;
import com.viber.voip.R.bool;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.dj;
import dagger.a;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.greenrobot.eventbus.EventBus;

@Singleton
public class b
{
  private static final Logger a = ViberEnv.getLogger();
  private final Context b;
  private final a<EventBus> c;
  private Boolean d;

  @Inject
  public b(Context paramContext, a<EventBus> parama)
  {
    this.b = paramContext.getApplicationContext();
    this.c = parama;
  }

  public boolean a()
  {
    return dj.c(this.b);
  }

  public boolean a(Context paramContext)
  {
    int i;
    Context localContext;
    label19: boolean bool;
    if (this.b == paramContext)
    {
      i = 1;
      if (paramContext != null)
        break label60;
      localContext = this.b;
      bool = localContext.getResources().getBoolean(R.bool.is_tablet);
      if (this.d != null)
        break label65;
      this.d = Boolean.valueOf(bool);
    }
    while (true)
    {
      return this.d.booleanValue();
      i = 0;
      break;
      label60: localContext = paramContext;
      break label19;
      label65: if ((paramContext != null) && (i == 0) && (this.d.booleanValue() != bool))
      {
        this.d = Boolean.valueOf(bool);
        ((EventBus)this.c.get()).post(new a(this.d.booleanValue(), false));
      }
    }
  }

  public static class a
  {
    public final boolean a;
    public final boolean b;

    public a(boolean paramBoolean1, boolean paramBoolean2)
    {
      this.a = paramBoolean1;
      this.b = paramBoolean2;
    }

    public String toString()
    {
      return "DeviceTypeChanged{isTablet=" + this.a + ", isInitial=" + this.b + '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.app.b
 * JD-Core Version:    0.6.2
 */