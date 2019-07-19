package com.viber.common.wear.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.common.wear.CallState;

public class CallStateResult
  implements Parcelable
{
  public static final Parcelable.Creator<CallStateResult> CREATOR = new Parcelable.Creator()
  {
    public CallStateResult a(Parcel paramAnonymousParcel)
    {
      return new CallStateResult(paramAnonymousParcel);
    }

    public CallStateResult[] a(int paramAnonymousInt)
    {
      return new CallStateResult[paramAnonymousInt];
    }
  };
  private long mCallDuration;
  private CallState mCallState;
  private String mDisplayName;

  public CallStateResult()
  {
    this(CallState.IDLE);
  }

  CallStateResult(Parcel paramParcel)
  {
    this.mCallState = CallState.values()[paramParcel.readInt()];
    this.mDisplayName = paramParcel.readString();
    this.mCallDuration = paramParcel.readLong();
  }

  public CallStateResult(CallState paramCallState)
  {
    this.mCallState = paramCallState;
  }

  public int describeContents()
  {
    return 0;
  }

  public long getCallDuration()
  {
    return this.mCallDuration;
  }

  public CallState getCallState()
  {
    return this.mCallState;
  }

  public String getDisplayName()
  {
    return this.mDisplayName;
  }

  public void setCallDuration(long paramLong)
  {
    this.mCallDuration = paramLong;
  }

  public void setCallState(CallState paramCallState)
  {
    if (paramCallState == null)
      throw new NullPointerException("Call state can't be null.");
    this.mCallState = paramCallState;
  }

  public void setDisplayName(String paramString)
  {
    this.mDisplayName = paramString;
  }

  public String toString()
  {
    return "CallStateResult{displayName='" + this.mDisplayName + '\'' + ", callState=" + this.mCallState + ", callDuration=" + this.mCallDuration + "ms" + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mCallState.ordinal());
    paramParcel.writeString(this.mDisplayName);
    paramParcel.writeLong(this.mCallDuration);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.wear.data.CallStateResult
 * JD-Core Version:    0.6.2
 */