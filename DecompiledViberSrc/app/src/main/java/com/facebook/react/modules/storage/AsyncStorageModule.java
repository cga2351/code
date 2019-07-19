package com.facebook.react.modules.storage;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.AsyncTask;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.common.ModuleDataCleaner.Cleanable;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Executor;

@ReactModule(name="AsyncSQLiteDBStorage")
public final class AsyncStorageModule extends ReactContextBaseJavaModule
  implements ModuleDataCleaner.Cleanable
{
  private static final int MAX_SQL_KEYS = 999;
  public static final String NAME = "AsyncSQLiteDBStorage";
  private final SerialExecutor executor;
  private ReactDatabaseSupplier mReactDatabaseSupplier;
  private boolean mShuttingDown = false;

  public AsyncStorageModule(ReactApplicationContext paramReactApplicationContext)
  {
    this(paramReactApplicationContext, AsyncTask.THREAD_POOL_EXECUTOR);
  }

  @VisibleForTesting
  AsyncStorageModule(ReactApplicationContext paramReactApplicationContext, Executor paramExecutor)
  {
    super(paramReactApplicationContext);
    this.executor = new SerialExecutor(paramExecutor);
    this.mReactDatabaseSupplier = ReactDatabaseSupplier.getInstance(paramReactApplicationContext);
  }

  private boolean ensureDatabase()
  {
    return (!this.mShuttingDown) && (this.mReactDatabaseSupplier.ensureDatabase());
  }

  @ReactMethod
  public void clear(final Callback paramCallback)
  {
    new GuardedAsyncTask(getReactApplicationContext())
    {
      protected void doInBackgroundGuarded(Void[] paramAnonymousArrayOfVoid)
      {
        if (!AsyncStorageModule.this.mReactDatabaseSupplier.ensureDatabase())
        {
          Callback localCallback2 = paramCallback;
          Object[] arrayOfObject2 = new Object[1];
          arrayOfObject2[0] = AsyncStorageErrorUtil.getDBError(null);
          localCallback2.invoke(arrayOfObject2);
          return;
        }
        try
        {
          AsyncStorageModule.this.mReactDatabaseSupplier.clear();
          paramCallback.invoke(new Object[0]);
          return;
        }
        catch (Exception localException)
        {
          FLog.w("ReactNative", localException.getMessage(), localException);
          Callback localCallback1 = paramCallback;
          Object[] arrayOfObject1 = new Object[1];
          arrayOfObject1[0] = AsyncStorageErrorUtil.getError(null, localException.getMessage());
          localCallback1.invoke(arrayOfObject1);
        }
      }
    }
    .executeOnExecutor(this.executor, new Void[0]);
  }

  public void clearSensitiveData()
  {
    this.mReactDatabaseSupplier.clearAndCloseDatabase();
  }

  @ReactMethod
  public void getAllKeys(final Callback paramCallback)
  {
    new GuardedAsyncTask(getReactApplicationContext())
    {
      protected void doInBackgroundGuarded(Void[] paramAnonymousArrayOfVoid)
      {
        if (!AsyncStorageModule.this.ensureDatabase())
        {
          Callback localCallback2 = paramCallback;
          Object[] arrayOfObject2 = new Object[2];
          arrayOfObject2[0] = AsyncStorageErrorUtil.getDBError(null);
          arrayOfObject2[1] = null;
          localCallback2.invoke(arrayOfObject2);
          return;
        }
        WritableArray localWritableArray = Arguments.createArray();
        String[] arrayOfString = { "key" };
        Cursor localCursor = AsyncStorageModule.this.mReactDatabaseSupplier.get().query("catalystLocalStorage", arrayOfString, null, null, null, null, null);
        try
        {
          if (localCursor.moveToFirst())
          {
            boolean bool;
            do
            {
              localWritableArray.pushString(localCursor.getString(0));
              bool = localCursor.moveToNext();
            }
            while (bool);
          }
          localCursor.close();
          paramCallback.invoke(new Object[] { null, localWritableArray });
          return;
        }
        catch (Exception localException)
        {
          FLog.w("ReactNative", localException.getMessage(), localException);
          Callback localCallback1 = paramCallback;
          Object[] arrayOfObject1 = new Object[2];
          arrayOfObject1[0] = AsyncStorageErrorUtil.getError(null, localException.getMessage());
          arrayOfObject1[1] = null;
          localCallback1.invoke(arrayOfObject1);
          return;
        }
        finally
        {
          localCursor.close();
        }
      }
    }
    .executeOnExecutor(this.executor, new Void[0]);
  }

  public String getName()
  {
    return "AsyncSQLiteDBStorage";
  }

  public void initialize()
  {
    super.initialize();
    this.mShuttingDown = false;
  }

  @ReactMethod
  public void multiGet(final ReadableArray paramReadableArray, final Callback paramCallback)
  {
    if (paramReadableArray == null)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = AsyncStorageErrorUtil.getInvalidKeyError(null);
      arrayOfObject[1] = null;
      paramCallback.invoke(arrayOfObject);
      return;
    }
    new GuardedAsyncTask(getReactApplicationContext())
    {
      protected void doInBackgroundGuarded(Void[] paramAnonymousArrayOfVoid)
      {
        if (!AsyncStorageModule.this.ensureDatabase())
        {
          Callback localCallback2 = paramCallback;
          Object[] arrayOfObject2 = new Object[2];
          arrayOfObject2[0] = AsyncStorageErrorUtil.getDBError(null);
          arrayOfObject2[1] = null;
          localCallback2.invoke(arrayOfObject2);
          return;
        }
        String[] arrayOfString = { "key", "value" };
        HashSet localHashSet = new HashSet();
        WritableArray localWritableArray1 = Arguments.createArray();
        for (int i = 0; i < paramReadableArray.size(); i += 999)
        {
          int j = Math.min(paramReadableArray.size() - i, 999);
          Cursor localCursor = AsyncStorageModule.this.mReactDatabaseSupplier.get().query("catalystLocalStorage", arrayOfString, AsyncLocalStorageUtil.buildKeySelection(j), AsyncLocalStorageUtil.buildKeySelectionArgs(paramReadableArray, i, j), null, null, null);
          localHashSet.clear();
          try
          {
            if (localCursor.getCount() != paramReadableArray.size())
              for (int k = i; k < i + j; k++)
                localHashSet.add(paramReadableArray.getString(k));
            if (localCursor.moveToFirst())
            {
              boolean bool;
              do
              {
                WritableArray localWritableArray2 = Arguments.createArray();
                localWritableArray2.pushString(localCursor.getString(0));
                localWritableArray2.pushString(localCursor.getString(1));
                localWritableArray1.pushArray(localWritableArray2);
                localHashSet.remove(localCursor.getString(0));
                bool = localCursor.moveToNext();
              }
              while (bool);
            }
            localCursor.close();
            Iterator localIterator = localHashSet.iterator();
            while (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              WritableArray localWritableArray3 = Arguments.createArray();
              localWritableArray3.pushString(str);
              localWritableArray3.pushNull();
              localWritableArray1.pushArray(localWritableArray3);
            }
          }
          catch (Exception localException)
          {
            FLog.w("ReactNative", localException.getMessage(), localException);
            Callback localCallback1 = paramCallback;
            Object[] arrayOfObject1 = new Object[2];
            arrayOfObject1[0] = AsyncStorageErrorUtil.getError(null, localException.getMessage());
            arrayOfObject1[1] = null;
            localCallback1.invoke(arrayOfObject1);
            return;
          }
          finally
          {
            localCursor.close();
          }
          localHashSet.clear();
        }
        paramCallback.invoke(new Object[] { null, localWritableArray1 });
      }
    }
    .executeOnExecutor(this.executor, new Void[0]);
  }

  @ReactMethod
  public void multiMerge(final ReadableArray paramReadableArray, final Callback paramCallback)
  {
    new GuardedAsyncTask(getReactApplicationContext())
    {
      protected void doInBackgroundGuarded(Void[] paramAnonymousArrayOfVoid)
      {
        Object localObject1 = null;
        if (!AsyncStorageModule.this.ensureDatabase())
        {
          Callback localCallback = paramCallback;
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = AsyncStorageErrorUtil.getDBError(null);
          localCallback.invoke(arrayOfObject);
          return;
        }
        while (true)
        {
          WritableMap localWritableMap1;
          try
          {
            AsyncStorageModule.this.mReactDatabaseSupplier.get().beginTransaction();
            int i = 0;
            if (i < paramReadableArray.size())
            {
              if (paramReadableArray.getArray(i).size() != 2)
              {
                WritableMap localWritableMap5 = AsyncStorageErrorUtil.getInvalidValueError(null);
                try
                {
                  AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                  return;
                }
                catch (Exception localException8)
                {
                  FLog.w("ReactNative", localException8.getMessage(), localException8);
                }
                if (localWritableMap5 != null)
                  break;
                AsyncStorageErrorUtil.getError(null, localException8.getMessage());
                return;
              }
              if (paramReadableArray.getArray(i).getString(0) == null)
              {
                WritableMap localWritableMap4 = AsyncStorageErrorUtil.getInvalidKeyError(null);
                try
                {
                  AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                  return;
                }
                catch (Exception localException7)
                {
                  FLog.w("ReactNative", localException7.getMessage(), localException7);
                }
                if (localWritableMap4 != null)
                  break;
                AsyncStorageErrorUtil.getError(null, localException7.getMessage());
                return;
              }
              if (paramReadableArray.getArray(i).getString(1) == null)
              {
                WritableMap localWritableMap3 = AsyncStorageErrorUtil.getInvalidValueError(null);
                try
                {
                  AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                  return;
                }
                catch (Exception localException6)
                {
                  FLog.w("ReactNative", localException6.getMessage(), localException6);
                }
                if (localWritableMap3 != null)
                  break;
                AsyncStorageErrorUtil.getError(null, localException6.getMessage());
                return;
              }
              if (!AsyncLocalStorageUtil.mergeImpl(AsyncStorageModule.this.mReactDatabaseSupplier.get(), paramReadableArray.getArray(i).getString(0), paramReadableArray.getArray(i).getString(1)))
              {
                WritableMap localWritableMap2 = AsyncStorageErrorUtil.getDBError(null);
                try
                {
                  AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                  return;
                }
                catch (Exception localException5)
                {
                  FLog.w("ReactNative", localException5.getMessage(), localException5);
                }
                if (localWritableMap2 != null)
                  break;
                AsyncStorageErrorUtil.getError(null, localException5.getMessage());
                return;
              }
              i++;
              continue;
            }
            AsyncStorageModule.this.mReactDatabaseSupplier.get().setTransactionSuccessful();
            try
            {
              AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
              if (localObject1 != null)
              {
                paramCallback.invoke(new Object[] { localObject1 });
                return;
              }
            }
            catch (Exception localException4)
            {
              FLog.w("ReactNative", localException4.getMessage(), localException4);
              localObject1 = null;
              if (0 != 0)
                continue;
              localObject1 = AsyncStorageErrorUtil.getError(null, localException4.getMessage());
              continue;
            }
          }
          catch (Exception localException2)
          {
            FLog.w("ReactNative", localException2.getMessage(), localException2);
            localWritableMap1 = AsyncStorageErrorUtil.getError(null, localException2.getMessage());
            try
            {
              AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
              localObject1 = localWritableMap1;
            }
            catch (Exception localException3)
            {
              FLog.w("ReactNative", localException3.getMessage(), localException3);
              if (localWritableMap1 != null)
                break label606;
            }
            localObject1 = AsyncStorageErrorUtil.getError(null, localException3.getMessage());
            continue;
          }
          finally
          {
            try
            {
              AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
              throw localObject2;
            }
            catch (Exception localException1)
            {
              FLog.w("ReactNative", localException1.getMessage(), localException1);
              if (0 != 0)
                continue;
              AsyncStorageErrorUtil.getError(null, localException1.getMessage());
              continue;
            }
            paramCallback.invoke(new Object[0]);
            return;
          }
          label606: localObject1 = localWritableMap1;
        }
      }
    }
    .executeOnExecutor(this.executor, new Void[0]);
  }

  @ReactMethod
  public void multiRemove(final ReadableArray paramReadableArray, final Callback paramCallback)
  {
    if (paramReadableArray.size() == 0)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = AsyncStorageErrorUtil.getInvalidKeyError(null);
      paramCallback.invoke(arrayOfObject);
      return;
    }
    new GuardedAsyncTask(getReactApplicationContext())
    {
      protected void doInBackgroundGuarded(Void[] paramAnonymousArrayOfVoid)
      {
        Object localObject1 = null;
        if (!AsyncStorageModule.this.ensureDatabase())
        {
          Callback localCallback = paramCallback;
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = AsyncStorageErrorUtil.getDBError(null);
          localCallback.invoke(arrayOfObject);
          return;
        }
        while (true)
        {
          WritableMap localWritableMap;
          try
          {
            AsyncStorageModule.this.mReactDatabaseSupplier.get().beginTransaction();
            int i = 0;
            if (i < paramReadableArray.size())
            {
              int j = Math.min(paramReadableArray.size() - i, 999);
              AsyncStorageModule.this.mReactDatabaseSupplier.get().delete("catalystLocalStorage", AsyncLocalStorageUtil.buildKeySelection(j), AsyncLocalStorageUtil.buildKeySelectionArgs(paramReadableArray, i, j));
              i += 999;
              continue;
            }
            AsyncStorageModule.this.mReactDatabaseSupplier.get().setTransactionSuccessful();
            try
            {
              AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
              if (localObject1 != null)
              {
                paramCallback.invoke(new Object[] { localObject1 });
                return;
              }
            }
            catch (Exception localException4)
            {
              FLog.w("ReactNative", localException4.getMessage(), localException4);
              localObject1 = null;
              if (0 != 0)
                continue;
              localObject1 = AsyncStorageErrorUtil.getError(null, localException4.getMessage());
              continue;
            }
          }
          catch (Exception localException2)
          {
            FLog.w("ReactNative", localException2.getMessage(), localException2);
            localWritableMap = AsyncStorageErrorUtil.getError(null, localException2.getMessage());
            try
            {
              AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
              localObject1 = localWritableMap;
            }
            catch (Exception localException3)
            {
              FLog.w("ReactNative", localException3.getMessage(), localException3);
              if (localWritableMap != null)
                break label351;
            }
            localObject1 = AsyncStorageErrorUtil.getError(null, localException3.getMessage());
            continue;
          }
          finally
          {
            try
            {
              AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
              throw localObject2;
            }
            catch (Exception localException1)
            {
              FLog.w("ReactNative", localException1.getMessage(), localException1);
              if (0 != 0)
                continue;
              AsyncStorageErrorUtil.getError(null, localException1.getMessage());
              continue;
            }
            paramCallback.invoke(new Object[0]);
            return;
          }
          label351: localObject1 = localWritableMap;
        }
      }
    }
    .executeOnExecutor(this.executor, new Void[0]);
  }

  @ReactMethod
  public void multiSet(final ReadableArray paramReadableArray, final Callback paramCallback)
  {
    if (paramReadableArray.size() == 0)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = AsyncStorageErrorUtil.getInvalidKeyError(null);
      paramCallback.invoke(arrayOfObject);
      return;
    }
    new GuardedAsyncTask(getReactApplicationContext())
    {
      protected void doInBackgroundGuarded(Void[] paramAnonymousArrayOfVoid)
      {
        Object localObject1 = null;
        if (!AsyncStorageModule.this.ensureDatabase())
        {
          Callback localCallback = paramCallback;
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = AsyncStorageErrorUtil.getDBError(null);
          localCallback.invoke(arrayOfObject);
          return;
        }
        SQLiteStatement localSQLiteStatement = AsyncStorageModule.this.mReactDatabaseSupplier.get().compileStatement("INSERT OR REPLACE INTO catalystLocalStorage VALUES (?, ?);");
        while (true)
        {
          WritableMap localWritableMap1;
          try
          {
            AsyncStorageModule.this.mReactDatabaseSupplier.get().beginTransaction();
            int i = 0;
            if (i < paramReadableArray.size())
            {
              if (paramReadableArray.getArray(i).size() != 2)
              {
                WritableMap localWritableMap4 = AsyncStorageErrorUtil.getInvalidValueError(null);
                try
                {
                  AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                  return;
                }
                catch (Exception localException7)
                {
                  FLog.w("ReactNative", localException7.getMessage(), localException7);
                }
                if (localWritableMap4 != null)
                  break;
                AsyncStorageErrorUtil.getError(null, localException7.getMessage());
                return;
              }
              if (paramReadableArray.getArray(i).getString(0) == null)
              {
                WritableMap localWritableMap3 = AsyncStorageErrorUtil.getInvalidKeyError(null);
                try
                {
                  AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                  return;
                }
                catch (Exception localException6)
                {
                  FLog.w("ReactNative", localException6.getMessage(), localException6);
                }
                if (localWritableMap3 != null)
                  break;
                AsyncStorageErrorUtil.getError(null, localException6.getMessage());
                return;
              }
              if (paramReadableArray.getArray(i).getString(1) == null)
              {
                WritableMap localWritableMap2 = AsyncStorageErrorUtil.getInvalidValueError(null);
                try
                {
                  AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                  return;
                }
                catch (Exception localException5)
                {
                  FLog.w("ReactNative", localException5.getMessage(), localException5);
                }
                if (localWritableMap2 != null)
                  break;
                AsyncStorageErrorUtil.getError(null, localException5.getMessage());
                return;
              }
              localSQLiteStatement.clearBindings();
              localSQLiteStatement.bindString(1, paramReadableArray.getArray(i).getString(0));
              localSQLiteStatement.bindString(2, paramReadableArray.getArray(i).getString(1));
              localSQLiteStatement.execute();
              i++;
              continue;
            }
            AsyncStorageModule.this.mReactDatabaseSupplier.get().setTransactionSuccessful();
            try
            {
              AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
              if (localObject1 != null)
              {
                paramCallback.invoke(new Object[] { localObject1 });
                return;
              }
            }
            catch (Exception localException4)
            {
              FLog.w("ReactNative", localException4.getMessage(), localException4);
              localObject1 = null;
              if (0 != 0)
                continue;
              localObject1 = AsyncStorageErrorUtil.getError(null, localException4.getMessage());
              continue;
            }
          }
          catch (Exception localException2)
          {
            FLog.w("ReactNative", localException2.getMessage(), localException2);
            localWritableMap1 = AsyncStorageErrorUtil.getError(null, localException2.getMessage());
            try
            {
              AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
              localObject1 = localWritableMap1;
            }
            catch (Exception localException3)
            {
              FLog.w("ReactNative", localException3.getMessage(), localException3);
              if (localWritableMap1 != null)
                break label576;
            }
            localObject1 = AsyncStorageErrorUtil.getError(null, localException3.getMessage());
            continue;
          }
          finally
          {
            try
            {
              AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
              throw localObject2;
            }
            catch (Exception localException1)
            {
              FLog.w("ReactNative", localException1.getMessage(), localException1);
              if (0 != 0)
                continue;
              AsyncStorageErrorUtil.getError(null, localException1.getMessage());
              continue;
            }
            paramCallback.invoke(new Object[0]);
            return;
          }
          label576: localObject1 = localWritableMap1;
        }
      }
    }
    .executeOnExecutor(this.executor, new Void[0]);
  }

  public void onCatalystInstanceDestroy()
  {
    this.mShuttingDown = true;
  }

  private class SerialExecutor
    implements Executor
  {
    private final Executor executor;
    private Runnable mActive;
    private final ArrayDeque<Runnable> mTasks = new ArrayDeque();

    SerialExecutor(Executor arg2)
    {
      Object localObject;
      this.executor = localObject;
    }

    public void execute(final Runnable paramRunnable)
    {
      try
      {
        this.mTasks.offer(new Runnable()
        {
          public void run()
          {
            try
            {
              paramRunnable.run();
              return;
            }
            finally
            {
              AsyncStorageModule.SerialExecutor.this.scheduleNext();
            }
          }
        });
        if (this.mActive == null)
          scheduleNext();
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }

    void scheduleNext()
    {
      try
      {
        Runnable localRunnable = (Runnable)this.mTasks.poll();
        this.mActive = localRunnable;
        if (localRunnable != null)
          this.executor.execute(this.mActive);
        return;
      }
      finally
      {
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.storage.AsyncStorageModule
 * JD-Core Version:    0.6.2
 */