package com.viber.voip.publicaccount.ui.holders.general.create;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.publicaccount.ui.holders.general.base.GeneralData;
import com.viber.voip.util.da;
import java.util.Locale;

class GeneralCreateData extends GeneralData
{
  public static final Parcelable.Creator<GeneralCreateData> CREATOR = new Parcelable.Creator()
  {
    public GeneralCreateData a(Parcel paramAnonymousParcel)
    {
      return new GeneralCreateData(paramAnonymousParcel);
    }

    public GeneralCreateData[] a(int paramAnonymousInt)
    {
      return new GeneralCreateData[paramAnonymousInt];
    }
  };
  public boolean mIsGroupIdGenerated;
  private int mMaximalIdLength;
  String mPublicGroupIdString;

  public GeneralCreateData()
  {
  }

  protected GeneralCreateData(Parcel paramParcel)
  {
    super(paramParcel);
    this.mPublicGroupIdString = paramParcel.readString();
    if (paramParcel.readByte() != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.mIsGroupIdGenerated = bool;
      this.mMaximalIdLength = paramParcel.readInt();
      return;
    }
  }

  private String createIdFromName(String paramString)
  {
    String str = paramString.toLowerCase(Locale.getDefault()).replaceAll("[^\\w\\-\\.~]", "");
    if (!da.a(str))
    {
      if (str.length() <= this.mMaximalIdLength)
        return str;
      return str.substring(0, this.mMaximalIdLength);
    }
    return null;
  }

  public int describeContents()
  {
    return 0;
  }

  public void fill(PublicAccount paramPublicAccount)
  {
    super.fill(paramPublicAccount);
    paramPublicAccount.setGroupUri(this.mPublicGroupIdString);
  }

  public void init(PublicAccount paramPublicAccount)
  {
    super.init(paramPublicAccount);
    this.mPublicGroupIdString = paramPublicAccount.getGroupUri();
    if ((da.a(this.mPublicGroupIdString)) && (!da.a(paramPublicAccount.getName())))
    {
      this.mPublicGroupIdString = createIdFromName(paramPublicAccount.getName());
      if (da.a(this.mPublicGroupIdString))
        break label63;
    }
    label63: for (boolean bool = true; ; bool = false)
    {
      this.mIsGroupIdGenerated = bool;
      return;
    }
  }

  public void setMaximalIdLength(int paramInt)
  {
    this.mMaximalIdLength = paramInt;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.mPublicGroupIdString);
    if (this.mIsGroupIdGenerated);
    for (byte b = 1; ; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.mMaximalIdLength);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.general.create.GeneralCreateData
 * JD-Core Version:    0.6.2
 */