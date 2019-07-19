package com.viber.voip.messages.orm.manager;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.viber.voip.ViberApplication;
import com.viber.voip.messages.orm.creator.Creator;
import com.viber.voip.messages.orm.service.ServiceDeleteCallback;
import com.viber.voip.messages.orm.service.ServiceSaveCallback;
import com.viber.voip.messages.orm.service.ServiceUpdateCallback;
import com.viber.voip.model.d;
import com.viber.voip.util.bq;
import com.viber.voip.util.bq.c;
import com.viber.voip.util.bq.f;
import com.viber.voip.util.bq.g;
import com.viber.voip.util.bq.i;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AsyncEntityManager extends EntityManager
  implements bq.g
{
  public static final int DEFAULT_REQUEST_TOKEN = 1536;
  protected static bq queryHandler = bq.b(ViberApplication.getApplication());
  protected Set<FillCursorCompleteCallback> accessors = Collections.synchronizedSet(new HashSet());
  protected boolean mHightPriority = true;
  protected int mId = 1536;
  protected boolean mRedirectToUi;
  protected String mSelection;
  protected String[] mSelectionArgs;
  protected String mSortOrder;
  protected boolean validCursor;

  public AsyncEntityManager(Creator paramCreator)
  {
    super(paramCreator);
  }

  public AsyncEntityManager(Creator paramCreator, FillCursorCompleteCallback paramFillCursorCompleteCallback)
  {
    super(paramCreator);
    registerCallback(paramFillCursorCompleteCallback);
  }

  public AsyncEntityManager(Creator paramCreator, boolean paramBoolean)
  {
    super(paramCreator);
    this.mHightPriority = paramBoolean;
  }

  public static void delete(ServiceDeleteCallback paramServiceDeleteCallback, Creator paramCreator, String paramString, String[] paramArrayOfString)
  {
    queryHandler.a(1536, paramCreator, paramCreator.getContentUri(), paramString, paramArrayOfString, new bq.c()
    {
      public void onDeleteComplete(int paramAnonymousInt1, Object paramAnonymousObject, int paramAnonymousInt2)
      {
        if (this.val$callback != null)
          this.val$callback.onDataDelete(paramAnonymousInt2);
      }
    });
  }

  public static void delete(d paramd, Creator paramCreator, ServiceDeleteCallback paramServiceDeleteCallback)
  {
    if (paramd.getId() != -1L)
    {
      String str = String.valueOf(paramd.getId());
      queryHandler.a(1536, paramCreator, paramCreator.getContentUri(), "_id=?", new String[] { str }, new bq.c()
      {
        public void onDeleteComplete(int paramAnonymousInt1, Object paramAnonymousObject, int paramAnonymousInt2)
        {
          if (this.val$callback != null)
            this.val$callback.onDataDelete(paramAnonymousInt2);
        }
      });
    }
  }

  public static void save(d paramd, Creator paramCreator, final ServiceSaveCallback paramServiceSaveCallback)
  {
    queryHandler.a(1536, paramCreator, paramCreator.getContentUri(), paramCreator.getContentValues(paramd), new bq.f()
    {
      public void onInsertComplete(int paramAnonymousInt, Object paramAnonymousObject, Uri paramAnonymousUri, Exception paramAnonymousException)
      {
        boolean bool = false;
        if (paramAnonymousUri != null)
        {
          long l = Long.parseLong(paramAnonymousUri.getLastPathSegment());
          this.val$entity.setId(l);
          bool = true;
        }
        if (paramServiceSaveCallback != null)
          paramServiceSaveCallback.onDataSave(this.val$entity, bool);
      }
    }
    , false, false);
  }

  public static void update(final d paramd, Creator paramCreator, ContentValues paramContentValues, ServiceUpdateCallback paramServiceUpdateCallback)
  {
    if (paramd.getId() != -1L)
    {
      String str = String.valueOf(paramd.getId());
      queryHandler.a(1536, paramCreator, paramCreator.getContentUri(), paramContentValues, "_id=?", new String[] { str }, new bq.i()
      {
        public void onUpdateComplete(int paramAnonymousInt1, Object paramAnonymousObject, Uri paramAnonymousUri, Exception paramAnonymousException, int paramAnonymousInt2)
        {
          if (this.val$callback != null)
          {
            if ((paramAnonymousInt2 > 0) && (paramAnonymousUri != null))
              this.val$callback.onDataUpdate(paramd, true);
          }
          else
            return;
          this.val$callback.onDataUpdate(null, true);
        }
      }
      , false, true);
    }
  }

  public static void update(d paramd, Creator paramCreator, ServiceUpdateCallback paramServiceUpdateCallback)
  {
    if (paramd.getId() != -1L)
      update(paramd, paramCreator, paramCreator.getContentValues(paramd), paramServiceUpdateCallback);
  }

  public static void update(final d paramd, Creator paramCreator, ServiceUpdateCallback paramServiceUpdateCallback, String paramString, String[] paramArrayOfString)
  {
    if (paramd.getId() != -1L)
      queryHandler.a(1536, paramCreator, paramCreator.getContentUri(), paramCreator.getContentValues(paramd), paramString, paramArrayOfString, new bq.i()
      {
        public void onUpdateComplete(int paramAnonymousInt1, Object paramAnonymousObject, Uri paramAnonymousUri, Exception paramAnonymousException, int paramAnonymousInt2)
        {
          if (this.val$callback != null)
          {
            if ((paramAnonymousInt2 > 0) && (paramAnonymousUri != null))
              this.val$callback.onDataUpdate(paramd, true);
          }
          else
            return;
          this.val$callback.onDataUpdate(null, true);
        }
      }
      , false, true);
  }

  protected void broadcastDataChanged(int paramInt)
  {
    while (true)
    {
      synchronized (this.accessors)
      {
        Set localSet2 = Collections.synchronizedSet(this.accessors);
        this.validCursor = true;
        Iterator localIterator = localSet2.iterator();
        if (!localIterator.hasNext())
          break;
        FillCursorCompleteCallback localFillCursorCompleteCallback = (FillCursorCompleteCallback)localIterator.next();
        if (paramInt == 1536)
        {
          i = this.mId;
          localFillCursorCompleteCallback.onDataReady(this, i);
        }
      }
      int i = paramInt;
    }
  }

  public void delete(ServiceDeleteCallback paramServiceDeleteCallback, String paramString, String[] paramArrayOfString)
  {
    delete(paramServiceDeleteCallback, this.mCreator, paramString, paramArrayOfString);
  }

  public void delete(d paramd, ServiceDeleteCallback paramServiceDeleteCallback)
  {
    delete(paramd, this.mCreator, paramServiceDeleteCallback);
  }

  public void fillCursor(int paramInt, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    synchronized (this.accessors)
    {
      this.validCursor = false;
      this.mSelection = paramString2;
      this.mSelectionArgs = paramArrayOfString;
      this.mSortOrder = paramString1;
      this.mCountRequest = false;
      queryHandler.a(paramInt, this, this.mCreator.getContentUri(), this.mCreator.getProjections(), paramString2, paramArrayOfString, paramString1, this, this.mRedirectToUi, false, this.mHightPriority);
      return;
    }
  }

  public void fillCursor(bq parambq, FillCursorCompleteCallback paramFillCursorCompleteCallback, int paramInt, String paramString, String[] paramArrayOfString)
  {
    fillCursor(parambq, paramFillCursorCompleteCallback, null, paramInt, paramString, paramArrayOfString);
  }

  public void fillCursor(bq parambq, final FillCursorCompleteCallback paramFillCursorCompleteCallback, String paramString1, int paramInt, String paramString2, String[] paramArrayOfString)
  {
    synchronized (this.accessors)
    {
      this.validCursor = false;
      this.mSelection = paramString2;
      this.mSelectionArgs = paramArrayOfString;
      this.mCountRequest = true;
      parambq.a(paramInt, this, this.mCreator.getContentUri(), this.mCreator.getProjections(), paramString2, paramArrayOfString, paramString1, new bq.g()
      {
        public void onQueryComplete(int paramAnonymousInt, Object paramAnonymousObject, Cursor paramAnonymousCursor)
        {
          if (paramFillCursorCompleteCallback != null)
            paramFillCursorCompleteCallback.onDataReady(new EntityManager(AsyncEntityManager.this.mCreator, paramAnonymousCursor), paramAnonymousInt);
        }
      }
      , this.mRedirectToUi, false, this.mHightPriority);
      return;
    }
  }

  public void fillCursor(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    synchronized (this.accessors)
    {
      this.validCursor = false;
      this.mSelection = paramString2;
      this.mSelectionArgs = paramArrayOfString;
      this.mSortOrder = paramString1;
      this.mCountRequest = false;
      queryHandler.a(1536, this, this.mCreator.getContentUri(), this.mCreator.getProjections(), paramString2, paramArrayOfString, paramString1, this, this.mRedirectToUi, false, this.mHightPriority);
      return;
    }
  }

  public void fillCursorSync(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    this.mSelection = paramString2;
    this.mSelectionArgs = paramArrayOfString;
    this.mSortOrder = paramString1;
    this.mCountRequest = false;
    super.fillCursor(paramString1, paramString2, paramArrayOfString);
  }

  public void onQueryComplete(int paramInt, Object paramObject, Cursor paramCursor)
  {
    try
    {
      processMessagesReplyInternal(paramCursor);
      return;
    }
    finally
    {
      broadcastDataChanged(paramInt);
    }
  }

  public void registerCallback(FillCursorCompleteCallback paramFillCursorCompleteCallback)
  {
    if (paramFillCursorCompleteCallback == null);
    while (true)
    {
      return;
      synchronized (this.accessors)
      {
        this.accessors.add(paramFillCursorCompleteCallback);
        if (!this.validCursor)
          continue;
        paramFillCursorCompleteCallback.onDataReady(this, this.mId);
        return;
      }
    }
  }

  public void save(d paramd, ServiceSaveCallback paramServiceSaveCallback)
  {
    save(paramd, this.mCreator, paramServiceSaveCallback);
  }

  public void update(d paramd, ServiceUpdateCallback paramServiceUpdateCallback)
  {
    update(paramd, this.mCreator, paramServiceUpdateCallback);
  }

  public void update(d paramd, ServiceUpdateCallback paramServiceUpdateCallback, String paramString, String[] paramArrayOfString)
  {
    update(paramd, this.mCreator, paramServiceUpdateCallback, paramString, paramArrayOfString);
  }

  public static abstract interface FillCursorCompleteCallback
  {
    public abstract void onDataReady(EntityManager paramEntityManager, int paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.manager.AsyncEntityManager
 * JD-Core Version:    0.6.2
 */