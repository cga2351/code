package com.viber.voip.messages.extensions;

import android.content.ContentValues;
import com.viber.provider.b;
import com.viber.voip.messages.controller.manager.aa;
import com.viber.voip.messages.extensions.d.a.c;
import com.viber.voip.messages.extensions.d.a.d;
import com.viber.voip.messages.extensions.model.c.b;
import com.viber.voip.messages.orm.entity.impl.ChatExtensionEntityHelper;
import com.viber.voip.s.a;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.sqlite.database.sqlite.SQLiteStatement;

@Singleton
public class f extends aa
{
  private final com.viber.voip.util.i.e g;
  private SQLiteStatement h;

  @Inject
  public f(com.viber.voip.util.i.e parame)
  {
    this.g = parame;
  }

  private ContentValues a(String paramString1, String paramString2, c paramc)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("keyword", paramString1);
    localContentValues.put("service_uri", paramc.a);
    localContentValues.put("country", paramString2);
    if (paramc.c != null)
    {
      localContentValues.put("timeframe_from", Long.valueOf(paramc.c.a.getTime()));
      localContentValues.put("timeframe_to", Long.valueOf(paramc.c.b.getTime()));
    }
    return localContentValues;
  }

  private SQLiteStatement b()
  {
    if (this.h == null)
      this.h = f().b("SELECT COUNT() FROM chat_extensions WHERE uri = ?");
    return this.h;
  }

  private boolean c(String paramString)
  {
    SQLiteStatement localSQLiteStatement = b();
    localSQLiteStatement.bindString(1, paramString);
    return localSQLiteStatement.simpleQueryForLong() > 0L;
  }

  b a(List<c.b> paramList, a parama)
  {
    b localb = f();
    while (true)
    {
      int j;
      try
      {
        localb.a();
        String[] arrayOfString = new String[paramList.size()];
        int i = paramList.size();
        j = 0;
        k = 0;
        m = 0;
        if (j < i)
        {
          c.b localb1 = (c.b)paramList.get(j);
          String str = localb1.b();
          arrayOfString[j] = str;
          ContentValues localContentValues = ChatExtensionEntityHelper.getContentValues(localb1, j);
          localContentValues.put("featured_index", Integer.valueOf(parama.a(str)));
          if (c(str))
          {
            i3 = k + localb.a("chat_extensions", localContentValues, "uri = ?", new String[] { str });
            i2 = m;
            break label256;
          }
          if (localb.a("chat_extensions", null, localContentValues) > 0L)
          {
            int n = m + 1;
            int i1 = k;
            i2 = n;
            i3 = i1;
            break label256;
          }
        }
        else
        {
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = a.a(arrayOfString);
          int i4 = localb.a("chat_extensions", String.format("uri NOT IN (%s)", arrayOfObject), null);
          localb.c();
          return new b(m, k, i4);
        }
      }
      finally
      {
        localb.b();
      }
      int i3 = k;
      int i2 = m;
      label256: j++;
      int m = i2;
      int k = i3;
    }
  }

  // ERROR //
  List<com.viber.voip.messages.extensions.model.ChatExtensionLoaderEntity> a()
  {
    // Byte code:
    //   0: new 175	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 176	java/util/ArrayList:<init>	()V
    //   7: astore_1
    //   8: invokestatic 75	com/viber/voip/messages/extensions/f:f	()Lcom/viber/provider/b;
    //   11: ldc 139
    //   13: getstatic 180	com/viber/voip/messages/orm/entity/impl/ChatExtensionEntityHelper:PROJECTIONS	[Ljava/lang/String;
    //   16: aconst_null
    //   17: aconst_null
    //   18: aconst_null
    //   19: aconst_null
    //   20: ldc 182
    //   22: invokeinterface 185 8 0
    //   27: astore 4
    //   29: aload 4
    //   31: astore_3
    //   32: aload_3
    //   33: ifnull +40 -> 73
    //   36: aload_3
    //   37: invokeinterface 191 1 0
    //   42: ifeq +31 -> 73
    //   45: aload_1
    //   46: new 193	com/viber/voip/messages/extensions/model/ChatExtensionLoaderEntity
    //   49: dup
    //   50: aload_3
    //   51: invokespecial 196	com/viber/voip/messages/extensions/model/ChatExtensionLoaderEntity:<init>	(Landroid/database/Cursor;)V
    //   54: invokeinterface 200 2 0
    //   59: pop
    //   60: aload_3
    //   61: invokeinterface 203 1 0
    //   66: istore 6
    //   68: iload 6
    //   70: ifne -25 -> 45
    //   73: aload_3
    //   74: invokestatic 207	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   77: aload_1
    //   78: areturn
    //   79: astore_2
    //   80: aconst_null
    //   81: astore_3
    //   82: aload_3
    //   83: invokestatic 207	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   86: aload_2
    //   87: athrow
    //   88: astore_2
    //   89: goto -7 -> 82
    //
    // Exception table:
    //   from	to	target	type
    //   8	29	79	finally
    //   36	45	88	finally
    //   45	68	88	finally
  }

  public void a(d[] paramArrayOfd)
  {
    b localb = f();
    while (true)
    {
      int j;
      int m;
      try
      {
        localb.a();
        localb.a("chatex_suggestions", null, null);
        int i = paramArrayOfd.length;
        j = 0;
        if (j < i)
        {
          d locald = paramArrayOfd[j];
          c[] arrayOfc = locald.b;
          int k = arrayOfc.length;
          m = 0;
          if (m >= k)
            break label156;
          c localc = arrayOfc[m];
          String[] arrayOfString = localc.b;
          int n = arrayOfString.length;
          int i1 = 0;
          if (i1 < n)
          {
            String str = arrayOfString[i1];
            localb.a("chatex_suggestions", null, a(locald.a, str, localc));
            i1++;
            continue;
          }
        }
        else
        {
          localb.c();
          return;
        }
      }
      finally
      {
        localb.b();
      }
      m++;
      continue;
      label156: j++;
    }
  }

  public boolean a(String paramString)
  {
    ContentValues localContentValues = new ContentValues(1);
    localContentValues.put("last_use_time", Long.valueOf(this.g.a()));
    return f().a("chat_extensions", localContentValues, "public_account_id = ?", new String[] { paramString }) > 0;
  }

  // ERROR //
  public List<com.viber.voip.model.entity.ChatExSuggestionEntity> b(String paramString)
  {
    // Byte code:
    //   0: new 175	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 176	java/util/ArrayList:<init>	()V
    //   7: astore_2
    //   8: invokestatic 75	com/viber/voip/messages/extensions/f:f	()Lcom/viber/provider/b;
    //   11: ldc 210
    //   13: getstatic 235	com/viber/voip/model/entity/ChatExSuggestionEntity:PROJECTIONS	[Ljava/lang/String;
    //   16: ldc 237
    //   18: iconst_1
    //   19: anewarray 105	java/lang/String
    //   22: dup
    //   23: iconst_0
    //   24: aload_1
    //   25: aastore
    //   26: aconst_null
    //   27: aconst_null
    //   28: aconst_null
    //   29: invokeinterface 185 8 0
    //   34: astore 5
    //   36: aload 5
    //   38: astore 4
    //   40: aload 4
    //   42: ifnull +43 -> 85
    //   45: aload 4
    //   47: invokeinterface 191 1 0
    //   52: ifeq +33 -> 85
    //   55: aload_2
    //   56: new 234	com/viber/voip/model/entity/ChatExSuggestionEntity
    //   59: dup
    //   60: aload 4
    //   62: invokespecial 238	com/viber/voip/model/entity/ChatExSuggestionEntity:<init>	(Landroid/database/Cursor;)V
    //   65: invokeinterface 200 2 0
    //   70: pop
    //   71: aload 4
    //   73: invokeinterface 203 1 0
    //   78: istore 7
    //   80: iload 7
    //   82: ifne -27 -> 55
    //   85: aload 4
    //   87: invokestatic 207	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   90: aload_2
    //   91: areturn
    //   92: astore_3
    //   93: aconst_null
    //   94: astore 4
    //   96: aload 4
    //   98: invokestatic 207	com/viber/voip/util/af:a	(Landroid/database/Cursor;)V
    //   101: aload_3
    //   102: athrow
    //   103: astore_3
    //   104: goto -8 -> 96
    //
    // Exception table:
    //   from	to	target	type
    //   8	36	92	finally
    //   45	55	103	finally
    //   55	80	103	finally
  }

  static abstract interface a
  {
    public abstract int a(String paramString);
  }

  static class b
  {
    public final int a;
    public final int b;
    public final int c;

    public b(int paramInt1, int paramInt2, int paramInt3)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramInt3;
    }

    public boolean a()
    {
      return (this.a > 0) || (this.b > 0) || (this.c > 0);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.f
 * JD-Core Version:    0.6.2
 */