package androidx.work.impl.b;

import android.arch.persistence.a.f;
import android.arch.persistence.room.b;
import android.arch.persistence.room.b.a;
import android.arch.persistence.room.h;
import android.arch.persistence.room.i;
import android.database.Cursor;
import android.support.v4.util.ArrayMap;
import androidx.work.c;
import androidx.work.o.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class l
  implements k
{
  private final android.arch.persistence.room.e a;
  private final b b;
  private final i c;
  private final i d;
  private final i e;
  private final i f;
  private final i g;
  private final i h;
  private final i i;
  private final i j;

  public l(android.arch.persistence.room.e parame)
  {
    this.a = parame;
    this.b = new b(parame)
    {
      public String a()
      {
        return "INSERT OR IGNORE INTO `WorkSpec`(`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`period_start_time`,`minimum_retention_duration`,`schedule_requested_at`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      public void a(f paramAnonymousf, j paramAnonymousj)
      {
        int i = 1;
        label45: label59: byte[] arrayOfByte1;
        label80: byte[] arrayOfByte2;
        label102: c localc;
        int j;
        label254: int k;
        label276: int m;
        if (paramAnonymousj.a == null)
        {
          paramAnonymousf.a(i);
          paramAnonymousf.a(2, p.a(paramAnonymousj.b));
          if (paramAnonymousj.c != null)
            break label391;
          paramAnonymousf.a(3);
          if (paramAnonymousj.d != null)
            break label405;
          paramAnonymousf.a(4);
          arrayOfByte1 = androidx.work.e.a(paramAnonymousj.e);
          if (arrayOfByte1 != null)
            break label419;
          paramAnonymousf.a(5);
          arrayOfByte2 = androidx.work.e.a(paramAnonymousj.f);
          if (arrayOfByte2 != null)
            break label431;
          paramAnonymousf.a(6);
          paramAnonymousf.a(7, paramAnonymousj.g);
          paramAnonymousf.a(8, paramAnonymousj.h);
          paramAnonymousf.a(9, paramAnonymousj.i);
          paramAnonymousf.a(10, paramAnonymousj.k);
          paramAnonymousf.a(11, p.a(paramAnonymousj.l));
          paramAnonymousf.a(12, paramAnonymousj.m);
          paramAnonymousf.a(13, paramAnonymousj.n);
          paramAnonymousf.a(14, paramAnonymousj.o);
          paramAnonymousf.a(15, paramAnonymousj.p);
          localc = paramAnonymousj.j;
          if (localc == null)
            break label478;
          paramAnonymousf.a(16, p.a(localc.a()));
          if (!localc.b())
            break label444;
          j = i;
          paramAnonymousf.a(17, j);
          if (!localc.c())
            break label450;
          k = i;
          paramAnonymousf.a(18, k);
          if (!localc.d())
            break label456;
          m = i;
          label298: paramAnonymousf.a(19, m);
          if (!localc.e())
            break label462;
        }
        byte[] arrayOfByte3;
        while (true)
        {
          paramAnonymousf.a(20, i);
          paramAnonymousf.a(21, localc.f());
          paramAnonymousf.a(22, localc.g());
          arrayOfByte3 = p.a(localc.h());
          if (arrayOfByte3 != null)
            break label467;
          paramAnonymousf.a(23);
          return;
          paramAnonymousf.a(i, paramAnonymousj.a);
          break;
          label391: paramAnonymousf.a(3, paramAnonymousj.c);
          break label45;
          label405: paramAnonymousf.a(4, paramAnonymousj.d);
          break label59;
          label419: paramAnonymousf.a(5, arrayOfByte1);
          break label80;
          label431: paramAnonymousf.a(6, arrayOfByte2);
          break label102;
          label444: j = 0;
          break label254;
          label450: k = 0;
          break label276;
          label456: m = 0;
          break label298;
          label462: i = 0;
        }
        label467: paramAnonymousf.a(23, arrayOfByte3);
        return;
        label478: paramAnonymousf.a(16);
        paramAnonymousf.a(17);
        paramAnonymousf.a(18);
        paramAnonymousf.a(19);
        paramAnonymousf.a(20);
        paramAnonymousf.a(21);
        paramAnonymousf.a(22);
        paramAnonymousf.a(23);
      }
    };
    this.c = new i(parame)
    {
      public String a()
      {
        return "DELETE FROM workspec WHERE id=?";
      }
    };
    this.d = new i(parame)
    {
      public String a()
      {
        return "UPDATE workspec SET output=? WHERE id=?";
      }
    };
    this.e = new i(parame)
    {
      public String a()
      {
        return "UPDATE workspec SET period_start_time=? WHERE id=?";
      }
    };
    this.f = new i(parame)
    {
      public String a()
      {
        return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
      }
    };
    this.g = new i(parame)
    {
      public String a()
      {
        return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
      }
    };
    this.h = new i(parame)
    {
      public String a()
      {
        return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
      }
    };
    this.i = new i(parame)
    {
      public String a()
      {
        return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
      }
    };
    this.j = new i(parame)
    {
      public String a()
      {
        return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
      }
    };
  }

  private void a(ArrayMap<String, ArrayList<String>> paramArrayMap)
  {
    Set localSet = paramArrayMap.keySet();
    if (localSet.isEmpty());
    ArrayMap localArrayMap2;
    int n;
    do
    {
      return;
      if (paramArrayMap.size() <= 999)
        break;
      ArrayMap localArrayMap1 = new ArrayMap(999);
      int k = paramArrayMap.size();
      int m = 0;
      localArrayMap2 = localArrayMap1;
      n = 0;
      while (m < k)
      {
        localArrayMap2.put(paramArrayMap.keyAt(m), paramArrayMap.valueAt(m));
        m++;
        n++;
        if (n == 999)
        {
          a(localArrayMap2);
          localArrayMap2 = new ArrayMap(999);
          n = 0;
        }
      }
    }
    while (n <= 0);
    a(localArrayMap2);
    return;
    StringBuilder localStringBuilder = a.a();
    localStringBuilder.append("SELECT `tag`,`work_spec_id` FROM `WorkTag` WHERE `work_spec_id` IN (");
    int i1 = localSet.size();
    a.a(localStringBuilder, i1);
    localStringBuilder.append(")");
    h localh = h.a(localStringBuilder.toString(), i1 + 0);
    Iterator localIterator = localSet.iterator();
    int i2 = 1;
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (str == null)
        localh.a(i2);
      while (true)
      {
        i2++;
        break;
        localh.a(i2, str);
      }
    }
    Cursor localCursor = this.a.a(localh);
    try
    {
      int i3 = localCursor.getColumnIndex("work_spec_id");
      if (i3 == -1)
        return;
      while (localCursor.moveToNext())
        if (!localCursor.isNull(i3))
        {
          ArrayList localArrayList = (ArrayList)paramArrayMap.get(localCursor.getString(i3));
          if (localArrayList != null)
            localArrayList.add(localCursor.getString(0));
        }
    }
    finally
    {
      localCursor.close();
    }
    localCursor.close();
  }

  public int a(o.a parama, String[] paramArrayOfString)
  {
    StringBuilder localStringBuilder = a.a();
    localStringBuilder.append("UPDATE workspec SET state=");
    localStringBuilder.append("?");
    localStringBuilder.append(" WHERE id IN (");
    a.a(localStringBuilder, paramArrayOfString.length);
    localStringBuilder.append(")");
    String str1 = localStringBuilder.toString();
    f localf = this.a.a(str1);
    localf.a(1, p.a(parama));
    int k = 2;
    int m = paramArrayOfString.length;
    int n = 0;
    if (n < m)
    {
      String str2 = paramArrayOfString[n];
      if (str2 == null)
        localf.a(k);
      while (true)
      {
        k++;
        n++;
        break;
        localf.a(k, str2);
      }
    }
    this.a.f();
    try
    {
      int i1 = localf.a();
      this.a.h();
      return i1;
    }
    finally
    {
      this.a.g();
    }
  }

  public List<String> a()
  {
    h localh = h.a("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5)", 0);
    Cursor localCursor = this.a.a(localh);
    ArrayList localArrayList;
    try
    {
      localArrayList = new ArrayList(localCursor.getCount());
      while (localCursor.moveToNext())
        localArrayList.add(localCursor.getString(0));
    }
    finally
    {
      localCursor.close();
      localh.b();
    }
    localCursor.close();
    localh.b();
    return localArrayList;
  }

  public List<j> a(int paramInt)
  {
    h localh = h.a("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))", 1);
    localh.a(1, paramInt);
    Cursor localCursor = this.a.a(localh);
    ArrayList localArrayList;
    while (true)
    {
      try
      {
        int k = localCursor.getColumnIndexOrThrow("id");
        int m = localCursor.getColumnIndexOrThrow("state");
        int n = localCursor.getColumnIndexOrThrow("worker_class_name");
        int i1 = localCursor.getColumnIndexOrThrow("input_merger_class_name");
        int i2 = localCursor.getColumnIndexOrThrow("input");
        int i3 = localCursor.getColumnIndexOrThrow("output");
        int i4 = localCursor.getColumnIndexOrThrow("initial_delay");
        int i5 = localCursor.getColumnIndexOrThrow("interval_duration");
        int i6 = localCursor.getColumnIndexOrThrow("flex_duration");
        int i7 = localCursor.getColumnIndexOrThrow("run_attempt_count");
        int i8 = localCursor.getColumnIndexOrThrow("backoff_policy");
        int i9 = localCursor.getColumnIndexOrThrow("backoff_delay_duration");
        int i10 = localCursor.getColumnIndexOrThrow("period_start_time");
        int i11 = localCursor.getColumnIndexOrThrow("minimum_retention_duration");
        int i12 = localCursor.getColumnIndexOrThrow("schedule_requested_at");
        int i13 = localCursor.getColumnIndexOrThrow("required_network_type");
        int i14 = localCursor.getColumnIndexOrThrow("requires_charging");
        int i15 = localCursor.getColumnIndexOrThrow("requires_device_idle");
        int i16 = localCursor.getColumnIndexOrThrow("requires_battery_not_low");
        int i17 = localCursor.getColumnIndexOrThrow("requires_storage_not_low");
        int i18 = localCursor.getColumnIndexOrThrow("trigger_content_update_delay");
        int i19 = localCursor.getColumnIndexOrThrow("trigger_max_content_delay");
        int i20 = localCursor.getColumnIndexOrThrow("content_uri_triggers");
        localArrayList = new ArrayList(localCursor.getCount());
        if (!localCursor.moveToNext())
          break;
        String str1 = localCursor.getString(k);
        String str2 = localCursor.getString(n);
        c localc = new c();
        localc.a(p.c(localCursor.getInt(i13)));
        if (localCursor.getInt(i14) != 0)
        {
          bool1 = true;
          localc.a(bool1);
          if (localCursor.getInt(i15) == 0)
            break label699;
          bool2 = true;
          localc.b(bool2);
          if (localCursor.getInt(i16) == 0)
            break label705;
          bool3 = true;
          localc.c(bool3);
          if (localCursor.getInt(i17) == 0)
            break label711;
          bool4 = true;
          localc.d(bool4);
          localc.a(localCursor.getLong(i18));
          localc.b(localCursor.getLong(i19));
          localc.a(p.a(localCursor.getBlob(i20)));
          j localj = new j(str1, str2);
          localj.b = p.a(localCursor.getInt(m));
          localj.d = localCursor.getString(i1);
          localj.e = androidx.work.e.a(localCursor.getBlob(i2));
          localj.f = androidx.work.e.a(localCursor.getBlob(i3));
          localj.g = localCursor.getLong(i4);
          localj.h = localCursor.getLong(i5);
          localj.i = localCursor.getLong(i6);
          localj.k = localCursor.getInt(i7);
          localj.l = p.b(localCursor.getInt(i8));
          localj.m = localCursor.getLong(i9);
          localj.n = localCursor.getLong(i10);
          localj.o = localCursor.getLong(i11);
          localj.p = localCursor.getLong(i12);
          localj.j = localc;
          localArrayList.add(localj);
          continue;
        }
      }
      finally
      {
        localCursor.close();
        localh.b();
      }
      boolean bool1 = false;
      continue;
      label699: boolean bool2 = false;
      continue;
      label705: boolean bool3 = false;
      continue;
      label711: boolean bool4 = false;
    }
    localCursor.close();
    localh.b();
    return localArrayList;
  }

  public void a(j paramj)
  {
    this.a.f();
    try
    {
      this.b.a(paramj);
      this.a.h();
      return;
    }
    finally
    {
      this.a.g();
    }
  }

  public void a(String paramString)
  {
    f localf = this.c.c();
    this.a.f();
    if (paramString == null);
    try
    {
      localf.a(1);
      while (true)
      {
        localf.a();
        this.a.h();
        return;
        localf.a(1, paramString);
      }
    }
    finally
    {
      this.a.g();
      this.c.a(localf);
    }
  }

  public void a(String paramString, long paramLong)
  {
    f localf = this.e.c();
    this.a.f();
    try
    {
      localf.a(1, paramLong);
      if (paramString == null)
        localf.a(2);
      while (true)
      {
        localf.a();
        this.a.h();
        return;
        localf.a(2, paramString);
      }
    }
    finally
    {
      this.a.g();
      this.e.a(localf);
    }
  }

  public void a(String paramString, androidx.work.e parame)
  {
    f localf = this.d.c();
    this.a.f();
    while (true)
    {
      try
      {
        byte[] arrayOfByte = androidx.work.e.a(parame);
        if (arrayOfByte == null)
        {
          localf.a(1);
          if (paramString == null)
          {
            localf.a(2);
            localf.a();
            this.a.h();
          }
        }
        else
        {
          localf.a(1, arrayOfByte);
          continue;
        }
      }
      finally
      {
        this.a.g();
        this.d.a(localf);
      }
      localf.a(2, paramString);
    }
  }

  public int b()
  {
    f localf = this.i.c();
    this.a.f();
    try
    {
      int k = localf.a();
      this.a.h();
      return k;
    }
    finally
    {
      this.a.g();
      this.i.a(localf);
    }
  }

  public int b(String paramString, long paramLong)
  {
    f localf = this.h.c();
    this.a.f();
    try
    {
      localf.a(1, paramLong);
      if (paramString == null)
        localf.a(2);
      while (true)
      {
        int k = localf.a();
        this.a.h();
        return k;
        localf.a(2, paramString);
      }
    }
    finally
    {
      this.a.g();
      this.h.a(localf);
    }
  }

  public j b(String paramString)
  {
    h localh = h.a("SELECT * FROM workspec WHERE id=?", 1);
    if (paramString == null)
      localh.a(1);
    while (true)
    {
      Cursor localCursor = this.a.a(localh);
      try
      {
        int k = localCursor.getColumnIndexOrThrow("id");
        int m = localCursor.getColumnIndexOrThrow("state");
        int n = localCursor.getColumnIndexOrThrow("worker_class_name");
        int i1 = localCursor.getColumnIndexOrThrow("input_merger_class_name");
        int i2 = localCursor.getColumnIndexOrThrow("input");
        int i3 = localCursor.getColumnIndexOrThrow("output");
        int i4 = localCursor.getColumnIndexOrThrow("initial_delay");
        int i5 = localCursor.getColumnIndexOrThrow("interval_duration");
        int i6 = localCursor.getColumnIndexOrThrow("flex_duration");
        int i7 = localCursor.getColumnIndexOrThrow("run_attempt_count");
        int i8 = localCursor.getColumnIndexOrThrow("backoff_policy");
        int i9 = localCursor.getColumnIndexOrThrow("backoff_delay_duration");
        int i10 = localCursor.getColumnIndexOrThrow("period_start_time");
        int i11 = localCursor.getColumnIndexOrThrow("minimum_retention_duration");
        int i12 = localCursor.getColumnIndexOrThrow("schedule_requested_at");
        int i13 = localCursor.getColumnIndexOrThrow("required_network_type");
        int i14 = localCursor.getColumnIndexOrThrow("requires_charging");
        int i15 = localCursor.getColumnIndexOrThrow("requires_device_idle");
        int i16 = localCursor.getColumnIndexOrThrow("requires_battery_not_low");
        int i17 = localCursor.getColumnIndexOrThrow("requires_storage_not_low");
        int i18 = localCursor.getColumnIndexOrThrow("trigger_content_update_delay");
        int i19 = localCursor.getColumnIndexOrThrow("trigger_max_content_delay");
        int i20 = localCursor.getColumnIndexOrThrow("content_uri_triggers");
        boolean bool1;
        label340: boolean bool2;
        label361: boolean bool3;
        label382: boolean bool4;
        label403: j localj;
        if (localCursor.moveToFirst())
        {
          String str1 = localCursor.getString(k);
          String str2 = localCursor.getString(n);
          c localc = new c();
          localc.a(p.c(localCursor.getInt(i13)));
          if (localCursor.getInt(i14) != 0)
          {
            bool1 = true;
            localc.a(bool1);
            if (localCursor.getInt(i15) == 0)
              break label681;
            bool2 = true;
            localc.b(bool2);
            if (localCursor.getInt(i16) == 0)
              break label687;
            bool3 = true;
            localc.c(bool3);
            if (localCursor.getInt(i17) == 0)
              break label693;
            bool4 = true;
            localc.d(bool4);
            localc.a(localCursor.getLong(i18));
            localc.b(localCursor.getLong(i19));
            localc.a(p.a(localCursor.getBlob(i20)));
            localj = new j(str1, str2);
            localj.b = p.a(localCursor.getInt(m));
            localj.d = localCursor.getString(i1);
            localj.e = androidx.work.e.a(localCursor.getBlob(i2));
            localj.f = androidx.work.e.a(localCursor.getBlob(i3));
            localj.g = localCursor.getLong(i4);
            localj.h = localCursor.getLong(i5);
            localj.i = localCursor.getLong(i6);
            localj.k = localCursor.getInt(i7);
            localj.l = p.b(localCursor.getInt(i8));
            localj.m = localCursor.getLong(i9);
            localj.n = localCursor.getLong(i10);
            localj.o = localCursor.getLong(i11);
            localj.p = localCursor.getLong(i12);
            localj.j = localc;
          }
        }
        while (true)
        {
          return localj;
          localh.a(1, paramString);
          break;
          bool1 = false;
          break label340;
          label681: bool2 = false;
          break label361;
          label687: bool3 = false;
          break label382;
          label693: bool4 = false;
          break label403;
          localj = null;
        }
      }
      finally
      {
        localCursor.close();
        localh.b();
      }
    }
  }

  public List<j> c()
  {
    h localh = h.a("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
    Cursor localCursor = this.a.a(localh);
    ArrayList localArrayList;
    while (true)
    {
      try
      {
        int k = localCursor.getColumnIndexOrThrow("id");
        int m = localCursor.getColumnIndexOrThrow("state");
        int n = localCursor.getColumnIndexOrThrow("worker_class_name");
        int i1 = localCursor.getColumnIndexOrThrow("input_merger_class_name");
        int i2 = localCursor.getColumnIndexOrThrow("input");
        int i3 = localCursor.getColumnIndexOrThrow("output");
        int i4 = localCursor.getColumnIndexOrThrow("initial_delay");
        int i5 = localCursor.getColumnIndexOrThrow("interval_duration");
        int i6 = localCursor.getColumnIndexOrThrow("flex_duration");
        int i7 = localCursor.getColumnIndexOrThrow("run_attempt_count");
        int i8 = localCursor.getColumnIndexOrThrow("backoff_policy");
        int i9 = localCursor.getColumnIndexOrThrow("backoff_delay_duration");
        int i10 = localCursor.getColumnIndexOrThrow("period_start_time");
        int i11 = localCursor.getColumnIndexOrThrow("minimum_retention_duration");
        int i12 = localCursor.getColumnIndexOrThrow("schedule_requested_at");
        int i13 = localCursor.getColumnIndexOrThrow("required_network_type");
        int i14 = localCursor.getColumnIndexOrThrow("requires_charging");
        int i15 = localCursor.getColumnIndexOrThrow("requires_device_idle");
        int i16 = localCursor.getColumnIndexOrThrow("requires_battery_not_low");
        int i17 = localCursor.getColumnIndexOrThrow("requires_storage_not_low");
        int i18 = localCursor.getColumnIndexOrThrow("trigger_content_update_delay");
        int i19 = localCursor.getColumnIndexOrThrow("trigger_max_content_delay");
        int i20 = localCursor.getColumnIndexOrThrow("content_uri_triggers");
        localArrayList = new ArrayList(localCursor.getCount());
        if (!localCursor.moveToNext())
          break;
        String str1 = localCursor.getString(k);
        String str2 = localCursor.getString(n);
        c localc = new c();
        localc.a(p.c(localCursor.getInt(i13)));
        if (localCursor.getInt(i14) != 0)
        {
          bool1 = true;
          localc.a(bool1);
          if (localCursor.getInt(i15) == 0)
            break label691;
          bool2 = true;
          localc.b(bool2);
          if (localCursor.getInt(i16) == 0)
            break label697;
          bool3 = true;
          localc.c(bool3);
          if (localCursor.getInt(i17) == 0)
            break label703;
          bool4 = true;
          localc.d(bool4);
          localc.a(localCursor.getLong(i18));
          localc.b(localCursor.getLong(i19));
          localc.a(p.a(localCursor.getBlob(i20)));
          j localj = new j(str1, str2);
          localj.b = p.a(localCursor.getInt(m));
          localj.d = localCursor.getString(i1);
          localj.e = androidx.work.e.a(localCursor.getBlob(i2));
          localj.f = androidx.work.e.a(localCursor.getBlob(i3));
          localj.g = localCursor.getLong(i4);
          localj.h = localCursor.getLong(i5);
          localj.i = localCursor.getLong(i6);
          localj.k = localCursor.getInt(i7);
          localj.l = p.b(localCursor.getInt(i8));
          localj.m = localCursor.getLong(i9);
          localj.n = localCursor.getLong(i10);
          localj.o = localCursor.getLong(i11);
          localj.p = localCursor.getLong(i12);
          localj.j = localc;
          localArrayList.add(localj);
          continue;
        }
      }
      finally
      {
        localCursor.close();
        localh.b();
      }
      boolean bool1 = false;
      continue;
      label691: boolean bool2 = false;
      continue;
      label697: boolean bool3 = false;
      continue;
      label703: boolean bool4 = false;
    }
    localCursor.close();
    localh.b();
    return localArrayList;
  }

  public List<j.a> c(String paramString)
  {
    h localh = h.a("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
    if (paramString == null)
      localh.a(1);
    Cursor localCursor;
    ArrayList localArrayList;
    while (true)
    {
      localCursor = this.a.a(localh);
      try
      {
        int k = localCursor.getColumnIndexOrThrow("id");
        int m = localCursor.getColumnIndexOrThrow("state");
        localArrayList = new ArrayList(localCursor.getCount());
        while (localCursor.moveToNext())
        {
          j.a locala = new j.a();
          locala.a = localCursor.getString(k);
          locala.b = p.a(localCursor.getInt(m));
          localArrayList.add(locala);
        }
      }
      finally
      {
        localCursor.close();
        localh.b();
      }
      localh.a(1, paramString);
    }
    localCursor.close();
    localh.b();
    return localArrayList;
  }

  public int d(String paramString)
  {
    f localf = this.f.c();
    this.a.f();
    if (paramString == null);
    try
    {
      localf.a(1);
      while (true)
      {
        int k = localf.a();
        this.a.h();
        return k;
        localf.a(1, paramString);
      }
    }
    finally
    {
      this.a.g();
      this.f.a(localf);
    }
  }

  public List<j> d()
  {
    h localh = h.a("SELECT * FROM workspec WHERE state=0", 0);
    Cursor localCursor = this.a.a(localh);
    ArrayList localArrayList;
    while (true)
    {
      try
      {
        int k = localCursor.getColumnIndexOrThrow("id");
        int m = localCursor.getColumnIndexOrThrow("state");
        int n = localCursor.getColumnIndexOrThrow("worker_class_name");
        int i1 = localCursor.getColumnIndexOrThrow("input_merger_class_name");
        int i2 = localCursor.getColumnIndexOrThrow("input");
        int i3 = localCursor.getColumnIndexOrThrow("output");
        int i4 = localCursor.getColumnIndexOrThrow("initial_delay");
        int i5 = localCursor.getColumnIndexOrThrow("interval_duration");
        int i6 = localCursor.getColumnIndexOrThrow("flex_duration");
        int i7 = localCursor.getColumnIndexOrThrow("run_attempt_count");
        int i8 = localCursor.getColumnIndexOrThrow("backoff_policy");
        int i9 = localCursor.getColumnIndexOrThrow("backoff_delay_duration");
        int i10 = localCursor.getColumnIndexOrThrow("period_start_time");
        int i11 = localCursor.getColumnIndexOrThrow("minimum_retention_duration");
        int i12 = localCursor.getColumnIndexOrThrow("schedule_requested_at");
        int i13 = localCursor.getColumnIndexOrThrow("required_network_type");
        int i14 = localCursor.getColumnIndexOrThrow("requires_charging");
        int i15 = localCursor.getColumnIndexOrThrow("requires_device_idle");
        int i16 = localCursor.getColumnIndexOrThrow("requires_battery_not_low");
        int i17 = localCursor.getColumnIndexOrThrow("requires_storage_not_low");
        int i18 = localCursor.getColumnIndexOrThrow("trigger_content_update_delay");
        int i19 = localCursor.getColumnIndexOrThrow("trigger_max_content_delay");
        int i20 = localCursor.getColumnIndexOrThrow("content_uri_triggers");
        localArrayList = new ArrayList(localCursor.getCount());
        if (!localCursor.moveToNext())
          break;
        String str1 = localCursor.getString(k);
        String str2 = localCursor.getString(n);
        c localc = new c();
        localc.a(p.c(localCursor.getInt(i13)));
        if (localCursor.getInt(i14) != 0)
        {
          bool1 = true;
          localc.a(bool1);
          if (localCursor.getInt(i15) == 0)
            break label691;
          bool2 = true;
          localc.b(bool2);
          if (localCursor.getInt(i16) == 0)
            break label697;
          bool3 = true;
          localc.c(bool3);
          if (localCursor.getInt(i17) == 0)
            break label703;
          bool4 = true;
          localc.d(bool4);
          localc.a(localCursor.getLong(i18));
          localc.b(localCursor.getLong(i19));
          localc.a(p.a(localCursor.getBlob(i20)));
          j localj = new j(str1, str2);
          localj.b = p.a(localCursor.getInt(m));
          localj.d = localCursor.getString(i1);
          localj.e = androidx.work.e.a(localCursor.getBlob(i2));
          localj.f = androidx.work.e.a(localCursor.getBlob(i3));
          localj.g = localCursor.getLong(i4);
          localj.h = localCursor.getLong(i5);
          localj.i = localCursor.getLong(i6);
          localj.k = localCursor.getInt(i7);
          localj.l = p.b(localCursor.getInt(i8));
          localj.m = localCursor.getLong(i9);
          localj.n = localCursor.getLong(i10);
          localj.o = localCursor.getLong(i11);
          localj.p = localCursor.getLong(i12);
          localj.j = localc;
          localArrayList.add(localj);
          continue;
        }
      }
      finally
      {
        localCursor.close();
        localh.b();
      }
      boolean bool1 = false;
      continue;
      label691: boolean bool2 = false;
      continue;
      label697: boolean bool3 = false;
      continue;
      label703: boolean bool4 = false;
    }
    localCursor.close();
    localh.b();
    return localArrayList;
  }

  public int e(String paramString)
  {
    f localf = this.g.c();
    this.a.f();
    if (paramString == null);
    try
    {
      localf.a(1);
      while (true)
      {
        int k = localf.a();
        this.a.h();
        return k;
        localf.a(1, paramString);
      }
    }
    finally
    {
      this.a.g();
      this.g.a(localf);
    }
  }

  public o.a f(String paramString)
  {
    h localh = h.a("SELECT state FROM workspec WHERE id=?", 1);
    if (paramString == null)
      localh.a(1);
    while (true)
    {
      Cursor localCursor = this.a.a(localh);
      try
      {
        if (localCursor.moveToFirst())
        {
          o.a locala2 = p.a(localCursor.getInt(0));
          locala1 = locala2;
          return locala1;
          localh.a(1, paramString);
          continue;
        }
        o.a locala1 = null;
      }
      finally
      {
        localCursor.close();
        localh.b();
      }
    }
  }

  public List<j.b> g(String paramString)
  {
    h localh = h.a("SELECT id, state, output FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
    if (paramString == null)
      localh.a(1);
    Cursor localCursor;
    ArrayMap localArrayMap;
    ArrayList localArrayList1;
    while (true)
    {
      this.a.f();
      try
      {
        localCursor = this.a.a(localh);
        try
        {
          localArrayMap = new ArrayMap();
          int k = localCursor.getColumnIndexOrThrow("id");
          int m = localCursor.getColumnIndexOrThrow("state");
          int n = localCursor.getColumnIndexOrThrow("output");
          localArrayList1 = new ArrayList(localCursor.getCount());
          while (localCursor.moveToNext())
          {
            j.b localb = new j.b();
            localb.a = localCursor.getString(k);
            localb.b = p.a(localCursor.getInt(m));
            localb.c = androidx.work.e.a(localCursor.getBlob(n));
            if (!localCursor.isNull(k))
            {
              String str = localCursor.getString(k);
              ArrayList localArrayList2 = (ArrayList)localArrayMap.get(str);
              if (localArrayList2 == null)
              {
                localArrayList2 = new ArrayList();
                localArrayMap.put(str, localArrayList2);
              }
              localb.d = localArrayList2;
            }
            localArrayList1.add(localb);
          }
        }
        finally
        {
          localCursor.close();
          localh.b();
        }
      }
      finally
      {
        this.a.g();
      }
      localh.a(1, paramString);
    }
    a(localArrayMap);
    this.a.h();
    localCursor.close();
    localh.b();
    this.a.g();
    return localArrayList1;
  }

  public List<androidx.work.e> h(String paramString)
  {
    h localh = h.a("SELECT output FROM workspec WHERE id IN (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
    if (paramString == null)
      localh.a(1);
    Cursor localCursor;
    ArrayList localArrayList;
    while (true)
    {
      localCursor = this.a.a(localh);
      try
      {
        localArrayList = new ArrayList(localCursor.getCount());
        while (localCursor.moveToNext())
          localArrayList.add(androidx.work.e.a(localCursor.getBlob(0)));
      }
      finally
      {
        localCursor.close();
        localh.b();
      }
      localh.a(1, paramString);
    }
    localCursor.close();
    localh.b();
    return localArrayList;
  }

  public List<String> i(String paramString)
  {
    h localh = h.a("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
    if (paramString == null)
      localh.a(1);
    Cursor localCursor;
    ArrayList localArrayList;
    while (true)
    {
      localCursor = this.a.a(localh);
      try
      {
        localArrayList = new ArrayList(localCursor.getCount());
        while (localCursor.moveToNext())
          localArrayList.add(localCursor.getString(0));
      }
      finally
      {
        localCursor.close();
        localh.b();
      }
      localh.a(1, paramString);
    }
    localCursor.close();
    localh.b();
    return localArrayList;
  }

  public List<String> j(String paramString)
  {
    h localh = h.a("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
    if (paramString == null)
      localh.a(1);
    Cursor localCursor;
    ArrayList localArrayList;
    while (true)
    {
      localCursor = this.a.a(localh);
      try
      {
        localArrayList = new ArrayList(localCursor.getCount());
        while (localCursor.moveToNext())
          localArrayList.add(localCursor.getString(0));
      }
      finally
      {
        localCursor.close();
        localh.b();
      }
      localh.a(1, paramString);
    }
    localCursor.close();
    localh.b();
    return localArrayList;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.b.l
 * JD-Core Version:    0.6.2
 */