package com.viber.voip.messages.ui.forward;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.messages.forward.GroupReferralForwardInfo;
import com.viber.voip.mvp.core.State;

public class ForwardPresenterState extends State
{
  public static final Parcelable.Creator<ForwardPresenterState> CREATOR = new Parcelable.Creator()
  {
    public ForwardPresenterState a(Parcel paramAnonymousParcel)
    {
      return new ForwardPresenterState(paramAnonymousParcel);
    }

    public ForwardPresenterState[] a(int paramAnonymousInt)
    {
      return new ForwardPresenterState[paramAnonymousInt];
    }
  };
  private final boolean mGroupLinkRequestFinished;
  private final GroupReferralForwardInfo mGroupReferralForwardInfo;
  private final Intent mPendingForwardIntent;

  protected ForwardPresenterState(Parcel paramParcel)
  {
    super(paramParcel);
    this.mGroupReferralForwardInfo = ((GroupReferralForwardInfo)paramParcel.readParcelable(GroupReferralForwardInfo.class.getClassLoader()));
    if (paramParcel.readByte() != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.mGroupLinkRequestFinished = bool;
      this.mPendingForwardIntent = ((Intent)paramParcel.readParcelable(Intent.class.getClassLoader()));
      return;
    }
  }

  public ForwardPresenterState(GroupReferralForwardInfo paramGroupReferralForwardInfo, boolean paramBoolean, Intent paramIntent)
  {
    this.mGroupReferralForwardInfo = paramGroupReferralForwardInfo;
    this.mGroupLinkRequestFinished = paramBoolean;
    this.mPendingForwardIntent = paramIntent;
  }

  public int describeContents()
  {
    return 0;
  }

  public GroupReferralForwardInfo getGroupReferralForwardInfo()
  {
    return this.mGroupReferralForwardInfo;
  }

  public Intent getPendingForwardIntent()
  {
    return this.mPendingForwardIntent;
  }

  public boolean isGroupLinkRequestFinished()
  {
    return this.mGroupLinkRequestFinished;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.mGroupReferralForwardInfo, paramInt);
    if (this.mGroupLinkRequestFinished);
    for (byte b = 1; ; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeParcelable(this.mPendingForwardIntent, paramInt);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.forward.ForwardPresenterState
 * JD-Core Version:    0.6.2
 */