package com.google.android.gms.ads.formats;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.internal.ads.zzafz;
import com.google.android.gms.internal.ads.zzaga;
import com.google.android.gms.internal.ads.zzare;
import com.google.android.gms.internal.ads.zzyd;
import com.google.android.gms.internal.ads.zzzq;
import com.google.android.gms.internal.ads.zzzr;

@zzare
@SafeParcelable.Class(creator="PublisherAdViewOptionsCreator")
public final class PublisherAdViewOptions extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<PublisherAdViewOptions> CREATOR = new zzc();

  @SafeParcelable.Field(getter="getManualImpressionsEnabled", id=1)
  private final boolean zzbqn;

  @SafeParcelable.Field(getter="getAppEventListenerBinder", id=2, type="android.os.IBinder")
  private final zzzq zzbqo;
  private AppEventListener zzbqp;

  @SafeParcelable.Field(getter="getDelayedBannerAdListenerBinder", id=3)
  private final IBinder zzbqq;

  private PublisherAdViewOptions(Builder paramBuilder)
  {
    this.zzbqn = Builder.zza(paramBuilder);
    this.zzbqp = Builder.zzb(paramBuilder);
    if (this.zzbqp != null);
    for (zzyd localzzyd = new zzyd(this.zzbqp); ; localzzyd = null)
    {
      this.zzbqo = localzzyd;
      this.zzbqq = null;
      return;
    }
  }

  @SafeParcelable.Constructor
  PublisherAdViewOptions(@SafeParcelable.Param(id=1) boolean paramBoolean, @SafeParcelable.Param(id=2) IBinder paramIBinder1, @SafeParcelable.Param(id=3) IBinder paramIBinder2)
  {
    this.zzbqn = paramBoolean;
    if (paramIBinder1 != null);
    for (zzzq localzzzq = zzzr.zzd(paramIBinder1); ; localzzzq = null)
    {
      this.zzbqo = localzzzq;
      this.zzbqq = paramIBinder2;
      return;
    }
  }

  public final AppEventListener getAppEventListener()
  {
    return this.zzbqp;
  }

  public final boolean getManualImpressionsEnabled()
  {
    return this.zzbqn;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeBoolean(paramParcel, 1, getManualImpressionsEnabled());
    if (this.zzbqo == null);
    for (IBinder localIBinder = null; ; localIBinder = this.zzbqo.asBinder())
    {
      SafeParcelWriter.writeIBinder(paramParcel, 2, localIBinder, false);
      SafeParcelWriter.writeIBinder(paramParcel, 3, this.zzbqq, false);
      SafeParcelWriter.finishObjectHeader(paramParcel, i);
      return;
    }
  }

  public final zzzq zzkt()
  {
    return this.zzbqo;
  }

  public final zzafz zzku()
  {
    return zzaga.zzu(this.zzbqq);
  }

  public static final class Builder
  {
    private boolean zzbqn = false;
    private AppEventListener zzbqp;

    public final PublisherAdViewOptions build()
    {
      return new PublisherAdViewOptions(this, null);
    }

    public final Builder setAppEventListener(AppEventListener paramAppEventListener)
    {
      this.zzbqp = paramAppEventListener;
      return this;
    }

    public final Builder setManualImpressionsEnabled(boolean paramBoolean)
    {
      this.zzbqn = paramBoolean;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.formats.PublisherAdViewOptions
 * JD-Core Version:    0.6.2
 */