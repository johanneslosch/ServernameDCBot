package tech.jlsol.servernamedcbot.util;

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
        object.put( "ID" , getIDFeatureRequest())
                .put("time", SQLHandler.MySQLUseDataManager.timeStamp)
                .put("request", request)
                .put("requested by", requestedBy);
        setIDFeatureRequest();
        WriteFile.writer(
                "featureRequest",
                SQLHandler.MySQLUseDataManager.timeStamp + "---" +
                        "#" + getOldIDFeatureRequest(),
                "json",
                object.toString(1));
    }
}
