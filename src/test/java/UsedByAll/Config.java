package UsedByAll;


import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;

public class Config {
    private String scheme;
    private boolean isHttpsConnection;
    private TestUser admin;
    private TestUser adminButika;
    private TestUser baseUser;

    public void setScheme(String a)
    { this.scheme = a; }
    public void setIsHttpsConnection(boolean a)
    { this.isHttpsConnection = a; }
    public void setAdmin(TestUser a)
    { this.admin = a; }
    public void setAdminButika(TestUser a)
    { this.adminButika = a; }
    public void setBaseUser(TestUser a)
    { this.baseUser = a; }
    public String getScheme()
    { return scheme; }
    public boolean getIsHttpsConnection()
    { return isHttpsConnection; }
    public TestUser getAdmin()
    { return admin; }
    public TestUser getAdminButika()
    { return adminButika; }
    public TestUser getBaseUser()
    { return baseUser; }

    public String getProtocol()
    {
        String protocol = "http://";
        if (getIsHttpsConnection()){
            protocol = "https://";
        }
        return protocol;
    }

    public Config(String scheme, boolean isHttpsConnection, TestUser admin, TestUser baseUser, TestUser adminButika){
        this.setScheme(scheme);
        this.setIsHttpsConnection(isHttpsConnection);
        this.setAdmin(admin);
        this.setAdminButika(adminButika);
        this.setBaseUser(baseUser);
    }

    public static Config getConfig()
    {
        //Читаем .json-файл и заполняем списки данных значениями из файла. В списки попадают данные только тех пользователей, которые в поле "useInTest" имеют значение "+"
        try {
            // Читаем конфиг
            FileReader reader = new FileReader("src/test/Config.json");
            BufferedReader br = new BufferedReader(reader);
            String result = "";
            String line;
            while ((line = br.readLine()) != null) {
                result += line;
            }
            br.close();
            JSONObject object = new JSONObject(result);
            JSONObject adminObject = object.getJSONObject("admin");
            TestUser admin = new TestUser();
            admin.setEmail(adminObject.getString("login"));
            admin.setPassword1(adminObject.getString("password"));
            JSONObject baseUserObject = object.getJSONObject("defaultUser");
            TestUser baseUser = new TestUser();
            baseUser.setEmail(baseUserObject.getString("login"));
            baseUser.setPassword1(baseUserObject.getString("password"));
            JSONObject adminButikaObject = object.getJSONObject("adminButika");
            TestUser adminButika = new TestUser();
            adminButika.setEmail(adminButikaObject.getString("login"));
            adminButika.setPassword1(adminButikaObject.getString("password"));
            // Отдаем конфиг
            return new Config(object.getString("scheme"), object.getBoolean("isHttpsConnection"), admin, baseUser, adminButika);
            }
        catch (Exception e){
            System.out.println("File not found. Exception: " + e);
            return null;
        }
    }
}