package com.viber.voip.backup.d;

import com.viber.jni.backup.BackupResult;
import com.viber.jni.backup.BackupResult.ErrorCode;
import com.viber.jni.backup.BackupWriter;
import com.viber.jni.backup.GroupMessageBackupEntity;
import com.viber.jni.backup.MessageBackupEntity;
import com.viber.voip.backup.c.d;
import com.viber.voip.backup.m;

public class e extends BackupWriter
  implements m
{
  private long a;

  public e(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
    throws d
  {
    BackupResult localBackupResult = nativeCreate(paramString1, paramString2, paramBoolean1, paramBoolean2);
    BackupResult.ErrorCode localErrorCode = BackupResult.ErrorCode.fromInt(localBackupResult.errorCode);
    if (localErrorCode != BackupResult.ErrorCode.NoError)
      throw new d("Failed creating backup. Error:" + localErrorCode, localErrorCode);
    this.a = localBackupResult.handle;
  }

  public void a()
  {
    if (this.a != 0L)
    {
      nativeDestroy(this.a);
      this.a = 0L;
    }
  }

  public void a(GroupMessageBackupEntity[] paramArrayOfGroupMessageBackupEntity)
    throws d
  {
    if (!nativeExportGroupMessagesBulk(this.a, paramArrayOfGroupMessageBackupEntity))
      throw new d("addGroupMessages failed");
  }

  public void a(MessageBackupEntity[] paramArrayOfMessageBackupEntity)
    throws d
  {
    if (!nativeExportMessagesBulk(this.a, paramArrayOfMessageBackupEntity))
      throw new d("addMessages failed");
  }

  public void b()
    throws d
  {
    if (!nativeStartExportMessages(this.a))
      throw new d("startMessages failed");
  }

  public void c()
    throws d
  {
    if (!nativeStartExportGroupMessages(this.a))
      throw new d("startGroupMessages failed");
  }

  public void d()
    throws d
  {
    boolean bool = nativeFinishExport(this.a);
    a();
    if (!bool)
      throw new d("finishExport failed");
  }

  public void finalize()
    throws Throwable
  {
    a();
    super.finalize();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.d.e
 * JD-Core Version:    0.6.2
 */