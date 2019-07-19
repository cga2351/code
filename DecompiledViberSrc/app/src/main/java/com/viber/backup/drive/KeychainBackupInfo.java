package com.viber.backup.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.voip.backup.BackupInfo;

public class KeychainBackupInfo extends BackupInfo
{
  public static final Parcelable.Creator<KeychainBackupInfo> CREATOR = new Parcelable.Creator()
  {
    public KeychainBackupInfo a(Parcel paramAnonymousParcel)
    {
      return new KeychainBackupInfo(paramAnonymousParcel);
    }

    public KeychainBackupInfo[] a(int paramAnonymousInt)
    {
      return new KeychainBackupInfo[paramAnonymousInt];
    }
  };
  private final long mKeychainUpdatedTimeMillis;

  protected KeychainBackupInfo(Parcel paramParcel)
  {
    super(paramParcel);
    this.mKeychainUpdatedTimeMillis = paramParcel.readLong();
  }

  public KeychainBackupInfo(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, int paramInt)
  {
    super(paramString1, paramString2, paramLong1, paramLong3, paramInt);
    this.mKeychainUpdatedTimeMillis = paramLong2;
  }

  public int describeContents()
  {
    return 0;
  }

  public long getKeychainUpdatedTimeMillis()
  {
    return this.mKeychainUpdatedTimeMillis;
  }

  public String toString()
  {
    return "KeychainBackupInfo{base=" + super.toString() + ", mKeychainUpdatedTimeMillis=" + this.mKeychainUpdatedTimeMillis + '}';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeLong(this.mKeychainUpdatedTimeMillis);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.backup.drive.KeychainBackupInfo
 * JD-Core Version:    0.6.2
 */