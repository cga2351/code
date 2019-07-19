package com.viber.voip.registration;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class u
{
  private final InputStream a;
  private final List<a> b = new ArrayList(5);

  public u(InputStream paramInputStream)
  {
    this.a = paramInputStream;
  }

  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
      ((a)localIterator.next()).a(paramString1, paramString2, paramString3, paramString4);
  }

  // ERROR //
  void a()
    throws java.io.IOException
  {
    // Byte code:
    //   0: invokestatic 54	org/xmlpull/v1/XmlPullParserFactory:newInstance	()Lorg/xmlpull/v1/XmlPullParserFactory;
    //   3: invokevirtual 58	org/xmlpull/v1/XmlPullParserFactory:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   6: astore_2
    //   7: aload_2
    //   8: aload_0
    //   9: getfield 23	com/viber/voip/registration/u:a	Ljava/io/InputStream;
    //   12: ldc 60
    //   14: invokeinterface 66 3 0
    //   19: aload_2
    //   20: invokeinterface 70 1 0
    //   25: istore 5
    //   27: aconst_null
    //   28: astore 6
    //   30: aconst_null
    //   31: astore 7
    //   33: goto +175 -> 208
    //   36: aload_2
    //   37: invokeinterface 72 1 0
    //   42: istore 8
    //   44: iload 8
    //   46: istore 5
    //   48: goto +160 -> 208
    //   51: astore_1
    //   52: new 46	java/io/IOException
    //   55: dup
    //   56: aload_1
    //   57: invokevirtual 76	org/xmlpull/v1/XmlPullParserException:getMessage	()Ljava/lang/String;
    //   60: invokespecial 79	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   63: athrow
    //   64: aload_2
    //   65: invokeinterface 82 1 0
    //   70: astore 7
    //   72: goto -36 -> 36
    //   75: aload_2
    //   76: invokeinterface 85 1 0
    //   81: istore 9
    //   83: aload_2
    //   84: invokeinterface 88 1 0
    //   89: astore 10
    //   91: ldc 90
    //   93: aload 7
    //   95: invokevirtual 96	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   98: ifeq +15 -> 113
    //   101: iload 9
    //   103: ifne +10 -> 113
    //   106: aload 10
    //   108: astore 6
    //   110: goto -74 -> 36
    //   113: ldc 98
    //   115: aload 7
    //   117: invokevirtual 96	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   120: ifeq -84 -> 36
    //   123: aload 6
    //   125: ifnull -89 -> 36
    //   128: aload 10
    //   130: ifnull -94 -> 36
    //   133: aload_0
    //   134: aload 6
    //   136: aload 10
    //   138: new 100	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   145: ldc 103
    //   147: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload 6
    //   152: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: ldc 112
    //   160: invokespecial 113	com/viber/voip/registration/u:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   163: aconst_null
    //   164: astore 6
    //   166: goto -130 -> 36
    //   169: aconst_null
    //   170: astore 7
    //   172: goto -136 -> 36
    //   175: aload_0
    //   176: getfield 23	com/viber/voip/registration/u:a	Ljava/io/InputStream;
    //   179: invokevirtual 118	java/io/InputStream:close	()V
    //   182: return
    //   183: astore 4
    //   185: new 46	java/io/IOException
    //   188: dup
    //   189: aload 4
    //   191: invokevirtual 76	org/xmlpull/v1/XmlPullParserException:getMessage	()Ljava/lang/String;
    //   194: invokespecial 79	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   197: athrow
    //   198: astore_3
    //   199: aload_0
    //   200: getfield 23	com/viber/voip/registration/u:a	Ljava/io/InputStream;
    //   203: invokevirtual 118	java/io/InputStream:close	()V
    //   206: aload_3
    //   207: athrow
    //   208: iload 5
    //   210: iconst_1
    //   211: if_icmpeq -36 -> 175
    //   214: iload 5
    //   216: tableswitch	default:+-180 -> 36, 2:+-152->64, 3:+-47->169, 4:+-141->75
    //
    // Exception table:
    //   from	to	target	type
    //   0	19	51	org/xmlpull/v1/XmlPullParserException
    //   19	27	183	org/xmlpull/v1/XmlPullParserException
    //   36	44	183	org/xmlpull/v1/XmlPullParserException
    //   64	72	183	org/xmlpull/v1/XmlPullParserException
    //   75	101	183	org/xmlpull/v1/XmlPullParserException
    //   113	123	183	org/xmlpull/v1/XmlPullParserException
    //   133	163	183	org/xmlpull/v1/XmlPullParserException
    //   19	27	198	finally
    //   36	44	198	finally
    //   64	72	198	finally
    //   75	101	198	finally
    //   113	123	198	finally
    //   133	163	198	finally
    //   185	198	198	finally
  }

  void a(a parama)
  {
    this.b.add(parama);
  }

  void b()
  {
    this.b.clear();
  }

  void c()
  {
    b();
  }

  static abstract interface a
  {
    public abstract void a(String paramString1, String paramString2, String paramString3, String paramString4);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.registration.u
 * JD-Core Version:    0.6.2
 */