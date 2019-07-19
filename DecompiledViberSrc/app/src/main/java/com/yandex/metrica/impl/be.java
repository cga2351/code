package com.yandex.metrica.impl;

import android.database.Cursor;
import com.yandex.metrica.impl.ob.ab;
import com.yandex.metrica.impl.ob.ek;
import com.yandex.metrica.impl.ob.fh;
import com.yandex.metrica.impl.ob.kk.c.e.b;

@Deprecated
class be extends bd
{
  public be(ab paramab)
  {
    super(paramab);
  }

  protected long H()
  {
    return -9223372036854775808L;
  }

  protected long I()
  {
    return -9223372036854775808L;
  }

  // ERROR //
  protected bd.c L()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: invokevirtual 22	com/yandex/metrica/impl/be:M	()Landroid/database/Cursor;
    //   6: astore 7
    //   8: aload 7
    //   10: astore_3
    //   11: aload_3
    //   12: ifnull +28 -> 40
    //   15: aload_3
    //   16: invokeinterface 28 1 0
    //   21: ifeq +19 -> 40
    //   24: aload_3
    //   25: invokeinterface 32 1 0
    //   30: istore 13
    //   32: aconst_null
    //   33: astore 11
    //   35: iload 13
    //   37: ifne +69 -> 106
    //   40: aload_0
    //   41: getfield 36	com/yandex/metrica/impl/be:m	Lcom/yandex/metrica/impl/ob/fh;
    //   44: aload_0
    //   45: invokevirtual 38	com/yandex/metrica/impl/be:H	()J
    //   48: getstatic 44	com/yandex/metrica/impl/ob/ek:b	Lcom/yandex/metrica/impl/ob/ek;
    //   51: invokevirtual 50	com/yandex/metrica/impl/ob/fh:a	(JLcom/yandex/metrica/impl/ob/ek;)Landroid/database/Cursor;
    //   54: astore 10
    //   56: aload 10
    //   58: astore 4
    //   60: aload 4
    //   62: ifnull +40 -> 102
    //   65: aload 4
    //   67: invokeinterface 28 1 0
    //   72: ifeq +30 -> 102
    //   75: aload 4
    //   77: invokeinterface 32 1 0
    //   82: ifle +20 -> 102
    //   85: aload_0
    //   86: getfield 36	com/yandex/metrica/impl/be:m	Lcom/yandex/metrica/impl/ob/fh;
    //   89: aload_0
    //   90: invokevirtual 38	com/yandex/metrica/impl/be:H	()J
    //   93: getstatic 44	com/yandex/metrica/impl/ob/ek:b	Lcom/yandex/metrica/impl/ob/ek;
    //   96: invokestatic 55	java/lang/System:currentTimeMillis	()J
    //   99: invokevirtual 58	com/yandex/metrica/impl/ob/fh:a	(JLcom/yandex/metrica/impl/ob/ek;J)V
    //   102: aload 4
    //   104: astore 11
    //   106: aload_3
    //   107: invokestatic 63	com/yandex/metrica/impl/bw:a	(Landroid/database/Cursor;)V
    //   110: aload 11
    //   112: invokestatic 63	com/yandex/metrica/impl/bw:a	(Landroid/database/Cursor;)V
    //   115: aload_0
    //   116: invokespecial 65	com/yandex/metrica/impl/bd:L	()Lcom/yandex/metrica/impl/bd$c;
    //   119: areturn
    //   120: astore 6
    //   122: aconst_null
    //   123: astore 4
    //   125: aload_1
    //   126: invokestatic 63	com/yandex/metrica/impl/bw:a	(Landroid/database/Cursor;)V
    //   129: aload 4
    //   131: invokestatic 63	com/yandex/metrica/impl/bw:a	(Landroid/database/Cursor;)V
    //   134: goto -19 -> 115
    //   137: astore_2
    //   138: aconst_null
    //   139: astore_3
    //   140: aconst_null
    //   141: astore 4
    //   143: aload_2
    //   144: astore 5
    //   146: aload_3
    //   147: invokestatic 63	com/yandex/metrica/impl/bw:a	(Landroid/database/Cursor;)V
    //   150: aload 4
    //   152: invokestatic 63	com/yandex/metrica/impl/bw:a	(Landroid/database/Cursor;)V
    //   155: aload 5
    //   157: athrow
    //   158: astore 9
    //   160: aload 9
    //   162: astore 5
    //   164: aconst_null
    //   165: astore 4
    //   167: goto -21 -> 146
    //   170: astore 5
    //   172: goto -26 -> 146
    //   175: astore 8
    //   177: aload_3
    //   178: astore_1
    //   179: aconst_null
    //   180: astore 4
    //   182: goto -57 -> 125
    //   185: astore 12
    //   187: aload_3
    //   188: astore_1
    //   189: goto -64 -> 125
    //
    // Exception table:
    //   from	to	target	type
    //   2	8	120	java/lang/Exception
    //   2	8	137	finally
    //   15	32	158	finally
    //   40	56	158	finally
    //   65	102	170	finally
    //   15	32	175	java/lang/Exception
    //   40	56	175	java/lang/Exception
    //   65	102	185	java/lang/Exception
  }

  protected Cursor M()
  {
    return this.m.a(H(), this.b);
  }

  protected Cursor a(long paramLong, ek paramek)
  {
    return this.m.a(H(), paramek);
  }

  protected bd.b a(long paramLong, kk.c.e.b paramb)
  {
    return super.a(I(), paramb);
  }

  public String a()
  {
    return super.a() + " [" + H() + "]";
  }

  protected boolean a(long paramLong)
  {
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.be
 * JD-Core Version:    0.6.2
 */