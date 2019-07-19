package com.facebook.react.util;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JSStackTrace
{
  private static final Pattern FILE_ID_PATTERN = Pattern.compile("\\b((?:seg-\\d+(?:_\\d+)?|\\d+)\\.js)");

  public static String format(String paramString, ReadableArray paramReadableArray)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString).append(", stack:\n");
    for (int i = 0; i < paramReadableArray.size(); i++)
    {
      ReadableMap localReadableMap = paramReadableArray.getMap(i);
      localStringBuilder.append(localReadableMap.getString("methodName")).append("@").append(parseFileId(localReadableMap)).append(localReadableMap.getInt("lineNumber"));
      if ((localReadableMap.hasKey("column")) && (!localReadableMap.isNull("column")) && (localReadableMap.getType("column") == ReadableType.Number))
        localStringBuilder.append(":").append(localReadableMap.getInt("column"));
      localStringBuilder.append("\n");
    }
    return localStringBuilder.toString();
  }

  private static String parseFileId(ReadableMap paramReadableMap)
  {
    if ((paramReadableMap.hasKey("file")) && (!paramReadableMap.isNull("file")) && (paramReadableMap.getType("file") == ReadableType.String))
    {
      Matcher localMatcher = FILE_ID_PATTERN.matcher(paramReadableMap.getString("file"));
      if (localMatcher.find())
        return localMatcher.group(1) + ":";
    }
    return "";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.util.JSStackTrace
 * JD-Core Version:    0.6.2
 */