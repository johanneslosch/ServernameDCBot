package tech.jlsol.servernamedcbot.listeners;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import tech.jlsol.servernamedcbot.util.Config;
import tech.jlsol.servernamedcbot.util.Logger;

import javax.annotation.Nonnull;

import java.io.File;
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
                    }*/
                    FeatureRequestWriter(event.getMessage().getContentRaw()
                                    .substring(getConfig("prefix").length()),
                            event.getAuthor().getAsTag() + "/" + event.getAuthor().getId());
                }
            }else{
                if(event.getMessage().getContentRaw().toLowerCase().startsWith(getConfig("prefix")+"reset")){
                        File file = new File("./data/util/FeatureRequestHelper.prop");
                        if(file.delete())
                        {
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
            }
        }
    }
}
