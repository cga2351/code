package com.viber.voip.contacts.c.e;

import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import com.viber.dexshared.Logger;
import com.viber.provider.contacts.a.a;
import com.viber.voip.ViberEnv;
import com.viber.voip.memberid.Member;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class a
{
  private static final Logger a = ViberEnv.getLogger();
  private ContentResolver b;

  public a(Context paramContext)
  {
    this.b = paramContext.getContentResolver();
  }

  // ERROR //
  public android.util.Pair<java.util.HashSet<Member>, com.viber.jni.BlockListInfo[]> a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 35	java/util/HashSet
    //   5: dup
    //   6: invokespecial 36	java/util/HashSet:<init>	()V
    //   9: astore_2
    //   10: new 35	java/util/HashSet
    //   13: dup
    //   14: invokespecial 36	java/util/HashSet:<init>	()V
    //   17: astore_3
    //   18: bipush 6
    //   20: anewarray 38	java/lang/String
    //   23: dup
    //   24: iconst_0
    //   25: ldc 40
    //   27: aastore
    //   28: dup
    //   29: iconst_1
    //   30: ldc 42
    //   32: aastore
    //   33: dup
    //   34: iconst_2
    //   35: ldc 44
    //   37: aastore
    //   38: dup
    //   39: iconst_3
    //   40: ldc 46
    //   42: aastore
    //   43: dup
    //   44: iconst_4
    //   45: ldc 48
    //   47: aastore
    //   48: dup
    //   49: iconst_5
    //   50: ldc 50
    //   52: aastore
    //   53: astore 4
    //   55: aload_0
    //   56: getfield 30	com/viber/voip/contacts/c/e/a:b	Landroid/content/ContentResolver;
    //   59: getstatic 56	com/viber/provider/contacts/a$a:c	Landroid/net/Uri;
    //   62: aload 4
    //   64: aconst_null
    //   65: aconst_null
    //   66: aconst_null
    //   67: invokevirtual 62	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   70: astore 8
    //   72: aload 8
    //   74: astore_1
    //   75: aload_1
    //   76: ifnull +104 -> 180
    //   79: aload_1
    //   80: invokeinterface 68 1 0
    //   85: ifeq +95 -> 180
    //   88: aload_1
    //   89: iconst_0
    //   90: invokeinterface 72 2 0
    //   95: astore 10
    //   97: aload_1
    //   98: iconst_1
    //   99: invokeinterface 76 2 0
    //   104: istore 11
    //   106: aload_2
    //   107: new 78	com/viber/voip/memberid/Member
    //   110: dup
    //   111: aload 10
    //   113: aload_1
    //   114: iconst_2
    //   115: invokeinterface 72 2 0
    //   120: aload_1
    //   121: iconst_3
    //   122: invokeinterface 72 2 0
    //   127: invokestatic 83	com/viber/voip/util/dx:a	(Ljava/lang/String;)Landroid/net/Uri;
    //   130: aload_1
    //   131: iconst_4
    //   132: invokeinterface 72 2 0
    //   137: aload_1
    //   138: iconst_5
    //   139: invokeinterface 72 2 0
    //   144: invokespecial 86	com/viber/voip/memberid/Member:<init>	(Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;)V
    //   147: invokevirtual 90	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   150: pop
    //   151: aload_3
    //   152: new 92	com/viber/jni/BlockListInfo
    //   155: dup
    //   156: aload 10
    //   158: iload 11
    //   160: invokespecial 95	com/viber/jni/BlockListInfo:<init>	(Ljava/lang/String;I)V
    //   163: invokevirtual 90	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   166: pop
    //   167: aload_1
    //   168: invokeinterface 98 1 0
    //   173: istore 14
    //   175: iload 14
    //   177: ifne -89 -> 88
    //   180: aload_1
    //   181: ifnull +7 -> 188
    //   184: aload_1
    //   185: invokestatic 103	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   188: new 105	android/util/Pair
    //   191: dup
    //   192: aload_2
    //   193: aload_3
    //   194: aload_3
    //   195: invokevirtual 109	java/util/HashSet:size	()I
    //   198: anewarray 92	com/viber/jni/BlockListInfo
    //   201: invokevirtual 113	java/util/HashSet:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   204: invokespecial 116	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   207: areturn
    //   208: astore 6
    //   210: aconst_null
    //   211: astore 7
    //   213: aload 7
    //   215: ifnull -27 -> 188
    //   218: aload 7
    //   220: invokestatic 103	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   223: goto -35 -> 188
    //   226: astore 5
    //   228: aload_1
    //   229: ifnull +7 -> 236
    //   232: aload_1
    //   233: invokestatic 103	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   236: aload 5
    //   238: athrow
    //   239: astore 9
    //   241: aload_1
    //   242: astore 7
    //   244: goto -31 -> 213
    //
    // Exception table:
    //   from	to	target	type
    //   55	72	208	org/sqlite/database/sqlite/SQLiteException
    //   55	72	226	finally
    //   79	88	226	finally
    //   88	175	226	finally
    //   79	88	239	org/sqlite/database/sqlite/SQLiteException
    //   88	175	239	org/sqlite/database/sqlite/SQLiteException
  }

  public void a(Set<Member> paramSet)
  {
    Iterator localIterator = paramSet.iterator();
    StringBuilder localStringBuilder = new StringBuilder();
    String[] arrayOfString = new String[paramSet.size()];
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      if (localStringBuilder.length() != 0)
        localStringBuilder.append(" OR ");
      localStringBuilder.append("canonized_number=?");
      j = i + 1;
      arrayOfString[i] = ((Member)localIterator.next()).getId();
    }
    this.b.delete(a.a.a, localStringBuilder.toString(), arrayOfString);
  }

  public void a(Set<Member> paramSet, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramSet.iterator();
    if (localIterator.hasNext())
    {
      ContentValues localContentValues = new ContentValues(3);
      localContentValues.put("canonized_number", ((Member)localIterator.next()).getId());
      localContentValues.put("blocked_date", Long.valueOf(System.currentTimeMillis()));
      if (paramBoolean);
      for (int i = 1; ; i = 0)
      {
        localContentValues.put("block_reason", Integer.valueOf(i));
        localArrayList.add(ContentProviderOperation.newInsert(a.a.a).withValues(localContentValues).build());
        break;
      }
    }
    try
    {
      this.b.applyBatch("com.viber.voip.provider.vibercontacts", localArrayList);
      return;
    }
    catch (OperationApplicationException localOperationApplicationException)
    {
    }
    catch (RemoteException localRemoteException)
    {
    }
  }

  public void b()
  {
    this.b.delete(a.a.a, null, null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.c.e.a
 * JD-Core Version:    0.6.2
 */