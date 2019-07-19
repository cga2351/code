package com.viber.provider.messages.b;

import android.database.Cursor;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.s.a;
import com.viber.voip.util.LongSparseSet;
import com.viber.voip.util.af;
import com.viber.voip.util.u;

class b
{
  private static final Logger a = ViberEnv.getLogger();

  private long a(com.viber.provider.b paramb, String paramString1, String paramString2, String paramString3)
  {
    return paramb.a(paramString1, String.format(paramString2 + " IN (%s)", new Object[] { paramString3 }), null);
  }

  // ERROR //
  private LongSparseSet a(com.viber.provider.b paramb, LongSparseSet paramLongSparseSet, String paramString)
  {
    // Byte code:
    //   0: new 47	com/viber/voip/util/LongSparseSet
    //   3: dup
    //   4: invokespecial 48	com/viber/voip/util/LongSparseSet:<init>	()V
    //   7: astore 4
    //   9: ldc 50
    //   11: iconst_1
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_3
    //   18: aastore
    //   19: invokestatic 39	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   22: astore 5
    //   24: aload_1
    //   25: ldc 52
    //   27: iconst_5
    //   28: anewarray 35	java/lang/String
    //   31: dup
    //   32: iconst_0
    //   33: ldc 54
    //   35: aastore
    //   36: dup
    //   37: iconst_1
    //   38: ldc 56
    //   40: aastore
    //   41: dup
    //   42: iconst_2
    //   43: ldc 58
    //   45: aastore
    //   46: dup
    //   47: iconst_3
    //   48: ldc 60
    //   50: aastore
    //   51: dup
    //   52: iconst_4
    //   53: ldc 62
    //   55: aastore
    //   56: aload 5
    //   58: aconst_null
    //   59: aconst_null
    //   60: aconst_null
    //   61: aconst_null
    //   62: invokeinterface 65 8 0
    //   67: astore 6
    //   69: aload 6
    //   71: invokestatic 71	com/viber/voip/util/af:c	(Landroid/database/Cursor;)Z
    //   74: ifeq +72 -> 146
    //   77: aload_0
    //   78: aload_2
    //   79: aload 4
    //   81: aload 6
    //   83: ldc 54
    //   85: invokespecial 74	com/viber/provider/messages/b/b:a	(Lcom/viber/voip/util/LongSparseSet;Lcom/viber/voip/util/LongSparseSet;Landroid/database/Cursor;Ljava/lang/String;)V
    //   88: aload_0
    //   89: aload_2
    //   90: aload 4
    //   92: aload 6
    //   94: ldc 56
    //   96: invokespecial 74	com/viber/provider/messages/b/b:a	(Lcom/viber/voip/util/LongSparseSet;Lcom/viber/voip/util/LongSparseSet;Landroid/database/Cursor;Ljava/lang/String;)V
    //   99: aload_0
    //   100: aload_2
    //   101: aload 4
    //   103: aload 6
    //   105: ldc 58
    //   107: invokespecial 74	com/viber/provider/messages/b/b:a	(Lcom/viber/voip/util/LongSparseSet;Lcom/viber/voip/util/LongSparseSet;Landroid/database/Cursor;Ljava/lang/String;)V
    //   110: aload_0
    //   111: aload_2
    //   112: aload 4
    //   114: aload 6
    //   116: ldc 60
    //   118: invokespecial 74	com/viber/provider/messages/b/b:a	(Lcom/viber/voip/util/LongSparseSet;Lcom/viber/voip/util/LongSparseSet;Landroid/database/Cursor;Ljava/lang/String;)V
    //   121: aload_0
    //   122: aload_2
    //   123: aload 4
    //   125: aload 6
    //   127: ldc 62
    //   129: invokespecial 74	com/viber/provider/messages/b/b:a	(Lcom/viber/voip/util/LongSparseSet;Lcom/viber/voip/util/LongSparseSet;Landroid/database/Cursor;Ljava/lang/String;)V
    //   132: aload 6
    //   134: invokeinterface 80 1 0
    //   139: istore 8
    //   141: iload 8
    //   143: ifne -66 -> 77
    //   146: aload 6
    //   148: invokestatic 83	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   151: ldc 85
    //   153: iconst_1
    //   154: anewarray 4	java/lang/Object
    //   157: dup
    //   158: iconst_0
    //   159: aload_3
    //   160: aastore
    //   161: invokestatic 39	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   164: astore 9
    //   166: aload_1
    //   167: ldc 87
    //   169: iconst_1
    //   170: anewarray 35	java/lang/String
    //   173: dup
    //   174: iconst_0
    //   175: ldc 89
    //   177: aastore
    //   178: aload 9
    //   180: aconst_null
    //   181: aconst_null
    //   182: aconst_null
    //   183: aconst_null
    //   184: invokeinterface 65 8 0
    //   189: astore 10
    //   191: aload 10
    //   193: invokestatic 71	com/viber/voip/util/af:c	(Landroid/database/Cursor;)Z
    //   196: ifeq +28 -> 224
    //   199: aload_0
    //   200: aload_2
    //   201: aload 4
    //   203: aload 10
    //   205: ldc 89
    //   207: invokespecial 74	com/viber/provider/messages/b/b:a	(Lcom/viber/voip/util/LongSparseSet;Lcom/viber/voip/util/LongSparseSet;Landroid/database/Cursor;Ljava/lang/String;)V
    //   210: aload 10
    //   212: invokeinterface 80 1 0
    //   217: istore 12
    //   219: iload 12
    //   221: ifne -22 -> 199
    //   224: aload 10
    //   226: invokestatic 83	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   229: aload 4
    //   231: areturn
    //   232: astore 7
    //   234: aload 6
    //   236: invokestatic 83	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   239: aload 7
    //   241: athrow
    //   242: astore 11
    //   244: aload 10
    //   246: invokestatic 83	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   249: aload 11
    //   251: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   69	77	232	finally
    //   77	141	232	finally
    //   191	199	242	finally
    //   199	219	242	finally
  }

  private LongSparseSet a(com.viber.provider.b paramb, String paramString1, String paramString2)
  {
    Cursor localCursor = paramb.a(paramString1, new String[] { "_id" }, paramString2, null, null, null, null);
    try
    {
      boolean bool1 = af.c(localCursor);
      LongSparseSet localLongSparseSet = null;
      if (bool1)
      {
        localLongSparseSet = new LongSparseSet();
        boolean bool2;
        do
        {
          localLongSparseSet.add(localCursor.getLong(localCursor.getColumnIndex("_id")));
          bool2 = localCursor.moveToNext();
        }
        while (bool2);
      }
      return localLongSparseSet;
    }
    finally
    {
      af.a(localCursor);
    }
  }

  private void a(LongSparseSet paramLongSparseSet1, LongSparseSet paramLongSparseSet2, Cursor paramCursor, String paramString)
  {
    long l = paramCursor.getLong(paramCursor.getColumnIndex(paramString));
    if (paramLongSparseSet1.contains(l))
      paramLongSparseSet2.add(l);
  }

  void a(com.viber.provider.b paramb)
  {
    LongSparseSet localLongSparseSet1 = a(paramb, "participants_info", "participant_info_flags & 2 <> 0");
    String str1;
    long l1;
    long l2;
    if (!u.a(localLongSparseSet1))
    {
      str1 = a.a(localLongSparseSet1);
      LongSparseSet localLongSparseSet2 = a(paramb, "conversations", String.format("conversation_type = 0 AND participant_id_1 IN (%s)", new Object[] { str1 }));
      if (u.a(localLongSparseSet2))
        break label267;
      String str2 = a.a(localLongSparseSet2);
      a(paramb, "participants", "conversation_id", str2);
      l1 = a(paramb, "messages_calls", "conversation_id", str2);
      l2 = a(paramb, "messages", "conversation_id", str2);
      a(paramb, "conversations", "_id", str2);
    }
    while (true)
    {
      LongSparseSet localLongSparseSet3 = a(paramb, localLongSparseSet1, str1);
      if (!u.a(localLongSparseSet3))
      {
        a.a(new Exception("Cannot remove still used ParticipantInfo"), "removeInvalidParticipantData: not removed ParticipantInfo count = " + localLongSparseSet3.size());
        localLongSparseSet1.removeAll(localLongSparseSet3);
      }
      if (!localLongSparseSet1.isEmpty())
        paramb.a("participants_info", String.format("_id IN (%s)", new Object[] { a.a(localLongSparseSet1) }), null);
      if ((l2 > 0L) || (l1 > 0L))
        a.a(new Exception("Dangling msgs/calls was removed"), "removeInvalidParticipantData: dangling msgs count = " + l2 + ", dangling calls count = " + l1);
      return;
      label267: l1 = 0L;
      l2 = 0L;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.provider.messages.b.b
 * JD-Core Version:    0.6.2
 */