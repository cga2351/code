package com.google.android.gms.gcm;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

public class Task
  implements ReflectedParcelable
{
  public static final int EXTRAS_LIMIT_BYTES = 10240;
  public static final int NETWORK_STATE_ANY = 2;
  public static final int NETWORK_STATE_CONNECTED = 0;
  public static final int NETWORK_STATE_UNMETERED = 1;
  protected static final long UNINITIALIZED = -1L;
  private final Bundle extras;
  private final String gcmTaskService;
  private final boolean isPersisted;
  private final int requiredNetworkState;
  private final boolean requiresCharging;
  private final String tag;
  private final boolean updateCurrent;
  private final Set<Uri> zzaw;
  private final boolean zzax;
  private final zzl zzay;

  @Deprecated
  Task(Parcel paramParcel)
  {
    Log.e("Task", "Constructing a Task object using a parcel.");
    this.gcmTaskService = paramParcel.readString();
    this.tag = paramParcel.readString();
    int j;
    if (paramParcel.readInt() == i)
    {
      j = i;
      this.updateCurrent = j;
      if (paramParcel.readInt() != i)
        break label101;
    }
    while (true)
    {
      this.isPersisted = i;
      this.requiredNetworkState = 2;
      this.zzaw = Collections.emptySet();
      this.requiresCharging = false;
      this.zzax = false;
      this.zzay = zzl.zzaq;
      this.extras = null;
      return;
      j = 0;
      break;
      label101: i = 0;
    }
  }

  Task(Builder paramBuilder)
  {
    this.gcmTaskService = paramBuilder.gcmTaskService;
    this.tag = paramBuilder.tag;
    this.updateCurrent = paramBuilder.updateCurrent;
    this.isPersisted = paramBuilder.isPersisted;
    this.requiredNetworkState = paramBuilder.requiredNetworkState;
    this.zzaw = paramBuilder.zzaw;
    this.requiresCharging = paramBuilder.requiresCharging;
    this.zzax = false;
    this.extras = paramBuilder.extras;
    if (paramBuilder.zzay != null);
    for (zzl localzzl = paramBuilder.zzay; ; localzzl = zzl.zzaq)
    {
      this.zzay = localzzl;
      return;
    }
  }

  private static void zzd(Uri paramUri)
  {
    if (paramUri == null)
      throw new IllegalArgumentException("Null URI");
    String str1 = paramUri.getScheme();
    String str2 = paramUri.getHost();
    if ((TextUtils.isEmpty(str2)) || ("null".equals(str2)))
      throw new IllegalArgumentException("URI hostname is required");
    try
    {
      i = paramUri.getPort();
      if ("tcp".equals(str1))
      {
        if ((i > 0) && (i <= 65535))
          return;
        int j = paramUri.getPort();
        throw new IllegalArgumentException(38 + "Invalid required URI port: " + j);
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      int i;
      String str3 = String.valueOf(localNumberFormatException.getMessage());
      if (str3.length() != 0);
      for (String str4 = "Invalid port number: ".concat(str3); ; str4 = new String("Invalid port number: "))
        throw new IllegalArgumentException(str4);
      if ("ping".equals(str1))
      {
        if (i != -1)
          throw new IllegalArgumentException("Ping does not support port numbers");
      }
      else
      {
        String str5 = String.valueOf(str1);
        if (str5.length() != 0);
        for (String str6 = "Unsupported required URI scheme: ".concat(str5); ; str6 = new String("Unsupported required URI scheme: "))
          throw new IllegalArgumentException(str6);
      }
    }
  }

  public static void zzg(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      Parcel localParcel = Parcel.obtain();
      paramBundle.writeToParcel(localParcel, 0);
      int i = localParcel.dataSize();
      localParcel.recycle();
      if (i > 10240)
        throw new IllegalArgumentException(55 + "Extras exceeding maximum size(10240 bytes): " + i);
      Iterator localIterator = paramBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = paramBundle.get((String)localIterator.next());
        if (((localObject instanceof Integer)) || ((localObject instanceof Long)) || ((localObject instanceof Double)) || ((localObject instanceof String)) || ((localObject instanceof Boolean)));
        for (int j = 1; ; j = 0)
        {
          if (j != 0)
            break label164;
          if (!(localObject instanceof Bundle))
            break label166;
          zzg((Bundle)localObject);
          break;
        }
        label164: continue;
        label166: throw new IllegalArgumentException("Only the following extra parameter types are supported: Integer, Long, Double, String, Boolean, and nested Bundles with the same restrictions.");
      }
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public Bundle getExtras()
  {
    return this.extras;
  }

  public int getRequiredNetwork()
  {
    return this.requiredNetworkState;
  }

  public boolean getRequiresCharging()
  {
    return this.requiresCharging;
  }

  public String getServiceName()
  {
    return this.gcmTaskService;
  }

  public String getTag()
  {
    return this.tag;
  }

  public boolean isPersisted()
  {
    return this.isPersisted;
  }

  public boolean isUpdateCurrent()
  {
    return this.updateCurrent;
  }

  public void toBundle(Bundle paramBundle)
  {
    paramBundle.putString("tag", this.tag);
    paramBundle.putBoolean("update_current", this.updateCurrent);
    paramBundle.putBoolean("persisted", this.isPersisted);
    paramBundle.putString("service", this.gcmTaskService);
    paramBundle.putInt("requiredNetwork", this.requiredNetworkState);
    if (!this.zzaw.isEmpty())
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.zzaw.iterator();
      while (localIterator.hasNext())
        localArrayList.add(((Uri)localIterator.next()).toString());
      paramBundle.putStringArrayList("reachabilityUris", localArrayList);
    }
    paramBundle.putBoolean("requiresCharging", this.requiresCharging);
    paramBundle.putBoolean("requiresIdle", false);
    paramBundle.putBundle("retryStrategy", this.zzay.zzf(new Bundle()));
    paramBundle.putBundle("extras", this.extras);
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.gcmTaskService);
    paramParcel.writeString(this.tag);
    int j;
    if (this.updateCurrent)
    {
      j = i;
      paramParcel.writeInt(j);
      if (!this.isPersisted)
        break label53;
    }
    while (true)
    {
      paramParcel.writeInt(i);
      return;
      j = 0;
      break;
      label53: i = 0;
    }
  }

  public static abstract class Builder
  {
    protected Bundle extras;
    protected String gcmTaskService;
    protected boolean isPersisted;
    protected int requiredNetworkState;
    protected boolean requiresCharging;
    protected String tag;
    protected boolean updateCurrent;
    protected Set<Uri> zzaw = Collections.emptySet();

    @ShowFirstParty
    protected zzl zzay = zzl.zzaq;

    public abstract Task build();

    protected void checkConditions()
    {
      if (this.gcmTaskService != null);
      zzl localzzl;
      int i;
      for (boolean bool = true; ; bool = false)
      {
        Preconditions.checkArgument(bool, "Must provide an endpoint for this task by calling setService(ComponentName).");
        GcmNetworkManager.zzd(this.tag);
        localzzl = this.zzay;
        if (localzzl == null)
          break label201;
        i = localzzl.zzi();
        if ((i == 1) || (i == 0))
          break;
        throw new IllegalArgumentException(45 + "Must provide a valid RetryPolicy: " + i);
      }
      int j = localzzl.zzj();
      int k = localzzl.zzk();
      if ((i == 0) && (j < 0))
        throw new IllegalArgumentException(52 + "InitialBackoffSeconds can't be negative: " + j);
      if ((i == 1) && (j < 10))
        throw new IllegalArgumentException("RETRY_POLICY_LINEAR must have an initial backoff at least 10 seconds.");
      if (k < j)
      {
        int m = localzzl.zzk();
        throw new IllegalArgumentException(77 + "MaximumBackoffSeconds must be greater than InitialBackoffSeconds: " + m);
      }
      label201: if (this.isPersisted)
        Task.zzg(this.extras);
      if ((!this.zzaw.isEmpty()) && (this.requiredNetworkState == 2))
        throw new IllegalArgumentException("Required URIs may not be used with NETWORK_STATE_ANY");
      Iterator localIterator = this.zzaw.iterator();
      while (localIterator.hasNext())
        Task.zze((Uri)localIterator.next());
    }

    public abstract Builder setExtras(Bundle paramBundle);

    public abstract Builder setPersisted(boolean paramBoolean);

    public abstract Builder setRequiredNetwork(int paramInt);

    public abstract Builder setRequiresCharging(boolean paramBoolean);

    public abstract Builder setService(Class<? extends GcmTaskService> paramClass);

    public abstract Builder setTag(String paramString);

    public abstract Builder setUpdateCurrent(boolean paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.gcm.Task
 * JD-Core Version:    0.6.2
 */