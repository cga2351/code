package com.google.android.gms.auth.api.accounttransfer;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApi.Settings.Builder;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.auth.zzab;
import com.google.android.gms.internal.auth.zzad;
import com.google.android.gms.internal.auth.zzaf;
import com.google.android.gms.internal.auth.zzah;
import com.google.android.gms.internal.auth.zzs;
import com.google.android.gms.internal.auth.zzu;
import com.google.android.gms.internal.auth.zzv;
import com.google.android.gms.internal.auth.zzy;
import com.google.android.gms.internal.auth.zzz;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public class AccountTransferClient extends GoogleApi<zzn>
{
  private static final Api.ClientKey<zzu> zzaj = new Api.ClientKey();
  private static final Api.AbstractClientBuilder<zzu, zzn> zzak = new zzc();
  private static final Api<zzn> zzal = new Api("AccountTransfer.ACCOUNT_TRANSFER_API", zzak, zzaj);

  AccountTransferClient(Activity paramActivity)
  {
    super(paramActivity, zzal, null, new GoogleApi.Settings.Builder().setMapper(new ApiExceptionMapper()).build());
  }

  AccountTransferClient(Context paramContext)
  {
    super(paramContext, zzal, null, new GoogleApi.Settings.Builder().setMapper(new ApiExceptionMapper()).build());
  }

  private static void zza(TaskCompletionSource paramTaskCompletionSource, Status paramStatus)
  {
    paramTaskCompletionSource.setException(new AccountTransferException(paramStatus));
  }

  public Task<DeviceMetaData> getDeviceMetaData(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    return doRead(new zzg(this, new zzv(paramString)));
  }

  public Task<Void> notifyCompletion(String paramString, int paramInt)
  {
    Preconditions.checkNotNull(paramString);
    return doWrite(new zzj(this, new zzab(paramString, paramInt)));
  }

  public Task<byte[]> retrieveData(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    return doRead(new zze(this, new zzad(paramString)));
  }

  public Task<Void> sendData(String paramString, byte[] paramArrayOfByte)
  {
    Preconditions.checkNotNull(paramString);
    Preconditions.checkNotNull(paramArrayOfByte);
    return doWrite(new zzd(this, new zzaf(paramString, paramArrayOfByte)));
  }

  public Task<Void> showUserChallenge(String paramString, PendingIntent paramPendingIntent)
  {
    Preconditions.checkNotNull(paramString);
    Preconditions.checkNotNull(paramPendingIntent);
    return doWrite(new zzi(this, new zzah(paramString, paramPendingIntent)));
  }

  private static class zza<T> extends zzs
  {
    private AccountTransferClient.zzb<T> zzav;

    public zza(AccountTransferClient.zzb<T> paramzzb)
    {
      this.zzav = paramzzb;
    }

    public final void onFailure(Status paramStatus)
    {
      this.zzav.zza(paramStatus);
    }
  }

  private static abstract class zzb<T> extends TaskApiCall<zzu, T>
  {
    private TaskCompletionSource<T> zzaw;

    protected final void setResult(T paramT)
    {
      this.zzaw.setResult(paramT);
    }

    protected final void zza(Status paramStatus)
    {
      AccountTransferClient.zzb(this.zzaw, paramStatus);
    }

    protected abstract void zza(zzz paramzzz)
      throws RemoteException;
  }

  private static abstract class zzc extends AccountTransferClient.zzb<Void>
  {
    zzy zzax = new zzk(this);

    private zzc()
    {
      super();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.api.accounttransfer.AccountTransferClient
 * JD-Core Version:    0.6.2
 */