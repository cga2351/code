package com.facebook.react.devsupport;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Inspector;
import com.facebook.react.bridge.Inspector.LocalConnection;
import com.facebook.react.bridge.Inspector.Page;
import com.facebook.react.bridge.Inspector.RemoteConnection;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class InspectorPackagerConnection
{
  private static final String TAG = "InspectorPackagerConnection";
  private BundleStatusProvider mBundleStatusProvider;
  private final Connection mConnection;
  private final Map<String, Inspector.LocalConnection> mInspectorConnections;
  private final String mPackageName;

  public InspectorPackagerConnection(String paramString1, String paramString2, BundleStatusProvider paramBundleStatusProvider)
  {
    this.mConnection = new Connection(paramString1);
    this.mInspectorConnections = new HashMap();
    this.mPackageName = paramString2;
    this.mBundleStatusProvider = paramBundleStatusProvider;
  }

  private JSONArray getPages()
    throws JSONException
  {
    List localList = Inspector.getPages();
    JSONArray localJSONArray = new JSONArray();
    BundleStatus localBundleStatus = this.mBundleStatusProvider.getBundleStatus();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      Inspector.Page localPage = (Inspector.Page)localIterator.next();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("id", String.valueOf(localPage.getId()));
      localJSONObject.put("title", localPage.getTitle());
      localJSONObject.put("app", this.mPackageName);
      localJSONObject.put("vm", localPage.getVM());
      localJSONObject.put("isLastBundleDownloadSuccess", localBundleStatus.isLastDownloadSucess);
      localJSONObject.put("bundleUpdateTimestamp", localBundleStatus.updateTimestamp);
      localJSONArray.put(localJSONObject);
    }
    return localJSONArray;
  }

  private void handleConnect(JSONObject paramJSONObject)
    throws JSONException
  {
    final String str = paramJSONObject.getString("pageId");
    if ((Inspector.LocalConnection)this.mInspectorConnections.remove(str) != null)
      throw new IllegalStateException("Already connected: " + str);
    try
    {
      Inspector.LocalConnection localLocalConnection = Inspector.connect(Integer.parseInt(str), new Inspector.RemoteConnection()
      {
        public void onDisconnect()
        {
          try
          {
            InspectorPackagerConnection.this.mInspectorConnections.remove(str);
            InspectorPackagerConnection.this.sendEvent("disconnect", InspectorPackagerConnection.access$200(InspectorPackagerConnection.this, str));
            return;
          }
          catch (JSONException localJSONException)
          {
            FLog.w("InspectorPackagerConnection", "Couldn't send event to packager", localJSONException);
          }
        }

        public void onMessage(String paramAnonymousString)
        {
          try
          {
            InspectorPackagerConnection.this.sendWrappedEvent(str, paramAnonymousString);
            return;
          }
          catch (JSONException localJSONException)
          {
            FLog.w("InspectorPackagerConnection", "Couldn't send event to packager", localJSONException);
          }
        }
      });
      this.mInspectorConnections.put(str, localLocalConnection);
      return;
    }
    catch (Exception localException)
    {
      FLog.w("InspectorPackagerConnection", "Failed to open page: " + str, localException);
      sendEvent("disconnect", makePageIdPayload(str));
    }
  }

  private void handleDisconnect(JSONObject paramJSONObject)
    throws JSONException
  {
    String str = paramJSONObject.getString("pageId");
    Inspector.LocalConnection localLocalConnection = (Inspector.LocalConnection)this.mInspectorConnections.remove(str);
    if (localLocalConnection == null)
      return;
    localLocalConnection.disconnect();
  }

  private void handleWrappedEvent(JSONObject paramJSONObject)
    throws JSONException
  {
    String str1 = paramJSONObject.getString("pageId");
    String str2 = paramJSONObject.getString("wrappedEvent");
    Inspector.LocalConnection localLocalConnection = (Inspector.LocalConnection)this.mInspectorConnections.get(str1);
    if (localLocalConnection == null)
      throw new IllegalStateException("Not connected: " + str1);
    localLocalConnection.sendMessage(str2);
  }

  private JSONObject makePageIdPayload(String paramString)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("pageId", paramString);
    return localJSONObject;
  }

  private void sendEvent(String paramString, Object paramObject)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("event", paramString);
    localJSONObject.put("payload", paramObject);
    this.mConnection.send(localJSONObject);
  }

  private void sendWrappedEvent(String paramString1, String paramString2)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("pageId", paramString1);
    localJSONObject.put("wrappedEvent", paramString2);
    sendEvent("wrappedEvent", localJSONObject);
  }

  void closeAllConnections()
  {
    Iterator localIterator = this.mInspectorConnections.entrySet().iterator();
    while (localIterator.hasNext())
      ((Inspector.LocalConnection)((Map.Entry)localIterator.next()).getValue()).disconnect();
    this.mInspectorConnections.clear();
  }

  public void closeQuietly()
  {
    this.mConnection.close();
  }

  public void connect()
  {
    this.mConnection.connect();
  }

  void handleProxyMessage(JSONObject paramJSONObject)
    throws JSONException, IOException
  {
    String str = paramJSONObject.getString("event");
    int i = -1;
    switch (str.hashCode())
    {
    default:
    case 1962251790:
    case 1328613653:
    case 951351530:
    case 530405532:
    }
    while (true)
      switch (i)
      {
      default:
        throw new IllegalArgumentException("Unknown event: " + str);
        if (str.equals("getPages"))
        {
          i = 0;
          continue;
          if (str.equals("wrappedEvent"))
          {
            i = 1;
            continue;
            if (str.equals("connect"))
            {
              i = 2;
              continue;
              if (str.equals("disconnect"))
                i = 3;
            }
          }
        }
        break;
      case 0:
      case 1:
      case 2:
      case 3:
      }
    sendEvent("getPages", getPages());
    return;
    handleWrappedEvent(paramJSONObject.getJSONObject("payload"));
    return;
    handleConnect(paramJSONObject.getJSONObject("payload"));
    return;
    handleDisconnect(paramJSONObject.getJSONObject("payload"));
  }

  public void sendEventToAllConnections(String paramString)
  {
    Iterator localIterator = this.mInspectorConnections.entrySet().iterator();
    while (localIterator.hasNext())
      ((Inspector.LocalConnection)((Map.Entry)localIterator.next()).getValue()).sendMessage(paramString);
  }

  public static class BundleStatus
  {
    public Boolean isLastDownloadSucess;
    public long updateTimestamp = -1L;

    public BundleStatus()
    {
      this(Boolean.valueOf(false), -1L);
    }

    public BundleStatus(Boolean paramBoolean, long paramLong)
    {
      this.isLastDownloadSucess = paramBoolean;
      this.updateTimestamp = paramLong;
    }
  }

  public static abstract interface BundleStatusProvider
  {
    public abstract InspectorPackagerConnection.BundleStatus getBundleStatus();
  }

  private class Connection extends WebSocketListener
  {
    private static final int RECONNECT_DELAY_MS = 2000;
    private boolean mClosed;
    private final Handler mHandler;
    private OkHttpClient mHttpClient;
    private boolean mSuppressConnectionErrors;
    private final String mUrl;

    @Nullable
    private WebSocket mWebSocket;

    public Connection(String arg2)
    {
      Object localObject;
      this.mUrl = localObject;
      this.mHandler = new Handler(Looper.getMainLooper());
    }

    private void abort(String paramString, Throwable paramThrowable)
    {
      FLog.e("InspectorPackagerConnection", "Error occurred, shutting down websocket connection: " + paramString, paramThrowable);
      InspectorPackagerConnection.this.closeAllConnections();
      closeWebSocketQuietly();
    }

    private void closeWebSocketQuietly()
    {
      if (this.mWebSocket != null);
      try
      {
        this.mWebSocket.close(1000, "End of session");
        label22: this.mWebSocket = null;
        return;
      }
      catch (Exception localException)
      {
        break label22;
      }
    }

    private void reconnect()
    {
      if (this.mClosed)
        throw new IllegalStateException("Can't reconnect closed client");
      if (!this.mSuppressConnectionErrors)
      {
        FLog.w("InspectorPackagerConnection", "Couldn't connect to packager, will silently retry");
        this.mSuppressConnectionErrors = true;
      }
      this.mHandler.postDelayed(new Runnable()
      {
        public void run()
        {
          if (!InspectorPackagerConnection.Connection.this.mClosed)
            InspectorPackagerConnection.Connection.this.connect();
        }
      }
      , 2000L);
    }

    public void close()
    {
      this.mClosed = true;
      if (this.mWebSocket != null);
      try
      {
        this.mWebSocket.close(1000, "End of session");
        label27: this.mWebSocket = null;
        return;
      }
      catch (Exception localException)
      {
        break label27;
      }
    }

    public void connect()
    {
      if (this.mClosed)
        throw new IllegalStateException("Can't connect closed client");
      if (this.mHttpClient == null)
        this.mHttpClient = new OkHttpClient.Builder().connectTimeout(10L, TimeUnit.SECONDS).writeTimeout(10L, TimeUnit.SECONDS).readTimeout(0L, TimeUnit.MINUTES).build();
      Request localRequest = new Request.Builder().url(this.mUrl).build();
      this.mHttpClient.newWebSocket(localRequest, this);
    }

    public void onClosed(WebSocket paramWebSocket, int paramInt, String paramString)
    {
      this.mWebSocket = null;
      InspectorPackagerConnection.this.closeAllConnections();
      if (!this.mClosed)
        reconnect();
    }

    public void onFailure(WebSocket paramWebSocket, Throwable paramThrowable, Response paramResponse)
    {
      if (this.mWebSocket != null)
        abort("Websocket exception", paramThrowable);
      if (!this.mClosed)
        reconnect();
    }

    public void onMessage(WebSocket paramWebSocket, String paramString)
    {
      try
      {
        InspectorPackagerConnection.this.handleProxyMessage(new JSONObject(paramString));
        return;
      }
      catch (Exception localException)
      {
        throw new RuntimeException(localException);
      }
    }

    public void onOpen(WebSocket paramWebSocket, Response paramResponse)
    {
      this.mWebSocket = paramWebSocket;
    }

    public void send(final JSONObject paramJSONObject)
    {
      AsyncTask local2 = new AsyncTask()
      {
        protected Void doInBackground(WebSocket[] paramAnonymousArrayOfWebSocket)
        {
          if ((paramAnonymousArrayOfWebSocket == null) || (paramAnonymousArrayOfWebSocket.length == 0))
            return null;
          try
          {
            paramAnonymousArrayOfWebSocket[0].send(paramJSONObject.toString());
            return null;
          }
          catch (Exception localException)
          {
            FLog.w("InspectorPackagerConnection", "Couldn't send event to packager", localException);
          }
          return null;
        }
      };
      WebSocket[] arrayOfWebSocket = new WebSocket[1];
      arrayOfWebSocket[0] = this.mWebSocket;
      local2.execute(arrayOfWebSocket);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.devsupport.InspectorPackagerConnection
 * JD-Core Version:    0.6.2
 */