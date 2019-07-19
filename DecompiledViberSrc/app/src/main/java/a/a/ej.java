package a.a;

import com.appboy.e.b.a;
import com.appboy.f.c;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public class ej
  implements ee
{
  private static final String a = c.a(ej.class);
  private ew b;
  private String c;
  private int d;
  private Object e;

  ej(ew paramew, String paramString, int paramInt)
  {
    this.b = paramew;
    this.c = paramString;
    this.d = paramInt;
  }

  protected ej(JSONObject paramJSONObject)
  {
    this((ew)dr.a(paramJSONObject, "property_type", ew.class, ew.e), paramJSONObject.getString("property_key"), paramJSONObject.getInt("comparator"));
    if (paramJSONObject.has("property_value"))
    {
      if (!this.b.equals(ew.a))
        break label63;
      this.e = paramJSONObject.getString("property_value");
    }
    label63: 
    do
    {
      return;
      if (this.b.equals(ew.d))
      {
        this.e = Boolean.valueOf(paramJSONObject.getBoolean("property_value"));
        return;
      }
      if (this.b.equals(ew.c))
      {
        this.e = Double.valueOf(paramJSONObject.getDouble("property_value"));
        return;
      }
    }
    while (!this.b.equals(ew.b));
    this.e = Long.valueOf(paramJSONObject.getLong("property_value"));
  }

  private boolean a(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool2;
    if ((!(paramObject instanceof Integer)) && (!(paramObject instanceof Double)))
      if (this.d == 2)
      {
        bool2 = bool1;
        bool1 = bool2;
      }
    double d1;
    double d2;
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            bool2 = false;
            break;
            d1 = ((Number)paramObject).doubleValue();
            d2 = ((Number)this.e).doubleValue();
            switch (this.d)
            {
            case 4:
            default:
              return false;
            case 3:
            case 5:
            case 1:
            case 2:
            }
          }
          while (d1 > d2);
          return false;
        }
        while (d1 < d2);
        return false;
      }
      while (d1 == d2);
      return false;
    }
    while (d1 != d2);
    return false;
  }

  private boolean a(Object paramObject, long paramLong)
  {
    boolean bool1 = true;
    boolean bool2 = paramObject instanceof String;
    Date localDate = null;
    if (bool2)
      localDate = di.a((String)paramObject, gr.b);
    boolean bool3;
    if (localDate == null)
      if (this.d == 2)
      {
        bool3 = bool1;
        bool1 = bool3;
      }
    long l1;
    long l2;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return bool1;
                    bool3 = false;
                    break;
                    l1 = di.a(localDate);
                    l2 = ((Number)this.e).longValue();
                    switch (this.d)
                    {
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    default:
                      return false;
                    case 3:
                    case 5:
                    case 15:
                    case 16:
                    case 4:
                    case 6:
                    case 1:
                    case 2:
                    }
                  }
                  while (l1 > l2);
                  return false;
                }
                while (l1 < l2);
                return false;
              }
              while (l1 < l2 + paramLong);
              return false;
            }
            while (l1 > l2 + paramLong);
            return false;
          }
          while (l1 >= paramLong - l2);
          return false;
        }
        while (l1 <= paramLong - l2);
        return false;
      }
      while (l1 == l2);
      return false;
    }
    while (l1 != l2);
    return false;
  }

  private boolean b(Object paramObject)
  {
    if (!(paramObject instanceof Boolean))
      if (this.d != 2);
    do
    {
      return true;
      return false;
      switch (this.d)
      {
      default:
        return false;
      case 1:
        return paramObject.equals(this.e);
      case 2:
      }
    }
    while (!paramObject.equals(this.e));
    return false;
  }

  private boolean c(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool2;
    if (!(paramObject instanceof String))
      if ((this.d == 2) || (this.d == 17))
      {
        bool2 = bool1;
        bool1 = bool2;
      }
    do
    {
      do
      {
        return bool1;
        bool2 = false;
        break;
        switch (this.d)
        {
        default:
          return false;
        case 10:
          return ((String)paramObject).matches((String)this.e);
        case 17:
        case 1:
        case 2:
        }
      }
      while (!((String)paramObject).matches((String)this.e));
      return false;
      return paramObject.equals(this.e);
    }
    while (!paramObject.equals(this.e));
    return false;
  }

  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (!this.b.equals(ew.e))
        localJSONObject.put("property_type", this.b.toString());
      localJSONObject.put("property_key", this.c);
      localJSONObject.put("comparator", this.d);
      localJSONObject.put("property_value", this.e);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      c.d(a, "Caught exception creating property filter Json.", localJSONException);
    }
    return localJSONObject;
  }

  public boolean a(ez paramez)
  {
    if (!(paramez instanceof fa));
    while (true)
    {
      return false;
      a locala = ((fa)paramez).f();
      Object localObject = null;
      if (locala != null);
      try
      {
        localObject = locala.b().opt(this.c);
        if (localObject == null)
        {
          if ((this.d != 12) && (this.d != 17))
            if (this.d != 2)
              break label187;
        }
        else
        {
          if (this.d == 11)
            return true;
          if (this.d == 12)
            continue;
          switch (1.a[this.b.ordinal()])
          {
          case 1:
            return c(localObject);
          case 2:
            return b(localObject);
          case 3:
            return a(localObject, paramez.c());
          case 4:
            boolean bool2 = a(localObject);
            return bool2;
          }
        }
      }
      catch (Exception localException)
      {
        c.d(a, "Caught exception checking property filter condition.", localException);
        return false;
      }
    }
    label187: for (boolean bool1 = true; ; bool1 = false)
      return bool1;
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.ej
 * JD-Core Version:    0.6.2
 */