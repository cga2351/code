package androidx.work.impl;

import android.arch.persistence.a.c.b;
import android.arch.persistence.a.c.b.a;
import android.arch.persistence.a.c.c;
import android.arch.persistence.room.a;
import android.arch.persistence.room.b.b.a;
import android.arch.persistence.room.b.b.b;
import android.arch.persistence.room.b.b.d;
import android.arch.persistence.room.e.b;
import android.arch.persistence.room.g;
import android.arch.persistence.room.g.a;
import androidx.work.impl.b.e;
import androidx.work.impl.b.f;
import androidx.work.impl.b.h;
import androidx.work.impl.b.i;
import androidx.work.impl.b.k;
import androidx.work.impl.b.l;
import androidx.work.impl.b.n;
import androidx.work.impl.b.o;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class WorkDatabase_Impl extends WorkDatabase
{
  private volatile k d;
  private volatile androidx.work.impl.b.b e;
  private volatile n f;
  private volatile e g;
  private volatile h h;

  protected android.arch.persistence.a.c b(a parama)
  {
    g localg = new g(parama, new g.a(5)
    {
      public void a(android.arch.persistence.a.b paramAnonymousb)
      {
        paramAnonymousb.c("DROP TABLE IF EXISTS `Dependency`");
        paramAnonymousb.c("DROP TABLE IF EXISTS `WorkSpec`");
        paramAnonymousb.c("DROP TABLE IF EXISTS `WorkTag`");
        paramAnonymousb.c("DROP TABLE IF EXISTS `SystemIdInfo`");
        paramAnonymousb.c("DROP TABLE IF EXISTS `WorkName`");
      }

      public void b(android.arch.persistence.a.b paramAnonymousb)
      {
        paramAnonymousb.c("CREATE TABLE IF NOT EXISTS `Dependency` (`work_spec_id` TEXT NOT NULL, `prerequisite_id` TEXT NOT NULL, PRIMARY KEY(`work_spec_id`, `prerequisite_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`prerequisite_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        paramAnonymousb.c("CREATE  INDEX `index_Dependency_work_spec_id` ON `Dependency` (`work_spec_id`)");
        paramAnonymousb.c("CREATE  INDEX `index_Dependency_prerequisite_id` ON `Dependency` (`prerequisite_id`)");
        paramAnonymousb.c("CREATE TABLE IF NOT EXISTS `WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `period_start_time` INTEGER NOT NULL, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `required_network_type` INTEGER, `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB, PRIMARY KEY(`id`))");
        paramAnonymousb.c("CREATE  INDEX `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
        paramAnonymousb.c("CREATE TABLE IF NOT EXISTS `WorkTag` (`tag` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        paramAnonymousb.c("CREATE  INDEX `index_WorkTag_work_spec_id` ON `WorkTag` (`work_spec_id`)");
        paramAnonymousb.c("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        paramAnonymousb.c("CREATE TABLE IF NOT EXISTS `WorkName` (`name` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`name`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        paramAnonymousb.c("CREATE  INDEX `index_WorkName_work_spec_id` ON `WorkName` (`work_spec_id`)");
        paramAnonymousb.c("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        paramAnonymousb.c("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"c84d23ade98552f1cec71088c1f0794c\")");
      }

      public void c(android.arch.persistence.a.b paramAnonymousb)
      {
        WorkDatabase_Impl.a(WorkDatabase_Impl.this, paramAnonymousb);
        paramAnonymousb.c("PRAGMA foreign_keys = ON");
        WorkDatabase_Impl.b(WorkDatabase_Impl.this, paramAnonymousb);
        if (WorkDatabase_Impl.d(WorkDatabase_Impl.this) != null)
        {
          int i = WorkDatabase_Impl.e(WorkDatabase_Impl.this).size();
          for (int j = 0; j < i; j++)
            ((e.b)WorkDatabase_Impl.f(WorkDatabase_Impl.this).get(j)).b(paramAnonymousb);
        }
      }

      protected void d(android.arch.persistence.a.b paramAnonymousb)
      {
        if (WorkDatabase_Impl.a(WorkDatabase_Impl.this) != null)
        {
          int i = WorkDatabase_Impl.b(WorkDatabase_Impl.this).size();
          for (int j = 0; j < i; j++)
            ((e.b)WorkDatabase_Impl.c(WorkDatabase_Impl.this).get(j)).a(paramAnonymousb);
        }
      }

      protected void e(android.arch.persistence.a.b paramAnonymousb)
      {
        HashMap localHashMap1 = new HashMap(2);
        localHashMap1.put("work_spec_id", new b.a("work_spec_id", "TEXT", true, 1));
        localHashMap1.put("prerequisite_id", new b.a("prerequisite_id", "TEXT", true, 2));
        HashSet localHashSet1 = new HashSet(2);
        localHashSet1.add(new b.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[] { "work_spec_id" }), Arrays.asList(new String[] { "id" })));
        localHashSet1.add(new b.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[] { "prerequisite_id" }), Arrays.asList(new String[] { "id" })));
        HashSet localHashSet2 = new HashSet(2);
        localHashSet2.add(new b.d("index_Dependency_work_spec_id", false, Arrays.asList(new String[] { "work_spec_id" })));
        localHashSet2.add(new b.d("index_Dependency_prerequisite_id", false, Arrays.asList(new String[] { "prerequisite_id" })));
        android.arch.persistence.room.b.b localb1 = new android.arch.persistence.room.b.b("Dependency", localHashMap1, localHashSet1, localHashSet2);
        android.arch.persistence.room.b.b localb2 = android.arch.persistence.room.b.b.a(paramAnonymousb, "Dependency");
        if (!localb1.equals(localb2))
          throw new IllegalStateException("Migration didn't properly handle Dependency(androidx.work.impl.model.Dependency).\n Expected:\n" + localb1 + "\n Found:\n" + localb2);
        HashMap localHashMap2 = new HashMap(23);
        localHashMap2.put("id", new b.a("id", "TEXT", true, 1));
        localHashMap2.put("state", new b.a("state", "INTEGER", true, 0));
        localHashMap2.put("worker_class_name", new b.a("worker_class_name", "TEXT", true, 0));
        localHashMap2.put("input_merger_class_name", new b.a("input_merger_class_name", "TEXT", false, 0));
        localHashMap2.put("input", new b.a("input", "BLOB", true, 0));
        localHashMap2.put("output", new b.a("output", "BLOB", true, 0));
        localHashMap2.put("initial_delay", new b.a("initial_delay", "INTEGER", true, 0));
        localHashMap2.put("interval_duration", new b.a("interval_duration", "INTEGER", true, 0));
        localHashMap2.put("flex_duration", new b.a("flex_duration", "INTEGER", true, 0));
        localHashMap2.put("run_attempt_count", new b.a("run_attempt_count", "INTEGER", true, 0));
        localHashMap2.put("backoff_policy", new b.a("backoff_policy", "INTEGER", true, 0));
        localHashMap2.put("backoff_delay_duration", new b.a("backoff_delay_duration", "INTEGER", true, 0));
        localHashMap2.put("period_start_time", new b.a("period_start_time", "INTEGER", true, 0));
        localHashMap2.put("minimum_retention_duration", new b.a("minimum_retention_duration", "INTEGER", true, 0));
        localHashMap2.put("schedule_requested_at", new b.a("schedule_requested_at", "INTEGER", true, 0));
        localHashMap2.put("required_network_type", new b.a("required_network_type", "INTEGER", false, 0));
        localHashMap2.put("requires_charging", new b.a("requires_charging", "INTEGER", true, 0));
        localHashMap2.put("requires_device_idle", new b.a("requires_device_idle", "INTEGER", true, 0));
        localHashMap2.put("requires_battery_not_low", new b.a("requires_battery_not_low", "INTEGER", true, 0));
        localHashMap2.put("requires_storage_not_low", new b.a("requires_storage_not_low", "INTEGER", true, 0));
        localHashMap2.put("trigger_content_update_delay", new b.a("trigger_content_update_delay", "INTEGER", true, 0));
        localHashMap2.put("trigger_max_content_delay", new b.a("trigger_max_content_delay", "INTEGER", true, 0));
        localHashMap2.put("content_uri_triggers", new b.a("content_uri_triggers", "BLOB", false, 0));
        HashSet localHashSet3 = new HashSet(0);
        HashSet localHashSet4 = new HashSet(1);
        localHashSet4.add(new b.d("index_WorkSpec_schedule_requested_at", false, Arrays.asList(new String[] { "schedule_requested_at" })));
        android.arch.persistence.room.b.b localb3 = new android.arch.persistence.room.b.b("WorkSpec", localHashMap2, localHashSet3, localHashSet4);
        android.arch.persistence.room.b.b localb4 = android.arch.persistence.room.b.b.a(paramAnonymousb, "WorkSpec");
        if (!localb3.equals(localb4))
          throw new IllegalStateException("Migration didn't properly handle WorkSpec(androidx.work.impl.model.WorkSpec).\n Expected:\n" + localb3 + "\n Found:\n" + localb4);
        HashMap localHashMap3 = new HashMap(2);
        localHashMap3.put("tag", new b.a("tag", "TEXT", true, 1));
        localHashMap3.put("work_spec_id", new b.a("work_spec_id", "TEXT", true, 2));
        HashSet localHashSet5 = new HashSet(1);
        localHashSet5.add(new b.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[] { "work_spec_id" }), Arrays.asList(new String[] { "id" })));
        HashSet localHashSet6 = new HashSet(1);
        localHashSet6.add(new b.d("index_WorkTag_work_spec_id", false, Arrays.asList(new String[] { "work_spec_id" })));
        android.arch.persistence.room.b.b localb5 = new android.arch.persistence.room.b.b("WorkTag", localHashMap3, localHashSet5, localHashSet6);
        android.arch.persistence.room.b.b localb6 = android.arch.persistence.room.b.b.a(paramAnonymousb, "WorkTag");
        if (!localb5.equals(localb6))
          throw new IllegalStateException("Migration didn't properly handle WorkTag(androidx.work.impl.model.WorkTag).\n Expected:\n" + localb5 + "\n Found:\n" + localb6);
        HashMap localHashMap4 = new HashMap(2);
        localHashMap4.put("work_spec_id", new b.a("work_spec_id", "TEXT", true, 1));
        localHashMap4.put("system_id", new b.a("system_id", "INTEGER", true, 0));
        HashSet localHashSet7 = new HashSet(1);
        localHashSet7.add(new b.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[] { "work_spec_id" }), Arrays.asList(new String[] { "id" })));
        android.arch.persistence.room.b.b localb7 = new android.arch.persistence.room.b.b("SystemIdInfo", localHashMap4, localHashSet7, new HashSet(0));
        android.arch.persistence.room.b.b localb8 = android.arch.persistence.room.b.b.a(paramAnonymousb, "SystemIdInfo");
        if (!localb7.equals(localb8))
          throw new IllegalStateException("Migration didn't properly handle SystemIdInfo(androidx.work.impl.model.SystemIdInfo).\n Expected:\n" + localb7 + "\n Found:\n" + localb8);
        HashMap localHashMap5 = new HashMap(2);
        localHashMap5.put("name", new b.a("name", "TEXT", true, 1));
        localHashMap5.put("work_spec_id", new b.a("work_spec_id", "TEXT", true, 2));
        HashSet localHashSet8 = new HashSet(1);
        localHashSet8.add(new b.b("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[] { "work_spec_id" }), Arrays.asList(new String[] { "id" })));
        HashSet localHashSet9 = new HashSet(1);
        localHashSet9.add(new b.d("index_WorkName_work_spec_id", false, Arrays.asList(new String[] { "work_spec_id" })));
        android.arch.persistence.room.b.b localb9 = new android.arch.persistence.room.b.b("WorkName", localHashMap5, localHashSet8, localHashSet9);
        android.arch.persistence.room.b.b localb10 = android.arch.persistence.room.b.b.a(paramAnonymousb, "WorkName");
        if (!localb9.equals(localb10))
          throw new IllegalStateException("Migration didn't properly handle WorkName(androidx.work.impl.model.WorkName).\n Expected:\n" + localb9 + "\n Found:\n" + localb10);
      }
    }
    , "c84d23ade98552f1cec71088c1f0794c", "1db8206f0da6aa81bbdd2d99a82d9e14");
    c.b localb = c.b.a(parama.b).a(parama.c).a(localg).a();
    return parama.a.a(localb);
  }

  protected android.arch.persistence.room.c c()
  {
    return new android.arch.persistence.room.c(this, new String[] { "Dependency", "WorkSpec", "WorkTag", "SystemIdInfo", "WorkName" });
  }

  public k m()
  {
    if (this.d != null)
      return this.d;
    try
    {
      if (this.d == null)
        this.d = new l(this);
      k localk = this.d;
      return localk;
    }
    finally
    {
    }
  }

  public androidx.work.impl.b.b n()
  {
    if (this.e != null)
      return this.e;
    try
    {
      if (this.e == null)
        this.e = new androidx.work.impl.b.c(this);
      androidx.work.impl.b.b localb = this.e;
      return localb;
    }
    finally
    {
    }
  }

  public n o()
  {
    if (this.f != null)
      return this.f;
    try
    {
      if (this.f == null)
        this.f = new o(this);
      n localn = this.f;
      return localn;
    }
    finally
    {
    }
  }

  public e p()
  {
    if (this.g != null)
      return this.g;
    try
    {
      if (this.g == null)
        this.g = new f(this);
      e locale = this.g;
      return locale;
    }
    finally
    {
    }
  }

  public h q()
  {
    if (this.h != null)
      return this.h;
    try
    {
      if (this.h == null)
        this.h = new i(this);
      h localh = this.h;
      return localh;
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.WorkDatabase_Impl
 * JD-Core Version:    0.6.2
 */