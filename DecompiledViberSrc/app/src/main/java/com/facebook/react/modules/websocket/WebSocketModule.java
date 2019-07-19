package com.facebook.react.modules.websocket;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.facebook.react.modules.network.ForwardingCookieHandler;
import f.f;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

@ReactModule(hasConstants=false, name="WebSocketModule")
public final class WebSocketModule extends ReactContextBaseJavaModule
{
  public static final String NAME = "WebSocketModule";
  private final Map<Integer, ContentHandler> mContentHandlers = new ConcurrentHashMap();
  private ForwardingCookieHandler mCookieHandler;
  private ReactContext mReactContext;
  private final Map<Integer, WebSocket> mWebSocketConnections = new ConcurrentHashMap();

  public WebSocketModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
    this.mReactContext = paramReactApplicationContext;
    this.mCookieHandler = new ForwardingCookieHandler(paramReactApplicationContext);
  }

  private String getCookie(String paramString)
  {
    try
    {
      URI localURI = new URI(getDefaultOrigin(paramString));
      List localList = (List)this.mCookieHandler.get(localURI, new HashMap()).get("Cookie");
      if ((localList != null) && (!localList.isEmpty()))
      {
        String str = (String)localList.get(0);
        return str;
      }
    }
    catch (URISyntaxException localURISyntaxException)
    {
      throw new IllegalArgumentException("Unable to get cookie from " + paramString);
    }
    catch (IOException localIOException)
    {
      label75: break label75;
    }
    return null;
  }

  private static String getDefaultOrigin(String paramString)
  {
    String str1 = "";
    try
    {
      URI localURI = new URI(paramString);
      if (localURI.getScheme().equals("wss"))
        str1 = str1 + "https";
      while (localURI.getPort() != -1)
      {
        Object[] arrayOfObject2 = new Object[3];
        arrayOfObject2[0] = str1;
        arrayOfObject2[1] = localURI.getHost();
        arrayOfObject2[2] = Integer.valueOf(localURI.getPort());
        return String.format("%s://%s:%s", arrayOfObject2);
        if (localURI.getScheme().equals("ws"))
          str1 = str1 + "http";
        else if ((localURI.getScheme().equals("http")) || (localURI.getScheme().equals("https")))
          str1 = str1 + localURI.getScheme();
      }
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = str1;
      arrayOfObject1[1] = localURI.getHost();
      String str2 = String.format("%s://%s", arrayOfObject1);
      return str2;
    }
    catch (URISyntaxException localURISyntaxException)
    {
    }
    throw new IllegalArgumentException("Unable to set " + paramString + " as default origin header");
  }

  private void notifyWebSocketFailed(int paramInt, String paramString)
  {
    WritableMap localWritableMap = Arguments.createMap();
    localWritableMap.putInt("id", paramInt);
    localWritableMap.putString("message", paramString);
    sendEvent("websocketFailed", localWritableMap);
  }

  private void sendEvent(String paramString, WritableMap paramWritableMap)
  {
    ((DeviceEventManagerModule.RCTDeviceEventEmitter)this.mReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(paramString, paramWritableMap);
  }

  @ReactMethod
  public void close(int paramInt1, String paramString, int paramInt2)
  {
    WebSocket localWebSocket = (WebSocket)this.mWebSocketConnections.get(Integer.valueOf(paramInt2));
    if (localWebSocket == null)
      return;
    try
    {
      localWebSocket.close(paramInt1, paramString);
      this.mWebSocketConnections.remove(Integer.valueOf(paramInt2));
      this.mContentHandlers.remove(Integer.valueOf(paramInt2));
      return;
    }
    catch (Exception localException)
    {
      FLog.e("ReactNative", "Could not close WebSocket connection for id " + paramInt2, localException);
    }
  }

  @ReactMethod
  public void connect(String paramString, @Nullable ReadableArray paramReadableArray, @Nullable ReadableMap paramReadableMap, final int paramInt)
  {
    OkHttpClient localOkHttpClient = new OkHttpClient.Builder().connectTimeout(10L, TimeUnit.SECONDS).writeTimeout(10L, TimeUnit.SECONDS).readTimeout(0L, TimeUnit.MINUTES).build();
    Request.Builder localBuilder = new Request.Builder().tag(Integer.valueOf(paramInt)).url(paramString);
    String str1 = getCookie(paramString);
    if (str1 != null)
      localBuilder.addHeader("Cookie", str1);
    ReadableMap localReadableMap;
    ReadableMapKeySetIterator localReadableMapKeySetIterator;
    if ((paramReadableMap != null) && (paramReadableMap.hasKey("headers")) && (paramReadableMap.getType("headers").equals(ReadableType.Map)))
    {
      localReadableMap = paramReadableMap.getMap("headers");
      localReadableMapKeySetIterator = localReadableMap.keySetIterator();
      if (!localReadableMap.hasKey("origin"))
        localBuilder.addHeader("origin", getDefaultOrigin(paramString));
    }
    while (localReadableMapKeySetIterator.hasNextKey())
    {
      String str3 = localReadableMapKeySetIterator.nextKey();
      if (ReadableType.String.equals(localReadableMap.getType(str3)))
      {
        localBuilder.addHeader(str3, localReadableMap.getString(str3));
      }
      else
      {
        FLog.w("ReactNative", "Ignoring: requested " + str3 + ", value not a string");
        continue;
        localBuilder.addHeader("origin", getDefaultOrigin(paramString));
      }
    }
    if ((paramReadableArray != null) && (paramReadableArray.size() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder("");
      for (int i = 0; i < paramReadableArray.size(); i++)
      {
        String str2 = paramReadableArray.getString(i).trim();
        if ((!str2.isEmpty()) && (!str2.contains(",")))
        {
          localStringBuilder.append(str2);
          localStringBuilder.append(",");
        }
      }
      if (localStringBuilder.length() > 0)
      {
        localStringBuilder.replace(-1 + localStringBuilder.length(), localStringBuilder.length(), "");
        localBuilder.addHeader("Sec-WebSocket-Protocol", localStringBuilder.toString());
      }
    }
    localOkHttpClient.newWebSocket(localBuilder.build(), new WebSocketListener()
    {
      public void onClosed(WebSocket paramAnonymousWebSocket, int paramAnonymousInt, String paramAnonymousString)
      {
        WritableMap localWritableMap = Arguments.createMap();
        localWritableMap.putInt("id", paramInt);
        localWritableMap.putInt("code", paramAnonymousInt);
        localWritableMap.putString("reason", paramAnonymousString);
        WebSocketModule.this.sendEvent("websocketClosed", localWritableMap);
      }

      public void onClosing(WebSocket paramAnonymousWebSocket, int paramAnonymousInt, String paramAnonymousString)
      {
        paramAnonymousWebSocket.close(paramAnonymousInt, paramAnonymousString);
      }

      public void onFailure(WebSocket paramAnonymousWebSocket, Throwable paramAnonymousThrowable, Response paramAnonymousResponse)
      {
        WebSocketModule.this.notifyWebSocketFailed(paramInt, paramAnonymousThrowable.getMessage());
      }

      public void onMessage(WebSocket paramAnonymousWebSocket, f paramAnonymousf)
      {
        WritableMap localWritableMap = Arguments.createMap();
        localWritableMap.putInt("id", paramInt);
        localWritableMap.putString("type", "binary");
        WebSocketModule.ContentHandler localContentHandler = (WebSocketModule.ContentHandler)WebSocketModule.this.mContentHandlers.get(Integer.valueOf(paramInt));
        if (localContentHandler != null)
          localContentHandler.onMessage(paramAnonymousf, localWritableMap);
        while (true)
        {
          WebSocketModule.this.sendEvent("websocketMessage", localWritableMap);
          return;
          localWritableMap.putString("data", paramAnonymousf.b());
        }
      }

      public void onMessage(WebSocket paramAnonymousWebSocket, String paramAnonymousString)
      {
        WritableMap localWritableMap = Arguments.createMap();
        localWritableMap.putInt("id", paramInt);
        localWritableMap.putString("type", "text");
        WebSocketModule.ContentHandler localContentHandler = (WebSocketModule.ContentHandler)WebSocketModule.this.mContentHandlers.get(Integer.valueOf(paramInt));
        if (localContentHandler != null)
          localContentHandler.onMessage(paramAnonymousString, localWritableMap);
        while (true)
        {
          WebSocketModule.this.sendEvent("websocketMessage", localWritableMap);
          return;
          localWritableMap.putString("data", paramAnonymousString);
        }
      }

      public void onOpen(WebSocket paramAnonymousWebSocket, Response paramAnonymousResponse)
      {
        WebSocketModule.this.mWebSocketConnections.put(Integer.valueOf(paramInt), paramAnonymousWebSocket);
        WritableMap localWritableMap = Arguments.createMap();
        localWritableMap.putInt("id", paramInt);
        WebSocketModule.this.sendEvent("websocketOpen", localWritableMap);
      }
    });
    localOkHttpClient.dispatcher().executorService().shutdown();
  }

  public String getName()
  {
    return "WebSocketModule";
  }

  @ReactMethod
  public void ping(int paramInt)
  {
    WebSocket localWebSocket = (WebSocket)this.mWebSocketConnections.get(Integer.valueOf(paramInt));
    if (localWebSocket == null)
    {
      WritableMap localWritableMap1 = Arguments.createMap();
      localWritableMap1.putInt("id", paramInt);
      localWritableMap1.putString("message", "client is null");
      sendEvent("websocketFailed", localWritableMap1);
      WritableMap localWritableMap2 = Arguments.createMap();
      localWritableMap2.putInt("id", paramInt);
      localWritableMap2.putInt("code", 0);
      localWritableMap2.putString("reason", "client is null");
      sendEvent("websocketClosed", localWritableMap2);
      this.mWebSocketConnections.remove(Integer.valueOf(paramInt));
      this.mContentHandlers.remove(Integer.valueOf(paramInt));
      return;
    }
    try
    {
      localWebSocket.send(f.b);
      return;
    }
    catch (Exception localException)
    {
      notifyWebSocketFailed(paramInt, localException.getMessage());
    }
  }

  @ReactMethod
  public void send(String paramString, int paramInt)
  {
    WebSocket localWebSocket = (WebSocket)this.mWebSocketConnections.get(Integer.valueOf(paramInt));
    if (localWebSocket == null)
    {
      WritableMap localWritableMap1 = Arguments.createMap();
      localWritableMap1.putInt("id", paramInt);
      localWritableMap1.putString("message", "client is null");
      sendEvent("websocketFailed", localWritableMap1);
      WritableMap localWritableMap2 = Arguments.createMap();
      localWritableMap2.putInt("id", paramInt);
      localWritableMap2.putInt("code", 0);
      localWritableMap2.putString("reason", "client is null");
      sendEvent("websocketClosed", localWritableMap2);
      this.mWebSocketConnections.remove(Integer.valueOf(paramInt));
      this.mContentHandlers.remove(Integer.valueOf(paramInt));
      return;
    }
    try
    {
      localWebSocket.send(paramString);
      return;
    }
    catch (Exception localException)
    {
      notifyWebSocketFailed(paramInt, localException.getMessage());
    }
  }

  public void sendBinary(f paramf, int paramInt)
  {
    WebSocket localWebSocket = (WebSocket)this.mWebSocketConnections.get(Integer.valueOf(paramInt));
    if (localWebSocket == null)
    {
      WritableMap localWritableMap1 = Arguments.createMap();
      localWritableMap1.putInt("id", paramInt);
      localWritableMap1.putString("message", "client is null");
      sendEvent("websocketFailed", localWritableMap1);
      WritableMap localWritableMap2 = Arguments.createMap();
      localWritableMap2.putInt("id", paramInt);
      localWritableMap2.putInt("code", 0);
      localWritableMap2.putString("reason", "client is null");
      sendEvent("websocketClosed", localWritableMap2);
      this.mWebSocketConnections.remove(Integer.valueOf(paramInt));
      this.mContentHandlers.remove(Integer.valueOf(paramInt));
      return;
    }
    try
    {
      localWebSocket.send(paramf);
      return;
    }
    catch (Exception localException)
    {
      notifyWebSocketFailed(paramInt, localException.getMessage());
    }
  }

  @ReactMethod
  public void sendBinary(String paramString, int paramInt)
  {
    WebSocket localWebSocket = (WebSocket)this.mWebSocketConnections.get(Integer.valueOf(paramInt));
    if (localWebSocket == null)
    {
      WritableMap localWritableMap1 = Arguments.createMap();
      localWritableMap1.putInt("id", paramInt);
      localWritableMap1.putString("message", "client is null");
      sendEvent("websocketFailed", localWritableMap1);
      WritableMap localWritableMap2 = Arguments.createMap();
      localWritableMap2.putInt("id", paramInt);
      localWritableMap2.putInt("code", 0);
      localWritableMap2.putString("reason", "client is null");
      sendEvent("websocketClosed", localWritableMap2);
      this.mWebSocketConnections.remove(Integer.valueOf(paramInt));
      this.mContentHandlers.remove(Integer.valueOf(paramInt));
      return;
    }
    try
    {
      localWebSocket.send(f.b(paramString));
      return;
    }
    catch (Exception localException)
    {
      notifyWebSocketFailed(paramInt, localException.getMessage());
    }
  }

  public void setContentHandler(int paramInt, ContentHandler paramContentHandler)
  {
    if (paramContentHandler != null)
    {
      this.mContentHandlers.put(Integer.valueOf(paramInt), paramContentHandler);
      return;
    }
    this.mContentHandlers.remove(Integer.valueOf(paramInt));
  }

  public static abstract interface ContentHandler
  {
    public abstract void onMessage(f paramf, WritableMap paramWritableMap);

    public abstract void onMessage(String paramString, WritableMap paramWritableMap);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.websocket.WebSocketModule
 * JD-Core Version:    0.6.2
 */