package com.facebook.react.devsupport;

import android.util.JsonReader;
import android.util.JsonToken;
import android.util.JsonWriter;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.common.JavascriptException;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

public class JSDebuggerWebSocketClient extends WebSocketListener
{
  private static final String TAG = "JSDebuggerWebSocketClient";
  private final ConcurrentHashMap<Integer, JSDebuggerCallback> mCallbacks = new ConcurrentHashMap();

  @Nullable
  private JSDebuggerCallback mConnectCallback;

  @Nullable
  private OkHttpClient mHttpClient;
  private final AtomicInteger mRequestID = new AtomicInteger();

  @Nullable
  private WebSocket mWebSocket;

  private void abort(String paramString, Throwable paramThrowable)
  {
    FLog.e("JSDebuggerWebSocketClient", "Error occurred, shutting down websocket connection: " + paramString, paramThrowable);
    closeQuietly();
    if (this.mConnectCallback != null)
    {
      this.mConnectCallback.onFailure(paramThrowable);
      this.mConnectCallback = null;
    }
    Iterator localIterator = this.mCallbacks.values().iterator();
    while (localIterator.hasNext())
      ((JSDebuggerCallback)localIterator.next()).onFailure(paramThrowable);
    this.mCallbacks.clear();
  }

  private void sendMessage(int paramInt, String paramString)
  {
    if (this.mWebSocket == null)
    {
      triggerRequestFailure(paramInt, new IllegalStateException("WebSocket connection no longer valid"));
      return;
    }
    try
    {
      this.mWebSocket.send(paramString);
      return;
    }
    catch (Exception localException)
    {
      triggerRequestFailure(paramInt, localException);
    }
  }

  private void triggerRequestFailure(int paramInt, Throwable paramThrowable)
  {
    JSDebuggerCallback localJSDebuggerCallback = (JSDebuggerCallback)this.mCallbacks.get(Integer.valueOf(paramInt));
    if (localJSDebuggerCallback != null)
    {
      this.mCallbacks.remove(Integer.valueOf(paramInt));
      localJSDebuggerCallback.onFailure(paramThrowable);
    }
  }

  private void triggerRequestSuccess(int paramInt, @Nullable String paramString)
  {
    JSDebuggerCallback localJSDebuggerCallback = (JSDebuggerCallback)this.mCallbacks.get(Integer.valueOf(paramInt));
    if (localJSDebuggerCallback != null)
    {
      this.mCallbacks.remove(Integer.valueOf(paramInt));
      localJSDebuggerCallback.onSuccess(paramString);
    }
  }

  public void closeQuietly()
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

  public void connect(String paramString, JSDebuggerCallback paramJSDebuggerCallback)
  {
    if (this.mHttpClient != null)
      throw new IllegalStateException("JSDebuggerWebSocketClient is already initialized.");
    this.mConnectCallback = paramJSDebuggerCallback;
    this.mHttpClient = new OkHttpClient.Builder().connectTimeout(10L, TimeUnit.SECONDS).writeTimeout(10L, TimeUnit.SECONDS).readTimeout(0L, TimeUnit.MINUTES).build();
    Request localRequest = new Request.Builder().url(paramString).build();
    this.mHttpClient.newWebSocket(localRequest, this);
  }

  public void executeJSCall(String paramString1, String paramString2, JSDebuggerCallback paramJSDebuggerCallback)
  {
    int i = this.mRequestID.getAndIncrement();
    this.mCallbacks.put(Integer.valueOf(i), paramJSDebuggerCallback);
    try
    {
      StringWriter localStringWriter = new StringWriter();
      JsonWriter localJsonWriter = new JsonWriter(localStringWriter);
      localJsonWriter.beginObject().name("id").value(i).name("method").value(paramString1);
      localStringWriter.append(",\"arguments\":").append(paramString2);
      localJsonWriter.endObject().close();
      sendMessage(i, localStringWriter.toString());
      return;
    }
    catch (IOException localIOException)
    {
      triggerRequestFailure(i, localIOException);
    }
  }

  public void loadApplicationScript(String paramString, HashMap<String, String> paramHashMap, JSDebuggerCallback paramJSDebuggerCallback)
  {
    int i = this.mRequestID.getAndIncrement();
    this.mCallbacks.put(Integer.valueOf(i), paramJSDebuggerCallback);
    StringWriter localStringWriter;
    JsonWriter localJsonWriter;
    try
    {
      localStringWriter = new StringWriter();
      localJsonWriter = new JsonWriter(localStringWriter).beginObject().name("id").value(i).name("method").value("executeApplicationScript").name("url").value(paramString).name("inject").beginObject();
      Iterator localIterator = paramHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localJsonWriter.name(str).value((String)paramHashMap.get(str));
      }
    }
    catch (IOException localIOException)
    {
      triggerRequestFailure(i, localIOException);
      return;
    }
    localJsonWriter.endObject().endObject().close();
    sendMessage(i, localStringWriter.toString());
  }

  public void onClosed(WebSocket paramWebSocket, int paramInt, String paramString)
  {
    this.mWebSocket = null;
  }

  public void onFailure(WebSocket paramWebSocket, Throwable paramThrowable, Response paramResponse)
  {
    abort("Websocket exception", paramThrowable);
  }

  public void onMessage(WebSocket paramWebSocket, String paramString)
  {
    Integer localInteger = null;
    try
    {
      localJsonReader = new JsonReader(new StringReader(paramString));
      localJsonReader.beginObject();
      str1 = null;
      while (true)
      {
        if (!localJsonReader.hasNext())
          break label158;
        str2 = localJsonReader.nextName();
        if (JsonToken.NULL != localJsonReader.peek())
          break;
        localJsonReader.skipValue();
      }
    }
    catch (IOException localIOException)
    {
      JsonReader localJsonReader;
      String str1;
      String str2;
      if (localInteger != null)
      {
        triggerRequestFailure(localInteger.intValue(), localIOException);
        label158: 
        do
        {
          return;
          if ("replyID".equals(str2))
          {
            localInteger = Integer.valueOf(localJsonReader.nextInt());
            break;
          }
          if ("result".equals(str2))
          {
            str1 = localJsonReader.nextString();
            break;
          }
          if (!"error".equals(str2))
            break;
          String str3 = localJsonReader.nextString();
          abort(str3, new JavascriptException(str3));
          break;
        }
        while (localInteger == null);
        triggerRequestSuccess(localInteger.intValue(), str1);
        return;
      }
      abort("Parsing response message from websocket failed", localIOException);
    }
  }

  public void onOpen(WebSocket paramWebSocket, Response paramResponse)
  {
    this.mWebSocket = paramWebSocket;
    ((JSDebuggerCallback)Assertions.assertNotNull(this.mConnectCallback)).onSuccess(null);
    this.mConnectCallback = null;
  }

  public void prepareJSRuntime(JSDebuggerCallback paramJSDebuggerCallback)
  {
    int i = this.mRequestID.getAndIncrement();
    this.mCallbacks.put(Integer.valueOf(i), paramJSDebuggerCallback);
    try
    {
      StringWriter localStringWriter = new StringWriter();
      new JsonWriter(localStringWriter).beginObject().name("id").value(i).name("method").value("prepareJSRuntime").endObject().close();
      sendMessage(i, localStringWriter.toString());
      return;
    }
    catch (IOException localIOException)
    {
      triggerRequestFailure(i, localIOException);
    }
  }

  public static abstract interface JSDebuggerCallback
  {
    public abstract void onFailure(Throwable paramThrowable);

    public abstract void onSuccess(@Nullable String paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.devsupport.JSDebuggerWebSocketClient
 * JD-Core Version:    0.6.2
 */