package twitter4j.internal.json;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import twitter4j.HashtagEntity;
import twitter4j.MediaEntity;
import twitter4j.URLEntity;
import twitter4j.UserMentionEntity;

final class HTMLEntity
{
  private static final Map<java.lang.String, java.lang.String> entityEscapeMap = new HashMap();
  private static final Map<java.lang.String, java.lang.String> escapeEntityMap = new HashMap();

  static
  {
    for ([Ljava.lang.String localString; : new java.lang.String[][] { { "&nbsp;", "&#160;", " " }, { "&iexcl;", "&#161;", "¡" }, { "&cent;", "&#162;", "¢" }, { "&pound;", "&#163;", "£" }, { "&curren;", "&#164;", "¤" }, { "&yen;", "&#165;", "¥" }, { "&brvbar;", "&#166;", "¦" }, { "&sect;", "&#167;", "§" }, { "&uml;", "&#168;", "¨" }, { "&copy;", "&#169;", "©" }, { "&ordf;", "&#170;", "ª" }, { "&laquo;", "&#171;", "«" }, { "&not;", "&#172;", "¬" }, { "&shy;", "&#173;", "­" }, { "&reg;", "&#174;", "®" }, { "&macr;", "&#175;", "¯" }, { "&deg;", "&#176;", "°" }, { "&plusmn;", "&#177;", "±" }, { "&sup2;", "&#178;", "²" }, { "&sup3;", "&#179;", "³" }, { "&acute;", "&#180;", "´" }, { "&micro;", "&#181;", "µ" }, { "&para;", "&#182;", "¶" }, { "&middot;", "&#183;", "·" }, { "&cedil;", "&#184;", "¸" }, { "&sup1;", "&#185;", "¹" }, { "&ordm;", "&#186;", "º" }, { "&raquo;", "&#187;", "»" }, { "&frac14;", "&#188;", "¼" }, { "&frac12;", "&#189;", "½" }, { "&frac34;", "&#190;", "¾" }, { "&iquest;", "&#191;", "¿" }, { "&Agrave;", "&#192;", "À" }, { "&Aacute;", "&#193;", "Á" }, { "&Acirc;", "&#194;", "Â" }, { "&Atilde;", "&#195;", "Ã" }, { "&Auml;", "&#196;", "Ä" }, { "&Aring;", "&#197;", "Å" }, { "&AElig;", "&#198;", "Æ" }, { "&Ccedil;", "&#199;", "Ç" }, { "&Egrave;", "&#200;", "È" }, { "&Eacute;", "&#201;", "É" }, { "&Ecirc;", "&#202;", "Ê" }, { "&Euml;", "&#203;", "Ë" }, { "&Igrave;", "&#204;", "Ì" }, { "&Iacute;", "&#205;", "Í" }, { "&Icirc;", "&#206;", "Î" }, { "&Iuml;", "&#207;", "Ï" }, { "&ETH;", "&#208;", "Ð" }, { "&Ntilde;", "&#209;", "Ñ" }, { "&Ograve;", "&#210;", "Ò" }, { "&Oacute;", "&#211;", "Ó" }, { "&Ocirc;", "&#212;", "Ô" }, { "&Otilde;", "&#213;", "Õ" }, { "&Ouml;", "&#214;", "Ö" }, { "&times;", "&#215;", "×" }, { "&Oslash;", "&#216;", "Ø" }, { "&Ugrave;", "&#217;", "Ù" }, { "&Uacute;", "&#218;", "Ú" }, { "&Ucirc;", "&#219;", "Û" }, { "&Uuml;", "&#220;", "Ü" }, { "&Yacute;", "&#221;", "Ý" }, { "&THORN;", "&#222;", "Þ" }, { "&szlig;", "&#223;", "ß" }, { "&agrave;", "&#224;", "à" }, { "&aacute;", "&#225;", "á" }, { "&acirc;", "&#226;", "â" }, { "&atilde;", "&#227;", "ã" }, { "&auml;", "&#228;", "ä" }, { "&aring;", "&#229;", "å" }, { "&aelig;", "&#230;", "æ" }, { "&ccedil;", "&#231;", "ç" }, { "&egrave;", "&#232;", "è" }, { "&eacute;", "&#233;", "é" }, { "&ecirc;", "&#234;", "ê" }, { "&euml;", "&#235;", "ë" }, { "&igrave;", "&#236;", "ì" }, { "&iacute;", "&#237;", "í" }, { "&icirc;", "&#238;", "î" }, { "&iuml;", "&#239;", "ï" }, { "&eth;", "&#240;", "ð" }, { "&ntilde;", "&#241;", "ñ" }, { "&ograve;", "&#242;", "ò" }, { "&oacute;", "&#243;", "ó" }, { "&ocirc;", "&#244;", "ô" }, { "&otilde;", "&#245;", "õ" }, { "&ouml;", "&#246;", "ö" }, { "&divide;", "&#247;", "÷" }, { "&oslash;", "&#248;", "ø" }, { "&ugrave;", "&#249;", "ù" }, { "&uacute;", "&#250;", "ú" }, { "&ucirc;", "&#251;", "û" }, { "&uuml;", "&#252;", "ü" }, { "&yacute;", "&#253;", "ý" }, { "&thorn;", "&#254;", "þ" }, { "&yuml;", "&#255;", "ÿ" }, { "&fnof;", "&#402;", "ƒ" }, { "&Alpha;", "&#913;", "Α" }, { "&Beta;", "&#914;", "Β" }, { "&Gamma;", "&#915;", "Γ" }, { "&Delta;", "&#916;", "Δ" }, { "&Epsilon;", "&#917;", "Ε" }, { "&Zeta;", "&#918;", "Ζ" }, { "&Eta;", "&#919;", "Η" }, { "&Theta;", "&#920;", "Θ" }, { "&Iota;", "&#921;", "Ι" }, { "&Kappa;", "&#922;", "Κ" }, { "&Lambda;", "&#923;", "Λ" }, { "&Mu;", "&#924;", "Μ" }, { "&Nu;", "&#925;", "Ν" }, { "&Xi;", "&#926;", "Ξ" }, { "&Omicron;", "&#927;", "Ο" }, { "&Pi;", "&#928;", "Π" }, { "&Rho;", "&#929;", "Ρ" }, { "&Sigma;", "&#931;", "Σ" }, { "&Tau;", "&#932;", "Τ" }, { "&Upsilon;", "&#933;", "Υ" }, { "&Phi;", "&#934;", "Φ" }, { "&Chi;", "&#935;", "Χ" }, { "&Psi;", "&#936;", "Ψ" }, { "&Omega;", "&#937;", "Ω" }, { "&alpha;", "&#945;", "α" }, { "&beta;", "&#946;", "β" }, { "&gamma;", "&#947;", "γ" }, { "&delta;", "&#948;", "δ" }, { "&epsilon;", "&#949;", "ε" }, { "&zeta;", "&#950;", "ζ" }, { "&eta;", "&#951;", "η" }, { "&theta;", "&#952;", "θ" }, { "&iota;", "&#953;", "ι" }, { "&kappa;", "&#954;", "κ" }, { "&lambda;", "&#955;", "λ" }, { "&mu;", "&#956;", "μ" }, { "&nu;", "&#957;", "ν" }, { "&xi;", "&#958;", "ξ" }, { "&omicron;", "&#959;", "ο" }, { "&pi;", "&#960;", "π" }, { "&rho;", "&#961;", "ρ" }, { "&sigmaf;", "&#962;", "ς" }, { "&sigma;", "&#963;", "σ" }, { "&tau;", "&#964;", "τ" }, { "&upsilon;", "&#965;", "υ" }, { "&phi;", "&#966;", "φ" }, { "&chi;", "&#967;", "χ" }, { "&psi;", "&#968;", "ψ" }, { "&omega;", "&#969;", "ω" }, { "&thetasym;", "&#977;", "ϑ" }, { "&upsih;", "&#978;", "ϒ" }, { "&piv;", "&#982;", "ϖ" }, { "&bull;", "&#8226;", "•" }, { "&hellip;", "&#8230;", "…" }, { "&prime;", "&#8242;", "′" }, { "&Prime;", "&#8243;", "″" }, { "&oline;", "&#8254;", "‾" }, { "&frasl;", "&#8260;", "⁄" }, { "&weierp;", "&#8472;", "℘" }, { "&image;", "&#8465;", "ℑ" }, { "&real;", "&#8476;", "ℜ" }, { "&trade;", "&#8482;", "™" }, { "&alefsym;", "&#8501;", "ℵ" }, { "&larr;", "&#8592;", "←" }, { "&uarr;", "&#8593;", "↑" }, { "&rarr;", "&#8594;", "→" }, { "&darr;", "&#8595;", "↓" }, { "&harr;", "&#8596;", "↔" }, { "&crarr;", "&#8629;", "↵" }, { "&lArr;", "&#8656;", "⇐" }, { "&uArr;", "&#8657;", "⇑" }, { "&rArr;", "&#8658;", "⇒" }, { "&dArr;", "&#8659;", "⇓" }, { "&hArr;", "&#8660;", "⇔" }, { "&forall;", "&#8704;", "∀" }, { "&part;", "&#8706;", "∂" }, { "&exist;", "&#8707;", "∃" }, { "&empty;", "&#8709;", "∅" }, { "&nabla;", "&#8711;", "∇" }, { "&isin;", "&#8712;", "∈" }, { "&notin;", "&#8713;", "∉" }, { "&ni;", "&#8715;", "∋" }, { "&prod;", "&#8719;", "∏" }, { "&sum;", "&#8721;", "∑" }, { "&minus;", "&#8722;", "−" }, { "&lowast;", "&#8727;", "∗" }, { "&radic;", "&#8730;", "√" }, { "&prop;", "&#8733;", "∝" }, { "&infin;", "&#8734;", "∞" }, { "&ang;", "&#8736;", "∠" }, { "&and;", "&#8743;", "∧" }, { "&or;", "&#8744;", "∨" }, { "&cap;", "&#8745;", "∩" }, { "&cup;", "&#8746;", "∪" }, { "&int;", "&#8747;", "∫" }, { "&there4;", "&#8756;", "∴" }, { "&sim;", "&#8764;", "∼" }, { "&cong;", "&#8773;", "≅" }, { "&asymp;", "&#8776;", "≈" }, { "&ne;", "&#8800;", "≠" }, { "&equiv;", "&#8801;", "≡" }, { "&le;", "&#8804;", "≤" }, { "&ge;", "&#8805;", "≥" }, { "&sub;", "&#8834;", "⊂" }, { "&sup;", "&#8835;", "⊃" }, { "&sube;", "&#8838;", "⊆" }, { "&supe;", "&#8839;", "⊇" }, { "&oplus;", "&#8853;", "⊕" }, { "&otimes;", "&#8855;", "⊗" }, { "&perp;", "&#8869;", "⊥" }, { "&sdot;", "&#8901;", "⋅" }, { "&lceil;", "&#8968;", "⌈" }, { "&rceil;", "&#8969;", "⌉" }, { "&lfloor;", "&#8970;", "⌊" }, { "&rfloor;", "&#8971;", "⌋" }, { "&lang;", "&#9001;", "〈" }, { "&rang;", "&#9002;", "〉" }, { "&loz;", "&#9674;", "◊" }, { "&spades;", "&#9824;", "♠" }, { "&clubs;", "&#9827;", "♣" }, { "&hearts;", "&#9829;", "♥" }, { "&diams;", "&#9830;", "♦" }, { "&quot;", "&#34;", "\"" }, { "&amp;", "&#38;", "&" }, { "&lt;", "&#60;", "<" }, { "&gt;", "&#62;", ">" }, { "&OElig;", "&#338;", "Œ" }, { "&oelig;", "&#339;", "œ" }, { "&Scaron;", "&#352;", "Š" }, { "&scaron;", "&#353;", "š" }, { "&Yuml;", "&#376;", "Ÿ" }, { "&circ;", "&#710;", "ˆ" }, { "&tilde;", "&#732;", "˜" }, { "&ensp;", "&#8194;", " " }, { "&emsp;", "&#8195;", " " }, { "&thinsp;", "&#8201;", " " }, { "&zwnj;", "&#8204;", "‌" }, { "&zwj;", "&#8205;", "‍" }, { "&lrm;", "&#8206;", "‎" }, { "&rlm;", "&#8207;", "‏" }, { "&ndash;", "&#8211;", "–" }, { "&mdash;", "&#8212;", "—" }, { "&lsquo;", "&#8216;", "‘" }, { "&rsquo;", "&#8217;", "’" }, { "&sbquo;", "&#8218;", "‚" }, { "&ldquo;", "&#8220;", "“" }, { "&rdquo;", "&#8221;", "”" }, { "&bdquo;", "&#8222;", "„" }, { "&dagger;", "&#8224;", "†" }, { "&Dagger;", "&#8225;", "‡" }, { "&permil;", "&#8240;", "‰" }, { "&lsaquo;", "&#8249;", "‹" }, { "&rsaquo;", "&#8250;", "›" }, { "&euro;", "&#8364;", "€" } })
    {
      entityEscapeMap.put(localString;[2], localString;[0]);
      escapeEntityMap.put(localString;[0], localString;[2]);
      escapeEntityMap.put(localString;[1], localString;[2]);
    }
  }

  static java.lang.String escape(java.lang.String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    escape(localStringBuilder);
    return localStringBuilder.toString();
  }

  static void escape(StringBuilder paramStringBuilder)
  {
    int i = 0;
    while (i < paramStringBuilder.length())
    {
      java.lang.String str = (java.lang.String)entityEscapeMap.get(paramStringBuilder.substring(i, i + 1));
      if (str != null)
      {
        paramStringBuilder.replace(i, i + 1, str);
        i += str.length();
      }
      else
      {
        i++;
      }
    }
  }

  static java.lang.String unescape(java.lang.String paramString)
  {
    java.lang.String str = null;
    if (paramString != null)
    {
      StringBuilder localStringBuilder = new StringBuilder(paramString);
      unescape(localStringBuilder);
      str = localStringBuilder.toString();
    }
    return str;
  }

  static void unescape(StringBuilder paramStringBuilder)
  {
    int j;
    for (int i = 0; ; i = j + 1)
    {
      if (i < paramStringBuilder.length())
      {
        j = paramStringBuilder.indexOf("&", i);
        if (-1 != j)
          break label25;
      }
      label25: int k;
      do
      {
        return;
        k = paramStringBuilder.indexOf(";", j);
      }
      while (-1 == k);
      java.lang.String str1 = paramStringBuilder.substring(j, k + 1);
      java.lang.String str2 = (java.lang.String)escapeEntityMap.get(str1);
      if (str2 != null)
        paramStringBuilder.replace(j, k + 1, str2);
    }
  }

  static java.lang.String unescapeAndSlideEntityIncdices(java.lang.String paramString, UserMentionEntity[] paramArrayOfUserMentionEntity, URLEntity[] paramArrayOfURLEntity, HashtagEntity[] paramArrayOfHashtagEntity, MediaEntity[] paramArrayOfMediaEntity)
  {
    int i;
    int k;
    label20: int n;
    label34: int i2;
    label49: EntityIndex[] arrayOfEntityIndex;
    if (paramArrayOfUserMentionEntity == null)
    {
      i = 0;
      int j = 0 + i;
      if (paramArrayOfURLEntity != null)
        break label341;
      k = 0;
      int m = j + k;
      if (paramArrayOfHashtagEntity != null)
        break label348;
      n = 0;
      int i1 = m + n;
      if (paramArrayOfMediaEntity != null)
        break label355;
      i2 = 0;
      arrayOfEntityIndex = new EntityIndex[i2 + i1];
      if (paramArrayOfUserMentionEntity == null)
        break label513;
      System.arraycopy(paramArrayOfUserMentionEntity, 0, arrayOfEntityIndex, 0, paramArrayOfUserMentionEntity.length);
    }
    label513: for (int i3 = 0 + paramArrayOfUserMentionEntity.length; ; i3 = 0)
    {
      if (paramArrayOfURLEntity != null)
      {
        System.arraycopy(paramArrayOfURLEntity, 0, arrayOfEntityIndex, i3, paramArrayOfURLEntity.length);
        i3 += paramArrayOfURLEntity.length;
      }
      if (paramArrayOfHashtagEntity != null)
      {
        System.arraycopy(paramArrayOfHashtagEntity, 0, arrayOfEntityIndex, i3, paramArrayOfHashtagEntity.length);
        i3 += paramArrayOfHashtagEntity.length;
      }
      if (paramArrayOfMediaEntity != null)
        System.arraycopy(paramArrayOfMediaEntity, 0, arrayOfEntityIndex, i3, paramArrayOfMediaEntity.length);
      Arrays.sort(arrayOfEntityIndex);
      StringBuilder localStringBuilder = new StringBuilder(paramString.length());
      int i4 = 0;
      int i5 = 0;
      int i6 = 1;
      label168: char c;
      int i8;
      int i7;
      label262: int i9;
      int i10;
      if (i4 < paramString.length())
      {
        c = paramString.charAt(i4);
        if (c == '&')
        {
          int i12 = paramString.indexOf(";", i4);
          if (-1 != i12)
          {
            java.lang.String str1 = paramString.substring(i4, i12 + 1);
            java.lang.String str2 = (java.lang.String)escapeEntityMap.get(str1);
            if (str2 != null)
            {
              localStringBuilder.append(str2);
              i8 = 1 - str1.length();
              i7 = i12;
              if (i5 >= arrayOfEntityIndex.length)
                break label502;
              if (i6 == 0)
                break label417;
              if (arrayOfEntityIndex[i5].getStart() != i8 + i7)
                break label502;
              arrayOfEntityIndex[i5].setStart(-1 + localStringBuilder.length());
              i9 = i5;
              i10 = 0;
            }
          }
        }
      }
      while (true)
      {
        int i11 = i7 + 1;
        i6 = i10;
        i5 = i9;
        i4 = i11;
        break label168;
        i = paramArrayOfUserMentionEntity.length;
        break;
        label341: k = paramArrayOfURLEntity.length;
        break label20;
        label348: n = paramArrayOfHashtagEntity.length;
        break label34;
        label355: i2 = paramArrayOfMediaEntity.length;
        break label49;
        localStringBuilder.append(c);
        i7 = i4;
        i8 = 0;
        break label262;
        localStringBuilder.append(c);
        i7 = i4;
        i8 = 0;
        break label262;
        localStringBuilder.append(c);
        i7 = i4;
        i8 = 0;
        break label262;
        label417: if (arrayOfEntityIndex[i5].getEnd() == i8 + i7)
        {
          arrayOfEntityIndex[i5].setEnd(-1 + localStringBuilder.length());
          i9 = i5 + 1;
          i10 = 1;
          continue;
          if ((i5 < arrayOfEntityIndex.length) && (arrayOfEntityIndex[i5].getEnd() == paramString.length()))
            arrayOfEntityIndex[i5].setEnd(localStringBuilder.length());
          return localStringBuilder.toString();
        }
        else
        {
          label502: i9 = i5;
          i10 = i6;
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_5_dex2jar.jar
 * Qualified Name:     twitter4j.internal.json.HTMLEntity
 * JD-Core Version:    0.6.2
 */