package com.facebook.react.devsupport;

import android.util.JsonReader;
import android.util.Pair;
import com.facebook.react.bridge.NativeDeltaClient;
import f.e;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import javax.annotation.Nullable;
import okhttp3.Headers;

public abstract class BundleDeltaClient
{
  private static final String METRO_DELTA_ID_HEADER = "X-Metro-Delta-ID";

  @Nullable
  private String mRevisionId;

  @Nullable
  static BundleDeltaClient create(ClientType paramClientType)
  {
    switch (1.$SwitchMap$com$facebook$react$devsupport$BundleDeltaClient$ClientType[paramClientType.ordinal()])
    {
    default:
      return null;
    case 1:
      return new BundleDeltaJavaClient(null);
    case 2:
    }
    return new BundleDeltaNativeClient(null);
  }

  static boolean isDeltaUrl(String paramString)
  {
    return paramString.indexOf(".delta?") != -1;
  }

  public abstract boolean canHandle(ClientType paramClientType);

  public final String extendUrlForDelta(String paramString)
  {
    try
    {
      if (this.mRevisionId != null)
      {
        String str = paramString + "&revisionId=" + this.mRevisionId;
        paramString = str;
      }
      return paramString;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  protected abstract Pair<Boolean, NativeDeltaClient> processDelta(e parame, File paramFile)
    throws IOException;

  public Pair<Boolean, NativeDeltaClient> processDelta(Headers paramHeaders, e parame, File paramFile)
    throws IOException
  {
    try
    {
      this.mRevisionId = paramHeaders.get("X-Metro-Delta-ID");
      Pair localPair = processDelta(parame, paramFile);
      return localPair;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void reset()
  {
    try
    {
      this.mRevisionId = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private static class BundleDeltaJavaClient extends BundleDeltaClient
  {
    final LinkedHashMap<Number, byte[]> mModules = new LinkedHashMap();
    byte[] mPostCode;
    byte[] mPreCode;

    private static int removeModules(JsonReader paramJsonReader, LinkedHashMap<Number, byte[]> paramLinkedHashMap)
      throws IOException
    {
      paramJsonReader.beginArray();
      for (int i = 0; paramJsonReader.hasNext(); i++)
        paramLinkedHashMap.remove(Integer.valueOf(paramJsonReader.nextInt()));
      paramJsonReader.endArray();
      return i;
    }

    private static int setModules(JsonReader paramJsonReader, LinkedHashMap<Number, byte[]> paramLinkedHashMap)
      throws IOException
    {
      paramJsonReader.beginArray();
      for (int i = 0; paramJsonReader.hasNext(); i++)
      {
        paramJsonReader.beginArray();
        paramLinkedHashMap.put(Integer.valueOf(paramJsonReader.nextInt()), paramJsonReader.nextString().getBytes());
        paramJsonReader.endArray();
      }
      paramJsonReader.endArray();
      return i;
    }

    public boolean canHandle(BundleDeltaClient.ClientType paramClientType)
    {
      return paramClientType == BundleDeltaClient.ClientType.DEV_SUPPORT;
    }

    public Pair<Boolean, NativeDeltaClient> processDelta(e parame, File paramFile)
      throws IOException
    {
      JsonReader localJsonReader;
      int i;
      while (true)
      {
        String str;
        try
        {
          localJsonReader = new JsonReader(new InputStreamReader(parame.g()));
          localJsonReader.beginObject();
          i = 0;
          if (!localJsonReader.hasNext())
            break;
          str = localJsonReader.nextName();
          if (str.equals("pre"))
          {
            this.mPreCode = localJsonReader.nextString().getBytes();
            continue;
          }
        }
        finally
        {
        }
        if (str.equals("post"))
          this.mPostCode = localJsonReader.nextString().getBytes();
        else if (str.equals("modules"))
          i += setModules(localJsonReader, this.mModules);
        else if (str.equals("added"))
          i += setModules(localJsonReader, this.mModules);
        else if (str.equals("modified"))
          i += setModules(localJsonReader, this.mModules);
        else if (str.equals("deleted"))
          i += removeModules(localJsonReader, this.mModules);
        else
          localJsonReader.skipValue();
      }
      localJsonReader.endObject();
      localJsonReader.close();
      Pair localPair1;
      if (i == 0)
        localPair1 = Pair.create(Boolean.FALSE, null);
      Pair localPair2;
      for (Object localObject2 = localPair1; ; localObject2 = localPair2)
      {
        return localObject2;
        FileOutputStream localFileOutputStream = new FileOutputStream(paramFile);
        try
        {
          localFileOutputStream.write(this.mPreCode);
          localFileOutputStream.write(10);
          Iterator localIterator = this.mModules.values().iterator();
          while (localIterator.hasNext())
          {
            localFileOutputStream.write((byte[])localIterator.next());
            localFileOutputStream.write(10);
          }
        }
        finally
        {
          localFileOutputStream.flush();
          localFileOutputStream.close();
        }
        localFileOutputStream.write(this.mPostCode);
        localFileOutputStream.write(10);
        localFileOutputStream.flush();
        localFileOutputStream.close();
        localPair2 = Pair.create(Boolean.TRUE, null);
      }
    }

    public void reset()
    {
      try
      {
        super.reset();
        this.mPreCode = null;
        this.mPostCode = null;
        this.mModules.clear();
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }

  private static class BundleDeltaNativeClient extends BundleDeltaClient
  {
    private final NativeDeltaClient nativeClient = new NativeDeltaClient();

    public boolean canHandle(BundleDeltaClient.ClientType paramClientType)
    {
      return paramClientType == BundleDeltaClient.ClientType.NATIVE;
    }

    protected Pair<Boolean, NativeDeltaClient> processDelta(e parame, File paramFile)
      throws IOException
    {
      this.nativeClient.processDelta(parame);
      return Pair.create(Boolean.FALSE, this.nativeClient);
    }

    public void reset()
    {
      super.reset();
      this.nativeClient.reset();
    }
  }

  public static enum ClientType
  {
    static
    {
      DEV_SUPPORT = new ClientType("DEV_SUPPORT", 1);
      NATIVE = new ClientType("NATIVE", 2);
      ClientType[] arrayOfClientType = new ClientType[3];
      arrayOfClientType[0] = NONE;
      arrayOfClientType[1] = DEV_SUPPORT;
      arrayOfClientType[2] = NATIVE;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.devsupport.BundleDeltaClient
 * JD-Core Version:    0.6.2
 */