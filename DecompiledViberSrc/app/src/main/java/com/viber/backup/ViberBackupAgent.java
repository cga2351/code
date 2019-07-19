package com.viber.backup;

import android.app.backup.BackupAgent;
import android.app.backup.BackupDataInput;
import android.app.backup.BackupDataOutput;
import android.content.Context;
import android.os.ParcelFileDescriptor;
import android.provider.Settings.Secure;
import android.support.v4.util.ArrayMap;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.registration.s;
import com.viber.voip.settings.d.ar;
import java.util.Collection;
import java.util.Iterator;

public class ViberBackupAgent extends BackupAgent
{
  private static final Logger a = ViberEnv.getLogger();
  private ArrayMap<String, a> b = new ArrayMap();

  private void a()
  {
    String str = Settings.Secure.getString(getApplicationContext().getContentResolver(), "android_id");
    e locale = new e(getApplicationContext(), str);
    this.b.put(locale.b(), locale);
    f localf = new f();
    this.b.put(localf.b(), localf);
    b localb = new b(getApplicationContext());
    this.b.put(localb.b(), localb);
  }

  private void a(BackupDataInput paramBackupDataInput, a parama)
  {
    try
    {
      int i = paramBackupDataInput.getDataSize();
      byte[] arrayOfByte = new byte[i];
      paramBackupDataInput.readEntityData(arrayOfByte, 0, i);
      parama.a(arrayOfByte);
      return;
    }
    catch (Exception localException)
    {
      while (!(parama instanceof e));
      d.ar.b.a(3);
    }
  }

  private void a(BackupDataInput paramBackupDataInput, d paramd)
  {
    try
    {
      int i = paramBackupDataInput.getDataSize();
      byte[] arrayOfByte = new byte[i];
      paramBackupDataInput.readEntityData(arrayOfByte, 0, i);
      paramd.a(paramBackupDataInput.getKey(), new String(arrayOfByte));
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void onBackup(ParcelFileDescriptor paramParcelFileDescriptor1, BackupDataOutput paramBackupDataOutput, ParcelFileDescriptor paramParcelFileDescriptor2)
  {
    Iterator localIterator = this.b.values().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      try
      {
        String str = locala.b();
        byte[] arrayOfByte = locala.a();
        if (arrayOfByte != null)
        {
          paramBackupDataOutput.writeEntityHeader(str, arrayOfByte.length);
          paramBackupDataOutput.writeEntityData(arrayOfByte, arrayOfByte.length);
        }
      }
      catch (Exception localException)
      {
      }
    }
  }

  public void onCreate()
  {
    a();
  }

  public void onRestore(BackupDataInput paramBackupDataInput, int paramInt, ParcelFileDescriptor paramParcelFileDescriptor)
  {
    d locald = new d(getApplicationContext(), new com.google.d.f());
    while (true)
    {
      try
      {
        if (paramBackupDataInput.readNextHeader())
        {
          a locala = (a)this.b.get(paramBackupDataInput.getKey());
          if (locala == null)
            break label106;
          a(paramBackupDataInput, locala);
          continue;
        }
      }
      catch (Exception localException)
      {
        if (s.e() != s.c)
          ((b)this.b.get("default_keychain")).c();
        if (s.e() == s.c)
          d.ar.b.a(0);
        locald.a();
        return;
      }
      label106: a(paramBackupDataInput, locald);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.backup.ViberBackupAgent
 * JD-Core Version:    0.6.2
 */