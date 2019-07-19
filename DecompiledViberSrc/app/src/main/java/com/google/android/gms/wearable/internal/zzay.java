package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.Channel.GetInputStreamResult;
import com.google.android.gms.wearable.Channel.GetOutputStreamResult;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.ChannelClient.Channel;

@SafeParcelable.Class(creator="ChannelImplCreator")
@SafeParcelable.Reserved({1})
public final class zzay extends AbstractSafeParcelable
  implements Channel, ChannelClient.Channel
{
  public static final Parcelable.Creator<zzay> CREATOR = new zzbi();

  @SafeParcelable.Field(getter="getToken", id=2)
  private final String zzce;

  @SafeParcelable.Field(getter="getPath", id=4)
  private final String zzcl;

  @SafeParcelable.Field(getter="getNodeId", id=3)
  private final String zzo;

  @SafeParcelable.Constructor
  public zzay(@SafeParcelable.Param(id=2) String paramString1, @SafeParcelable.Param(id=3) String paramString2, @SafeParcelable.Param(id=4) String paramString3)
  {
    this.zzce = ((String)Preconditions.checkNotNull(paramString1));
    this.zzo = ((String)Preconditions.checkNotNull(paramString2));
    this.zzcl = ((String)Preconditions.checkNotNull(paramString3));
  }

  public final PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, ChannelApi.ChannelListener paramChannelListener)
  {
    IntentFilter[] arrayOfIntentFilter = new IntentFilter[1];
    arrayOfIntentFilter[0] = zzgj.zzc("com.google.android.gms.wearable.CHANNEL_EVENT");
    return zzb.zza(paramGoogleApiClient, new zzbf(this.zzce, arrayOfIntentFilter), paramChannelListener);
  }

  public final PendingResult<Status> close(GoogleApiClient paramGoogleApiClient)
  {
    return paramGoogleApiClient.enqueue(new zzaz(this, paramGoogleApiClient));
  }

  public final PendingResult<Status> close(GoogleApiClient paramGoogleApiClient, int paramInt)
  {
    return paramGoogleApiClient.enqueue(new zzba(this, paramGoogleApiClient, paramInt));
  }

  public final boolean equals(Object paramObject)
  {
    if (paramObject == this);
    zzay localzzay;
    do
    {
      return true;
      if (!(paramObject instanceof zzay))
        return false;
      localzzay = (zzay)paramObject;
    }
    while ((this.zzce.equals(localzzay.zzce)) && (Objects.equal(localzzay.zzo, this.zzo)) && (Objects.equal(localzzay.zzcl, this.zzcl)));
    return false;
  }

  public final PendingResult<Channel.GetInputStreamResult> getInputStream(GoogleApiClient paramGoogleApiClient)
  {
    return paramGoogleApiClient.enqueue(new zzbb(this, paramGoogleApiClient));
  }

  public final String getNodeId()
  {
    return this.zzo;
  }

  public final PendingResult<Channel.GetOutputStreamResult> getOutputStream(GoogleApiClient paramGoogleApiClient)
  {
    return paramGoogleApiClient.enqueue(new zzbc(this, paramGoogleApiClient));
  }

  public final String getPath()
  {
    return this.zzcl;
  }

  public final int hashCode()
  {
    return this.zzce.hashCode();
  }

  public final PendingResult<Status> receiveFile(GoogleApiClient paramGoogleApiClient, Uri paramUri, boolean paramBoolean)
  {
    Preconditions.checkNotNull(paramGoogleApiClient, "client is null");
    Preconditions.checkNotNull(paramUri, "uri is null");
    return paramGoogleApiClient.enqueue(new zzbd(this, paramGoogleApiClient, paramUri, paramBoolean));
  }

  public final PendingResult<Status> removeListener(GoogleApiClient paramGoogleApiClient, ChannelApi.ChannelListener paramChannelListener)
  {
    Preconditions.checkNotNull(paramGoogleApiClient, "client is null");
    Preconditions.checkNotNull(paramChannelListener, "listener is null");
    return paramGoogleApiClient.enqueue(new zzan(paramGoogleApiClient, paramChannelListener, this.zzce));
  }

  public final PendingResult<Status> sendFile(GoogleApiClient paramGoogleApiClient, Uri paramUri)
  {
    return sendFile(paramGoogleApiClient, paramUri, 0L, -1L);
  }

  public final PendingResult<Status> sendFile(GoogleApiClient paramGoogleApiClient, Uri paramUri, long paramLong1, long paramLong2)
  {
    Preconditions.checkNotNull(paramGoogleApiClient, "client is null");
    Preconditions.checkNotNull(this.zzce, "token is null");
    Preconditions.checkNotNull(paramUri, "uri is null");
    boolean bool1;
    if (paramLong1 >= 0L)
    {
      bool1 = true;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Long.valueOf(paramLong1);
      Preconditions.checkArgument(bool1, "startOffset is negative: %s", arrayOfObject1);
      if ((paramLong2 < 0L) && (paramLong2 != -1L))
        break label123;
    }
    label123: for (boolean bool2 = true; ; bool2 = false)
    {
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Long.valueOf(paramLong2);
      Preconditions.checkArgument(bool2, "invalid length: %s", arrayOfObject2);
      return paramGoogleApiClient.enqueue(new zzbe(this, paramGoogleApiClient, paramUri, paramLong1, paramLong2));
      bool1 = false;
      break;
    }
  }

  public final String toString()
  {
    char[] arrayOfChar = this.zzce.toCharArray();
    int i = arrayOfChar.length;
    int j = 0;
    int k = 0;
    while (j < i)
    {
      k += arrayOfChar[j];
      j++;
    }
    String str1 = this.zzce.trim();
    int m = str1.length();
    if (m > 25)
    {
      String str4 = str1.substring(0, 10);
      String str5 = str1.substring(m - 10, m);
      str1 = 16 + String.valueOf(str4).length() + String.valueOf(str5).length() + str4 + "..." + str5 + "::" + k;
    }
    String str2 = this.zzo;
    String str3 = this.zzcl;
    return 31 + String.valueOf(str1).length() + String.valueOf(str2).length() + String.valueOf(str3).length() + "Channel{token=" + str1 + ", nodeId=" + str2 + ", path=" + str3 + "}";
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 2, this.zzce, false);
    SafeParcelWriter.writeString(paramParcel, 3, getNodeId(), false);
    SafeParcelWriter.writeString(paramParcel, 4, getPath(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }

  public final String zzc()
  {
    return this.zzce;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzay
 * JD-Core Version:    0.6.2
 */