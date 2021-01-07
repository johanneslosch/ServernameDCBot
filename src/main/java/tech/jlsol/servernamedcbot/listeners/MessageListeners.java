package tech.jlsol.servernamedcbot.listeners;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.json.JSONArray;
import org.json.JSONObject;
import tech.jlsol.servernamedcbot.util.Config;
import tech.jlsol.servernamedcbot.util.Logger;

import javax.annotation.Nonnull;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
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
                    /*try {
                        SQLHandler.MySQLUseDataManager.setFeatureRequest(SQLHandler.MySQLUseDataManager.timeStamp,
                         event.getMessage().getContentRaw().substring(getConfig("prefix").length()),
                         event.getAuthor().getAsTag());
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                        Logger.error(throwables.getMessage());
                    }*///SQL Connection
                    FeatureRequestWriter(event.getMessage().getContentRaw()
                                    .substring(getConfig("prefix").length()),
                            event.getAuthor().getAsTag() + "/" + event.getAuthor().getId());
                }
            }else{
                if(event.getMessage().getContentRaw().toLowerCase().startsWith(getConfig("prefix")+"reset")){
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
                            Logger.msg("reset successful");

                        }
                        else
                        {
                            Config.writeConfig(
                                    "data",
                                    "FeatureRequestHelper",
                                    "ID-FeatureRequest",
                                    "0");
                            Logger.error("Failed to delete the file");
                        }
                }
                if(event.getMessage().getContentRaw().toLowerCase().startsWith(getConfig("prefix")+"showAll")){
                    String[] pathNames;

                    // Creates a new File instance by converting the given pathname string
                    // into an abstract pathname
                    File f = new File("./featureRequest");

                    // Populates the array with names of files and directories
                    pathNames = f.list();
                    // For each pathname in the pathNames array
                    for (String pathname : pathNames) {
                        // Print the names of files and directories
                        System.out.println(pathname);
                        JSONObject jsonObject = new JSONObject();

                        try (FileReader reader = new FileReader(pathname))
                        {
                            event.getChannel().sendMessage((CharSequence) new EmbedBuilder()
                            //.setAuthor(event.getJDA().getUserByTag()
                            .setDescription(jsonObject.getString("request"))
                            .setColor(Color.WHITE)
                            .setTitle("IDEA - " + jsonObject.getInt("ID"))).complete();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
