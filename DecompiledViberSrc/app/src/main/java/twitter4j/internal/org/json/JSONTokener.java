package twitter4j.internal.org.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;

public class JSONTokener
{
  private int character;
  private boolean eof;
  private int index;
  private int line;
  private char previous;
  private Reader reader;
  private boolean usePrevious;

  public JSONTokener(InputStream paramInputStream)
    throws JSONException
  {
    this(new InputStreamReader(paramInputStream));
  }

  public JSONTokener(Reader paramReader)
  {
    if (paramReader.markSupported());
    while (true)
    {
      this.reader = paramReader;
      this.eof = false;
      this.usePrevious = false;
      this.previous = '\000';
      this.index = 0;
      this.character = 1;
      this.line = 1;
      return;
      paramReader = new BufferedReader(paramReader);
    }
  }

  public JSONTokener(String paramString)
  {
    this(new StringReader(paramString));
  }

  public void back()
    throws JSONException
  {
    if ((this.usePrevious) || (this.index <= 0))
      throw new JSONException("Stepping back two steps is not supported");
    this.index = (-1 + this.index);
    this.character = (-1 + this.character);
    this.usePrevious = true;
    this.eof = false;
  }

  public boolean end()
  {
    return (this.eof) && (!this.usePrevious);
  }

  public boolean more()
    throws JSONException
  {
    next();
    if (end())
      return false;
    back();
    return true;
  }

  public char next()
    throws JSONException
  {
    int j;
    int k;
    if (this.usePrevious)
    {
      this.usePrevious = false;
      j = this.previous;
      this.index = (1 + this.index);
      if (this.previous != '\r')
        break label112;
      this.line = (1 + this.line);
      k = 0;
      if (j != 10)
        break label106;
      label55: this.character = k;
    }
    while (true)
    {
      while (true)
      {
        this.previous = ((char)j);
        return this.previous;
        try
        {
          int i = this.reader.read();
          j = i;
          if (j > 0)
            break;
          this.eof = true;
          j = 0;
        }
        catch (IOException localIOException)
        {
          throw new JSONException(localIOException);
        }
      }
      label106: k = 1;
      break label55;
      label112: if (j == 10)
      {
        this.line = (1 + this.line);
        this.character = 0;
      }
      else
      {
        this.character = (1 + this.character);
      }
    }
  }

  public char next(char paramChar)
    throws JSONException
  {
    char c = next();
    if (c != paramChar)
      throw syntaxError("Expected '" + paramChar + "' and instead saw '" + c + "'");
    return c;
  }

  public String next(int paramInt)
    throws JSONException
  {
    if (paramInt == 0)
      return "";
    char[] arrayOfChar = new char[paramInt];
    for (int i = 0; i < paramInt; i++)
    {
      arrayOfChar[i] = next();
      if (end())
        throw syntaxError("Substring bounds error");
    }
    return new String(arrayOfChar);
  }

  public char nextClean()
    throws JSONException
  {
    char c;
    do
      c = next();
    while ((c != 0) && (c <= ' '));
    return c;
  }

  public String nextString(char paramChar)
    throws JSONException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    while (true)
    {
      char c1 = next();
      switch (c1)
      {
      default:
        if (c1 == paramChar)
          return localStringBuilder.toString();
        break;
      case '\000':
      case '\n':
      case '\r':
        throw syntaxError("Unterminated string");
      case '\\':
        char c2 = next();
        switch (c2)
        {
        default:
          throw syntaxError("Illegal escape.");
        case 'b':
          localStringBuilder.append('\b');
          break;
        case 't':
          localStringBuilder.append('\t');
          break;
        case 'n':
          localStringBuilder.append('\n');
          break;
        case 'f':
          localStringBuilder.append('\f');
          break;
        case 'r':
          localStringBuilder.append('\r');
          break;
        case 'u':
          localStringBuilder.append((char)Integer.parseInt(next(4), 16));
          break;
        case '"':
        case '\'':
        case '/':
        case '\\':
          localStringBuilder.append(c2);
        }
        break;
      }
      localStringBuilder.append(c1);
    }
  }

  public Object nextValue()
    throws JSONException
  {
    char c = nextClean();
    StringBuilder localStringBuilder;
    switch (c)
    {
    default:
      localStringBuilder = new StringBuilder();
    case '"':
    case '\'':
    case '{':
    case '[':
    }
    while ((c >= ' ') && (",:]}/\\\"[{;=#".indexOf(c) < 0))
    {
      localStringBuilder.append(c);
      c = next();
      continue;
      return nextString(c);
      back();
      return new JSONObject(this);
      back();
      return new JSONArray(this);
    }
    back();
    String str = localStringBuilder.toString().trim();
    if (str.equals(""))
      throw syntaxError("Missing value");
    return JSONObject.stringToValue(str);
  }

  public JSONException syntaxError(String paramString)
  {
    return new JSONException(paramString + toString());
  }

  public String toString()
  {
    return " at " + this.index + " [character " + this.character + " line " + this.line + "]";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.internal.org.json.JSONTokener
 * JD-Core Version:    0.6.2
 */