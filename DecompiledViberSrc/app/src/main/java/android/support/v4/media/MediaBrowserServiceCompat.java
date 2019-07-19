package android.support.v4.media;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.service.media.MediaBrowserService;
import android.support.v4.app.BundleCompat;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.os.ResultReceiver;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.Pair;
import android.text.TextUtils;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class MediaBrowserServiceCompat extends Service
{
  static final boolean DEBUG = false;
  private static final float EPSILON = 1.0E-005F;
  public static final String KEY_MEDIA_ITEM = "media_item";
  public static final String KEY_SEARCH_RESULTS = "search_results";
  public static final int RESULT_ERROR = -1;
  static final int RESULT_FLAG_ON_LOAD_ITEM_NOT_IMPLEMENTED = 2;
  static final int RESULT_FLAG_ON_SEARCH_NOT_IMPLEMENTED = 4;
  static final int RESULT_FLAG_OPTION_NOT_HANDLED = 1;
  public static final int RESULT_OK = 0;
  public static final int RESULT_PROGRESS_UPDATE = 1;
  public static final String SERVICE_INTERFACE = "android.media.browse.MediaBrowserService";
  static final String TAG = "MBServiceCompat";
  final ArrayMap<IBinder, ConnectionRecord> mConnections = new ArrayMap();
  ConnectionRecord mCurConnection;
  final ServiceHandler mHandler = new ServiceHandler();
  private MediaBrowserServiceImpl mImpl;
  MediaSessionCompat.Token mSession;

  void addSubscription(String paramString, ConnectionRecord paramConnectionRecord, IBinder paramIBinder, Bundle paramBundle)
  {
    List localList = (List)paramConnectionRecord.subscriptions.get(paramString);
    if (localList == null);
    for (Object localObject = new ArrayList(); ; localObject = localList)
    {
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        if ((paramIBinder == localPair.first) && (MediaBrowserCompatUtils.areSameOptions(paramBundle, (Bundle)localPair.second)))
          return;
      }
      ((List)localObject).add(new Pair(paramIBinder, paramBundle));
      paramConnectionRecord.subscriptions.put(paramString, localObject);
      performLoadChildren(paramString, paramConnectionRecord, paramBundle, null);
      this.mCurConnection = paramConnectionRecord;
      onSubscribe(paramString, paramBundle);
      this.mCurConnection = null;
      return;
    }
  }

  List<MediaBrowserCompat.MediaItem> applyOptions(List<MediaBrowserCompat.MediaItem> paramList, Bundle paramBundle)
  {
    if (paramList == null)
      paramList = null;
    int i;
    int j;
    do
    {
      return paramList;
      i = paramBundle.getInt("android.media.browse.extra.PAGE", -1);
      j = paramBundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
    }
    while ((i == -1) && (j == -1));
    int k = j * i;
    int m = k + j;
    if ((i < 0) || (j < 1) || (k >= paramList.size()))
      return Collections.emptyList();
    if (m > paramList.size())
      m = paramList.size();
    return paramList.subList(k, m);
  }

  public void attachToBaseContext(Context paramContext)
  {
    attachBaseContext(paramContext);
  }

  public void dump(FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
  }

  public final Bundle getBrowserRootHints()
  {
    return this.mImpl.getBrowserRootHints();
  }

  public final MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo()
  {
    return this.mImpl.getCurrentBrowserInfo();
  }

  public MediaSessionCompat.Token getSessionToken()
  {
    return this.mSession;
  }

  boolean isValidPackage(String paramString, int paramInt)
  {
    if (paramString == null);
    while (true)
    {
      return false;
      String[] arrayOfString = getPackageManager().getPackagesForUid(paramInt);
      int i = arrayOfString.length;
      for (int j = 0; j < i; j++)
        if (arrayOfString[j].equals(paramString))
          return true;
    }
  }

  public void notifyChildrenChanged(MediaSessionManager.RemoteUserInfo paramRemoteUserInfo, String paramString, Bundle paramBundle)
  {
    if (paramRemoteUserInfo == null)
      throw new IllegalArgumentException("remoteUserInfo cannot be null in notifyChildrenChanged");
    if (paramString == null)
      throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
    if (paramBundle == null)
      throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
    this.mImpl.notifyChildrenChanged(paramRemoteUserInfo, paramString, paramBundle);
  }

  public void notifyChildrenChanged(String paramString)
  {
    if (paramString == null)
      throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
    this.mImpl.notifyChildrenChanged(paramString, null);
  }

  public void notifyChildrenChanged(String paramString, Bundle paramBundle)
  {
    if (paramString == null)
      throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
    if (paramBundle == null)
      throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
    this.mImpl.notifyChildrenChanged(paramString, paramBundle);
  }

  public IBinder onBind(Intent paramIntent)
  {
    return this.mImpl.onBind(paramIntent);
  }

  public void onCreate()
  {
    super.onCreate();
    if (Build.VERSION.SDK_INT >= 28)
      this.mImpl = new MediaBrowserServiceImplApi28();
    while (true)
    {
      this.mImpl.onCreate();
      return;
      if (Build.VERSION.SDK_INT >= 26)
        this.mImpl = new MediaBrowserServiceImplApi26();
      else if (Build.VERSION.SDK_INT >= 23)
        this.mImpl = new MediaBrowserServiceImplApi23();
      else if (Build.VERSION.SDK_INT >= 21)
        this.mImpl = new MediaBrowserServiceImplApi21();
      else
        this.mImpl = new MediaBrowserServiceImplBase();
    }
  }

  public void onCustomAction(String paramString, Bundle paramBundle, Result<Bundle> paramResult)
  {
    paramResult.sendError(null);
  }

  public abstract BrowserRoot onGetRoot(String paramString, int paramInt, Bundle paramBundle);

  public abstract void onLoadChildren(String paramString, Result<List<MediaBrowserCompat.MediaItem>> paramResult);

  public void onLoadChildren(String paramString, Result<List<MediaBrowserCompat.MediaItem>> paramResult, Bundle paramBundle)
  {
    paramResult.setFlags(1);
    onLoadChildren(paramString, paramResult);
  }

  public void onLoadItem(String paramString, Result<MediaBrowserCompat.MediaItem> paramResult)
  {
    paramResult.setFlags(2);
    paramResult.sendResult(null);
  }

  public void onSearch(String paramString, Bundle paramBundle, Result<List<MediaBrowserCompat.MediaItem>> paramResult)
  {
    paramResult.setFlags(4);
    paramResult.sendResult(null);
  }

  public void onSubscribe(String paramString, Bundle paramBundle)
  {
  }

  public void onUnsubscribe(String paramString)
  {
  }

  void performCustomAction(String paramString, Bundle paramBundle, ConnectionRecord paramConnectionRecord, final ResultReceiver paramResultReceiver)
  {
    Result local4 = new Result(paramString)
    {
      void onErrorSent(Bundle paramAnonymousBundle)
      {
        paramResultReceiver.send(-1, paramAnonymousBundle);
      }

      void onProgressUpdateSent(Bundle paramAnonymousBundle)
      {
        paramResultReceiver.send(1, paramAnonymousBundle);
      }

      void onResultSent(Bundle paramAnonymousBundle)
      {
        paramResultReceiver.send(0, paramAnonymousBundle);
      }
    };
    this.mCurConnection = paramConnectionRecord;
    onCustomAction(paramString, paramBundle, local4);
    this.mCurConnection = null;
    if (!local4.isDone())
      throw new IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + paramString + " extras=" + paramBundle);
  }

  void performLoadChildren(final String paramString, final ConnectionRecord paramConnectionRecord, final Bundle paramBundle1, final Bundle paramBundle2)
  {
    Result local1 = new Result(paramString)
    {
      void onResultSent(List<MediaBrowserCompat.MediaItem> paramAnonymousList)
      {
        if (MediaBrowserServiceCompat.this.mConnections.get(paramConnectionRecord.callbacks.asBinder()) != paramConnectionRecord)
        {
          if (MediaBrowserServiceCompat.DEBUG)
            Log.d("MBServiceCompat", "Not sending onLoadChildren result for connection that has been disconnected. pkg=" + paramConnectionRecord.pkg + " id=" + paramString);
          return;
        }
        if ((0x1 & getFlags()) != 0)
          paramAnonymousList = MediaBrowserServiceCompat.this.applyOptions(paramAnonymousList, paramBundle1);
        try
        {
          paramConnectionRecord.callbacks.onLoadChildren(paramString, paramAnonymousList, paramBundle1, paramBundle2);
          return;
        }
        catch (RemoteException localRemoteException)
        {
          Log.w("MBServiceCompat", "Calling onLoadChildren() failed for id=" + paramString + " package=" + paramConnectionRecord.pkg);
        }
      }
    };
    this.mCurConnection = paramConnectionRecord;
    if (paramBundle1 == null)
      onLoadChildren(paramString, local1);
    while (true)
    {
      this.mCurConnection = null;
      if (local1.isDone())
        break;
      throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + paramConnectionRecord.pkg + " id=" + paramString);
      onLoadChildren(paramString, local1, paramBundle1);
    }
  }

  void performLoadItem(String paramString, ConnectionRecord paramConnectionRecord, final ResultReceiver paramResultReceiver)
  {
    Result local2 = new Result(paramString)
    {
      void onResultSent(MediaBrowserCompat.MediaItem paramAnonymousMediaItem)
      {
        if ((0x2 & getFlags()) != 0)
        {
          paramResultReceiver.send(-1, null);
          return;
        }
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("media_item", paramAnonymousMediaItem);
        paramResultReceiver.send(0, localBundle);
      }
    };
    this.mCurConnection = paramConnectionRecord;
    onLoadItem(paramString, local2);
    this.mCurConnection = null;
    if (!local2.isDone())
      throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + paramString);
  }

  void performSearch(String paramString, Bundle paramBundle, ConnectionRecord paramConnectionRecord, final ResultReceiver paramResultReceiver)
  {
    Result local3 = new Result(paramString)
    {
      void onResultSent(List<MediaBrowserCompat.MediaItem> paramAnonymousList)
      {
        if (((0x4 & getFlags()) != 0) || (paramAnonymousList == null))
        {
          paramResultReceiver.send(-1, null);
          return;
        }
        Bundle localBundle = new Bundle();
        localBundle.putParcelableArray("search_results", (Parcelable[])paramAnonymousList.toArray(new MediaBrowserCompat.MediaItem[0]));
        paramResultReceiver.send(0, localBundle);
      }
    };
    this.mCurConnection = paramConnectionRecord;
    onSearch(paramString, paramBundle, local3);
    this.mCurConnection = null;
    if (!local3.isDone())
      throw new IllegalStateException("onSearch must call detach() or sendResult() before returning for query=" + paramString);
  }

  boolean removeSubscription(String paramString, ConnectionRecord paramConnectionRecord, IBinder paramIBinder)
  {
    if (paramIBinder == null);
    try
    {
      Object localObject2 = paramConnectionRecord.subscriptions.remove(paramString);
      if (localObject2 != null);
      for (boolean bool3 = true; ; bool3 = false)
        return bool3;
      List localList = (List)paramConnectionRecord.subscriptions.get(paramString);
      boolean bool1 = false;
      if (localList != null)
      {
        Iterator localIterator = localList.iterator();
        boolean bool2 = false;
        while (localIterator.hasNext())
          if (paramIBinder == ((Pair)localIterator.next()).first)
          {
            localIterator.remove();
            bool2 = true;
          }
        if (localList.size() == 0)
          paramConnectionRecord.subscriptions.remove(paramString);
        bool1 = bool2;
      }
      return bool1;
    }
    finally
    {
      this.mCurConnection = paramConnectionRecord;
      onUnsubscribe(paramString);
      this.mCurConnection = null;
    }
  }

  public void setSessionToken(MediaSessionCompat.Token paramToken)
  {
    if (paramToken == null)
      throw new IllegalArgumentException("Session token may not be null.");
    if (this.mSession != null)
      throw new IllegalStateException("The session token has already been set.");
    this.mSession = paramToken;
    this.mImpl.setSessionToken(paramToken);
  }

  public static final class BrowserRoot
  {
    public static final String EXTRA_OFFLINE = "android.service.media.extra.OFFLINE";
    public static final String EXTRA_RECENT = "android.service.media.extra.RECENT";
    public static final String EXTRA_SUGGESTED = "android.service.media.extra.SUGGESTED";

    @Deprecated
    public static final String EXTRA_SUGGESTION_KEYWORDS = "android.service.media.extra.SUGGESTION_KEYWORDS";
    private final Bundle mExtras;
    private final String mRootId;

    public BrowserRoot(String paramString, Bundle paramBundle)
    {
      if (paramString == null)
        throw new IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead.");
      this.mRootId = paramString;
      this.mExtras = paramBundle;
    }

    public Bundle getExtras()
    {
      return this.mExtras;
    }

    public String getRootId()
    {
      return this.mRootId;
    }
  }

  private class ConnectionRecord
    implements IBinder.DeathRecipient
  {
    public final MediaSessionManager.RemoteUserInfo browserInfo;
    public final MediaBrowserServiceCompat.ServiceCallbacks callbacks;
    public final int pid;
    public final String pkg;
    public MediaBrowserServiceCompat.BrowserRoot root;
    public final Bundle rootHints;
    public final HashMap<String, List<Pair<IBinder, Bundle>>> subscriptions = new HashMap();
    public final int uid;

    ConnectionRecord(String paramInt1, int paramInt2, int paramBundle, Bundle paramServiceCallbacks, MediaBrowserServiceCompat.ServiceCallbacks arg6)
    {
      this.pkg = paramInt1;
      this.pid = paramInt2;
      this.uid = paramBundle;
      this.browserInfo = new MediaSessionManager.RemoteUserInfo(paramInt1, paramInt2, paramBundle);
      this.rootHints = paramServiceCallbacks;
      Object localObject;
      this.callbacks = localObject;
    }

    public void binderDied()
    {
      MediaBrowserServiceCompat.this.mHandler.post(new Runnable()
      {
        public void run()
        {
          MediaBrowserServiceCompat.this.mConnections.remove(MediaBrowserServiceCompat.ConnectionRecord.this.callbacks.asBinder());
        }
      });
    }
  }

  static abstract interface MediaBrowserServiceImpl
  {
    public abstract Bundle getBrowserRootHints();

    public abstract MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo();

    public abstract void notifyChildrenChanged(MediaSessionManager.RemoteUserInfo paramRemoteUserInfo, String paramString, Bundle paramBundle);

    public abstract void notifyChildrenChanged(String paramString, Bundle paramBundle);

    public abstract IBinder onBind(Intent paramIntent);

    public abstract void onCreate();

    public abstract void setSessionToken(MediaSessionCompat.Token paramToken);
  }

  class MediaBrowserServiceImplApi21
    implements MediaBrowserServiceCompat.MediaBrowserServiceImpl, MediaBrowserServiceCompatApi21.ServiceCompatProxy
  {
    Messenger mMessenger;
    final List<Bundle> mRootExtrasList = new ArrayList();
    Object mServiceObj;

    MediaBrowserServiceImplApi21()
    {
    }

    public Bundle getBrowserRootHints()
    {
      if (this.mMessenger == null);
      do
      {
        return null;
        if (MediaBrowserServiceCompat.this.mCurConnection == null)
          throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
      }
      while (MediaBrowserServiceCompat.this.mCurConnection.rootHints == null);
      return new Bundle(MediaBrowserServiceCompat.this.mCurConnection.rootHints);
    }

    public MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo()
    {
      if (MediaBrowserServiceCompat.this.mCurConnection == null)
        throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
      return MediaBrowserServiceCompat.this.mCurConnection.browserInfo;
    }

    public void notifyChildrenChanged(MediaSessionManager.RemoteUserInfo paramRemoteUserInfo, String paramString, Bundle paramBundle)
    {
      notifyChildrenChangedForCompat(paramRemoteUserInfo, paramString, paramBundle);
    }

    public void notifyChildrenChanged(String paramString, Bundle paramBundle)
    {
      notifyChildrenChangedForFramework(paramString, paramBundle);
      notifyChildrenChangedForCompat(paramString, paramBundle);
    }

    void notifyChildrenChangedForCompat(final MediaSessionManager.RemoteUserInfo paramRemoteUserInfo, final String paramString, final Bundle paramBundle)
    {
      MediaBrowserServiceCompat.this.mHandler.post(new Runnable()
      {
        public void run()
        {
          for (int i = 0; i < MediaBrowserServiceCompat.this.mConnections.size(); i++)
          {
            MediaBrowserServiceCompat.ConnectionRecord localConnectionRecord = (MediaBrowserServiceCompat.ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.valueAt(i);
            if (localConnectionRecord.browserInfo.equals(paramRemoteUserInfo))
              MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.this.notifyChildrenChangedForCompatOnHandler(localConnectionRecord, paramString, paramBundle);
          }
        }
      });
    }

    void notifyChildrenChangedForCompat(final String paramString, final Bundle paramBundle)
    {
      MediaBrowserServiceCompat.this.mHandler.post(new Runnable()
      {
        public void run()
        {
          Iterator localIterator = MediaBrowserServiceCompat.this.mConnections.keySet().iterator();
          while (localIterator.hasNext())
          {
            IBinder localIBinder = (IBinder)localIterator.next();
            MediaBrowserServiceCompat.ConnectionRecord localConnectionRecord = (MediaBrowserServiceCompat.ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.get(localIBinder);
            MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.this.notifyChildrenChangedForCompatOnHandler(localConnectionRecord, paramString, paramBundle);
          }
        }
      });
    }

    void notifyChildrenChangedForCompatOnHandler(MediaBrowserServiceCompat.ConnectionRecord paramConnectionRecord, String paramString, Bundle paramBundle)
    {
      List localList = (List)paramConnectionRecord.subscriptions.get(paramString);
      if (localList != null)
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          Pair localPair = (Pair)localIterator.next();
          if (MediaBrowserCompatUtils.hasDuplicatedItems(paramBundle, (Bundle)localPair.second))
            MediaBrowserServiceCompat.this.performLoadChildren(paramString, paramConnectionRecord, (Bundle)localPair.second, paramBundle);
        }
      }
    }

    void notifyChildrenChangedForFramework(String paramString, Bundle paramBundle)
    {
      MediaBrowserServiceCompatApi21.notifyChildrenChanged(this.mServiceObj, paramString);
    }

    public IBinder onBind(Intent paramIntent)
    {
      return MediaBrowserServiceCompatApi21.onBind(this.mServiceObj, paramIntent);
    }

    public void onCreate()
    {
      this.mServiceObj = MediaBrowserServiceCompatApi21.createService(MediaBrowserServiceCompat.this, this);
      MediaBrowserServiceCompatApi21.onCreate(this.mServiceObj);
    }

    public MediaBrowserServiceCompatApi21.BrowserRoot onGetRoot(String paramString, int paramInt, Bundle paramBundle)
    {
      Bundle localBundle2;
      IMediaSession localIMediaSession;
      IBinder localIBinder;
      Bundle localBundle1;
      if ((paramBundle != null) && (paramBundle.getInt("extra_client_version", 0) != 0))
      {
        paramBundle.remove("extra_client_version");
        this.mMessenger = new Messenger(MediaBrowserServiceCompat.this.mHandler);
        localBundle2 = new Bundle();
        localBundle2.putInt("extra_service_version", 2);
        BundleCompat.putBinder(localBundle2, "extra_messenger", this.mMessenger.getBinder());
        if (MediaBrowserServiceCompat.this.mSession != null)
        {
          localIMediaSession = MediaBrowserServiceCompat.this.mSession.getExtraBinder();
          if (localIMediaSession == null)
          {
            localIBinder = null;
            BundleCompat.putBinder(localBundle2, "extra_session_binder", localIBinder);
            localBundle1 = localBundle2;
          }
        }
      }
      while (true)
      {
        MediaBrowserServiceCompat.this.mCurConnection = new MediaBrowserServiceCompat.ConnectionRecord(MediaBrowserServiceCompat.this, paramString, -1, paramInt, paramBundle, null);
        MediaBrowserServiceCompat.BrowserRoot localBrowserRoot = MediaBrowserServiceCompat.this.onGetRoot(paramString, paramInt, paramBundle);
        MediaBrowserServiceCompat.this.mCurConnection = null;
        if (localBrowserRoot == null)
        {
          return null;
          localIBinder = localIMediaSession.asBinder();
          break;
          this.mRootExtrasList.add(localBundle2);
          localBundle1 = localBundle2;
          continue;
        }
        if (localBundle1 == null)
          localBundle1 = localBrowserRoot.getExtras();
        while (true)
        {
          return new MediaBrowserServiceCompatApi21.BrowserRoot(localBrowserRoot.getRootId(), localBundle1);
          if (localBrowserRoot.getExtras() != null)
            localBundle1.putAll(localBrowserRoot.getExtras());
        }
        localBundle1 = null;
      }
    }

    public void onLoadChildren(String paramString, final MediaBrowserServiceCompatApi21.ResultWrapper<List<Parcel>> paramResultWrapper)
    {
      MediaBrowserServiceCompat.Result local2 = new MediaBrowserServiceCompat.Result(paramString)
      {
        public void detach()
        {
          paramResultWrapper.detach();
        }

        void onResultSent(List<MediaBrowserCompat.MediaItem> paramAnonymousList)
        {
          Object localObject = null;
          if (paramAnonymousList != null)
          {
            ArrayList localArrayList = new ArrayList();
            Iterator localIterator = paramAnonymousList.iterator();
            while (localIterator.hasNext())
            {
              MediaBrowserCompat.MediaItem localMediaItem = (MediaBrowserCompat.MediaItem)localIterator.next();
              Parcel localParcel = Parcel.obtain();
              localMediaItem.writeToParcel(localParcel, 0);
              localArrayList.add(localParcel);
            }
            localObject = localArrayList;
          }
          paramResultWrapper.sendResult(localObject);
        }
      };
      MediaBrowserServiceCompat.this.onLoadChildren(paramString, local2);
    }

    public void setSessionToken(final MediaSessionCompat.Token paramToken)
    {
      MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable()
      {
        public void run()
        {
          if (!MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.this.mRootExtrasList.isEmpty())
          {
            IMediaSession localIMediaSession = paramToken.getExtraBinder();
            if (localIMediaSession != null)
            {
              Iterator localIterator = MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.this.mRootExtrasList.iterator();
              while (localIterator.hasNext())
                BundleCompat.putBinder((Bundle)localIterator.next(), "extra_session_binder", localIMediaSession.asBinder());
            }
            MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.this.mRootExtrasList.clear();
          }
          MediaBrowserServiceCompatApi21.setSessionToken(MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.this.mServiceObj, paramToken.getToken());
        }
      });
    }
  }

  class MediaBrowserServiceImplApi23 extends MediaBrowserServiceCompat.MediaBrowserServiceImplApi21
    implements MediaBrowserServiceCompatApi23.ServiceCompatProxy
  {
    MediaBrowserServiceImplApi23()
    {
      super();
    }

    public void onCreate()
    {
      this.mServiceObj = MediaBrowserServiceCompatApi23.createService(MediaBrowserServiceCompat.this, this);
      MediaBrowserServiceCompatApi21.onCreate(this.mServiceObj);
    }

    public void onLoadItem(String paramString, final MediaBrowserServiceCompatApi21.ResultWrapper<Parcel> paramResultWrapper)
    {
      MediaBrowserServiceCompat.Result local1 = new MediaBrowserServiceCompat.Result(paramString)
      {
        public void detach()
        {
          paramResultWrapper.detach();
        }

        void onResultSent(MediaBrowserCompat.MediaItem paramAnonymousMediaItem)
        {
          if (paramAnonymousMediaItem == null)
          {
            paramResultWrapper.sendResult(null);
            return;
          }
          Parcel localParcel = Parcel.obtain();
          paramAnonymousMediaItem.writeToParcel(localParcel, 0);
          paramResultWrapper.sendResult(localParcel);
        }
      };
      MediaBrowserServiceCompat.this.onLoadItem(paramString, local1);
    }
  }

  class MediaBrowserServiceImplApi26 extends MediaBrowserServiceCompat.MediaBrowserServiceImplApi23
    implements MediaBrowserServiceCompatApi26.ServiceCompatProxy
  {
    MediaBrowserServiceImplApi26()
    {
      super();
    }

    public Bundle getBrowserRootHints()
    {
      if (MediaBrowserServiceCompat.this.mCurConnection != null)
      {
        if (MediaBrowserServiceCompat.this.mCurConnection.rootHints == null)
          return null;
        return new Bundle(MediaBrowserServiceCompat.this.mCurConnection.rootHints);
      }
      return MediaBrowserServiceCompatApi26.getBrowserRootHints(this.mServiceObj);
    }

    void notifyChildrenChangedForFramework(String paramString, Bundle paramBundle)
    {
      if (paramBundle != null)
      {
        MediaBrowserServiceCompatApi26.notifyChildrenChanged(this.mServiceObj, paramString, paramBundle);
        return;
      }
      super.notifyChildrenChangedForFramework(paramString, paramBundle);
    }

    public void onCreate()
    {
      this.mServiceObj = MediaBrowserServiceCompatApi26.createService(MediaBrowserServiceCompat.this, this);
      MediaBrowserServiceCompatApi21.onCreate(this.mServiceObj);
    }

    public void onLoadChildren(String paramString, final MediaBrowserServiceCompatApi26.ResultWrapper paramResultWrapper, Bundle paramBundle)
    {
      MediaBrowserServiceCompat.Result local1 = new MediaBrowserServiceCompat.Result(paramString)
      {
        public void detach()
        {
          paramResultWrapper.detach();
        }

        void onResultSent(List<MediaBrowserCompat.MediaItem> paramAnonymousList)
        {
          Object localObject = null;
          if (paramAnonymousList != null)
          {
            ArrayList localArrayList = new ArrayList();
            Iterator localIterator = paramAnonymousList.iterator();
            while (localIterator.hasNext())
            {
              MediaBrowserCompat.MediaItem localMediaItem = (MediaBrowserCompat.MediaItem)localIterator.next();
              Parcel localParcel = Parcel.obtain();
              localMediaItem.writeToParcel(localParcel, 0);
              localArrayList.add(localParcel);
            }
            localObject = localArrayList;
          }
          paramResultWrapper.sendResult(localObject, getFlags());
        }
      };
      MediaBrowserServiceCompat.this.onLoadChildren(paramString, local1, paramBundle);
    }
  }

  class MediaBrowserServiceImplApi28 extends MediaBrowserServiceCompat.MediaBrowserServiceImplApi26
  {
    MediaBrowserServiceImplApi28()
    {
      super();
    }

    public MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo()
    {
      if (MediaBrowserServiceCompat.this.mCurConnection != null)
        return MediaBrowserServiceCompat.this.mCurConnection.browserInfo;
      return new MediaSessionManager.RemoteUserInfo(((MediaBrowserService)this.mServiceObj).getCurrentBrowserInfo());
    }
  }

  class MediaBrowserServiceImplBase
    implements MediaBrowserServiceCompat.MediaBrowserServiceImpl
  {
    private Messenger mMessenger;

    MediaBrowserServiceImplBase()
    {
    }

    public Bundle getBrowserRootHints()
    {
      if (MediaBrowserServiceCompat.this.mCurConnection == null)
        throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
      if (MediaBrowserServiceCompat.this.mCurConnection.rootHints == null)
        return null;
      return new Bundle(MediaBrowserServiceCompat.this.mCurConnection.rootHints);
    }

    public MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo()
    {
      if (MediaBrowserServiceCompat.this.mCurConnection == null)
        throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
      return MediaBrowserServiceCompat.this.mCurConnection.browserInfo;
    }

    public void notifyChildrenChanged(final MediaSessionManager.RemoteUserInfo paramRemoteUserInfo, final String paramString, final Bundle paramBundle)
    {
      MediaBrowserServiceCompat.this.mHandler.post(new Runnable()
      {
        public void run()
        {
          for (int i = 0; ; i++)
            if (i < MediaBrowserServiceCompat.this.mConnections.size())
            {
              MediaBrowserServiceCompat.ConnectionRecord localConnectionRecord = (MediaBrowserServiceCompat.ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.valueAt(i);
              if (localConnectionRecord.browserInfo.equals(paramRemoteUserInfo))
                MediaBrowserServiceCompat.MediaBrowserServiceImplBase.this.notifyChildrenChangedOnHandler(localConnectionRecord, paramString, paramBundle);
            }
            else
            {
              return;
            }
        }
      });
    }

    public void notifyChildrenChanged(final String paramString, final Bundle paramBundle)
    {
      MediaBrowserServiceCompat.this.mHandler.post(new Runnable()
      {
        public void run()
        {
          Iterator localIterator = MediaBrowserServiceCompat.this.mConnections.keySet().iterator();
          while (localIterator.hasNext())
          {
            IBinder localIBinder = (IBinder)localIterator.next();
            MediaBrowserServiceCompat.ConnectionRecord localConnectionRecord = (MediaBrowserServiceCompat.ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.get(localIBinder);
            MediaBrowserServiceCompat.MediaBrowserServiceImplBase.this.notifyChildrenChangedOnHandler(localConnectionRecord, paramString, paramBundle);
          }
        }
      });
    }

    void notifyChildrenChangedOnHandler(MediaBrowserServiceCompat.ConnectionRecord paramConnectionRecord, String paramString, Bundle paramBundle)
    {
      List localList = (List)paramConnectionRecord.subscriptions.get(paramString);
      if (localList != null)
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          Pair localPair = (Pair)localIterator.next();
          if (MediaBrowserCompatUtils.hasDuplicatedItems(paramBundle, (Bundle)localPair.second))
            MediaBrowserServiceCompat.this.performLoadChildren(paramString, paramConnectionRecord, (Bundle)localPair.second, paramBundle);
        }
      }
    }

    public IBinder onBind(Intent paramIntent)
    {
      if ("android.media.browse.MediaBrowserService".equals(paramIntent.getAction()))
        return this.mMessenger.getBinder();
      return null;
    }

    public void onCreate()
    {
      this.mMessenger = new Messenger(MediaBrowserServiceCompat.this.mHandler);
    }

    public void setSessionToken(final MediaSessionCompat.Token paramToken)
    {
      MediaBrowserServiceCompat.this.mHandler.post(new Runnable()
      {
        public void run()
        {
          Iterator localIterator = MediaBrowserServiceCompat.this.mConnections.values().iterator();
          while (localIterator.hasNext())
          {
            MediaBrowserServiceCompat.ConnectionRecord localConnectionRecord = (MediaBrowserServiceCompat.ConnectionRecord)localIterator.next();
            try
            {
              localConnectionRecord.callbacks.onConnect(localConnectionRecord.root.getRootId(), paramToken, localConnectionRecord.root.getExtras());
            }
            catch (RemoteException localRemoteException)
            {
              Log.w("MBServiceCompat", "Connection for " + localConnectionRecord.pkg + " is no longer valid.");
              localIterator.remove();
            }
          }
        }
      });
    }
  }

  public static class Result<T>
  {
    private final Object mDebug;
    private boolean mDetachCalled;
    private int mFlags;
    private boolean mSendErrorCalled;
    private boolean mSendProgressUpdateCalled;
    private boolean mSendResultCalled;

    Result(Object paramObject)
    {
      this.mDebug = paramObject;
    }

    private void checkExtraFields(Bundle paramBundle)
    {
      if (paramBundle == null);
      float f;
      do
      {
        do
          return;
        while (!paramBundle.containsKey("android.media.browse.extra.DOWNLOAD_PROGRESS"));
        f = paramBundle.getFloat("android.media.browse.extra.DOWNLOAD_PROGRESS");
      }
      while ((f >= -1.0E-005F) && (f <= 1.00001F));
      throw new IllegalArgumentException("The value of the EXTRA_DOWNLOAD_PROGRESS field must be a float number within [0.0, 1.0].");
    }

    public void detach()
    {
      if (this.mDetachCalled)
        throw new IllegalStateException("detach() called when detach() had already been called for: " + this.mDebug);
      if (this.mSendResultCalled)
        throw new IllegalStateException("detach() called when sendResult() had already been called for: " + this.mDebug);
      if (this.mSendErrorCalled)
        throw new IllegalStateException("detach() called when sendError() had already been called for: " + this.mDebug);
      this.mDetachCalled = true;
    }

    int getFlags()
    {
      return this.mFlags;
    }

    boolean isDone()
    {
      return (this.mDetachCalled) || (this.mSendResultCalled) || (this.mSendErrorCalled);
    }

    void onErrorSent(Bundle paramBundle)
    {
      throw new UnsupportedOperationException("It is not supported to send an error for " + this.mDebug);
    }

    void onProgressUpdateSent(Bundle paramBundle)
    {
      throw new UnsupportedOperationException("It is not supported to send an interim update for " + this.mDebug);
    }

    void onResultSent(T paramT)
    {
    }

    public void sendError(Bundle paramBundle)
    {
      if ((this.mSendResultCalled) || (this.mSendErrorCalled))
        throw new IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + this.mDebug);
      this.mSendErrorCalled = true;
      onErrorSent(paramBundle);
    }

    public void sendProgressUpdate(Bundle paramBundle)
    {
      if ((this.mSendResultCalled) || (this.mSendErrorCalled))
        throw new IllegalStateException("sendProgressUpdate() called when either sendResult() or sendError() had already been called for: " + this.mDebug);
      checkExtraFields(paramBundle);
      this.mSendProgressUpdateCalled = true;
      onProgressUpdateSent(paramBundle);
    }

    public void sendResult(T paramT)
    {
      if ((this.mSendResultCalled) || (this.mSendErrorCalled))
        throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.mDebug);
      this.mSendResultCalled = true;
      onResultSent(paramT);
    }

    void setFlags(int paramInt)
    {
      this.mFlags = paramInt;
    }
  }

  private class ServiceBinderImpl
  {
    ServiceBinderImpl()
    {
    }

    public void addSubscription(final String paramString, final IBinder paramIBinder, final Bundle paramBundle, final MediaBrowserServiceCompat.ServiceCallbacks paramServiceCallbacks)
    {
      MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable()
      {
        public void run()
        {
          IBinder localIBinder = paramServiceCallbacks.asBinder();
          MediaBrowserServiceCompat.ConnectionRecord localConnectionRecord = (MediaBrowserServiceCompat.ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.get(localIBinder);
          if (localConnectionRecord == null)
          {
            Log.w("MBServiceCompat", "addSubscription for callback that isn't registered id=" + paramString);
            return;
          }
          MediaBrowserServiceCompat.this.addSubscription(paramString, localConnectionRecord, paramIBinder, paramBundle);
        }
      });
    }

    public void connect(final String paramString, final int paramInt1, final int paramInt2, final Bundle paramBundle, final MediaBrowserServiceCompat.ServiceCallbacks paramServiceCallbacks)
    {
      if (!MediaBrowserServiceCompat.this.isValidPackage(paramString, paramInt2))
        throw new IllegalArgumentException("Package/uid mismatch: uid=" + paramInt2 + " package=" + paramString);
      MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable()
      {
        public void run()
        {
          IBinder localIBinder = paramServiceCallbacks.asBinder();
          MediaBrowserServiceCompat.this.mConnections.remove(localIBinder);
          MediaBrowserServiceCompat.ConnectionRecord localConnectionRecord = new MediaBrowserServiceCompat.ConnectionRecord(MediaBrowserServiceCompat.this, paramString, paramInt1, paramInt2, paramBundle, paramServiceCallbacks);
          MediaBrowserServiceCompat.this.mCurConnection = localConnectionRecord;
          localConnectionRecord.root = MediaBrowserServiceCompat.this.onGetRoot(paramString, paramInt2, paramBundle);
          MediaBrowserServiceCompat.this.mCurConnection = null;
          if (localConnectionRecord.root == null)
            Log.i("MBServiceCompat", "No root for client " + paramString + " from service " + getClass().getName());
          while (true)
          {
            try
            {
              paramServiceCallbacks.onConnectFailed();
              return;
            }
            catch (RemoteException localRemoteException2)
            {
              Log.w("MBServiceCompat", "Calling onConnectFailed() failed. Ignoring. pkg=" + paramString);
              return;
            }
            try
            {
              MediaBrowserServiceCompat.this.mConnections.put(localIBinder, localConnectionRecord);
              localIBinder.linkToDeath(localConnectionRecord, 0);
              if (MediaBrowserServiceCompat.this.mSession != null)
              {
                paramServiceCallbacks.onConnect(localConnectionRecord.root.getRootId(), MediaBrowserServiceCompat.this.mSession, localConnectionRecord.root.getExtras());
                return;
              }
            }
            catch (RemoteException localRemoteException1)
            {
              Log.w("MBServiceCompat", "Calling onConnect() failed. Dropping client. pkg=" + paramString);
              MediaBrowserServiceCompat.this.mConnections.remove(localIBinder);
            }
          }
        }
      });
    }

    public void disconnect(final MediaBrowserServiceCompat.ServiceCallbacks paramServiceCallbacks)
    {
      MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable()
      {
        public void run()
        {
          IBinder localIBinder = paramServiceCallbacks.asBinder();
          MediaBrowserServiceCompat.ConnectionRecord localConnectionRecord = (MediaBrowserServiceCompat.ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.remove(localIBinder);
          if (localConnectionRecord != null)
            localConnectionRecord.callbacks.asBinder().unlinkToDeath(localConnectionRecord, 0);
        }
      });
    }

    public void getMediaItem(final String paramString, final ResultReceiver paramResultReceiver, final MediaBrowserServiceCompat.ServiceCallbacks paramServiceCallbacks)
    {
      if ((TextUtils.isEmpty(paramString)) || (paramResultReceiver == null))
        return;
      MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable()
      {
        public void run()
        {
          IBinder localIBinder = paramServiceCallbacks.asBinder();
          MediaBrowserServiceCompat.ConnectionRecord localConnectionRecord = (MediaBrowserServiceCompat.ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.get(localIBinder);
          if (localConnectionRecord == null)
          {
            Log.w("MBServiceCompat", "getMediaItem for callback that isn't registered id=" + paramString);
            return;
          }
          MediaBrowserServiceCompat.this.performLoadItem(paramString, localConnectionRecord, paramResultReceiver);
        }
      });
    }

    public void registerCallbacks(final MediaBrowserServiceCompat.ServiceCallbacks paramServiceCallbacks, final String paramString, final int paramInt1, final int paramInt2, final Bundle paramBundle)
    {
      MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable()
      {
        public void run()
        {
          IBinder localIBinder = paramServiceCallbacks.asBinder();
          MediaBrowserServiceCompat.this.mConnections.remove(localIBinder);
          MediaBrowserServiceCompat.ConnectionRecord localConnectionRecord = new MediaBrowserServiceCompat.ConnectionRecord(MediaBrowserServiceCompat.this, paramString, paramInt1, paramInt2, paramBundle, paramServiceCallbacks);
          MediaBrowserServiceCompat.this.mConnections.put(localIBinder, localConnectionRecord);
          try
          {
            localIBinder.linkToDeath(localConnectionRecord, 0);
            return;
          }
          catch (RemoteException localRemoteException)
          {
            Log.w("MBServiceCompat", "IBinder is already dead.");
          }
        }
      });
    }

    public void removeSubscription(final String paramString, final IBinder paramIBinder, final MediaBrowserServiceCompat.ServiceCallbacks paramServiceCallbacks)
    {
      MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable()
      {
        public void run()
        {
          IBinder localIBinder = paramServiceCallbacks.asBinder();
          MediaBrowserServiceCompat.ConnectionRecord localConnectionRecord = (MediaBrowserServiceCompat.ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.get(localIBinder);
          if (localConnectionRecord == null)
            Log.w("MBServiceCompat", "removeSubscription for callback that isn't registered id=" + paramString);
          while (MediaBrowserServiceCompat.this.removeSubscription(paramString, localConnectionRecord, paramIBinder))
            return;
          Log.w("MBServiceCompat", "removeSubscription called for " + paramString + " which is not subscribed");
        }
      });
    }

    public void search(final String paramString, final Bundle paramBundle, final ResultReceiver paramResultReceiver, final MediaBrowserServiceCompat.ServiceCallbacks paramServiceCallbacks)
    {
      if ((TextUtils.isEmpty(paramString)) || (paramResultReceiver == null))
        return;
      MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable()
      {
        public void run()
        {
          IBinder localIBinder = paramServiceCallbacks.asBinder();
          MediaBrowserServiceCompat.ConnectionRecord localConnectionRecord = (MediaBrowserServiceCompat.ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.get(localIBinder);
          if (localConnectionRecord == null)
          {
            Log.w("MBServiceCompat", "search for callback that isn't registered query=" + paramString);
            return;
          }
          MediaBrowserServiceCompat.this.performSearch(paramString, paramBundle, localConnectionRecord, paramResultReceiver);
        }
      });
    }

    public void sendCustomAction(final String paramString, final Bundle paramBundle, final ResultReceiver paramResultReceiver, final MediaBrowserServiceCompat.ServiceCallbacks paramServiceCallbacks)
    {
      if ((TextUtils.isEmpty(paramString)) || (paramResultReceiver == null))
        return;
      MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable()
      {
        public void run()
        {
          IBinder localIBinder = paramServiceCallbacks.asBinder();
          MediaBrowserServiceCompat.ConnectionRecord localConnectionRecord = (MediaBrowserServiceCompat.ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.get(localIBinder);
          if (localConnectionRecord == null)
          {
            Log.w("MBServiceCompat", "sendCustomAction for callback that isn't registered action=" + paramString + ", extras=" + paramBundle);
            return;
          }
          MediaBrowserServiceCompat.this.performCustomAction(paramString, paramBundle, localConnectionRecord, paramResultReceiver);
        }
      });
    }

    public void unregisterCallbacks(final MediaBrowserServiceCompat.ServiceCallbacks paramServiceCallbacks)
    {
      MediaBrowserServiceCompat.this.mHandler.postOrRun(new Runnable()
      {
        public void run()
        {
          IBinder localIBinder = paramServiceCallbacks.asBinder();
          MediaBrowserServiceCompat.ConnectionRecord localConnectionRecord = (MediaBrowserServiceCompat.ConnectionRecord)MediaBrowserServiceCompat.this.mConnections.remove(localIBinder);
          if (localConnectionRecord != null)
            localIBinder.unlinkToDeath(localConnectionRecord, 0);
        }
      });
    }
  }

  private static abstract interface ServiceCallbacks
  {
    public abstract IBinder asBinder();

    public abstract void onConnect(String paramString, MediaSessionCompat.Token paramToken, Bundle paramBundle)
      throws RemoteException;

    public abstract void onConnectFailed()
      throws RemoteException;

    public abstract void onLoadChildren(String paramString, List<MediaBrowserCompat.MediaItem> paramList, Bundle paramBundle1, Bundle paramBundle2)
      throws RemoteException;
  }

  private static class ServiceCallbacksCompat
    implements MediaBrowserServiceCompat.ServiceCallbacks
  {
    final Messenger mCallbacks;

    ServiceCallbacksCompat(Messenger paramMessenger)
    {
      this.mCallbacks = paramMessenger;
    }

    private void sendRequest(int paramInt, Bundle paramBundle)
      throws RemoteException
    {
      Message localMessage = Message.obtain();
      localMessage.what = paramInt;
      localMessage.arg1 = 2;
      localMessage.setData(paramBundle);
      this.mCallbacks.send(localMessage);
    }

    public IBinder asBinder()
    {
      return this.mCallbacks.getBinder();
    }

    public void onConnect(String paramString, MediaSessionCompat.Token paramToken, Bundle paramBundle)
      throws RemoteException
    {
      if (paramBundle == null)
        paramBundle = new Bundle();
      paramBundle.putInt("extra_service_version", 2);
      Bundle localBundle = new Bundle();
      localBundle.putString("data_media_item_id", paramString);
      localBundle.putParcelable("data_media_session_token", paramToken);
      localBundle.putBundle("data_root_hints", paramBundle);
      sendRequest(1, localBundle);
    }

    public void onConnectFailed()
      throws RemoteException
    {
      sendRequest(2, null);
    }

    public void onLoadChildren(String paramString, List<MediaBrowserCompat.MediaItem> paramList, Bundle paramBundle1, Bundle paramBundle2)
      throws RemoteException
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("data_media_item_id", paramString);
      localBundle.putBundle("data_options", paramBundle1);
      localBundle.putBundle("data_notify_children_changed_options", paramBundle2);
      if (paramList != null)
        if (!(paramList instanceof ArrayList))
          break label68;
      label68: for (ArrayList localArrayList = (ArrayList)paramList; ; localArrayList = new ArrayList(paramList))
      {
        localBundle.putParcelableArrayList("data_media_item_list", localArrayList);
        sendRequest(3, localBundle);
        return;
      }
    }
  }

  private final class ServiceHandler extends Handler
  {
    private final MediaBrowserServiceCompat.ServiceBinderImpl mServiceBinderImpl = new MediaBrowserServiceCompat.ServiceBinderImpl(MediaBrowserServiceCompat.this);

    ServiceHandler()
    {
    }

    public void handleMessage(Message paramMessage)
    {
      Bundle localBundle1 = paramMessage.getData();
      switch (paramMessage.what)
      {
      default:
        Log.w("MBServiceCompat", "Unhandled message: " + paramMessage + "\n  Service version: " + 2 + "\n  Client version: " + paramMessage.arg1);
        return;
      case 1:
        Bundle localBundle6 = localBundle1.getBundle("data_root_hints");
        MediaSessionCompat.ensureClassLoader(localBundle6);
        this.mServiceBinderImpl.connect(localBundle1.getString("data_package_name"), localBundle1.getInt("data_calling_pid"), localBundle1.getInt("data_calling_uid"), localBundle6, new MediaBrowserServiceCompat.ServiceCallbacksCompat(paramMessage.replyTo));
        return;
      case 2:
        this.mServiceBinderImpl.disconnect(new MediaBrowserServiceCompat.ServiceCallbacksCompat(paramMessage.replyTo));
        return;
      case 3:
        Bundle localBundle5 = localBundle1.getBundle("data_options");
        MediaSessionCompat.ensureClassLoader(localBundle5);
        this.mServiceBinderImpl.addSubscription(localBundle1.getString("data_media_item_id"), BundleCompat.getBinder(localBundle1, "data_callback_token"), localBundle5, new MediaBrowserServiceCompat.ServiceCallbacksCompat(paramMessage.replyTo));
        return;
      case 4:
        this.mServiceBinderImpl.removeSubscription(localBundle1.getString("data_media_item_id"), BundleCompat.getBinder(localBundle1, "data_callback_token"), new MediaBrowserServiceCompat.ServiceCallbacksCompat(paramMessage.replyTo));
        return;
      case 5:
        this.mServiceBinderImpl.getMediaItem(localBundle1.getString("data_media_item_id"), (ResultReceiver)localBundle1.getParcelable("data_result_receiver"), new MediaBrowserServiceCompat.ServiceCallbacksCompat(paramMessage.replyTo));
        return;
      case 6:
        Bundle localBundle4 = localBundle1.getBundle("data_root_hints");
        MediaSessionCompat.ensureClassLoader(localBundle4);
        this.mServiceBinderImpl.registerCallbacks(new MediaBrowserServiceCompat.ServiceCallbacksCompat(paramMessage.replyTo), localBundle1.getString("data_package_name"), localBundle1.getInt("data_calling_pid"), localBundle1.getInt("data_calling_uid"), localBundle4);
        return;
      case 7:
        this.mServiceBinderImpl.unregisterCallbacks(new MediaBrowserServiceCompat.ServiceCallbacksCompat(paramMessage.replyTo));
        return;
      case 8:
        Bundle localBundle3 = localBundle1.getBundle("data_search_extras");
        MediaSessionCompat.ensureClassLoader(localBundle3);
        this.mServiceBinderImpl.search(localBundle1.getString("data_search_query"), localBundle3, (ResultReceiver)localBundle1.getParcelable("data_result_receiver"), new MediaBrowserServiceCompat.ServiceCallbacksCompat(paramMessage.replyTo));
        return;
      case 9:
      }
      Bundle localBundle2 = localBundle1.getBundle("data_custom_action_extras");
      MediaSessionCompat.ensureClassLoader(localBundle2);
      this.mServiceBinderImpl.sendCustomAction(localBundle1.getString("data_custom_action"), localBundle2, (ResultReceiver)localBundle1.getParcelable("data_result_receiver"), new MediaBrowserServiceCompat.ServiceCallbacksCompat(paramMessage.replyTo));
    }

    public void postOrRun(Runnable paramRunnable)
    {
      if (Thread.currentThread() == getLooper().getThread())
      {
        paramRunnable.run();
        return;
      }
      post(paramRunnable);
    }

    public boolean sendMessageAtTime(Message paramMessage, long paramLong)
    {
      Bundle localBundle = paramMessage.getData();
      localBundle.setClassLoader(MediaBrowserCompat.class.getClassLoader());
      localBundle.putInt("data_calling_uid", Binder.getCallingUid());
      localBundle.putInt("data_calling_pid", Binder.getCallingPid());
      return super.sendMessageAtTime(paramMessage, paramLong);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserServiceCompat
 * JD-Core Version:    0.6.2
 */