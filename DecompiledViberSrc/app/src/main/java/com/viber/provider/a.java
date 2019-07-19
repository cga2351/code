package com.viber.provider;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.Context;
import android.content.OperationApplicationException;
import android.net.Uri;
import android.os.RemoteException;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.util.ArrayList;
import java.util.List;
import org.sqlite.database.sqlite.SQLiteConstraintException;

public final class a
{
  private static final Logger a = ViberEnv.getLogger();
  private final ContentResolver b;
  private String c;
  private final ArrayList<ContentProviderOperation> d;

  public a(Context paramContext, String paramString)
  {
    this.b = paramContext.getContentResolver();
    this.c = paramString;
    this.d = new ArrayList();
  }

  public int a()
  {
    return this.d.size();
  }

  public void a(ContentProviderOperation paramContentProviderOperation)
  {
    if (paramContentProviderOperation == null)
      return;
    this.d.add(paramContentProviderOperation);
  }

  public List<Uri> b()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.d.size() == 0)
      return localArrayList;
    try
    {
      ContentProviderResult[] arrayOfContentProviderResult = this.b.applyBatch(this.c, this.d);
      if ((arrayOfContentProviderResult != null) && (arrayOfContentProviderResult.length > 0))
        for (int i = 0; i < arrayOfContentProviderResult.length; i++)
          localArrayList.add(arrayOfContentProviderResult[i].uri);
    }
    catch (SQLiteConstraintException localSQLiteConstraintException)
    {
      this.d.clear();
      return localArrayList;
    }
    catch (RemoteException localRemoteException)
    {
      break label82;
    }
    catch (OperationApplicationException localOperationApplicationException)
    {
      label82: break label82;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.provider.a
 * JD-Core Version:    0.6.2
 */