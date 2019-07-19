package com.yandex.metrica.impl;

import android.content.ContentValues;
import android.text.TextUtils;
import com.yandex.metrica.impl.ob.lq;
import com.yandex.metrica.impl.ob.nz.a;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

abstract class m extends at
{
  static final ContentValues a = new ContentValues();
  final Map<String, String> b = new LinkedHashMap();
  lq c;

  private void H()
  {
    this.c = new lq();
  }

  m a(ContentValues paramContentValues)
  {
    this.b.clear();
    Iterator localIterator = paramContentValues.valueSet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      this.b.put(localEntry.getKey(), localEntry.getValue().toString());
    }
    String str = paramContentValues.getAsString("report_request_parameters");
    if (!TextUtils.isEmpty(str))
      try
      {
        this.c = new lq(new nz.a(str));
        return this;
      }
      catch (Exception localException)
      {
        H();
        return this;
      }
    H();
    return this;
  }

  public String a()
  {
    return super.a() + " [" + this.b.toString() + "]";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.m
 * JD-Core Version:    0.6.2
 */