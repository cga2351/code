package com.viber.voip.backup.g;

import android.content.Context;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

public class b
{
  private static final Logger a = ViberEnv.getLogger();

  private static String a()
  {
    return System.currentTimeMillis() + "_" + "toSecondaryBackup.vbk";
  }

  public a a(Context paramContext, int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("getBackupFileHolder: unknown BackupProcess = " + paramInt);
    case 1:
    case 2:
      return new d(paramContext, ".backupDb", "backup.vbk");
    case 3:
    }
    return new d(paramContext, ".toSecondaryBackupDb", a());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.g.b
 * JD-Core Version:    0.6.2
 */