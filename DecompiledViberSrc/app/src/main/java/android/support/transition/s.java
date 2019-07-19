package android.support.transition;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class s
{
  public final Map<String, Object> a = new HashMap();
  public View b;
  final ArrayList<l> c = new ArrayList();

  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof s)) && (this.b == ((s)paramObject).b) && (this.a.equals(((s)paramObject).a));
  }

  public int hashCode()
  {
    return 31 * this.b.hashCode() + this.a.hashCode();
  }

  public String toString()
  {
    String str1 = "TransitionValues@" + Integer.toHexString(hashCode()) + ":\n";
    String str2 = str1 + "    view = " + this.b + "\n";
    String str3 = str2 + "    values:";
    Iterator localIterator = this.a.keySet().iterator();
    String str5;
    for (String str4 = str3; localIterator.hasNext(); str4 = str4 + "    " + str5 + ": " + this.a.get(str5) + "\n")
      str5 = (String)localIterator.next();
    return str4;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.transition.s
 * JD-Core Version:    0.6.2
 */