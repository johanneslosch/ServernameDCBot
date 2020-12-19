package tech.jlsol.servernamedcbot.listeners;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import tech.jlsol.servernamedcbot.util.Config;
import tech.jlsol.servernamedcbot.util.WriteFile;

import javax.annotation.Nonnull;

public class MessageListeners extends ListenerAdapter {
    private String getConfig(String key){
        return Config.readConfig("data", "settings", key);
    }
    private void writeToFile(String content){
        WriteFile.writer("data", "msg", "txt", content);
    }
    public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
        if(!event.getAuthor().isBot()){
            if(event.getChannel().getName().equals(getConfig("featureRQ-TC"))){
                if(event.getMessage().getContentRaw().toLowerCase().startsWith(getConfig("prefix"))){
                    writeToFile(event.getMessage().getContentDisplay().substring(getConfig("prefix").length()));
                }
            }else{
                System.out.println("Message received from " + event.getAuthor().getName());
            }
        }
    }
}
