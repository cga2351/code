package com.viber.voip.backup;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.viber.voip.util.da;

public class BackupInfo
  implements Parcelable
{
  public static final Parcelable.Creator<BackupInfo> CREATOR = new Parcelable.Creator()
  {
    public BackupInfo a(Parcel paramAnonymousParcel)
    {
      return new BackupInfo(paramAnonymousParcel);
    }

    public BackupInfo[] a(int paramAnonymousInt)
    {
      return new BackupInfo[paramAnonymousInt];
    }
  };
  private final String mAccount;
  private final String mDriveFileId;
  private final int mMetadataVersion;
  private final long mSize;
  private final long mUpdateTime;

  protected BackupInfo(Parcel paramParcel)
  {
    this.mAccount = paramParcel.readString();
    this.mDriveFileId = paramParcel.readString();
    this.mUpdateTime = paramParcel.readLong();
    this.mSize = paramParcel.readLong();
    this.mMetadataVersion = paramParcel.readInt();
  }

  public BackupInfo(String paramString1, String paramString2, long paramLong1, long paramLong2, int paramInt)
  {
    this.mAccount = paramString1;
    this.mDriveFileId = paramString2;
    this.mUpdateTime = paramLong1;
    this.mSize = paramLong2;
    this.mMetadataVersion = paramInt;
  }

  public int describeContents()
  {
    return 0;
  }

  public String getAccount()
  {
    return this.mAccount;
  }

  public String getDriveFileId()
  {
    return this.mDriveFileId;
  }

  public int getMetaDataVersion()
  {
    return this.mMetadataVersion;
  }

  public long getSize()
  {
    return this.mSize;
  }

  public long getUpdateTime()
  {
    return this.mUpdateTime;
  }

  public boolean isBackupExists()
  {
    return (!da.a(this.mAccount)) && (!da.a(this.mDriveFileId)) && (this.mUpdateTime > 0L) && (this.mSize > 0L);
  }

  public boolean isNewer(BackupInfo paramBackupInfo)
  {
    return this.mUpdateTime > paramBackupInfo.mUpdateTime;
  }

  public String toString()
  {
    return "BackupInfo{mAccount='" + this.mAccount + '\'' + ", mDriveFileId='" + this.mDriveFileId + '\'' + ", mUpdateTime=" + this.mUpdateTime + ", mSize=" + this.mSize + ", mMetadataVersion=" + this.mMetadataVersion + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mAccount);
    paramParcel.writeString(this.mDriveFileId);
    paramParcel.writeLong(this.mUpdateTime);
    paramParcel.writeLong(this.mSize);
    paramParcel.writeInt(this.mMetadataVersion);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.BackupInfo
 * JD-Core Version:    0.6.2
 */