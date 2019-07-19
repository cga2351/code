package com.viber.voip.stickers.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.SparseArray;
import com.viber.dexshared.Logger;
import com.viber.provider.e;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.stickers.entity.c;
import com.viber.voip.util.af;
import com.viber.voip.util.av;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class a
{
  private static final Logger a = ViberEnv.getLogger();
  private static final String[] b = { "stickers._id", "generic_col_pos", "generic_row_pos", "column_span", "row_span", "package_id", "stickers.flags" };
  private static final String[] c = { "_id" };

  private List<com.viber.voip.stickers.entity.b> a(String paramString, String[] paramArrayOfString)
  {
    Cursor localCursor = h().a("stickers_packages", new String[] { "_id", "package_info", "flags", "thumb_axis_shrink_factor", "menu_position", "visibility", "version" }, paramString, paramArrayOfString, null, null, null);
    boolean bool1 = af.b(localCursor);
    ArrayList localArrayList = null;
    if (!bool1)
    {
      boolean bool2 = localCursor.moveToFirst();
      localArrayList = null;
      if (bool2)
      {
        localArrayList = new ArrayList(localCursor.getCount());
        do
        {
          com.viber.voip.stickers.entity.b localb = new com.viber.voip.stickers.entity.b(localCursor.getInt(0), localCursor.getString(1));
          localb.a(localCursor.getInt(2));
          localb.b(localCursor.getFloat(3));
          localb.b(localCursor.getInt(4));
          localb.c(localCursor.getInt(5));
          localb.a(localCursor.getFloat(6));
          localb.i(true);
          localArrayList.add(localb);
        }
        while (localCursor.moveToNext());
      }
    }
    af.a(localCursor);
    if (localArrayList == null)
      localArrayList = new ArrayList(0);
    return localArrayList;
  }

  private com.viber.provider.b h()
  {
    return com.viber.provider.messages.b.d.a(ViberApplication.getApplication());
  }

  public int a(com.viber.voip.stickers.entity.d paramd)
  {
    ContentValues localContentValues = new ContentValues(2);
    localContentValues.put("visibility", Integer.valueOf(paramd.b()));
    localContentValues.put("menu_position", Integer.valueOf(paramd.a()));
    com.viber.provider.b localb = h();
    String[] arrayOfString = new String[3];
    arrayOfString[0] = String.valueOf(paramd.e());
    arrayOfString[1] = String.valueOf(paramd.b());
    arrayOfString[2] = String.valueOf(paramd.a());
    return localb.a("stickers_packages", localContentValues, "_id = ? AND (visibility <> ? OR menu_position <> ?)", arrayOfString);
  }

  public SparseArray<Sticker> a(int[] paramArrayOfInt)
  {
    Cursor localCursor = h().a("stickers", b, "stickers._id IN (" + com.viber.voip.s.a.b(paramArrayOfInt) + ")", null, null, null, null);
    SparseArray localSparseArray = new SparseArray(localCursor.getCount());
    if ((!af.b(localCursor)) && (localCursor.getCount() > 0) && (localCursor.moveToFirst()))
      do
      {
        Sticker localSticker = a(localCursor);
        localSparseArray.put(localSticker.id, localSticker);
      }
      while (localCursor.moveToNext());
    af.a(localCursor);
    return localSparseArray;
  }

  public Sticker a(Cursor paramCursor)
  {
    Sticker localSticker = new Sticker(paramCursor.getInt(0), paramCursor.getInt(1), paramCursor.getInt(2), paramCursor.getInt(3), paramCursor.getInt(4), paramCursor.getInt(5), paramCursor.getInt(6));
    localSticker.setIsInDatabase(true);
    return localSticker;
  }

  public List<Sticker> a()
  {
    Cursor localCursor = h().a("stickers", b, null, null, null, null, "stickers._id");
    Object localObject;
    if ((!af.b(localCursor)) && (localCursor.getCount() > 0) && (localCursor.moveToFirst()))
    {
      localObject = new ArrayList(localCursor.getCount());
      do
        ((List)localObject).add(a(localCursor));
      while (localCursor.moveToNext());
    }
    while (true)
    {
      af.a(localCursor);
      return localObject;
      localObject = Collections.emptyList();
    }
  }

  public List<Integer> a(Set<Integer> paramSet)
  {
    com.viber.provider.b localb1 = h();
    String[] arrayOfString = { "_id" };
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = com.viber.voip.s.a.d(paramSet);
    Cursor localCursor = localb1.a("stickers", arrayOfString, String.format("package_id = 0 AND _id NOT IN (%s) AND _id NOT IN (SELECT  DISTINCT extra_upload_id FROM  messages WHERE extra_mime = 4)", arrayOfObject1), null, null, null, null);
    while (true)
    {
      try
      {
        if ((!af.b(localCursor)) && (localCursor.moveToFirst()))
        {
          localArrayList = new ArrayList(localCursor.getCount());
          localArrayList.add(Integer.valueOf(localCursor.getInt(0)));
          boolean bool = localCursor.moveToNext();
          if (bool)
            continue;
          af.a(localCursor);
          if ((localArrayList != null) && (localArrayList.size() > 0))
          {
            com.viber.provider.b localb2 = h();
            Object[] arrayOfObject2 = new Object[1];
            arrayOfObject2[0] = com.viber.voip.s.a.d(localArrayList);
            localb2.a("stickers", String.format("_id IN(%s)", arrayOfObject2), null);
          }
          return localArrayList;
        }
      }
      finally
      {
        af.a(localCursor);
      }
      ArrayList localArrayList = null;
    }
  }

  public void a(int paramInt, c paramc)
  {
    ContentValues localContentValues = new ContentValues(1);
    localContentValues.put("package_info", paramc.a());
    com.viber.provider.b localb = h();
    String[] arrayOfString = new String[1];
    arrayOfString[0] = Integer.toString(paramInt);
    localb.a("stickers_packages", localContentValues, "_id = ?", arrayOfString);
  }

  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      h().a("stickers", null, null);
      h().a("stickers_packages", null, null);
      e.a(ViberApplication.getApplication(), "db/script_for_filling_stickers_table.sql", h(), a);
      e.a(ViberApplication.getApplication(), "db/doodle_sticker_pack_migration_92.sql", h(), a);
      return;
    }
    h().a("stickers", "package_id NOT IN ( " + paramInt + ", " + 400 + ", " + 143700 + ", " + 133600 + ", " + -1 + " )", null);
    h().a("stickers_packages", "_id NOT IN ( " + paramInt + ", " + 400 + ", " + 143700 + ", " + 133600 + ")", null);
  }

  public void a(Sticker paramSticker)
  {
    try
    {
      ContentValues localContentValues = new ContentValues(7);
      localContentValues.put("_id", Integer.valueOf(paramSticker.id));
      if (paramSticker.packageId > 0)
      {
        localContentValues.put("package_id", Integer.valueOf(paramSticker.packageId));
        localContentValues.put("generic_col_pos", Integer.valueOf(paramSticker.getGenericColPos()));
        localContentValues.put("generic_row_pos", Integer.valueOf(paramSticker.getGenericRowPos()));
      }
      localContentValues.put("column_span", Integer.valueOf(paramSticker.getColSpan()));
      localContentValues.put("row_span", Integer.valueOf(paramSticker.getRowSpan()));
      localContentValues.put("flags", Integer.valueOf(paramSticker.getFlags()));
      com.viber.provider.b localb = h();
      af.a(localb, new b(this, paramSticker, localb, localContentValues));
      return;
    }
    finally
    {
    }
  }

  public void a(com.viber.voip.stickers.entity.b paramb)
  {
    a(paramb, false);
  }

  public void a(com.viber.voip.stickers.entity.b paramb, boolean paramBoolean)
  {
    ContentValues localContentValues = new ContentValues(7);
    localContentValues.put("_id", Integer.valueOf(paramb.e()));
    localContentValues.put("package_info", paramb.z());
    localContentValues.put("flags", Integer.valueOf(paramb.A()));
    localContentValues.put("thumb_axis_shrink_factor", Float.valueOf(paramb.C()));
    localContentValues.put("version", Float.valueOf(paramb.B()));
    if (paramb.c());
    for (int i = 0; ; i = 1)
    {
      localContentValues.put("visibility", Integer.valueOf(i));
      if (!e(paramb.e()))
        break;
      if (paramBoolean)
      {
        localContentValues.put("menu_position", Integer.valueOf(0));
        d(paramb.e());
      }
      com.viber.provider.b localb = h();
      String[] arrayOfString = new String[1];
      arrayOfString[0] = Integer.toString(paramb.e());
      localb.a("stickers_packages", localContentValues, "_id = ?", arrayOfString);
      return;
    }
    h().a("stickers_packages", null, localContentValues);
    paramb.i(true);
  }

  public void a(List<Sticker> paramList)
  {
    try
    {
      com.viber.provider.b localb = h();
      localb.a();
      try
      {
        int i = paramList.size();
        for (int j = 0; j < i; j++)
          a((Sticker)paramList.get(j));
        localb.c();
        localb.b();
        return;
      }
      finally
      {
        localb.b();
      }
    }
    finally
    {
    }
  }

  public boolean a(int paramInt)
  {
    com.viber.provider.b localb = h();
    String[] arrayOfString1 = c;
    String[] arrayOfString2 = new String[1];
    arrayOfString2[0] = Integer.toString(paramInt);
    Cursor localCursor = localb.a("stickers", arrayOfString1, "stickers._id=?", arrayOfString2, null, null, null);
    try
    {
      if ((!af.b(localCursor)) && (localCursor.getCount() > 0))
      {
        boolean bool = localCursor.moveToFirst();
        if (bool)
          return true;
      }
      return false;
    }
    finally
    {
      af.a(localCursor);
    }
  }

  public Sticker b(int paramInt)
  {
    com.viber.provider.b localb = h();
    String[] arrayOfString1 = b;
    String[] arrayOfString2 = new String[1];
    arrayOfString2[0] = String.valueOf(paramInt);
    Cursor localCursor = localb.a("stickers", arrayOfString1, "stickers._id=?", arrayOfString2, null, null, null);
    try
    {
      boolean bool1 = af.b(localCursor);
      Object localObject2 = null;
      if (!bool1)
      {
        int i = localCursor.getCount();
        localObject2 = null;
        if (i > 0)
        {
          boolean bool2 = localCursor.moveToFirst();
          localObject2 = null;
          if (bool2)
          {
            Sticker localSticker = a(localCursor);
            localObject2 = localSticker;
          }
        }
      }
      return localObject2;
    }
    finally
    {
      af.a(localCursor);
    }
  }

  public List<Sticker> b()
  {
    Cursor localCursor = h().a("stickers", b, "stickers.package_id<=?", new String[] { "0" }, null, null, null);
    Object localObject;
    if ((!af.b(localCursor)) && (localCursor.getCount() > 0) && (localCursor.moveToFirst()))
    {
      localObject = new ArrayList(localCursor.getCount());
      do
        ((List)localObject).add(a(localCursor));
      while (localCursor.moveToNext());
    }
    while (true)
    {
      af.a(localCursor);
      return localObject;
      localObject = Collections.emptyList();
    }
  }

  public void b(List<com.viber.voip.stickers.entity.b> paramList)
  {
    h().a();
    try
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        com.viber.voip.stickers.entity.b localb = (com.viber.voip.stickers.entity.b)localIterator.next();
        ContentValues localContentValues = new ContentValues(2);
        localContentValues.put("version", Float.valueOf(localb.B()));
        localContentValues.put("flags", Integer.valueOf(localb.A()));
        com.viber.provider.b localb1 = h();
        String[] arrayOfString = new String[1];
        arrayOfString[0] = Integer.toString(localb.e());
        localb1.a("stickers_packages", localContentValues, "_id = ?", arrayOfString);
      }
    }
    finally
    {
      h().b();
    }
    h().c();
    h().b();
  }

  public List<com.viber.voip.stickers.entity.b> c()
  {
    return a(null, null);
  }

  public List<Sticker> c(int paramInt)
  {
    com.viber.provider.b localb = h();
    String[] arrayOfString1 = b;
    String[] arrayOfString2 = new String[1];
    arrayOfString2[0] = String.valueOf(paramInt);
    Cursor localCursor = localb.a("stickers", arrayOfString1, "package_id=?", arrayOfString2, null, null, "_id");
    ArrayList localArrayList = new ArrayList(localCursor.getCount());
    if ((!af.b(localCursor)) && (localCursor.getCount() > 0) && (localCursor.moveToFirst()))
      do
        localArrayList.add(a(localCursor));
      while (localCursor.moveToNext());
    af.a(localCursor);
    return localArrayList;
  }

  public List<com.viber.voip.stickers.entity.b> d()
  {
    return a("flags & ? > 0", new String[] { Integer.toString(av.a(0, new int[] { 9 })) });
  }

  public void d(int paramInt)
  {
    if (paramInt <= 0)
      return;
    String str = Integer.toString(paramInt);
    h().a("UPDATE stickers_packages SET menu_position = menu_position + 1 WHERE _id != ? AND flags & (1 << 6) = 0 AND flags & (1 << 3) = 0", new String[] { str });
  }

  public List<com.viber.voip.stickers.entity.b> e()
  {
    return a("flags & 64 = 0 AND flags & 8 = 0", null);
  }

  public boolean e(int paramInt)
  {
    com.viber.provider.b localb = h();
    String[] arrayOfString1 = { "*" };
    String[] arrayOfString2 = new String[1];
    arrayOfString2[0] = String.valueOf(paramInt);
    Cursor localCursor = localb.a("stickers_packages", arrayOfString1, "stickers_packages._id=?", arrayOfString2, null, null, null);
    if ((localCursor != null) && (localCursor.getCount() > 0));
    for (boolean bool = true; ; bool = false)
    {
      af.a(localCursor);
      return bool;
    }
  }

  public int f(int paramInt)
  {
    com.viber.provider.b localb = h();
    String[] arrayOfString = new String[1];
    arrayOfString[0] = String.valueOf(paramInt);
    return localb.a("stickers_packages", "_id=?", arrayOfString);
  }

  public String f()
  {
    Cursor localCursor = h().a("stickers_packages", new String[] { "_id", "package_info", "flags" }, null, null, null, null, null);
    try
    {
      if ((!af.b(localCursor)) && (localCursor.moveToFirst()))
      {
        StringBuilder localStringBuilder = new StringBuilder(localCursor.getCount());
        do
        {
          com.viber.voip.stickers.entity.b localb = new com.viber.voip.stickers.entity.b(localCursor.getInt(0), localCursor.getString(1));
          localb.a(localCursor.getInt(2));
          if ((!localb.h()) && (localb.g()))
            localStringBuilder.append(String.valueOf(localb.e())).append(",");
        }
        while (localCursor.moveToNext());
        if (localStringBuilder.length() > 0)
          localStringBuilder.deleteCharAt(-1 + localStringBuilder.length());
        String str = localStringBuilder.toString();
        return str;
      }
      return null;
    }
    finally
    {
      af.a(localCursor);
    }
  }

  // ERROR //
  public void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 49	com/viber/voip/stickers/b/a:h	()Lcom/viber/provider/b;
    //   4: astore_1
    //   5: aload_1
    //   6: invokeinterface 346 1 0
    //   11: aload_1
    //   12: ldc_w 420
    //   15: invokeinterface 423 2 0
    //   20: aload_1
    //   21: invokeinterface 354 1 0
    //   26: aload_1
    //   27: invokeinterface 356 1 0
    //   32: return
    //   33: astore_3
    //   34: aload_1
    //   35: invokeinterface 356 1 0
    //   40: return
    //   41: astore_2
    //   42: aload_1
    //   43: invokeinterface 356 1 0
    //   48: aload_2
    //   49: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   11	26	33	java/lang/Exception
    //   11	26	41	finally
  }

  // ERROR //
  public void g(int paramInt)
  {
    // Byte code:
    //   0: iload_1
    //   1: ifgt +4 -> 5
    //   4: return
    //   5: iload_1
    //   6: invokestatic 252	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   9: astore_2
    //   10: aload_0
    //   11: invokespecial 49	com/viber/voip/stickers/b/a:h	()Lcom/viber/provider/b;
    //   14: astore_3
    //   15: aload_3
    //   16: invokeinterface 346 1 0
    //   21: aload_3
    //   22: ldc_w 425
    //   25: iconst_3
    //   26: anewarray 21	java/lang/String
    //   29: dup
    //   30: iconst_0
    //   31: aload_2
    //   32: aastore
    //   33: dup
    //   34: iconst_1
    //   35: aload_2
    //   36: aastore
    //   37: dup
    //   38: iconst_2
    //   39: aload_2
    //   40: aastore
    //   41: invokeinterface 393 3 0
    //   46: aload_3
    //   47: ldc_w 427
    //   50: iconst_1
    //   51: anewarray 21	java/lang/String
    //   54: dup
    //   55: iconst_0
    //   56: aload_2
    //   57: aastore
    //   58: invokeinterface 393 3 0
    //   63: aload_3
    //   64: invokeinterface 354 1 0
    //   69: aload_3
    //   70: invokeinterface 356 1 0
    //   75: return
    //   76: astore 5
    //   78: aload_3
    //   79: invokeinterface 356 1 0
    //   84: return
    //   85: astore 4
    //   87: aload_3
    //   88: invokeinterface 356 1 0
    //   93: aload 4
    //   95: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   21	69	76	java/lang/Exception
    //   21	69	85	finally
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.stickers.b.a
 * JD-Core Version:    0.6.2
 */