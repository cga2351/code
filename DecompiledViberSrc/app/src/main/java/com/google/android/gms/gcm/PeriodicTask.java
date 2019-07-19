package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public class PeriodicTask extends Task
{
  public static final Parcelable.Creator<PeriodicTask> CREATOR = new zzk();
  protected long mFlexInSeconds = -1L;
  protected long mIntervalInSeconds = -1L;

  @Deprecated
  private PeriodicTask(Parcel paramParcel)
  {
    super(paramParcel);
    this.mIntervalInSeconds = paramParcel.readLong();
    this.mFlexInSeconds = Math.min(paramParcel.readLong(), this.mIntervalInSeconds);
  }

  private PeriodicTask(Builder paramBuilder)
  {
    super(paramBuilder);
    this.mIntervalInSeconds = Builder.zzd(paramBuilder);
    this.mFlexInSeconds = Math.min(Builder.zze(paramBuilder), this.mIntervalInSeconds);
  }

  public long getFlex()
  {
    return this.mFlexInSeconds;
  }

  public long getPeriod()
  {
    return this.mIntervalInSeconds;
  }

  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putLong("period", this.mIntervalInSeconds);
    paramBundle.putLong("period_flex", this.mFlexInSeconds);
  }

  public String toString()
  {
    String str = super.toString();
    long l1 = getPeriod();
    long l2 = getFlex();
    return 54 + String.valueOf(str).length() + str + " period=" + l1 + " flex=" + l2;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeLong(this.mIntervalInSeconds);
    paramParcel.writeLong(this.mFlexInSeconds);
  }

  public static class Builder extends Task.Builder
  {
    private long zzao = -1L;
    private long zzap = -1L;

    public Builder()
    {
      this.isPersisted = true;
    }

    public PeriodicTask build()
    {
      checkConditions();
      return new PeriodicTask(this, null);
    }

    protected void checkConditions()
    {
      super.checkConditions();
      if (this.zzao == -1L)
        throw new IllegalArgumentException("Must call setPeriod(long) to establish an execution interval for this periodic task.");
      if (this.zzao <= 0L)
      {
        long l = this.zzao;
        throw new IllegalArgumentException(66 + "Period set cannot be less than or equal to 0: " + l);
      }
      if (this.zzap == -1L)
        this.zzap = (()(0.1F * (float)this.zzao));
      while (this.zzap <= this.zzao)
        return;
      this.zzap = this.zzao;
    }

    public Builder setExtras(Bundle paramBundle)
    {
      this.extras = paramBundle;
      return this;
    }

    public Builder setFlex(long paramLong)
    {
      this.zzap = paramLong;
      return this;
    }

    public Builder setPeriod(long paramLong)
    {
      this.zzao = paramLong;
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
 * Qualified Name:     com.google.android.gms.gcm.PeriodicTask
 * JD-Core Version:    0.6.2
 */