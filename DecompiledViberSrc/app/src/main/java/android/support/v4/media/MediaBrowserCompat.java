package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.support.v4.app.BundleCompat;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.IMediaSession.Stub;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.os.ResultReceiver;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class MediaBrowserCompat
{
  public static final String CUSTOM_ACTION_DOWNLOAD = "android.support.v4.media.action.DOWNLOAD";
  public static final String CUSTOM_ACTION_REMOVE_DOWNLOADED_FILE = "android.support.v4.media.action.REMOVE_DOWNLOADED_FILE";
  static final boolean DEBUG = false;
  public static final String EXTRA_DOWNLOAD_PROGRESS = "android.media.browse.extra.DOWNLOAD_PROGRESS";
  public static final String EXTRA_MEDIA_ID = "android.media.browse.extra.MEDIA_ID";
  public static final String EXTRA_PAGE = "android.media.browse.extra.PAGE";
  public static final String EXTRA_PAGE_SIZE = "android.media.browse.extra.PAGE_SIZE";
  static final String TAG = "MediaBrowserCompat";
  private final MediaBrowserImpl mImpl;

  public MediaBrowserCompat(Context paramContext, ComponentName paramComponentName, ConnectionCallback paramConnectionCallback, Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      this.mImpl = new MediaBrowserImplApi26(paramContext, paramComponentName, paramConnectionCallback, paramBundle);
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      this.mImpl = new MediaBrowserImplApi23(paramContext, paramComponentName, paramConnectionCallback, paramBundle);
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.mImpl = new MediaBrowserImplApi21(paramContext, paramComponentName, paramConnectionCallback, paramBundle);
      return;
    }
    this.mImpl = new MediaBrowserImplBase(paramContext, paramComponentName, paramConnectionCallback, paramBundle);
  }

  public void connect()
  {
    this.mImpl.connect();
  }

  public void disconnect()
  {
    this.mImpl.disconnect();
  }

  public Bundle getExtras()
  {
    return this.mImpl.getExtras();
  }

  public void getItem(String paramString, ItemCallback paramItemCallback)
  {
    this.mImpl.getItem(paramString, paramItemCallback);
  }

  public Bundle getNotifyChildrenChangedOptions()
  {
    return this.mImpl.getNotifyChildrenChangedOptions();
  }

  public String getRoot()
  {
    return this.mImpl.getRoot();
  }

  public ComponentName getServiceComponent()
  {
    return this.mImpl.getServiceComponent();
  }

  public MediaSessionCompat.Token getSessionToken()
  {
    return this.mImpl.getSessionToken();
  }

  public boolean isConnected()
  {
    return this.mImpl.isConnected();
  }

  public void search(String paramString, Bundle paramBundle, SearchCallback paramSearchCallback)
  {
    if (TextUtils.isEmpty(paramString))
      throw new IllegalArgumentException("query cannot be empty");
    if (paramSearchCallback == null)
      throw new IllegalArgumentException("callback cannot be null");
    this.mImpl.search(paramString, paramBundle, paramSearchCallback);
  }

  public void sendCustomAction(String paramString, Bundle paramBundle, CustomActionCallback paramCustomActionCallback)
  {
    if (TextUtils.isEmpty(paramString))
      throw new IllegalArgumentException("action cannot be empty");
    this.mImpl.sendCustomAction(paramString, paramBundle, paramCustomActionCallback);
  }

  public void subscribe(String paramString, Bundle paramBundle, SubscriptionCallback paramSubscriptionCallback)
  {
    if (TextUtils.isEmpty(paramString))
      throw new IllegalArgumentException("parentId is empty");
    if (paramSubscriptionCallback == null)
      throw new IllegalArgumentException("callback is null");
    if (paramBundle == null)
      throw new IllegalArgumentException("options are null");
    this.mImpl.subscribe(paramString, paramBundle, paramSubscriptionCallback);
  }

  public void subscribe(String paramString, SubscriptionCallback paramSubscriptionCallback)
  {
    if (TextUtils.isEmpty(paramString))
      throw new IllegalArgumentException("parentId is empty");
    if (paramSubscriptionCallback == null)
      throw new IllegalArgumentException("callback is null");
    this.mImpl.subscribe(paramString, null, paramSubscriptionCallback);
  }

  public void unsubscribe(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      throw new IllegalArgumentException("parentId is empty");
    this.mImpl.unsubscribe(paramString, null);
  }

  public void unsubscribe(String paramString, SubscriptionCallback paramSubscriptionCallback)
  {
    if (TextUtils.isEmpty(paramString))
      throw new IllegalArgumentException("parentId is empty");
    if (paramSubscriptionCallback == null)
      throw new IllegalArgumentException("callback is null");
    this.mImpl.unsubscribe(paramString, paramSubscriptionCallback);
  }

  private static class CallbackHandler extends Handler
  {
    private final WeakReference<MediaBrowserCompat.MediaBrowserServiceCallbackImpl> mCallbackImplRef;
    private WeakReference<Messenger> mCallbacksMessengerRef;

    CallbackHandler(MediaBrowserCompat.MediaBrowserServiceCallbackImpl paramMediaBrowserServiceCallbackImpl)
    {
      this.mCallbackImplRef = new WeakReference(paramMediaBrowserServiceCallbackImpl);
    }

    public void handleMessage(Message paramMessage)
    {
      if ((this.mCallbacksMessengerRef == null) || (this.mCallbacksMessengerRef.get() == null) || (this.mCallbackImplRef.get() == null));
      Bundle localBundle1;
      MediaBrowserCompat.MediaBrowserServiceCallbackImpl localMediaBrowserServiceCallbackImpl;
      Messenger localMessenger;
      do
      {
        return;
        localBundle1 = paramMessage.getData();
        MediaSessionCompat.ensureClassLoader(localBundle1);
        localMediaBrowserServiceCallbackImpl = (MediaBrowserCompat.MediaBrowserServiceCallbackImpl)this.mCallbackImplRef.get();
        localMessenger = (Messenger)this.mCallbacksMessengerRef.get();
        try
        {
          switch (paramMessage.what)
          {
          default:
            Log.w("MediaBrowserCompat", "Unhandled message: " + paramMessage + "\n  Client version: " + 1 + "\n  Service version: " + paramMessage.arg1);
            return;
          case 1:
          case 2:
          case 3:
          }
        }
        catch (BadParcelableException localBadParcelableException)
        {
          Log.e("MediaBrowserCompat", "Could not unparcel the data.");
        }
      }
      while (paramMessage.what != 1);
      localMediaBrowserServiceCallbackImpl.onConnectionFailed(localMessenger);
      return;
      Bundle localBundle4 = localBundle1.getBundle("data_root_hints");
      MediaSessionCompat.ensureClassLoader(localBundle4);
      localMediaBrowserServiceCallbackImpl.onServiceConnected(localMessenger, localBundle1.getString("data_media_item_id"), (MediaSessionCompat.Token)localBundle1.getParcelable("data_media_session_token"), localBundle4);
      return;
      localMediaBrowserServiceCallbackImpl.onConnectionFailed(localMessenger);
      return;
      Bundle localBundle2 = localBundle1.getBundle("data_options");
      MediaSessionCompat.ensureClassLoader(localBundle2);
      Bundle localBundle3 = localBundle1.getBundle("data_notify_children_changed_options");
      MediaSessionCompat.ensureClassLoader(localBundle3);
      localMediaBrowserServiceCallbackImpl.onLoadChildren(localMessenger, localBundle1.getString("data_media_item_id"), localBundle1.getParcelableArrayList("data_media_item_list"), localBundle2, localBundle3);
    }

    void setCallbacksMessenger(Messenger paramMessenger)
    {
      this.mCallbacksMessengerRef = new WeakReference(paramMessenger);
    }
  }

  public static class ConnectionCallback
  {
    ConnectionCallbackInternal mConnectionCallbackInternal;
    final Object mConnectionCallbackObj;

    public ConnectionCallback()
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        this.mConnectionCallbackObj = MediaBrowserCompatApi21.createConnectionCallback(new StubApi21());
        return;
      }
      this.mConnectionCallbackObj = null;
    }

    public void onConnected()
    {
    }

    public void onConnectionFailed()
    {
    }

    public void onConnectionSuspended()
    {
    }

    void setInternalConnectionCallback(ConnectionCallbackInternal paramConnectionCallbackInternal)
    {
      this.mConnectionCallbackInternal = paramConnectionCallbackInternal;
    }

    static abstract interface ConnectionCallbackInternal
    {
      public abstract void onConnected();

      public abstract void onConnectionFailed();

      public abstract void onConnectionSuspended();
    }

    private class StubApi21
      implements MediaBrowserCompatApi21.ConnectionCallback
    {
      StubApi21()
      {
      }

      public void onConnected()
      {
        if (MediaBrowserCompat.ConnectionCallback.this.mConnectionCallbackInternal != null)
          MediaBrowserCompat.ConnectionCallback.this.mConnectionCallbackInternal.onConnected();
        MediaBrowserCompat.ConnectionCallback.this.onConnected();
      }

      public void onConnectionFailed()
      {
        if (MediaBrowserCompat.ConnectionCallback.this.mConnectionCallbackInternal != null)
          MediaBrowserCompat.ConnectionCallback.this.mConnectionCallbackInternal.onConnectionFailed();
        MediaBrowserCompat.ConnectionCallback.this.onConnectionFailed();
      }

      public void onConnectionSuspended()
      {
        if (MediaBrowserCompat.ConnectionCallback.this.mConnectionCallbackInternal != null)
          MediaBrowserCompat.ConnectionCallback.this.mConnectionCallbackInternal.onConnectionSuspended();
        MediaBrowserCompat.ConnectionCallback.this.onConnectionSuspended();
      }
    }
  }

  public static abstract class CustomActionCallback
  {
    public void onError(String paramString, Bundle paramBundle1, Bundle paramBundle2)
    {
    }

    public void onProgressUpdate(String paramString, Bundle paramBundle1, Bundle paramBundle2)
    {
    }

    public void onResult(String paramString, Bundle paramBundle1, Bundle paramBundle2)
    {
    }
  }

  private static class CustomActionResultReceiver extends ResultReceiver
  {
    private final String mAction;
    private final MediaBrowserCompat.CustomActionCallback mCallback;
    private final Bundle mExtras;

    CustomActionResultReceiver(String paramString, Bundle paramBundle, MediaBrowserCompat.CustomActionCallback paramCustomActionCallback, Handler paramHandler)
    {
      super();
      this.mAction = paramString;
      this.mExtras = paramBundle;
      this.mCallback = paramCustomActionCallback;
    }

    protected void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      if (this.mCallback == null)
        return;
      MediaSessionCompat.ensureClassLoader(paramBundle);
      switch (paramInt)
      {
      default:
        Log.w("MediaBrowserCompat", "Unknown result code: " + paramInt + " (extras=" + this.mExtras + ", resultData=" + paramBundle + ")");
        return;
      case 1:
        this.mCallback.onProgressUpdate(this.mAction, this.mExtras, paramBundle);
        return;
      case 0:
        this.mCallback.onResult(this.mAction, this.mExtras, paramBundle);
        return;
      case -1:
      }
      this.mCallback.onError(this.mAction, this.mExtras, paramBundle);
    }
  }

  public static abstract class ItemCallback
  {
    final Object mItemCallbackObj;

    public ItemCallback()
    {
      if (Build.VERSION.SDK_INT >= 23)
      {
        this.mItemCallbackObj = MediaBrowserCompatApi23.createItemCallback(new StubApi23());
        return;
      }
      this.mItemCallbackObj = null;
    }

    public void onError(String paramString)
    {
    }

    public void onItemLoaded(MediaBrowserCompat.MediaItem paramMediaItem)
    {
    }

    private class StubApi23
      implements MediaBrowserCompatApi23.ItemCallback
    {
      StubApi23()
      {
      }

      public void onError(String paramString)
      {
        MediaBrowserCompat.ItemCallback.this.onError(paramString);
      }

      public void onItemLoaded(Parcel paramParcel)
      {
        if (paramParcel == null)
        {
          MediaBrowserCompat.ItemCallback.this.onItemLoaded(null);
          return;
        }
        paramParcel.setDataPosition(0);
        MediaBrowserCompat.MediaItem localMediaItem = (MediaBrowserCompat.MediaItem)MediaBrowserCompat.MediaItem.CREATOR.createFromParcel(paramParcel);
        paramParcel.recycle();
        MediaBrowserCompat.ItemCallback.this.onItemLoaded(localMediaItem);
      }
    }
  }

  private static class ItemReceiver extends ResultReceiver
  {
    private final MediaBrowserCompat.ItemCallback mCallback;
    private final String mMediaId;

    ItemReceiver(String paramString, MediaBrowserCompat.ItemCallback paramItemCallback, Handler paramHandler)
    {
      super();
      this.mMediaId = paramString;
      this.mCallback = paramItemCallback;
    }

    protected void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      MediaSessionCompat.ensureClassLoader(paramBundle);
      if ((paramInt != 0) || (paramBundle == null) || (!paramBundle.containsKey("media_item")))
      {
        this.mCallback.onError(this.mMediaId);
        return;
      }
      Parcelable localParcelable = paramBundle.getParcelable("media_item");
      if ((localParcelable == null) || ((localParcelable instanceof MediaBrowserCompat.MediaItem)))
      {
        this.mCallback.onItemLoaded((MediaBrowserCompat.MediaItem)localParcelable);
        return;
      }
      this.mCallback.onError(this.mMediaId);
    }
  }

  static abstract interface MediaBrowserImpl
  {
    public abstract void connect();

    public abstract void disconnect();

    public abstract Bundle getExtras();

    public abstract void getItem(String paramString, MediaBrowserCompat.ItemCallback paramItemCallback);

    public abstract Bundle getNotifyChildrenChangedOptions();

    public abstract String getRoot();

    public abstract ComponentName getServiceComponent();

    public abstract MediaSessionCompat.Token getSessionToken();

    public abstract boolean isConnected();

    public abstract void search(String paramString, Bundle paramBundle, MediaBrowserCompat.SearchCallback paramSearchCallback);

    public abstract void sendCustomAction(String paramString, Bundle paramBundle, MediaBrowserCompat.CustomActionCallback paramCustomActionCallback);

    public abstract void subscribe(String paramString, Bundle paramBundle, MediaBrowserCompat.SubscriptionCallback paramSubscriptionCallback);

    public abstract void unsubscribe(String paramString, MediaBrowserCompat.SubscriptionCallback paramSubscriptionCallback);
  }

  static class MediaBrowserImplApi21
    implements MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal, MediaBrowserCompat.MediaBrowserImpl, MediaBrowserCompat.MediaBrowserServiceCallbackImpl
  {
    protected final Object mBrowserObj;
    protected Messenger mCallbacksMessenger;
    final Context mContext;
    protected final MediaBrowserCompat.CallbackHandler mHandler = new MediaBrowserCompat.CallbackHandler(this);
    private MediaSessionCompat.Token mMediaSessionToken;
    private Bundle mNotifyChildrenChangedOptions;
    protected final Bundle mRootHints;
    protected MediaBrowserCompat.ServiceBinderWrapper mServiceBinderWrapper;
    protected int mServiceVersion;
    private final ArrayMap<String, MediaBrowserCompat.Subscription> mSubscriptions = new ArrayMap();

    MediaBrowserImplApi21(Context paramContext, ComponentName paramComponentName, MediaBrowserCompat.ConnectionCallback paramConnectionCallback, Bundle paramBundle)
    {
      this.mContext = paramContext;
      if (paramBundle != null);
      for (Bundle localBundle = new Bundle(paramBundle); ; localBundle = new Bundle())
      {
        this.mRootHints = localBundle;
        this.mRootHints.putInt("extra_client_version", 1);
        paramConnectionCallback.setInternalConnectionCallback(this);
        this.mBrowserObj = MediaBrowserCompatApi21.createBrowser(paramContext, paramComponentName, paramConnectionCallback.mConnectionCallbackObj, this.mRootHints);
        return;
      }
    }

    public void connect()
    {
      MediaBrowserCompatApi21.connect(this.mBrowserObj);
    }

    public void disconnect()
    {
      if ((this.mServiceBinderWrapper != null) && (this.mCallbacksMessenger != null));
      try
      {
        this.mServiceBinderWrapper.unregisterCallbackMessenger(this.mCallbacksMessenger);
        MediaBrowserCompatApi21.disconnect(this.mBrowserObj);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        while (true)
          Log.i("MediaBrowserCompat", "Remote error unregistering client messenger.");
      }
    }

    public Bundle getExtras()
    {
      return MediaBrowserCompatApi21.getExtras(this.mBrowserObj);
    }

    public void getItem(final String paramString, final MediaBrowserCompat.ItemCallback paramItemCallback)
    {
      if (TextUtils.isEmpty(paramString))
        throw new IllegalArgumentException("mediaId is empty");
      if (paramItemCallback == null)
        throw new IllegalArgumentException("cb is null");
      if (!MediaBrowserCompatApi21.isConnected(this.mBrowserObj))
      {
        Log.i("MediaBrowserCompat", "Not connected, unable to retrieve the MediaItem.");
        this.mHandler.post(new Runnable()
        {
          public void run()
          {
            paramItemCallback.onError(paramString);
          }
        });
        return;
      }
      if (this.mServiceBinderWrapper == null)
      {
        this.mHandler.post(new Runnable()
        {
          public void run()
          {
            paramItemCallback.onError(paramString);
          }
        });
        return;
      }
      MediaBrowserCompat.ItemReceiver localItemReceiver = new MediaBrowserCompat.ItemReceiver(paramString, paramItemCallback, this.mHandler);
      try
      {
        this.mServiceBinderWrapper.getMediaItem(paramString, localItemReceiver, this.mCallbacksMessenger);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        Log.i("MediaBrowserCompat", "Remote error getting media item: " + paramString);
        this.mHandler.post(new Runnable()
        {
          public void run()
          {
            paramItemCallback.onError(paramString);
          }
        });
      }
    }

    public Bundle getNotifyChildrenChangedOptions()
    {
      return this.mNotifyChildrenChangedOptions;
    }

    public String getRoot()
    {
      return MediaBrowserCompatApi21.getRoot(this.mBrowserObj);
    }

    public ComponentName getServiceComponent()
    {
      return MediaBrowserCompatApi21.getServiceComponent(this.mBrowserObj);
    }

    public MediaSessionCompat.Token getSessionToken()
    {
      if (this.mMediaSessionToken == null)
        this.mMediaSessionToken = MediaSessionCompat.Token.fromToken(MediaBrowserCompatApi21.getSessionToken(this.mBrowserObj));
      return this.mMediaSessionToken;
    }

    public boolean isConnected()
    {
      return MediaBrowserCompatApi21.isConnected(this.mBrowserObj);
    }

    public void onConnected()
    {
      Bundle localBundle = MediaBrowserCompatApi21.getExtras(this.mBrowserObj);
      if (localBundle == null);
      while (true)
      {
        return;
        this.mServiceVersion = localBundle.getInt("extra_service_version", 0);
        IBinder localIBinder = BundleCompat.getBinder(localBundle, "extra_messenger");
        if (localIBinder != null)
        {
          this.mServiceBinderWrapper = new MediaBrowserCompat.ServiceBinderWrapper(localIBinder, this.mRootHints);
          this.mCallbacksMessenger = new Messenger(this.mHandler);
          this.mHandler.setCallbacksMessenger(this.mCallbacksMessenger);
        }
        try
        {
          this.mServiceBinderWrapper.registerCallbackMessenger(this.mContext, this.mCallbacksMessenger);
          IMediaSession localIMediaSession = IMediaSession.Stub.asInterface(BundleCompat.getBinder(localBundle, "extra_session_binder"));
          if (localIMediaSession == null)
            continue;
          this.mMediaSessionToken = MediaSessionCompat.Token.fromToken(MediaBrowserCompatApi21.getSessionToken(this.mBrowserObj), localIMediaSession);
          return;
        }
        catch (RemoteException localRemoteException)
        {
          while (true)
            Log.i("MediaBrowserCompat", "Remote error registering client messenger.");
        }
      }
    }

    public void onConnectionFailed()
    {
    }

    public void onConnectionFailed(Messenger paramMessenger)
    {
    }

    public void onConnectionSuspended()
    {
      this.mServiceBinderWrapper = null;
      this.mCallbacksMessenger = null;
      this.mMediaSessionToken = null;
      this.mHandler.setCallbacksMessenger(null);
    }

    public void onLoadChildren(Messenger paramMessenger, String paramString, List paramList, Bundle paramBundle1, Bundle paramBundle2)
    {
      if (this.mCallbacksMessenger != paramMessenger);
      MediaBrowserCompat.SubscriptionCallback localSubscriptionCallback;
      do
      {
        MediaBrowserCompat.Subscription localSubscription;
        do
        {
          return;
          localSubscription = (MediaBrowserCompat.Subscription)this.mSubscriptions.get(paramString);
          if (localSubscription != null)
            break;
        }
        while (!MediaBrowserCompat.DEBUG);
        Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + paramString);
        return;
        localSubscriptionCallback = localSubscription.getCallback(paramBundle1);
      }
      while (localSubscriptionCallback == null);
      if (paramBundle1 == null)
      {
        if (paramList == null)
        {
          localSubscriptionCallback.onError(paramString);
          return;
        }
        this.mNotifyChildrenChangedOptions = paramBundle2;
        localSubscriptionCallback.onChildrenLoaded(paramString, paramList);
        this.mNotifyChildrenChangedOptions = null;
        return;
      }
      if (paramList == null)
      {
        localSubscriptionCallback.onError(paramString, paramBundle1);
        return;
      }
      this.mNotifyChildrenChangedOptions = paramBundle2;
      localSubscriptionCallback.onChildrenLoaded(paramString, paramList, paramBundle1);
      this.mNotifyChildrenChangedOptions = null;
    }

    public void onServiceConnected(Messenger paramMessenger, String paramString, MediaSessionCompat.Token paramToken, Bundle paramBundle)
    {
    }

    public void search(final String paramString, final Bundle paramBundle, final MediaBrowserCompat.SearchCallback paramSearchCallback)
    {
      if (!isConnected())
        throw new IllegalStateException("search() called while not connected");
      if (this.mServiceBinderWrapper == null)
      {
        Log.i("MediaBrowserCompat", "The connected service doesn't support search.");
        this.mHandler.post(new Runnable()
        {
          public void run()
          {
            paramSearchCallback.onError(paramString, paramBundle);
          }
        });
        return;
      }
      MediaBrowserCompat.SearchResultReceiver localSearchResultReceiver = new MediaBrowserCompat.SearchResultReceiver(paramString, paramBundle, paramSearchCallback, this.mHandler);
      try
      {
        this.mServiceBinderWrapper.search(paramString, paramBundle, localSearchResultReceiver, this.mCallbacksMessenger);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        Log.i("MediaBrowserCompat", "Remote error searching items with query: " + paramString, localRemoteException);
        this.mHandler.post(new Runnable()
        {
          public void run()
          {
            paramSearchCallback.onError(paramString, paramBundle);
          }
        });
      }
    }

    public void sendCustomAction(final String paramString, final Bundle paramBundle, final MediaBrowserCompat.CustomActionCallback paramCustomActionCallback)
    {
      if (!isConnected())
        throw new IllegalStateException("Cannot send a custom action (" + paramString + ") with " + "extras " + paramBundle + " because the browser is not connected to the " + "service.");
      if (this.mServiceBinderWrapper == null)
      {
        Log.i("MediaBrowserCompat", "The connected service doesn't support sendCustomAction.");
        if (paramCustomActionCallback != null)
          this.mHandler.post(new Runnable()
          {
            public void run()
            {
              paramCustomActionCallback.onError(paramString, paramBundle, null);
            }
          });
      }
      MediaBrowserCompat.CustomActionResultReceiver localCustomActionResultReceiver = new MediaBrowserCompat.CustomActionResultReceiver(paramString, paramBundle, paramCustomActionCallback, this.mHandler);
      try
      {
        this.mServiceBinderWrapper.sendCustomAction(paramString, paramBundle, localCustomActionResultReceiver, this.mCallbacksMessenger);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        do
          Log.i("MediaBrowserCompat", "Remote error sending a custom action: action=" + paramString + ", extras=" + paramBundle, localRemoteException);
        while (paramCustomActionCallback == null);
        this.mHandler.post(new Runnable()
        {
          public void run()
          {
            paramCustomActionCallback.onError(paramString, paramBundle, null);
          }
        });
      }
    }

    public void subscribe(String paramString, Bundle paramBundle, MediaBrowserCompat.SubscriptionCallback paramSubscriptionCallback)
    {
      MediaBrowserCompat.Subscription localSubscription = (MediaBrowserCompat.Subscription)this.mSubscriptions.get(paramString);
      if (localSubscription == null)
      {
        localSubscription = new MediaBrowserCompat.Subscription();
        this.mSubscriptions.put(paramString, localSubscription);
      }
      paramSubscriptionCallback.setSubscription(localSubscription);
      if (paramBundle == null);
      for (Bundle localBundle = null; ; localBundle = new Bundle(paramBundle))
      {
        localSubscription.putCallback(localBundle, paramSubscriptionCallback);
        if (this.mServiceBinderWrapper != null)
          break;
        MediaBrowserCompatApi21.subscribe(this.mBrowserObj, paramString, paramSubscriptionCallback.mSubscriptionCallbackObj);
        return;
      }
      try
      {
        this.mServiceBinderWrapper.addSubscription(paramString, paramSubscriptionCallback.mToken, localBundle, this.mCallbacksMessenger);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        Log.i("MediaBrowserCompat", "Remote error subscribing media item: " + paramString);
      }
    }

    public void unsubscribe(String paramString, MediaBrowserCompat.SubscriptionCallback paramSubscriptionCallback)
    {
      MediaBrowserCompat.Subscription localSubscription = (MediaBrowserCompat.Subscription)this.mSubscriptions.get(paramString);
      if (localSubscription == null)
        return;
      if (this.mServiceBinderWrapper == null)
        if (paramSubscriptionCallback == null)
          MediaBrowserCompatApi21.unsubscribe(this.mBrowserObj, paramString);
      while (true)
        if ((localSubscription.isEmpty()) || (paramSubscriptionCallback == null))
        {
          this.mSubscriptions.remove(paramString);
          return;
          List localList3 = localSubscription.getCallbacks();
          List localList4 = localSubscription.getOptionsList();
          for (int j = -1 + localList3.size(); j >= 0; j--)
            if (localList3.get(j) == paramSubscriptionCallback)
            {
              localList3.remove(j);
              localList4.remove(j);
            }
          if (localList3.size() == 0)
          {
            MediaBrowserCompatApi21.unsubscribe(this.mBrowserObj, paramString);
            continue;
            if (paramSubscriptionCallback == null)
              try
              {
                this.mServiceBinderWrapper.removeSubscription(paramString, null, this.mCallbacksMessenger);
              }
              catch (RemoteException localRemoteException)
              {
                Log.d("MediaBrowserCompat", "removeSubscription failed with RemoteException parentId=" + paramString);
              }
          }
        }
        else
        {
          break;
          List localList1 = localSubscription.getCallbacks();
          List localList2 = localSubscription.getOptionsList();
          for (int i = -1 + localList1.size(); i >= 0; i--)
            if (localList1.get(i) == paramSubscriptionCallback)
            {
              this.mServiceBinderWrapper.removeSubscription(paramString, paramSubscriptionCallback.mToken, this.mCallbacksMessenger);
              localList1.remove(i);
              localList2.remove(i);
            }
        }
    }
  }

  static class MediaBrowserImplApi23 extends MediaBrowserCompat.MediaBrowserImplApi21
  {
    MediaBrowserImplApi23(Context paramContext, ComponentName paramComponentName, MediaBrowserCompat.ConnectionCallback paramConnectionCallback, Bundle paramBundle)
    {
      super(paramComponentName, paramConnectionCallback, paramBundle);
    }

    public void getItem(String paramString, MediaBrowserCompat.ItemCallback paramItemCallback)
    {
      if (this.mServiceBinderWrapper == null)
      {
        MediaBrowserCompatApi23.getItem(this.mBrowserObj, paramString, paramItemCallback.mItemCallbackObj);
        return;
      }
      super.getItem(paramString, paramItemCallback);
    }
  }

  static class MediaBrowserImplApi26 extends MediaBrowserCompat.MediaBrowserImplApi23
  {
    MediaBrowserImplApi26(Context paramContext, ComponentName paramComponentName, MediaBrowserCompat.ConnectionCallback paramConnectionCallback, Bundle paramBundle)
    {
      super(paramComponentName, paramConnectionCallback, paramBundle);
    }

    public void subscribe(String paramString, Bundle paramBundle, MediaBrowserCompat.SubscriptionCallback paramSubscriptionCallback)
    {
      if ((this.mServiceBinderWrapper == null) || (this.mServiceVersion < 2))
      {
        if (paramBundle == null)
        {
          MediaBrowserCompatApi21.subscribe(this.mBrowserObj, paramString, paramSubscriptionCallback.mSubscriptionCallbackObj);
          return;
        }
        MediaBrowserCompatApi26.subscribe(this.mBrowserObj, paramString, paramBundle, paramSubscriptionCallback.mSubscriptionCallbackObj);
        return;
      }
      super.subscribe(paramString, paramBundle, paramSubscriptionCallback);
    }

    public void unsubscribe(String paramString, MediaBrowserCompat.SubscriptionCallback paramSubscriptionCallback)
    {
      if ((this.mServiceBinderWrapper == null) || (this.mServiceVersion < 2))
      {
        if (paramSubscriptionCallback == null)
        {
          MediaBrowserCompatApi21.unsubscribe(this.mBrowserObj, paramString);
          return;
        }
        MediaBrowserCompatApi26.unsubscribe(this.mBrowserObj, paramString, paramSubscriptionCallback.mSubscriptionCallbackObj);
        return;
      }
      super.unsubscribe(paramString, paramSubscriptionCallback);
    }
  }

  static class MediaBrowserImplBase
    implements MediaBrowserCompat.MediaBrowserImpl, MediaBrowserCompat.MediaBrowserServiceCallbackImpl
  {
    static final int CONNECT_STATE_CONNECTED = 3;
    static final int CONNECT_STATE_CONNECTING = 2;
    static final int CONNECT_STATE_DISCONNECTED = 1;
    static final int CONNECT_STATE_DISCONNECTING = 0;
    static final int CONNECT_STATE_SUSPENDED = 4;
    final MediaBrowserCompat.ConnectionCallback mCallback;
    Messenger mCallbacksMessenger;
    final Context mContext;
    private Bundle mExtras;
    final MediaBrowserCompat.CallbackHandler mHandler = new MediaBrowserCompat.CallbackHandler(this);
    private MediaSessionCompat.Token mMediaSessionToken;
    private Bundle mNotifyChildrenChangedOptions;
    final Bundle mRootHints;
    private String mRootId;
    MediaBrowserCompat.ServiceBinderWrapper mServiceBinderWrapper;
    final ComponentName mServiceComponent;
    MediaServiceConnection mServiceConnection;
    int mState = 1;
    private final ArrayMap<String, MediaBrowserCompat.Subscription> mSubscriptions = new ArrayMap();

    public MediaBrowserImplBase(Context paramContext, ComponentName paramComponentName, MediaBrowserCompat.ConnectionCallback paramConnectionCallback, Bundle paramBundle)
    {
      if (paramContext == null)
        throw new IllegalArgumentException("context must not be null");
      if (paramComponentName == null)
        throw new IllegalArgumentException("service component must not be null");
      if (paramConnectionCallback == null)
        throw new IllegalArgumentException("connection callback must not be null");
      this.mContext = paramContext;
      this.mServiceComponent = paramComponentName;
      this.mCallback = paramConnectionCallback;
      if (paramBundle == null);
      for (Bundle localBundle = null; ; localBundle = new Bundle(paramBundle))
      {
        this.mRootHints = localBundle;
        return;
      }
    }

    private static String getStateLabel(int paramInt)
    {
      switch (paramInt)
      {
      default:
        return "UNKNOWN/" + paramInt;
      case 0:
        return "CONNECT_STATE_DISCONNECTING";
      case 1:
        return "CONNECT_STATE_DISCONNECTED";
      case 2:
        return "CONNECT_STATE_CONNECTING";
      case 3:
        return "CONNECT_STATE_CONNECTED";
      case 4:
      }
      return "CONNECT_STATE_SUSPENDED";
    }

    private boolean isCurrent(Messenger paramMessenger, String paramString)
    {
      int i = 1;
      if ((this.mCallbacksMessenger != paramMessenger) || (this.mState == 0) || (this.mState == i))
      {
        if ((this.mState != 0) && (this.mState != i))
          Log.i("MediaBrowserCompat", paramString + " for " + this.mServiceComponent + " with mCallbacksMessenger=" + this.mCallbacksMessenger + " this=" + this);
        i = 0;
      }
      return i;
    }

    public void connect()
    {
      if ((this.mState != 0) && (this.mState != 1))
        throw new IllegalStateException("connect() called while neigther disconnecting nor disconnected (state=" + getStateLabel(this.mState) + ")");
      this.mState = 2;
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          if (MediaBrowserCompat.MediaBrowserImplBase.this.mState == 0);
          while (true)
          {
            return;
            MediaBrowserCompat.MediaBrowserImplBase.this.mState = 2;
            if ((MediaBrowserCompat.DEBUG) && (MediaBrowserCompat.MediaBrowserImplBase.this.mServiceConnection != null))
              throw new RuntimeException("mServiceConnection should be null. Instead it is " + MediaBrowserCompat.MediaBrowserImplBase.this.mServiceConnection);
            if (MediaBrowserCompat.MediaBrowserImplBase.this.mServiceBinderWrapper != null)
              throw new RuntimeException("mServiceBinderWrapper should be null. Instead it is " + MediaBrowserCompat.MediaBrowserImplBase.this.mServiceBinderWrapper);
            if (MediaBrowserCompat.MediaBrowserImplBase.this.mCallbacksMessenger != null)
              throw new RuntimeException("mCallbacksMessenger should be null. Instead it is " + MediaBrowserCompat.MediaBrowserImplBase.this.mCallbacksMessenger);
            Intent localIntent = new Intent("android.media.browse.MediaBrowserService");
            localIntent.setComponent(MediaBrowserCompat.MediaBrowserImplBase.this.mServiceComponent);
            MediaBrowserCompat.MediaBrowserImplBase.this.mServiceConnection = new MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection(MediaBrowserCompat.MediaBrowserImplBase.this);
            try
            {
              boolean bool2 = MediaBrowserCompat.MediaBrowserImplBase.this.mContext.bindService(localIntent, MediaBrowserCompat.MediaBrowserImplBase.this.mServiceConnection, 1);
              bool1 = bool2;
              if (!bool1)
              {
                MediaBrowserCompat.MediaBrowserImplBase.this.forceCloseConnection();
                MediaBrowserCompat.MediaBrowserImplBase.this.mCallback.onConnectionFailed();
              }
              if (!MediaBrowserCompat.DEBUG)
                continue;
              Log.d("MediaBrowserCompat", "connect...");
              MediaBrowserCompat.MediaBrowserImplBase.this.dump();
              return;
            }
            catch (Exception localException)
            {
              while (true)
              {
                Log.e("MediaBrowserCompat", "Failed binding to service " + MediaBrowserCompat.MediaBrowserImplBase.this.mServiceComponent);
                boolean bool1 = false;
              }
            }
          }
        }
      });
    }

    public void disconnect()
    {
      this.mState = 0;
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          if (MediaBrowserCompat.MediaBrowserImplBase.this.mCallbacksMessenger != null);
          try
          {
            MediaBrowserCompat.MediaBrowserImplBase.this.mServiceBinderWrapper.disconnect(MediaBrowserCompat.MediaBrowserImplBase.this.mCallbacksMessenger);
            int i = MediaBrowserCompat.MediaBrowserImplBase.this.mState;
            MediaBrowserCompat.MediaBrowserImplBase.this.forceCloseConnection();
            if (i != 0)
              MediaBrowserCompat.MediaBrowserImplBase.this.mState = i;
            if (MediaBrowserCompat.DEBUG)
            {
              Log.d("MediaBrowserCompat", "disconnect...");
              MediaBrowserCompat.MediaBrowserImplBase.this.dump();
            }
            return;
          }
          catch (RemoteException localRemoteException)
          {
            while (true)
              Log.w("MediaBrowserCompat", "RemoteException during connect for " + MediaBrowserCompat.MediaBrowserImplBase.this.mServiceComponent);
          }
        }
      });
    }

    void dump()
    {
      Log.d("MediaBrowserCompat", "MediaBrowserCompat...");
      Log.d("MediaBrowserCompat", "  mServiceComponent=" + this.mServiceComponent);
      Log.d("MediaBrowserCompat", "  mCallback=" + this.mCallback);
      Log.d("MediaBrowserCompat", "  mRootHints=" + this.mRootHints);
      Log.d("MediaBrowserCompat", "  mState=" + getStateLabel(this.mState));
      Log.d("MediaBrowserCompat", "  mServiceConnection=" + this.mServiceConnection);
      Log.d("MediaBrowserCompat", "  mServiceBinderWrapper=" + this.mServiceBinderWrapper);
      Log.d("MediaBrowserCompat", "  mCallbacksMessenger=" + this.mCallbacksMessenger);
      Log.d("MediaBrowserCompat", "  mRootId=" + this.mRootId);
      Log.d("MediaBrowserCompat", "  mMediaSessionToken=" + this.mMediaSessionToken);
    }

    void forceCloseConnection()
    {
      if (this.mServiceConnection != null)
        this.mContext.unbindService(this.mServiceConnection);
      this.mState = 1;
      this.mServiceConnection = null;
      this.mServiceBinderWrapper = null;
      this.mCallbacksMessenger = null;
      this.mHandler.setCallbacksMessenger(null);
      this.mRootId = null;
      this.mMediaSessionToken = null;
    }

    public Bundle getExtras()
    {
      if (!isConnected())
        throw new IllegalStateException("getExtras() called while not connected (state=" + getStateLabel(this.mState) + ")");
      return this.mExtras;
    }

    public void getItem(final String paramString, final MediaBrowserCompat.ItemCallback paramItemCallback)
    {
      if (TextUtils.isEmpty(paramString))
        throw new IllegalArgumentException("mediaId is empty");
      if (paramItemCallback == null)
        throw new IllegalArgumentException("cb is null");
      if (!isConnected())
      {
        Log.i("MediaBrowserCompat", "Not connected, unable to retrieve the MediaItem.");
        this.mHandler.post(new Runnable()
        {
          public void run()
          {
            paramItemCallback.onError(paramString);
          }
        });
        return;
      }
      MediaBrowserCompat.ItemReceiver localItemReceiver = new MediaBrowserCompat.ItemReceiver(paramString, paramItemCallback, this.mHandler);
      try
      {
        this.mServiceBinderWrapper.getMediaItem(paramString, localItemReceiver, this.mCallbacksMessenger);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        Log.i("MediaBrowserCompat", "Remote error getting media item: " + paramString);
        this.mHandler.post(new Runnable()
        {
          public void run()
          {
            paramItemCallback.onError(paramString);
          }
        });
      }
    }

    public Bundle getNotifyChildrenChangedOptions()
    {
      return this.mNotifyChildrenChangedOptions;
    }

    public String getRoot()
    {
      if (!isConnected())
        throw new IllegalStateException("getRoot() called while not connected(state=" + getStateLabel(this.mState) + ")");
      return this.mRootId;
    }

    public ComponentName getServiceComponent()
    {
      if (!isConnected())
        throw new IllegalStateException("getServiceComponent() called while not connected (state=" + this.mState + ")");
      return this.mServiceComponent;
    }

    public MediaSessionCompat.Token getSessionToken()
    {
      if (!isConnected())
        throw new IllegalStateException("getSessionToken() called while not connected(state=" + this.mState + ")");
      return this.mMediaSessionToken;
    }

    public boolean isConnected()
    {
      return this.mState == 3;
    }

    public void onConnectionFailed(Messenger paramMessenger)
    {
      Log.e("MediaBrowserCompat", "onConnectFailed for " + this.mServiceComponent);
      if (!isCurrent(paramMessenger, "onConnectFailed"))
        return;
      if (this.mState != 2)
      {
        Log.w("MediaBrowserCompat", "onConnect from service while mState=" + getStateLabel(this.mState) + "... ignoring");
        return;
      }
      forceCloseConnection();
      this.mCallback.onConnectionFailed();
    }

    public void onLoadChildren(Messenger paramMessenger, String paramString, List paramList, Bundle paramBundle1, Bundle paramBundle2)
    {
      if (!isCurrent(paramMessenger, "onLoadChildren"));
      MediaBrowserCompat.SubscriptionCallback localSubscriptionCallback;
      do
      {
        MediaBrowserCompat.Subscription localSubscription;
        do
        {
          return;
          if (MediaBrowserCompat.DEBUG)
            Log.d("MediaBrowserCompat", "onLoadChildren for " + this.mServiceComponent + " id=" + paramString);
          localSubscription = (MediaBrowserCompat.Subscription)this.mSubscriptions.get(paramString);
          if (localSubscription != null)
            break;
        }
        while (!MediaBrowserCompat.DEBUG);
        Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + paramString);
        return;
        localSubscriptionCallback = localSubscription.getCallback(paramBundle1);
      }
      while (localSubscriptionCallback == null);
      if (paramBundle1 == null)
      {
        if (paramList == null)
        {
          localSubscriptionCallback.onError(paramString);
          return;
        }
        this.mNotifyChildrenChangedOptions = paramBundle2;
        localSubscriptionCallback.onChildrenLoaded(paramString, paramList);
        this.mNotifyChildrenChangedOptions = null;
        return;
      }
      if (paramList == null)
      {
        localSubscriptionCallback.onError(paramString, paramBundle1);
        return;
      }
      this.mNotifyChildrenChangedOptions = paramBundle2;
      localSubscriptionCallback.onChildrenLoaded(paramString, paramList, paramBundle1);
      this.mNotifyChildrenChangedOptions = null;
    }

    public void onServiceConnected(Messenger paramMessenger, String paramString, MediaSessionCompat.Token paramToken, Bundle paramBundle)
    {
      if (!isCurrent(paramMessenger, "onConnect"));
      while (true)
      {
        return;
        if (this.mState != 2)
        {
          Log.w("MediaBrowserCompat", "onConnect from service while mState=" + getStateLabel(this.mState) + "... ignoring");
          return;
        }
        this.mRootId = paramString;
        this.mMediaSessionToken = paramToken;
        this.mExtras = paramBundle;
        this.mState = 3;
        if (MediaBrowserCompat.DEBUG)
        {
          Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
          dump();
        }
        this.mCallback.onConnected();
        try
        {
          Iterator localIterator = this.mSubscriptions.entrySet().iterator();
          while (localIterator.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            String str = (String)localEntry.getKey();
            MediaBrowserCompat.Subscription localSubscription = (MediaBrowserCompat.Subscription)localEntry.getValue();
            List localList1 = localSubscription.getCallbacks();
            List localList2 = localSubscription.getOptionsList();
            for (int i = 0; i < localList1.size(); i++)
              this.mServiceBinderWrapper.addSubscription(str, ((MediaBrowserCompat.SubscriptionCallback)localList1.get(i)).mToken, (Bundle)localList2.get(i), this.mCallbacksMessenger);
          }
        }
        catch (RemoteException localRemoteException)
        {
          Log.d("MediaBrowserCompat", "addSubscription failed with RemoteException.");
        }
      }
    }

    public void search(final String paramString, final Bundle paramBundle, final MediaBrowserCompat.SearchCallback paramSearchCallback)
    {
      if (!isConnected())
        throw new IllegalStateException("search() called while not connected (state=" + getStateLabel(this.mState) + ")");
      MediaBrowserCompat.SearchResultReceiver localSearchResultReceiver = new MediaBrowserCompat.SearchResultReceiver(paramString, paramBundle, paramSearchCallback, this.mHandler);
      try
      {
        this.mServiceBinderWrapper.search(paramString, paramBundle, localSearchResultReceiver, this.mCallbacksMessenger);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        Log.i("MediaBrowserCompat", "Remote error searching items with query: " + paramString, localRemoteException);
        this.mHandler.post(new Runnable()
        {
          public void run()
          {
            paramSearchCallback.onError(paramString, paramBundle);
          }
        });
      }
    }

    public void sendCustomAction(final String paramString, final Bundle paramBundle, final MediaBrowserCompat.CustomActionCallback paramCustomActionCallback)
    {
      if (!isConnected())
        throw new IllegalStateException("Cannot send a custom action (" + paramString + ") with " + "extras " + paramBundle + " because the browser is not connected to the " + "service.");
      MediaBrowserCompat.CustomActionResultReceiver localCustomActionResultReceiver = new MediaBrowserCompat.CustomActionResultReceiver(paramString, paramBundle, paramCustomActionCallback, this.mHandler);
      try
      {
        this.mServiceBinderWrapper.sendCustomAction(paramString, paramBundle, localCustomActionResultReceiver, this.mCallbacksMessenger);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        do
          Log.i("MediaBrowserCompat", "Remote error sending a custom action: action=" + paramString + ", extras=" + paramBundle, localRemoteException);
        while (paramCustomActionCallback == null);
        this.mHandler.post(new Runnable()
        {
          public void run()
          {
            paramCustomActionCallback.onError(paramString, paramBundle, null);
          }
        });
      }
    }

    public void subscribe(String paramString, Bundle paramBundle, MediaBrowserCompat.SubscriptionCallback paramSubscriptionCallback)
    {
      MediaBrowserCompat.Subscription localSubscription1 = (MediaBrowserCompat.Subscription)this.mSubscriptions.get(paramString);
      MediaBrowserCompat.Subscription localSubscription2;
      if (localSubscription1 == null)
      {
        localSubscription2 = new MediaBrowserCompat.Subscription();
        this.mSubscriptions.put(paramString, localSubscription2);
      }
      for (MediaBrowserCompat.Subscription localSubscription3 = localSubscription2; ; localSubscription3 = localSubscription1)
      {
        Bundle localBundle;
        if (paramBundle == null)
          localBundle = null;
        while (true)
        {
          localSubscription3.putCallback(localBundle, paramSubscriptionCallback);
          if (isConnected());
          try
          {
            this.mServiceBinderWrapper.addSubscription(paramString, paramSubscriptionCallback.mToken, localBundle, this.mCallbacksMessenger);
            return;
            localBundle = new Bundle(paramBundle);
          }
          catch (RemoteException localRemoteException)
          {
            Log.d("MediaBrowserCompat", "addSubscription failed with RemoteException parentId=" + paramString);
            return;
          }
        }
      }
    }

    public void unsubscribe(String paramString, MediaBrowserCompat.SubscriptionCallback paramSubscriptionCallback)
    {
      MediaBrowserCompat.Subscription localSubscription = (MediaBrowserCompat.Subscription)this.mSubscriptions.get(paramString);
      if (localSubscription == null);
      while (true)
      {
        return;
        if (paramSubscriptionCallback == null);
        try
        {
          if (isConnected())
            this.mServiceBinderWrapper.removeSubscription(paramString, null, this.mCallbacksMessenger);
          while ((localSubscription.isEmpty()) || (paramSubscriptionCallback == null))
          {
            this.mSubscriptions.remove(paramString);
            return;
            List localList1 = localSubscription.getCallbacks();
            List localList2 = localSubscription.getOptionsList();
            for (int i = -1 + localList1.size(); i >= 0; i--)
              if (localList1.get(i) == paramSubscriptionCallback)
              {
                if (isConnected())
                  this.mServiceBinderWrapper.removeSubscription(paramString, paramSubscriptionCallback.mToken, this.mCallbacksMessenger);
                localList1.remove(i);
                localList2.remove(i);
              }
          }
        }
        catch (RemoteException localRemoteException)
        {
          while (true)
            Log.d("MediaBrowserCompat", "removeSubscription failed with RemoteException parentId=" + paramString);
        }
      }
    }

    private class MediaServiceConnection
      implements ServiceConnection
    {
      MediaServiceConnection()
      {
      }

      private void postOrRun(Runnable paramRunnable)
      {
        if (Thread.currentThread() == MediaBrowserCompat.MediaBrowserImplBase.this.mHandler.getLooper().getThread())
        {
          paramRunnable.run();
          return;
        }
        MediaBrowserCompat.MediaBrowserImplBase.this.mHandler.post(paramRunnable);
      }

      boolean isCurrent(String paramString)
      {
        int i = 1;
        if ((MediaBrowserCompat.MediaBrowserImplBase.this.mServiceConnection != this) || (MediaBrowserCompat.MediaBrowserImplBase.this.mState == 0) || (MediaBrowserCompat.MediaBrowserImplBase.this.mState == i))
        {
          if ((MediaBrowserCompat.MediaBrowserImplBase.this.mState != 0) && (MediaBrowserCompat.MediaBrowserImplBase.this.mState != i))
            Log.i("MediaBrowserCompat", paramString + " for " + MediaBrowserCompat.MediaBrowserImplBase.this.mServiceComponent + " with mServiceConnection=" + MediaBrowserCompat.MediaBrowserImplBase.this.mServiceConnection + " this=" + this);
          i = 0;
        }
        return i;
      }

      public void onServiceConnected(final ComponentName paramComponentName, final IBinder paramIBinder)
      {
        postOrRun(new Runnable()
        {
          public void run()
          {
            if (MediaBrowserCompat.DEBUG)
            {
              Log.d("MediaBrowserCompat", "MediaServiceConnection.onServiceConnected name=" + paramComponentName + " binder=" + paramIBinder);
              MediaBrowserCompat.MediaBrowserImplBase.this.dump();
            }
            if (!MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.this.isCurrent("onServiceConnected"));
            do
            {
              return;
              MediaBrowserCompat.MediaBrowserImplBase.this.mServiceBinderWrapper = new MediaBrowserCompat.ServiceBinderWrapper(paramIBinder, MediaBrowserCompat.MediaBrowserImplBase.this.mRootHints);
              MediaBrowserCompat.MediaBrowserImplBase.this.mCallbacksMessenger = new Messenger(MediaBrowserCompat.MediaBrowserImplBase.this.mHandler);
              MediaBrowserCompat.MediaBrowserImplBase.this.mHandler.setCallbacksMessenger(MediaBrowserCompat.MediaBrowserImplBase.this.mCallbacksMessenger);
              MediaBrowserCompat.MediaBrowserImplBase.this.mState = 2;
              try
              {
                if (MediaBrowserCompat.DEBUG)
                {
                  Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                  MediaBrowserCompat.MediaBrowserImplBase.this.dump();
                }
                MediaBrowserCompat.MediaBrowserImplBase.this.mServiceBinderWrapper.connect(MediaBrowserCompat.MediaBrowserImplBase.this.mContext, MediaBrowserCompat.MediaBrowserImplBase.this.mCallbacksMessenger);
                return;
              }
              catch (RemoteException localRemoteException)
              {
                Log.w("MediaBrowserCompat", "RemoteException during connect for " + MediaBrowserCompat.MediaBrowserImplBase.this.mServiceComponent);
              }
            }
            while (!MediaBrowserCompat.DEBUG);
            Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
            MediaBrowserCompat.MediaBrowserImplBase.this.dump();
          }
        });
      }

      public void onServiceDisconnected(final ComponentName paramComponentName)
      {
        postOrRun(new Runnable()
        {
          public void run()
          {
            if (MediaBrowserCompat.DEBUG)
            {
              Log.d("MediaBrowserCompat", "MediaServiceConnection.onServiceDisconnected name=" + paramComponentName + " this=" + this + " mServiceConnection=" + MediaBrowserCompat.MediaBrowserImplBase.this.mServiceConnection);
              MediaBrowserCompat.MediaBrowserImplBase.this.dump();
            }
            if (!MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.this.isCurrent("onServiceDisconnected"))
              return;
            MediaBrowserCompat.MediaBrowserImplBase.this.mServiceBinderWrapper = null;
            MediaBrowserCompat.MediaBrowserImplBase.this.mCallbacksMessenger = null;
            MediaBrowserCompat.MediaBrowserImplBase.this.mHandler.setCallbacksMessenger(null);
            MediaBrowserCompat.MediaBrowserImplBase.this.mState = 4;
            MediaBrowserCompat.MediaBrowserImplBase.this.mCallback.onConnectionSuspended();
          }
        });
      }
    }
  }

  static abstract interface MediaBrowserServiceCallbackImpl
  {
    public abstract void onConnectionFailed(Messenger paramMessenger);

    public abstract void onLoadChildren(Messenger paramMessenger, String paramString, List paramList, Bundle paramBundle1, Bundle paramBundle2);

    public abstract void onServiceConnected(Messenger paramMessenger, String paramString, MediaSessionCompat.Token paramToken, Bundle paramBundle);
  }

  public static class MediaItem
    implements Parcelable
  {
    public static final Parcelable.Creator<MediaItem> CREATOR = new Parcelable.Creator()
    {
      public MediaBrowserCompat.MediaItem createFromParcel(Parcel paramAnonymousParcel)
      {
        return new MediaBrowserCompat.MediaItem(paramAnonymousParcel);
      }

      public MediaBrowserCompat.MediaItem[] newArray(int paramAnonymousInt)
      {
        return new MediaBrowserCompat.MediaItem[paramAnonymousInt];
      }
    };
    public static final int FLAG_BROWSABLE = 1;
    public static final int FLAG_PLAYABLE = 2;
    private final MediaDescriptionCompat mDescription;
    private final int mFlags;

    MediaItem(Parcel paramParcel)
    {
      this.mFlags = paramParcel.readInt();
      this.mDescription = ((MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(paramParcel));
    }

    public MediaItem(MediaDescriptionCompat paramMediaDescriptionCompat, int paramInt)
    {
      if (paramMediaDescriptionCompat == null)
        throw new IllegalArgumentException("description cannot be null");
      if (TextUtils.isEmpty(paramMediaDescriptionCompat.getMediaId()))
        throw new IllegalArgumentException("description must have a non-empty media id");
      this.mFlags = paramInt;
      this.mDescription = paramMediaDescriptionCompat;
    }

    public static MediaItem fromMediaItem(Object paramObject)
    {
      if ((paramObject == null) || (Build.VERSION.SDK_INT < 21))
        return null;
      int i = MediaBrowserCompatApi21.MediaItem.getFlags(paramObject);
      return new MediaItem(MediaDescriptionCompat.fromMediaDescription(MediaBrowserCompatApi21.MediaItem.getDescription(paramObject)), i);
    }

    public static List<MediaItem> fromMediaItemList(List<?> paramList)
    {
      Object localObject;
      if ((paramList == null) || (Build.VERSION.SDK_INT < 21))
        localObject = null;
      while (true)
      {
        return localObject;
        localObject = new ArrayList(paramList.size());
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
          ((List)localObject).add(fromMediaItem(localIterator.next()));
      }
    }

    public int describeContents()
    {
      return 0;
    }

    public MediaDescriptionCompat getDescription()
    {
      return this.mDescription;
    }

    public int getFlags()
    {
      return this.mFlags;
    }

    public String getMediaId()
    {
      return this.mDescription.getMediaId();
    }

    public boolean isBrowsable()
    {
      return (0x1 & this.mFlags) != 0;
    }

    public boolean isPlayable()
    {
      return (0x2 & this.mFlags) != 0;
    }

    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("MediaItem{");
      localStringBuilder.append("mFlags=").append(this.mFlags);
      localStringBuilder.append(", mDescription=").append(this.mDescription);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.mFlags);
      this.mDescription.writeToParcel(paramParcel, paramInt);
    }

    @Retention(RetentionPolicy.SOURCE)
    public static @interface Flags
    {
    }
  }

  public static abstract class SearchCallback
  {
    public void onError(String paramString, Bundle paramBundle)
    {
    }

    public void onSearchResult(String paramString, Bundle paramBundle, List<MediaBrowserCompat.MediaItem> paramList)
    {
    }
  }

  private static class SearchResultReceiver extends ResultReceiver
  {
    private final MediaBrowserCompat.SearchCallback mCallback;
    private final Bundle mExtras;
    private final String mQuery;

    SearchResultReceiver(String paramString, Bundle paramBundle, MediaBrowserCompat.SearchCallback paramSearchCallback, Handler paramHandler)
    {
      super();
      this.mQuery = paramString;
      this.mExtras = paramBundle;
      this.mCallback = paramSearchCallback;
    }

    protected void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      MediaSessionCompat.ensureClassLoader(paramBundle);
      if ((paramInt != 0) || (paramBundle == null) || (!paramBundle.containsKey("search_results")))
      {
        this.mCallback.onError(this.mQuery, this.mExtras);
        return;
      }
      Parcelable[] arrayOfParcelable = paramBundle.getParcelableArray("search_results");
      Object localObject = null;
      if (arrayOfParcelable != null)
      {
        ArrayList localArrayList = new ArrayList();
        int i = arrayOfParcelable.length;
        for (int j = 0; j < i; j++)
          localArrayList.add((MediaBrowserCompat.MediaItem)arrayOfParcelable[j]);
        localObject = localArrayList;
      }
      this.mCallback.onSearchResult(this.mQuery, this.mExtras, localObject);
    }
  }

  private static class ServiceBinderWrapper
  {
    private Messenger mMessenger;
    private Bundle mRootHints;

    public ServiceBinderWrapper(IBinder paramIBinder, Bundle paramBundle)
    {
      this.mMessenger = new Messenger(paramIBinder);
      this.mRootHints = paramBundle;
    }

    private void sendRequest(int paramInt, Bundle paramBundle, Messenger paramMessenger)
      throws RemoteException
    {
      Message localMessage = Message.obtain();
      localMessage.what = paramInt;
      localMessage.arg1 = 1;
      localMessage.setData(paramBundle);
      localMessage.replyTo = paramMessenger;
      this.mMessenger.send(localMessage);
    }

    void addSubscription(String paramString, IBinder paramIBinder, Bundle paramBundle, Messenger paramMessenger)
      throws RemoteException
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("data_media_item_id", paramString);
      BundleCompat.putBinder(localBundle, "data_callback_token", paramIBinder);
      localBundle.putBundle("data_options", paramBundle);
      sendRequest(3, localBundle, paramMessenger);
    }

    void connect(Context paramContext, Messenger paramMessenger)
      throws RemoteException
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("data_package_name", paramContext.getPackageName());
      localBundle.putBundle("data_root_hints", this.mRootHints);
      sendRequest(1, localBundle, paramMessenger);
    }

    void disconnect(Messenger paramMessenger)
      throws RemoteException
    {
      sendRequest(2, null, paramMessenger);
    }

    void getMediaItem(String paramString, ResultReceiver paramResultReceiver, Messenger paramMessenger)
      throws RemoteException
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("data_media_item_id", paramString);
      localBundle.putParcelable("data_result_receiver", paramResultReceiver);
      sendRequest(5, localBundle, paramMessenger);
    }

    void registerCallbackMessenger(Context paramContext, Messenger paramMessenger)
      throws RemoteException
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("data_package_name", paramContext.getPackageName());
      localBundle.putBundle("data_root_hints", this.mRootHints);
      sendRequest(6, localBundle, paramMessenger);
    }

    void removeSubscription(String paramString, IBinder paramIBinder, Messenger paramMessenger)
      throws RemoteException
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("data_media_item_id", paramString);
      BundleCompat.putBinder(localBundle, "data_callback_token", paramIBinder);
      sendRequest(4, localBundle, paramMessenger);
    }

    void search(String paramString, Bundle paramBundle, ResultReceiver paramResultReceiver, Messenger paramMessenger)
      throws RemoteException
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("data_search_query", paramString);
      localBundle.putBundle("data_search_extras", paramBundle);
      localBundle.putParcelable("data_result_receiver", paramResultReceiver);
      sendRequest(8, localBundle, paramMessenger);
    }

    void sendCustomAction(String paramString, Bundle paramBundle, ResultReceiver paramResultReceiver, Messenger paramMessenger)
      throws RemoteException
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("data_custom_action", paramString);
      localBundle.putBundle("data_custom_action_extras", paramBundle);
      localBundle.putParcelable("data_result_receiver", paramResultReceiver);
      sendRequest(9, localBundle, paramMessenger);
    }

    void unregisterCallbackMessenger(Messenger paramMessenger)
      throws RemoteException
    {
      sendRequest(7, null, paramMessenger);
    }
  }

  private static class Subscription
  {
    private final List<MediaBrowserCompat.SubscriptionCallback> mCallbacks = new ArrayList();
    private final List<Bundle> mOptionsList = new ArrayList();

    public MediaBrowserCompat.SubscriptionCallback getCallback(Bundle paramBundle)
    {
      for (int i = 0; i < this.mOptionsList.size(); i++)
        if (MediaBrowserCompatUtils.areSameOptions((Bundle)this.mOptionsList.get(i), paramBundle))
          return (MediaBrowserCompat.SubscriptionCallback)this.mCallbacks.get(i);
      return null;
    }

    public List<MediaBrowserCompat.SubscriptionCallback> getCallbacks()
    {
      return this.mCallbacks;
    }

    public List<Bundle> getOptionsList()
    {
      return this.mOptionsList;
    }

    public boolean isEmpty()
    {
      return this.mCallbacks.isEmpty();
    }

    public void putCallback(Bundle paramBundle, MediaBrowserCompat.SubscriptionCallback paramSubscriptionCallback)
    {
      for (int i = 0; i < this.mOptionsList.size(); i++)
        if (MediaBrowserCompatUtils.areSameOptions((Bundle)this.mOptionsList.get(i), paramBundle))
        {
          this.mCallbacks.set(i, paramSubscriptionCallback);
          return;
        }
      this.mCallbacks.add(paramSubscriptionCallback);
      this.mOptionsList.add(paramBundle);
    }
  }

  public static abstract class SubscriptionCallback
  {
    final Object mSubscriptionCallbackObj;
    WeakReference<MediaBrowserCompat.Subscription> mSubscriptionRef;
    final IBinder mToken = new Binder();

    public SubscriptionCallback()
    {
      if (Build.VERSION.SDK_INT >= 26)
      {
        this.mSubscriptionCallbackObj = MediaBrowserCompatApi26.createSubscriptionCallback(new StubApi26());
        return;
      }
      if (Build.VERSION.SDK_INT >= 21)
      {
        this.mSubscriptionCallbackObj = MediaBrowserCompatApi21.createSubscriptionCallback(new StubApi21());
        return;
      }
      this.mSubscriptionCallbackObj = null;
    }

    public void onChildrenLoaded(String paramString, List<MediaBrowserCompat.MediaItem> paramList)
    {
    }

    public void onChildrenLoaded(String paramString, List<MediaBrowserCompat.MediaItem> paramList, Bundle paramBundle)
    {
    }

    public void onError(String paramString)
    {
    }

    public void onError(String paramString, Bundle paramBundle)
    {
    }

    void setSubscription(MediaBrowserCompat.Subscription paramSubscription)
    {
      this.mSubscriptionRef = new WeakReference(paramSubscription);
    }

    private class StubApi21
      implements MediaBrowserCompatApi21.SubscriptionCallback
    {
      StubApi21()
      {
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

      public void onChildrenLoaded(String paramString, List<?> paramList)
      {
        if (MediaBrowserCompat.SubscriptionCallback.this.mSubscriptionRef == null);
        for (MediaBrowserCompat.Subscription localSubscription = null; localSubscription == null; localSubscription = (MediaBrowserCompat.Subscription)MediaBrowserCompat.SubscriptionCallback.this.mSubscriptionRef.get())
        {
          MediaBrowserCompat.SubscriptionCallback.this.onChildrenLoaded(paramString, MediaBrowserCompat.MediaItem.fromMediaItemList(paramList));
          return;
        }
        List localList1 = MediaBrowserCompat.MediaItem.fromMediaItemList(paramList);
        List localList2 = localSubscription.getCallbacks();
        List localList3 = localSubscription.getOptionsList();
        int i = 0;
        label67: Bundle localBundle;
        if (i < localList2.size())
        {
          localBundle = (Bundle)localList3.get(i);
          if (localBundle != null)
            break label114;
          MediaBrowserCompat.SubscriptionCallback.this.onChildrenLoaded(paramString, localList1);
        }
        while (true)
        {
          i++;
          break label67;
          break;
          label114: MediaBrowserCompat.SubscriptionCallback.this.onChildrenLoaded(paramString, applyOptions(localList1, localBundle), localBundle);
        }
      }

      public void onError(String paramString)
      {
        MediaBrowserCompat.SubscriptionCallback.this.onError(paramString);
      }
    }

    private class StubApi26 extends MediaBrowserCompat.SubscriptionCallback.StubApi21
      implements MediaBrowserCompatApi26.SubscriptionCallback
    {
      StubApi26()
      {
        super();
      }

      public void onChildrenLoaded(String paramString, List<?> paramList, Bundle paramBundle)
      {
        MediaBrowserCompat.SubscriptionCallback.this.onChildrenLoaded(paramString, MediaBrowserCompat.MediaItem.fromMediaItemList(paramList), paramBundle);
      }

      public void onError(String paramString, Bundle paramBundle)
      {
        MediaBrowserCompat.SubscriptionCallback.this.onError(paramString, paramBundle);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserCompat
 * JD-Core Version:    0.6.2
 */