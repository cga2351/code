package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

@zzare
final class zzbbj
{
  private final Object zzeab = new Object();
  private final List<Runnable> zzeac = new ArrayList();
  private boolean zzead = false;

  public final void zza(Runnable paramRunnable, Executor paramExecutor)
  {
    synchronized (this.zzeab)
    {
      if (this.zzead)
      {
        paramExecutor.execute(paramRunnable);
        return;
      }
      this.zzeac.add(new zzbbk(paramExecutor, paramRunnable));
    }
  }

  public final void zzxd()
  {
    ArrayList localArrayList1 = new ArrayList();
    synchronized (this.zzeab)
    {
      if (this.zzead)
        return;
      localArrayList1.addAll(this.zzeac);
      this.zzeac.clear();
      this.zzead = true;
      ArrayList localArrayList2 = (ArrayList)localArrayList1;
      int i = localArrayList2.size();
      int j = 0;
      if (j < i)
      {
        Object localObject3 = localArrayList2.get(j);
        j++;
        ((Runnable)localObject3).run();
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbbj
 * JD-Core Version:    0.6.2
 */