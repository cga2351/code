package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;

@SafeParcelable.Class(creator="ChannelEventParcelableCreator")
@SafeParcelable.Reserved({1})
public final class zzaw extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzaw> CREATOR = new zzax();

  @SafeParcelable.Field(id=3)
  private final int type;

  @SafeParcelable.Field(id=5)
  private final int zzcj;

  @SafeParcelable.Field(id=2)
  private final zzay zzck;

  @SafeParcelable.Field(id=4)
  private final int zzg;

  @SafeParcelable.Constructor
  public zzaw(@SafeParcelable.Param(id=2) zzay paramzzay, @SafeParcelable.Param(id=3) int paramInt1, @SafeParcelable.Param(id=4) int paramInt2, @SafeParcelable.Param(id=5) int paramInt3)
  {
    this.zzck = paramzzay;
    this.type = paramInt1;
    this.zzg = paramInt2;
    this.zzcj = paramInt3;
  }

  public final String toString()
  {
    String str1 = String.valueOf(this.zzck);
    int i = this.type;
    String str2;
    String str3;
    switch (i)
    {
    default:
      str2 = Integer.toString(i);
      int j = this.zzg;
      switch (j)
      {
      default:
        str3 = Integer.toString(j);
      case 1:
      case 2:
      case 3:
      case 0:
      }
      break;
    case 1:
    case 2:
    case 4:
    case 3:
    }
    while (true)
    {
      int k = this.zzcj;
      return 81 + String.valueOf(str1).length() + String.valueOf(str2).length() + String.valueOf(str3).length() + "ChannelEventParcelable[, channel=" + str1 + ", type=" + str2 + ", closeReason=" + str3 + ", appErrorCode=" + k + "]";
      str2 = "CHANNEL_OPENED";
      break;
      str2 = "CHANNEL_CLOSED";
      break;
      str2 = "OUTPUT_CLOSED";
      break;
      str2 = "INPUT_CLOSED";
      break;
      str3 = "CLOSE_REASON_DISCONNECTED";
      continue;
      str3 = "CLOSE_REASON_REMOTE_CLOSE";
      continue;
      str3 = "CLOSE_REASON_LOCAL_CLOSE";
      continue;
      str3 = "CLOSE_REASON_NORMAL";
    }
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 2, this.zzck, paramInt, false);
    SafeParcelWriter.writeInt(paramParcel, 3, this.type);
    SafeParcelWriter.writeInt(paramParcel, 4, this.zzg);
    SafeParcelWriter.writeInt(paramParcel, 5, this.zzcj);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }

  public final void zza(ChannelApi.ChannelListener paramChannelListener)
  {
    switch (this.type)
    {
    default:
      int i = this.type;
      Log.w("ChannelEventParcelable", 25 + "Unknown type: " + i);
      return;
    case 1:
      paramChannelListener.onChannelOpened(this.zzck);
      return;
    case 2:
      paramChannelListener.onChannelClosed(this.zzck, this.zzg, this.zzcj);
      return;
    case 3:
      paramChannelListener.onInputClosed(this.zzck, this.zzg, this.zzcj);
      return;
    case 4:
    }
    paramChannelListener.onOutputClosed(this.zzck, this.zzg, this.zzcj);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.zzaw
 * JD-Core Version:    0.6.2
 */