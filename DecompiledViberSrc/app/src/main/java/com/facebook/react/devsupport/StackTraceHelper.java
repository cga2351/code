package com.facebook.react.devsupport;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.devsupport.interfaces.StackFrame;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class StackTraceHelper
{
  public static final String COLUMN_KEY = "column";
  public static final String LINE_NUMBER_KEY = "lineNumber";
  private static final Pattern STACK_FRAME_PATTERN1 = Pattern.compile("^(?:(.*?)@)?(.*?)\\:([0-9]+)\\:([0-9]+)$");
  private static final Pattern STACK_FRAME_PATTERN2 = Pattern.compile("\\s*(?:at)\\s*(.+?)\\s*[@(](.*):([0-9]+):([0-9]+)[)]$");

  public static StackFrame[] convertJavaStackTrace(Throwable paramThrowable)
  {
    StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
    StackFrame[] arrayOfStackFrame = new StackFrame[arrayOfStackTraceElement.length];
    for (int i = 0; i < arrayOfStackTraceElement.length; i++)
      arrayOfStackFrame[i] = new StackFrameImpl(arrayOfStackTraceElement[i].getClassName(), arrayOfStackTraceElement[i].getFileName(), arrayOfStackTraceElement[i].getMethodName(), arrayOfStackTraceElement[i].getLineNumber(), -1, null);
    return arrayOfStackFrame;
  }

  public static StackFrame[] convertJsStackTrace(@Nullable ReadableArray paramReadableArray)
  {
    int i;
    StackFrame[] arrayOfStackFrame;
    int j;
    label18: ReadableType localReadableType;
    ReadableMap localReadableMap;
    String str1;
    String str2;
    if (paramReadableArray != null)
    {
      i = paramReadableArray.size();
      arrayOfStackFrame = new StackFrame[i];
      j = 0;
      if (j >= i)
        break label203;
      localReadableType = paramReadableArray.getType(j);
      if (localReadableType != ReadableType.Map)
        break label171;
      localReadableMap = paramReadableArray.getMap(j);
      str1 = localReadableMap.getString("methodName");
      str2 = localReadableMap.getString("file");
      if ((!localReadableMap.hasKey("lineNumber")) || (localReadableMap.isNull("lineNumber")))
        break label211;
    }
    label171: label203: label211: for (int k = localReadableMap.getInt("lineNumber"); ; k = -1)
    {
      if ((localReadableMap.hasKey("column")) && (!localReadableMap.isNull("column")));
      for (int m = localReadableMap.getInt("column"); ; m = -1)
      {
        arrayOfStackFrame[j] = new StackFrameImpl(str2, str1, k, m, null);
        while (true)
        {
          j++;
          break label18;
          i = 0;
          break;
          if (localReadableType == ReadableType.String)
            arrayOfStackFrame[j] = new StackFrameImpl(null, paramReadableArray.getString(j), -1, -1, null);
        }
        return arrayOfStackFrame;
      }
    }
  }

  public static StackFrame[] convertJsStackTrace(String paramString)
  {
    String[] arrayOfString = paramString.split("\n");
    StackFrame[] arrayOfStackFrame = new StackFrame[arrayOfString.length];
    int i = 0;
    if (i < arrayOfString.length)
    {
      Matcher localMatcher1 = STACK_FRAME_PATTERN1.matcher(arrayOfString[i]);
      Matcher localMatcher2 = STACK_FRAME_PATTERN2.matcher(arrayOfString[i]);
      label51: String str1;
      if (localMatcher2.find())
      {
        str1 = localMatcher2.group(2);
        if (localMatcher2.group(1) != null)
          break label146;
      }
      label146: for (String str2 = "(unknown)"; ; str2 = localMatcher2.group(1))
      {
        arrayOfStackFrame[i] = new StackFrameImpl(str1, str2, Integer.parseInt(localMatcher2.group(3)), Integer.parseInt(localMatcher2.group(4)), null);
        while (true)
        {
          i++;
          break;
          if (localMatcher1.find())
          {
            localMatcher2 = localMatcher1;
            break label51;
          }
          arrayOfStackFrame[i] = new StackFrameImpl(null, arrayOfString[i], -1, -1, null);
        }
      }
    }
    return arrayOfStackFrame;
  }

  public static StackFrame[] convertJsStackTrace(JSONArray paramJSONArray)
  {
    int i;
    StackFrame[] arrayOfStackFrame;
    int j;
    if (paramJSONArray != null)
    {
      i = paramJSONArray.length();
      arrayOfStackFrame = new StackFrame[i];
      j = 0;
      label16: if (j >= i)
        break label146;
    }
    while (true)
    {
      try
      {
        JSONObject localJSONObject = paramJSONArray.getJSONObject(j);
        String str1 = localJSONObject.getString("methodName");
        String str2 = localJSONObject.getString("file");
        if ((!localJSONObject.has("lineNumber")) || (localJSONObject.isNull("lineNumber")))
          break label154;
        k = localJSONObject.getInt("lineNumber");
        if ((!localJSONObject.has("column")) || (localJSONObject.isNull("column")))
          break label148;
        m = localJSONObject.getInt("column");
        arrayOfStackFrame[j] = new StackFrameImpl(str2, str1, k, m, null);
        j++;
        break label16;
        i = 0;
      }
      catch (JSONException localJSONException)
      {
        throw new RuntimeException(localJSONException);
      }
      label146: return arrayOfStackFrame;
      label148: int m = -1;
      continue;
      label154: int k = -1;
    }
  }

  public static String formatFrameSource(StackFrame paramStackFrame)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramStackFrame.getFileName());
    int i = paramStackFrame.getLine();
    if (i > 0)
    {
      localStringBuilder.append(":").append(i);
      int j = paramStackFrame.getColumn();
      if (j > 0)
        localStringBuilder.append(":").append(j);
    }
    return localStringBuilder.toString();
  }

  public static String formatStackTrace(String paramString, StackFrame[] paramArrayOfStackFrame)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString).append("\n");
    int i = paramArrayOfStackFrame.length;
    for (int j = 0; j < i; j++)
    {
      StackFrame localStackFrame = paramArrayOfStackFrame[j];
      localStringBuilder.append(localStackFrame.getMethod()).append("\n").append("    ").append(formatFrameSource(localStackFrame)).append("\n");
    }
    return localStringBuilder.toString();
  }

  public static class StackFrameImpl
    implements StackFrame
  {
    private final int mColumn;
    private final String mFile;
    private final String mFileName;
    private final int mLine;
    private final String mMethod;

    private StackFrameImpl(String paramString1, String paramString2, int paramInt1, int paramInt2)
    {
      this.mFile = paramString1;
      this.mMethod = paramString2;
      this.mLine = paramInt1;
      this.mColumn = paramInt2;
      if (paramString1 != null);
      for (String str = new File(paramString1).getName(); ; str = "")
      {
        this.mFileName = str;
        return;
      }
    }

    private StackFrameImpl(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
    {
      this.mFile = paramString1;
      this.mFileName = paramString2;
      this.mMethod = paramString3;
      this.mLine = paramInt1;
      this.mColumn = paramInt2;
    }

    public int getColumn()
    {
      return this.mColumn;
    }

    public String getFile()
    {
      return this.mFile;
    }

    public String getFileName()
    {
      return this.mFileName;
    }

    public int getLine()
    {
      return this.mLine;
    }

    public String getMethod()
    {
      return this.mMethod;
    }

    public JSONObject toJSON()
    {
      return new JSONObject(MapBuilder.of("file", getFile(), "methodName", getMethod(), "lineNumber", Integer.valueOf(getLine()), "column", Integer.valueOf(getColumn())));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.devsupport.StackTraceHelper
 * JD-Core Version:    0.6.2
 */