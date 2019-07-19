package com.viber.jni.backup;

import java.util.ArrayList;

public class BackupReader
{
  protected static native long nativeCreate(String paramString);

  protected static native void nativeDestroy(long paramLong);

  protected static native void nativeGetNextGroupMessagesBulk(long paramLong, ArrayList<GroupMessageBackupEntity> paramArrayList, int paramInt);

  protected static native void nativeGetNextMessagesBulk(long paramLong, ArrayList<MessageBackupEntity> paramArrayList, int paramInt);

  protected static native BackupHeader nativeReadImportHeader(long paramLong);

  protected static native void nativeStartImportingGroupMessages(long paramLong);

  protected static native void nativeStartImportingMessages(long paramLong);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.backup.BackupReader
 * JD-Core Version:    0.6.2
 */