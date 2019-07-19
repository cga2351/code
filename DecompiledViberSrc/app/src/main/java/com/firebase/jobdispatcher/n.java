package com.firebase.jobdispatcher;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class n
{
  private final boolean a;
  private final String b;

  n(String paramString, boolean paramBoolean)
  {
    this.a = paramBoolean;
    this.b = paramString;
  }

  private static String a(List<t> paramList)
  {
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray1 = new JSONArray();
    JSONArray localJSONArray2 = new JSONArray();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      t localt = (t)localIterator.next();
      localJSONArray1.put(localt.b());
      localJSONArray2.put(localt.a());
    }
    try
    {
      localJSONObject.put("uri_flags", localJSONArray1);
      localJSONObject.put("uris", localJSONArray2);
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException);
    }
  }

  private static List<t> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      JSONArray localJSONArray1 = localJSONObject.getJSONArray("uri_flags");
      JSONArray localJSONArray2 = localJSONObject.getJSONArray("uris");
      int i = localJSONArray1.length();
      for (int j = 0; j < i; j++)
      {
        int k = localJSONArray1.getInt(j);
        localArrayList.add(new t(Uri.parse(localJSONArray2.getString(j)), k));
      }
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException);
    }
    return localArrayList;
  }

  private void a(r paramr, Bundle paramBundle)
  {
    if (paramr == v.a)
    {
      paramBundle.putInt(this.b + "trigger_type", 2);
      return;
    }
    if ((paramr instanceof r.b))
    {
      r.b localb = (r.b)paramr;
      paramBundle.putInt(this.b + "trigger_type", 1);
      paramBundle.putInt(this.b + "window_start", localb.a());
      paramBundle.putInt(this.b + "window_end", localb.b());
      return;
    }
    if ((paramr instanceof r.a))
    {
      paramBundle.putInt(this.b + "trigger_type", 3);
      String str = a(((r.a)paramr).a());
      paramBundle.putString(this.b + "observed_uris", str);
      return;
    }
    throw new IllegalArgumentException("Unsupported trigger.");
  }

  private void a(u paramu, Bundle paramBundle)
  {
    if (paramu == null)
      paramu = u.a;
    paramBundle.putInt(this.b + "retry_policy", paramu.a());
    paramBundle.putInt(this.b + "initial_backoff_seconds", paramu.b());
    paramBundle.putInt(this.b + "maximum_backoff_seconds", paramu.c());
  }

  private r c(Bundle paramBundle)
  {
    switch (paramBundle.getInt(this.b + "trigger_type"))
    {
    default:
      if (Log.isLoggable("FJD.ExternalReceiver", 3))
        Log.d("FJD.ExternalReceiver", "Unsupported trigger.");
      return null;
    case 2:
      return v.a;
    case 1:
      return v.a(paramBundle.getInt(this.b + "window_start"), paramBundle.getInt(this.b + "window_end"));
    case 3:
    }
    return v.a(Collections.unmodifiableList(a(paramBundle.getString(this.b + "observed_uris"))));
  }

  private u d(Bundle paramBundle)
  {
    int i = paramBundle.getInt(this.b + "retry_policy");
    if ((i != 1) && (i != 2))
      return u.a;
    return new u(i, paramBundle.getInt(this.b + "initial_backoff_seconds"), paramBundle.getInt(this.b + "maximum_backoff_seconds"));
  }

  Bundle a(p paramp, Bundle paramBundle)
  {
    if (paramBundle == null)
      throw new IllegalArgumentException("Unexpected null Bundle provided");
    paramBundle.putInt(this.b + "persistent", paramp.g());
    paramBundle.putBoolean(this.b + "recurring", paramp.h());
    paramBundle.putBoolean(this.b + "replace_current", paramp.d());
    paramBundle.putString(this.b + "tag", paramp.e());
    paramBundle.putString(this.b + "service", paramp.i());
    paramBundle.putInt(this.b + "constraints", a.a(paramp.a()));
    if (this.a)
      paramBundle.putBundle(this.b + "extras", paramp.b());
    a(paramp.f(), paramBundle);
    a(paramp.c(), paramBundle);
    return paramBundle;
  }

  o a(Bundle paramBundle)
  {
    if (paramBundle == null)
      Log.e("FJD.ExternalReceiver", "Unexpected null Bundle provided");
    Bundle localBundle;
    do
    {
      return null;
      localBundle = paramBundle.getBundle("extras");
    }
    while (localBundle == null);
    o.a locala = b(localBundle);
    ArrayList localArrayList = paramBundle.getParcelableArrayList("triggered_uris");
    if (localArrayList != null)
      locala.a(new w(localArrayList));
    return locala.a();
  }

  public o.a b(Bundle paramBundle)
  {
    if (paramBundle == null)
      throw new IllegalArgumentException("Unexpected null Bundle provided");
    boolean bool1 = paramBundle.getBoolean(this.b + "recurring");
    boolean bool2 = paramBundle.getBoolean(this.b + "replace_current");
    int i = paramBundle.getInt(this.b + "persistent");
    int[] arrayOfInt = a.a(paramBundle.getInt(this.b + "constraints"));
    r localr = c(paramBundle);
    u localu = d(paramBundle);
    String str1 = paramBundle.getString(this.b + "tag");
    String str2 = paramBundle.getString(this.b + "service");
    if ((str1 == null) || (str2 == null) || (localr == null) || (localu == null))
      return null;
    o.a locala = new o.a();
    locala.a(str1);
    locala.b(str2);
    locala.a(localr);
    locala.a(localu);
    locala.a(bool1);
    locala.a(i);
    locala.a(arrayOfInt);
    locala.b(bool2);
    locala.a(paramBundle);
    return locala;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.firebase.jobdispatcher.n
 * JD-Core Version:    0.6.2
 */