package tech.jlsol.servernamedcbot.listeners;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.json.JSONObject;
import org.json.JSONTokener;
import tech.jlsol.servernamedcbot.util.Config;
import tech.jlsol.servernamedcbot.util.ErrorHandler;
import tech.jlsol.servernamedcbot.util.Logger;
import tech.jlsol.servernamedcbot.util.SQLHandler;

import javax.annotation.Nonnull;

import java.awt.*;
import java.io.*;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import static tech.jlsol.servernamedcbot.util.JSONHandler.FeatureRequestWriter;

public class MessageListeners extends ListenerAdapter {
    private String getConfig(String key){
        return Config.readConfig("data", "settings", key);
    }
    public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
        if(!event.getAuthor().isBot()){
            if(event.getChannel().getName().equals(getConfig("featureRQ-TC"))){
                if(event.getMessage().getContentRaw().toLowerCase().startsWith(getConfig("prefix"))){
                    //FeatureRequestWriter(event.getMessage().getContentRaw()
                    //                .substring(getConfig("prefix").length()),
                    //        event.getAuthor().getAsTag() + "/" + event.getAuthor().getId());
                    try {
                        SQLHandler.MySQLUseDataManager.setFeatureRequest(SQLHandler.MySQLUseDataManager.timeStamp,
                                event.getMessage().getContentRaw().substring(getConfig("prefix").length()),
                                event.getAuthor().getAsTag() + "/" + event.getAuthor().getId());
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }else{
                if(event.getMessage().getContentRaw()
                        .toLowerCase().startsWith(getConfig("prefix")+"reset")){
                        File file = new File("./data/util/FeatureRequestHelper.prop");
                        if(file.delete())
                        {
                            File dir = new File("./featureRequest");
                            if(dir.delete())
                            {
                                event.getChannel().sendMessage("reset successful").
                                        complete().delete().completeAfter(10, TimeUnit.SECONDS);
                            }
                            Config.writeConfig(
                                    "data",
                                    "FeatureRequestHelper",
                                    "ID-FeatureRequest",
                                    "0");
                            event.getChannel().sendMessage("reset successful").
                                    complete().delete().completeAfter(20, TimeUnit.SECONDS);
                            Logger.msg("Feature Request - reset successful");

                        }
                        else
                        {
                            Config.writeConfig(
                                    "data",
                                    "FeatureRequestHelper",
                                    "ID-FeatureRequest",
                                    "0");
                            Logger.error(ErrorHandler.getErrorMessage(ErrorHandler.ErrorCodes.SECURITY_EXCEPTION,
                                    java.util.Optional.of("Failed to delete the file")));
                        }
                }
                if(event.getMessage().getContentDisplay()
                        .toLowerCase().startsWith(getConfig("prefix")+"showall")){
                    String[] pathNames;
                    File f = new File("./featureRequest/");
                    pathNames = f.list();

                    for (String pathname : pathNames) {
                        handleFileData(f, pathname, event);
                    }
                }
                if(event.getMessage().getContentDisplay()
                        .toLowerCase().startsWith(getConfig("prefix")+"get")){
                    String message = event.getMessage().getContentDisplay().toLowerCase()
                            .replace(getConfig("prefix")+"get", "");
                    if(message.startsWith(" ")){
                        message = message.replace(" ", "");
                    }
                    System.out.println(message);
                    String[] pathNames;
                    File f = new File("./featureRequest/");
                    pathNames = f.list();

                    for (String pathname : pathNames) {
                        if(pathname.endsWith("#" + message + ".json")){
                            handleFileData(f, pathname, event);
                        }
                    }
                }
            }
        }
    }

    /**
     *                     handles file data, and print it as embed messages in text channel
     * @param f            directory, 'File f = new File("./featureRequest/")'
     * @param pathname     String with filename
     * @param event        MessageReceiveEvent to get connected to guild
     */
    private void handleFileData(File f, String pathname, MessageReceivedEvent event){
        try {
            FileInputStream fileInputStream = new FileInputStream(String.format("%s/%s", f, pathname));
            JSONObject object = new JSONObject(new JSONTokener(fileInputStream));
            event.getChannel().sendMessage(
                    new EmbedBuilder()
                            .setAuthor(object.getString("requested by"))
                            .setDescription(object.getString("request"))
                            .setTitle("Feature-Request - " + object.getInt("ID"))
                            .setFooter(object.getString("time"))
                            .setColor(Color.BLUE)
                            .build())
                    .queue();
        } catch (FileNotFoundException e) {
            Logger.error(ErrorHandler.getErrorMessage(ErrorHandler.ErrorCodes.FILE_NOT_FOUND,
                    java.util.Optional.ofNullable(e.getMessage())));
        }
    }
}
