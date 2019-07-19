package com.viber.voip.backup.a;

import android.content.Context;
import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.backup.BackupInfo;
import java.io.IOException;

public abstract class e<COMMON_DATA, BACKUP_INFO extends BackupInfo> extends c<COMMON_DATA, BACKUP_INFO>
{
  protected static final Logger f = ViberEnv.getLogger();

  public e(Context paramContext, b<COMMON_DATA> paramb, Handler paramHandler)
  {
    super(paramContext, paramb, paramHandler);
  }

  protected abstract com.google.a.b.a.a.b a(com.viber.voip.backup.b.b paramb, a<COMMON_DATA> parama)
    throws IOException, com.viber.voip.k.b;

  protected void a(BACKUP_INFO paramBACKUP_INFO)
  {
  }

  // ERROR //
  protected BACKUP_INFO b(a parama)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 37	com/viber/voip/k/c
    //   5: dup
    //   6: invokespecial 39	com/viber/voip/k/c:<init>	()V
    //   9: astore_3
    //   10: new 41	com/viber/voip/backup/b/b
    //   13: dup
    //   14: aload_0
    //   15: getfield 44	com/viber/voip/backup/a/e:a	Landroid/content/Context;
    //   18: aload_3
    //   19: invokespecial 47	com/viber/voip/backup/b/b:<init>	(Landroid/content/Context;Lcom/viber/voip/k/a;)V
    //   22: astore 4
    //   24: aload_1
    //   25: invokevirtual 52	com/viber/voip/backup/a/a:b	()[Lcom/viber/voip/backup/a/a$a;
    //   28: astore 6
    //   30: aload 6
    //   32: arraylength
    //   33: istore 7
    //   35: iconst_0
    //   36: istore 8
    //   38: iload 8
    //   40: iload 7
    //   42: if_icmpge +79 -> 121
    //   45: aload 6
    //   47: iload 8
    //   49: aaload
    //   50: astore 9
    //   52: aload 4
    //   54: aload 9
    //   56: invokevirtual 57	com/viber/voip/backup/a/a$a:a	()Ljava/lang/String;
    //   59: invokevirtual 60	com/viber/voip/backup/b/b:a	(Ljava/lang/String;)V
    //   62: aload_0
    //   63: aload 4
    //   65: aload_1
    //   66: invokevirtual 62	com/viber/voip/backup/a/e:a	(Lcom/viber/voip/backup/b/b;Lcom/viber/voip/backup/a/a;)Lcom/google/a/b/a/a/b;
    //   69: astore 12
    //   71: aload_0
    //   72: aload 9
    //   74: invokevirtual 57	com/viber/voip/backup/a/a$a:a	()Ljava/lang/String;
    //   77: aload 12
    //   79: invokestatic 67	com/viber/voip/backup/l:a	(Lcom/google/a/b/a/a/b;)Lcom/google/a/b/a/a/a;
    //   82: invokevirtual 70	com/viber/voip/backup/a/e:b	(Ljava/lang/String;Lcom/google/a/b/a/a/a;)Lcom/viber/voip/backup/BackupInfo;
    //   85: astore 13
    //   87: aload 13
    //   89: invokevirtual 76	com/viber/voip/backup/BackupInfo:isBackupExists	()Z
    //   92: ifeq +23 -> 115
    //   95: aload_2
    //   96: ifnull +16 -> 112
    //   99: aload 13
    //   101: aload_2
    //   102: invokevirtual 80	com/viber/voip/backup/BackupInfo:isNewer	(Lcom/viber/voip/backup/BackupInfo;)Z
    //   105: istore 14
    //   107: iload 14
    //   109: ifeq +6 -> 115
    //   112: aload 13
    //   114: astore_2
    //   115: iinc 8 1
    //   118: goto -80 -> 38
    //   121: aload_2
    //   122: ifnull +8 -> 130
    //   125: aload_0
    //   126: aload_2
    //   127: invokevirtual 82	com/viber/voip/backup/a/e:a	(Lcom/viber/voip/backup/BackupInfo;)V
    //   130: aload_2
    //   131: areturn
    //   132: astore 5
    //   134: aload_2
    //   135: areturn
    //   136: astore 11
    //   138: goto -23 -> 115
    //   141: astore 10
    //   143: goto -28 -> 115
    //
    // Exception table:
    //   from	to	target	type
    //   2	35	132	java/lang/Throwable
    //   45	62	132	java/lang/Throwable
    //   62	95	132	java/lang/Throwable
    //   99	107	132	java/lang/Throwable
    //   125	130	132	java/lang/Throwable
    //   62	95	136	com/viber/voip/k/b
    //   99	107	136	com/viber/voip/k/b
    //   62	95	141	java/io/IOException
    //   99	107	141	java/io/IOException
  }

  protected abstract BACKUP_INFO b(String paramString, com.google.a.b.a.a.a parama);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.a.e
 * JD-Core Version:    0.6.2
 */