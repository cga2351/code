package android.arch.persistence.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build.VERSION;
import android.util.Log;
import java.io.File;

public abstract interface c
{
  public abstract b a();

  public abstract void a(boolean paramBoolean);

  public static abstract class a
  {
    public final int a;

    public a(int paramInt)
    {
      this.a = paramInt;
    }

    private void a(String paramString)
    {
      if ((paramString.equalsIgnoreCase(":memory:")) || (paramString.trim().length() == 0));
      while (true)
      {
        return;
        Log.w("SupportSQLite", "deleting the database file: " + paramString);
        try
        {
          if (Build.VERSION.SDK_INT >= 16)
          {
            SQLiteDatabase.deleteDatabase(new File(paramString));
            return;
          }
        }
        catch (Exception localException1)
        {
          Log.w("SupportSQLite", "delete failed: ", localException1);
          return;
        }
        try
        {
          if (!new File(paramString).delete())
          {
            Log.e("SupportSQLite", "Could not delete the database file " + paramString);
            return;
          }
        }
        catch (Exception localException2)
        {
          Log.e("SupportSQLite", "error while deleting corrupted database file", localException2);
        }
      }
    }

    public void a(b paramb)
    {
    }

    public abstract void a(b paramb, int paramInt1, int paramInt2);

    public abstract void b(b paramb);

    public void b(b paramb, int paramInt1, int paramInt2)
    {
      throw new SQLiteException("Can't downgrade database from version " + paramInt1 + " to " + paramInt2);
    }

    public void c(b paramb)
    {
    }

    // ERROR //
    public void d(b paramb)
    {
      // Byte code:
      //   0: ldc 34
      //   2: new 36	java/lang/StringBuilder
      //   5: dup
      //   6: invokespecial 37	java/lang/StringBuilder:<init>	()V
      //   9: ldc 104
      //   11: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   14: aload_1
      //   15: invokeinterface 109 1 0
      //   20: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   23: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   26: invokestatic 81	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
      //   29: pop
      //   30: aload_1
      //   31: invokeinterface 111 1 0
      //   36: ifne +14 -> 50
      //   39: aload_0
      //   40: aload_1
      //   41: invokeinterface 109 1 0
      //   46: invokespecial 113	android/arch/persistence/a/c$a:a	(Ljava/lang/String;)V
      //   49: return
      //   50: aload_1
      //   51: invokeinterface 117 1 0
      //   56: astore 12
      //   58: aload 12
      //   60: astore 4
      //   62: aload_1
      //   63: invokeinterface 120 1 0
      //   68: aload 4
      //   70: ifnull +45 -> 115
      //   73: aload 4
      //   75: invokeinterface 126 1 0
      //   80: astore 10
      //   82: aload 10
      //   84: invokeinterface 131 1 0
      //   89: ifeq -40 -> 49
      //   92: aload_0
      //   93: aload 10
      //   95: invokeinterface 135 1 0
      //   100: checkcast 137	android/util/Pair
      //   103: getfield 141	android/util/Pair:second	Ljava/lang/Object;
      //   106: checkcast 20	java/lang/String
      //   109: invokespecial 113	android/arch/persistence/a/c$a:a	(Ljava/lang/String;)V
      //   112: goto -30 -> 82
      //   115: aload_0
      //   116: aload_1
      //   117: invokeinterface 109 1 0
      //   122: invokespecial 113	android/arch/persistence/a/c$a:a	(Ljava/lang/String;)V
      //   125: return
      //   126: astore 11
      //   128: aconst_null
      //   129: astore 6
      //   131: aload 11
      //   133: astore 7
      //   135: aload 6
      //   137: ifnull +45 -> 182
      //   140: aload 6
      //   142: invokeinterface 126 1 0
      //   147: astore 8
      //   149: aload 8
      //   151: invokeinterface 131 1 0
      //   156: ifeq +36 -> 192
      //   159: aload_0
      //   160: aload 8
      //   162: invokeinterface 135 1 0
      //   167: checkcast 137	android/util/Pair
      //   170: getfield 141	android/util/Pair:second	Ljava/lang/Object;
      //   173: checkcast 20	java/lang/String
      //   176: invokespecial 113	android/arch/persistence/a/c$a:a	(Ljava/lang/String;)V
      //   179: goto -30 -> 149
      //   182: aload_0
      //   183: aload_1
      //   184: invokeinterface 109 1 0
      //   189: invokespecial 113	android/arch/persistence/a/c$a:a	(Ljava/lang/String;)V
      //   192: aload 7
      //   194: athrow
      //   195: astore_3
      //   196: aconst_null
      //   197: astore 4
      //   199: goto -137 -> 62
      //   202: astore 9
      //   204: goto -136 -> 68
      //   207: astore 5
      //   209: aload 4
      //   211: astore 6
      //   213: aload 5
      //   215: astore 7
      //   217: goto -82 -> 135
      //
      // Exception table:
      //   from	to	target	type
      //   50	58	126	finally
      //   50	58	195	android/database/sqlite/SQLiteException
      //   62	68	202	java/io/IOException
      //   62	68	207	finally
    }
  }

  public static class b
  {
    public final Context a;
    public final String b;
    public final c.a c;

    b(Context paramContext, String paramString, c.a parama)
    {
      this.a = paramContext;
      this.b = paramString;
      this.c = parama;
    }

    public static a a(Context paramContext)
    {
      return new a(paramContext);
    }

    public static class a
    {
      Context a;
      String b;
      c.a c;

      a(Context paramContext)
      {
        this.a = paramContext;
      }

      public a a(c.a parama)
      {
        this.c = parama;
        return this;
      }

      public a a(String paramString)
      {
        this.b = paramString;
        return this;
      }

      public c.b a()
      {
        if (this.c == null)
          throw new IllegalArgumentException("Must set a callback to create the configuration.");
        if (this.a == null)
          throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
        return new c.b(this.a, this.b, this.c);
      }
    }
  }

  public static abstract interface c
  {
    public abstract c a(c.b paramb);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.arch.persistence.a.c
 * JD-Core Version:    0.6.2
 */