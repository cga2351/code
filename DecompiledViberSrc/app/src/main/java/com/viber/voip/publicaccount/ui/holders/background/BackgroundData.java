package com.viber.voip.publicaccount.ui.holders.background;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.viber.voip.backgrounds.b;
import com.viber.voip.backgrounds.m;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.publicaccount.entity.PublicAccount.Background;
import com.viber.voip.publicaccount.ui.holders.PublicAccountEditUIHolder.HolderData;
import com.viber.voip.util.da;

class BackgroundData
  implements PublicAccountEditUIHolder.HolderData
{
  public static final Parcelable.Creator<BackgroundData> CREATOR = new Parcelable.Creator()
  {
    public BackgroundData a(Parcel paramAnonymousParcel)
    {
      return new BackgroundData(paramAnonymousParcel);
    }

    public BackgroundData[] a(int paramAnonymousInt)
    {
      return new BackgroundData[paramAnonymousInt];
    }
  };
  String mBackgroundId;
  Uri mBackgroundUri;
  long mConversationId;
  boolean mIsBackgroundTile;
  Uri mNonProcessedBackgroundUri;

  public BackgroundData()
  {
  }

  protected BackgroundData(Parcel paramParcel)
  {
    this.mConversationId = paramParcel.readLong();
    this.mBackgroundUri = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
    this.mNonProcessedBackgroundUri = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
    this.mBackgroundId = paramParcel.readString();
    if (paramParcel.readByte() != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.mIsBackgroundTile = bool;
      return;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public void fill(PublicAccount paramPublicAccount)
  {
    String str;
    PublicAccount.Background localBackground;
    Pair localPair;
    if (this.mBackgroundUri != null)
    {
      str = this.mBackgroundUri.toString();
      localBackground = new PublicAccount.Background(this.mBackgroundId, str);
      if (!da.a(this.mBackgroundId))
      {
        localPair = m.e(this.mBackgroundId);
        if (((Integer)localPair.first).intValue() < 0)
          break label94;
      }
    }
    label94: for (int i = ((Integer)localPair.first).intValue(); ; i = 0)
    {
      localBackground.setObjectId(b.c(i));
      paramPublicAccount.setBackground(localBackground);
      return;
      str = null;
      break;
    }
  }

  public void init(PublicAccount paramPublicAccount)
  {
    this.mConversationId = paramPublicAccount.getConversationId();
    PublicAccount.Background localBackground = paramPublicAccount.getBackground();
    this.mBackgroundId = localBackground.getId();
    if (!da.a(localBackground.getUri()));
    for (this.mBackgroundUri = Uri.parse(localBackground.getUri()); ; this.mBackgroundUri = null)
    {
      this.mNonProcessedBackgroundUri = null;
      return;
    }
  }

  public void setCustomBackground(Uri paramUri)
  {
    this.mBackgroundId = null;
    this.mIsBackgroundTile = false;
    this.mBackgroundUri = paramUri;
    this.mNonProcessedBackgroundUri = null;
  }

  public void setDefaultBackground(int paramInt, boolean paramBoolean)
  {
    this.mBackgroundId = Integer.toString(paramInt);
    this.mIsBackgroundTile = paramBoolean;
    this.mBackgroundUri = null;
    this.mNonProcessedBackgroundUri = null;
  }

  public void setNonProcessedCustomBackground(Uri paramUri)
  {
    this.mBackgroundId = null;
    this.mIsBackgroundTile = false;
    this.mBackgroundUri = null;
    this.mNonProcessedBackgroundUri = paramUri;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.mConversationId);
    paramParcel.writeParcelable(this.mBackgroundUri, paramInt);
    paramParcel.writeParcelable(this.mNonProcessedBackgroundUri, paramInt);
    paramParcel.writeString(this.mBackgroundId);
    if (this.mIsBackgroundTile);
    for (byte b = 1; ; b = 0)
    {
      paramParcel.writeByte(b);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.background.BackgroundData
 * JD-Core Version:    0.6.2
 */