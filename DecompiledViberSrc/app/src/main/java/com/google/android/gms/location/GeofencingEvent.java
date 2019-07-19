package com.google.android.gms.location;

import android.content.Intent;
import android.location.Location;
import com.google.android.gms.internal.location.zzbh;
import java.util.ArrayList;
import java.util.List;

public class GeofencingEvent
{
  private final int errorCode;
  private final int zzam;
  private final List<Geofence> zzan;
  private final Location zzao;

  private GeofencingEvent(int paramInt1, int paramInt2, List<Geofence> paramList, Location paramLocation)
  {
    this.errorCode = paramInt1;
    this.zzam = paramInt2;
    this.zzan = paramList;
    this.zzao = paramLocation;
  }

  public static GeofencingEvent fromIntent(Intent paramIntent)
  {
    if (paramIntent == null)
      return null;
    int i = paramIntent.getIntExtra("gms_error_code", -1);
    int j = paramIntent.getIntExtra("com.google.android.location.intent.extra.transition", -1);
    int k;
    ArrayList localArrayList1;
    if ((j != -1) && ((j == 1) || (j == 2) || (j == 4)))
    {
      k = j;
      localArrayList1 = (ArrayList)paramIntent.getSerializableExtra("com.google.android.location.intent.extra.geofence_list");
      if (localArrayList1 != null)
        break label89;
    }
    label89: ArrayList localArrayList2;
    for (Object localObject1 = null; ; localObject1 = localArrayList2)
    {
      return new GeofencingEvent(i, k, (List)localObject1, (Location)paramIntent.getParcelableExtra("com.google.android.location.intent.extra.triggering_location"));
      k = -1;
      break;
      localArrayList2 = new ArrayList(localArrayList1.size());
      ArrayList localArrayList3 = (ArrayList)localArrayList1;
      int m = localArrayList3.size();
      int n = 0;
      while (n < m)
      {
        Object localObject2 = localArrayList3.get(n);
        n++;
        localArrayList2.add(zzbh.zza((byte[])localObject2));
      }
    }
  }

  public int getErrorCode()
  {
    return this.errorCode;
  }

  public int getGeofenceTransition()
  {
    return this.zzam;
  }

  public List<Geofence> getTriggeringGeofences()
  {
    return this.zzan;
  }

  public Location getTriggeringLocation()
  {
    return this.zzao;
  }

  public boolean hasError()
  {
    return this.errorCode != -1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.GeofencingEvent
 * JD-Core Version:    0.6.2
 */