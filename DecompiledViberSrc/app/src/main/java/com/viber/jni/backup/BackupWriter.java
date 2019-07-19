package com.viber.jni.backup;

public class BackupWriter
{
  protected static native BackupResult nativeCreate(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2);

  protected static native void nativeDestroy(long paramLong);

  protected static native boolean nativeExportGroupMessagesBulk(long paramLong, MessageBackupEntity[] paramArrayOfMessageBackupEntity);

  protected static native boolean nativeExportMessagesBulk(long paramLong, MessageBackupEntity[] paramArrayOfMessageBackupEntity);

  protected static native boolean nativeFinishExport(long paramLong);

  protected static native boolean nativeStartExportGroupMessages(long paramLong);

  protected static native boolean nativeStartExportMessages(long paramLong);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.backup.BackupWriter
 * JD-Core Version:    0.6.2
 */