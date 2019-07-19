package com.viber.voip.group.participants.settings;

import android.content.Context;
import android.support.v4.app.LoaderManager;
import android.support.v4.util.ArraySet;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.conversation.ac;
import com.viber.voip.messages.conversation.ae;
import com.viber.voip.messages.k;
import com.viber.voip.util.cl;
import dagger.a;
import java.util.Set;
import org.greenrobot.eventbus.EventBus;

public class d
  implements com.viber.provider.d.a, e
{
  private static final Logger b = ViberEnv.getLogger();
  private boolean a;
  private final ac c;
  private a d = (a)cl.b(a.class);

  public d(Context paramContext, LoaderManager paramLoaderManager, a<k> parama, int paramInt, EventBus paramEventBus)
  {
    this.c = new ac(8, paramContext, false, false, null, paramInt, paramLoaderManager, parama, this, paramEventBus);
  }

  public d(Context paramContext, LoaderManager paramLoaderManager, a<k> parama, EventBus paramEventBus)
  {
    ArraySet localArraySet = new ArraySet();
    localArraySet.add(Integer.valueOf(1));
    localArraySet.add(Integer.valueOf(4));
    this.c = new ac(paramContext, false, false, localArraySet, paramLoaderManager, parama, this, paramEventBus);
  }

  private void a(boolean paramBoolean)
  {
    if (paramBoolean == this.a)
      return;
    this.a = paramBoolean;
    if (this.a)
    {
      this.c.p();
      return;
    }
    this.c.q();
  }

  public ae a(int paramInt)
  {
    return this.c.e(paramInt);
  }

  public void a()
  {
    a(false);
  }

  public void a(long paramLong)
  {
    if (!this.c.a(paramLong))
    {
      this.c.b(paramLong);
      this.c.i();
    }
    a(true);
  }

  public void a(a parama)
  {
    this.d = parama;
  }

  public void a(String paramString)
  {
    if (this.c.d())
      this.c.a(paramString, paramString);
  }

  public void b()
  {
    this.c.j();
  }

  public int c()
  {
    return this.c.getCount();
  }

  public void onLoadFinished(com.viber.provider.d paramd, boolean paramBoolean)
  {
    this.d.b(paramBoolean);
  }

  public void onLoaderReset(com.viber.provider.d paramd)
  {
  }

  public static abstract interface a
  {
    public abstract void b(boolean paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.group.participants.settings.d
 * JD-Core Version:    0.6.2
 */