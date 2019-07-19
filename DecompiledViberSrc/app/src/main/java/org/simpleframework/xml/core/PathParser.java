package org.simpleframework.xml.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.Style;
import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

class PathParser
  implements Expression
{
  protected boolean attribute;
  protected Cache<String> attributes = new ConcurrentCache();
  protected StringBuilder builder = new StringBuilder();
  protected String cache;
  protected int count;
  protected char[] data;
  protected Cache<String> elements = new ConcurrentCache();
  protected List<Integer> indexes = new ArrayList();
  protected String location;
  protected List<String> names = new ArrayList();
  protected int off;
  protected String path;
  protected List<String> prefixes = new ArrayList();
  protected int start;
  protected Style style;
  protected Type type;

  public PathParser(String paramString, Type paramType, Format paramFormat)
    throws Exception
  {
    this.style = paramFormat.getStyle();
    this.type = paramType;
    this.path = paramString;
    parse(paramString);
  }

  private void align()
    throws Exception
  {
    if (this.names.size() > this.indexes.size())
      this.indexes.add(Integer.valueOf(1));
  }

  private void attribute()
    throws Exception
  {
    int i = 1 + this.off;
    this.off = i;
    while (this.off < this.count)
    {
      char[] arrayOfChar = this.data;
      int j = this.off;
      this.off = (j + 1);
      char c = arrayOfChar[j];
      if (!isValid(c))
      {
        Object[] arrayOfObject2 = new Object[3];
        arrayOfObject2[0] = Character.valueOf(c);
        arrayOfObject2[1] = this.path;
        arrayOfObject2[2] = this.type;
        throw new PathException("Illegal character '%s' in attribute for '%s' in %s", arrayOfObject2);
      }
    }
    if (this.off <= i)
    {
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = this.path;
      arrayOfObject1[1] = this.type;
      throw new PathException("Attribute reference in '%s' for %s is empty", arrayOfObject1);
    }
    this.attribute = true;
    attribute(i, this.off - i);
  }

  private void attribute(int paramInt1, int paramInt2)
  {
    String str = new String(this.data, paramInt1, paramInt2);
    if (paramInt2 > 0)
      attribute(str);
  }

  private void attribute(String paramString)
  {
    String str = this.style.getAttribute(paramString);
    this.prefixes.add(null);
    this.names.add(str);
  }

  private void build()
  {
    int i = this.names.size();
    int j = i - 1;
    int k = 0;
    if (k < i)
    {
      String str1 = (String)this.prefixes.get(k);
      String str2 = (String)this.names.get(k);
      int m = ((Integer)this.indexes.get(k)).intValue();
      if (k > 0)
        this.builder.append('/');
      if ((this.attribute) && (k == j))
      {
        this.builder.append('@');
        this.builder.append(str2);
      }
      while (true)
      {
        k++;
        break;
        if (str1 != null)
        {
          this.builder.append(str1);
          this.builder.append(':');
        }
        this.builder.append(str2);
        this.builder.append('[');
        this.builder.append(m);
        this.builder.append(']');
      }
    }
    this.location = this.builder.toString();
  }

  private void element()
    throws Exception
  {
    int i = this.off;
    for (int j = 0; ; j++)
    {
      char c;
      if (this.off < this.count)
      {
        char[] arrayOfChar = this.data;
        int k = this.off;
        this.off = (k + 1);
        c = arrayOfChar[k];
        if (isValid(c))
          continue;
        if (c != '@')
          break label76;
        this.off = (-1 + this.off);
      }
      label76: 
      do
        while (true)
        {
          element(i, j);
          return;
          if (c != '[')
            break;
          index();
        }
      while (c == '/');
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = Character.valueOf(c);
      arrayOfObject[1] = this.path;
      arrayOfObject[2] = this.type;
      throw new PathException("Illegal character '%s' in element for '%s' in %s", arrayOfObject);
    }
  }

  private void element(int paramInt1, int paramInt2)
  {
    String str = new String(this.data, paramInt1, paramInt2);
    if (paramInt2 > 0)
      element(str);
  }

  private void element(String paramString)
  {
    int i = paramString.indexOf(':');
    String str1 = null;
    if (i > 0)
    {
      str1 = paramString.substring(0, i);
      paramString = paramString.substring(i + 1);
    }
    String str2 = this.style.getElement(paramString);
    this.prefixes.add(str1);
    this.names.add(str2);
  }

  private void index()
    throws Exception
  {
    int i;
    int m;
    if (this.data[(-1 + this.off)] == '[')
    {
      i = 0;
      if (this.off < this.count)
      {
        char[] arrayOfChar2 = this.data;
        int k = this.off;
        this.off = (k + 1);
        m = arrayOfChar2[k];
        if (isDigit(m))
          break label126;
      }
    }
    while (true)
    {
      char[] arrayOfChar1 = this.data;
      int j = this.off;
      this.off = (j + 1);
      if (arrayOfChar1[(j - 1)] != ']')
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = this.path;
        arrayOfObject[1] = this.type;
        throw new PathException("Invalid index for path '%s' in %s", arrayOfObject);
        label126: i = -48 + (m + i * 10);
        break;
      }
      this.indexes.add(Integer.valueOf(i));
      return;
      i = 0;
    }
  }

  private boolean isDigit(char paramChar)
  {
    return Character.isDigit(paramChar);
  }

  private boolean isEmpty(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }

  private boolean isLetter(char paramChar)
  {
    return Character.isLetterOrDigit(paramChar);
  }

  private boolean isSpecial(char paramChar)
  {
    return (paramChar == '_') || (paramChar == '-') || (paramChar == ':');
  }

  private boolean isValid(char paramChar)
  {
    return (isLetter(paramChar)) || (isSpecial(paramChar));
  }

  private void parse(String paramString)
    throws Exception
  {
    if (paramString != null)
    {
      this.count = paramString.length();
      this.data = new char[this.count];
      paramString.getChars(0, this.count, this.data, 0);
    }
    path();
  }

  private void path()
    throws Exception
  {
    if (this.data[this.off] == '/')
    {
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = this.path;
      arrayOfObject2[1] = this.type;
      throw new PathException("Path '%s' in %s references document root", arrayOfObject2);
    }
    if (this.data[this.off] == '.')
      skip();
    while (this.off < this.count)
    {
      if (this.attribute)
      {
        Object[] arrayOfObject1 = new Object[2];
        arrayOfObject1[0] = this.path;
        arrayOfObject1[1] = this.type;
        throw new PathException("Path '%s' in %s references an invalid attribute", arrayOfObject1);
      }
      segment();
    }
    truncate();
    build();
  }

  private void segment()
    throws Exception
  {
    int i = this.data[this.off];
    if (i == 47)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = this.path;
      arrayOfObject[1] = this.type;
      throw new PathException("Invalid path expression '%s' in %s", arrayOfObject);
    }
    if (i == 64)
      attribute();
    while (true)
    {
      align();
      return;
      element();
    }
  }

  private void skip()
    throws Exception
  {
    if (this.data.length > 1)
    {
      if (this.data[(1 + this.off)] != '/')
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = this.path;
        arrayOfObject[1] = this.type;
        throw new PathException("Path '%s' in %s has an illegal syntax", arrayOfObject);
      }
      this.off = (1 + this.off);
    }
    int i = 1 + this.off;
    this.off = i;
    this.start = i;
  }

  private void truncate()
    throws Exception
  {
    if (-1 + this.off >= this.data.length)
      this.off = (-1 + this.off);
    while (this.data[(-1 + this.off)] != '/')
      return;
    this.off = (-1 + this.off);
  }

  public String getAttribute(String paramString)
  {
    if (!isEmpty(this.location))
    {
      String str = (String)this.attributes.fetch(paramString);
      if (str == null)
      {
        str = getAttributePath(this.location, paramString);
        if (str != null)
          this.attributes.cache(paramString, str);
      }
      return str;
    }
    return this.style.getAttribute(paramString);
  }

  protected String getAttributePath(String paramString1, String paramString2)
  {
    String str = this.style.getAttribute(paramString2);
    if (isEmpty(paramString1))
      return str;
    return paramString1 + "/@" + str;
  }

  public String getElement(String paramString)
  {
    if (!isEmpty(this.location))
    {
      String str = (String)this.elements.fetch(paramString);
      if (str == null)
      {
        str = getElementPath(this.location, paramString);
        if (str != null)
          this.elements.cache(paramString, str);
      }
      return str;
    }
    return this.style.getElement(paramString);
  }

  protected String getElementPath(String paramString1, String paramString2)
  {
    String str = this.style.getElement(paramString2);
    if (isEmpty(str))
      return paramString1;
    if (isEmpty(paramString1))
      return str;
    return paramString1 + "/" + str + "[1]";
  }

  public String getFirst()
  {
    return (String)this.names.get(0);
  }

  public int getIndex()
  {
    return ((Integer)this.indexes.get(0)).intValue();
  }

  public String getLast()
  {
    int i = -1 + this.names.size();
    return (String)this.names.get(i);
  }

  public String getPath()
  {
    return this.location;
  }

  public Expression getPath(int paramInt)
  {
    return getPath(paramInt, 0);
  }

  public Expression getPath(int paramInt1, int paramInt2)
  {
    int i = -1 + this.names.size();
    if (i - paramInt2 >= paramInt1)
      return new PathSection(paramInt1, i - paramInt2);
    return new PathSection(paramInt1, paramInt1);
  }

  public String getPrefix()
  {
    return (String)this.prefixes.get(0);
  }

  public boolean isAttribute()
  {
    return this.attribute;
  }

  public boolean isEmpty()
  {
    return isEmpty(this.location);
  }

  public boolean isPath()
  {
    return this.names.size() > 1;
  }

  public Iterator<String> iterator()
  {
    return this.names.iterator();
  }

  public String toString()
  {
    int i = this.off - this.start;
    if (this.cache == null)
      this.cache = new String(this.data, this.start, i);
    return this.cache;
  }

  private class PathSection
    implements Expression
  {
    private int begin;
    private List<String> cache = new ArrayList();
    private int end;
    private String path;
    private String section;

    public PathSection(int paramInt1, int arg3)
    {
      this.begin = paramInt1;
      int i;
      this.end = i;
    }

    private String getCanonicalPath()
    {
      int i = 0;
      int j = 0;
      while (i < this.begin)
      {
        j = PathParser.this.location.indexOf('/', j + 1);
        i++;
      }
      int k = j;
      while (i <= this.end)
      {
        k = PathParser.this.location.indexOf('/', k + 1);
        if (k == -1)
          k = PathParser.this.location.length();
        i++;
      }
      return PathParser.this.location.substring(j + 1, k);
    }

    private String getFragment()
    {
      int i = 0;
      int j = PathParser.this.start;
      int k = 0;
      int m = j;
      while (true)
      {
        if (i <= this.end)
        {
          if (m >= PathParser.this.count)
            m++;
        }
        else
          return new String(PathParser.this.data, k, m - 1 - k);
        char[] arrayOfChar = PathParser.this.data;
        int n = m + 1;
        if (arrayOfChar[m] == '/')
        {
          i++;
          if (i == this.begin)
          {
            k = n;
            m = n;
          }
        }
        else
        {
          m = n;
        }
      }
    }

    public String getAttribute(String paramString)
    {
      String str = getPath();
      if (str != null)
        paramString = PathParser.this.getAttributePath(str, paramString);
      return paramString;
    }

    public String getElement(String paramString)
    {
      String str = getPath();
      if (str != null)
        paramString = PathParser.this.getElementPath(str, paramString);
      return paramString;
    }

    public String getFirst()
    {
      return (String)PathParser.this.names.get(this.begin);
    }

    public int getIndex()
    {
      return ((Integer)PathParser.this.indexes.get(this.begin)).intValue();
    }

    public String getLast()
    {
      return (String)PathParser.this.names.get(this.end);
    }

    public String getPath()
    {
      if (this.section == null)
        this.section = getCanonicalPath();
      return this.section;
    }

    public Expression getPath(int paramInt)
    {
      return getPath(paramInt, 0);
    }

    public Expression getPath(int paramInt1, int paramInt2)
    {
      return new PathSection(PathParser.this, paramInt1 + this.begin, this.end - paramInt2);
    }

    public String getPrefix()
    {
      return (String)PathParser.this.prefixes.get(this.begin);
    }

    public boolean isAttribute()
    {
      boolean bool1 = PathParser.this.attribute;
      boolean bool2 = false;
      if (bool1)
      {
        int i = this.end;
        int j = -1 + PathParser.this.names.size();
        bool2 = false;
        if (i >= j)
          bool2 = true;
      }
      return bool2;
    }

    public boolean isEmpty()
    {
      return this.begin == this.end;
    }

    public boolean isPath()
    {
      return this.end - this.begin >= 1;
    }

    public Iterator<String> iterator()
    {
      if (this.cache.isEmpty())
        for (int i = this.begin; i <= this.end; i++)
        {
          String str = (String)PathParser.this.names.get(i);
          if (str != null)
            this.cache.add(str);
        }
      return this.cache.iterator();
    }

    public String toString()
    {
      if (this.path == null)
        this.path = getFragment();
      return this.path;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.PathParser
 * JD-Core Version:    0.6.2
 */