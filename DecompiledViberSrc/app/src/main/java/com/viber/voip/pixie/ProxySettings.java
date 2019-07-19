package com.viber.voip.pixie;

import com.google.d.a.c;
import java.io.Serializable;

public class ProxySettings
  implements Serializable
{
  public static final String ENABLED = "proxy_enabled";
  public static final String ENCRYPTION_METHOD = "method";
  public static final String[] ENCRYPTION_METHODS = { "Salsa20", "ChaCha20", "AES-128/CFB", "AES-192/CFB", "AES-256/CFB", "AES-128/CTR", "AES-192/CTR", "AES-256/CTR", "Camellia-128/CFB", "Camellia-192/CFB", "Camellia-256/CFB", "AES-128/GCM", "AES-192/GCM", "AES-256/GCM" };
  public static final String ENCRYPTION_METHOD_AES128CFB = "AES-128/CFB";
  public static final String ENCRYPTION_METHOD_AES128CTR = "AES-128/CTR";
  public static final String ENCRYPTION_METHOD_AES128GCM = "AES-128/GCM";
  public static final String ENCRYPTION_METHOD_AES192CFB = "AES-192/CFB";
  public static final String ENCRYPTION_METHOD_AES192CTR = "AES-192/CTR";
  public static final String ENCRYPTION_METHOD_AES192GCM = "AES-192/GCM";
  public static final String ENCRYPTION_METHOD_AES256CFB = "AES-256/CFB";
  public static final String ENCRYPTION_METHOD_AES256CTR = "AES-256/CTR";
  public static final String ENCRYPTION_METHOD_AES256GCM = "AES-256/GCM";
  public static final String ENCRYPTION_METHOD_CAMELLIA128CFB = "Camellia-128/CFB";
  public static final String ENCRYPTION_METHOD_CAMELLIA192CFB = "Camellia-192/CFB";
  public static final String ENCRYPTION_METHOD_CAMELLIA256CFB = "Camellia-256/CFB";
  public static final String ENCRYPTION_METHOD_CHACHA20 = "ChaCha20";
  public static final String ENCRYPTION_METHOD_SALSA20 = "Salsa20";
  public static final String KEY = "key";
  public static final String PASSWORD = "password";
  public static final String PORT = "port";
  public static final String SERVER_NAME = "server_name";
  public static final String TYPE = "type";
  public static final String[] TYPES = { "socks5", "ss", "gq" };
  public static final String TYPE_GO_QUIET = "gq";
  public static final String TYPE_SHADOW_SOCKS = "ss";
  public static final String TYPE_SOCKS5 = "socks5";
  public static final String UDP = "udp";
  public static final String URL = "url";
  public static final String USERNAME = "username";

  @c(a="proxy_enabled")
  public final boolean enabled;

  @c(a="method")
  public final String encryptionMethod;

  @c(a="key")
  public String key;

  @c(a="password")
  public final String password;

  @c(a="port")
  public final int port;

  @c(a="server_name")
  public String serverName;

  @c(a="type")
  public final String type;

  @c(a="udp")
  public final boolean udp;

  @c(a="url")
  public final String url;

  @c(a="username")
  public final String username;

  public ProxySettings(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, boolean paramBoolean1, String paramString5, String paramString6, String paramString7, boolean paramBoolean2)
  {
    this.type = paramString1;
    this.url = paramString2;
    this.username = paramString3;
    this.password = paramString4;
    this.port = paramInt;
    this.udp = paramBoolean1;
    this.encryptionMethod = paramString5;
    this.serverName = paramString6;
    this.key = paramString7;
    this.enabled = paramBoolean2;
  }

  public String toString()
  {
    return "ProxySettings{type='" + this.type + '\'' + ", url='" + this.url + '\'' + ", username='" + this.username + '\'' + ", password='" + this.password + '\'' + ", port=" + this.port + ", udp=" + this.udp + ", encryptionMethod='" + this.encryptionMethod + '\'' + ", enabled=" + this.enabled + ", serverName=" + this.serverName + ", key=" + this.key + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.pixie.ProxySettings
 * JD-Core Version:    0.6.2
 */