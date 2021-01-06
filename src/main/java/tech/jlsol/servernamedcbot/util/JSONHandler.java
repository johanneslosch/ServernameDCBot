package tech.jlsol.servernamedcbot.util;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONHandler {
    private static Integer getIDFeatureRequest(){
        return Integer.valueOf(Config.readConfig(
                "data",
                "FeatureRequestHelper",
                "ID-FeatureRequest"));
    }

    private static void setIDFeatureRequest(){
        Config.writeConfig(
                "data",
                "FeatureRequestHelper",
                "ID-FeatureRequest",
                String.valueOf(getIDFeatureRequest() + 1));
    }

    private static Integer getOldIDFeatureRequest(){
        return getIDFeatureRequest() - 1;
    }

    public static void FeatureRequestWriter(String request, String requestedBy){
        JSONObject object = new JSONObject();
        JSONArray array = new JSONArray();
        array.put(0, "ID: " + getIDFeatureRequest())
                .put(1, "time: " + SQLHandler.MySQLUseDataManager.timeStamp)
                .put(2, "request: " + request)
                .put(3, "requested by: " + requestedBy);
        object.put("id", getIDFeatureRequest())
                .put("details", array);
        setIDFeatureRequest();
        WriteFile.writer(
                "featureRequest",
                "#" + getOldIDFeatureRequest() + "---" +
                        SQLHandler.MySQLUseDataManager.timeStamp,
                "json",
                object.toString(1));
    }
}
