package com.viber.voip.apps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AuthInfo
  implements Parcelable
{
  public static final Parcelable.Creator<AuthInfo> CREATOR = new Parcelable.Creator()
  {
    public AuthInfo a(Parcel paramAnonymousParcel)
    {
      return new AuthInfo(paramAnonymousParcel);
    }

    public AuthInfo[] a(int paramAnonymousInt)
    {
      return new AuthInfo[paramAnonymousInt];
    }
  };
  private int mAppId;
  private int mAuthType = 0;
  private String mAutoSubscribeBotUri;
  private String mIdentifier;
  private boolean mNeedConfirmation;
  private int mScope;

  public AuthInfo()
  {
  }

  AuthInfo(Parcel paramParcel)
  {
    this.mAuthType = paramParcel.readInt();
    this.mAppId = paramParcel.readInt();
    this.mScope = paramParcel.readInt();
    this.mIdentifier = paramParcel.readString();
    int i = paramParcel.readInt();
    boolean bool = false;
    if (i != 0)
      bool = true;
    this.mNeedConfirmation = bool;
    this.mAutoSubscribeBotUri = paramParcel.readString();
  }

  public int describeContents()
  {
    return 0;
  }

  public int getAppId()
  {
    return this.mAppId;
  }

  public int getAuthType()
  {
    return this.mAuthType;
  }

  public String getAutoSubscribeBotUri()
  {
    return this.mAutoSubscribeBotUri;
  }

  public String getIdentifier()
  {
    return this.mIdentifier;
  }

  public int getScope()
  {
    return this.mScope;
  }

  public boolean isNeedConfirmation()
  {
    return this.mNeedConfirmation;
  }

  public void setAppId(int paramInt)
  {
    this.mAppId = paramInt;
  }

  public void setAuthType(int paramInt)
  {
    this.mAuthType = paramInt;
  }

  public void setAutoSubscribeBotUri(String paramString)
  {
    this.mAutoSubscribeBotUri = paramString;
  }

  public void setIdentifier(String paramString)
  {
    this.mIdentifier = paramString;
  }

  public void setNeedConfirmation(boolean paramBoolean)
  {
    this.mNeedConfirmation = paramBoolean;
  }

  public void setScope(int paramInt)
  {
    this.mScope = paramInt;
  }

  public String toString()
  {
    return "AuthInfo{authType=" + this.mAuthType + ", appId=" + this.mAppId + ", scope=" + this.mScope + ", identifier='" + this.mIdentifier + '\'' + ", confirm=" + this.mNeedConfirmation + ", autosubscribeTo='" + this.mAutoSubscribeBotUri + '\'' + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mAuthType);
    paramParcel.writeInt(this.mAppId);
    paramParcel.writeInt(this.mScope);
    paramParcel.writeString(this.mIdentifier);
    if (this.mNeedConfirmation);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeInt(i);
      paramParcel.writeString(this.mAutoSubscribeBotUri);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.apps.model.AuthInfo
 * JD-Core Version:    0.6.2
 */