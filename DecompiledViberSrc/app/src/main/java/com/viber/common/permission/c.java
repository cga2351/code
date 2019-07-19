package com.viber.common.permission;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.Pair;
import android.support.v4.util.SparseArrayCompat;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

public class c
{
  final SparseArrayCompat<PermissionRequest> a = new SparseArrayCompat();
  private final Context b;
  private final EventBus c;

  public c(Context paramContext, EventBus paramEventBus)
  {
    this.b = paramContext;
    this.c = paramEventBus;
  }

  public static c a(Context paramContext)
  {
    if ((paramContext instanceof d))
      return ((d)paramContext).a();
    Context localContext = paramContext.getApplicationContext();
    if (!(localContext instanceof d))
      throw new IllegalArgumentException("Application must implement PermissionManagerHolder");
    return a(localContext);
  }

  private Pair<List<String>, List<String>> b(String[] paramArrayOfString)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = paramArrayOfString.length;
    int j = 0;
    if (j < i)
    {
      String str = paramArrayOfString[j];
      if (a(new String[] { str }))
        localArrayList1.add(str);
      while (true)
      {
        j++;
        break;
        localArrayList2.add(str);
      }
    }
    return Pair.create(localArrayList1, localArrayList2);
  }

  public void a(int paramInt1, String paramString, int paramInt2)
  {
    this.c.post(new a(paramInt1, paramString, paramInt2));
  }

  public void a(Context paramContext, int paramInt, String[] paramArrayOfString)
  {
    a(paramContext, false, new PermissionRequest(paramInt, false, paramArrayOfString));
  }

  public void a(Context paramContext, int paramInt, String[] paramArrayOfString, Object paramObject)
  {
    a(paramContext, false, new PermissionRequest(paramInt, false, paramArrayOfString, paramObject));
  }

  public void a(Context paramContext, int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    a(paramContext, paramInt, paramArrayOfString, paramArrayOfInt);
  }

  public void a(Fragment paramFragment, int paramInt, String[] paramArrayOfString)
  {
    a(paramFragment, false, new PermissionRequest(paramInt, false, paramArrayOfString));
  }

  public void a(Fragment paramFragment, int paramInt, String[] paramArrayOfString, Object paramObject)
  {
    a(paramFragment, false, new PermissionRequest(paramInt, false, paramArrayOfString, paramObject));
  }

  public void a(Fragment paramFragment, int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    a(paramFragment, paramInt, paramArrayOfString, paramArrayOfInt);
  }

  public void a(b paramb)
  {
    this.c.register(paramb);
  }

  void a(Object paramObject, int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    PermissionRequest localPermissionRequest;
    synchronized (this.a)
    {
      localPermissionRequest = (PermissionRequest)this.a.get(paramInt);
      this.a.remove(paramInt);
      if ((localPermissionRequest == null) || (paramArrayOfString.length == 0))
        return;
    }
    int i = paramArrayOfString.length;
    ArrayList localArrayList1 = new ArrayList(i);
    ArrayList localArrayList2 = new ArrayList(i);
    int j = 0;
    if (j < i)
    {
      String str = paramArrayOfString[j];
      if (paramArrayOfInt[j] != 0)
        localArrayList1.add(str);
      while (true)
      {
        j++;
        break;
        localArrayList2.add(str);
      }
    }
    if (localArrayList1.size() > 0)
    {
      int k;
      if (f.a(paramObject, localArrayList1))
        k = 2;
      while (true)
      {
        this.c.post(new e(k, localPermissionRequest, localArrayList2, localArrayList1));
        return;
        if (localPermissionRequest.mRational)
          k = 3;
        else
          k = 1;
      }
    }
    this.c.post(new e(0, localPermissionRequest, localArrayList2, localArrayList1));
  }

  void a(Object paramObject, boolean paramBoolean, PermissionRequest paramPermissionRequest)
  {
    if (!(paramObject instanceof ActivityCompat.OnRequestPermissionsResultCallback))
      throw new IllegalArgumentException("Caller must implement ActivityCompat.OnRequestPermissionsResultCallback");
    String[] arrayOfString = paramPermissionRequest.mPermissions;
    Pair localPair = b(arrayOfString);
    if (paramBoolean)
    {
      int i = arrayOfString.length;
      for (int j = 0; j < i; j++)
        if (f.a(paramObject, arrayOfString[j]))
        {
          this.c.post(new e(3, paramPermissionRequest, (List)localPair.first, (List)localPair.second));
          return;
        }
    }
    if (((List)localPair.second).isEmpty())
    {
      this.c.post(new e(0, paramPermissionRequest, (List)localPair.first, (List)localPair.second));
      return;
    }
    f.a(paramObject, (String[])((List)localPair.second).toArray(new String[((List)localPair.second).size()]), paramPermissionRequest.mRequestCode);
    synchronized (this.a)
    {
      this.a.put(paramPermissionRequest.mRequestCode, paramPermissionRequest);
      return;
    }
  }

  public boolean a(String[] paramArrayOfString)
  {
    if (Build.VERSION.SDK_INT < 23);
    while (true)
    {
      return true;
      int i = paramArrayOfString.length;
      for (int j = 0; j < i; j++)
      {
        String str = paramArrayOfString[j];
        if (ContextCompat.checkSelfPermission(this.b, str) != 0)
          return false;
      }
    }
  }

  public void b(b paramb)
  {
    this.c.unregister(paramb);
  }

  public boolean c(b paramb)
  {
    return this.c.isRegistered(paramb);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.permission.c
 * JD-Core Version:    0.6.2
 */