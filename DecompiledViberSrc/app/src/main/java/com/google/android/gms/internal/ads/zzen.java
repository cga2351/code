package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

public final class zzen extends zzfk
{
  private static final zzfl<zzch> zzzh = new zzfl();
  private final Context zzzg;
  private zzbk.zza zzzi = null;

  public zzen(zzdy paramzzdy, String paramString1, String paramString2, zzbp.zza.zza paramzza, int paramInt1, int paramInt2, Context paramContext, zzbk.zza paramzza1)
  {
    super(paramzzdy, paramString1, paramString2, paramzza, paramInt1, 27);
    this.zzzg = paramContext;
    this.zzzi = paramzza1;
  }

  private static String zza(zzbk.zza paramzza)
  {
    if ((paramzza != null) && (paramzza.zzw()) && (!zzef.zzaq(paramzza.zzx().zzae())))
      return paramzza.zzx().zzae();
    return null;
  }

  private final String zzcy()
  {
    try
    {
      if (this.zzvd.zzcq() != null)
        this.zzvd.zzcq().get();
      zzbp.zza localzza = this.zzvd.zzcp();
      if ((localzza != null) && (localzza.zzai()))
      {
        String str = localzza.zzae();
        return str;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      return null;
    }
    catch (ExecutionException localExecutionException)
    {
      label52: break label52;
    }
  }

  protected final void zzcx()
    throws IllegalAccessException, InvocationTargetException
  {
    while (true)
    {
      int i;
      zzbm localzzbm;
      label88: zzch localzzch2;
      label220: zzch localzzch3;
      zzbp.zza.zza localzza1;
      synchronized (zzzh.zzar(this.zzzg.getPackageName()))
      {
        zzch localzzch1 = (zzch)???.get();
        if ((localzzch1 != null) && (!zzef.zzaq(localzzch1.zzne)) && (!localzzch1.zzne.equals("E")))
          if (localzzch1.zzne.equals("0000000000000000000000000000000000000000000000000000000000000000"))
          {
            break label465;
            if (i != 0)
            {
              if (zzef.zzaq(zza(this.zzzi)))
                break label326;
              localzzbm = zzbm.zzef;
              Method localMethod = this.zzzw;
              Object[] arrayOfObject = new Object[3];
              arrayOfObject[0] = this.zzzg;
              if (localzzbm != zzbm.zzed)
                break label477;
              bool2 = true;
              arrayOfObject[1] = Boolean.valueOf(bool2);
              zzaci localzzaci = zzact.zzcrk;
              arrayOfObject[2] = zzyr.zzpe().zzd(localzzaci);
              localzzch2 = new zzch((String)localMethod.invoke(null, arrayOfObject));
              if ((!zzef.zzaq(localzzch2.zzne)) && (!localzzch2.zzne.equals("E")));
            }
            switch (zzeo.zzzj[localzzbm.ordinal()])
            {
            default:
              ???.set(localzzch2);
              localzzch3 = (zzch)???.get();
              localzza1 = this.zzzm;
              if (localzzch3 == null);
              break;
            case 1:
            case 2:
            }
          }
      }
      while (true)
      {
        try
        {
          this.zzzm.zzz(localzzch3.zzne);
          this.zzzm.zzba(localzzch3.zznf);
          this.zzzm.zzab(localzzch3.zzng);
          this.zzzm.zzac(localzzch3.zznh);
          this.zzzm.zzad(localzzch3.zzni);
          return;
          i = 0;
          break;
          label326: zzbk.zza localzza = this.zzzi;
          if ((!zzef.zzaq(zza(localzza))) || (localzza == null) || (!localzza.zzu()) || (localzza.zzv().zzz() != zzbm.zzee))
            break label471;
          bool1 = true;
          if ((Boolean.valueOf(bool1).booleanValue()) && (this.zzvd.zzcn()))
          {
            localzzbm = zzbm.zzee;
            break label88;
          }
          localzzbm = zzbm.zzed;
          break label88;
          localzzch2.zzne = this.zzzi.zzx().zzae();
          break label220;
          localObject1 = finally;
          throw localObject1;
          String str = zzcy();
          if (zzef.zzaq(str))
            break label220;
          localzzch2.zzne = str;
          break label220;
        }
        finally
        {
        }
        label465: i = 1;
        break;
        label471: boolean bool1 = false;
      }
      label477: boolean bool2 = false;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzen
 * JD-Core Version:    0.6.2
 */