package tech.jlsol.servernamedcbot.listeners;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import tech.jlsol.servernamedcbot.util.Config;

import javax.annotation.Nonnull;

public class MessageListeners extends ListenerAdapter {
    private String getConfig(String key){
        return Config.readConfig("data", "settings", key);
    }
    //TODO: get message & so on!
    public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
        if(!event.getAuthor().isBot()){
            if(event.getChannel().getName().equals(getConfig("featureRQ-TC"))){
                if(event.getMessage().getContentRaw().toLowerCase().startsWith(getConfig("prefix"))){
                    event.getChannel().sendMessage(":check:").queue();
                }
            }else{
                System.out.println("Message received from " + event.getAuthor().getName());
            }
        }
    }
}
