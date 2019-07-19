package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public final class zzby extends zzak
{
  private final zzfn zzamx;
  private Boolean zzaql;
  private String zzaqm;

  public zzby(zzfn paramzzfn)
  {
    this(paramzzfn, null);
  }

  private zzby(zzfn paramzzfn, String paramString)
  {
    Preconditions.checkNotNull(paramzzfn);
    this.zzamx = paramzzfn;
    this.zzaqm = null;
  }

  private final void zzb(zzk paramzzk, boolean paramBoolean)
  {
    Preconditions.checkNotNull(paramzzk);
    zzc(paramzzk.packageName, false);
    this.zzamx.zzgr().zzu(paramzzk.zzafi, paramzzk.zzafv);
  }

  private final void zzc(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.zzamx.zzgt().zzjg().zzby("Measurement Service called without app package");
      throw new SecurityException("Measurement Service called without app package");
    }
    if (paramBoolean);
    while (true)
    {
      try
      {
        if (this.zzaql == null)
        {
          if (("com.google.android.gms".equals(this.zzaqm)) || (UidVerifier.isGooglePlayServicesUid(this.zzamx.getContext(), Binder.getCallingUid())))
            break label203;
          boolean bool2 = GoogleSignatureVerifier.getInstance(this.zzamx.getContext()).isUidGoogleSigned(Binder.getCallingUid());
          bool1 = false;
          if (bool2)
            break label203;
          this.zzaql = Boolean.valueOf(bool1);
        }
        if (!this.zzaql.booleanValue())
        {
          if ((this.zzaqm == null) && (GooglePlayServicesUtilLight.uidHasPackageName(this.zzamx.getContext(), Binder.getCallingUid(), paramString)))
            this.zzaqm = paramString;
          if (!paramString.equals(this.zzaqm))
            throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[] { paramString }));
        }
      }
      catch (SecurityException localSecurityException)
      {
        this.zzamx.zzgt().zzjg().zzg("Measurement Service called with invalid calling package. appId", zzas.zzbw(paramString));
        throw localSecurityException;
      }
      return;
      label203: boolean bool1 = true;
    }
  }

  @VisibleForTesting
  private final void zze(Runnable paramRunnable)
  {
    Preconditions.checkNotNull(paramRunnable);
    if ((((Boolean)zzai.zzakn.get()).booleanValue()) && (this.zzamx.zzgs().zzkf()))
    {
      paramRunnable.run();
      return;
    }
    this.zzamx.zzgs().zzc(paramRunnable);
  }

  public final List<zzfu> zza(zzk paramzzk, boolean paramBoolean)
  {
    zzb(paramzzk, false);
    Future localFuture = this.zzamx.zzgs().zzb(new zzco(this, paramzzk));
    try
    {
      List localList = (List)localFuture.get();
      localArrayList = new ArrayList(localList.size());
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        zzfw localzzfw = (zzfw)localIterator.next();
        if ((paramBoolean) || (!zzfx.zzcy(localzzfw.name)))
          localArrayList.add(new zzfu(localzzfw));
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      ArrayList localArrayList;
      this.zzamx.zzgt().zzjg().zze("Failed to get user attributes. appId", zzas.zzbw(paramzzk.packageName), localInterruptedException);
      return null;
      return localArrayList;
    }
    catch (ExecutionException localExecutionException)
    {
      label121: break label121;
    }
  }

  public final List<zzo> zza(String paramString1, String paramString2, zzk paramzzk)
  {
    zzb(paramzzk, false);
    Future localFuture = this.zzamx.zzgs().zzb(new zzcg(this, paramzzk, paramString1, paramString2));
    try
    {
      List localList = (List)localFuture.get();
      return localList;
    }
    catch (InterruptedException localInterruptedException)
    {
      this.zzamx.zzgt().zzjg().zzg("Failed to get conditional user properties", localInterruptedException);
      return Collections.emptyList();
    }
    catch (ExecutionException localExecutionException)
    {
      label46: break label46;
    }
  }

  public final List<zzfu> zza(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    zzc(paramString1, true);
    Future localFuture = this.zzamx.zzgs().zzb(new zzcf(this, paramString1, paramString2, paramString3));
    try
    {
      List localList = (List)localFuture.get();
      localArrayList = new ArrayList(localList.size());
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        zzfw localzzfw = (zzfw)localIterator.next();
        if ((paramBoolean) || (!zzfx.zzcy(localzzfw.name)))
          localArrayList.add(new zzfu(localzzfw));
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      ArrayList localArrayList;
      this.zzamx.zzgt().zzjg().zze("Failed to get user attributes. appId", zzas.zzbw(paramString1), localInterruptedException);
      return Collections.emptyList();
      return localArrayList;
    }
    catch (ExecutionException localExecutionException)
    {
      label126: break label126;
    }
  }

  public final List<zzfu> zza(String paramString1, String paramString2, boolean paramBoolean, zzk paramzzk)
  {
    zzb(paramzzk, false);
    Future localFuture = this.zzamx.zzgs().zzb(new zzce(this, paramzzk, paramString1, paramString2));
    try
    {
      List localList = (List)localFuture.get();
      localArrayList = new ArrayList(localList.size());
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        zzfw localzzfw = (zzfw)localIterator.next();
        if ((paramBoolean) || (!zzfx.zzcy(localzzfw.name)))
          localArrayList.add(new zzfu(localzzfw));
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      ArrayList localArrayList;
      this.zzamx.zzgt().zzjg().zze("Failed to get user attributes. appId", zzas.zzbw(paramzzk.packageName), localInterruptedException);
      return Collections.emptyList();
      return localArrayList;
    }
    catch (ExecutionException localExecutionException)
    {
      label127: break label127;
    }
  }

  public final void zza(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    zze(new zzcq(this, paramString2, paramString3, paramString1, paramLong));
  }

  public final void zza(zzag paramzzag, zzk paramzzk)
  {
    Preconditions.checkNotNull(paramzzag);
    zzb(paramzzk, false);
    zze(new zzcj(this, paramzzag, paramzzk));
  }

  public final void zza(zzag paramzzag, String paramString1, String paramString2)
  {
    Preconditions.checkNotNull(paramzzag);
    Preconditions.checkNotEmpty(paramString1);
    zzc(paramString1, true);
    zze(new zzck(this, paramzzag, paramString1));
  }

  public final void zza(zzfu paramzzfu, zzk paramzzk)
  {
    Preconditions.checkNotNull(paramzzfu);
    zzb(paramzzk, false);
    if (paramzzfu.getValue() == null)
    {
      zze(new zzcm(this, paramzzfu, paramzzk));
      return;
    }
    zze(new zzcn(this, paramzzfu, paramzzk));
  }

  public final void zza(zzk paramzzk)
  {
    zzb(paramzzk, false);
    zze(new zzcp(this, paramzzk));
  }

  public final void zza(zzo paramzzo, zzk paramzzk)
  {
    Preconditions.checkNotNull(paramzzo);
    Preconditions.checkNotNull(paramzzo.zzags);
    zzb(paramzzk, false);
    zzo localzzo = new zzo(paramzzo);
    localzzo.packageName = paramzzk.packageName;
    if (paramzzo.zzags.getValue() == null)
    {
      zze(new zzca(this, localzzo, paramzzk));
      return;
    }
    zze(new zzcb(this, localzzo, paramzzk));
  }

  public final byte[] zza(zzag paramzzag, String paramString)
  {
    Preconditions.checkNotEmpty(paramString);
    Preconditions.checkNotNull(paramzzag);
    zzc(paramString, true);
    this.zzamx.zzgt().zzjn().zzg("Log and bundle. event", this.zzamx.zzgq().zzbt(paramzzag.name));
    long l1 = this.zzamx.zzbx().nanoTime() / 1000000L;
    Future localFuture = this.zzamx.zzgs().zzc(new zzcl(this, paramzzag, paramString));
    try
    {
      byte[] arrayOfByte = (byte[])localFuture.get();
      if (arrayOfByte == null)
      {
        this.zzamx.zzgt().zzjg().zzg("Log and bundle returned null. appId", zzas.zzbw(paramString));
        arrayOfByte = new byte[0];
      }
      long l2 = this.zzamx.zzbx().nanoTime() / 1000000L;
      this.zzamx.zzgt().zzjn().zzd("Log and bundle processed. event, size, time_ms", this.zzamx.zzgq().zzbt(paramzzag.name), Integer.valueOf(arrayOfByte.length), Long.valueOf(l2 - l1));
      return arrayOfByte;
    }
    catch (InterruptedException localInterruptedException)
    {
      this.zzamx.zzgt().zzjg().zzd("Failed to log and bundle. appId, event, error", zzas.zzbw(paramString), this.zzamx.zzgq().zzbt(paramzzag.name), localInterruptedException);
      return null;
    }
    catch (ExecutionException localExecutionException)
    {
      label195: break label195;
    }
  }

  @VisibleForTesting
  final zzag zzb(zzag paramzzag, zzk paramzzk)
  {
    boolean bool1 = "_cmp".equals(paramzzag.name);
    int i = 0;
    if (bool1)
    {
      zzad localzzad = paramzzag.zzahu;
      i = 0;
      if (localzzad != null)
      {
        int j = paramzzag.zzahu.size();
        i = 0;
        if (j != 0)
          break label97;
      }
    }
    while (i != 0)
    {
      this.zzamx.zzgt().zzjm().zzg("Event has been filtered ", paramzzag.toString());
      return new zzag("_cmpx", paramzzag.zzahu, paramzzag.origin, paramzzag.zzaig);
      label97: String str = paramzzag.zzahu.getString("_cis");
      boolean bool2 = TextUtils.isEmpty(str);
      i = 0;
      if (!bool2)
        if (!"referrer broadcast".equals(str))
        {
          boolean bool4 = "referrer API".equals(str);
          i = 0;
          if (!bool4);
        }
        else
        {
          boolean bool3 = this.zzamx.zzgv().zzbe(paramzzk.packageName);
          i = 0;
          if (bool3)
            i = 1;
        }
    }
    return paramzzag;
  }

  public final void zzb(zzk paramzzk)
  {
    zzb(paramzzk, false);
    zze(new zzbz(this, paramzzk));
  }

  public final void zzb(zzo paramzzo)
  {
    Preconditions.checkNotNull(paramzzo);
    Preconditions.checkNotNull(paramzzo.zzags);
    zzc(paramzzo.packageName, true);
    zzo localzzo = new zzo(paramzzo);
    if (paramzzo.zzags.getValue() == null)
    {
      zze(new zzcc(this, localzzo));
      return;
    }
    zze(new zzcd(this, localzzo));
  }

  public final String zzc(zzk paramzzk)
  {
    zzb(paramzzk, false);
    return this.zzamx.zzh(paramzzk);
  }

  public final void zzd(zzk paramzzk)
  {
    zzc(paramzzk.packageName, false);
    zze(new zzci(this, paramzzk));
  }

  public final List<zzo> zze(String paramString1, String paramString2, String paramString3)
  {
    zzc(paramString1, true);
    Future localFuture = this.zzamx.zzgs().zzb(new zzch(this, paramString1, paramString2, paramString3));
    try
    {
      List localList = (List)localFuture.get();
      return localList;
    }
    catch (InterruptedException localInterruptedException)
    {
      this.zzamx.zzgt().zzjg().zzg("Failed to get conditional user properties", localInterruptedException);
      return Collections.emptyList();
    }
    catch (ExecutionException localExecutionException)
    {
      label46: break label46;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzby
 * JD-Core Version:    0.6.2
 */