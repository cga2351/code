package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public class OneoffTask extends Task
{
  public static final Parcelable.Creator<OneoffTask> CREATOR = new zzi();
  private final long zzal;
  private final long zzam;

  @Deprecated
  private OneoffTask(Parcel paramParcel)
  {
    super(paramParcel);
    this.zzal = paramParcel.readLong();
    this.zzam = paramParcel.readLong();
  }

  private OneoffTask(Builder paramBuilder)
  {
    super(paramBuilder);
    this.zzal = Builder.zzd(paramBuilder);
    this.zzam = Builder.zze(paramBuilder);
  }

  public long getWindowEnd()
  {
    return this.zzam;
  }

  public long getWindowStart()
  {
    return this.zzal;
  }

  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putLong("window_start", this.zzal);
    paramBundle.putLong("window_end", this.zzam);
  }

  public String toString()
  {
    String str = super.toString();
    long l1 = getWindowStart();
    long l2 = getWindowEnd();
    return 64 + String.valueOf(str).length() + str + " windowStart=" + l1 + " windowEnd=" + l2;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeLong(this.zzal);
    paramParcel.writeLong(this.zzam);
  }

  public static class Builder extends Task.Builder
  {
    private long zzal = -1L;
    private long zzam = -1L;

    public Builder()
    {
      this.isPersisted = false;
    }

    public OneoffTask build()
    {
      checkConditions();
      return new OneoffTask(this, null);
    }

    protected void checkConditions()
    {
      super.checkConditions();
      if ((this.zzal == -1L) || (this.zzam == -1L))
        throw new IllegalArgumentException("Must specify an execution window using setExecutionWindow.");
      if (this.zzal >= this.zzam)
        throw new IllegalArgumentException("Window start must be shorter than window end.");
    }

    public Builder setExecutionWindow(long paramLong1, long paramLong2)
    {
      this.zzal = paramLong1;
      this.zzam = paramLong2;
      return this;
    }

    public Builder setExtras(Bundle paramBundle)
    {
      this.extras = paramBundle;
      return this;
    }

    public Builder setPersisted(boolean paramBoolean)
    {
      this.isPersisted = paramBoolean;
      return this;
    }

    public Builder setRequiredNetwork(int paramInt)
    {
      this.requiredNetworkState = paramInt;
      return this;
    }

    public Builder setRequiresCharging(boolean paramBoolean)
    {
      this.requiresCharging = paramBoolean;
      return this;
    }

    public Builder setService(Class<? extends GcmTaskService> paramClass)
    {
      this.gcmTaskService = paramClass.getName();
      return this;
    }

    public Builder setTag(String paramString)
    {
      this.tag = paramString;
      return this;
    }

    public Builder setUpdateCurrent(boolean paramBoolean)
    {
      this.updateCurrent = paramBoolean;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.gcm.OneoffTask
 * JD-Core Version:    0.6.2
 */