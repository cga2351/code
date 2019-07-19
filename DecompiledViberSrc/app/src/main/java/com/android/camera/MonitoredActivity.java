package com.android.camera;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;

public class MonitoredActivity extends NoSearchActivity
{
  private final ArrayList<b> a = new ArrayList();

  public void a(b paramb)
  {
    if (this.a.contains(paramb))
      return;
    this.a.add(paramb);
  }

  public void b(b paramb)
  {
    this.a.remove(paramb);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).a(this);
  }

  protected void onDestroy()
  {
    super.onDestroy();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).b(this);
  }

  protected void onStart()
  {
    super.onStart();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).c(this);
  }

  protected void onStop()
  {
    super.onStop();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).d(this);
  }

  public static class a
    implements MonitoredActivity.b
  {
    public void a(MonitoredActivity paramMonitoredActivity)
    {
    }

    public void b(MonitoredActivity paramMonitoredActivity)
    {
    }

    public void c(MonitoredActivity paramMonitoredActivity)
    {
    }

    public void d(MonitoredActivity paramMonitoredActivity)
    {
    }
  }

  public static abstract interface b
  {
    public abstract void a(MonitoredActivity paramMonitoredActivity);

    public abstract void b(MonitoredActivity paramMonitoredActivity);

    public abstract void c(MonitoredActivity paramMonitoredActivity);

    public abstract void d(MonitoredActivity paramMonitoredActivity);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.android.camera.MonitoredActivity
 * JD-Core Version:    0.6.2
 */