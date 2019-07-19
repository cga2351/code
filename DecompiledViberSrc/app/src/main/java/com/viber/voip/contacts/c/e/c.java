package com.viber.voip.contacts.c.e;

import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.os.RemoteException;
import com.viber.dexshared.Logger;
import com.viber.provider.contacts.a.h;
import com.viber.provider.contacts.a.i;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.orm.creator.CreatorHelper;
import com.viber.voip.model.entity.y;
import com.viber.voip.model.entity.z;
import com.viber.voip.util.af;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class c
{
  private static final Logger a = ViberEnv.getLogger();
  private ContentResolver b;

  public c(Context paramContext)
  {
    this.b = paramContext.getContentResolver();
  }

  private int a(boolean paramBoolean)
  {
    if (paramBoolean)
      return z.b;
    return z.a;
  }

  private void a(Set<String> paramSet, boolean paramBoolean1, boolean paramBoolean2)
  {
    ArrayList localArrayList = new ArrayList();
    z localz = new z();
    localz.a(a(paramBoolean1));
    Iterator localIterator = paramSet.iterator();
    if (localIterator.hasNext())
    {
      localz.a((String)localIterator.next());
      if (paramBoolean2);
      for (ContentProviderOperation.Builder localBuilder = ContentProviderOperation.newUpdate(a.i.a); ; localBuilder = ContentProviderOperation.newInsert(a.i.a))
      {
        localArrayList.add(localBuilder.withValues(localz.getContentValues()).build());
        break;
      }
    }
    try
    {
      this.b.applyBatch("com.viber.voip.provider.vibercontacts", localArrayList);
      return;
    }
    catch (OperationApplicationException localOperationApplicationException)
    {
    }
    catch (RemoteException localRemoteException)
    {
    }
  }

  public void a(Set<String> paramSet, boolean paramBoolean)
  {
    a(paramSet, paramBoolean, false);
  }

  public void a(int[] paramArrayOfInt)
  {
    y localy = new y();
    ArrayList localArrayList = new ArrayList();
    int i = paramArrayOfInt.length;
    for (int j = 0; j < i; j++)
    {
      localy.a(paramArrayOfInt[j]);
      localArrayList.add(ContentProviderOperation.newInsert(a.h.a).withValues(localy.getContentValues()).build());
    }
    try
    {
      this.b.applyBatch("com.viber.voip.provider.vibercontacts", localArrayList);
      return;
    }
    catch (OperationApplicationException localOperationApplicationException)
    {
    }
    catch (RemoteException localRemoteException)
    {
    }
  }

  public int[] a()
  {
    Cursor localCursor = this.b.query(a.h.a, null, null, null, null);
    Object localObject1 = new int[0];
    if (localCursor != null);
    try
    {
      int[] arrayOfInt = new int[localCursor.getCount()];
      int j;
      for (int i = 0; localCursor.moveToNext(); i = j)
      {
        j = i + 1;
        arrayOfInt[i] = ((y)y.a.createInstance(localCursor)).a();
      }
      af.a(localCursor);
      localObject1 = arrayOfInt;
      return localObject1;
    }
    finally
    {
      af.a(localCursor);
    }
  }

  public void b()
  {
    this.b.delete(a.i.a, null, null);
    this.b.delete(a.h.a, null, null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.c.e.c
 * JD-Core Version:    0.6.2
 */